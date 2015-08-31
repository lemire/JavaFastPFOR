/**
 * This is code is released under the
 * Apache License Version 2.0 http://www.apache.org/licenses/.
 *
 * (c) Daniel Lemire, http://lemire.me/en/
 */

package me.lemire.integercompression.differential;

import me.lemire.integercompression.IntWrapper;


/**
 * Interface describing a standard CODEC to compress integers. This is a
 * variation on the IntegerCODEC interface meant to be used for random access
 * and with integrated differential coding
 * (i.e., given a large array, you can segment it and decode just the subarray you need).
 * 
 * The main differences are that we must specify the number of integers we wish to
 * decode as well as the initial value (for differential coding). This information 
 * might be stored elsewhere.
 * 
 * 
 * @author Daniel Lemire
 * 
 */
public interface SkippableIntegratedIntegerCODEC {
    /**
     * Compress data from an array to another array.
     * 
     * Both inpos and outpos are modified to represent how much data was read
     * and written to if 12 ints (inlength = 12) are compressed to 3 ints, then
     * inpos will be incremented by 12 while outpos will be incremented by 3 we
     * use IntWrapper to pass the values by reference.
     * 
     * @param in
     *            input array
     * @param inpos
     *            location in the input array
     * @param inlength
     *            how many integers to compress
     * @param out
     *            output array
     * @param outpos
     *            where to write in the output array
     * @param initvalue initial value for the purpose of differential coding, the value is automatically updated 
     */
    public void headlessCompress(int[] in, IntWrapper inpos, int inlength, int[] out,
            IntWrapper outpos, IntWrapper initvalue);

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
     *            array where to write the compressed output
     * @param outpos
     *            where to write the compressed output in out
     * @param num
     *            number of integers we want to decode, the actual number of integers decoded can be less
     * @param initvalue initial value for the purpose of differential coding, the value is automatically updated 
     */
    public void headlessUncompress(int[] in, IntWrapper inpos, int inlength, int[] out,
            IntWrapper outpos, int num, IntWrapper initvalue);

}
