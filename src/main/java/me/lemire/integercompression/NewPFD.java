/**
 * This code is released under the
 * Apache License Version 2.0 http://www.apache.org/licenses/.
 *
 * (c) Daniel Lemire, http://lemire.me/en/
 */

package me.lemire.integercompression;

/**
 * NewPFD/NewPFOR 
 * <p/>
 * Follows:
 * <p/>
 * H. Yan, S. Ding, T. Suel, Inverted index compression and query processing
 * with optimized document ordering, in: WWW �09, 2009, pp. 401�410.
 * <p/>
 * using Simple16 as the secondary coder.
 * 
 * Note that this does not use differential coding: if you are working on 
 * sorted lists, you must compute the deltas separately. (Yes, this is true even
 * though the "D" at the end of the name probably stands for delta.)
 * 
 * For multi-threaded applications, each thread should use its own NewPFD object.
 *
 * @author Daniel Lemire
 */
public final class NewPFD implements IntegerCODEC {
    final int PageSize;
    final static int BlockSize = 128;

    int[] exceptbuffer = new int[2 * BlockSize];
    
    /**
     * Constructor for the NewPFD CODEC.
     */
    public NewPFD() {
        PageSize = 65536;
    }

    @Override
    public void compress(int[] in, IntWrapper inpos, int inlength, int[] out,
                         IntWrapper outpos) {
        inlength = inlength / BlockSize * BlockSize;
        if(inlength == 0) return;
        final int finalinpos = inpos.get() + inlength;
        out[outpos.get()] = inlength;
        outpos.increment();
        while (inpos.get() != finalinpos) {
            int thissize = finalinpos > PageSize + inpos.get() ? PageSize
                    : (finalinpos - inpos.get());
            encodePage(in, inpos, thissize, out, outpos);
        }

    }

    protected static final int[] bits = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11,
            12, 13, 16, 20, 32};
    protected static final int[] invbits = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11,
            12, 13, 14, 14, 14, 15, 15, 15, 15, 16, 16, 16, 16, 16, 16, 16, 16,
            16, 16, 16, 16};

    protected static void getBestBFromData(int[] in, int pos, IntWrapper bestb,
                                        IntWrapper bestexcept) {
        final int mb = Util.maxbits(in, pos, BlockSize);
        int mini = 0;
        if (mini + 28 < bits[invbits[mb]])
            mini = bits[invbits[mb]] - 28; // 28 is the max for exceptions
        int besti = bits.length - 1;
        int exceptcounter = 0;
        for (int i = mini; i < bits.length - 1; ++i) {
            int tmpcounter = 0;
            for (int k = pos; k < BlockSize + pos; ++k)
                if ((in[k] >>> bits[i]) != 0)
                    ++tmpcounter;
            if (tmpcounter * 10 <= BlockSize) {
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
        for (final int finalinpos = tmpinpos + thissize; tmpinpos + BlockSize <= finalinpos; tmpinpos += BlockSize) {
            getBestBFromData(in, tmpinpos, bestb, bestexcept);
            final int tmpbestb = bestb.get();
            final int nbrexcept = bestexcept.get();
            int exceptsize = 0;
            final int remember = tmpoutpos;
            tmpoutpos++;
            if (nbrexcept > 0) {
                for (int i = 0, c = 0; i < BlockSize; ++i) {
                    if ((in[tmpinpos + i] >>> bits[tmpbestb])!=0) {
                        exceptbuffer[c + nbrexcept] = i;
                        exceptbuffer[c] = in[tmpinpos + i] >>> bits[tmpbestb];
                        ++c;
                    }
                }
                exceptsize = S16.compress(exceptbuffer, 0, 2 * nbrexcept, out,
                        tmpoutpos);
                tmpoutpos += exceptsize;
            }
            out[remember] = tmpbestb | (nbrexcept << 8) | (exceptsize << 16);
            for (int k = 0; k < BlockSize; k += 32) {
                BitPacking.fastpack(in, tmpinpos + k, out, tmpoutpos,
                        bits[tmpbestb]);
                tmpoutpos += bits[tmpbestb];
            }
        }
        inpos.set(tmpinpos);
        outpos.set(tmpoutpos);
    }

    @Override
    public void uncompress(int[] in, IntWrapper inpos, int inlength, int[] out,
                           IntWrapper outpos) {
        if(inlength == 0) return;
        int mynvalue = in[inpos.get()];
        inpos.increment();
        final int finalout = outpos.get() + mynvalue;
        while (outpos.get() != finalout) {
            int thissize = finalout > PageSize + outpos.get() ? PageSize
                    : (finalout - outpos.get());
            decodePage(in, inpos, out, outpos, thissize);
        }
    }

    private void decodePage(int[] in, IntWrapper inpos, int[] out,
                            IntWrapper outpos, int thissize) {
        int tmpoutpos = outpos.get();
        int tmpinpos = inpos.get();

        for (int run = 0; run < thissize / BlockSize; ++run, tmpoutpos += BlockSize) {
            final int b = in[tmpinpos] & 0xFF;
            final int cexcept = (in[tmpinpos] >>> 8) & 0xFF;
            final int exceptsize = (in[tmpinpos] >>> 16);
            ++tmpinpos;
            S16.uncompress(in, tmpinpos, exceptsize, exceptbuffer, 0,
                    2 * cexcept);
            tmpinpos += exceptsize;
            for (int k = 0; k < BlockSize; k += 32) {
                BitPacking
                        .fastunpack(in, tmpinpos, out, tmpoutpos + k, bits[b]);
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
    public String toString() {
        return this.getClass().getSimpleName();
    }

}
