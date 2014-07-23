package com.kamikaze.pfordelta;

import java.util.Arrays;

/**
 * This is a version of the  kamikaze PForDelta library that
 * was slightly cleaned up by D. Lemire. It is included in the
 * JavaFastPFOR library for comparison purposes. As the original
 */

/**
 * Implementation of the optimized PForDelta algorithm for sorted integer
 * arrays. The basic ideas are based on
 * 
 * 1. Original algorithm from
 * http://homepages.cwi.nl/~heman/downloads/msthesis.pdf
 * 
 * 2. Optimization and variation from
 * http://www2008.org/papers/pdf/p387-zhangA.pdf
 * 
 * 3. Further optimization http://www2009.org/proceedings/pdf/p401.pdf
 * 
 * As a part of the PForDelta implementation, Simple16 is used to compress
 * exceptions. The original Simple16 algorithm can also be found in the above
 * literatures.
 * 
 * This implementation overcomes the problem that Simple16 cannot deal with
 * more than 2^28 numbers.
 * 
 * Author: hao yan hyan2008@gmail.com
 */

public class PForDelta {

        // NOTE: we expect the blockSize is always < (1<<(31-POSSIBLE_B_BITS)).
        // For example, in the current default settings,
        // the blockSize < (1<<(31-5)), that is, < 2^27, the commonly used block
        // size is 128 or 256.

        // All possible values of b in the PForDelta algorithm
        private static final int[] POSSIBLE_B = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9,
                10, 11, 12, 13, 16, 20, 28 };

        // Max number of bits to store an uncompressed value
        private static final int MAX_BITS = 32;
        // Header records the value of b and the number of exceptions in the
        // block
        private static final int HEADER_NUM = 2;
        // Header size in bits
        private static final int HEADER_SIZE = MAX_BITS * HEADER_NUM;

        private static final int[] MASK = { 0x00000000, 0x00000001, 0x00000003,
                0x00000007, 0x0000000f, 0x0000001f, 0x0000003f, 0x0000007f,
                0x000000ff, 0x000001ff, 0x000003ff, 0x000007ff, 0x00000fff,
                0x00001fff, 0x00003fff, 0x00007fff, 0x0000ffff, 0x0001ffff,
                0x0003ffff, 0x0007ffff, 0x000fffff, 0x001fffff, 0x003fffff,
                0x007fffff, 0x00ffffff, 0x01ffffff, 0x03ffffff, 0x07ffffff,
                0x0fffffff, 0x1fffffff, 0x3fffffff, 0x7fffffff, 0xffffffff };

        /**
         * Compress one block of blockSize integers using PForDelta with the
         * optimal parameter b
         * 
         * @param inBlock
         *                the block to be compressed
         * @param blockSize
         *                the block size
         * @return the compressed block
         */
        public static int[] compressOneBlockOpt(final int[] inBlock,
                int blockSize) {
                // find the best b that may lead to the smallest overall
                // compressed size
                int currentB = POSSIBLE_B[0];
                int[] outBlock = null;
                int tmpB = currentB;
                // deal with the large exception cases
                boolean hasBigNum = checkBigNumbers(inBlock,
                        POSSIBLE_B[POSSIBLE_B.length - 1], blockSize);
                if (hasBigNum) {
                        currentB = 4;
                        System.out.println("has big num and the currentB is: "
                                + currentB);
                } else {
                        int optSize = estimateCompressedSize(inBlock, tmpB,
                                blockSize);
                        for (int i = 1; i < POSSIBLE_B.length; ++i) {
                                tmpB = POSSIBLE_B[i];
                                int curSize = estimateCompressedSize(inBlock,
                                        tmpB, blockSize);
                                if (curSize < optSize) {
                                        currentB = tmpB;
                                        optSize = curSize;
                                }
                        }
                }

                // compress the block using the above best b
                outBlock = compressOneBlock(inBlock, currentB, blockSize);

                return outBlock;
        }

        /**
         * Decompress one block using PForDelta
         * 
         * @param outBlock
         *                the block that was decompressed
         * @param inBlock
         *                the block to be decompressed
         * @param blockSize
         *                the number of elements in the decompressed block
         * @return the compressed size in bits
         */
        public static int decompressOneBlock(int[] outBlock, int[] inBlock,
                int blockSize) {
                int[] expAux = new int[blockSize * 2];

                int expNum = inBlock[0] & 0x3ff;
                int bits = (inBlock[0] >>> 10) & (0x1f);

                // decompress the b-bit slots
                int offset = HEADER_SIZE;
                int compressedBits = 0;
                if (bits == 0) {
                        Arrays.fill(outBlock, 0);
                } else {
                        compressedBits = decompressBBitSlots(outBlock, inBlock,
                                blockSize, bits);
                        // Note that blocksize must be ==128 in order to use
                        // decompressBBitSlotsWithHardCodes
                        // compressedBits =
                        // decompressBBitSlotsWithHardCodes(outBlock, inBlock,
                        // blockSize, bits);
                }
                offset += compressedBits;

                // decompress exceptions
                if (expNum > 0) {
                        compressedBits = decompressBlockByS16(expAux, inBlock,
                                offset, expNum * 2);
                        offset += compressedBits;

                        for (int i = 0; i < expNum; i++) {
                                int curExpPos = expAux[i];
                                int curHighBits = expAux[i + expNum];
                                outBlock[curExpPos] = (outBlock[curExpPos] & MASK[bits])
                                        | ((curHighBits & MASK[32 - bits]) << bits);
                        }
                }
                return offset;
        }

        /**
         * Estimate the compressed size in ints of a block
         * 
         * @param inputBlock
         *                the block to be compressed
         * @param bits
         *                the value of the parameter b
         * @param blockSize
         *                the block size
         * @return the compressed size in ints
         */
        public static int estimateCompressedSize(int[] inputBlock, int bits,
                int blockSize)  {
                int maxNoExp = (1 << bits) - 1;
                // Size of the header and the bits-bit slots
                int outputOffset = HEADER_SIZE + bits * blockSize;
                int expNum = 0;

                for (int i = 0; i < blockSize; ++i) {
                        if (inputBlock[i] > maxNoExp) {
                                expNum++;
                        }
                }
                outputOffset += (expNum << 5);

                return outputOffset;
        }

        /**
         * Check if the block contains big numbers that is greater than ((1&lt;&lt;
         * bits)-1)
         * 
         * @param inputBlock
         *                the block to be compressed
         * @param bits
         *                the numbers of bits to decide whether a number is a
         *                big number
         * @param blockSize
         *                the block size
         * @return true if there is any big numbers in the block
         */
        public static boolean checkBigNumbers(int[] inputBlock, int bits,
                int blockSize) {
                int maxNoExp = (1 << bits) - 1;
                for (int i = 0; i < blockSize; ++i) {
                        if (inputBlock[i] > maxNoExp)
                                return true;
                }
                return false;
        }

        /**
         * The core implementation of compressing a block with blockSize
         * integers using PForDelta with the given parameter b
         * 
         * @param inputBlock
         *                the block to be compressed
         * @param bits
         *                the the value of the parameter b
         * @param blockSize
         *                the block size
         * @return the compressed block
         */
        public static int[] compressOneBlock(int[] inputBlock, int bits,
                int blockSize)  {

                int[] expAux = new int[blockSize * 2];

                int maxCompBitSize = HEADER_SIZE + blockSize
                        * (MAX_BITS + MAX_BITS + MAX_BITS) + 32;
                int[] tmpCompressedBlock = new int[(maxCompBitSize >>> 5)];

                int outputOffset = HEADER_SIZE;
                int expUpperBound = 1 << bits;
                int expNum = 0;

                for (int elem : inputBlock) {
                        if (elem >= expUpperBound) {
                                expNum++;
                        }
                }

                int expIndex = 0;
                // compress the b-bit slots
                for (int i = 0; i < blockSize; ++i) {
                        if (inputBlock[i] < expUpperBound) {
                                writeBits(tmpCompressedBlock, inputBlock[i],
                                        outputOffset, bits);
                        } else // exp
                        {
                                // store the lower bits-bits of the exception
                                writeBits(tmpCompressedBlock, inputBlock[i]
                                        & MASK[bits], outputOffset, bits);
                                // write the position of exception
                                expAux[expIndex] = i;
                                // write the higher 32-bits bits of the
                                // exception
                                expAux[expIndex + expNum] = (inputBlock[i] >>> bits)
                                        & MASK[32 - bits];
                                expIndex++;
                        }
                        outputOffset += bits;
                }

                // the first int in the compressed block stores the value of b
                // and the number of exceptions
                // tmpCompressedBlock[0] = ((bits & MASK[POSSIBLE_B_BITS]) <<
                // (31-POSSIBLE_B_BITS)) | (expNum & MASK[31-POSSIBLE_B_BITS]);
                tmpCompressedBlock[0] = ((bits & MASK[10]) << 10)
                        | (expNum & 0x3ff);
                tmpCompressedBlock[1] = inputBlock[blockSize - 1];

                // compress exceptions
                if (expNum > 0) {
                        int compressedBitSize = compressBlockByS16(
                                tmpCompressedBlock, outputOffset, expAux,
                                expNum * 2);
                        outputOffset += compressedBitSize;
                }

                // discard the redundant parts in the tmpCompressedBlock
                int compressedSizeInInts = (outputOffset + 31) >>> 5;
                int[] compBlock;
                compBlock = new int[compressedSizeInInts];
                System.arraycopy(tmpCompressedBlock, 0, compBlock, 0,
                        compressedSizeInInts);

                return compBlock;
        }

        /**
         * Decompress b-bit slots
         * 
         * @param outDecompSlots
         *                decompressed block which is the output
         * @param inCompBlock
         *                the compressed block which is the input
         * @param blockSize
         *                the block size
         * @param bits
         *                the value of the parameter b
         * @return the compressed size in bits of the data that has been
         *         decompressed
         */
        public static int decompressBBitSlots(int[] outDecompSlots,
                int[] inCompBlock, int blockSize, int bits) {
                int compressedBitSize = 0;
                int offset = HEADER_SIZE;
                for (int i = 0; i < blockSize; i++) {
                        outDecompSlots[i] = readBits(inCompBlock, offset, bits);
                        offset += bits;
                }
                compressedBitSize = bits * blockSize;

                return compressedBitSize;
        }

        /**
         * Compress a block of blockSize integers using Simple16 algorithm
         * 
         * @param outCompBlock
         *                the compressed block which is the output
         * @param outStartOffsetInBits
         *                the start offset in bits of the compressed block
         * @param inBlock
         *                the block to be compressed
         * @param blockSize
         *                the block size
         * @return the compressed size in bits
         */
        private static int compressBlockByS16(int[] outCompBlock,
                int outStartOffsetInBits, int[] inBlock, int blockSize) {
                int outOffset = (outStartOffsetInBits + 31) >>> 5;
                int num, inOffset = 0, numLeft;
                for (numLeft = blockSize; numLeft > 0; numLeft -= num) {
                        num = Simple16.s16Compress(outCompBlock, outOffset,
                                inBlock, inOffset, numLeft, blockSize);
                        outOffset++;
                        inOffset += num;
                }
                int compressedBitSize = (outOffset << 5) - outStartOffsetInBits;
                return compressedBitSize;
        }

        /**
         * Decompress a block of blockSize integers using Simple16 algorithm
         * 
         * @param outDecompBlock
         *                the decompressed block which is the output
         * @param inCompBlock
         *                the compressed block which is the input
         * @param blockSize
         *                the block size
         * @param inStartOffsetInBits
         *                the start offset in bits of the compressed block
         * @return the compressed size in bits of the data that has been
         *         decompressed
         */
        public static int decompressBlockByS16(int[] outDecompBlock,
                int[] inCompBlock, int inStartOffsetInBits, int blockSize) {
                int inOffset = (inStartOffsetInBits + 31) >>> 5;
                int num, outOffset = 0, numLeft;
                for (numLeft = blockSize; numLeft > 0; numLeft -= num) {
                        num = Simple16.s16Decompress(outDecompBlock, outOffset,
                                inCompBlock, inOffset, numLeft);
                        outOffset += num;
                        inOffset++;
                }
                int compressedBitSize = (inOffset << 5) - inStartOffsetInBits;
                return compressedBitSize;
        }

        /**
         * Write a certain number of bits of an integer into an integer array
         * starting from the given start offset
         * 
         * @param out
         *                the output array
         * @param val
         *                the integer to be written
         * @param outOffset
         *                the start offset in bits in the output array
         * @param bits
         *                the number of bits to be written (bits greater or equal to 0)
         */
        public static final void writeBits(int[] out, int val, int outOffset,
                int bits) {
                if (bits == 0)
                        return;
                final int index = outOffset >>> 5;
                final int skip = outOffset & 0x1f;
                val &= (0xffffffff >>> (32 - bits));
                out[index] |= (val << skip);
                if (32 - skip < bits) {
                        out[index + 1] |= (val >>> (32 - skip));
                }
        }

        /**
         * Decompress the b-bit slots using hardcoded unpack methods
         * 
         * @param decompressedSlots
         *                the decompressed output
         * @param compBlock
         *                the compressed input block
         * @param blockSize
         *                the block size which is 256 by default
         * @param bits
         *                the value of b
         * @return the processed data size (the number of bits in the compressed
         *         form)
         */
        static int decompressBBitSlotsWithHardCodes(int[] decompressedSlots,
                int[] compBlock, int blockSize, int bits) {
                int compressedBitSize = 0;
                PForDeltaUnpack128.unpack(decompressedSlots, compBlock, bits);
                compressedBitSize = bits * blockSize;

                return compressedBitSize;
        }

        /**
         * Read a certain number of bits of an integer into an integer array
         * starting from the given start offset
         * 
         * @param in
         *                the input array
         * @param inOffset
         *                the start offset in bits in the input array
         * @param bits
         *                the number of bits to be read, unlike writeBits(),
         *                readBits() does not deal with bits==0 and thus bits
         *                must be greater than 0. When bits ==0, the calling functions will
         *                just skip the entire bits-bit slots without decoding
         *                them
         * @return the bits bits of the input
         */
        public static final int readBits(int[] in, final int inOffset,
                final int bits) {
                final int index = inOffset >>> 5;
                final int skip = inOffset & 0x1f;
                int val = in[index] >>> skip;
                if (32 - skip < bits) {
                        val |= (in[index + 1] << (32 - skip));
                }
                return val & (0xffffffff >>> (32 - bits));
        }

}
