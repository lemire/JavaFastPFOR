/*
 * This code is released under the
 * Apache License Version 2.0 http://www.apache.org/licenses/.
 */
package me.lemire.integercompression;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * @author lemire
 *
 */
@SuppressWarnings({ "static-method" })
public class DeltaZigzagEncodingTest {

    protected static int zigzagEncode(DeltaZigzagEncoding.Encoder e, int value) {
        e.setContextValue(0);
        return e.encodeInt(value);
    }

    protected static int zigzagDecode(DeltaZigzagEncoding.Decoder d, int value) {
        d.setContextValue(0);
        return d.decodeInt(value);
    }

    protected static void checkEncode(
            DeltaZigzagEncoding.Encoder e,
            int[] data,
            int[] expected)
    {
        assertArrayEquals(expected, e.encodeArray(data));
        assertEquals(data[data.length - 1], e.getContextValue());
    }

    protected static void checkDecode(
            DeltaZigzagEncoding.Decoder d,
            int[] data,
            int[] expected)
    {
        int[] r = d.decodeArray(data);
        assertArrayEquals(expected, r);
        assertEquals(r[r.length - 1], d.getContextValue());
    }
    /**
     * 
     */
    @Test
    public void checkZigzagEncode() {
        DeltaZigzagEncoding.Encoder e = new DeltaZigzagEncoding.Encoder(0);
        assertEquals(0, zigzagEncode(e, 0));
        assertEquals(2, zigzagEncode(e, 1));
        assertEquals(4, zigzagEncode(e, 2));
        assertEquals(6, zigzagEncode(e, 3));
        assertEquals(1, zigzagEncode(e, -1));
        assertEquals(3, zigzagEncode(e, -2));
        assertEquals(5, zigzagEncode(e, -3));
    }
    /**
     * 
     */
    @Test
    public void checkZigzagDecoder() {
        DeltaZigzagEncoding.Decoder d = new DeltaZigzagEncoding.Decoder(0);
        assertEquals( 0, zigzagDecode(d, 0));
        assertEquals(-1, zigzagDecode(d, 1));
        assertEquals( 1, zigzagDecode(d, 2));
        assertEquals(-2, zigzagDecode(d, 3));
        assertEquals( 2, zigzagDecode(d, 4));
        assertEquals(-3, zigzagDecode(d, 5));
    }
    /**
     * 
     */
    @Test
    public void checkEncodeSimple() {
        DeltaZigzagEncoding.Encoder e = new DeltaZigzagEncoding.Encoder(0);
        checkEncode(e,
            new int[]{ 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 },
            new int[]{ 0, 2, 2, 2, 2, 2, 2, 2, 2, 2 });
    }
    /**
     * 
     */
    @Test
    public void checkDecodeSimple() {
        DeltaZigzagEncoding.Decoder d = new DeltaZigzagEncoding.Decoder(0);
        checkDecode(d,
            new int[]{ 0, 2, 2, 2, 2, 2, 2, 2, 2, 2 },
            new int[]{ 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 });
    }

    protected static class SpotChecker {

        private final static DeltaZigzagEncoding.Encoder encoder =
            new DeltaZigzagEncoding.Encoder(0);

        private final static DeltaZigzagEncoding.Decoder decoder =
            new DeltaZigzagEncoding.Decoder(0);

        public void check(int value) {
            SpotChecker.encoder.setContextValue(0);
            SpotChecker.decoder.setContextValue(0);
            int value2 = SpotChecker.decoder.decodeInt(SpotChecker.encoder.encodeInt(value));
            assertEquals(value, value2);
        }
    }

    /**
     * 
     */
    @Test
    public void checkSpots() {
        SpotChecker c = new SpotChecker();
        c.check(0);
        c.check(1);
        c.check(1375228800);
        c.check(1 << 30);
        c.check(1 << 31);
    }
}
