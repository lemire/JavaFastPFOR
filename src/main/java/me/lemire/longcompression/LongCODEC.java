/**
 * This code is released under the
 * Apache License Version 2.0 http://www.apache.org/licenses/.
 *
 * (c) Daniel Lemire, http://lemire.me/en/
 */

package me.lemire.longcompression;

import me.lemire.integercompression.IntWrapper;

/**
 * Interface describing a standard CODEC to compress longs.
 * 
 * @author Benoit Lacelle
 * 
 */
public interface LongCODEC {
        /**
         * Compress data from an array to another array.
         * 
         * Both inpos and outpos are modified to represent how much data was
         * read and written to. If 12 longs (inlength = 12) are compressed to 3
         * longs, then inpos will be incremented by 12 while outpos will be
         * incremented by 3. We use IntWrapper to pass the values by reference.
         * 
         * @param in
         *                input array
         * @param inpos
         *                where to start reading in the array
         * @param inlength
         *                how many longs to compress
         * @param out
         *                output array
         * @param outpos
         *                where to write in the output array
         */
        public void compress(long[] in, IntWrapper inpos, int inlength,
                long[] out, IntWrapper outpos);

        /**
         * Uncompress data from an array to another array.
         * 
         * Both inpos and outpos parameters are modified to indicate new
         * positions after read/write.
         * 
         * @param in
         *                array containing data in compressed form
         * @param inpos
         *                where to start reading in the array
         * @param inlength
         *                length of the compressed data (ignored by some
         *                schemes)
         * @param out
         *                array where to write the uncompressed output
         * @param outpos
         *                where to start writing the uncompressed output in out
         */
        public void uncompress(long[] in, IntWrapper inpos, int inlength,
                long[] out, IntWrapper outpos);

}
