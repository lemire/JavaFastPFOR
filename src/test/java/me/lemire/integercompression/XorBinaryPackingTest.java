/**
 * This code is released under the
 * Apache License Version 2.0 http://www.apache.org/licenses/.
 */
package me.lemire.integercompression;

import java.util.Arrays;

import org.junit.Test;
import static org.junit.Assert.*;

public final class XorBinaryPackingTest
{
    @Test
    public void packAndUnpack0() {
        int[] data = new int[] {
             0,  1,  2,  3,  4,  5,  6,  7,  8,  9, 10, 11, 12, 13, 14, 15,
            16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31,
        };
        checkPack(data, 6, 0);
    }

    @Test
    public void packAndUnpack1() {
        int[] data = new int[32];
        Arrays.fill(data, 1);
        checkPack(data, 1, 0);
        Arrays.fill(data, 2);
        checkPack(data, 2, 1);
        Arrays.fill(data, 4);
        checkPack(data, 3, 2);
        Arrays.fill(data, 8);
        checkPack(data, 4, 4);
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

    public static void checkCompressAndUncompress(String label, int[] data) {
        XorBinaryPacking codec = new XorBinaryPacking();
        int[] compBuf = TestUtils.compress(codec, data);
        int[] decompBuf = TestUtils.uncompress(codec, compBuf, data.length);
        assertArrayEquals(data, decompBuf);
    }

    @Test
    public void compressAndUncompress0() {
        int[] data = new int[128];
        Arrays.fill(data,  0,  31, 1);
        Arrays.fill(data, 32,  63, 2);
        Arrays.fill(data, 64,  95, 4);
        Arrays.fill(data, 96, 127, 8);
        checkCompressAndUncompress("compressAndUncompress0", data);
    }

    @Test
    public void compressAndUncompress1() {
        int[] data = new int[128];
        for (int i = 0; i < data.length; ++i) {
            data[i] = i;
        }
        checkCompressAndUncompress("compressAndUncompress1", data);
    }

    @Test
    public void compressAndUncompress2() {
        int[] data = new int[128];
        for (int i = 0; i < data.length; ++i) {
            data[i] = i * (i + 1) / 2;
        }
        checkCompressAndUncompress("compressAndUncompress2", data);
    }

    @Test
    public void compressAndUncompress3() {
        int[] data = new int[256];
        Arrays.fill(data,   0, 127, 2);
        Arrays.fill(data, 128, 255, 3);
        checkCompressAndUncompress("compressAndUncompress3", data);
    }

    @Test
    public void compressAndUncompress4() {
        int[] data = new int[256];
        Arrays.fill(data,   0, 127, 3);
        Arrays.fill(data, 128, 255, 2);
        checkCompressAndUncompress("compressAndUncompress4", data);
    }
}
