/**
 * This code is released under the
 * Apache License Version 2.0 http://www.apache.org/licenses/.
 *
 * (c) Daniel Lemire, http://lemire.me/en/
 */
package me.lemire.integercompression;


/**
 * Scheme  based on a commonly used idea: can be extremely fast.
 * It encodes integers in blocks of 128 integers. For arrays containing
 * an arbitrary number of integers, you should use it in conjunction
 * with another CODEC: 
 * 
 *  <pre>IntegerCODEC ic = 
 *  new Composition(new BinaryPacking(), new VariableByte()).</pre>
 * 
 * Note that this does not use differential coding: if you are working on sorted
 * lists, use IntegratedBinaryPacking instead.
 *
 * <p>
 * For details, please see
 * </p>
 * <p>
 * Daniel Lemire and Leonid Boytsov, Decoding billions of integers per second
 * through vectorization Software: Practice &amp; Experience
 * <a href="http://onlinelibrary.wiley.com/doi/10.1002/spe.2203/abstract">http://onlinelibrary.wiley.com/doi/10.1002/spe.2203/abstract</a>
 * <a href="http://arxiv.org/abs/1209.2137">http://arxiv.org/abs/1209.2137</a>
 * </p>
 * <p>
 * Daniel Lemire, Leonid Boytsov, Nathan Kurz,
 * SIMD Compression and the Intersection of Sorted Integers
 * http://arxiv.org/abs/1401.6399
 * </p>
 * 
 * @author Daniel Lemire
 */
public final class BinaryPacking implements IntegerCODEC, SkippableIntegerCODEC {

        @Override
        public void compress(int[] in, IntWrapper inpos, int inlength,
                int[] out, IntWrapper outpos) {
            inlength = inlength / 128 * 128;
            if (inlength == 0)
                    return;
            out[outpos.get()] = inlength;
            outpos.increment();
            headlessCompress(in, inpos, inlength, out, outpos);
        }

        @Override
        public void headlessCompress(int[] in, IntWrapper inpos, int inlength,
                int[] out, IntWrapper outpos) {
                inlength = inlength / 128 * 128;
                int tmpoutpos = outpos.get();
                for (int s = inpos.get(); s < inpos.get() + inlength; s += 32 * 4) {
                        final int mbits1 = Util.maxbits(in, s, 32);
                        final int mbits2 = Util.maxbits(in, s + 32, 32);
                        final int mbits3 = Util.maxbits(in, s + 2 * 32, 32);
                        final int mbits4 = Util.maxbits(in, s + 3 * 32, 32);
                        out[tmpoutpos++] = (mbits1 << 24) | (mbits2 << 16)
                                | (mbits3 << 8) | (mbits4);
                        BitPacking.fastpackwithoutmask(in, s, out, tmpoutpos,
                                mbits1);
                        tmpoutpos += mbits1;
                        BitPacking.fastpackwithoutmask(in, s + 32, out,
                                tmpoutpos, mbits2);
                        tmpoutpos += mbits2;
                        BitPacking.fastpackwithoutmask(in, s + 2 * 32, out,
                                tmpoutpos, mbits3);
                        tmpoutpos += mbits3;
                        BitPacking.fastpackwithoutmask(in, s + 3 * 32, out,
                                tmpoutpos, mbits4);
                        tmpoutpos += mbits4;
                }
                inpos.add(inlength);
                outpos.set(tmpoutpos);
        }

        @Override
        public void uncompress(int[] in, IntWrapper inpos, int inlength,
                int[] out, IntWrapper outpos) {
                if (inlength == 0)
                        return;
                final int outlength = in[inpos.get()];
                inpos.increment();
                headlessUncompress(in,inpos, inlength,out,outpos,outlength);
        }

        @Override
        public void headlessUncompress(int[] in, IntWrapper inpos, int inlength,
                int[] out, IntWrapper outpos, int num) {
                final int outlength = num / 128 * 128;
                int tmpinpos = inpos.get();
                for (int s = outpos.get(); s < outpos.get() + outlength; s += 32 * 4) {
                        final int mbits1 = (in[tmpinpos] >>> 24);
                        final int mbits2 = (in[tmpinpos] >>> 16) & 0xFF;
                        final int mbits3 = (in[tmpinpos] >>> 8) & 0xFF;
                        final int mbits4 = (in[tmpinpos]) & 0xFF;
                        ++tmpinpos;
                        BitPacking.fastunpack(in, tmpinpos, out, s, mbits1);
                        tmpinpos += mbits1;
                        BitPacking
                                .fastunpack(in, tmpinpos, out, s + 32, mbits2);
                        tmpinpos += mbits2;
                        BitPacking.fastunpack(in, tmpinpos, out, s + 2 * 32,
                                mbits3);
                        tmpinpos += mbits3;
                        BitPacking.fastunpack(in, tmpinpos, out, s + 3 * 32,
                                mbits4);
                        tmpinpos += mbits4;
                }
                outpos.add(outlength);
                inpos.set(tmpinpos);
        }
        @Override
        public String toString() {
                return this.getClass().getSimpleName();
        }
}
