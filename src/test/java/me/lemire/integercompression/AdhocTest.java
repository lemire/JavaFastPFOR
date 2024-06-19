/**
 * This code is released under the
 * Apache License Version 2.0 http://www.apache.org/licenses/.
 *
 * (c) Daniel Lemire, http://lemire.me/en/
 */

package me.lemire.integercompression;

import org.junit.Assert;
import org.junit.Test;

import me.lemire.integercompression.differential.*;

import static me.lemire.integercompression.TestUtils.*;

import java.util.Arrays;

/**
 * Collection of adhoc tests.
 */
@SuppressWarnings({  "static-method" })
public class AdhocTest {

    @Test
    public void testIssue59() {
        FastPFOR128 fastpfor = new FastPFOR128();

        int N = 9984;
        int[] data = new int[N];
        for (var i = 0; i < N; i += 150) {
            data[i] = i;
        }

        int[] compressedoutput1 = new int[N + 1024];

        IntWrapper inputoffset1 = new IntWrapper(0);
        IntWrapper outputoffset1 = new IntWrapper(0);

        fastpfor.compress(data, inputoffset1, N, compressedoutput1, outputoffset1);
        int compressedsize1 = outputoffset1.get();

        int[] recovered1 = new int[N];
        inputoffset1 = new IntWrapper(0);
        outputoffset1 = new IntWrapper(0);
        fastpfor.uncompress(compressedoutput1, outputoffset1, compressedsize1, recovered1, inputoffset1);
        Assert.assertArrayEquals(data, recovered1);

        int[] compressedoutput2 = new int[N + 1024];

        IntWrapper inputoffset2 = new IntWrapper(0);
        IntWrapper outputoffset2 = new IntWrapper(0);

        fastpfor.compress(data, inputoffset2, N, compressedoutput2, outputoffset2);
        int compressedsize2 = outputoffset2.get();

        int[] recovered2 = new int[N];
        inputoffset2 = new IntWrapper(0);
        outputoffset2 = new IntWrapper(0);
        fastpfor.uncompress(compressedoutput2, outputoffset2, compressedsize2, recovered2, inputoffset2);
        Assert.assertArrayEquals(data, recovered2);
    }  

    @Test
    public void testIssue29() {
        for(int x = 0; x < 64; x++) {
          int[] a = {2, 3, 4, 5};
          int[] b = new int[90];
          int[] c = new int[a.length];
          IntegerCODEC codec = new Composition(new BinaryPacking(), new VariableByte());

          IntWrapper aOffset = new IntWrapper(0);
          IntWrapper bOffset = new IntWrapper(x);
          codec.compress(a, aOffset, a.length, b, bOffset);
          int len = bOffset.get() - x;
          bOffset.set(x);
          IntWrapper cOffset = new IntWrapper(0);
          codec.uncompress(b, bOffset, len, c, cOffset);
          Assert.assertArrayEquals(a,c);
        }
    }
    
    /**
     * 
     */
    @Test
    public void testIssue29b() {
        for(int x = 0; x < 64; x++) {
            int[] a = {2, 3, 4, 5};
            int[] b = new int[90];
            int[] c = new int[a.length];
            SkippableIntegerCODEC codec = new SkippableComposition(new BinaryPacking(), new VariableByte());
            IntWrapper aOffset = new IntWrapper(0);
            IntWrapper bOffset = new IntWrapper(x);
            codec.headlessCompress(a, aOffset, a.length, b, bOffset);
            int len = bOffset.get() - x;
            bOffset.set(x);
            IntWrapper cOffset = new IntWrapper(0);
            codec.headlessUncompress(b, bOffset, len, c, cOffset, a.length);
            Assert.assertArrayEquals(a,c);
        }
    }
    

    /**
     * 
     */
    @Test
    public void testIssue41() {
        for (int x = 0; x < 64; x++) {
            int[] a = { 2, 3, 4, 5 };
            int[] b = new int[90];
            int[] c = new int[a.length];
            SkippableIntegratedIntegerCODEC codec = new SkippableIntegratedComposition(new IntegratedBinaryPacking(),
                    new IntegratedVariableByte());
            IntWrapper aOffset = new IntWrapper(0);
            IntWrapper bOffset = new IntWrapper(x);
            IntWrapper initValue = new IntWrapper(0);

            codec.headlessCompress(a, aOffset, a.length, b, bOffset, initValue);
            int len = bOffset.get() - x;
            bOffset.set(x);
            IntWrapper cOffset = new IntWrapper(0);
            initValue = new IntWrapper(0);
            codec.headlessUncompress(b, bOffset, len, c, cOffset, a.length, initValue);
            Assert.assertArrayEquals(a, c);
        }
    }
 
    @Test
    public void biggerCompressedArray0() {
        // No problem: for comparison.
        IntegerCODEC c = new Composition(new FastPFOR128(), new VariableByte());
        assertSymmetry(c, 0, 16384);
        c = new Composition(new FastPFOR(), new VariableByte());
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
        IntegerCODEC c = new Composition(new FastPFOR128(), new VariableByte());
        assertSymmetry(c, 65535, 65535);
        c = new Composition(new FastPFOR(), new VariableByte());
        assertSymmetry(c, 65535, 65535);
    }

 
}
