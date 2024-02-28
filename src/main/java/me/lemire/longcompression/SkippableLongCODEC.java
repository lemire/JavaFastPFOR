/**
 * This is code is released under the
 * Apache License Version 2.0 http://www.apache.org/licenses/.
 *
 * (c) Daniel Lemire, http://lemire.me/en/
 */

package me.lemire.longcompression;

import me.lemire.integercompression.IntWrapper;

/**
 * Interface describing a standard CODEC to compress longs. This is a
 * variation on the LongCODEC interface meant to be used for random access
 * (i.e., given a large array, you can segment it and decode just the subarray you need).
 * 
 * The main difference is that we must specify the number of longs we wish to
 * decode. This information should be stored elsewhere.
 * 
 * This interface was designed by the Terrier team for their search engine.
 * 
 * @author Benoit Lacelle
 * 
 */
public interface SkippableLongCODEC {
    /**
     * Compress data from an array to another array.
     * 
     * Both inpos and outpos are modified to represent how much data was read
     * and written to. If 12 longs (inlength = 12) are compressed to 3 longs, then
     * inpos will be incremented by 12 while outpos will be incremented by 3. We
     * use IntWrapper to pass the values by reference.
     * 
     * @param in
     *            input array
     * @param inpos
     *            where to start reading in the array
     * @param inlength
     *            how many longs to compress
     * @param out
     *            output array
     * @param outpos
     *            where to write in the output array
     */
    public void headlessCompress(long[] in, IntWrapper inpos, int inlength, long[] out,
            IntWrapper outpos);

    /**
     * Uncompress data from an array to another array.
     * 
     * Both inpos and outpos parameters are modified to indicate new positions
     * after read/write.
     * 
     * @param in
     *            array containing data in compressed form
     * @param inpos
     *            where to start reading in the array
     * @param inlength
     *            length of the compressed data (ignored by some schemes)
     * @param out
     *            array where to write the uncompressed output
     * @param outpos
     *            where to start writing the uncompressed output in out
     * @param num
     *            number of longs we want to decode, the actual number of longs decoded can be less
     */
    public void headlessUncompress(long[] in, IntWrapper inpos, int inlength, long[] out,
            IntWrapper outpos, int num);

}
