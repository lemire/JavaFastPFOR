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
    public static void assertSymmetry(IntegerCODEC codec, int... orig) {
        // There are some cases that compressed array is bigger than original
        // array.  So output array for compress must be larger.
        //
        // Example:
        //  - VariableByte compresses an array like [ -1 ].
        //  - Composition compresses a short array.

        int[] compressed = new int[orig.length + 1];
        IntWrapper c_inpos = new IntWrapper(0);
        IntWrapper c_outpos = new IntWrapper(0);
        codec.compress(orig, c_inpos, orig.length, compressed,
                c_outpos);

        assertTrue(c_outpos.get() <= orig.length + 1);

        // Uncompress an array.
        int[] uncompressed = new int[orig.length];
        IntWrapper u_inpos = new IntWrapper(0);
        IntWrapper u_outpos = new IntWrapper(0);
        codec.uncompress(compressed, u_inpos, c_outpos.get(),
                uncompressed, u_outpos);

        // Compare between uncompressed and orig arrays.
        int[] target = Arrays.copyOf(uncompressed, u_outpos.get());
        assertArrayEquals(orig, target);
    }

}
