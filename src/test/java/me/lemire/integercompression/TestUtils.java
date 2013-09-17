package me.lemire.integercompression;

import java.util.Arrays;

import static org.junit.Assert.*;

/**
 * Static utility methods for test.
 */
public class TestUtils {

    private static void dumpIntArray(int[] data, String label) {
        System.out.println(label);
        for (int i = 0; i < 32; ++i) {
            System.out.format(" %1$11d", data[i]);
            if ((i + 1) % 6 == 0) {
                System.out.println();
            }
        }
        System.out.println();
    }

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
        final int EXTEND = 1;

        int[] compressed = new int[orig.length + EXTEND];
        IntWrapper c_inpos = new IntWrapper(0);
        IntWrapper c_outpos = new IntWrapper(0);
        codec.compress(orig, c_inpos, orig.length, compressed,
                c_outpos);

        assertTrue(c_outpos.get() <= orig.length + EXTEND);

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
