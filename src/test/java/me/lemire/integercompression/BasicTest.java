package me.lemire.integercompression;

import java.util.Arrays;
import java.util.Random;

import me.lemire.integercompression.synth.ClusteredDataGenerator;

import org.junit.Test;

/**
 * Just some basic sanity tests.
 * 
 * @author Daniel Lemire
 *
 */
public class BasicTest {
	
	/**
	 * Verify bitpacking
	 */
	@SuppressWarnings("static-method")
	@Test
	public void verify() {
        System.out.println("Checking the code...");
        final int N = 32;
        final int times = 1000;
        Random r = new Random();
        int[] data = new int[N];
        int[] compressed = new int[N];
        int[] uncompressed = new int[N];
        for (int bit = 0; bit < 31; ++bit) {
            for (int t = 0; t < times; ++t) {
                for (int k = 0; k < N; ++k) {
                    data[k] = r.nextInt(1 << bit);
                }
                BitPacking.fastpack(data, 0, compressed, 0, bit);
                BitPacking.fastunpack(compressed, 0, uncompressed, 0, bit);
                if (!Arrays.equals(uncompressed, data)) {
                    throw new RuntimeException("bug " + bit);
                }
            }
        }
        System.out.println("Code appears to be correct.");
    }

	/**
	 * Verify bitpacking without mask
	 */
	@SuppressWarnings("static-method")
	@Test
	public void verifyWithoutMask() {
        System.out.println("Checking the code...");
        final int N = 32;
        final int times = 1000;
        Random r = new Random();
        int[] data = new int[N];
        int[] compressed = new int[N];
        int[] uncompressed = new int[N];
        for (int bit = 0; bit < 31; ++bit) {
            for (int t = 0; t < times; ++t) {
                for (int k = 0; k < N; ++k) {
                    data[k] = r.nextInt(1 << bit);
                }
                BitPacking.fastpackwithoutmask(data, 0, compressed, 0, bit);
                BitPacking.fastunpack(compressed, 0, uncompressed, 0, bit);
                if (!Arrays.equals(uncompressed, data)) {
                    throw new RuntimeException("bug " + bit);
                }
            }
        }
        System.out.println("Code appears to be correct.");
    }

	/**
	 * Verify bitpacking with exception
	 */
	@SuppressWarnings("static-method")
	@Test
	public void verifyWithExceptions() {
        System.out.println("Checking the code...");
        final int N = 32;
        final int times = 1000;
        Random r = new Random();
        int[] data = new int[N];
        int[] compressed = new int[N];
        int[] uncompressed = new int[N];
        for (int bit = 0; bit < 31; ++bit) {
            for (int t = 0; t < times; ++t) {
                for (int k = 0; k < N; ++k) {
                    data[k] = r.nextInt();
                }
                BitPacking.fastpack(data, 0, compressed, 0, bit);
                BitPacking.fastunpack(compressed, 0, uncompressed, 0, bit);
                for (int k = 0; k < N; ++k) {
                    if ((data[k] & ((1 << bit) - 1)) != uncompressed[k]) {
                        for (int k2 = 0; k2 < N; ++k2) {
                            System.out.println((data[k] & ((1 << bit) - 1)) + " " + uncompressed[k]);
                        }
                        System.out.println(compressed[0]);
                        throw new RuntimeException("bug " + bit);
                    }
                }
            }
        }
        System.out.println("Code with overflow appears to be correct.");
    }

	/**
	 * check that the codecs can be inverted.
	 */
	@SuppressWarnings("static-method")
	@Test
	public void basictest() {
		test(5, 10);
		test(5, 14);
		test(2, 18);
	}
	/**
	 * check that there is no spurious output.
	 */
	@SuppressWarnings("static-method")
	@Test
	public void spuriousouttest() {
		testSpurious(new IntegratedBinaryPacking());
		testSpurious(new BinaryPacking());
		testSpurious(new NewPFD());
		testSpurious(new NewPFDS9());
		testSpurious(new OptPFD());
		testSpurious(new OptPFDS9());
		testSpurious(new FastPFOR());
	}
	
	private static void testSpurious(IntegerCODEC c) {
		int[] x = new int[1024];
		int[] y = new int[0];
		IntWrapper i0 = new IntWrapper(0);
		IntWrapper i1 = new IntWrapper(0);
		for(int inlength = 0; inlength <128;++inlength) {
			c.compress(x, i0, inlength,y,i1);
		}
	}

	private static void test(int N, int nbr) {
		ClusteredDataGenerator cdg = new ClusteredDataGenerator();
		for (int sparsity = 1; sparsity < 31 - nbr; sparsity += 4) {
			System.out.println("#testing sparsity "+sparsity);
			int[][] data = new int[N][];
			int Max = (1 << (nbr + sparsity));
			for (int k = 0; k < N; ++k) {
				data[k] = cdg.generateClustered((1 << nbr), Max);
			}

			testCodec(new IntegratedComposition(new IntegratedBinaryPacking(),
					new IntegratedVariableByte()), data, Max);
			testCodec(new JustCopy(), data, Max);
			testCodec(new VariableByte(), data, Max);
			testCodec(new IntegratedVariableByte(), data, Max);
			testCodec(new Composition(new BinaryPacking(), new VariableByte()),
					data, Max);
			testCodec(new Composition(new NewPFD(), new VariableByte()), data,
					Max);
			testCodec(new Composition(new NewPFDS9(), new VariableByte()),
					data, Max);
			testCodec(new Composition(new OptPFD(), new VariableByte()), data,
					Max);
			testCodec(new Composition(new OptPFDS9(), new VariableByte()),
					data, Max);
			testCodec(new Composition(new FastPFOR(), new VariableByte()),
					data, Max);
			testCodec(new Simple9(), data, Max);
		}
	}

	private static void testCodec(IntegerCODEC c, int[][] data, int Max) {
		int N = data.length;
		int maxlength = 0;
		for (int k = 0; k < N; ++k) {
			if (data[k].length > maxlength)
				maxlength = data[k].length;
		}
		int[] buffer = new int[maxlength + 1024];
		int[] dataout = new int[4 * maxlength + 1024];
		/* 4x + 1024 to account for the possibility of some negative compression */
		IntWrapper inpos = new IntWrapper();
		IntWrapper outpos = new IntWrapper();
		for (int k = 0; k < N; ++k) {
			int[] backupdata = Arrays.copyOf(data[k], data[k].length);
			//
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
			c.uncompress(dataout, inpos, thiscompsize - 1, buffer, outpos);
			if (!(c instanceof IntegratedIntegerCODEC))
				Delta.fastinverseDelta(buffer);
			//
			if (outpos.get() != data[k].length)
				throw new RuntimeException("we have a bug (diff length) " + c
						+ " expected " + data[k].length + " got "
						+ outpos.get());
			for (int m = 0; m < outpos.get(); ++m)
				if (buffer[m] != data[k][m]) {
					throw new RuntimeException(
							"we have a bug (actual difference), expected "
									+ data[k][m] + " found " + buffer[m]
									+ " at " + m);
				}

		}
	}

}
