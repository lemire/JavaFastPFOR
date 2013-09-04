package me.lemire.integercompression;

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

}
