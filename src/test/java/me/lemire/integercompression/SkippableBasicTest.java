package me.lemire.integercompression;

import java.util.Arrays;

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
            new SkippableComposition(new BinaryPacking(), new VariableByte()),
           /* new SkippableComposition(new NewPFD(), new VariableByte()),
            new SkippableComposition(new NewPFDS9(), new VariableByte()),
            new SkippableComposition(new NewPFDS16(), new VariableByte()),
            new SkippableComposition(new OptPFD(), new VariableByte()),
            new SkippableComposition(new OptPFDS9(), new VariableByte()),
            new SkippableComposition(new OptPFDS16(), new VariableByte()),*/
            new SkippableComposition(new FastPFOR(), new VariableByte()),
            new Simple9(),
            new Simple16() };

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
            System.out.println("[SkippeableBasicTest.varyingLengthTest] codec = "+c);
            for (int L = 1; L <= 128; L++) {
                int[] comp = TestUtils.compressHeadless(c, Arrays.copyOf(data, L));
                int[] answer = TestUtils.uncompressHeadless(c, comp, L);
                for (int k = 0; k < L; ++k)
                    if (answer[k] != data[k])
                        throw new RuntimeException("bug "+c.toString()+" "+k+" "+answer[k]+" "+data[k]);
            }
            for (int L = 128; L <= N; L *= 2) {
                int[] comp = TestUtils.compressHeadless(c, Arrays.copyOf(data, L));
                int[] answer = TestUtils.uncompressHeadless(c, comp, L);
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
            System.out.println("[SkippeableBasicTest.varyingLengthTest2] codec = "+c);

            try {
                // CODEC Simple9 is limited to "small" integers.
                if (c.getClass().equals(
                        Class.forName("me.lemire.integercompression.Simple9")))
                    continue;
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
            try {
                // CODEC Simple16 is limited to "small" integers.
                if (c.getClass().equals(
                        Class.forName("me.lemire.integercompression.Simple16")))
                    continue;
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
            for (int L = 1; L <= 128; L++) {
                int[] comp = TestUtils.compressHeadless(c, Arrays.copyOf(data, L));
                int[] answer = TestUtils.uncompressHeadless(c, comp, L);
                for (int k = 0; k < L; ++k)
                    if (answer[k] != data[k])
                        throw new RuntimeException("bug at k = "+k+" "+answer[k]+" "+data[k]+" for "+c.toString());
            }
            for (int L = 128; L <= N; L *= 2) {
                int[] comp = TestUtils.compressHeadless(c, Arrays.copyOf(data, L));
                int[] answer = TestUtils.uncompressHeadless(c, comp, L);
                for (int k = 0; k < L; ++k)
                    if (answer[k] != data[k])
                        throw new RuntimeException("bug");
            }

        }
    }


}
