package com.kamikaze.pfordelta;

/**
 * This is a version of the  kamikaze PForDelta library that
 * was slightly cleaned up by D. Lemire. It is included in the
 * JavaFastPFOR library for comparison purposes. As the original
 */

/**
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

import java.nio.IntBuffer;
import java.util.Arrays;

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
 * literature.
 * 
 * This implementation overcomes the problem that Simple16 cannot deal with
 * greater than 2^28 numbers.
 * 
 * This implementation is almost same as PForDelta in the same package, except
 * that it is tuned especially for Lucene-4.0 Codec to achieve the best
 * performance in Lucene-4.0.
 * 
 * @author hao yan, hyan2008@gmail.com
 */
public class LCPForDelta {

        // NOTE: we expect the blockSize is always < (1<<(31-POSSIBLE_B_BITS)).
        // For example, in the current default settings,
        // the blockSize < (1<<(31-5)), that is, < 2^27

        // All possible values of b in the PForDelta algorithm
        private static final int[] POSSIBLE_B = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9,
                10, 11, 12, 13, 16, 20, 28 };

        // POSSIBLE_B.length < (1<<POSSIBLE_B_BITS)
        private static final int POSSIBLE_B_BITS = 5;
        // Max number of bits to store an uncompressed value
        private static final int MAX_BITS = 32;
        // Header records the value of b and the number of exceptions in the
        // block
        private static final int HEADER_NUM = 1;
        // Header size in bits
        private static final int HEADER_SIZE = MAX_BITS * HEADER_NUM;

        private static final int[] MASK = { 0x00000000, 0x00000001, 0x00000003,
                0x00000007, 0x0000000f, 0x0000001f, 0x0000003f, 0x0000007f,
                0x000000ff, 0x000001ff, 0x000003ff, 0x000007ff, 0x00000fff,
                0x00001fff, 0x00003fff, 0x00007fff, 0x0000ffff, 0x0001ffff,
                0x0003ffff, 0x0007ffff, 0x000fffff, 0x001fffff, 0x003fffff,
                0x007fffff, 0x00ffffff, 0x01ffffff, 0x03ffffff, 0x07ffffff,
                0x0fffffff, 0x1fffffff, 0x3fffffff, 0x7fffffff, 0xffffffff };

        private int[] compBuffer; // buffer to hold the compressed data

        protected int[] getCompBuffer() {
                return compBuffer;
        }

        protected void setCompBuffer(int[] buffer) {
                compBuffer = buffer;
        }

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
        public int compress(int[] inBlock, int blockSize) {
                // find the best b that can lead to the smallest overall
                // compressed size
                int currentB = POSSIBLE_B[0];
                int tmpB = currentB;
                boolean hasBigNum = checkBigNumbers(inBlock, blockSize,
                        POSSIBLE_B[POSSIBLE_B.length - 1]);
                if (hasBigNum) {
                        currentB = 4;
                } else {
                        int optSize = estimateCompressedSize(inBlock,
                                blockSize, tmpB);
                        for (int i = 1; i < POSSIBLE_B.length; ++i) {
                                tmpB = POSSIBLE_B[i];
                                int curSize = estimateCompressedSize(inBlock,
                                        blockSize, tmpB);
                                if (curSize < optSize) {
                                        currentB = tmpB;
                                        optSize = curSize;
                                }
                        }
                }

                // compress the block using the above best b
                int compressedSizeInInts = compressOneBlockCore(inBlock,
                        blockSize, currentB);

                return compressedSizeInInts;
        }

        /**
         * The core implementation of compressing a block with blockSize
         * integers using PForDelta with the given parameter b
         * 
         * @param inputBlock
         *                the block to be compressed
         * @param blockSize
         *                the block size
         * @param bits
         *                the the value of the parameter b
         * @return the size of the compressed block (the number of ints)
         */
        public int compressOneBlockCore(int[] inputBlock, int blockSize,
                int bits)  {
                int outputOffset = HEADER_SIZE;
                int expUpperBound = 1 << bits;
                int expNum = 0;
                int maxCompBitSize = HEADER_SIZE + blockSize
                        * (MAX_BITS + MAX_BITS + MAX_BITS) + 32;
                int[] tmpCompBuffer = new int[(maxCompBitSize >>> 5)];

                int[] expPosBuffer = new int[blockSize];
                int[] expHighBitsBuffer = new int[blockSize];

                // compress the b-bit slots
                for (int i = 0; i < blockSize; ++i) {
                        int value = inputBlock[i];
                        if (value < expUpperBound) {
                                writeBits(tmpCompBuffer, value, outputOffset,
                                        bits);
                        } else // exp
                        {
                                // store the lower bits-bits of the exception
                                writeBits(tmpCompBuffer, value & MASK[bits],
                                        outputOffset, bits);
                                // write the position of exception
                                expPosBuffer[expNum] = i;
                                // write the higher 32-bits bits of the
                                // exception
                                expHighBitsBuffer[expNum] = (value >>> bits)
                                        & MASK[32 - bits];
                                expNum++;
                        }
                        outputOffset += bits;
                }

                tmpCompBuffer[0] = ((bits & MASK[POSSIBLE_B_BITS]) << (31 - POSSIBLE_B_BITS))
                        | (expNum & MASK[31 - POSSIBLE_B_BITS]);

                // compress exceptions
                if (expNum > 0) {
                        int compressedBitSize;

                        compressedBitSize = compressBlockByS16(tmpCompBuffer,
                                outputOffset, expPosBuffer, expNum, blockSize,
                                inputBlock);
                        outputOffset += compressedBitSize;

                        compressedBitSize = compressBlockByS16(tmpCompBuffer,
                                outputOffset, expHighBitsBuffer, expNum,
                                blockSize, inputBlock);
                        outputOffset += compressedBitSize;
                }

                // discard the redundant parts in the tmpCompressedBlock
                int compressedSizeInInts = (outputOffset + 31) >>> 5;

                compBuffer = tmpCompBuffer;
                return compressedSizeInInts;
        }

        protected int compressOneBlockCore2(int[] inputBlock, int blockSize,
                int bits) throws IllegalArgumentException {
                int outputOffset = HEADER_SIZE;
                int expUpperBound = 1 << bits;
                int expNum = 0;
                int maxCompBitSize = HEADER_SIZE + blockSize
                        * (MAX_BITS + MAX_BITS + MAX_BITS) + 32;
                int[] tmpCompBuffer = new int[(maxCompBitSize >>> 5)];

                int[] expPosBuffer = new int[blockSize];
                int[] expHighBitsBuffer = new int[blockSize];

                // compress the b-bit slots
                for (int i = 0; i < blockSize; ++i) {
                        int value = inputBlock[i];
                        if (value < expUpperBound) {
                                writeBits(tmpCompBuffer, value, outputOffset,
                                        bits);
                        } else // exp
                        {
                                // store the lower bits-bits of the exception
                                writeBits(tmpCompBuffer, value & MASK[bits],
                                        outputOffset, bits);
                                // write the position of exception
                                expPosBuffer[expNum] = i;
                                // write the higher 32-bits bits of the
                                // exception
                                expHighBitsBuffer[expNum] = (value >>> bits)
                                        & MASK[32 - bits];
                                expNum++;
                        }
                        outputOffset += bits;
                }

                tmpCompBuffer[0] = ((bits & MASK[POSSIBLE_B_BITS]) << (31 - POSSIBLE_B_BITS))
                        | (expNum & MASK[31 - POSSIBLE_B_BITS]);

                // compress exceptions
                if (expNum > 0) {
                        int compressedBitSize;

                        int[] expBuffer = new int[expNum * 2];
                        System.arraycopy(expPosBuffer, 0, expBuffer, 0, expNum);
                        System.arraycopy(expHighBitsBuffer, 0, expBuffer,
                                expNum, expNum);

                        compressedBitSize = compressBlockByS16(tmpCompBuffer,
                                outputOffset, expBuffer, expNum * 2, blockSize,
                                inputBlock);
                        outputOffset += compressedBitSize;
                }

                // discard the redundant parts in the tmpCompressedBlock
                int compressedSizeInInts = (outputOffset + 31) >>> 5;

                compBuffer = tmpCompBuffer;
                return compressedSizeInInts;
        }

        /**
         * Decompress one block using PForDelta
         * 
         * @param decompBlock
         *                the block that was decompressed
         * @param inBlock
         *                the block to be decompressed
         * @param blockSize
         *                the number of elements in the decompressed block
         */
        public static void decompressOneBlock(int[] decompBlock, int[] inBlock,
                int blockSize) {
                int expNum = inBlock[0] & MASK[31 - POSSIBLE_B_BITS];
                int bits = (inBlock[0] >>> (31 - POSSIBLE_B_BITS)) & (0x1f);

                int[] expPosBuffer = new int[blockSize];
                int[] expHighBitsBuffer = new int[blockSize];

                // decompress the b-bit slots
                int offset = HEADER_SIZE;
                int compressedBits = 0;
                if (bits == 0) {
                        Arrays.fill(decompBlock, 0);
                } else {
                        compressedBits = decompressBBitSlots(decompBlock,
                                inBlock, blockSize, bits);
                        // compressedBits =
                        // decompressBBitSlotsWithHardCodes(decompBlock,
                        // inBlock, blockSize, bits);
                }
                offset += compressedBits;

                // decompress exceptions
                if (expNum > 0) {
                        compressedBits = decompressBlockByS16(expPosBuffer,
                                inBlock, offset, expNum);
                        offset += compressedBits;
                        compressedBits = decompressBlockByS16(
                                expHighBitsBuffer, inBlock, offset, expNum);
                        offset += compressedBits;

                        for (int i = 0; i < expNum; i++) {
                                int curExpPos = expPosBuffer[i];
                                int curHighBits = expHighBitsBuffer[i];
                                decompBlock[curExpPos] = (decompBlock[curExpPos] & MASK[bits])
                                        | ((curHighBits & MASK[32 - bits]) << bits);
                        }
                }
        }

        protected static void decompressOneBlockWithSize(int[] decompBlock,
                int[] inBlock, int blockSize, int[] expPosBuffer,
                int[] expHighBitsBuffer, int inBlockLen) {
                int expNum = inBlock[0] & MASK[31 - POSSIBLE_B_BITS];
                int bits = (inBlock[0] >>> (31 - POSSIBLE_B_BITS)) & (0x1f);

                // decompress the b-bit slots
                int offset = HEADER_SIZE;
                int compressedBits = 0;
                if (bits == 0) {
                        Arrays.fill(decompBlock, 0, inBlockLen, 0);
                } else {
                        // compressedBits =
                        // decompressBBitSlotsWithHardCodes(decompBlock,
                        // inBlock, blockSize, bits);
                        compressedBits = decompressBBitSlots(decompBlock,
                                inBlock, blockSize, bits);
                }
                offset += compressedBits;

                // decompress exceptions
                if (expNum > 0) {
                        compressedBits = decompressBlockByS16(expPosBuffer,
                                inBlock, offset, expNum);
                        offset += compressedBits;
                        compressedBits = decompressBlockByS16(
                                expHighBitsBuffer, inBlock, offset, expNum);
                        offset += compressedBits;

                        for (int i = 0; i < expNum; i++) {
                                int curExpPos = expPosBuffer[i];
                                int curHighBits = expHighBitsBuffer[i];
                                decompBlock[curExpPos] = (decompBlock[curExpPos] & MASK[bits])
                                        | ((curHighBits & MASK[32 - bits]) << bits);
                        }
                }
        }

        protected static void decompressOneBlockWithSizeWithIntBuffer(
                final int[] decompBlock, final IntBuffer inBlock,
                final int blockSize, final int[] expPosBuffer,
                final int[] expHighBitsBuffer, final int inBlockLen) {
                final int flag = inBlock.get();
                final int expNum = flag & MASK[31 - POSSIBLE_B_BITS];
                final int bits = (flag >>> (31 - POSSIBLE_B_BITS)) & (0x1f);
                if (bits == 0) {
                        Arrays.fill(decompBlock, 0, inBlockLen, 0);
                } else {
                        PForDeltaUnpack128WIthIntBuffer.unpack(decompBlock,
                                inBlock, bits);
                }

                if (expNum > 0) {
                        // decompress expPos
                        int num, outOffset = 0, numLeft;
                        for (numLeft = expNum; numLeft > 0; numLeft -= num) {
                                num = Simple16WithHardCodes
                                        .s16DecompressWithIntBufferWithHardCodes(
                                                expPosBuffer, outOffset,
                                                inBlock.get(), numLeft);
                                outOffset += num;
                        }

                        // decompress expHighBits and decompBlock at the same
                        // time
                        for (outOffset = 0, numLeft = expNum; numLeft > 0; numLeft -= num) {
                                num = Simple16WithHardCodes
                                        .s16DecompressWithIntBufferIntegrated2(
                                                decompBlock, outOffset,
                                                inBlock.get(), numLeft,
                                                expPosBuffer, bits);
                                outOffset += num;
                        }
                }
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
        public static int estimateCompressedSize(int[] inputBlock,
                int blockSize, int bits)  {
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
        public static boolean checkBigNumbers(int[] inputBlock, int blockSize,
                int bits)  {
                int maxNoExp = (1 << bits) - 1;
                for (int i = 0; i < blockSize; ++i) {
                        if (inputBlock[i] > maxNoExp)
                                return true;
                }
                return false;
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

        protected static int decompressBBitSlotsWithHardCodes(
                final int[] outDecompSlots, final int[] inCompBlock,
                final int blockSize, final int bits) {
                int compressedBitSize = 0;
                PForDeltaUnpack128.unpack(outDecompSlots, inCompBlock, bits);
                compressedBitSize = bits * blockSize;
                return compressedBitSize;
        }

        protected static int decompressBBitSlotsWithHardCodesWithIntBuffer(
                final int[] outDecompSlots, final IntBuffer inCompBlock,
                final int blockSize, final int bits) {
                PForDeltaUnpack128WIthIntBuffer.unpack(outDecompSlots,
                        inCompBlock, bits);
                return bits * blockSize;
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
                int outStartOffsetInBits, int[] inBlock, int blockSize,
                int oriBlockSize, int[] oriInputBlock) {
                int outOffset = (outStartOffsetInBits + 31) >>> 5;
                int num, inOffset = 0, numLeft;
                for (numLeft = blockSize; numLeft > 0; numLeft -= num) {
                        num = Simple16WithHardCodes.s16Compress(outCompBlock,
                                outOffset, inBlock, inOffset, numLeft,
                                blockSize, oriBlockSize, oriInputBlock);
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

        protected static void decompressBlockByS16WithIntBuffer(
                final int[] outDecompBlock, final IntBuffer inCompBlock,
                final int blockSize) {
                int num, outOffset = 0, numLeft;
                for (numLeft = blockSize; numLeft > 0; numLeft -= num) {
                        num = Simple16WithHardCodes.s16DecompressWithIntBuffer(
                                outDecompBlock, outOffset, inCompBlock.get(),
                                numLeft);
                        outOffset += num;
                }
        }

        protected static void decompressBlockByS16WithIntBufferIntegrated(
                final int[] outDecompBlock, final IntBuffer inCompBlock,
                final int blockSize, int[] expPosBuffer, int oribits) {
                int num, outOffset = 0, numLeft;
                for (numLeft = blockSize; numLeft > 0; numLeft -= num) {
                        num = Simple16WithHardCodes
                                .s16DecompressWithIntBufferIntegrated(
                                        outDecompBlock, outOffset,
                                        inCompBlock.get(), numLeft,
                                        expPosBuffer, oribits);
                        outOffset += num;
                }
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
         *                must be greater than  0. When bits ==0, the calling functions will
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

        protected static final int readBitsWithBuffer(int[] in,
                final int inOffset, final int bits) {
                final int index = inOffset >>> 5;
                final int skip = inOffset & 0x1f;
                int val = in[index] >>> skip;
                if (32 - skip < bits) {
                        val |= (in[index + 1] << (32 - skip));
                }
                return val & (0xffffffff >>> (32 - bits));
        }

}
