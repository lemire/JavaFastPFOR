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
 * 
 * Compared to Simple16, Simple16WithHardCodes will decompress each compressed
 * integer using hardwired codes, resulting in faster decompression speed.
 * However, it will sacrifice with slightly larger index size.
 * 
 * Author: Hao Yan, hyan2008@gmail.com
 */
public class Simple16WithHardCodes {

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
         * @param oriBlockSize  ori block size
         * @param oriInputBlock ori input block 
         * @return the number of compressed integers
         */
        public static final int s16Compress(int[] out, int outOffset, int[] in,
                int inOffset, int n, int blockSize, int oriBlockSize,
                int[] oriInputBlock) {
                int numIdx, j, num, bits;
                for (numIdx = 0; numIdx < S16_NUMSIZE; numIdx++) {
                        out[outOffset] = numIdx << S16_BITSSIZE;
                        // num = (S16_NUM[numIdx] < n) ? S16_NUM[numIdx] : n;

                        if (S16_NUM[numIdx] > n)
                                continue;
                        num = S16_NUM[numIdx];

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

                return -1;
        }


        protected static final int s16CompressBackup(int[] out, int outOffset,
                int[] in, int inOffset, int n, int blockSize, int oriBlockSize,
                int[] oriInputBlock) {
                int numIdx, j, num, bits;
                for (numIdx = 0; numIdx < S16_NUMSIZE; numIdx++) {
                        out[outOffset] = numIdx << S16_BITSSIZE;
                        num = (S16_NUM[numIdx] < n) ? S16_NUM[numIdx] : n;

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
        protected static final int s16Decompress(int[] out, int outOffset,
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

        protected static final int s16DecompressWithIntBufferBackup(
                final int[] out, int outOffset, final int value, final int n) {
                int j = 0, shift;
                final int numIdx = value >>> S16_BITSSIZE;
                final int num = S16_NUM[numIdx] < n ? S16_NUM[numIdx] : n;
                int s16Bits;
                for (shift = 0; j < num; ++j) {
                        s16Bits = S16_BITS[numIdx][j];
                        out[outOffset++] = (value >>> shift)
                                & (0xffffffff >>> (32 - s16Bits));
                        shift += s16Bits;
                }
                return num;
        }

        protected static final int s16DecompressWithIntBuffer(final int[] out,
                int outOffset, final int value, final int n) {
                int j = 0, shift;
                final int numIdx = value >>> S16_BITSSIZE;

                final int num = S16_NUM[numIdx];
                int s16Bits;
                for (shift = 0; j < num; ++j) {
                        s16Bits = S16_BITS[numIdx][j];
                        out[outOffset++] = (value >>> shift)
                                & (0xffffffff >>> (32 - s16Bits));
                        shift += s16Bits;
                }
                return num;
        }

        protected static final int s16DecompressWithIntBufferWithHardCodes(
                final int[] out, int outOffset, final int value, final int n) {
                final int numIdx = value >>> S16_BITSSIZE;
                return s16DecompressOneNumberWithHardCodes(out, outOffset,
                        value, numIdx);
        }

        protected static final int s16DecompressWithIntBufferIntegrated(
                final int[] out, int outOffset, final int value, final int n,
                int[] expPos, int oribits) {
                int j = 0, shift = 0;
                final int numIdx = value >>> S16_BITSSIZE;

                final int num = S16_NUM[numIdx];
                int s16Bits;
                for (; j < num; ++j) {
                        s16Bits = S16_BITS[numIdx][j];
                        out[expPos[outOffset + j]] |= (((value >>> shift) & (0xffffffff >>> (32 - s16Bits))) << oribits);
                        shift += s16Bits;
                }
                return num;
        }

        protected static final int s16DecompressWithIntBufferIntegrated2(
                final int[] out, int outOffset, final int value, final int n,
                int[] expPos, int oribits) {
                final int numIdx = value >>> S16_BITSSIZE;
                return s16DecompressOneNumberWithHardCodesIntegrated(out,
                        outOffset, value, numIdx, oribits, expPos);
        }

        protected static final int s16DecompressWithIntBufferIntegratedBackup(
                final int[] out, int outOffset, final int value, final int n,
                int[] expPos, int oribits) {
                int j = 0, shift = 0;
                final int numIdx = value >>> S16_BITSSIZE;
                final int num = S16_NUM[numIdx] < n ? S16_NUM[numIdx] : n;
                int s16Bits;
                for (; j < num; ++j, ++outOffset) {
                        s16Bits = S16_BITS[numIdx][j];
                        out[expPos[outOffset]] |= (((value >>> shift) & (0xffffffff >>> (32 - s16Bits))) << oribits);
                        shift += s16Bits;
                }
                return num;
        }

        protected static int s16DecompressOneNumberWithHardCodes(int[] out,
                int outOffset, int value, int numIdx) {
                switch (numIdx) {
                case 0: {
                        out[outOffset] = value & 0x00000001;
                        out[outOffset + 1] = (value >>> 1) & 0x00000001;
                        out[outOffset + 2] = (value >>> 2) & 0x00000001;
                        out[outOffset + 3] = (value >>> 3) & 0x00000001;
                        out[outOffset + 4] = (value >>> 4) & 0x00000001;
                        out[outOffset + 5] = (value >>> 5) & 0x00000001;
                        out[outOffset + 6] = (value >>> 6) & 0x00000001;
                        out[outOffset + 7] = (value >>> 7) & 0x00000001;
                        out[outOffset + 8] = (value >>> 8) & 0x00000001;
                        out[outOffset + 9] = (value >>> 9) & 0x00000001;
                        out[outOffset + 10] = (value >>> 10) & 0x00000001;
                        out[outOffset + 11] = (value >>> 11) & 0x00000001;
                        out[outOffset + 12] = (value >>> 12) & 0x00000001;
                        out[outOffset + 13] = (value >>> 13) & 0x00000001;
                        out[outOffset + 14] = (value >>> 14) & 0x00000001;
                        out[outOffset + 15] = (value >>> 15) & 0x00000001;
                        out[outOffset + 16] = (value >>> 16) & 0x00000001;
                        out[outOffset + 17] = (value >>> 17) & 0x00000001;
                        out[outOffset + 18] = (value >>> 18) & 0x00000001;
                        out[outOffset + 19] = (value >>> 19) & 0x00000001;
                        out[outOffset + 20] = (value >>> 20) & 0x00000001;
                        out[outOffset + 21] = (value >>> 21) & 0x00000001;
                        out[outOffset + 22] = (value >>> 22) & 0x00000001;
                        out[outOffset + 23] = (value >>> 23) & 0x00000001;
                        out[outOffset + 24] = (value >>> 24) & 0x00000001;
                        out[outOffset + 25] = (value >>> 25) & 0x00000001;
                        out[outOffset + 26] = (value >>> 26) & 0x00000001;
                        out[outOffset + 27] = (value >>> 27) & 0x00000001;
                        return 28;
                }
                case 1: {
                        out[outOffset] = value & 0x00000003;
                        out[outOffset + 1] = (value >>> 2) & 0x00000003;
                        out[outOffset + 2] = (value >>> 4) & 0x00000003;
                        out[outOffset + 3] = (value >>> 6) & 0x00000003;
                        out[outOffset + 4] = (value >>> 8) & 0x00000003;
                        out[outOffset + 5] = (value >>> 10) & 0x00000003;
                        out[outOffset + 6] = (value >>> 12) & 0x00000003;
                        out[outOffset + 7] = (value >>> 14) & 0x00000001;
                        out[outOffset + 8] = (value >>> 15) & 0x00000001;
                        out[outOffset + 9] = (value >>> 16) & 0x00000001;
                        out[outOffset + 10] = (value >>> 17) & 0x00000001;
                        out[outOffset + 11] = (value >>> 18) & 0x00000001;
                        out[outOffset + 12] = (value >>> 19) & 0x00000001;
                        out[outOffset + 13] = (value >>> 20) & 0x00000001;
                        out[outOffset + 14] = (value >>> 21) & 0x00000001;
                        out[outOffset + 15] = (value >>> 22) & 0x00000001;
                        out[outOffset + 16] = (value >>> 23) & 0x00000001;
                        out[outOffset + 17] = (value >>> 24) & 0x00000001;
                        out[outOffset + 18] = (value >>> 25) & 0x00000001;
                        out[outOffset + 19] = (value >>> 26) & 0x00000001;
                        out[outOffset + 20] = (value >>> 27) & 0x00000001;
                        return 21;
                }
                case 2: {
                        out[outOffset] = value & 0x00000001;
                        out[outOffset + 1] = (value >>> 1) & 0x00000001;
                        out[outOffset + 2] = (value >>> 2) & 0x00000001;
                        out[outOffset + 3] = (value >>> 3) & 0x00000001;
                        out[outOffset + 4] = (value >>> 4) & 0x00000001;
                        out[outOffset + 5] = (value >>> 5) & 0x00000001;
                        out[outOffset + 6] = (value >>> 6) & 0x00000001;
                        out[outOffset + 7] = (value >>> 7) & 0x00000003;
                        out[outOffset + 8] = (value >>> 9) & 0x00000003;
                        out[outOffset + 9] = (value >>> 11) & 0x00000003;
                        out[outOffset + 10] = (value >>> 13) & 0x00000003;
                        out[outOffset + 11] = (value >>> 15) & 0x00000003;
                        out[outOffset + 12] = (value >>> 17) & 0x00000003;
                        out[outOffset + 13] = (value >>> 19) & 0x00000003;
                        out[outOffset + 14] = (value >>> 21) & 0x00000001;
                        out[outOffset + 15] = (value >>> 22) & 0x00000001;
                        out[outOffset + 16] = (value >>> 23) & 0x00000001;
                        out[outOffset + 17] = (value >>> 24) & 0x00000001;
                        out[outOffset + 18] = (value >>> 25) & 0x00000001;
                        out[outOffset + 19] = (value >>> 26) & 0x00000001;
                        out[outOffset + 20] = (value >>> 27) & 0x00000001;
                        return 21;
                }
                case 3: {
                        out[outOffset] = value & 0x00000001;
                        out[outOffset + 1] = (value >>> 1) & 0x00000001;
                        out[outOffset + 2] = (value >>> 2) & 0x00000001;
                        out[outOffset + 3] = (value >>> 3) & 0x00000001;
                        out[outOffset + 4] = (value >>> 4) & 0x00000001;
                        out[outOffset + 5] = (value >>> 5) & 0x00000001;
                        out[outOffset + 6] = (value >>> 6) & 0x00000001;
                        out[outOffset + 7] = (value >>> 7) & 0x00000001;
                        out[outOffset + 8] = (value >>> 8) & 0x00000001;
                        out[outOffset + 9] = (value >>> 9) & 0x00000001;
                        out[outOffset + 10] = (value >>> 10) & 0x00000001;
                        out[outOffset + 11] = (value >>> 11) & 0x00000001;
                        out[outOffset + 12] = (value >>> 12) & 0x00000001;
                        out[outOffset + 13] = (value >>> 13) & 0x00000001;
                        out[outOffset + 14] = (value >>> 14) & 0x00000003;
                        out[outOffset + 15] = (value >>> 16) & 0x00000003;
                        out[outOffset + 16] = (value >>> 18) & 0x00000003;
                        out[outOffset + 17] = (value >>> 20) & 0x00000003;
                        out[outOffset + 18] = (value >>> 22) & 0x00000003;
                        out[outOffset + 19] = (value >>> 24) & 0x00000003;
                        out[outOffset + 20] = (value >>> 26) & 0x00000003;
                        return 21;
                }
                case 4: {
                        out[outOffset] = value & 0x00000003;
                        out[outOffset + 1] = (value >>> 2) & 0x00000003;
                        out[outOffset + 2] = (value >>> 4) & 0x00000003;
                        out[outOffset + 3] = (value >>> 6) & 0x00000003;
                        out[outOffset + 4] = (value >>> 8) & 0x00000003;
                        out[outOffset + 5] = (value >>> 10) & 0x00000003;
                        out[outOffset + 6] = (value >>> 12) & 0x00000003;
                        out[outOffset + 7] = (value >>> 14) & 0x00000003;
                        out[outOffset + 8] = (value >>> 16) & 0x00000003;
                        out[outOffset + 9] = (value >>> 18) & 0x00000003;
                        out[outOffset + 10] = (value >>> 20) & 0x00000003;
                        out[outOffset + 11] = (value >>> 22) & 0x00000003;
                        out[outOffset + 12] = (value >>> 24) & 0x00000003;
                        out[outOffset + 13] = (value >>> 26) & 0x00000003;
                        return 14;
                }
                case 5: {
                        out[outOffset] = value & 0x0000000f;
                        out[outOffset + 1] = (value >>> 4) & 0x00000007;
                        out[outOffset + 2] = (value >>> 7) & 0x00000007;
                        out[outOffset + 3] = (value >>> 10) & 0x00000007;
                        out[outOffset + 4] = (value >>> 13) & 0x00000007;
                        out[outOffset + 5] = (value >>> 16) & 0x00000007;
                        out[outOffset + 6] = (value >>> 19) & 0x00000007;
                        out[outOffset + 7] = (value >>> 22) & 0x00000007;
                        out[outOffset + 8] = (value >>> 25) & 0x00000007;
                        return 9;
                }
                case 6: {
                        out[outOffset] = value & 0x00000007;
                        out[outOffset + 1] = (value >>> 3) & 0x0000000f;
                        out[outOffset + 2] = (value >>> 7) & 0x0000000f;
                        out[outOffset + 3] = (value >>> 11) & 0x0000000f;
                        out[outOffset + 4] = (value >>> 15) & 0x0000000f;
                        out[outOffset + 5] = (value >>> 19) & 0x00000007;
                        out[outOffset + 6] = (value >>> 22) & 0x00000007;
                        out[outOffset + 7] = (value >>> 25) & 0x00000007;
                        return 8;
                }
                case 7: {
                        out[outOffset] = value & 0x0000000f;
                        out[outOffset + 1] = (value >>> 4) & 0x0000000f;
                        out[outOffset + 2] = (value >>> 8) & 0x0000000f;
                        out[outOffset + 3] = (value >>> 12) & 0x0000000f;
                        out[outOffset + 4] = (value >>> 16) & 0x0000000f;
                        out[outOffset + 5] = (value >>> 20) & 0x0000000f;
                        out[outOffset + 6] = (value >>> 24) & 0x0000000f;
                        return 7;
                }
                case 8: {
                        out[outOffset] = value & 0x0000001f;
                        out[outOffset + 1] = (value >>> 5) & 0x0000001f;
                        out[outOffset + 2] = (value >>> 10) & 0x0000001f;
                        out[outOffset + 3] = (value >>> 15) & 0x0000001f;
                        out[outOffset + 4] = (value >>> 20) & 0x0000000f;
                        out[outOffset + 5] = (value >>> 24) & 0x0000000f;
                        return 6;
                }
                case 9: {
                        out[outOffset] = value & 0x0000000f;
                        out[outOffset + 1] = (value >>> 4) & 0x0000000f;
                        out[outOffset + 2] = (value >>> 8) & 0x0000001f;
                        out[outOffset + 3] = (value >>> 13) & 0x0000001f;
                        out[outOffset + 4] = (value >>> 18) & 0x0000001f;
                        out[outOffset + 5] = (value >>> 23) & 0x0000001f;
                        return 6;
                }
                case 10: {
                        out[outOffset] = value & 0x0000003f;
                        out[outOffset + 1] = (value >>> 6) & 0x0000003f;
                        out[outOffset + 2] = (value >>> 12) & 0x0000003f;
                        out[outOffset + 3] = (value >>> 18) & 0x0000001f;
                        out[outOffset + 4] = (value >>> 23) & 0x0000001f;
                        return 5;
                }
                case 11: {
                        out[outOffset] = value & 0x0000001f;
                        out[outOffset + 1] = (value >>> 5) & 0x0000001f;
                        out[outOffset + 2] = (value >>> 10) & 0x0000003f;
                        out[outOffset + 3] = (value >>> 16) & 0x0000003f;
                        out[outOffset + 4] = (value >>> 22) & 0x0000003f;
                        return 5;
                }
                case 12: {
                        out[outOffset] = value & 0x0000007f;
                        out[outOffset + 1] = (value >>> 7) & 0x0000007f;
                        out[outOffset + 2] = (value >>> 14) & 0x0000007f;
                        out[outOffset + 3] = (value >>> 21) & 0x0000007f;
                        return 4;
                }
                case 13: {
                        out[outOffset] = value & 0x000003ff;
                        out[outOffset + 1] = (value >>> 10) & 0x000001ff;
                        out[outOffset + 2] = (value >>> 19) & 0x000001ff;
                        return 3;
                }
                case 14: {
                        out[outOffset] = value & 0x00003fff;
                        out[outOffset + 1] = (value >>> 14) & 0x00003fff;
                        return 2;
                }
                case 15: {
                        out[outOffset] = value & 0x0fffffff;
                        return 1;
                }
                default:
                        return -1;
                }
        }

        protected static int s16DecompressOneNumberWithHardCodesIntegrated(
                int[] out, int outOffset, int value, int numIdx, int oribits,
                int[] expPos) {
                switch (numIdx) {
                case 0: {
                        out[expPos[outOffset]] |= ((value & 0x00000001) << oribits);
                        out[expPos[outOffset + 1]] |= (((value >>> 1) & 0x00000001) << oribits);
                        out[expPos[outOffset + 2]] |= (((value >>> 2) & 0x00000001) << oribits);
                        out[expPos[outOffset + 3]] |= (((value >>> 3) & 0x00000001) << oribits);
                        out[expPos[outOffset + 4]] |= (((value >>> 4) & 0x00000001) << oribits);
                        out[expPos[outOffset + 5]] |= (((value >>> 5) & 0x00000001) << oribits);
                        out[expPos[outOffset + 6]] |= (((value >>> 6) & 0x00000001) << oribits);
                        out[expPos[outOffset + 7]] |= (((value >>> 7) & 0x00000001) << oribits);
                        out[expPos[outOffset + 8]] |= (((value >>> 8) & 0x00000001) << oribits);
                        out[expPos[outOffset + 9]] |= (((value >>> 9) & 0x00000001) << oribits);
                        out[expPos[outOffset + 10]] |= (((value >>> 10) & 0x00000001) << oribits);
                        out[expPos[outOffset + 11]] |= (((value >>> 11) & 0x00000001) << oribits);
                        out[expPos[outOffset + 12]] |= (((value >>> 12) & 0x00000001) << oribits);
                        out[expPos[outOffset + 13]] |= (((value >>> 13) & 0x00000001) << oribits);
                        out[expPos[outOffset + 14]] |= (((value >>> 14) & 0x00000001) << oribits);
                        out[expPos[outOffset + 15]] |= (((value >>> 15) & 0x00000001) << oribits);
                        out[expPos[outOffset + 16]] |= (((value >>> 16) & 0x00000001) << oribits);
                        out[expPos[outOffset + 17]] |= (((value >>> 17) & 0x00000001) << oribits);
                        out[expPos[outOffset + 18]] |= (((value >>> 18) & 0x00000001) << oribits);
                        out[expPos[outOffset + 19]] |= (((value >>> 19) & 0x00000001) << oribits);
                        out[expPos[outOffset + 20]] |= (((value >>> 20) & 0x00000001) << oribits);
                        out[expPos[outOffset + 21]] |= (((value >>> 21) & 0x00000001) << oribits);
                        out[expPos[outOffset + 22]] |= (((value >>> 22) & 0x00000001) << oribits);
                        out[expPos[outOffset + 23]] |= (((value >>> 23) & 0x00000001) << oribits);
                        out[expPos[outOffset + 24]] |= (((value >>> 24) & 0x00000001) << oribits);
                        out[expPos[outOffset + 25]] |= (((value >>> 25) & 0x00000001) << oribits);
                        out[expPos[outOffset + 26]] |= (((value >>> 26) & 0x00000001) << oribits);
                        out[expPos[outOffset + 27]] |= (((value >>> 27) & 0x00000001) << oribits);
                        return 28;
                }
                case 1: {
                        out[expPos[outOffset]] |= ((value & 0x00000003) << oribits);
                        out[expPos[outOffset + 1]] |= (((value >>> 2) & 0x00000003) << oribits);
                        out[expPos[outOffset + 2]] |= (((value >>> 4) & 0x00000003) << oribits);
                        out[expPos[outOffset + 3]] |= (((value >>> 6) & 0x00000003) << oribits);
                        out[expPos[outOffset + 4]] |= (((value >>> 8) & 0x00000003) << oribits);
                        out[expPos[outOffset + 5]] |= (((value >>> 10) & 0x00000003) << oribits);
                        out[expPos[outOffset + 6]] |= (((value >>> 12) & 0x00000003) << oribits);
                        out[expPos[outOffset + 7]] |= (((value >>> 14) & 0x00000001) << oribits);
                        out[expPos[outOffset + 8]] |= (((value >>> 15) & 0x00000001) << oribits);
                        out[expPos[outOffset + 9]] |= (((value >>> 16) & 0x00000001) << oribits);
                        out[expPos[outOffset + 10]] |= (((value >>> 17) & 0x00000001) << oribits);
                        out[expPos[outOffset + 11]] |= (((value >>> 18) & 0x00000001) << oribits);
                        out[expPos[outOffset + 12]] |= (((value >>> 19) & 0x00000001) << oribits);
                        out[expPos[outOffset + 13]] |= (((value >>> 20) & 0x00000001) << oribits);
                        out[expPos[outOffset + 14]] |= (((value >>> 21) & 0x00000001) << oribits);
                        out[expPos[outOffset + 15]] |= (((value >>> 22) & 0x00000001) << oribits);
                        out[expPos[outOffset + 16]] |= (((value >>> 23) & 0x00000001) << oribits);
                        out[expPos[outOffset + 17]] |= (((value >>> 24) & 0x00000001) << oribits);
                        out[expPos[outOffset + 18]] |= (((value >>> 25) & 0x00000001) << oribits);
                        out[expPos[outOffset + 19]] |= (((value >>> 26) & 0x00000001) << oribits);
                        out[expPos[outOffset + 20]] |= (((value >>> 27) & 0x00000001) << oribits);
                        return 21;
                }
                case 2: {
                        out[expPos[outOffset]] |= ((value & 0x00000001) << oribits);
                        out[expPos[outOffset + 1]] |= (((value >>> 1) & 0x00000001) << oribits);
                        out[expPos[outOffset + 2]] |= (((value >>> 2) & 0x00000001) << oribits);
                        out[expPos[outOffset + 3]] |= (((value >>> 3) & 0x00000001) << oribits);
                        out[expPos[outOffset + 4]] |= (((value >>> 4) & 0x00000001) << oribits);
                        out[expPos[outOffset + 5]] |= (((value >>> 5) & 0x00000001) << oribits);
                        out[expPos[outOffset + 6]] |= (((value >>> 6) & 0x00000001) << oribits);
                        out[expPos[outOffset + 7]] |= (((value >>> 7) & 0x00000003) << oribits);
                        out[expPos[outOffset + 8]] |= (((value >>> 9) & 0x00000003) << oribits);
                        out[expPos[outOffset + 9]] |= (((value >>> 11) & 0x00000003) << oribits);
                        out[expPos[outOffset + 10]] |= (((value >>> 13) & 0x00000003) << oribits);
                        out[expPos[outOffset + 11]] |= (((value >>> 15) & 0x00000003) << oribits);
                        out[expPos[outOffset + 12]] |= (((value >>> 17) & 0x00000003) << oribits);
                        out[expPos[outOffset + 13]] |= (((value >>> 19) & 0x00000003) << oribits);
                        out[expPos[outOffset + 14]] |= (((value >>> 21) & 0x00000001) << oribits);
                        out[expPos[outOffset + 15]] |= (((value >>> 22) & 0x00000001) << oribits);
                        out[expPos[outOffset + 16]] |= (((value >>> 23) & 0x00000001) << oribits);
                        out[expPos[outOffset + 17]] |= (((value >>> 24) & 0x00000001) << oribits);
                        out[expPos[outOffset + 18]] |= (((value >>> 25) & 0x00000001) << oribits);
                        out[expPos[outOffset + 19]] |= (((value >>> 26) & 0x00000001) << oribits);
                        out[expPos[outOffset + 20]] |= (((value >>> 27) & 0x00000001) << oribits);
                        return 21;
                }
                case 3: {
                        out[expPos[outOffset]] |= ((value & 0x00000001) << oribits);
                        out[expPos[outOffset + 1]] |= (((value >>> 1) & 0x00000001) << oribits);
                        out[expPos[outOffset + 2]] |= (((value >>> 2) & 0x00000001) << oribits);
                        out[expPos[outOffset + 3]] |= (((value >>> 3) & 0x00000001) << oribits);
                        out[expPos[outOffset + 4]] |= (((value >>> 4) & 0x00000001) << oribits);
                        out[expPos[outOffset + 5]] |= (((value >>> 5) & 0x00000001) << oribits);
                        out[expPos[outOffset + 6]] |= (((value >>> 6) & 0x00000001) << oribits);
                        out[expPos[outOffset + 7]] |= (((value >>> 7) & 0x00000001) << oribits);
                        out[expPos[outOffset + 8]] |= (((value >>> 8) & 0x00000001) << oribits);
                        out[expPos[outOffset + 9]] |= (((value >>> 9) & 0x00000001) << oribits);
                        out[expPos[outOffset + 10]] |= (((value >>> 10) & 0x00000001) << oribits);
                        out[expPos[outOffset + 11]] |= (((value >>> 11) & 0x00000001) << oribits);
                        out[expPos[outOffset + 12]] |= (((value >>> 12) & 0x00000001) << oribits);
                        out[expPos[outOffset + 13]] |= (((value >>> 13) & 0x00000001) << oribits);
                        out[expPos[outOffset + 14]] |= (((value >>> 14) & 0x00000003) << oribits);
                        out[expPos[outOffset + 15]] |= (((value >>> 16) & 0x00000003) << oribits);
                        out[expPos[outOffset + 16]] |= (((value >>> 18) & 0x00000003) << oribits);
                        out[expPos[outOffset + 17]] |= (((value >>> 20) & 0x00000003) << oribits);
                        out[expPos[outOffset + 18]] |= (((value >>> 22) & 0x00000003) << oribits);
                        out[expPos[outOffset + 19]] |= (((value >>> 24) & 0x00000003) << oribits);
                        out[expPos[outOffset + 20]] |= (((value >>> 26) & 0x00000003) << oribits);
                        return 21;
                }
                case 4: {
                        out[expPos[outOffset]] |= ((value & 0x00000003) << oribits);
                        out[expPos[outOffset + 1]] |= (((value >>> 2) & 0x00000003) << oribits);
                        out[expPos[outOffset + 2]] |= (((value >>> 4) & 0x00000003) << oribits);
                        out[expPos[outOffset + 3]] |= (((value >>> 6) & 0x00000003) << oribits);
                        out[expPos[outOffset + 4]] |= (((value >>> 8) & 0x00000003) << oribits);
                        out[expPos[outOffset + 5]] |= (((value >>> 10) & 0x00000003) << oribits);
                        out[expPos[outOffset + 6]] |= (((value >>> 12) & 0x00000003) << oribits);
                        out[expPos[outOffset + 7]] |= (((value >>> 14) & 0x00000003) << oribits);
                        out[expPos[outOffset + 8]] |= (((value >>> 16) & 0x00000003) << oribits);
                        out[expPos[outOffset + 9]] |= (((value >>> 18) & 0x00000003) << oribits);
                        out[expPos[outOffset + 10]] |= (((value >>> 20) & 0x00000003) << oribits);
                        out[expPos[outOffset + 11]] |= (((value >>> 22) & 0x00000003) << oribits);
                        out[expPos[outOffset + 12]] |= (((value >>> 24) & 0x00000003) << oribits);
                        out[expPos[outOffset + 13]] |= (((value >>> 26) & 0x00000003) << oribits);
                        return 14;
                }
                case 5: {
                        out[expPos[outOffset]] |= ((value & 0x0000000f) << oribits);
                        out[expPos[outOffset + 1]] |= (((value >>> 4) & 0x00000007) << oribits);
                        out[expPos[outOffset + 2]] |= (((value >>> 7) & 0x00000007) << oribits);
                        out[expPos[outOffset + 3]] |= (((value >>> 10) & 0x00000007) << oribits);
                        out[expPos[outOffset + 4]] |= (((value >>> 13) & 0x00000007) << oribits);
                        out[expPos[outOffset + 5]] |= (((value >>> 16) & 0x00000007) << oribits);
                        out[expPos[outOffset + 6]] |= (((value >>> 19) & 0x00000007) << oribits);
                        out[expPos[outOffset + 7]] |= (((value >>> 22) & 0x00000007) << oribits);
                        out[expPos[outOffset + 8]] |= (((value >>> 25) & 0x00000007) << oribits);
                        return 9;
                }
                case 6: {
                        out[expPos[outOffset]] |= ((value & 0x00000007) << oribits);
                        out[expPos[outOffset + 1]] |= (((value >>> 3) & 0x0000000f) << oribits);
                        out[expPos[outOffset + 2]] |= (((value >>> 7) & 0x0000000f) << oribits);
                        out[expPos[outOffset + 3]] |= (((value >>> 11) & 0x0000000f) << oribits);
                        out[expPos[outOffset + 4]] |= (((value >>> 15) & 0x0000000f) << oribits);
                        out[expPos[outOffset + 5]] |= (((value >>> 19) & 0x00000007) << oribits);
                        out[expPos[outOffset + 6]] |= (((value >>> 22) & 0x00000007) << oribits);
                        out[expPos[outOffset + 7]] |= (((value >>> 25) & 0x00000007) << oribits);
                        return 8;
                }
                case 7: {
                        out[expPos[outOffset]] |= ((value & 0x0000000f) << oribits);
                        out[expPos[outOffset + 1]] |= (((value >>> 4) & 0x0000000f) << oribits);
                        out[expPos[outOffset + 2]] |= (((value >>> 8) & 0x0000000f) << oribits);
                        out[expPos[outOffset + 3]] |= (((value >>> 12) & 0x0000000f) << oribits);
                        out[expPos[outOffset + 4]] |= (((value >>> 16) & 0x0000000f) << oribits);
                        out[expPos[outOffset + 5]] |= (((value >>> 20) & 0x0000000f) << oribits);
                        out[expPos[outOffset + 6]] |= (((value >>> 24) & 0x0000000f) << oribits);
                        return 7;
                }
                case 8: {
                        out[expPos[outOffset]] |= ((value & 0x0000001f) << oribits);
                        out[expPos[outOffset + 1]] |= (((value >>> 5) & 0x0000001f) << oribits);
                        out[expPos[outOffset + 2]] |= (((value >>> 10) & 0x0000001f) << oribits);
                        out[expPos[outOffset + 3]] |= (((value >>> 15) & 0x0000001f) << oribits);
                        out[expPos[outOffset + 4]] |= (((value >>> 20) & 0x0000000f) << oribits);
                        out[expPos[outOffset + 5]] |= (((value >>> 24) & 0x0000000f) << oribits);
                        return 6;
                }
                case 9: {
                        out[expPos[outOffset]] |= ((value & 0x0000000f) << oribits);
                        out[expPos[outOffset + 1]] |= (((value >>> 4) & 0x0000000f) << oribits);
                        out[expPos[outOffset + 2]] |= (((value >>> 8) & 0x0000001f) << oribits);
                        out[expPos[outOffset + 3]] |= (((value >>> 13) & 0x0000001f) << oribits);
                        out[expPos[outOffset + 4]] |= (((value >>> 18) & 0x0000001f) << oribits);
                        out[expPos[outOffset + 5]] |= (((value >>> 23) & 0x0000001f) << oribits);
                        return 6;
                }
                case 10: {
                        out[expPos[outOffset]] |= ((value & 0x0000003f) << oribits);
                        out[expPos[outOffset + 1]] |= (((value >>> 6) & 0x0000003f) << oribits);
                        out[expPos[outOffset + 2]] |= (((value >>> 12) & 0x0000003f) << oribits);
                        out[expPos[outOffset + 3]] |= (((value >>> 18) & 0x0000001f) << oribits);
                        out[expPos[outOffset + 4]] |= (((value >>> 23) & 0x0000001f) << oribits);
                        return 5;
                }
                case 11: {
                        out[expPos[outOffset]] |= ((value & 0x0000001f) << oribits);
                        out[expPos[outOffset + 1]] |= (((value >>> 5) & 0x0000001f) << oribits);
                        out[expPos[outOffset + 2]] |= (((value >>> 10) & 0x0000003f) << oribits);
                        out[expPos[outOffset + 3]] |= (((value >>> 16) & 0x0000003f) << oribits);
                        out[expPos[outOffset + 4]] |= (((value >>> 22) & 0x0000003f) << oribits);
                        return 5;
                }
                case 12: {
                        out[expPos[outOffset]] |= ((value & 0x0000007f) << oribits);
                        out[expPos[outOffset + 1]] |= (((value >>> 7) & 0x0000007f) << oribits);
                        out[expPos[outOffset + 2]] |= (((value >>> 14) & 0x0000007f) << oribits);
                        out[expPos[outOffset + 3]] |= (((value >>> 21) & 0x0000007f) << oribits);
                        return 4;
                }
                case 13: {
                        out[expPos[outOffset]] |= ((value & 0x000003ff) << oribits);
                        out[expPos[outOffset + 1]] |= (((value >>> 10) & 0x000001ff) << oribits);
                        out[expPos[outOffset + 2]] |= (((value >>> 19) & 0x000001ff) << oribits);
                        return 3;
                }
                case 14: {
                        out[expPos[outOffset]] |= ((value & 0x00003fff) << oribits);
                        out[expPos[outOffset + 1]] |= (((value >>> 14) & 0x00003fff) << oribits);
                        return 2;
                }
                case 15: {
                        out[expPos[outOffset]] |= ((value & 0x0fffffff) << oribits);
                        return 1;
                }
                default:
                        return -1;
                }
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
