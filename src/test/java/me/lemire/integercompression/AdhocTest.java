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
    public void adhoc1() {
        Composition c = new Composition(new FastPFOR(), new VariableByte());
        assertSymmetry(c, 0, 16384);
    }

}
