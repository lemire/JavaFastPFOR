package me.lemire.integercompression;

import me.lemire.integercompression.differential.*;
import java.util.*;

import org.junit.Test;

/**
 * 
 *
 */
public class ExampleTest {
	/**
	 * 
	 */
	@Test

	public void superSimpleExample() {
		IntegratedIntCompressor iic = new IntegratedIntCompressor();
		int[] data = new int[2342351];
		for (int k = 0; k < data.length; ++k)
			data[k] = k;
		System.out.println("Compressing " + data.length + " integers using friendly interface");
		int[] compressed = iic.compress(data);
		int[] recov = iic.uncompress(compressed);
		System.out
				.println("compressed from " + data.length * 4 / 1024 + "KB to " + compressed.length * 4 / 1024 + "KB");
		if (!Arrays.equals(recov, data))
			throw new RuntimeException("bug");
	}

	/**
	 * 
	 */
	@Test

	public void basicExample() {
		int[] data = new int[2342351];
		System.out.println("Compressing " + data.length + " integers in one go");
		// data should be sorted for best
		// results
		for (int k = 0; k < data.length; ++k)
			data[k] = k;
		// Very important: the data is in sorted order!!! If not, you
		// will get very poor compression with IntegratedBinaryPacking,
		// you should use another CODEC.

		// next we compose a CODEC. Most of the processing
		// will be done with binary packing, and leftovers will
		// be processed using variable byte
		IntegratedIntegerCODEC codec = new IntegratedComposition(new IntegratedBinaryPacking(),
				new IntegratedVariableByte());
		// output vector should be large enough...
		int[] compressed = new int[data.length + 1024];
		// compressed might not be large enough in some cases
		// if you get java.lang.ArrayIndexOutOfBoundsException, try
		// allocating more memory

		/**
		 *
		 * compressing
		 *
		 */
		IntWrapper inputoffset = new IntWrapper(0);
		IntWrapper outputoffset = new IntWrapper(0);
		codec.compress(data, inputoffset, data.length, compressed, outputoffset);
		// got it!
		// inputoffset should be at data.length but outputoffset tells
		// us where we are...
		System.out.println(
				"compressed from " + data.length * 4 / 1024 + "KB to " + outputoffset.intValue() * 4 / 1024 + "KB");
		// we can repack the data: (optional)
		compressed = Arrays.copyOf(compressed, outputoffset.intValue());

		/**
		 *
		 * now uncompressing
		 *
		 * This assumes that we otherwise know how many integers have been
		 * compressed. See basicExampleHeadless for a more general case.
		 */
		int[] recovered = new int[data.length];
		IntWrapper recoffset = new IntWrapper(0);
		codec.uncompress(compressed, new IntWrapper(0), compressed.length, recovered, recoffset);
		if (Arrays.equals(data, recovered))
			System.out.println("data is recovered without loss");
		else
			throw new RuntimeException("bug"); // could use assert
		System.out.println();
	}

	/**
	 * Like the basicExample, but we store the input array size manually.
	 */
	@Test
	public void basicExampleHeadless() {
		int[] data = new int[2342351];
		System.out.println("Compressing " + data.length + " integers in one go using the headless approach");
		// data should be sorted for best
		// results
		for (int k = 0; k < data.length; ++k)
			data[k] = k;
		// Very important: the data is in sorted order!!! If not, you
		// will get very poor compression with IntegratedBinaryPacking,
		// you should use another CODEC.

		// next we compose a CODEC. Most of the processing
		// will be done with binary packing, and leftovers will
		// be processed using variable byte
		SkippableIntegratedComposition codec = new SkippableIntegratedComposition(new IntegratedBinaryPacking(),
				new IntegratedVariableByte());
		// output vector should be large enough...
		int[] compressed = new int[data.length + 1024];
		// compressed might not be large enough in some cases
		// if you get java.lang.ArrayIndexOutOfBoundsException, try
		// allocating more memory

		/**
		 *
		 * compressing
		 *
		 */
		IntWrapper inputoffset = new IntWrapper(0);
		IntWrapper outputoffset = new IntWrapper(1);
		compressed[0] = data.length; // we manually store how many integers we
		codec.headlessCompress(data, inputoffset, data.length, compressed, outputoffset, new IntWrapper(0));					
		// got it!
		// inputoffset should be at data.length but outputoffset tells
		// us where we are...
		System.out.println(
				"compressed from " + data.length * 4 / 1024 + "KB to " + outputoffset.intValue() * 4 / 1024 + "KB");
		// we can repack the data: (optional)
		compressed = Arrays.copyOf(compressed, outputoffset.intValue());

		/**
		 *
		 * now uncompressing
		 *
		 */
		int howmany = compressed[0];// we manually stored the number of
									// compressed integers
		int[] recovered = new int[howmany];
		IntWrapper recoffset = new IntWrapper(0);
		codec.headlessUncompress(compressed, new IntWrapper(1), compressed.length, recovered, recoffset, howmany, new IntWrapper(0));
		if (Arrays.equals(data, recovered))
			System.out.println("data is recovered without loss");
		else
			throw new RuntimeException("bug"); // could use assert
		System.out.println();
	}

	/**
	 * This is an example to show you can compress unsorted integers as long as
	 * most are small.
	 */
	@Test
	public void unsortedExample() {
		final int N = 1333333;
		int[] data = new int[N];
		// initialize the data (most will be small
		for (int k = 0; k < N; k += 1)
			data[k] = 3;
		// throw some larger values
		for (int k = 0; k < N; k += 5)
			data[k] = 100;
		for (int k = 0; k < N; k += 533)
			data[k] = 10000;
		int[] compressed = new int[N + 1024];// could need more
		IntegerCODEC codec = new Composition(new FastPFOR(), new VariableByte());
		// compressing
		IntWrapper inputoffset = new IntWrapper(0);
		IntWrapper outputoffset = new IntWrapper(0);
		codec.compress(data, inputoffset, data.length, compressed, outputoffset);
		System.out.println("compressed unsorted integers from " + data.length * 4 / 1024 + "KB to "
				+ outputoffset.intValue() * 4 / 1024 + "KB");
		// we can repack the data: (optional)
		compressed = Arrays.copyOf(compressed, outputoffset.intValue());

		int[] recovered = new int[N];
		IntWrapper recoffset = new IntWrapper(0);
		codec.uncompress(compressed, new IntWrapper(0), compressed.length, recovered, recoffset);
		if (Arrays.equals(data, recovered))
			System.out.println("data is recovered without loss");
		else
			throw new RuntimeException("bug"); // could use assert
		System.out.println();

	}

	/**
	 * This is like the basic example, but we show how to process larger arrays
	 * in chunks.
	 *
	 * Some of this code was written by Pavel Klinov.
	 */
	@Test
	public void advancedExample() {
		int TotalSize = 2342351; // some arbitrary number
		int ChunkSize = 16384; // size of each chunk, choose a multiple of 128
		System.out.println("Compressing " + TotalSize + " integers using chunks of " + ChunkSize + " integers ("
				+ ChunkSize * 4 / 1024 + "KB)");
		System.out.println("(It is often better for applications to work in chunks fitting in CPU cache.)");
		int[] data = new int[TotalSize];
		// data should be sorted for best
		// results
		for (int k = 0; k < data.length; ++k)
			data[k] = k;
		// next we compose a CODEC. Most of the processing
		// will be done with binary packing, and leftovers will
		// be processed using variable byte, using variable byte
		// only for the last chunk!
		IntegratedIntegerCODEC regularcodec = new IntegratedBinaryPacking();
		IntegratedVariableByte ivb = new IntegratedVariableByte();
		IntegratedIntegerCODEC lastcodec = new IntegratedComposition(regularcodec, ivb);
		// output vector should be large enough...
		int[] compressed = new int[TotalSize + 1024];

		/**
		 *
		 * compressing
		 *
		 */
		IntWrapper inputoffset = new IntWrapper(0);
		IntWrapper outputoffset = new IntWrapper(0);
		for (int k = 0; k < TotalSize / ChunkSize; ++k)
			regularcodec.compress(data, inputoffset, ChunkSize, compressed, outputoffset);
		lastcodec.compress(data, inputoffset, TotalSize % ChunkSize, compressed, outputoffset);
		// got it!
		// inputoffset should be at data.length but outputoffset tells
		// us where we are...
		System.out.println(
				"compressed from " + data.length * 4 / 1024 + "KB to " + outputoffset.intValue() * 4 / 1024 + "KB");
		// we can repack the data:
		compressed = Arrays.copyOf(compressed, outputoffset.intValue());

		/**
		 *
		 * now uncompressing
		 *
		 * We are *not* assuming that the original array length is known,
		 * however we assume that the chunk size (ChunkSize) is known.
		 *
		 */
		int[] recovered = new int[ChunkSize];
		IntWrapper compoff = new IntWrapper(0);
		IntWrapper recoffset;
		int currentpos = 0;

		while (compoff.get() < compressed.length) {
			recoffset = new IntWrapper(0);
			regularcodec.uncompress(compressed, compoff, compressed.length - compoff.get(), recovered, recoffset);

			if (recoffset.get() < ChunkSize) {// last chunk detected
				ivb.uncompress(compressed, compoff, compressed.length - compoff.get(), recovered, recoffset);
			}
			for (int i = 0; i < recoffset.get(); ++i) {
				if (data[currentpos + i] != recovered[i])
					throw new RuntimeException("bug"); // could use assert
			}
			currentpos += recoffset.get();
		}
		System.out.println("data is recovered without loss");
		System.out.println();

	}

	/**
	 * Demo of the headless approach where we must supply the array length
	 */
	@Test
	public void headlessDemo() {
		System.out.println("Compressing arrays with minimal header...");
		int[] uncompressed1 = { 1, 2, 1, 3, 1 };
		int[] uncompressed2 = { 3, 2, 4, 6, 1 };

		int[] compressed = new int[uncompressed1.length + uncompressed2.length + 1024];

		SkippableIntegerCODEC codec = new SkippableComposition(new BinaryPacking(), new VariableByte());

		// compressing
		IntWrapper outPos = new IntWrapper();

		IntWrapper previous = new IntWrapper();

		codec.headlessCompress(uncompressed1, new IntWrapper(), uncompressed1.length, compressed, outPos);
		int length1 = outPos.get() - previous.get();
		previous = new IntWrapper(outPos.get());
		codec.headlessCompress(uncompressed2, new IntWrapper(), uncompressed2.length, compressed, outPos);
		int length2 = outPos.get() - previous.get();

		compressed = Arrays.copyOf(compressed, length1 + length2);
		System.out
				.println("compressed unsorted integers from " + uncompressed1.length * 4 + "B to " + length1 * 4 + "B");
		System.out
				.println("compressed unsorted integers from " + uncompressed2.length * 4 + "B to " + length2 * 4 + "B");
		System.out.println("Total compressed output " + compressed.length);

		int[] recovered1 = new int[uncompressed1.length];
		int[] recovered2 = new int[uncompressed1.length];
		IntWrapper inPos = new IntWrapper();
		System.out.println("Decoding first array starting at pos = " + inPos);
		codec.headlessUncompress(compressed, inPos, compressed.length, recovered1, new IntWrapper(0),
				uncompressed1.length);
		System.out.println("Decoding second array starting at pos = " + inPos);
		codec.headlessUncompress(compressed, inPos, compressed.length, recovered2, new IntWrapper(0),
				uncompressed2.length);
		if (!Arrays.equals(uncompressed1, recovered1))
			throw new RuntimeException("First array does not match.");
		if (!Arrays.equals(uncompressed2, recovered2))
			throw new RuntimeException("Second array does not match.");
		System.out.println("The arrays match, your code is probably ok.");

	}
}
