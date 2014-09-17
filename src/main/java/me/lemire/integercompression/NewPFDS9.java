/**
 * This code is released under the
 * Apache License Version 2.0 http://www.apache.org/licenses/.
 *
 * (c) Daniel Lemire, http://lemire.me/en/
 */

package me.lemire.integercompression;


/**
 * NewPFD/NewPFOR based on Simple9  by Yan et al.
 * <p>
 * Follows:
 * </p><p>
 * H. Yan, S. Ding, T. Suel, Inverted index compression and query processing
 * with optimized document ordering, in: WWW 09, 2009, pp. 401-410.
 * </p>
 * using Simple9 as the secondary coder.
 * 
 * It encodes integers in blocks of 128 integers. For arrays containing
 * an arbitrary number of integers, you should use it in conjunction
 * with another CODEC: 
 * 
 *  <pre>IntegerCODEC ic = new Composition(new PDFS9(), new VariableByte()).</pre>
 * 
 * Note that this does not use differential coding: if you are working on sorted
 * lists, you must compute the deltas separately.
 * 
 * For multi-threaded applications, each thread should use its own NewPFDS9
 * object.
 * 
 * @author Daniel Lemire
 */
public final class NewPFDS9 implements IntegerCODEC,SkippableIntegerCODEC {
        final static int BLOCK_SIZE = 128;

        int[] exceptbuffer = new int[2 * BLOCK_SIZE];

        /**
         * Constructor for the NewPFDS9 CODEC.
         */
        public NewPFDS9() {
        }

        @Override
        public void headlessCompress(int[] in, IntWrapper inpos, int inlength,
                int[] out, IntWrapper outpos) {
                inlength = Util.greatestMultiple(inlength, BLOCK_SIZE);
                if (inlength == 0)
                        return;
                encodePage(in, inpos, inlength, out, outpos);
        }

        private static final int[] bits = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10,
                11, 12, 13, 16, 20, 32 };
        private static final int[] invbits = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9,
                10, 11, 12, 13, 14, 14, 14, 15, 15, 15, 15, 16, 16, 16, 16, 16,
                16, 16, 16, 16, 16, 16, 16 };

        private static void getBestBFromData(int[] in, int pos,
                IntWrapper bestb, IntWrapper bestexcept) {
                final int mb = Util.maxbits(in, pos, BLOCK_SIZE);
                int mini = 0;
                if (mini + 28 < bits[invbits[mb]])
                        mini = bits[invbits[mb]] - 28; // 28 is the max for
                                                       // exceptions
                int besti = bits.length - 1;
                int exceptcounter = 0;
                for (int i = mini; i < bits.length - 1; ++i) {
                        int tmpcounter = 0;
                        for (int k = pos; k < BLOCK_SIZE + pos; ++k)
                                if ((in[k] >>> bits[i]) != 0)
                                        ++tmpcounter;
                        if (tmpcounter * 10 <= BLOCK_SIZE) {
                                besti = i;
                                exceptcounter = tmpcounter;
                                break;
                        }
                }
                bestb.set(besti);
                bestexcept.set(exceptcounter);
        }

        private void encodePage(int[] in, IntWrapper inpos, int thissize,
                int[] out, IntWrapper outpos) {
                int tmpoutpos = outpos.get();
                int tmpinpos = inpos.get();
                IntWrapper bestb = new IntWrapper();
                IntWrapper bestexcept = new IntWrapper();
                for (final int finalinpos = tmpinpos + thissize; tmpinpos
                        + BLOCK_SIZE <= finalinpos; tmpinpos += BLOCK_SIZE) {
                        getBestBFromData(in, tmpinpos, bestb, bestexcept);
                        final int tmpbestb = bestb.get();
                        final int nbrexcept = bestexcept.get();
                        int exceptsize = 0;
                        final int remember = tmpoutpos;
                        tmpoutpos++;
                        if (nbrexcept > 0) {
                                for (int i = 0, c = 0; i < BLOCK_SIZE; ++i) {
                                        if ((in[tmpinpos + i] >>> bits[tmpbestb]) != 0) {
                                                exceptbuffer[c + nbrexcept] = i;
                                                exceptbuffer[c] = in[tmpinpos
                                                        + i] >>> bits[tmpbestb];
                                                ++c;
                                        }
                                }
                                exceptsize = S9.compress(exceptbuffer, 0,
                                        2 * nbrexcept, out, tmpoutpos);
                                tmpoutpos += exceptsize;
                        }
                        out[remember] = tmpbestb | (nbrexcept << 8)
                                | (exceptsize << 16);
                        for (int k = 0; k < BLOCK_SIZE; k += 32) {
                                BitPacking.fastpack(in, tmpinpos + k, out,
                                        tmpoutpos, bits[tmpbestb]);
                                tmpoutpos += bits[tmpbestb];
                        }
                }
                inpos.set(tmpinpos);
                outpos.set(tmpoutpos);
        }

        @Override
        public void headlessUncompress(int[] in, IntWrapper inpos, int inlength,
                int[] out, IntWrapper outpos, int mynvalue) {
                if (inlength == 0)
                        return;
                mynvalue = Util.greatestMultiple(mynvalue, BLOCK_SIZE);
                decodePage(in, inpos, out, outpos, mynvalue);
        }

        private void decodePage(int[] in, IntWrapper inpos, int[] out,
                IntWrapper outpos, int thissize) {
                int tmpoutpos = outpos.get();
                int tmpinpos = inpos.get();

                for (int run = 0; run < thissize / BLOCK_SIZE; ++run, tmpoutpos += BLOCK_SIZE) {
                        final int b = in[tmpinpos] & 0xFF;
                        final int cexcept = (in[tmpinpos] >>> 8) & 0xFF;
                        final int exceptsize = (in[tmpinpos] >>> 16);
                        ++tmpinpos;
                        S9.uncompress(in, tmpinpos, exceptsize, exceptbuffer,
                                0, 2 * cexcept);
                        tmpinpos += exceptsize;
                        for (int k = 0; k < BLOCK_SIZE; k += 32) {
                                BitPacking.fastunpack(in, tmpinpos, out,
                                        tmpoutpos + k, bits[b]);
                                tmpinpos += bits[b];
                        }
                        for (int k = 0; k < cexcept; ++k) {
                                out[tmpoutpos + exceptbuffer[k + cexcept]] |= (exceptbuffer[k] << bits[b]);
                        }
                }
                outpos.set(tmpoutpos);
                inpos.set(tmpinpos);
        }
        @Override
        public void compress(int[] in, IntWrapper inpos, int inlength, int[] out,
                IntWrapper outpos) {
            inlength = Util.greatestMultiple(inlength, BLOCK_SIZE);
            if (inlength == 0)
                    return;
            out[outpos.get()] = inlength;
            outpos.increment();
            headlessCompress(in, inpos, inlength, out, outpos);        
        }

        @Override
        public void uncompress(int[] in, IntWrapper inpos, int inlength, int[] out,
                IntWrapper outpos) {
            if (inlength == 0)
                return;
            final int outlength = in[inpos.get()];
            inpos.increment();
            headlessUncompress(in, inpos, inlength, out, outpos, outlength);
        }
        @Override
        public String toString() {
                return this.getClass().getSimpleName();
        }

}
