package me.lemire.integercompression;

/**
 * This is an implementation of the popular Simple16 scheme. It is limited to
 * 28-bit integers (between 0 and 2^28-1).
 * 
 * Note that this does not use differential coding: if you are working on sorted
 * lists, you must compute the deltas separately.
 * 
 * <p>
 * Adapted by D. Lemire from the Apache Lucene project.
 * </p>
 */
public final class Simple16 implements IntegerCODEC, SkippableIntegerCODEC {

	public void headlessCompress(int[] in, IntWrapper inpos, int inlength, int out[], IntWrapper outpos) {
		int i_inpos = inpos.get();
		int i_outpos = outpos.get();
		final int finalin = i_inpos + inlength;
		while (i_inpos < finalin) {
			int inoffset = compressblock(out, i_outpos++, in, i_inpos, inlength);
			if (inoffset == -1)
				throw new RuntimeException("Too big a number");
			i_inpos += inoffset;
			inlength -= inoffset;
		}
		inpos.set(i_inpos);
		outpos.set(i_outpos);
	}

	/**
	 * Compress an integer array using Simple16
	 * 
	 * @param out
	 *            the compressed output
	 * @param outOffset
	 *            the offset of the output in the number of integers
	 * @param in
	 *            the integer input array
	 * @param inOffset
	 *            the offset of the input in the number of integers
	 * @param n
	 *            the number of elements to be compressed
	 * @return the number of compressed integers
	 */
	public static final int compressblock(int[] out, int outOffset, int[] in, int inOffset, int n) {
		int numIdx, j, num, bits;
		for (numIdx = 0; numIdx < S16_NUMSIZE; numIdx++) {
			out[outOffset] = numIdx << S16_BITSSIZE;
			num = (S16_NUM[numIdx] < n) ? S16_NUM[numIdx] : n;

			for (j = 0, bits = 0; (j < num) && (in[inOffset + j] < SHIFTED_S16_BITS[numIdx][j]);) {
				out[outOffset] |= (in[inOffset + j] << bits);
				bits += S16_BITS[numIdx][j];
				j++;
			}

			if (j == num) {
				return num;
			}
		}

		return -1;
	}

	/**
	 * Decompress an integer array using Simple16
	 * 
	 * @param out
	 *            the decompressed output
	 * @param outOffset
	 *            the offset of the output in the number of integers
	 * @param in
	 *            the compressed input array
	 * @param inOffset
	 *            the offset of the input in the number of integers
	 * @param n
	 *            the number of elements to be compressed
	 * @return the number of processed integers
	 */
	public static final int decompressblock(int[] out, int outOffset, int[] in, int inOffset, int n) {
		int numIdx, j = 0, bits = 0;
		numIdx = in[inOffset] >>> S16_BITSSIZE;
		int num = S16_NUM[numIdx] < n ? S16_NUM[numIdx] : n;
		for (j = 0, bits = 0; j < num; j++) {
			out[outOffset + j] = (in[inOffset] >>> bits) & (0xffffffff >>> (32 - S16_BITS[numIdx][j]));
			bits += S16_BITS[numIdx][j];
		}
		return num;
	}

	@Override
	public void headlessUncompress(int[] in, IntWrapper inpos, int inlength, int[] out, IntWrapper outpos, int num) {
		int i_inpos = inpos.get();
		int i_outpos = outpos.get();
		while (num > 0) {
			final int howmany = decompressblock(out, i_outpos, in, i_inpos, num);
			num -= howmany;
			i_outpos += howmany;
			i_inpos++;
		}
		inpos.set(i_inpos);
		outpos.set(i_outpos);
	}

	/**
	 * Uncompress data from an array to another array.
	 * 
	 * Both inpos and outpos parameters are modified to indicate new positions
	 * after read/write.
	 * 
	 * @param in
	 *            array containing data in compressed form
	 * @param tmpinpos
	 *            where to start reading in the array
	 * @param inlength
	 *            length of the compressed data (ignored by some schemes)
	 * @param out
	 *            array where to write the compressed output
	 * @param currentPos
	 *            where to write the compressed output in out
	 * @param outlength
	 *            number of integers we want to decode
	 */
	public static void uncompress(int[] in, int tmpinpos, int inlength, int[] out, int currentPos, int outlength) {
		final int finalpos = tmpinpos + inlength;
		while (tmpinpos < finalpos) {
			final int howmany = decompressblock(out, currentPos, in, tmpinpos, outlength);
			outlength -= howmany;
			currentPos += howmany;
			tmpinpos += 1;
		}

	}

	private static int[][] shiftme(int[][] x) {
		int[][] answer = new int[x.length][];
		for (int k = 0; k < x.length; ++k) {
			answer[k] = new int[x[k].length];
			for (int z = 0; z < answer[k].length; ++z)
				answer[k][z] = 1 << x[k][z];
		}
		return answer;
	}

	@Override
	public void compress(int[] in, IntWrapper inpos, int inlength, int[] out, IntWrapper outpos) {
		if (inlength == 0)
			return;
		out[outpos.get()] = inlength;
		outpos.increment();
		headlessCompress(in, inpos, inlength, out, outpos);
	}

	@Override
	public void uncompress(int[] in, IntWrapper inpos, int inlength, int[] out, IntWrapper outpos) {
		if (inlength == 0)
			return;
		final int outlength = in[inpos.get()];
		inpos.increment();
		headlessUncompress(in, inpos, inlength, out, outpos, outlength);

	}

	@Override
	public String toString() {
		return this.getClass().getSimpleName();
	}

	private static final int S16_NUMSIZE = 16;
	private static final int S16_BITSSIZE = 28;
	// the possible number of bits used to represent one integer
	private static final int[] S16_NUM = { 28, 21, 21, 21, 14, 9, 8, 7, 6, 6, 5, 5, 4, 3, 2, 1 };
	// the corresponding number of elements for each value of the number of bits
	private static final int[][] S16_BITS = {
			{ 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
			{ 2, 2, 2, 2, 2, 2, 2, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
			{ 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 1, 1, 1, 1, 1, 1, 1 },
			{ 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2 },
			{ 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2 }, { 4, 3, 3, 3, 3, 3, 3, 3, 3 }, { 3, 4, 4, 4, 4, 3, 3, 3 },
			{ 4, 4, 4, 4, 4, 4, 4 }, { 5, 5, 5, 5, 4, 4 }, { 4, 4, 5, 5, 5, 5 }, { 6, 6, 6, 5, 5 }, { 5, 5, 6, 6, 6 },
			{ 7, 7, 7, 7 }, { 10, 9, 9, }, { 14, 14 }, { 28 } };
	private static final int[][] SHIFTED_S16_BITS = shiftme(S16_BITS);

}