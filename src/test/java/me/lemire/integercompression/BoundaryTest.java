package me.lemire.integercompression;

import java.util.Arrays;

import org.junit.Test;
import static org.junit.Assert.*;

public class BoundaryTest
{
    private static void compressAndUncompress(int length, IntegerCODEC c) {
        // Initialize array.
        int[] source = new int[length];
        for (int i = 0; i < source.length; ++i) {
            source[i] = i;
        }

        // Compress an array.
        int[] compressed = new int[length];
        IntWrapper c_inpos = new IntWrapper(0);
        IntWrapper c_outpos = new IntWrapper(0);
        c.compress(source, c_inpos, source.length, compressed, c_outpos);
        assertTrue(c_outpos.get() <= length);

        // Uncompress an array.
        int[] uncompressed = new int[length];
        IntWrapper u_inpos = new IntWrapper(0);
        IntWrapper u_outpos = new IntWrapper(0);
        c.uncompress(compressed, u_inpos, c_outpos.get(),
                uncompressed, u_outpos);

        // Compare between uncompressed and original arrays.
        int[] target = Arrays.copyOf(uncompressed, u_outpos.get());
        assertArrayEquals(source, target);
    }

    private static void around128(IntegerCODEC c) {
        compressAndUncompress(127, c);
        compressAndUncompress(128, c);
        compressAndUncompress(129, c);
    }

    private static void around256(IntegerCODEC c) {
        compressAndUncompress(255, c);
        compressAndUncompress(256, c);
        compressAndUncompress(257, c);
    }

    private static void testBoundary(IntegerCODEC c) {
        around128(c);
        around256(c);
    }

    @Test
    public void testIntegratedComposition() throws Exception {
        IntegratedComposition c = new IntegratedComposition(
                new IntegratedBinaryPacking(),
                new IntegratedVariableByte());
        testBoundary(c);
    }

    @Test
    public void testComposition() throws Exception {
        Composition c = new Composition(
                new BinaryPacking(),
                new VariableByte());
        testBoundary(c);
    }
}
