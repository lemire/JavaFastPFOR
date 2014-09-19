package me.lemire.integercompression;

import org.junit.Test;
import static me.lemire.integercompression.TestUtils.*;

/**
 * Collection of adhoc tests.
 */
@SuppressWarnings({  "static-method" })
public class AdhocTest
{

    /**
     * a test
     */
    @Test
    public void biggerCompressedArray0() {
        // No problem: for comparison.
        IntegerCODEC c = new Composition(new FastPFOR128(), new VariableByte());
        assertSymmetry(c, 0, 16384);
        c = new Composition(new FastPFOR(), new VariableByte());
        assertSymmetry(c, 0, 16384);

    }

    /**
     * a test
     */
    @Test
    public void biggerCompressedArray1() {
        // Compressed array is bigger than original, because of VariableByte.
        IntegerCODEC c = new VariableByte();
        assertSymmetry(c, -1);
    }

    /**
     * a test
     */
    @Test
    public void biggerCompressedArray2() {
        // Compressed array is bigger than original, because of Composition.
        IntegerCODEC c = new Composition(new FastPFOR128(), new VariableByte());
        assertSymmetry(c, 65535, 65535);
        c = new Composition(new FastPFOR(), new VariableByte());
        assertSymmetry(c, 65535, 65535);
    }

 
}
