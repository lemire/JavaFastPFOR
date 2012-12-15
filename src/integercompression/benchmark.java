/**
 * This is code is released under the
 * Apache License Version 2.0 http://www.apache.org/licenses/.
 *
 * (c) Daniel Lemire, http://lemire.me/en/
 */
package integercompression;

import integercompression.synth.ClusteredDataGenerator;

import java.text.DecimalFormat;
import java.util.Arrays;

public class benchmark {

	public static void main(String args[]) {
		test(20, 18, 10);
	}

	public static void testCodec(IntegerCODEC c, int[][] data, int Max,
			int repeat, boolean verbose) {
		DecimalFormat df = new DecimalFormat("0.00");
		DecimalFormat dfspeed = new DecimalFormat("0");
		if (verbose)
			System.out.println("# " + c.toString());
		if (verbose)
			System.out
					.println("# bits per int, compress speed (mis), decompression speed (mis) ");
		long bef, aft;
		String line = "";
		int N = data.length;
		int totalsize = 0;
		int maxlength = 0;
		for (int k = 0; k < N; ++k) {
			totalsize += data[k].length;
			if (data[k].length > maxlength)
				maxlength = data[k].length;
		}
		int[] buffer = new int[maxlength + 1024];
		int[] dataout = new int[4 * maxlength + 1024];
		/* 4x + 1024 to account for the possibility of some negative compression */
		int size = 0;
		int comptime = 0;
		long decomptime = 0;
		IntWrapper inpos = new IntWrapper();
		IntWrapper outpos = new IntWrapper();
		for (int r = 0; r < repeat; ++r) {
			size = 0;
			for (int k = 0; k < N; ++k) {
				int[] backupdata = Arrays.copyOf(data[k], data[k].length);
				//
				bef = System.nanoTime() / 1000;
				inpos.set(1);
				outpos.set(0);
				if (!(c instanceof IntegratedIntegerCODEC)) {
					Delta.delta(backupdata);
				}
				c.compress(backupdata, inpos, backupdata.length - inpos.get(),
						dataout, outpos);
				aft = System.nanoTime() / 1000;
				//
				comptime += aft - bef;
				final int thiscompsize = outpos.get() + 1;
				size += thiscompsize;
				//
				bef = System.nanoTime() / 1000;
				inpos.set(0);
				outpos.set(1);
				buffer[0] = backupdata[0];
				c.uncompress(dataout, inpos, thiscompsize - 1, buffer, outpos);
				if (!(c instanceof IntegratedIntegerCODEC))
					Delta.fastinverseDelta(buffer);
				aft = System.nanoTime() / 1000;
				//
				decomptime += aft - bef;
				if (outpos.get() != data[k].length)
					throw new RuntimeException("we have a bug (diff length) "
							+ c + " expected " + data[k].length + " got "
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

		line += "\t" + df.format(size * 32.0 / totalsize);
		line += "\t" + dfspeed.format(totalsize * repeat / (comptime));
		line += "\t" + dfspeed.format(totalsize * repeat / (decomptime));
		if (verbose)
			System.out.println(line);
	}

	public static void test(int N, int nbr, int repeat) {
		ClusteredDataGenerator cdg = new ClusteredDataGenerator();
		for (int sparsity = 1; sparsity < 31 - nbr; sparsity += 1) {
			System.out.println("# sparsity " + sparsity);
			int[][] data = new int[N][];
			int Max = (1 << (nbr + sparsity));
			System.out.println("# generating random data...");
			for (int k = 0; k < N; ++k) {
				data[k] = cdg.generateClustered((1 << nbr), Max);
			}
			System.out.println("# generating random data... ok.");
			// building
			testCodec(new IntegratedComposition(new IntegratedBinaryPacking(),
					new IntegratedVariableByte()), data, Max, repeat, false);
			testCodec(new IntegratedComposition(new IntegratedBinaryPacking(),
					new IntegratedVariableByte()), data, Max, repeat, false);
			testCodec(new IntegratedComposition(new IntegratedBinaryPacking(),
					new IntegratedVariableByte()), data, Max, repeat, true);
			System.out.println();

			
			testCodec(new JustCopy(), data, Max, repeat, false);
			testCodec(new JustCopy(), data, Max, repeat, false);
			testCodec(new JustCopy(), data, Max, repeat, true);
			System.out.println();

			testCodec(new VariableByte(), data, Max, repeat, false);
			testCodec(new VariableByte(), data, Max, repeat, false);
			testCodec(new VariableByte(), data, Max, repeat, true);
			System.out.println();

			testCodec(new IntegratedVariableByte(), data, Max, repeat, false);
			testCodec(new IntegratedVariableByte(), data, Max, repeat, false);
			testCodec(new IntegratedVariableByte(), data, Max, repeat, true);
			System.out.println();


			testCodec(new Composition(new BinaryPacking(), new VariableByte()),
					data, Max, repeat, false);
			testCodec(new Composition(new BinaryPacking(), new VariableByte()),
					data, Max, repeat, false);
			testCodec(new Composition(new BinaryPacking(), new VariableByte()),
					data, Max, repeat, true);
			System.out.println();

			testCodec(new Composition(new NewPFD(), new VariableByte()), data,
					Max, repeat, false);
			testCodec(new Composition(new NewPFD(), new VariableByte()), data,
					Max, repeat, false);
			testCodec(new Composition(new NewPFD(), new VariableByte()), data,
					Max, repeat, true);
			System.out.println();

			testCodec(new Composition(new OptPFD(), new VariableByte()), data,
					Max, repeat, false);
			testCodec(new Composition(new OptPFD(), new VariableByte()), data,
					Max, repeat, false);
			testCodec(new Composition(new OptPFD(), new VariableByte()), data,
					Max, repeat, true);
			System.out.println();

			testCodec(new Composition(new FastPFOR(), new VariableByte()),
					data, Max, repeat, false);
			testCodec(new Composition(new FastPFOR(), new VariableByte()),
					data, Max, repeat, false);
			testCodec(new Composition(new FastPFOR(), new VariableByte()),
					data, Max, repeat, true);
			System.out.println();

			testCodec(new Simple9(), data, Max, repeat, false);
			testCodec(new Simple9(), data, Max, repeat, false);
			testCodec(new Simple9(), data, Max, repeat, true);
			System.out.println();

		}
	}
}
