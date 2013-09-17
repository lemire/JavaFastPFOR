/**
 * This code is released under the
 * Apache License Version 2.0 http://www.apache.org/licenses/.
 */
package me.lemire.integercompression;

import org.junit.Test;
import static org.junit.Assert.*;

public final class XorBinaryPackingTest
{
    @Test
    public void packAndUnpack() {
        int[] data = new int[] {
             0,  1,  2,  3,  4,  5,  6,  7,  8,  9, 10, 11, 12, 13, 14, 15,
            16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31,
        };
        checkPack(data, 6, 0);
    }

    public void checkPack(int[] data, int validBits, int context) {
        int[] work = new int[32];

        int[] packBuf = new int[validBits];
        int packRetval = XorBinaryPacking.xorPack(data, 0, packBuf, 0,
                validBits, context, work);
        assertEquals(validBits, packRetval);

        int[] unpackBuf = new int[32];
        int unpackRetval = XorBinaryPacking.xorUnpack(packBuf, 0, unpackBuf, 0,
                validBits, context, work);
        assertEquals(validBits, unpackRetval);

        assertArrayEquals(data, unpackBuf);
    }

    @Test
    public void maxBits0() {
        int[] data = { 0 };
        assertEquals(0, XorBinaryPacking.xorMaxBits(data, 0, data.length, 0));
        assertEquals(1, XorBinaryPacking.xorMaxBits(data, 0, data.length, 1));
        assertEquals(2, XorBinaryPacking.xorMaxBits(data, 0, data.length, 2));
        assertEquals(2, XorBinaryPacking.xorMaxBits(data, 0, data.length, 3));
        assertEquals(3, XorBinaryPacking.xorMaxBits(data, 0, data.length, 4));
        assertEquals(3, XorBinaryPacking.xorMaxBits(data, 0, data.length, 5));
        assertEquals(3, XorBinaryPacking.xorMaxBits(data, 0, data.length, 6));
        assertEquals(3, XorBinaryPacking.xorMaxBits(data, 0, data.length, 7));
        assertEquals(4, XorBinaryPacking.xorMaxBits(data, 0, data.length, 8));

        for (int i = 5; i <= 32; ++i) {
            assertEquals(i, XorBinaryPacking.xorMaxBits(data, 0, data.length,
                        1 << (i - 1)));
        }
    }

    @Test
    public void maxBits1() {
        int[] data = { 0 };
        for (int i = 1; i <= 32; ++i) {
            data[0] = 1 << (i - 1);
            assertEquals(i,
                    XorBinaryPacking.xorMaxBits(data, 0, data.length, 0));
        }
    }
}
