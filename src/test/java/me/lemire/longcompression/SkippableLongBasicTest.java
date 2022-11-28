/**
 * This code is released under the
 * Apache License Version 2.0 http://www.apache.org/licenses/.
 *
 * (c) Daniel Lemire, http://lemire.me/en/
 */

package me.lemire.longcompression;

import java.util.Arrays;

import org.junit.Test;

import me.lemire.integercompression.IntWrapper;
import me.lemire.integercompression.TestUtils;
import me.lemire.integercompression.VariableByte;


/**
 * Just some basic sanity tests.
 * 
 * @author Benoit Lacelle
 */
@SuppressWarnings({ "static-method" })
public class SkippableLongBasicTest {
    final SkippableLongCODEC[] codecs = {
            new LongJustCopy(),
            new LongVariableByte(),
            new SkippableLongComposition(new LongBinaryPacking(), new LongVariableByte()), };

    
    /**
     * 
     */
    @Test
    public void consistentTest() {
        int N = 4096;
        long[] data = new long[N];
        long[] rev = new long[N];
        for (int k = 0; k < N; ++k)
            data[k] = k % 128;
        for (SkippableLongCODEC c : codecs) {
            System.out.println("[SkippeableBasicTest.consistentTest] codec = "
                    + c);
            long[] outBuf = new long[N + 1024];
            for (int n = 0; n <= N; ++n) {
                IntWrapper inPos = new IntWrapper();
                IntWrapper outPos = new IntWrapper();
                c.headlessCompress(data, inPos, n, outBuf, outPos);

                IntWrapper inPoso = new IntWrapper();
                IntWrapper outPoso = new IntWrapper();
                c.headlessUncompress(outBuf, inPoso, outPos.get(), rev,
                        outPoso, n);
                if (outPoso.get() != n) {
                    throw new RuntimeException("bug "+n);
                }
                if (inPoso.get() != outPos.get()) {
                    throw new RuntimeException("bug "+n+" "+inPoso.get()+" "+outPos.get());
                }
                for (int j = 0; j < n; ++j)
                    if (data[j] != rev[j]) {
                        throw new RuntimeException("bug");
                    }
            }
        }
    }

    
    /**
     * 
     */
    @Test
    public void varyingLengthTest() {
        int N = 4096;
        long[] data = new long[N];
        for (int k = 0; k < N; ++k)
            data[k] = k;
        for (SkippableLongCODEC c : codecs) {
            System.out.println("[SkippeableBasicTest.varyingLengthTest] codec = "+c);
            for (int L = 1; L <= 128; L++) {
            	long[] comp = LongTestUtils.compressHeadless(c, Arrays.copyOf(data, L));
            	long[] answer = LongTestUtils.uncompressHeadless(c, comp, L);
                for (int k = 0; k < L; ++k)
                    if (answer[k] != data[k])
                        throw new RuntimeException("bug "+c.toString()+" "+k+" "+answer[k]+" "+data[k]);
            }
            for (int L = 128; L <= N; L *= 2) {
            	long[] comp = LongTestUtils.compressHeadless(c, Arrays.copyOf(data, L));
            	long[] answer = LongTestUtils.uncompressHeadless(c, comp, L);
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
        long[] data = new long[N];
        data[127] = -1;
        for (SkippableLongCODEC c : codecs) {
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
            	long[] comp = LongTestUtils.compressHeadless(c, Arrays.copyOf(data, L));
            	long[] answer = LongTestUtils.uncompressHeadless(c, comp, L);
                for (int k = 0; k < L; ++k)
                    if (answer[k] != data[k]) {
                    	throw new RuntimeException("L=" + L + ": bug at k = "+k+" "+answer[k]+" "+data[k]+" for "+c.toString());
                    }
            }
            for (int L = 128; L <= N; L *= 2) {
            	long[] comp = LongTestUtils.compressHeadless(c, Arrays.copyOf(data, L));
            	long[] answer = LongTestUtils.uncompressHeadless(c, comp, L);
                for (int k = 0; k < L; ++k)
                    if (answer[k] != data[k])
                        throw new RuntimeException("bug");
            }

        }
    }


}
