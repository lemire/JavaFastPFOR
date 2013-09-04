package me.lemire.integercompression;

import java.util.Arrays;

import static org.junit.Assert.*;

/**
 * Static utility methods for test.
 */
public class TestUtils {

    /**
     * Check that compress and uncompress keep original array.
     *
     * @param codec CODEC to test.
     * @param source Data for test.
     */
    public static void assertSymmetry(IntegerCODEC codec, int... source) {
        int[] compressed = new int[source.length];
        IntWrapper c_inpos = new IntWrapper(0);
        IntWrapper c_outpos = new IntWrapper(0);
        codec.compress(source, c_inpos, source.length, compressed, c_outpos);
        assertTrue(c_outpos.get() <= source.length);

        // Uncompress an array.
        int[] uncompressed = new int[source.length];
        IntWrapper u_inpos = new IntWrapper(0);
        IntWrapper u_outpos = new IntWrapper(0);
        codec.uncompress(compressed, u_inpos, c_outpos.get(),
                uncompressed, u_outpos);

        // Compare between uncompressed and original arrays.
        int[] target = Arrays.copyOf(uncompressed, u_outpos.get());
        assertArrayEquals(source, target);
    }

}
