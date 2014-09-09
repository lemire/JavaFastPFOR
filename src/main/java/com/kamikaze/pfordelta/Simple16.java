package com.kamikaze.pfordelta;

/**
 * This is a version of the  kamikaze PForDelta library that
 * was slightly cleaned up by D. Lemire. It is included in the
 * JavaFastPFOR library for comparison purposes. As the original
 */

/**
 * Implementation of the Simple16 algorithm for sorted integer arrays. The basic
 * ideas are based on papers from
 * 
 * 1. http://www2008.org/papers/pdf/p387-zhangA.pdf
 * 
 * 2. http://www2009.org/proceedings/pdf/p401.pdf
 * 
 * The maximum possible integer value Simple16 can encode is less than 2^28 (this is
 * dertermined by the Simple16 algorithm itself). Therefore, in order to use
 * Simple16, the application must write their own code to encode numbers in the
 * range of [2^28, 2^32). A simple way is just write those numbers as 32-bit
 * integers (that is, no compression for very big numbers).
 */
public class Simple16 {

        private static final int S16_NUMSIZE = 16;
        private static final int S16_BITSSIZE = 28;

        // the possible number of compressed numbers hold in a single 32-bit
        // integer
        private static final int[] S16_NUM = { 28, 21, 21, 21, 14, 9, 8, 7, 6,
                6, 5, 5, 4, 3, 2, 1 };

        // the possible number of bits used to compress one number
        private static final int[][] S16_BITS = {
                { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1,
                        1, 1, 1, 1, 1, 1, 1, 1 },
                { 2, 2, 2, 2, 2, 2, 2, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1,
                        1, 0, 0, 0, 0, 0, 0, 0 },
                { 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 1, 1, 1, 1, 1, 1,
                        1, 0, 0, 0, 0, 0, 0, 0 },
                { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2,
                        2, 0, 0, 0, 0, 0, 0, 0 },
                { 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 0, 0, 0, 0, 0, 0,
                        0, 0, 0, 0, 0, 0, 0, 0 },
                { 4, 3, 3, 3, 3, 3, 3, 3, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
                        0, 0, 0, 0, 0, 0, 0, 0 },
                { 3, 4, 4, 4, 4, 3, 3, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
                        0, 0, 0, 0, 0, 0, 0, 0 },
                { 4, 4, 4, 4, 4, 4, 4, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
                        0, 0, 0, 0, 0, 0, 0, 0 },
                { 5, 5, 5, 5, 4, 4, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
                        0, 0, 0, 0, 0, 0, 0, 0 },
                { 4, 4, 5, 5, 5, 5, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
                        0, 0, 0, 0, 0, 0, 0, 0 },
                { 6, 6, 6, 5, 5, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
                        0, 0, 0, 0, 0, 0, 0, 0 },
                { 5, 5, 6, 6, 6, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
                        0, 0, 0, 0, 0, 0, 0, 0 },
                { 7, 7, 7, 7, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
                        0, 0, 0, 0, 0, 0, 0, 0 },
                { 10, 9, 9, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
                        0, 0, 0, 0, 0, 0, 0, 0 },
                { 14, 14, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
                        0, 0, 0, 0, 0, 0, 0, 0 },
                { 28, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
                        0, 0, 0, 0, 0, 0, 0, 0 } };

        /**
         * Compress an integer array using Simple16
         * 
         * @param out
         *                the compressed output
         * @param outOffset
         *                the offset of the output in the number of integers
         * @param in
         *                the integer input array
         * @param inOffset
         *                the offset of the input in the number of integers
         * @param n
         *                the number of elements to be compressed
         * @param blockSize block size
         * @return the number of compressed integers
         */
        public static final int s16Compress(int[] out, int outOffset, int[] in,
                int inOffset, int n, int blockSize) {
                int numIdx = 0, j = 0, num = 0, bits = 0;
                try {
                        for (numIdx = 0; numIdx < S16_NUMSIZE; numIdx++) {
                                out[outOffset] = numIdx << S16_BITSSIZE;
                                num = (S16_NUM[numIdx] < n) ? S16_NUM[numIdx]
                                        : n;

                                for (j = 0, bits = 0; (j < num)
                                        && in[inOffset + j] < (1 << S16_BITS[numIdx][j]);) {
                                        out[outOffset] |= (in[inOffset + j] << bits);
                                        bits += S16_BITS[numIdx][j];
                                        j++;
                                }

                                if (j == num) {
                                        return num;
                                }
                        }
                } catch (Exception e) {
                        System.out.println("s16Compress: " + "numIdx:" + numIdx
                                + ",j:" + j + ",num:" + num + ",bits: " + bits);
                        e.printStackTrace();
                }

                return -1;
        }

        /**
         * Decompress an integer array using Simple16
         * 
         * @param out
         *                the decompressed output
         * @param outOffset
         *                the offset of the output in the number of integers
         * @param in
         *                the compressed input array
         * @param inOffset
         *                the offset of the input in the number of integers
         * @param n
         *                the number of elements to be compressed
         * @return the number of processed integers
         */
        public static final int s16Decompress(int[] out, int outOffset,
                int[] in, int inOffset, int n) {
                int numIdx, j = 0, bits = 0;
                numIdx = in[inOffset] >>> S16_BITSSIZE;
                int num = S16_NUM[numIdx] < n ? S16_NUM[numIdx] : n;
                for (j = 0, bits = 0; j < num; j++) {
                        out[outOffset + j] = readBitsForS16(in, inOffset, bits,
                                S16_BITS[numIdx][j]);
                        bits += S16_BITS[numIdx][j];
                }
                return num;
        }

        /**
         * Read a certain number of bits of a integer on the input array
         * 
         * @param in
         *                the input array
         * @param inIntOffset
         *                the start offset in ints in the input array
         * @param inWithIntOffset
         *                the start offset within a int in the input array
         * @param bits
         *                the number of bits to be read
         * @return the bits bits of the input
         */
        static private int readBitsForS16(int[] in, final int inIntOffset,
                final int inWithIntOffset, final int bits) {
                final int val = (in[inIntOffset] >>> inWithIntOffset);
                return val & (0xffffffff >>> (32 - bits));
        }
}
