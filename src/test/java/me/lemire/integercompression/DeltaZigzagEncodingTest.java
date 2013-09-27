/*
 * This code is released under the
 * Apache License Version 2.0 http://www.apache.org/licenses/.
 */
package me.lemire.integercompression;

import org.junit.Test;
import static org.junit.Assert.*;

public class DeltaZigzagEncodingTest {

    public static int zigzagEncode(DeltaZigzagEncoding.Encoder e, int value) {
        e.setContextValue(0);
        return e.encodeInt(value);
    }

    public static int zigzagDecode(DeltaZigzagEncoding.Decoder d, int value) {
        d.setContextValue(0);
        return d.decodeInt(value);
    }

    public static void checkEncode(
            DeltaZigzagEncoding.Encoder e,
            int[] data,
            int[] expected)
    {
        assertArrayEquals(expected, e.encodeArray(data));
        assertEquals(data[data.length - 1], e.getContextValue());
    }

    public static void checkDecode(
            DeltaZigzagEncoding.Decoder d,
            int[] data,
            int[] expected)
    {
        int[] r = d.decodeArray(data);
        assertArrayEquals(expected, r);
        assertEquals(r[r.length - 1], d.getContextValue());
    }

    @Test
    public void checkZigzagEncode() {
        DeltaZigzagEncoding.Encoder e = new DeltaZigzagEncoding.Encoder();
        assertEquals(0, zigzagEncode(e, 0));
        assertEquals(2, zigzagEncode(e, 1));
        assertEquals(4, zigzagEncode(e, 2));
        assertEquals(6, zigzagEncode(e, 3));
        assertEquals(1, zigzagEncode(e, -1));
        assertEquals(3, zigzagEncode(e, -2));
        assertEquals(5, zigzagEncode(e, -3));
    }

    @Test
    public void checkZigzagDecoder() {
        DeltaZigzagEncoding.Decoder d = new DeltaZigzagEncoding.Decoder();
        assertEquals( 0, zigzagDecode(d, 0));
        assertEquals(-1, zigzagDecode(d, 1));
        assertEquals( 1, zigzagDecode(d, 2));
        assertEquals(-2, zigzagDecode(d, 3));
        assertEquals( 2, zigzagDecode(d, 4));
        assertEquals(-3, zigzagDecode(d, 5));
    }

    @Test
    public void checkEncodeSimple() {
        DeltaZigzagEncoding.Encoder e = new DeltaZigzagEncoding.Encoder();
        checkEncode(e,
            new int[]{ 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 },
            new int[]{ 0, 2, 2, 2, 2, 2, 2, 2, 2, 2 });
    }

    @Test
    public void checkDecodeSimple() {
        DeltaZigzagEncoding.Decoder d = new DeltaZigzagEncoding.Decoder();
        checkDecode(d,
            new int[]{ 0, 2, 2, 2, 2, 2, 2, 2, 2, 2 },
            new int[]{ 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 });
    }
}
