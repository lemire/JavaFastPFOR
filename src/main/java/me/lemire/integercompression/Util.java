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
   

	
	// check whether x is small than y as unsigned ints (supported by Java 8 natively);
	protected static final boolean smallerorequalthan(int x, int y) {
		return (x + Integer.MIN_VALUE) <= (y + Integer.MIN_VALUE);
	}
	
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
     * 
     * @param initoffset
     *            initial vallue for the computation of the deltas
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

    protected static int packsize(int num, int b) {
        if (b > 16)
            return num;
        int howmanyfit = 32 / b;
        return (num + howmanyfit - 1) / howmanyfit;
    }

    protected static int pack(int[] outputarray, int arraypos, int[] data, int datapos,
            int num, int b) {
        if (num == 0)
            return arraypos;
        if (b > 16) {
            System.arraycopy(data, datapos, outputarray, arraypos, num);
            return num + arraypos;
        }
        for (int k = 0; k < packsize(num, b); ++k)
            outputarray[k + arraypos] = 0;
        int inwordpointer = 0;
        for (int k = 0; k < num; ++k) {
            outputarray[arraypos] |= (data[k + datapos] << inwordpointer);
            inwordpointer += b;
            final int increment = ((inwordpointer + b - 1) >> 5);
            arraypos += increment;
            inwordpointer &= ~(-increment);
        }
        return arraypos + (inwordpointer > 0 ? 1 : 0);
    }

    protected static int unpack(int[] sourcearray, int arraypos, int[] data, int datapos,
            int num, int b) {
        if (b > 16) {
            System.arraycopy(sourcearray, arraypos, data, 0, num);
            return num + arraypos;
        }
        final int mask = (1 << b) - 1;
        int inwordpointer = 0;
        for (int k = 0; k < num; ++k) {
            data[k + datapos] = ((sourcearray[arraypos] >>> inwordpointer) & mask);
            inwordpointer += b;
            final int increment = ((inwordpointer + b - 1) >> 5);
            arraypos += increment;
            inwordpointer &= ~(-increment);
        }
        return arraypos + (inwordpointer > 0 ? 1 : 0);
    }

    protected static int packsizew(int num, int b) {
        int howmanyfit = 32 / b;
        if (num <= howmanyfit)
            return 1;
        return num;
    }

    protected static int packw(int[] outputarray, int arraypos, int[] data,
            int num, int b) {
        int howmanyfit = 32 / b;
        if (num > howmanyfit) {
            System.arraycopy(data, 0, outputarray, arraypos, num);
            return num + arraypos;
        }
        outputarray[arraypos] = 0;
        int inwordpointer = 0;
        for (int k = 0; k < num; ++k) {
            outputarray[arraypos] |= (data[k] << inwordpointer);
            inwordpointer += b;
        }
        return arraypos + 1;
    }

    protected static int unpackw(int[] sourcearray, int arraypos, int[] data,
            int num, int b) {
        int howmanyfit = 32 / b;
        if (num > howmanyfit) {
            System.arraycopy(sourcearray, arraypos, data, 0, num);
            return num + arraypos;
        }
        final int mask = (1 << b) - 1;
        int val = sourcearray[arraypos];
        for (int k = 0; k < num; ++k) {
            data[k] = (val & mask);
            val >>>= b;
        }
        return arraypos + 1;
    }

    /**
     * return floor(value / factor) * factor
     * 
     * @param value
     *            numerator
     * @param factor
     *            denominator
     * @return greatest multiple of factor no larger than value
     */
    public static int greatestMultiple(int value, int factor) {
        return value - value % factor;
    }
}
