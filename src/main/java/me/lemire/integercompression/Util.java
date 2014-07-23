/**
 * This code is released under the
 * Apache License Version 2.0 http://www.apache.org/licenses/.
 *
 * (c) Daniel Lemire, http://lemire.me/en/
 */
package me.lemire.integercompression;

/**
 * Routine utility functions.
 * 
 * @author Daniel Lemire
 * 
 */
public final class Util {
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
    public static int maxbits(int[] i, int pos, int length) {
        int mask = 0;
        for (int k = pos; k < pos + length; ++k)
            mask |= i[k];
        return bits(mask);
    }

    protected static int maxbits32(int[] i, int pos) {
        int mask = i[pos];
        mask |= i[pos + 1];
        mask |= i[pos + 2];
        mask |= i[pos + 3];
        mask |= i[pos + 4];
        mask |= i[pos + 5];
        mask |= i[pos + 6];
        mask |= i[pos + 7];
        mask |= i[pos + 8];
        mask |= i[pos + 9];
        mask |= i[pos + 10];
        mask |= i[pos + 11];
        mask |= i[pos + 12];
        mask |= i[pos + 13];
        mask |= i[pos + 14];
        mask |= i[pos + 15];
        mask |= i[pos + 16];
        mask |= i[pos + 17];
        mask |= i[pos + 18];
        mask |= i[pos + 19];
        mask |= i[pos + 20];
        mask |= i[pos + 21];
        mask |= i[pos + 22];
        mask |= i[pos + 23];
        mask |= i[pos + 24];
        mask |= i[pos + 25];
        mask |= i[pos + 26];
        mask |= i[pos + 27];
        mask |= i[pos + 28];
        mask |= i[pos + 29];
        mask |= i[pos + 30];
        mask |= i[pos + 31];
        return bits(mask);
    }

    /**
     * Compute the maximum of the integer logarithms (ceil(log(x+1)) of a the
     * successive differences (deltas) of a range of value
     * @param initoffset initial vallue for the computation of the deltas
     * @param i
     *            source array
     * @param pos
     *            starting position
     * @param length
     *            number of integers to consider
     * @return integer logarithm
     */
    public static int maxdiffbits(int initoffset, int[] i, int pos, int length) {
        int mask = 0;
        mask |= (i[pos] - initoffset);
        for (int k = pos + 1; k < pos + length; ++k) {
            mask |= i[k] - i[k - 1];
        }
        return bits(mask);
    }

    /**
     * Compute the integer logarithms (ceil(log(x+1)) of a value
     * 
     * @param i
     *            source value
     * @return integer logarithm
     */
    public static int bits(int i) {
        return 32 - Integer.numberOfLeadingZeros(i);
    }

    /**
     * return floor(value / factor)
     * 
     * @param value numerator
     * @param factor denominator
     * @return result of the division
     */
    public static int floorBy(int value, int factor) {

        return value - value % factor;
    }
}
