/**
 * This code is released under the
 * Apache License Version 2.0 http://www.apache.org/licenses/.
 *
 * (c) Daniel Lemire, http://lemire.me/en/
 */

package me.lemire.longcompression;

import java.util.Arrays;

/**
 * Bitpacking routines
 * 
 * <p>For details, please see</p>
 * <p>
 * Daniel Lemire and Leonid Boytsov, Decoding billions of integers per second
 * through vectorization Software: Practice &amp; Experience
 * <a href="http://onlinelibrary.wiley.com/doi/10.1002/spe.2203/abstract">http://onlinelibrary.wiley.com/doi/10.1002/spe.2203/abstract</a>
 * <a href="http://arxiv.org/abs/1209.2137">http://arxiv.org/abs/1209.2137</a>
 * </p>
 * 
 * @author Benoit Lacelle
 * 
 */
public final class LongBitPacking {

        /**
         * Pack 64 longs
         * 
         * @param in
         *                source array
         * @param inpos
         *                position in source array
         * @param out
         *                output array
         * @param outpos
         *                position in output array
         * @param bit
         *                number of bits to use per long
         */
        public static void fastpackwithoutmask(final long[] in, final int inpos,
                final long[] out, final int outpos, final int bit) {
                if (bit == 0) {
                    fastpackwithoutmask0(in, inpos, out, outpos);
                } else if (bit == 64) {
                    fastpackwithoutmask64(in, inpos, out, outpos);
                }  else if (bit > 0 && bit < 64) {
                    slowpackwithoutmask(in, inpos, out, outpos, bit);
                } else {
                    throw new IllegalArgumentException("Unsupported bit width: " + bit);
                }
        }

        protected static void fastpackwithoutmask0(final long[] in, int inpos,
                final long[] out, int outpos) {
                // nothing
        }

        protected static void fastpackwithoutmask64(final long[] in, int inpos,
                final long[] out, int outpos) {
                System.arraycopy(in, inpos, out, outpos, 64);
        }

        protected static void slowpackwithoutmask(final long[] in, int inpos,
                final long[] out, int outpos, final int bit) {
                int bucket = 0;
                int shift = 0;
                
                out[outpos + bucket] = 0L;
                for (int i = 0 ; i < 64 ; i++) {
                    if (shift >= 64) {
                        bucket++;
                        out[bucket + outpos] = 0L;
                        shift -= 64;

                        if (shift > 0) {
                            // There is some leftovers from previous input in the next bucket
                            out[outpos + bucket] |= in[inpos + i - 1] >> (bit - shift);
                        }
                    }
                    out[outpos + bucket] |= in[inpos + i] << shift;
                    
                    shift += bit;
                }
        }


        /**
         * Unpack the 64 longs
         * 
         * @param in
         *                source array
         * @param inpos
         *                starting point in the source array
         * @param out
         *                output array
         * @param outpos
         *                starting point in the output array
         * @param bit
         *                how many bits to use per integer
         */
        public static void fastunpack(final long[] in, final int inpos,
                final long[] out, final int outpos, final int bit) {
                if (bit == 0) {
                    fastunpack0(in, inpos, out, outpos);
                } else if (bit == 64) {
                    fastunpack64(in, inpos, out, outpos);
                } else if (bit > 0 && bit < 64) {
                    slowunpack(in, inpos, out, outpos, bit);
                } else {
                    throw new IllegalArgumentException("Unsupported bit width: " + bit);
                }
        }


        protected static void fastunpack0(final long[] in, int inpos,
                final long[] out, int outpos) {
                Arrays.fill(out, outpos, outpos + 64, 0);
        }
        
        protected static void fastunpack64(final long[] in, int inpos,
                final long[] out, int outpos) {
                System.arraycopy(in, inpos, out, outpos, 64);
        }

        protected static void slowunpack(final long[] in, int inpos,
                final long[] out, int outpos, final int bit) {
                int bucket = 0;
                int shift = 0;
                for (int i = 0 ; i < 64 ; i++) {
                    if (shift >= 64) {
                        bucket++;
                        shift -= 64;

                        if (shift > 0) {
                            // There is some leftovers from previous input in the next bucket
                            out[outpos + i - 1] |= (in[inpos + bucket] << (bit - shift) & ((1L << bit) - 1));
                        }
                    }
                    out[outpos + i] = ((in[inpos + bucket] >>> shift) & ((1L << bit) - 1));
                    
                    shift += bit;
                }
        }
}
