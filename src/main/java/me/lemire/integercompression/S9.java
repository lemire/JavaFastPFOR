/**
 * This code is released under the
 * Apache License Version 2.0 http://www.apache.org/licenses/.
 *
 * (c) Daniel Lemire, http://lemire.me/en/
 */
package me.lemire.integercompression;

/**
 * This is a version of Simple9 optimized for NewPFOR, OptPFOR
 * <p>
 * Adapted by D. Lemire from the Apache Lucene project.
 * </p>
 * 
 * @author Daniel Lemire
 */
public final class S9 {


	/**
	 * Estimate size of the compressed output.
	 * 
	 * @param in
	 *            array to compress
	 * @param currentPos
	 *            where to start reading
	 * @param inlength
	 *            how many integers to read
	 * @return estimated size of the output (in 32-bit integers)
	 */
	public static int estimatecompress(int[] in, int currentPos, int inlength) {
		int tmpoutpos = 0;
		int finalpos = currentPos + inlength;
		outer: while (currentPos < finalpos) {
			mainloop: for (int selector = 0; selector < 8; selector++) {

				int compressedNum = codeNum[selector];
				if (finalpos <= currentPos + compressedNum - 1)
					compressedNum = finalpos - currentPos;
				int b = bitLength[selector];
				int max = 1 << b;
				int i = 0;
				for (; i < compressedNum; i++)
					if (Util.smallerorequalthan(max , in[currentPos + i]))
						continue mainloop;
				currentPos += compressedNum;
				++tmpoutpos;
				continue outer;
			}
			final int selector = 8;
			if (in[currentPos] >= 1 << bitLength[selector])
				throw new RuntimeException("Too big a number");
			tmpoutpos++;
			currentPos++;

		}
		return tmpoutpos;
	}

	/**
	 * Compress an integer array using Simple9
	 *
	 * 
	 * @param in
	 *            array to compress
	 * @param currentPos
	 *            where to start reading
	 * @param inlength
	 *            how many integers to read
	 * @param out
	 *            output array
	 * @param tmpoutpos
	 *            location in the output array
	 * @return the number of 32-bit words written (in compressed form)
	 */
	public static int compress(int[] in, int currentPos, int inlength, int out[], int tmpoutpos) {
		int origtmpoutpos = tmpoutpos;
		int finalpos = currentPos + inlength;
		outer: while (currentPos < finalpos) {
			mainloop: for (int selector = 0; selector < 8; selector++) {
				int res = 0;
				int compressedNum = codeNum[selector];
				if (finalpos <= currentPos + compressedNum - 1)
					compressedNum = finalpos - currentPos;
				int b = bitLength[selector];
				int max = 1 << b;
				int i = 0;
				for (; i < compressedNum; i++) {
					if (Util.smallerorequalthan(max, in[currentPos + i]))
						continue mainloop;
					res = (res << b) + in[currentPos + i];
				}
				if (compressedNum != codeNum[selector])
					res <<= (codeNum[selector] - compressedNum) * b;
				res |= selector << 28;
				out[tmpoutpos++] = res;
				currentPos += compressedNum;
				continue outer;
			}
			final int selector = 8;
			if (in[currentPos] >= 1 << bitLength[selector])
				throw new RuntimeException("Too big a number");
			out[tmpoutpos++] = in[currentPos++] | (selector << 28);
		}
		return tmpoutpos - origtmpoutpos;
	}

	/**
	 * Uncompressed data from an input array into an output array
	 * 
	 * @param in
	 *            input array (in compressed form)
	 * @param tmpinpos
	 *            starting location in the compressed input array
	 * @param inlength
	 *            how much data we wish the read (in 32-bit words)
	 * @param out
	 *            output array (in decompressed form)
	 * @param currentPos
	 *            current position in the output array
	 * @param outlength
	 *            available data in the output array
	 */
	public static void uncompress(int[] in, int tmpinpos, int inlength, int[] out, int currentPos, int outlength) {
		int finallength = currentPos + outlength;

		while (currentPos < finallength) {
			int val = in[tmpinpos++];
			int header = val >>> 28;
			switch (header) {
			case 0: { // number : 28, bitwidth : 1
				final int howmany = finallength - currentPos < 28 ? finallength - currentPos : 28;
				for (int k = 0; k < howmany; ++k) {
					out[currentPos++] = (val << (k + 4)) >>> 31;
				}
				break;
			}
			case 1: { // number : 14, bitwidth : 2
				final int howmany = finallength - currentPos < 14 ? finallength - currentPos : 14;
				for (int k = 0; k < howmany; ++k) {
					out[currentPos++] = (val << (2 * k + 4)) >>> 30;
				}
				break;
			}
			case 2: { // number : 9, bitwidth : 3
				final int howmany = finallength - currentPos < 9 ? finallength - currentPos : 9;
				for (int k = 0; k < howmany; ++k) {
					out[currentPos++] = (val << (3 * k + 5)) >>> 29;
				}
				break;
			}
			case 3: { // number : 7, bitwidth : 4
				final int howmany = finallength - currentPos < 7 ? finallength - currentPos : 7;
				for (int k = 0; k < howmany; ++k) {
					out[currentPos++] = (val << (4 * k + 4)) >>> 28;
				}
				break;
			}
			case 4: { // number : 5, bitwidth : 5
				final int howmany = finallength - currentPos < 5 ? finallength - currentPos : 5;
				for (int k = 0; k < howmany; ++k) {
					out[currentPos++] = (val << (5 * k + 7)) >>> 27;
				}
				break;
			}
			case 5: { // number : 4, bitwidth : 7
				final int howmany = finallength - currentPos < 4 ? finallength - currentPos : 4;
				for (int k = 0; k < howmany; ++k) {
					out[currentPos++] = (val << (7 * k + 4)) >>> 25;
				}
				break;
			}
			case 6: { // number : 3, bitwidth : 9
				final int howmany = finallength - currentPos < 3 ? finallength - currentPos : 3;
				for (int k = 0; k < howmany; ++k) {
					out[currentPos++] = (val << (9 * k + 5)) >>> 23;
				}
				break;
			}
			case 7: { // number : 2, bitwidth : 14
				final int howmany = finallength - currentPos < 2 ? finallength - currentPos : 2;
				for (int k = 0; k < howmany; ++k) {
					out[currentPos++] = (val << (14 * k + 4)) >>> 18;
				}
				break;
			}
			case 8: { // number : 1, bitwidth : 28
				out[currentPos++] = (val << 4) >>> 4;
				break;
			}
			default: {
				throw new RuntimeException("shouldn't happen");
			}
			}
		}

	}

	private final static int bitLength[] = { 1, 2, 3, 4, 5, 7, 9, 14, 28 };

	private final static int codeNum[] = { 28, 14, 9, 7, 5, 4, 3, 2, 1 };

}
