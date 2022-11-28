/**
 * This code is released under the
 * Apache License Version 2.0 http://www.apache.org/licenses/.
 *
 * (c) Daniel Lemire, http://lemire.me/en/
 */

package me.lemire.longcompression;

/**
 * These are unofficial helpers related to long compression
 * 
 * @author Benoit Lacelle
 *
 */
@Deprecated
public class LongUtil {
    
    /**
     * Compute the maximum of the integer logarithms (ceil(log(x+1)) of a range
     * of value
     * 
     * @param i
     *            source array
     * @param pos
     *            starting position
     * @param length
     *            number of integers to consider
     * @return integer logarithm
     */
    public static int maxbits(long[] i, int pos, int length) {
        long mask = 0;
        for (int k = pos; k < pos + length; ++k)
            mask |= i[k];
        return bits(mask);
    }

    /**
     * Compute the integer logarithms (ceil(log(x+1)) of a value
     * 
     * @param i
     *            source value
     * @return integer logarithm
     */
    public static int bits(long i) {
        return 64 - Long.numberOfLeadingZeros(i);
    }
    
    protected static String longToBinaryWithLeading(long l) {
        return String.format("%64s", Long.toBinaryString(l)).replace(' ', '0');
    }
}
