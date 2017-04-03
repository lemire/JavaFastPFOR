package me.lemire.integercompression;

import java.util.Arrays;
import java.util.Random;

import me.lemire.integercompression.differential.Delta;
import me.lemire.integercompression.differential.IntegratedBinaryPacking;
import me.lemire.integercompression.differential.IntegratedComposition;
import me.lemire.integercompression.differential.IntegratedIntegerCODEC;
import me.lemire.integercompression.differential.IntegratedVariableByte;
import me.lemire.integercompression.differential.XorBinaryPacking;
import me.lemire.integercompression.synth.ClusteredDataGenerator;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Just some basic sanity tests.
 * 
 * @author Daniel Lemire
 */
@SuppressWarnings({ "static-method" })
public class BasicTest {
    IntegerCODEC[] codecs = {
            new IntegratedComposition(new IntegratedBinaryPacking(),
                    new IntegratedVariableByte()),
            new JustCopy(),
            new VariableByte(),
            new GroupSimple9(),
            new IntegratedVariableByte(),
            new Composition(new BinaryPacking(), new VariableByte()),
            new Composition(new NewPFD(), new VariableByte()),
            new Composition(new NewPFDS16(), new VariableByte()),
            new Composition(new OptPFDS9(), new VariableByte()),
            new Composition(new OptPFDS16(), new VariableByte()),
            new Composition(new FastPFOR128(), new VariableByte()),
            new Composition(new FastPFOR(), new VariableByte()),
            new Simple9(),
            new Simple16(),
            new GroupSimple9(),
            new Composition(new XorBinaryPacking(), new VariableByte()),
            new Composition(new DeltaZigzagBinaryPacking(),
					new DeltaZigzagVariableByte()) };

	/**
     * 
     */
	@Test
	public void saulTest() {
		for (IntegerCODEC C : codecs) {
			for (int x = 0; x < 50; ++x) {
				int[] a = { 2, 3, 4, 5 };
				int[] b = new int[90];
				int[] c = new int[a.length];

				IntWrapper aOffset = new IntWrapper(0);
				IntWrapper bOffset = new IntWrapper(x);
				C.compress(a, aOffset, a.length, b, bOffset);
				int len = bOffset.get() - x;

				bOffset.set(x);
				IntWrapper cOffset = new IntWrapper(0);
				C.uncompress(b, bOffset, len, c, cOffset);
				if(!Arrays.equals(a, c)) {
					System.out.println("Problem with "+C);
				}
				assertArrayEquals(a, c);

			}
		}
	}
    /**
     * 
     */
    @Test
    public void varyingLengthTest() {
        int N = 4096;
        int[] data = new int[N];
        for (int k = 0; k < N; ++k)
            data[k] = k;
        for (IntegerCODEC c : codecs) {
            System.out.println("[BasicTest.varyingLengthTest] codec = " + c);
            for (int L = 1; L <= 128; L++) {
                int[] comp = TestUtils.compress(c, Arrays.copyOf(data, L));
                int[] answer = TestUtils.uncompress(c, comp, L);
                for (int k = 0; k < L; ++k)
                    if (answer[k] != data[k])
                        throw new RuntimeException("bug");
            }
            for (int L = 128; L <= N; L *= 2) {
                int[] comp = TestUtils.compress(c, Arrays.copyOf(data, L));
                int[] answer = TestUtils.uncompress(c, comp, L);
                for (int k = 0; k < L; ++k)
                    if (answer[k] != data[k]) {
                        System.out.println(Arrays.toString(Arrays.copyOf(
                                answer, L)));
                        System.out.println(Arrays.toString(Arrays.copyOf(data,
                                L)));
                        throw new RuntimeException("bug");
                    }
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
        for (IntegerCODEC c : codecs) {
            System.out.println("[BasicTest.varyingLengthTest2] codec = " + c);
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
            try {
                // CODEC GroupSimple9 is limited to "small" integers.
                if (c.getClass().equals(
                        Class.forName("me.lemire.integercompression.GroupSimple9")))
                    continue;
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }

            for (int L = 1; L <= 128; L++) {
                int[] comp = TestUtils.compress(c, Arrays.copyOf(data, L));
                int[] answer = TestUtils.uncompress(c, comp, L);
                for (int k = 0; k < L; ++k)
                    if (answer[k] != data[k])
                        throw new RuntimeException("bug");
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
    public void checkDeltaZigzagVB() {
        DeltaZigzagVariableByte codec = new DeltaZigzagVariableByte();
        DeltaZigzagVariableByte codeco = new DeltaZigzagVariableByte();

        testZeroInZeroOut(codec);
        test(codec, codeco, 5, 10);
        test(codec, codeco, 5, 14);
        test(codec, codeco, 2, 18);
    }

    /**
     * 
     */
    @Test
    public void checkDeltaZigzagPacking() {
        DeltaZigzagBinaryPacking codec = new DeltaZigzagBinaryPacking();
        testZeroInZeroOut(codec);
        testSpurious(codec);

        IntegerCODEC compo = new Composition(new DeltaZigzagBinaryPacking(),
                new VariableByte());
        IntegerCODEC compo2 = new Composition(new DeltaZigzagBinaryPacking(),
                new VariableByte());

        testZeroInZeroOut(compo);
        testUnsorted(compo);
        test(compo, compo2, 5, 10);
        test(compo, compo2, 5, 14);
        test(compo, compo2, 2, 18);
    }

    /**
     * 
     */
    @Test
    public void checkXorBinaryPacking() {
        testZeroInZeroOut(new XorBinaryPacking());
        testSpurious(new XorBinaryPacking());
    }

    /**
     * 
     */
    @Test
    public void checkXorBinaryPacking1() {
        IntegerCODEC c = new IntegratedComposition(new XorBinaryPacking(),
                new IntegratedVariableByte());
        testZeroInZeroOut(c);
    }

    /**
     * 
     */
    @Test
    public void checkXorBinaryPacking2() {
        IntegerCODEC c = new IntegratedComposition(new XorBinaryPacking(),
                new IntegratedVariableByte());
        testUnsorted(c);
    }

    /**
     * 
     */
    @Test
    public void checkXorBinaryPacking3() {
        IntegerCODEC c = new IntegratedComposition(new XorBinaryPacking(),
                new IntegratedVariableByte());
        IntegerCODEC co = new IntegratedComposition(new XorBinaryPacking(),
                new IntegratedVariableByte());
        test(c, co, 5, 10);
        test(c, co, 5, 14);
        test(c, co, 2, 18);
    }

    /**
     * Verify bitpacking.
     */
    @Test
    public void verifyBitPacking() {
        final int N = 32;
        final int TIMES = 1000;
        Random r = new Random();
        int[] data = new int[N];
        int[] compressed = new int[N];
        int[] uncompressed = new int[N];
        for (int bit = 0; bit < 31; ++bit) {
            for (int t = 0; t < TIMES; ++t) {
                for (int k = 0; k < N; ++k) {
                    data[k] = r.nextInt(1 << bit);
                }
                BitPacking.fastpack(data, 0, compressed, 0, bit);
                BitPacking.fastunpack(compressed, 0, uncompressed, 0, bit);
                assertArrayEquals(uncompressed, data);
            }
        }
    }

    /**
     * Verify bitpacking without mask.
     */
    @Test
    public void verifyWithoutMask() {
        final int N = 32;
        final int TIMES = 1000;
        Random r = new Random();
        int[] data = new int[N];
        int[] compressed = new int[N];
        int[] uncompressed = new int[N];
        for (int bit = 0; bit < 31; ++bit) {
            for (int t = 0; t < TIMES; ++t) {
                for (int k = 0; k < N; ++k) {
                    data[k] = r.nextInt(1 << bit);
                }
                BitPacking.fastpackwithoutmask(data, 0, compressed, 0, bit);
                BitPacking.fastunpack(compressed, 0, uncompressed, 0, bit);
                assertArrayEquals(uncompressed, data);
            }
        }
    }

    /**
     * @param array
     *            some array
     * @param mask
     *            provided mask
     */
    public static void maskArray(int[] array, int mask) {
        for (int i = 0, end = array.length; i < end; ++i) {
            array[i] &= mask;
        }
    }

    /**
     * Verify bitpacking with exception.
     */
    @Test
    public void verifyWithExceptions() {
        final int N = 32;
        final int TIMES = 1000;
        Random r = new Random();
        int[] data = new int[N];
        int[] compressed = new int[N];
        int[] uncompressed = new int[N];
        for (int bit = 0; bit < 31; ++bit) {
            for (int t = 0; t < TIMES; ++t) {
                for (int k = 0; k < N; ++k) {
                    data[k] = r.nextInt();
                }
                BitPacking.fastpack(data, 0, compressed, 0, bit);
                BitPacking.fastunpack(compressed, 0, uncompressed, 0, bit);

                // Check assertions.
                maskArray(data, ((1 << bit) - 1));
                assertArrayEquals(data, uncompressed);
            }
        }
    }

    /**
     * check that the codecs can be inverted.
     */
    @Test
    public void basictest() {
        test(5, 10);
        test(5, 14);
        test(2, 18);
    }

    /**
     * check that there is no spurious output.
     */
    @Test
    public void spuriousouttest() {
        testSpurious(new IntegratedBinaryPacking());
        testSpurious(new BinaryPacking());
        testSpurious(new NewPFD());
        testSpurious(new NewPFDS9());
        testSpurious(new NewPFDS16());
        testSpurious(new OptPFD());
        testSpurious(new OptPFDS9());
        testSpurious(new OptPFDS16());
        testSpurious(new FastPFOR128());
        testSpurious(new FastPFOR());
    }

    /**
     * check that an empty array generates an empty array after compression.
     */
    @Test
    public void zeroinzerouttest() {
        testZeroInZeroOut(new IntegratedBinaryPacking());
        testZeroInZeroOut(new IntegratedVariableByte());
        testZeroInZeroOut(new BinaryPacking());
        testZeroInZeroOut(new NewPFD());
        testZeroInZeroOut(new NewPFDS9());
        testZeroInZeroOut(new NewPFDS16());
        testZeroInZeroOut(new OptPFD());
        testZeroInZeroOut(new OptPFDS9());
        testZeroInZeroOut(new OptPFDS16());
        testZeroInZeroOut(new FastPFOR128());
        testZeroInZeroOut(new FastPFOR());
        testZeroInZeroOut(new VariableByte());
        testZeroInZeroOut(new Composition(new IntegratedBinaryPacking(),
                new VariableByte()));
        testZeroInZeroOut(new Composition(new BinaryPacking(),
                new VariableByte()));
        testZeroInZeroOut(new Composition(new NewPFD(), new VariableByte()));
        testZeroInZeroOut(new Composition(new NewPFDS9(), new VariableByte()));
        testZeroInZeroOut(new Composition(new NewPFDS16(), new VariableByte()));
        testZeroInZeroOut(new Composition(new OptPFD(), new VariableByte()));
        testZeroInZeroOut(new Composition(new OptPFDS9(), new VariableByte()));
        testZeroInZeroOut(new Composition(new OptPFDS16(), new VariableByte()));
        testZeroInZeroOut(new Composition(new FastPFOR128(), new VariableByte()));
        testZeroInZeroOut(new Composition(new FastPFOR(), new VariableByte()));

        testZeroInZeroOut(new IntegratedComposition(
                new IntegratedBinaryPacking(), new IntegratedVariableByte()));
    }

    private static void testSpurious(IntegerCODEC c) {
        int[] x = new int[1024];
        int[] y = new int[0];
        IntWrapper i0 = new IntWrapper(0);
        IntWrapper i1 = new IntWrapper(0);
        for (int inlength = 0; inlength < 32; ++inlength) {
            c.compress(x, i0, inlength, y, i1);
            assertEquals(0, i1.intValue());
        }
    }

    private static void testZeroInZeroOut(IntegerCODEC c) {
        int[] x = new int[0];
        int[] y = new int[0];
        IntWrapper i0 = new IntWrapper(0);
        IntWrapper i1 = new IntWrapper(0);
        c.compress(x, i0, 0, y, i1);
        assertEquals(0, i1.intValue());

        int[] out = new int[0];
        IntWrapper outpos = new IntWrapper(0);
        c.uncompress(y, i1, 0, out, outpos);
        assertEquals(0, outpos.intValue());
    }

    private static void test(IntegerCODEC c, IntegerCODEC co, int N, int nbr) {
        ClusteredDataGenerator cdg = new ClusteredDataGenerator();
        for (int sparsity = 1; sparsity < 31 - nbr; sparsity += 4) {
            int[][] data = new int[N][];
            int max = (1 << (nbr + sparsity));
            for (int k = 0; k < N; ++k) {
                data[k] = cdg.generateClustered((1 << nbr), max);
            }
            testCodec(c, co, data, max);
        }
    }

    private static void test(int N, int nbr) {
        ClusteredDataGenerator cdg = new ClusteredDataGenerator();
        System.out.println("[BasicTest.test] N = " + N + " " + nbr);
        for (int sparsity = 1; sparsity < 31 - nbr; sparsity += 4) {
            int[][] data = new int[N][];
            int max = (1 << (nbr + sparsity));
            for (int k = 0; k < N; ++k) {
                data[k] = cdg.generateClustered((1 << nbr), max);
            }

            testCodec(new IntegratedComposition(new IntegratedBinaryPacking(),
                    new IntegratedVariableByte()),
                    new IntegratedComposition(new IntegratedBinaryPacking(),
                            new IntegratedVariableByte()), data, max);
            testCodec(new JustCopy(), new JustCopy(), data, max);
            testCodec(new VariableByte(), new VariableByte(), data, max);
            testCodec(new IntegratedVariableByte(),
                    new IntegratedVariableByte(), data, max);
            testCodec(new Composition(new BinaryPacking(), new VariableByte()),
                    new Composition(new BinaryPacking(), new VariableByte()),
                    data, max);
            testCodec(new Composition(new NewPFD(), new VariableByte()),
                    new Composition(new NewPFD(), new VariableByte()), data,
                    max);
            testCodec(new Composition(new NewPFDS9(), new VariableByte()),
                    new Composition(new NewPFDS9(), new VariableByte()), data,
                    max);
            testCodec(new Composition(new NewPFDS16(), new VariableByte()),
                    new Composition(new NewPFDS16(), new VariableByte()), data,
                    max);
            testCodec(new Composition(new OptPFD(), new VariableByte()),
                    new Composition(new OptPFD(), new VariableByte()), data,
                    max);
            testCodec(new Composition(new OptPFDS9(), new VariableByte()),
                    new Composition(new OptPFDS9(), new VariableByte()), data,
                    max);
            testCodec(new Composition(new OptPFDS16(), new VariableByte()),
                    new Composition(new OptPFDS16(), new VariableByte()), data,
                    max);
            testCodec(new Composition(new FastPFOR128(), new VariableByte()),
                    new Composition(new FastPFOR128(), new VariableByte()),
                    data, max);
            testCodec(new Composition(new FastPFOR(), new VariableByte()),
                    new Composition(new FastPFOR(), new VariableByte()),
                    data, max);
            testCodec(new Simple9(), new Simple9(), data, max);
        }
    }

    private static void testCodec(IntegerCODEC c, IntegerCODEC co,
            int[][] data, int max) {
        int N = data.length;
        int maxlength = 0;
        for (int k = 0; k < N; ++k) {
            if (data[k].length > maxlength)
                maxlength = data[k].length;
        }
        int[] buffer = new int[maxlength + 1024];
        int[] dataout = new int[4 * maxlength + 1024];
        // 4x + 1024 to account for the possibility of some negative
        // compression.
        IntWrapper inpos = new IntWrapper();
        IntWrapper outpos = new IntWrapper();
        for (int k = 0; k < N; ++k) {
            int[] backupdata = Arrays.copyOf(data[k], data[k].length);

            inpos.set(1);
            outpos.set(0);
            if (!(c instanceof IntegratedIntegerCODEC)) {
                Delta.delta(backupdata);
            }
            c.compress(backupdata, inpos, backupdata.length - inpos.get(),
                    dataout, outpos);
            final int thiscompsize = outpos.get() + 1;
            inpos.set(0);
            outpos.set(1);
            buffer[0] = backupdata[0];
            co.uncompress(dataout, inpos, thiscompsize - 1, buffer, outpos);
            if (!(c instanceof IntegratedIntegerCODEC))
                Delta.fastinverseDelta(buffer);

            // Check assertions.
            assertEquals("length is not match", outpos.get(), data[k].length);
            int[] bufferCutout = Arrays.copyOf(buffer, outpos.get());
            assertArrayEquals("failed to reconstruct original data", data[k],
                    bufferCutout);
        }
    }

    /**
     * Test for unsorted array.
     */
    @Test
    public void testUnsortedExample() {
        testUnsorted(new VariableByte());
        testUnsorted(new IntegratedVariableByte());
        testUnsorted(new Composition(new BinaryPacking(), new VariableByte()));
        testUnsorted(new Composition(new NewPFD(), new VariableByte()));
        testUnsorted(new Composition(new NewPFDS9(), new VariableByte()));
        testUnsorted(new Composition(new NewPFDS16(), new VariableByte()));
        testUnsorted(new Composition(new OptPFD(), new VariableByte()));
        testUnsorted(new Composition(new OptPFDS9(), new VariableByte()));
        testUnsorted(new Composition(new OptPFDS16(), new VariableByte()));
        testUnsorted(new Composition(new FastPFOR128(), new VariableByte()));
        testUnsorted(new Composition(new FastPFOR(), new VariableByte()));

        testUnsorted(new IntegratedComposition(new IntegratedBinaryPacking(),
                new IntegratedVariableByte()));
        testUnsorted(new Composition(new IntegratedBinaryPacking(),
                new VariableByte()));

        testUnsorted2(new VariableByte());
        testUnsorted2(new IntegratedVariableByte());
        testUnsorted2(new Composition(new BinaryPacking(), new VariableByte()));
        testUnsorted2(new Composition(new NewPFD(), new VariableByte()));
        testUnsorted2(new Composition(new NewPFDS9(), new VariableByte()));
        testUnsorted2(new Composition(new NewPFDS16(), new VariableByte()));
        testUnsorted2(new Composition(new OptPFD(), new VariableByte()));
        testUnsorted2(new Composition(new OptPFDS9(), new VariableByte()));
        testUnsorted2(new Composition(new OptPFDS16(), new VariableByte()));
        testUnsorted2(new Composition(new FastPFOR128(), new VariableByte()));
        testUnsorted2(new Composition(new FastPFOR(), new VariableByte()));

        testUnsorted3(new IntegratedComposition(new IntegratedBinaryPacking(),
                new IntegratedVariableByte()));
        testUnsorted3(new Composition(new IntegratedBinaryPacking(),
                new VariableByte()));
        testUnsorted3(new VariableByte());
        testUnsorted3(new IntegratedVariableByte());
        testUnsorted3(new Composition(new BinaryPacking(), new VariableByte()));
        testUnsorted3(new Composition(new NewPFD(), new VariableByte()));
        testUnsorted3(new Composition(new NewPFDS9(), new VariableByte()));
        testUnsorted3(new Composition(new NewPFDS16(), new VariableByte()));
        testUnsorted3(new Composition(new OptPFD(), new VariableByte()));
        testUnsorted3(new Composition(new OptPFDS9(), new VariableByte()));
        testUnsorted3(new Composition(new OptPFDS16(), new VariableByte()));
        testUnsorted3(new Composition(new FastPFOR128(), new VariableByte()));
        testUnsorted3(new Composition(new FastPFOR(), new VariableByte()));

        testUnsorted2(new IntegratedComposition(new IntegratedBinaryPacking(),
                new IntegratedVariableByte()));
        testUnsorted2(new Composition(new IntegratedBinaryPacking(),
                new VariableByte()));

    }

    /**
     * @param codec
     *            provided codec
     */
    public void testUnsorted(IntegerCODEC codec) {
        int[] lengths = { 133, 1026, 1333333 };
        for (int N : lengths) {
            int[] data = new int[N];
            // initialize the data (most will be small)
            for (int k = 0; k < N; k += 1)
                data[k] = 3;
            // throw some larger values
            for (int k = 0; k < N; k += 5)
                data[k] = 100;
            for (int k = 0; k < N; k += 533)
                data[k] = 10000;
            data[5] = -311;
            // could need more compressing
            int[] compressed = new int[(int) Math.ceil(N * 1.01) + 1024];
            IntWrapper inputoffset = new IntWrapper(0);
            IntWrapper outputoffset = new IntWrapper(0);
            codec.compress(data, inputoffset, data.length, compressed,
                    outputoffset);
            // we can repack the data: (optional)
            compressed = Arrays.copyOf(compressed, outputoffset.intValue());

            int[] recovered = new int[N];
            IntWrapper recoffset = new IntWrapper(0);
            codec.uncompress(compressed, new IntWrapper(0), compressed.length,
                    recovered, recoffset);
            assertArrayEquals(data, recovered);
        }
    }

    private void testUnsorted2(IntegerCODEC codec) {
        int[] data = new int[128];
        data[5] = -1;
        int[] compressed = new int[1024];
        IntWrapper inputoffset = new IntWrapper(0);
        IntWrapper outputoffset = new IntWrapper(0);
        codec.compress(data, inputoffset, data.length, compressed, outputoffset);
        // we can repack the data: (optional)
        compressed = Arrays.copyOf(compressed, outputoffset.intValue());

        int[] recovered = new int[128];
        IntWrapper recoffset = new IntWrapper(0);
        codec.uncompress(compressed, new IntWrapper(0), compressed.length,
                recovered, recoffset);
        assertArrayEquals(data, recovered);
    }

    private void testUnsorted3(IntegerCODEC codec) {
        int[] data = new int[128];
        data[127] = -1;
        int[] compressed = new int[1024];
        IntWrapper inputoffset = new IntWrapper(0);
        IntWrapper outputoffset = new IntWrapper(0);
        codec.compress(data, inputoffset, data.length, compressed, outputoffset);
        // we can repack the data: (optional)
        compressed = Arrays.copyOf(compressed, outputoffset.intValue());

        int[] recovered = new int[128];
        IntWrapper recoffset = new IntWrapper(0);
        codec.uncompress(compressed, new IntWrapper(0), compressed.length,
                recovered, recoffset);
        assertArrayEquals(data, recovered);
    }

    /**
         * 
         */
    @Test
    public void fastPforTest() {
        // proposed by Stefan Ackermann (https://github.com/Stivo)
        FastPFOR codec1 = new FastPFOR();
        FastPFOR codec2 = new FastPFOR();
        int N = FastPFOR.BLOCK_SIZE;
        int[] data = new int[N];
        for (int i = 0; i < N; i++)
            data[i] = 0;
        data[126] = -1;
        int[] comp = TestUtils.compress(codec1, Arrays.copyOf(data, N));
        int[] answer = TestUtils.uncompress(codec2, comp, N);
        for (int k = 0; k < N; ++k)
            if (answer[k] != data[k])
                throw new RuntimeException("bug " + k + " " + answer[k]
                        + " != " + data[k]);
    }

    /**
     * 
     */
    @Test
    public void fastPfor128Test() {
        // proposed by Stefan Ackermann (https://github.com/Stivo)
        FastPFOR128 codec1 = new FastPFOR128();
        FastPFOR128 codec2 = new FastPFOR128();
        int N = FastPFOR128.BLOCK_SIZE;
        int[] data = new int[N];
        for (int i = 0; i < N; i++)
            data[i] = 0;
        data[126] = -1;
        int[] comp = TestUtils.compress(codec1, Arrays.copyOf(data, N));
        int[] answer = TestUtils.uncompress(codec2, comp, N);
        for (int k = 0; k < N; ++k)
            if (answer[k] != data[k])
                throw new RuntimeException("bug " + k + " " + answer[k]
                        + " != " + data[k]);
    }

}
