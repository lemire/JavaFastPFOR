package me.lemire.integercompression;

import java.util.Arrays;

import org.junit.Test;
import static org.junit.Assert.*;

import static me.lemire.integercompression.TestUtils.*;

/**
 * Collection of adhoc tests.
 */
public class AdhocTest
{

    @Test
    public void biggerCompressedArray0() {
        // No problem: for comparison.
        IntegerCODEC c = new Composition(new FastPFOR(), new VariableByte());
        assertSymmetry(c, 0, 16384);
    }

    @Test
    public void biggerCompressedArray1() {
        // Compressed array is bigger than original, because of VariableByte.
        IntegerCODEC c = new VariableByte();
        assertSymmetry(c, -1);
    }

    @Test
    public void biggerCompressedArray2() {
        // Compressed array is bigger than original, because of Composition.
        IntegerCODEC c = new Composition(new FastPFOR(), new VariableByte());
        assertSymmetry(c, 65535, 65535);
    }

    // NOTE: This require bigger 2 items for compressed array than original.
    /*
    @Test
    public void overflowVariableByte() {
        IntegerCODEC c = new VariableByte();
        int[] d = new int[8];
        Arrays.fill(d, -1);
        assertSymmetry(c, d);
    }
    */
}
