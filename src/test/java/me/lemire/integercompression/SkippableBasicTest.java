package me.lemire.integercompression;

import java.util.Arrays;

import me.lemire.integercompression.skippable.*;

import org.junit.Test;


/**
 * Just some basic sanity tests.
 * 
 * @author Daniel Lemire
 */
@SuppressWarnings({ "static-method" })
public class SkippableBasicTest {
    SkippableIntegerCODEC[] codecs = {
            new JustCopy(),
            new VariableByte(),
            new SkippableComposition(new SkippableBinaryPacking(), new VariableByte()),
           // new SkippableComposition(new SkippableNewPFD(), new VariableByte()),
           // new SkippableComposition(new SkippableOptPFD(), new VariableByte()),
           // new SkippableComposition(new SkippableFastPFOR(), new VariableByte()),
            new SkippableSimple9(),
            new SkippableSimple16() };

    /**
     * 
     */
    @Test
    public void varyingLengthTest() {
        int N = 4096;
        int[] data = new int[N];
        for (int k = 0; k < N; ++k)
            data[k] = k;
        for (SkippableIntegerCODEC c : codecs) {
            for (int L = 1; L <= 128; L++) {
                int[] comp = TestUtils.compress(c, Arrays.copyOf(data, L));
                int[] answer = TestUtils.uncompress(c, comp, L);
                for (int k = 0; k < L; ++k)
                    if (answer[k] != data[k])
                        throw new RuntimeException("bug "+c.toString()+" "+k+" "+answer[k]+" "+data[k]);
            }
            for (int L = 128; L <= N; L *= 2) {
                int[] comp = TestUtils.compress(c, Arrays.copyOf(data, L));
                int[] answer = TestUtils.uncompress(c, comp, L);
                for (int k = 0; k < L; ++k)
                    if (answer[k] != data[k])
                        throw new RuntimeException("bug");
            }

        }
    }

    /**
     * 
     */
    @Test
    public void varyingLengthTest2() {
        int N = 128;
        int[] data = new int[N];
        data[127] = -1;
        for (SkippableIntegerCODEC c : codecs) {
            try {
                // CODEC Simple9 is limited to "small" integers.
                if (c.getClass().equals(
                        Class.forName("me.lemire.integercompression.skippable.SkippableSimple9")))
                    continue;
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
            try {
                // CODEC Simple16 is limited to "small" integers.
                if (c.getClass().equals(
                        Class.forName("me.lemire.integercompression.skippable.SkippableSimple16")))
                    continue;
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
            for (int L = 1; L <= 128; L++) {
                int[] comp = TestUtils.compress(c, Arrays.copyOf(data, L));
                int[] answer = TestUtils.uncompress(c, comp, L);
                for (int k = 0; k < L; ++k)
                    if (answer[k] != data[k])
                        throw new RuntimeException("bug at k = "+k+" "+answer[k]+" "+data[k]+" for "+c.toString());
            }
            for (int L = 128; L <= N; L *= 2) {
                int[] comp = TestUtils.compress(c, Arrays.copyOf(data, L));
                int[] answer = TestUtils.uncompress(c, comp, L);
                for (int k = 0; k < L; ++k)
                    if (answer[k] != data[k])
                        throw new RuntimeException("bug");
            }

        }
    }


}
