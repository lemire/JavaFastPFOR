package me.lemire.integercompression;

/**
 * Group Simple 9 is a variation on Simple 9 that preserves the same
 * compression ratios but offers higher decoding speed by regrouping
 * the 32-bit words into pairs of 64-bit words.
 * 
 * original by Kun Jiang, Yuexiang Yang and Qinghua Zheng source:
 * https://github.com/deeper2/simple
 * 
 * Adapted by D. Lemire.
 */

public final class GroupSimple9 implements IntegerCODEC, SkippableIntegerCODEC {

	private static final int[][] M = { { 0, 1, 2, 3, 4, 5, 6, 7, 8 }, { 9, 10, 11, 12, 13, 14, 15, 16, 17 },
			{ 18, 19, 20, 21, 22, 23, 24, 25, 26 }, { 27, 28, 29, 30, 31, 32, 33, 34, 35 },
			{ 36, 37, 38, 39, 40, 41, 42, 43, 44 }, { 45, 46, 47, 48, 49, 50, 51, 52, 53 },
			{ 54, 55, 56, 57, 58, 59, 60, 61, 62 }, { 63, 64, 65, 66, 67, 68, 69, 70, 71 },
			{ 72, 73, 74, 75, 76, 77, 78, 79, 80 } };

	@Override
	public void compress(int[] in, IntWrapper inpos, int inlength, int out[], IntWrapper outpos) {
		if (inlength == 0)
			return;
		out[outpos.get()] = inlength;
		outpos.increment();
		headlessCompress(in, inpos, inlength, out, outpos);
	}

	private void encode0(final int[] in, final int inf, final int code, final int[] out,
			final int outf) {
		for (int i = 0; i < 24; i++)
			out[outf + 0] = (out[outf + 0] << 1) + (in[inf + i]);
		for (int i = 0; i < 4; i++)
			out[outf + 1] = (out[outf + 1] << 1) + in[inf + 24 + i];
		for (int i = 0; i < 28; i++)
			out[outf + 1] = (out[outf + 1] << 1) + in[inf + 28 + i];
		out[outf + 0] = code << 24 | out[outf + 0];
		
	}

	private void encode1(final int[] in, final int inf, final int code, final int[] out,
			final int outf) {
		for (int i = 0; i < 24; i++)
			out[outf + 0] = (out[outf + 0] << 1) + in[inf + i];
		for (int i = 0; i < 4; i++)
			out[outf + 1] = (out[outf + 1] << 1) + in[inf + 24 + i];
		for (int i = 0; i < 14; i++)
			out[outf + 1] = (out[outf + 1] << 2) + in[inf + 28 + i];
		out[outf + 0] = code << 24 | out[outf + 0];
		
	}

	private void encode2(final int[] in, final int inf, final int code, final int[] out,
			final int outf) {
		for (int i = 0; i < 24; i++)
			out[outf + 0] = (out[outf + 0] << 1) + in[inf + i];
		for (int i = 0; i < 4; i++)
			out[outf + 1] = (out[outf + 1] << 1) + in[inf + 24 + i];
		for (int i = 0; i < 9; i++)
			out[outf + 1] = (out[outf + 1] << 3) + in[inf + 28 + i];// 第二个28位是低位存储的，所以浪费的1比特在最顶端。
		out[outf + 0] = code << 24 | out[outf + 0];
		
	}

	private void encode3(final int[] in, final int inf, final int code, final int[] out,
			final int outf) {
		for (int i = 0; i < 24; i++)
			out[outf + 0] = (out[outf + 0] << 1) + in[inf + i];
		for (int i = 0; i < 4; i++)
			out[outf + 1] = (out[outf + 1] << 1) + in[inf + 24 + i];
		for (int i = 0; i < 7; i++)
			out[outf + 1] = (out[outf + 1] << 4) + in[inf + 28 + i];
		out[outf + 0] = code << 24 | out[outf + 0];
		
	}

	private void encode4(final int[] in, final int inf, final int code, final int[] out,
			final int outf) {
		for (int i = 0; i < 24; i++)
			out[outf + 0] = (out[outf + 0] << 1) + in[inf + i];
		for (int i = 0; i < 4; i++)
			out[outf + 1] = (out[outf + 1] << 1) + in[inf + 24 + i];
		for (int i = 0; i < 5; i++)
			out[outf + 1] = (out[outf + 1] << 5) + in[inf + 28 + i];
		out[outf + 0] = code << 24 | out[outf + 0];
		
	}

	private void encode5(final int[] in, final int inf, final int code, final int[] out,
			final int outf) {
		for (int i = 0; i < 24; i++)
			out[outf + 0] = (out[outf + 0] << 1) + in[inf + i];
		for (int i = 0; i < 4; i++)
			out[outf + 1] = (out[outf + 1] << 1) + in[inf + 24 + i];
		for (int i = 0; i < 4; i++)
			out[outf + 1] = (out[outf + 1] << 7) + in[inf + 28 + i];
		out[outf + 0] = code << 24 | out[outf + 0];
		
	}

	private void encode6(final int[] in, final int inf, final int code, final int[] out,
			final int outf) {
		for (int i = 0; i < 24; i++)
			out[outf + 0] = (out[outf + 0] << 1) + in[inf + i];
		for (int i = 0; i < 4; i++)
			out[outf + 1] = (out[outf + 1] << 1) + in[inf + 24 + i];
		for (int i = 0; i < 3; i++)
			out[outf + 1] = (out[outf + 1] << 9) + in[inf + 28 + i];
		out[outf + 0] = code << 24 | out[outf + 0];
		
	}

	private void encode7(final int[] in, final int inf, final int code, final int[] out,
			final int outf) {
		for (int i = 0; i < 24; i++)
			out[outf + 0] = (out[outf + 0] << 1) + in[inf + i];
		for (int i = 0; i < 4; i++)
			out[outf + 1] = (out[outf + 1] << 1) + in[inf + 24 + i];
		for (int i = 0; i < 2; i++)
			out[outf + 1] = (out[outf + 1] << 14) + in[inf + 28 + i];
		out[outf + 0] = code << 24 | out[outf + 0];
		
	}

	private void encode8(final int[] in, final int inf, final int code, final int[] out,
			final int outf) {
		for (int i = 0; i < 24; i++)
			out[outf + 0] = (out[outf + 0] << 1) + in[inf + i];
		for (int i = 0; i < 4; i++)
			out[outf + 1] = (out[outf + 1] << 1) + in[inf + 24 + i];
		for (int i = 0; i < 1; i++)
			out[outf + 1] = (out[outf + 1] << 28) + in[inf + 28 + i];
		out[outf + 0] = code << 24 | out[outf + 0];
		
	}

	private void encode9(final int[] in, final int inf, final int code, final int[] out,
			final int outf) {
		for (int i = 0; i < 12; i++)
			out[outf + 0] = (out[outf + 0] << 2) + in[inf + i];
		for (int i = 0; i < 2; i++)
			out[outf + 1] = (out[outf + 1] << 2) + in[inf + 12 + i];
		for (int i = 0; i < 28; i++)
			out[outf + 1] = (out[outf + 1] << 1) + in[inf + 14 + i];

		out[outf + 0] = code << 24 | out[outf + 0];
		
	}

	private void encode10(final int[] in, final int inf, final int code, final int[] out,
			final int outf) {
		for (int i = 0; i < 12; i++) {
			out[outf + 0] = (out[outf + 0] << 2) + in[inf + i];

		}
		for (int i = 0; i < 2; i++)
			out[outf + 1] = (out[outf + 1] << 2) + in[inf + 12 + i];
		for (int i = 0; i < 14; i++)
			out[outf + 1] = (out[outf + 1] << 2) + in[inf + 14 + i];

		out[outf + 0] = code << 24 | out[outf + 0];
		
	}

	private void encode11(final int[] in, final int inf, final int code, final int[] out,
			final int outf) {
		for (int i = 0; i < 12; i++)
			out[outf + 0] = (out[outf + 0] << 2) + in[inf + i];
		for (int i = 0; i < 2; i++)
			out[outf + 1] = (out[outf + 1] << 2) + in[inf + 12 + i];
		for (int i = 0; i < 9; i++)
			out[outf + 1] = (out[outf + 1] << 3) + in[inf + 14 + i];

		out[outf + 0] = code << 24 | out[outf + 0];
		
	}

	private void encode12(final int[] in, final int inf, final int code, final int[] out,
			final int outf) {
		for (int i = 0; i < 12; i++)
			out[outf + 0] = (out[outf + 0] << 2) + in[inf + i];
		for (int i = 0; i < 2; i++)
			out[outf + 1] = (out[outf + 1] << 2) + in[inf + 12 + i];
		for (int i = 0; i < 7; i++)
			out[outf + 1] = (out[outf + 1] << 4) + in[inf + 14 + i];

		out[outf + 0] = code << 24 | out[outf + 0];
		
	}

	private void encode13(final int[] in, final int inf, final int code, final int[] out,
			final int outf) {
		for (int i = 0; i < 12; i++)
			out[outf + 0] = (out[outf + 0] << 2) + in[inf + i];
		for (int i = 0; i < 2; i++)
			out[outf + 1] = (out[outf + 1] << 2) + in[inf + 12 + i];
		for (int i = 0; i < 5; i++)
			out[outf + 1] = (out[outf + 1] << 5) + in[inf + 14 + i];

		out[outf + 0] = code << 24 | out[outf + 0];
		
	}

	private void encode14(final int[] in, final int inf, final int code, final int[] out,
			final int outf) {
		for (int i = 0; i < 12; i++)
			out[outf + 0] = (out[outf + 0] << 2) + in[inf + i];
		for (int i = 0; i < 2; i++)
			out[outf + 1] = (out[outf + 1] << 2) + in[inf + 12 + i];
		for (int i = 0; i < 4; i++)
			out[outf + 1] = (out[outf + 1] << 7) + in[inf + 14 + i];

		out[outf + 0] = code << 24 | out[outf + 0];
		
	}

	private void encode15(final int[] in, final int inf, final int code, final int[] out,
			final int outf) {
		for (int i = 0; i < 12; i++)
			out[outf + 0] = (out[outf + 0] << 2) + in[inf + i];
		for (int i = 0; i < 2; i++)
			out[outf + 1] = (out[outf + 1] << 2) + in[inf + 12 + i];
		for (int i = 0; i < 3; i++)
			out[outf + 1] = (out[outf + 1] << 9) + in[inf + 14 + i];

		out[outf + 0] = code << 24 | out[outf + 0];
		
	}

	private void encode16(final int[] in, final int inf, final int code, final int[] out,
			final int outf) {
		for (int i = 0; i < 12; i++)
			out[outf + 0] = (out[outf + 0] << 2) + in[inf + i];
		for (int i = 0; i < 2; i++)
			out[outf + 1] = (out[outf + 1] << 2) + in[inf + 12 + i];
		for (int i = 0; i < 2; i++)
			out[outf + 1] = (out[outf + 1] << 14) + in[inf + 14 + i];

		out[outf + 0] = code << 24 | out[outf + 0];
		
	}

	private void encode17(final int[] in, final int inf, final int code, final int[] out,
			final int outf) {
		for (int i = 0; i < 12; i++)
			out[outf + 0] = (out[outf + 0] << 2) + in[inf + i];
		for (int i = 0; i < 2; i++)
			out[outf + 1] = (out[outf + 1] << 2) + in[inf + 12 + i];
		for (int i = 0; i < 1; i++)
			out[outf + 1] = (out[outf + 1] << 28) + in[inf + 14 + i];

		out[outf + 0] = code << 24 | out[outf + 0];
		
	}

	private void encode18(final int[] in, final int inf, final int code, final int[] out,
			final int outf) {
		for (int i = 0; i < 8; i++)
			out[outf + 0] = (out[outf + 0] << 3) + in[inf + i];
		for (int i = 0; i < 1; i++)
			out[outf + 1] = (out[outf + 1] << 3) + in[inf + 8 + i];
		for (int i = 0; i < 28; i++)
			out[outf + 1] = (out[outf + 1] << 1) + in[inf + 9 + i];

		out[outf + 0] = code << 24 | out[outf + 0];
		
	}

	private void encode19(final int[] in, final int inf, final int code, final int[] out,
			final int outf) {
		for (int i = 0; i < 8; i++)
			out[outf + 0] = (out[outf + 0] << 3) + in[inf + i];
		for (int i = 0; i < 1; i++)
			out[outf + 1] = (out[outf + 1] << 3) + in[inf + 8 + i];
		for (int i = 0; i < 14; i++)
			out[outf + 1] = (out[outf + 1] << 2) + in[inf + 9 + i];

		out[outf + 0] = code << 24 | out[outf + 0];
		
	}

	private void encode20(final int[] in, final int inf, final int code, final int[] out,
			final int outf) {
		for (int i = 0; i < 8; i++)
			out[outf + 0] = (out[outf + 0] << 3) + in[inf + i];
		for (int i = 0; i < 1; i++)
			out[outf + 1] = (out[outf + 1] << 3) + in[inf + 8 + i];
		for (int i = 0; i < 9; i++)
			out[outf + 1] = (out[outf + 1] << 3) + in[inf + 9 + i];

		out[outf + 0] = code << 24 | out[outf + 0];
		
	}

	private void encode21(final int[] in, final int inf, final int code, final int[] out,
			final int outf) {
		for (int i = 0; i < 8; i++)
			out[outf + 0] = (out[outf + 0] << 3) + in[inf + i];
		for (int i = 0; i < 1; i++)
			out[outf + 1] = (out[outf + 1] << 3) + in[inf + 8 + i];
		for (int i = 0; i < 7; i++)
			out[outf + 1] = (out[outf + 1] << 4) + in[inf + 9 + i];
		out[outf + 0] = code << 24 | out[outf + 0];
		
	}

	private void encode22(final int[] in, final int inf, final int code, final int[] out,
			final int outf) {
		for (int i = 0; i < 8; i++)
			out[outf + 0] = (out[outf + 0] << 3) + in[inf + i];
		for (int i = 0; i < 1; i++)
			out[outf + 1] = (out[outf + 1] << 3) + in[inf + 8 + i];
		for (int i = 0; i < 5; i++)
			out[outf + 1] = (out[outf + 1] << 5) + in[inf + 9 + i];
		out[outf + 0] = code << 24 | out[outf + 0];
		
	}

	private void encode23(final int[] in, final int inf, final int code, final int[] out,
			final int outf) {
		for (int i = 0; i < 8; i++)
			out[outf + 0] = (out[outf + 0] << 3) + in[inf + i];
		for (int i = 0; i < 1; i++)
			out[outf + 1] = (out[outf + 1] << 3) + in[inf + 8 + i];
		for (int i = 0; i < 4; i++)
			out[outf + 1] = (out[outf + 1] << 7) + in[inf + 9 + i];
		out[outf + 0] = code << 24 | out[outf + 0];
		
	}

	private void encode24(final int[] in, final int inf, final int code, final int[] out,
			final int outf) {
		for (int i = 0; i < 8; i++)
			out[outf + 0] = (out[outf + 0] << 3) + in[inf + i];
		for (int i = 0; i < 1; i++)
			out[outf + 1] = (out[outf + 1] << 3) + in[inf + 8 + i];
		for (int i = 0; i < 3; i++)
			out[outf + 1] = (out[outf + 1] << 9) + in[inf + 9 + i];
		out[outf + 0] = code << 24 | out[outf + 0];
		
	}

	private void encode25(final int[] in, final int inf, final int code, final int[] out,
			final int outf) {
		for (int i = 0; i < 8; i++)
			out[outf + 0] = (out[outf + 0] << 3) + in[inf + i];
		for (int i = 0; i < 1; i++)
			out[outf + 1] = (out[outf + 1] << 3) + in[inf + 8 + i];
		for (int i = 0; i < 2; i++)
			out[outf + 1] = (out[outf + 1] << 14) + in[inf + 9 + i];
		out[outf + 0] = code << 24 | out[outf + 0];
		
	}

	private void encode26(final int[] in, final int inf, final int code, final int[] out,
			final int outf) {
		for (int i = 0; i < 8; i++)
			out[outf + 0] = (out[outf + 0] << 3) + in[inf + i];
		for (int i = 0; i < 1; i++)
			out[outf + 1] = (out[outf + 1] << 3) + in[inf + 8 + i];
		for (int i = 0; i < 1; i++)
			out[outf + 1] = (out[outf + 1] << 28) + in[inf + 9 + i];
		out[outf + 0] = code << 24 | out[outf + 0];
		
	}

	private void encode27(final int[] in, final int inf, final int code, final int[] out,
			final int outf) {
		for (int i = 0; i < 6; i++)
			out[outf + 0] = (out[outf + 0] << 4) + in[inf + i];
		for (int i = 0; i < 1; i++)
			out[outf + 1] = (out[outf + 1] << 4) + in[inf + 6 + i];
		for (int i = 0; i < 28; i++)
			out[outf + 1] = (out[outf + 1] << 1) + in[inf + 7 + i];
		out[outf + 0] = code << 24 | out[outf + 0];
		
	}

	private void encode28(final int[] in, final int inf, final int code, final int[] out,
			final int outf) {
		for (int i = 0; i < 6; i++)
			out[outf + 0] = (out[outf + 0] << 4) + in[inf + i];
		for (int i = 0; i < 1; i++)
			out[outf + 1] = (out[outf + 1] << 4) + in[inf + 6 + i];
		for (int i = 0; i < 14; i++)
			out[outf + 1] = (out[outf + 1] << 2) + in[inf + 7 + i];
		out[outf + 0] = code << 24 | out[outf + 0];
		
	}

	private void encode29(final int[] in, final int inf, final int code, final int[] out,
			final int outf) {
		for (int i = 0; i < 6; i++)
			out[outf + 0] = (out[outf + 0] << 4) + in[inf + i];
		for (int i = 0; i < 1; i++)
			out[outf + 1] = (out[outf + 1] << 4) + in[inf + 6 + i];
		for (int i = 0; i < 9; i++)
			out[outf + 1] = (out[outf + 1] << 3) + in[inf + 7 + i];
		out[outf + 0] = code << 24 | out[outf + 0];
		
	}

	private void encode30(final int[] in, final int inf, final int code, final int[] out,
			final int outf) {
		for (int i = 0; i < 6; i++)
			out[outf + 0] = (out[outf + 0] << 4) + in[inf + i];
		for (int i = 0; i < 1; i++)
			out[outf + 1] = (out[outf + 1] << 4) + in[inf + 6 + i];
		for (int i = 0; i < 7; i++)
			out[outf + 1] = (out[outf + 1] << 4) + in[inf + 7 + i];
		out[outf + 0] = code << 24 | out[outf + 0];
		
	}

	private void encode31(final int[] in, final int inf, final int code, final int[] out,
			final int outf) {
		for (int i = 0; i < 6; i++)
			out[outf + 0] = (out[outf + 0] << 4) + in[inf + i];
		for (int i = 0; i < 1; i++)
			out[outf + 1] = (out[outf + 1] << 4) + in[inf + 6 + i];
		for (int i = 0; i < 5; i++)
			out[outf + 1] = (out[outf + 1] << 5) + in[inf + 7 + i];
		out[outf + 0] = code << 24 | out[outf + 0];
		
	}

	private void encode32(final int[] in, final int inf, final int code, final int[] out,
			final int outf) {
		for (int i = 0; i < 6; i++)
			out[outf + 0] = (out[outf + 0] << 4) + in[inf + i];
		for (int i = 0; i < 1; i++)
			out[outf + 1] = (out[outf + 1] << 4) + in[inf + 6 + i];
		for (int i = 0; i < 4; i++)
			out[outf + 1] = (out[outf + 1] << 7) + in[inf + 7 + i];
		out[outf + 0] = code << 24 | out[outf + 0];
		
	}

	private void encode33(final int[] in, final int inf, final int code, final int[] out,
			final int outf) {
		for (int i = 0; i < 6; i++)
			out[outf + 0] = (out[outf + 0] << 4) + in[inf + i];
		for (int i = 0; i < 1; i++)
			out[outf + 1] = (out[outf + 1] << 4) + in[inf + 6 + i];
		for (int i = 0; i < 3; i++)
			out[outf + 1] = (out[outf + 1] << 9) + in[inf + 7 + i];
		out[outf + 0] = code << 24 | out[outf + 0];
		
	}

	private void encode34(final int[] in, final int inf, final int code, final int[] out,
			final int outf) {
		for (int i = 0; i < 6; i++)
			out[outf + 0] = (out[outf + 0] << 4) + in[inf + i];
		for (int i = 0; i < 1; i++)
			out[outf + 1] = (out[outf + 1] << 4) + in[inf + 6 + i];
		for (int i = 0; i < 2; i++)
			out[outf + 1] = (out[outf + 1] << 14) + in[inf + 7 + i];
		out[outf + 0] = code << 24 | out[outf + 0];
		
	}

	private void encode35(final int[] in, final int inf, final int code, final int[] out,
			final int outf) {
		for (int i = 0; i < 6; i++)
			out[outf + 0] = (out[outf + 0] << 4) + in[inf + i];
		for (int i = 0; i < 1; i++)
			out[outf + 1] = (out[outf + 1] << 4) + in[inf + 6 + i];
		for (int i = 0; i < 1; i++)
			out[outf + 1] = (out[outf + 1] << 28) + in[inf + 7 + i];
		out[outf + 0] = code << 24 | out[outf + 0];
		
	}

	private void encode36(final int[] in, final int inf, final int code, final int[] out,
			final int outf) {
		for (int i = 0; i < 4; i++)
			out[outf + 0] = (out[outf + 0] << 5) + in[inf + i];
		out[outf + 0] = (out[outf + 0] << 4) + (in[inf + 4] >>> 1);
		out[outf + 1] = (out[outf + 1] << 1) + ((in[inf + 4] << 31) >>> 31);
		for (int i = 0; i < 28; i++)
			out[outf + 1] = (out[outf + 1] << 1) + in[inf + 5 + i];
		out[outf + 0] = code << 24 | out[outf + 0];
		
	}

	private void encode37(final int[] in, final int inf, final int code, final int[] out,
			final int outf) {
		for (int i = 0; i < 4; i++)
			out[outf + 0] = (out[outf + 0] << 5) + in[inf + i];
		out[outf + 0] = (out[outf + 0] << 4) + (in[inf + 4] >>> 1);
		out[outf + 1] = (out[outf + 1] << 1) + ((in[inf + 4] << 31) >>> 31);
		for (int i = 0; i < 14; i++)
			out[outf + 1] = (out[outf + 1] << 2) + in[inf + 5 + i];
		out[outf + 0] = code << 24 | out[outf + 0];
		
	}

	private void encode38(final int[] in, final int inf, final int code, final int[] out,
			final int outf) {
		for (int i = 0; i < 4; i++)
			out[outf + 0] = (out[outf + 0] << 5) + in[inf + i];
		out[outf + 0] = (out[outf + 0] << 4) + (in[inf + 4] >>> 1);
		out[outf + 1] = (out[outf + 1] << 1) + ((in[inf + 4] << 31) >>> 31);
		for (int i = 0; i < 9; i++)
			out[outf + 1] = (out[outf + 1] << 3) + in[inf + 5 + i];
		out[outf + 0] = code << 24 | out[outf + 0];
		
	}

	private void encode39(final int[] in, final int inf, final int code, final int[] out,
			final int outf) {
		for (int i = 0; i < 4; i++)
			out[outf + 0] = (out[outf + 0] << 5) + in[inf + i];
		out[outf + 0] = (out[outf + 0] << 4) + (in[inf + 4] >>> 1);
		out[outf + 1] = (out[outf + 1] << 1) + ((in[inf + 4] << 31) >>> 31);
		for (int i = 0; i < 7; i++)
			out[outf + 1] = (out[outf + 1] << 4) + in[inf + 5 + i];
		out[outf + 0] = code << 24 | out[outf + 0];
		
	}

	private void encode40(final int[] in, final int inf, final int code, final int[] out,
			final int outf) {
		for (int i = 0; i < 4; i++)
			out[outf + 0] = (out[outf + 0] << 5) + in[inf + i];
		out[outf + 0] = (out[outf + 0] << 4) + (in[inf + 4] >>> 1);
		out[outf + 1] = (out[outf + 1] << 1) + ((in[inf + 4] << 31) >>> 31);
		for (int i = 0; i < 5; i++)
			out[outf + 1] = (out[outf + 1] << 5) + in[inf + 5 + i];
		out[outf + 0] = code << 24 | out[outf + 0];
		
	}

	private void encode41(final int[] in, final int inf, final int code, final int[] out,
			final int outf) {
		for (int i = 0; i < 4; i++)
			out[outf + 0] = (out[outf + 0] << 5) + in[inf + i];
		out[outf + 0] = (out[outf + 0] << 4) + (in[inf + 4] >>> 1);
		out[outf + 1] = (out[outf + 1] << 1) + ((in[inf + 4] << 31) >>> 31);
		for (int i = 0; i < 4; i++)
			out[outf + 1] = (out[outf + 1] << 7) + in[inf + 5 + i];
		out[outf + 0] = code << 24 | out[outf + 0];
		
	}

	private void encode42(final int[] in, final int inf, final int code, final int[] out,
			final int outf) {
		for (int i = 0; i < 4; i++)
			out[outf + 0] = (out[outf + 0] << 5) + in[inf + i];
		out[outf + 0] = (out[outf + 0] << 4) + (in[inf + 4] >>> 1);
		out[outf + 1] = (out[outf + 1] << 1) + ((in[inf + 4] << 31) >>> 31);
		for (int i = 0; i < 3; i++)
			out[outf + 1] = (out[outf + 1] << 9) + in[inf + 5 + i];
		out[outf + 0] = code << 24 | out[outf + 0];
		
	}

	private void encode43(final int[] in, final int inf, final int code, final int[] out,
			final int outf) {
		for (int i = 0; i < 4; i++)
			out[outf + 0] = (out[outf + 0] << 5) + in[inf + i];
		out[outf + 0] = (out[outf + 0] << 4) + (in[inf + 4] >>> 1);
		out[outf + 1] = (out[outf + 1] << 1) + ((in[inf + 4] << 31) >>> 31);
		for (int i = 0; i < 2; i++)
			out[outf + 1] = (out[outf + 1] << 14) + in[inf + 5 + i];
		out[outf + 0] = code << 24 | out[outf + 0];
		
	}

	private void encode44(final int[] in, final int inf, final int code, final int[] out,
			final int outf) {
		for (int i = 0; i < 4; i++)
			out[outf + 0] = (out[outf + 0] << 5) + in[inf + i];
		out[outf + 0] = (out[outf + 0] << 4) + (in[inf + 4] >>> 1);
		out[outf + 1] = (out[outf + 1] << 1) + ((in[inf + 4] << 31) >>> 31);
		for (int i = 0; i < 1; i++)
			out[outf + 1] = (out[outf + 1] << 28) + in[inf + 5 + i];
		out[outf + 0] = code << 24 | out[outf + 0];
		
	}

	private void encode45(final int[] in, final int inf, final int code, final int[] out,
			final int outf) {
		for (int i = 0; i < 3; i++)
			out[outf + 0] = (out[outf + 0] << 7) + in[inf + i];
		out[outf + 0] = (out[outf + 0] << 3) + (in[inf + 3] >>> 4);
		out[outf + 1] = (out[outf + 1] << 4) + ((in[inf + 3] << 28) >>> 28);
		for (int i = 0; i < 28; i++)
			out[outf + 1] = (out[outf + 1] << 1) + in[inf + 4 + i];
		out[outf + 0] = code << 24 | out[outf + 0];
		
	}

	private void encode46(final int[] in, final int inf, final int code, final int[] out,
			final int outf) {
		for (int i = 0; i < 3; i++)
			out[outf + 0] = (out[outf + 0] << 7) + in[inf + i];
		out[outf + 0] = (out[outf + 0] << 3) + (in[inf + 3] >>> 4);
		out[outf + 1] = (out[outf + 1] << 4) + ((in[inf + 3] << 28) >>> 28);
		for (int i = 0; i < 14; i++)
			out[outf + 1] = (out[outf + 1] << 2) + in[inf + 4 + i];
		out[outf + 0] = code << 24 | out[outf + 0];
		
	}

	private void encode47(final int[] in, final int inf, final int code, final int[] out,
			final int outf) {
		for (int i = 0; i < 3; i++)
			out[outf + 0] = (out[outf + 0] << 7) + in[inf + i];
		out[outf + 0] = (out[outf + 0] << 3) + (in[inf + 3] >>> 4);
		out[outf + 1] = (out[outf + 1] << 4) + ((in[inf + 3] << 28) >>> 28);
		for (int i = 0; i < 9; i++)
			out[outf + 1] = (out[outf + 1] << 3) + in[inf + 4 + i];
		out[outf + 0] = code << 24 | out[outf + 0];
		
	}

	private void encode48(final int[] in, final int inf, final int code, final int[] out,
			final int outf) {
		for (int i = 0; i < 3; i++)
			out[outf + 0] = (out[outf + 0] << 7) + in[inf + i];
		out[outf + 0] = (out[outf + 0] << 3) + (in[inf + 3] >>> 4);
		out[outf + 1] = (out[outf + 1] << 4) + ((in[inf + 3] << 28) >>> 28);
		for (int i = 0; i < 7; i++)
			out[outf + 1] = (out[outf + 1] << 4) + in[inf + 4 + i];
		out[outf + 0] = code << 24 | out[outf + 0];
		
	}

	private void encode49(final int[] in, final int inf, final int code, final int[] out,
			final int outf) {
		for (int i = 0; i < 3; i++)
			out[outf + 0] = (out[outf + 0] << 7) + in[inf + i];
		out[outf + 0] = (out[outf + 0] << 3) + (in[inf + 3] >>> 4);
		out[outf + 1] = (out[outf + 1] << 4) + ((in[inf + 3] << 28) >>> 28);
		for (int i = 0; i < 5; i++)
			out[outf + 1] = (out[outf + 1] << 5) + in[inf + 4 + i];
		out[outf + 0] = code << 24 | out[outf + 0];
		
	}

	private void encode50(final int[] in, final int inf, final int code, final int[] out,
			final int outf) {
		for (int i = 0; i < 3; i++)
			out[outf + 0] = (out[outf + 0] << 7) + in[inf + i];
		out[outf + 0] = (out[outf + 0] << 3) + (in[inf + 3] >>> 4);
		out[outf + 1] = (out[outf + 1] << 4) + ((in[inf + 3] << 28) >>> 28);
		for (int i = 0; i < 4; i++)
			out[outf + 1] = (out[outf + 1] << 7) + in[inf + 4 + i];
		out[outf + 0] = code << 24 | out[outf + 0];
		
	}

	private void encode51(final int[] in, final int inf, final int code, final int[] out,
			final int outf) {
		for (int i = 0; i < 3; i++)
			out[outf + 0] = (out[outf + 0] << 7) + in[inf + i];
		out[outf + 0] = (out[outf + 0] << 3) + (in[inf + 3] >>> 4);
		out[outf + 1] = (out[outf + 1] << 4) + ((in[inf + 3] << 28) >>> 28);
		for (int i = 0; i < 3; i++)
			out[outf + 1] = (out[outf + 1] << 9) + in[inf + 4 + i];
		out[outf + 0] = code << 24 | out[outf + 0];
		
	}

	private void encode52(final int[] in, final int inf, final int code, final int[] out,
			final int outf) {
		for (int i = 0; i < 3; i++)
			out[outf + 0] = (out[outf + 0] << 7) + in[inf + i];
		out[outf + 0] = (out[outf + 0] << 3) + (in[inf + 3] >>> 4);
		out[outf + 1] = (out[outf + 1] << 4) + ((in[inf + 3] << 28) >>> 28);
		for (int i = 0; i < 2; i++)
			out[outf + 1] = (out[outf + 1] << 14) + in[inf + 4 + i];
		out[outf + 0] = code << 24 | out[outf + 0];
		
	}

	private void encode53(final int[] in, final int inf, final int code, final int[] out,
			final int outf) {
		for (int i = 0; i < 3; i++)
			out[outf + 0] = (out[outf + 0] << 7) + in[inf + i];
		out[outf + 0] = (out[outf + 0] << 3) + (in[inf + 3] >>> 4);
		out[outf + 1] = (out[outf + 1] << 4) + ((in[inf + 3] << 28) >>> 28);
		for (int i = 0; i < 1; i++)
			out[outf + 1] = (out[outf + 1] << 28) + in[inf + 4 + i];
		out[outf + 0] = code << 24 | out[outf + 0];
		
	}

	private void encode54(final int[] in, final int inf, final int code, final int[] out,
			final int outf) {
		for (int i = 0; i < 2; i++)
			out[outf + 0] = (out[outf + 0] << 9) + in[inf + i];
		out[outf + 0] = (out[outf + 0] << 6) + (in[inf + 2] >>> 3);
		out[outf + 1] = (out[outf + 1] << 3) + ((in[inf + 2] << 29) >>> 29);
		for (int i = 0; i < 28; i++)
			out[outf + 1] = (out[outf + 1] << 1) + in[inf + 3 + i];
		out[outf + 0] = code << 24 | out[outf + 0];
		
	}

	private void encode55(final int[] in, final int inf, final int code, final int[] out,
			final int outf) {
		for (int i = 0; i < 2; i++)
			out[outf + 0] = (out[outf + 0] << 9) + in[inf + i];
		out[outf + 0] = (out[outf + 0] << 6) + (in[inf + 2] >>> 3);
		out[outf + 1] = (out[outf + 1] << 3) + ((in[inf + 2] << 29) >>> 29);
		for (int i = 0; i < 14; i++)
			out[outf + 1] = (out[outf + 1] << 2) + in[inf + 3 + i];
		out[outf + 0] = code << 24 | out[outf + 0];
		
	}

	private void encode56(final int[] in, final int inf, final int code, final int[] out,
			final int outf) {
		for (int i = 0; i < 2; i++)
			out[outf + 0] = (out[outf + 0] << 9) + in[inf + i];
		out[outf + 0] = (out[outf + 0] << 6) + (in[inf + 2] >>> 3);
		out[outf + 1] = (out[outf + 1] << 3) + ((in[inf + 2] << 29) >>> 29);
		for (int i = 0; i < 9; i++)
			out[outf + 1] = (out[outf + 1] << 3) + in[inf + 3 + i];
		out[outf + 0] = code << 24 | out[outf + 0];
		
	}

	private void encode57(final int[] in, final int inf, final int code, final int[] out,
			final int outf) {
		for (int i = 0; i < 2; i++)
			out[outf + 0] = (out[outf + 0] << 9) + in[inf + i];
		out[outf + 0] = (out[outf + 0] << 6) + (in[inf + 2] >>> 3);
		out[outf + 1] = (out[outf + 1] << 3) + ((in[inf + 2] << 29) >>> 29);
		for (int i = 0; i < 7; i++)
			out[outf + 1] = (out[outf + 1] << 4) + in[inf + 3 + i];
		out[outf + 0] = code << 24 | out[outf + 0];
		
	}

	private void encode58(final int[] in, final int inf, final int code, final int[] out,
			final int outf) {
		for (int i = 0; i < 2; i++)
			out[outf + 0] = (out[outf + 0] << 9) + in[inf + i];
		out[outf + 0] = (out[outf + 0] << 6) + (in[inf + 2] >>> 3);
		out[outf + 1] = (out[outf + 1] << 3) + ((in[inf + 2] << 29) >>> 29);
		for (int i = 0; i < 5; i++)
			out[outf + 1] = (out[outf + 1] << 5) + in[inf + 3 + i];
		out[outf + 0] = code << 24 | out[outf + 0];
		
	}

	private void encode59(final int[] in, final int inf, final int code, final int[] out,
			final int outf) {
		for (int i = 0; i < 2; i++)
			out[outf + 0] = (out[outf + 0] << 9) + in[inf + i];
		out[outf + 0] = (out[outf + 0] << 6) + (in[inf + 2] >>> 3);
		out[outf + 1] = (out[outf + 1] << 3) + ((in[inf + 2] << 29) >>> 29);
		for (int i = 0; i < 4; i++)
			out[outf + 1] = (out[outf + 1] << 7) + in[inf + 3 + i];
		out[outf + 0] = code << 24 | out[outf + 0];
		
	}

	private void encode60(final int[] in, final int inf, final int code, final int[] out,
			final int outf) {
		for (int i = 0; i < 2; i++)
			out[outf + 0] = (out[outf + 0] << 9) + in[inf + i];
		out[outf + 0] = (out[outf + 0] << 6) + (in[inf + 2] >>> 3);
		out[outf + 1] = (out[outf + 1] << 3) + ((in[inf + 2] << 29) >>> 29);
		for (int i = 0; i < 3; i++)
			out[outf + 1] = (out[outf + 1] << 9) + in[inf + 3 + i];
		out[outf + 0] = code << 24 | out[outf + 0];
		
	}

	private void encode61(final int[] in, final int inf, final int code, final int[] out,
			final int outf) {
		for (int i = 0; i < 2; i++)
			out[outf + 0] = (out[outf + 0] << 9) + in[inf + i];
		out[outf + 0] = (out[outf + 0] << 6) + (in[inf + 2] >>> 3);
		out[outf + 1] = (out[outf + 1] << 3) + ((in[inf + 2] << 29) >>> 29);
		for (int i = 0; i < 2; i++)
			out[outf + 1] = (out[outf + 1] << 14) + in[inf + 3 + i];
		out[outf + 0] = code << 24 | out[outf + 0];
		
	}

	private void encode62(final int[] in, final int inf, final int code, final int[] out,
			final int outf) {
		for (int i = 0; i < 2; i++)
			out[outf + 0] = (out[outf + 0] << 9) + in[inf + i];
		out[outf + 0] = (out[outf + 0] << 6) + (in[inf + 2] >>> 3);
		out[outf + 1] = (out[outf + 1] << 3) + ((in[inf + 2] << 29) >>> 29);
		for (int i = 0; i < 1; i++)
			out[outf + 1] = (out[outf + 1] << 28) + in[inf + 3 + i];
		out[outf + 0] = code << 24 | out[outf + 0];
		
	}

	private void encode63(final int[] in, final int inf, final int code, final int[] out,
			final int outf) {

		out[outf + 0] = (out[outf + 0] << 14) + in[inf];
		out[outf + 0] = (out[outf + 0] << 10) + (in[inf + 1] >>> 4);
		out[outf + 1] = (out[outf + 1] << 4) + ((in[inf + 1] << 28) >>> 28);
		for (int i = 0; i < 28; i++)
			out[outf + 1] = (out[outf + 1] << 1) + in[inf + 2 + i];
		out[outf + 0] = code << 24 | out[outf + 0];
		
	}

	private void encode64(final int[] in, final int inf, final int code, final int[] out,
			final int outf) {
		out[outf + 0] = (out[outf + 0] << 14) + in[inf];
		out[outf + 0] = (out[outf + 0] << 10) + (in[inf + 1] >>> 4);
		out[outf + 1] = (out[outf + 1] << 4) + ((in[inf + 1] << 28) >>> 28);
		for (int i = 0; i < 14; i++)
			out[outf + 1] = (out[outf + 1] << 2) + in[inf + 2 + i];
		out[outf + 0] = code << 24 | out[outf + 0];
		
	}

	private void encode65(final int[] in, final int inf, final int code, final int[] out,
			final int outf) {
		out[outf + 0] = (out[outf + 0] << 14) + in[inf];
		out[outf + 0] = (out[outf + 0] << 10) + (in[inf + 1] >>> 4);
		out[outf + 1] = (out[outf + 1] << 4) + ((in[inf + 1] << 28) >>> 28);
		for (int i = 0; i < 9; i++)
			out[outf + 1] = (out[outf + 1] << 3) + in[inf + 2 + i];
		out[outf + 0] = code << 24 | out[outf + 0];
		
	}

	private void encode66(final int[] in, final int inf, final int code, final int[] out,
			final int outf) {
		out[outf + 0] = (out[outf + 0] << 14) + in[inf];
		out[outf + 0] = (out[outf + 0] << 10) + (in[inf + 1] >>> 4);
		out[outf + 1] = (out[outf + 1] << 4) + ((in[inf + 1] << 28) >>> 28);
		for (int i = 0; i < 7; i++)
			out[outf + 1] = (out[outf + 1] << 4) + in[inf + 2 + i];
		out[outf + 0] = code << 24 | out[outf + 0];
		
	}

	private void encode67(final int[] in, final int inf, final int code, final int[] out,
			final int outf) {
		out[outf + 0] = (out[outf + 0] << 14) + in[inf];
		out[outf + 0] = (out[outf + 0] << 10) + (in[inf + 1] >>> 4);
		out[outf + 1] = (out[outf + 1] << 4) + ((in[inf + 1] << 28) >>> 28);
		for (int i = 0; i < 5; i++)
			out[outf + 1] = (out[outf + 1] << 5) + in[inf + 2 + i];
		out[outf + 0] = code << 24 | out[outf + 0];
		
	}

	private void encode68(final int[] in, final int inf, final int code, final int[] out,
			final int outf) {
		out[outf + 0] = (out[outf + 0] << 14) + in[inf];
		out[outf + 0] = (out[outf + 0] << 10) + (in[inf + 1] >>> 4);
		out[outf + 1] = (out[outf + 1] << 4) + ((in[inf + 1] << 28) >>> 28);
		for (int i = 0; i < 4; i++)
			out[outf + 1] = (out[outf + 1] << 7) + in[inf + 2 + i];
		out[outf + 0] = code << 24 | out[outf + 0];
		
	}

	private void encode69(final int[] in, final int inf, final int code, final int[] out,
			final int outf) {
		out[outf + 0] = (out[outf + 0] << 14) + in[inf];
		out[outf + 0] = (out[outf + 0] << 10) + (in[inf + 1] >>> 4);
		out[outf + 1] = (out[outf + 1] << 4) + ((in[inf + 1] << 28) >>> 28);
		for (int i = 0; i < 3; i++)
			out[outf + 1] = (out[outf + 1] << 9) + in[inf + 2 + i];
		out[outf + 0] = code << 24 | out[outf + 0];
		
	}

	private void encode70(final int[] in, final int inf, final int code, final int[] out,
			final int outf) {
		out[outf + 0] = (out[outf + 0] << 14) + in[inf];
		out[outf + 0] = (out[outf + 0] << 10) + (in[inf + 1] >>> 4);
		out[outf + 1] = (out[outf + 1] << 4) + ((in[inf + 1] << 28) >>> 28);
		for (int i = 0; i < 2; i++)
			out[outf + 1] = (out[outf + 1] << 14) + in[inf + 2 + i];
		out[outf + 0] = code << 24 | out[outf + 0];
		
	}

	private void encode71(final int[] in, final int inf, final int code, final int[] out,
			final int outf) {
		out[outf + 0] = (out[outf + 0] << 14) + in[inf];
		out[outf + 0] = (out[outf + 0] << 10) + (in[inf + 1] >>> 4);
		out[outf + 1] = (out[outf + 1] << 4) + ((in[inf + 1] << 28) >>> 28);
		for (int i = 0; i < 1; i++)
			out[outf + 1] = (out[outf + 1] << 28) + in[inf + 2 + i];
		out[outf + 0] = code << 24 | out[outf + 0];
		
	}

	private void encode72(final int[] in, final int inf, final int code, final int[] out,
			final int outf) {

		out[outf + 0] = (out[outf + 0] << 24) + (in[inf] >>> 4);
		out[outf + 1] = (out[outf + 1] << 4) + ((in[inf] << 28) >>> 28);
		for (int i = 0; i < 28; i++)
			out[outf + 1] = (out[outf + 1] << 1) + in[inf + 1 + i];
		out[outf + 0] = code << 24 | out[outf + 0];
		
	}

	private void encode73(final int[] in, final int inf, final int code, final int[] out,
			final int outf) {
		out[outf + 0] = (out[outf + 0] << 24) + (in[inf] >>> 4);
		out[outf + 1] = (out[outf + 1] << 4) + ((in[inf] << 28) >>> 28);
		for (int i = 0; i < 14; i++)
			out[outf + 1] = (out[outf + 1] << 2) + in[inf + 1 + i];
		out[outf + 0] = code << 24 | out[outf + 0];
		
	}

	private void encode74(final int[] in, final int inf, final int code, final int[] out,
			final int outf) {
		out[outf + 0] = (out[outf + 0] << 24) + (in[inf] >>> 4);
		out[outf + 1] = (out[outf + 1] << 4) + ((in[inf] << 28) >>> 28);
		for (int i = 0; i < 9; i++)
			out[outf + 1] = (out[outf + 1] << 3) + in[inf + 1 + i];
		out[outf + 0] = code << 24 | out[outf + 0];
		
	}

	private void encode75(final int[] in, final int inf, final int code, final int[] out,
			final int outf) {
		out[outf + 0] = (out[outf + 0] << 24) + (in[inf] >>> 4);
		out[outf + 1] = (out[outf + 1] << 4) + ((in[inf] << 28) >>> 28);
		for (int i = 0; i < 7; i++)
			out[outf + 1] = (out[outf + 1] << 4) + in[inf + 1 + i];
		out[outf + 0] = code << 24 | out[outf + 0];
		
	}

	private void encode76(final int[] in, final int inf, final int code, final int[] out,
			final int outf) {
		out[outf + 0] = (out[outf + 0] << 24) + (in[inf] >>> 4);
		out[outf + 1] = (out[outf + 1] << 4) + ((in[inf] << 28) >>> 28);
		for (int i = 0; i < 5; i++)
			out[outf + 1] = (out[outf + 1] << 5) + in[inf + 1 + i];
		out[outf + 0] = code << 24 | out[outf + 0];
		
	}

	private void encode77(final int[] in, final int inf, final int code, final int[] out,
			final int outf) {
		out[outf + 0] = (out[outf + 0] << 24) + (in[inf] >>> 4);
		out[outf + 1] = (out[outf + 1] << 4) + ((in[inf] << 28) >>> 28);
		for (int i = 0; i < 4; i++)
			out[outf + 1] = (out[outf + 1] << 7) + in[inf + 1 + i];
		out[outf + 0] = code << 24 | out[outf + 0];
		
	}

	private void encode78(final int[] in, final int inf, final int code, final int[] out,
			final int outf) {
		out[outf + 0] = (out[outf + 0] << 24) + (in[inf] >>> 4);
		out[outf + 1] = (out[outf + 1] << 4) + ((in[inf] << 28) >>> 28);
		for (int i = 0; i < 3; i++)
			out[outf + 1] = (out[outf + 1] << 9) + in[inf + 1 + i];
		out[outf + 0] = code << 24 | out[outf + 0];
		
	}

	private void encode79(final int[] in, final int inf, final int code, final int[] out,
			final int outf) {
		out[outf + 0] = (out[outf + 0] << 24) + (in[inf] >>> 4);
		out[outf + 1] = (out[outf + 1] << 4) + ((in[inf] << 28) >>> 28);
		for (int i = 0; i < 2; i++)
			out[outf + 1] = (out[outf + 1] << 14) + in[inf + 1 + i];
		out[outf + 0] = code << 24 | out[outf + 0];
		
	}

	private void encode80(final int[] in, final int inf, final int code, final int[] out,
			final int outf) {
		out[outf + 0] = (out[outf + 0] << 24) + (in[inf] >>> 4);
		out[outf + 1] = (out[outf + 1] << 4) + ((in[inf] << 28) >>> 28);
		for (int i = 0; i < 1; i++)
			out[outf + 1] = (out[outf + 1] << 28) + in[inf + 1 + i];
		out[outf + 0] = code << 24 | out[outf + 0];
		
	}

	@Override
	public void uncompress(int[] in, IntWrapper inpos, int inlength, int[] out, IntWrapper outpos) {
		if (inlength == 0)
			return;
		final int outlength = in[inpos.get()];
		inpos.increment();
		headlessUncompress(in, inpos, inlength, out, outpos, outlength);
	}

	
	
	private void decode80(int val, int valn, int[] out, int currentPos) {
		// number : 1, bitwidth : 28
		out[currentPos++] = (val << 8) >>> 4 | (valn >>> 28);
		// number : 1, bitwidth : 28
		out[currentPos++] = (valn << 4) >>> 4;
	}

	private void decode79(int val, int valn, int[] out, int currentPos) {
		// number : 1, bitwidth : 28
		out[currentPos++] = (val << 8) >>> 4 | (valn >>> 28);
		// number :2, bitwidth : 14
		out[currentPos++] = (valn << 4) >>> 18;
		out[currentPos++] = (valn << 18) >>> 18;
	}

	private void decode78(int val, int valn, int[] out, int currentPos) {
		// number : 1, bitwidth : 28
		out[currentPos++] = (val << 8) >>> 4 | (valn >>> 27);
		// number : 3, bitwidth :9
		out[currentPos++] = (valn << 5) >>> 23;
		out[currentPos++] = (valn << 14) >>> 23;
		out[currentPos++] = (valn << 23) >>> 23;
	}

	private void decode77(int val, int valn, int[] out, int currentPos) {
		// number : 1, bitwidth : 28
		out[currentPos++] = (val << 8) >>> 4 | (valn >>> 28);
		// number : 4, bitwidth : 7
		out[currentPos++] = (valn << 4) >>> 25;
		out[currentPos++] = (valn << 11) >>> 25;
		out[currentPos++] = (valn << 18) >>> 25;
		out[currentPos++] = (valn << 25) >>> 25;
	}

	private void decode76(int val, int valn, int[] out, int currentPos) {
		// number : 5, bitwidth : 5
		out[currentPos++] = (val << 8) >>> 4 | (valn >>> 25);
		// number : 14, bitwidth : 2
		out[currentPos++] = (valn << 7) >>> 27;
		out[currentPos++] = (valn << 12) >>> 27;
		out[currentPos++] = (valn << 17) >>> 27;
		out[currentPos++] = (valn << 22) >>> 27;
		out[currentPos++] = (valn << 27) >>> 27;
	}

	private void decode75(int val, int valn, int[] out, int currentPos) {
		// number : 1, bitwidth : 28
		out[currentPos++] = (val << 8) >>> 4 | (valn >>> 28);
		// number : 7, bitwidth : 4
		out[currentPos++] = (valn << 4) >>> 28;
		out[currentPos++] = (valn << 8) >>> 28;
		out[currentPos++] = (valn << 12) >>> 28;
		out[currentPos++] = (valn << 16) >>> 28;
		out[currentPos++] = (valn << 20) >>> 28;
		out[currentPos++] = (valn << 24) >>> 28;
		out[currentPos++] = (valn << 28) >>> 28;
	}

	private void decode74(int val, int valn, int[] out, int currentPos) {
		// number : 1, bitwidth : 28
		out[currentPos++] = (val << 8) >>> 4 | (valn >>> 27);
		// number : 9, bitwidth : 3
		out[currentPos++] = (valn << 5) >>> 29;
		out[currentPos++] = (valn << 8) >>> 29;
		out[currentPos++] = (valn << 11) >>> 29;
		out[currentPos++] = (valn << 14) >>> 29;
		out[currentPos++] = (valn << 17) >>> 29;
		out[currentPos++] = (valn << 20) >>> 29;
		out[currentPos++] = (valn << 23) >>> 29;
		out[currentPos++] = (valn << 26) >>> 29;
		out[currentPos++] = (valn << 29) >>> 29;
	}

	private void decode73(int val, int valn, int[] out, int currentPos) {
		// number : 1, bitwidth : 28
		out[currentPos++] = (val << 8) >>> 4 | (valn >>> 28);
		// number : 14, bitwidth : 2
		out[currentPos++] = (valn << 4) >>> 30;
		out[currentPos++] = (valn << 6) >>> 30;
		out[currentPos++] = (valn << 8) >>> 30;
		out[currentPos++] = (valn << 10) >>> 30;
		out[currentPos++] = (valn << 12) >>> 30;
		out[currentPos++] = (valn << 14) >>> 30;
		out[currentPos++] = (valn << 16) >>> 30;
		out[currentPos++] = (valn << 18) >>> 30;
		out[currentPos++] = (valn << 20) >>> 30;
		out[currentPos++] = (valn << 22) >>> 30; // 10
		out[currentPos++] = (valn << 24) >>> 30;
		out[currentPos++] = (valn << 26) >>> 30;
		out[currentPos++] = (valn << 28) >>> 30;
		out[currentPos++] = (valn << 30) >>> 30;
	}

	private void decode72(int val, int valn, int[] out, int currentPos) {
		// number : 1, bitwidth : 28
		out[currentPos++] = (val << 8) >>> 4 | (valn >>> 28);
		// number : 28, bitwidth : 1
		out[currentPos++] = (valn << 4) >>> 31;
		out[currentPos++] = (valn << 5) >>> 31;
		out[currentPos++] = (valn << 6) >>> 31;
		out[currentPos++] = (valn << 7) >>> 31;
		out[currentPos++] = (valn << 8) >>> 31;
		out[currentPos++] = (valn << 9) >>> 31;
		out[currentPos++] = (valn << 10) >>> 31;
		out[currentPos++] = (valn << 11) >>> 31;
		out[currentPos++] = (valn << 12) >>> 31;
		out[currentPos++] = (valn << 13) >>> 31; // 10
		out[currentPos++] = (valn << 14) >>> 31;
		out[currentPos++] = (valn << 15) >>> 31;
		out[currentPos++] = (valn << 16) >>> 31;
		out[currentPos++] = (valn << 17) >>> 31;
		out[currentPos++] = (valn << 18) >>> 31;
		out[currentPos++] = (valn << 19) >>> 31;
		out[currentPos++] = (valn << 20) >>> 31;
		out[currentPos++] = (valn << 21) >>> 31;
		out[currentPos++] = (valn << 22) >>> 31;
		out[currentPos++] = (valn << 23) >>> 31; // 20
		out[currentPos++] = (valn << 24) >>> 31;
		out[currentPos++] = (valn << 25) >>> 31;
		out[currentPos++] = (valn << 26) >>> 31;
		out[currentPos++] = (valn << 27) >>> 31;
		out[currentPos++] = (valn << 28) >>> 31;
		out[currentPos++] = (valn << 29) >>> 31;
		out[currentPos++] = (valn << 30) >>> 31;
		out[currentPos++] = (valn << 31) >>> 31;
	}

	private void decode71(int val, int valn, int[] out, int currentPos) {
		// number : 2, bitwidth : 14
		out[currentPos++] = (val << 8) >>> 18;
		out[currentPos++] = (val << 22) >>> 18 | (valn >>> 28);
		// number : 1, bitwidth : 28
		out[currentPos++] = (valn << 4) >>> 4;
	}

	private void decode70(int val, int valn, int[] out, int currentPos) {
		// number : 2, bitwidth : 14
		out[currentPos++] = (val << 8) >>> 18;
		out[currentPos++] = (val << 22) >>> 18 | (valn >>> 28);
		// number : 2, bitwidth : 14
		out[currentPos++] = (valn << 4) >>> 18;
		out[currentPos++] = (valn << 18) >>> 18;
	}

	private void decode69(int val, int valn, int[] out, int currentPos) {
		// number : 2, bitwidth : 14
		out[currentPos++] = (val << 8) >>> 18;
		out[currentPos++] = (val << 22) >>> 18 | (valn >>> 27);
		// number : 3, bitwidth : 9
		out[currentPos++] = (valn << 5) >>> 23;
		out[currentPos++] = (valn << 14) >>> 23;
		out[currentPos++] = (valn << 23) >>> 23;
	}

	private void decode68(int val, int valn, int[] out, int currentPos) {
		// number : 2, bitwidth : 14
		out[currentPos++] = (val << 8) >>> 18;
		out[currentPos++] = (val << 22) >>> 18 | (valn >>> 28);
		// number : 4, bitwidth : 7
		out[currentPos++] = (valn << 4) >>> 25;
		out[currentPos++] = (valn << 11) >>> 25;
		out[currentPos++] = (valn << 18) >>> 25;
		out[currentPos++] = (valn << 25) >>> 25;
	}

	private void decode67(int val, int valn, int[] out, int currentPos) {
		// number : 2, bitwidth : 14
		out[currentPos++] = (val << 8) >>> 18;
		out[currentPos++] = (val << 22) >>> 18 | (valn >>> 25);
		// number : 5, bitwidth : 5
		out[currentPos++] = (valn << 7) >>> 27;
		out[currentPos++] = (valn << 12) >>> 27;
		out[currentPos++] = (valn << 17) >>> 27;
		out[currentPos++] = (valn << 22) >>> 27;
		out[currentPos++] = (valn << 27) >>> 27;
	}

	private void decode66(int val, int valn, int[] out, int currentPos) {
		// number : 2, bitwidth : 14
		out[currentPos++] = (val << 8) >>> 18;
		out[currentPos++] = (val << 22) >>> 18 | (valn >>> 28);
		// number : 7, bitwidth : 4
		out[currentPos++] = (valn << 4) >>> 28;
		out[currentPos++] = (valn << 8) >>> 28;
		out[currentPos++] = (valn << 12) >>> 28;
		out[currentPos++] = (valn << 16) >>> 28;
		out[currentPos++] = (valn << 20) >>> 28;
		out[currentPos++] = (valn << 24) >>> 28;
		out[currentPos++] = (valn << 28) >>> 28;
	}

	private void decode65(int val, int valn, int[] out, int currentPos) {
		// number : 2, bitwidth : 14
		out[currentPos++] = (val << 8) >>> 18;
		out[currentPos++] = (val << 22) >>> 18 | (valn >>> 27);
		// number : 9, bitwidth : 3
		out[currentPos++] = (valn << 5) >>> 29;
		out[currentPos++] = (valn << 8) >>> 29;
		out[currentPos++] = (valn << 11) >>> 29;
		out[currentPos++] = (valn << 14) >>> 29;
		out[currentPos++] = (valn << 17) >>> 29;
		out[currentPos++] = (valn << 20) >>> 29;
		out[currentPos++] = (valn << 23) >>> 29;
		out[currentPos++] = (valn << 26) >>> 29;
		out[currentPos++] = (valn << 29) >>> 29;
	}

	private void decode64(int val, int valn, int[] out, int currentPos) {
		// number : 2, bitwidth : 14
		out[currentPos++] = (val << 8) >>> 18;
		out[currentPos++] = (val << 22) >>> 18 | (valn >>> 28);
		// number : 14, bitwidth : 2
		out[currentPos++] = (valn << 4) >>> 30;
		out[currentPos++] = (valn << 6) >>> 30;
		out[currentPos++] = (valn << 8) >>> 30;
		out[currentPos++] = (valn << 10) >>> 30;
		out[currentPos++] = (valn << 12) >>> 30;
		out[currentPos++] = (valn << 14) >>> 30;
		out[currentPos++] = (valn << 16) >>> 30;
		out[currentPos++] = (valn << 18) >>> 30;
		out[currentPos++] = (valn << 20) >>> 30;
		out[currentPos++] = (valn << 22) >>> 30; // 10
		out[currentPos++] = (valn << 24) >>> 30;
		out[currentPos++] = (valn << 26) >>> 30;
		out[currentPos++] = (valn << 28) >>> 30;
		out[currentPos++] = (valn << 30) >>> 30;
	}

	private void decode63(int val, int valn, int[] out, int currentPos) {
		// number : 2, bitwidth : 14
		out[currentPos++] = (val << 8) >>> 18;
		out[currentPos++] = (val << 22) >>> 18 | (valn >>> 28);
		// number : 28, bitwidth : 1
		out[currentPos++] = (valn << 4) >>> 31;
		out[currentPos++] = (valn << 5) >>> 31;
		out[currentPos++] = (valn << 6) >>> 31;
		out[currentPos++] = (valn << 7) >>> 31;
		out[currentPos++] = (valn << 8) >>> 31;
		out[currentPos++] = (valn << 9) >>> 31;
		out[currentPos++] = (valn << 10) >>> 31;
		out[currentPos++] = (valn << 11) >>> 31;
		out[currentPos++] = (valn << 12) >>> 31;
		out[currentPos++] = (valn << 13) >>> 31; // 10
		out[currentPos++] = (valn << 14) >>> 31;
		out[currentPos++] = (valn << 15) >>> 31;
		out[currentPos++] = (valn << 16) >>> 31;
		out[currentPos++] = (valn << 17) >>> 31;
		out[currentPos++] = (valn << 18) >>> 31;
		out[currentPos++] = (valn << 19) >>> 31;
		out[currentPos++] = (valn << 20) >>> 31;
		out[currentPos++] = (valn << 21) >>> 31;
		out[currentPos++] = (valn << 22) >>> 31;
		out[currentPos++] = (valn << 23) >>> 31; // 20
		out[currentPos++] = (valn << 24) >>> 31;
		out[currentPos++] = (valn << 25) >>> 31;
		out[currentPos++] = (valn << 26) >>> 31;
		out[currentPos++] = (valn << 27) >>> 31;
		out[currentPos++] = (valn << 28) >>> 31;
		out[currentPos++] = (valn << 29) >>> 31;
		out[currentPos++] = (valn << 30) >>> 31;
		out[currentPos++] = (valn << 31) >>> 31;
	}

	private void decode62(int val, int valn, int[] out, int currentPos) {
		// number : 3, bitwidth : 9
		out[currentPos++] = (val << 8) >>> 23;
		out[currentPos++] = (val << 17) >>> 23;
		out[currentPos++] = (val << 26) >>> 23 | (valn >>> 28);
		// number : 1, bitwidth : 28
		out[currentPos++] = (valn << 4) >>> 4;
	}

	private void decode61(int val, int valn, int[] out, int currentPos) {
		// number : 3, bitwidth : 9
		out[currentPos++] = (val << 8) >>> 23;
		out[currentPos++] = (val << 17) >>> 23;
		out[currentPos++] = (val << 26) >>> 23 | (valn >>> 28);
		// number : 2, bitwidth : 14
		out[currentPos++] = (valn << 4) >>> 18;
		out[currentPos++] = (valn << 18) >>> 18;
	}

	private void decode60(int val, int valn, int[] out, int currentPos) {
		// number : 3, bitwidth : 9
		out[currentPos++] = (val << 8) >>> 23;
		out[currentPos++] = (val << 17) >>> 23;
		out[currentPos++] = (val << 26) >>> 23 | (valn >>> 27);
		// number : 3, bitwidth : 9
		out[currentPos++] = (valn << 5) >>> 23;
		out[currentPos++] = (valn << 14) >>> 23;
		out[currentPos++] = (valn << 23) >>> 23;
	}

	private void decode59(int val, int valn, int[] out, int currentPos) {
		// number : 3, bitwidth : 9
		out[currentPos++] = (val << 8) >>> 23;
		out[currentPos++] = (val << 17) >>> 23;
		out[currentPos++] = (val << 26) >>> 23 | (valn >>> 28);
		// number : 4, bitwidth : 7
		out[currentPos++] = (valn << 4) >>> 25;
		out[currentPos++] = (valn << 11) >>> 25;
		out[currentPos++] = (valn << 18) >>> 25;
		out[currentPos++] = (valn << 25) >>> 25;
	}

	private void decode58(int val, int valn, int[] out, int currentPos) {
		// number : 3, bitwidth : 9
		out[currentPos++] = (val << 8) >>> 23;
		out[currentPos++] = (val << 17) >>> 23;
		out[currentPos++] = (val << 26) >>> 23 | (valn >>> 25);
		// number : 5, bitwidth : 5
		out[currentPos++] = (valn << 7) >>> 27;
		out[currentPos++] = (valn << 12) >>> 27;
		out[currentPos++] = (valn << 17) >>> 27;
		out[currentPos++] = (valn << 22) >>> 27;
		out[currentPos++] = (valn << 27) >>> 27;
	}

	private void decode57(int val, int valn, int[] out, int currentPos) {
		// number : 3, bitwidth : 9
		out[currentPos++] = (val << 8) >>> 23;
		out[currentPos++] = (val << 17) >>> 23;
		out[currentPos++] = (val << 26) >>> 23 | (valn >>> 28);
		// number : 7, bitwidth : 4
		out[currentPos++] = (valn << 4) >>> 28;
		out[currentPos++] = (valn << 8) >>> 28;
		out[currentPos++] = (valn << 12) >>> 28;
		out[currentPos++] = (valn << 16) >>> 28;
		out[currentPos++] = (valn << 20) >>> 28;
		out[currentPos++] = (valn << 24) >>> 28;
		out[currentPos++] = (valn << 28) >>> 28;
	}

	private void decode56(int val, int valn, int[] out, int currentPos) {
		// number : 3, bitwidth : 9
		out[currentPos++] = (val << 8) >>> 23;
		out[currentPos++] = (val << 17) >>> 23;
		out[currentPos++] = (val << 26) >>> 23 | (valn >>> 27);
		// number : 9, bitwidth : 3
		out[currentPos++] = (valn << 5) >>> 29;
		out[currentPos++] = (valn << 8) >>> 29;
		out[currentPos++] = (valn << 11) >>> 29;
		out[currentPos++] = (valn << 14) >>> 29;
		out[currentPos++] = (valn << 17) >>> 29;
		out[currentPos++] = (valn << 20) >>> 29;
		out[currentPos++] = (valn << 23) >>> 29;
		out[currentPos++] = (valn << 26) >>> 29;
		out[currentPos++] = (valn << 29) >>> 29;
	}

	private void decode55(int val, int valn, int[] out, int currentPos) {
		// number : 3, bitwidth : 9
		out[currentPos++] = (val << 8) >>> 23;
		out[currentPos++] = (val << 17) >>> 23;
		out[currentPos++] = (val << 26) >>> 23 | (valn >>> 28);
		// number : 14, bitwidth : 2
		out[currentPos++] = (valn << 4) >>> 30;
		out[currentPos++] = (valn << 6) >>> 30;
		out[currentPos++] = (valn << 8) >>> 30;
		out[currentPos++] = (valn << 10) >>> 30;
		out[currentPos++] = (valn << 12) >>> 30;
		out[currentPos++] = (valn << 14) >>> 30;
		out[currentPos++] = (valn << 16) >>> 30;
		out[currentPos++] = (valn << 18) >>> 30;
		out[currentPos++] = (valn << 20) >>> 30;
		out[currentPos++] = (valn << 22) >>> 30; // 10
		out[currentPos++] = (valn << 24) >>> 30;
		out[currentPos++] = (valn << 26) >>> 30;
		out[currentPos++] = (valn << 28) >>> 30;
		out[currentPos++] = (valn << 30) >>> 30;
	}

	private void decode54(int val, int valn, int[] out, int currentPos) {
		// number : 3, bitwidth : 9
		out[currentPos++] = (val << 8) >>> 23;
		out[currentPos++] = (val << 17) >>> 23;
		out[currentPos++] = (val << 26) >>> 23 | (valn >>> 28);
		// number : 28, bitwidth : 1
		out[currentPos++] = (valn << 4) >>> 31;
		out[currentPos++] = (valn << 5) >>> 31;
		out[currentPos++] = (valn << 6) >>> 31;
		out[currentPos++] = (valn << 7) >>> 31;
		out[currentPos++] = (valn << 8) >>> 31;
		out[currentPos++] = (valn << 9) >>> 31;
		out[currentPos++] = (valn << 10) >>> 31;
		out[currentPos++] = (valn << 11) >>> 31;
		out[currentPos++] = (valn << 12) >>> 31;
		out[currentPos++] = (valn << 13) >>> 31; // 10
		out[currentPos++] = (valn << 14) >>> 31;
		out[currentPos++] = (valn << 15) >>> 31;
		out[currentPos++] = (valn << 16) >>> 31;
		out[currentPos++] = (valn << 17) >>> 31;
		out[currentPos++] = (valn << 18) >>> 31;
		out[currentPos++] = (valn << 19) >>> 31;
		out[currentPos++] = (valn << 20) >>> 31;
		out[currentPos++] = (valn << 21) >>> 31;
		out[currentPos++] = (valn << 22) >>> 31;
		out[currentPos++] = (valn << 23) >>> 31; // 20
		out[currentPos++] = (valn << 24) >>> 31;
		out[currentPos++] = (valn << 25) >>> 31;
		out[currentPos++] = (valn << 26) >>> 31;
		out[currentPos++] = (valn << 27) >>> 31;
		out[currentPos++] = (valn << 28) >>> 31;
		out[currentPos++] = (valn << 29) >>> 31;
		out[currentPos++] = (valn << 30) >>> 31;
		out[currentPos++] = (valn << 31) >>> 31;
	}

	private void decode53(int val, int valn, int[] out, int currentPos) {
		// number : 4, bitwidth : 7
		out[currentPos++] = (val << 8) >>> 25;
		out[currentPos++] = (val << 15) >>> 25;
		out[currentPos++] = (val << 22) >>> 25;
		out[currentPos++] = (val << 29) >>> 25 | (valn >>> 28);
		// number : 1, bitwidth : 28
		out[currentPos++] = (valn << 4) >>> 4;
	}

	private void decode52(int val, int valn, int[] out, int currentPos) {
		// number : 4, bitwidth : 7
		out[currentPos++] = (val << 8) >>> 25;
		out[currentPos++] = (val << 15) >>> 25;
		out[currentPos++] = (val << 22) >>> 25;
		out[currentPos++] = (val << 29) >>> 25 | (valn >>> 28);
		// number : 2, bitwidth : 14
		out[currentPos++] = (valn << 4) >>> 18;
		out[currentPos++] = (valn << 18) >>> 18;
	}

	private void decode51(int val, int valn, int[] out, int currentPos) {
		// number : 4, bitwidth : 7
		out[currentPos++] = (val << 8) >>> 25;
		out[currentPos++] = (val << 15) >>> 25;
		out[currentPos++] = (val << 22) >>> 25;
		out[currentPos++] = (val << 29) >>> 25 | (valn >>> 27);
		// number : 3, bitwidth : 9
		out[currentPos++] = (valn << 5) >>> 23;
		out[currentPos++] = (valn << 14) >>> 23;
		out[currentPos++] = (valn << 23) >>> 23;
	}

	private void decode50(int val, int valn, int[] out, int currentPos) {
		// number : 4, bitwidth : 7
		out[currentPos++] = (val << 8) >>> 25;
		out[currentPos++] = (val << 15) >>> 25;
		out[currentPos++] = (val << 22) >>> 25;
		out[currentPos++] = (val << 29) >>> 25 | (valn >>> 28);
		// number : 4, bitwidth : 7
		out[currentPos++] = (valn << 4) >>> 25;
		out[currentPos++] = (valn << 11) >>> 25;
		out[currentPos++] = (valn << 18) >>> 25;
		out[currentPos++] = (valn << 25) >>> 25;
	}

	private void decode49(int val, int valn, int[] out, int currentPos) {
		// number : 4, bitwidth : 7
		out[currentPos++] = (val << 8) >>> 25;
		out[currentPos++] = (val << 15) >>> 25;
		out[currentPos++] = (val << 22) >>> 25;
		out[currentPos++] = (val << 29) >>> 25 | (valn >>> 25);
		// number : 5, bitwidth : 5
		out[currentPos++] = (valn << 7) >>> 27;
		out[currentPos++] = (valn << 12) >>> 27;
		out[currentPos++] = (valn << 17) >>> 27;
		out[currentPos++] = (valn << 22) >>> 27;
		out[currentPos++] = (valn << 27) >>> 27;
	}

	private void decode48(int val, int valn, int[] out, int currentPos) {
		// number : 4, bitwidth : 7
		out[currentPos++] = (val << 8) >>> 25;
		out[currentPos++] = (val << 15) >>> 25;
		out[currentPos++] = (val << 22) >>> 25;
		out[currentPos++] = (val << 29) >>> 25 | (valn >>> 28);
		// number : 7, bitwidth : 4
		out[currentPos++] = (valn << 4) >>> 28;
		out[currentPos++] = (valn << 8) >>> 28;
		out[currentPos++] = (valn << 12) >>> 28;
		out[currentPos++] = (valn << 16) >>> 28;
		out[currentPos++] = (valn << 20) >>> 28;
		out[currentPos++] = (valn << 24) >>> 28;
		out[currentPos++] = (valn << 28) >>> 28;
	}

	private void decode47(int val, int valn, int[] out, int currentPos) {
		// number : 4, bitwidth : 7
		out[currentPos++] = (val << 8) >>> 25;
		out[currentPos++] = (val << 15) >>> 25;
		out[currentPos++] = (val << 22) >>> 25;
		out[currentPos++] = (val << 29) >>> 25 | (valn >>> 27);
		// number : 9, bitwidth : 3
		out[currentPos++] = (valn << 5) >>> 29;
		out[currentPos++] = (valn << 8) >>> 29;
		out[currentPos++] = (valn << 11) >>> 29;
		out[currentPos++] = (valn << 14) >>> 29;
		out[currentPos++] = (valn << 17) >>> 29;
		out[currentPos++] = (valn << 20) >>> 29;
		out[currentPos++] = (valn << 23) >>> 29;
		out[currentPos++] = (valn << 26) >>> 29;
		out[currentPos++] = (valn << 29) >>> 29;
	}

	private void decode46(int val, int valn, int[] out, int currentPos) {
		// number : 4, bitwidth : 7
		out[currentPos++] = (val << 8) >>> 25;
		out[currentPos++] = (val << 15) >>> 25;
		out[currentPos++] = (val << 22) >>> 25;
		out[currentPos++] = (val << 29) >>> 25 | (valn >>> 28);
		// number : 14, bitwidth : 2
		out[currentPos++] = (valn << 4) >>> 30;
		out[currentPos++] = (valn << 6) >>> 30;
		out[currentPos++] = (valn << 8) >>> 30;
		out[currentPos++] = (valn << 10) >>> 30;
		out[currentPos++] = (valn << 12) >>> 30;
		out[currentPos++] = (valn << 14) >>> 30;
		out[currentPos++] = (valn << 16) >>> 30;
		out[currentPos++] = (valn << 18) >>> 30;
		out[currentPos++] = (valn << 20) >>> 30;
		out[currentPos++] = (valn << 22) >>> 30; // 10
		out[currentPos++] = (valn << 24) >>> 30;
		out[currentPos++] = (valn << 26) >>> 30;
		out[currentPos++] = (valn << 28) >>> 30;
		out[currentPos++] = (valn << 30) >>> 30;
	}

	private void decode45(int val, int valn, int[] out, int currentPos) {
		// number : 4, bitwidth : 7
		out[currentPos++] = (val << 8) >>> 25;
		out[currentPos++] = (val << 15) >>> 25;
		out[currentPos++] = (val << 22) >>> 25;
		out[currentPos++] = (val << 29) >>> 25 | (valn >>> 28);
		// number : 28, bitwidth : 1
		out[currentPos++] = (valn << 4) >>> 31;
		out[currentPos++] = (valn << 5) >>> 31;
		out[currentPos++] = (valn << 6) >>> 31;
		out[currentPos++] = (valn << 7) >>> 31;
		out[currentPos++] = (valn << 8) >>> 31;
		out[currentPos++] = (valn << 9) >>> 31;
		out[currentPos++] = (valn << 10) >>> 31;
		out[currentPos++] = (valn << 11) >>> 31;
		out[currentPos++] = (valn << 12) >>> 31;
		out[currentPos++] = (valn << 13) >>> 31; // 10
		out[currentPos++] = (valn << 14) >>> 31;
		out[currentPos++] = (valn << 15) >>> 31;
		out[currentPos++] = (valn << 16) >>> 31;
		out[currentPos++] = (valn << 17) >>> 31;
		out[currentPos++] = (valn << 18) >>> 31;
		out[currentPos++] = (valn << 19) >>> 31;
		out[currentPos++] = (valn << 20) >>> 31;
		out[currentPos++] = (valn << 21) >>> 31;
		out[currentPos++] = (valn << 22) >>> 31;
		out[currentPos++] = (valn << 23) >>> 31; // 20
		out[currentPos++] = (valn << 24) >>> 31;
		out[currentPos++] = (valn << 25) >>> 31;
		out[currentPos++] = (valn << 26) >>> 31;
		out[currentPos++] = (valn << 27) >>> 31;
		out[currentPos++] = (valn << 28) >>> 31;
		out[currentPos++] = (valn << 29) >>> 31;
		out[currentPos++] = (valn << 30) >>> 31;
		out[currentPos++] = (valn << 31) >>> 31;
	}

	private void decode44(int val, int valn, int[] out, int currentPos) {
		// number : 5, bitwidth : 5
		out[currentPos++] = (val << 8) >>> 27;
		out[currentPos++] = (val << 13) >>> 27;
		out[currentPos++] = (val << 18) >>> 27;
		out[currentPos++] = (val << 23) >>> 27;
		out[currentPos++] = (val << 28) >>> 27 | (valn >>> 28);
		// number : 1, bitwidth : 28
		out[currentPos++] = (valn << 4) >>> 4;
	}

	private void decode43(int val, int valn, int[] out, int currentPos) {
		// number : 5, bitwidth : 5
		out[currentPos++] = (val << 8) >>> 27;
		out[currentPos++] = (val << 13) >>> 27;
		out[currentPos++] = (val << 18) >>> 27;
		out[currentPos++] = (val << 23) >>> 27;
		out[currentPos++] = (val << 28) >>> 27 | (valn >>> 28);
		// number : 2, bitwidth : 14
		out[currentPos++] = (valn << 4) >>> 18;
		out[currentPos++] = (valn << 18) >>> 18;
	}

	private void decode42(int val, int valn, int[] out, int currentPos) {
		// number : 5, bitwidth : 5
		out[currentPos++] = (val << 8) >>> 27;
		out[currentPos++] = (val << 13) >>> 27;
		out[currentPos++] = (val << 18) >>> 27;
		out[currentPos++] = (val << 23) >>> 27;
		out[currentPos++] = (val << 28) >>> 27 | (valn >>> 27);
		// number : 3, bitwidth : 9
		out[currentPos++] = (valn << 5) >>> 23;
		out[currentPos++] = (valn << 14) >>> 23;
		out[currentPos++] = (valn << 23) >>> 23;
	}

	private void decode41(int val, int valn, int[] out, int currentPos) {
		// number : 5, bitwidth : 5
		out[currentPos++] = (val << 8) >>> 27;
		out[currentPos++] = (val << 13) >>> 27;
		out[currentPos++] = (val << 18) >>> 27;
		out[currentPos++] = (val << 23) >>> 27;
		out[currentPos++] = (val << 28) >>> 27 | (valn >>> 28);
		// number : 4, bitwidth : 7
		out[currentPos++] = (valn << 4) >>> 25;
		out[currentPos++] = (valn << 11) >>> 25;
		out[currentPos++] = (valn << 18) >>> 25;
		out[currentPos++] = (valn << 25) >>> 25;
	}

	private void decode40(int val, int valn, int[] out, int currentPos) {
		// number : 5, bitwidth : 5
		out[currentPos++] = (val << 8) >>> 27;
		out[currentPos++] = (val << 13) >>> 27;
		out[currentPos++] = (val << 18) >>> 27;
		out[currentPos++] = (val << 23) >>> 27;
		out[currentPos++] = (val << 28) >>> 27 | (valn >>> 25);
		// number : 5, bitwidth : 5
		out[currentPos++] = (valn << 7) >>> 27;
		out[currentPos++] = (valn << 12) >>> 27;
		out[currentPos++] = (valn << 17) >>> 27;
		out[currentPos++] = (valn << 22) >>> 27;
		out[currentPos++] = (valn << 27) >>> 27;
	}

	private void decode39(int val, int valn, int[] out, int currentPos) {
		// number : 5, bitwidth : 5
		out[currentPos++] = (val << 8) >>> 27;
		out[currentPos++] = (val << 13) >>> 27;
		out[currentPos++] = (val << 18) >>> 27;
		out[currentPos++] = (val << 23) >>> 27;
		out[currentPos++] = (val << 28) >>> 27 | (valn >>> 28);
		// number : 7, bitwidth : 4
		out[currentPos++] = (valn << 4) >>> 28;
		out[currentPos++] = (valn << 8) >>> 28;
		out[currentPos++] = (valn << 12) >>> 28;
		out[currentPos++] = (valn << 16) >>> 28;
		out[currentPos++] = (valn << 20) >>> 28;
		out[currentPos++] = (valn << 24) >>> 28;
		out[currentPos++] = (valn << 28) >>> 28;
	}

	private void decode38(int val, int valn, int[] out, int currentPos) {
		// number : 5, bitwidth : 5
		out[currentPos++] = (val << 8) >>> 27;
		out[currentPos++] = (val << 13) >>> 27;
		out[currentPos++] = (val << 18) >>> 27;
		out[currentPos++] = (val << 23) >>> 27;
		out[currentPos++] = (val << 28) >>> 27 | (valn >>> 27);
		// number : 9, bitwidth : 3
		out[currentPos++] = (valn << 5) >>> 29;
		out[currentPos++] = (valn << 8) >>> 29;
		out[currentPos++] = (valn << 11) >>> 29;
		out[currentPos++] = (valn << 14) >>> 29;
		out[currentPos++] = (valn << 17) >>> 29;
		out[currentPos++] = (valn << 20) >>> 29;
		out[currentPos++] = (valn << 23) >>> 29;
		out[currentPos++] = (valn << 26) >>> 29;
		out[currentPos++] = (valn << 29) >>> 29;
	}

	private void decode37(int val, int valn, int[] out, int currentPos) {
		// number : 5, bitwidth : 5
		out[currentPos++] = (val << 8) >>> 27;
		out[currentPos++] = (val << 13) >>> 27;
		out[currentPos++] = (val << 18) >>> 27;
		out[currentPos++] = (val << 23) >>> 27;
		out[currentPos++] = (val << 28) >>> 27 | (valn >>> 28);
		// number : 14, bitwidth : 2
		out[currentPos++] = (valn << 4) >>> 30;
		out[currentPos++] = (valn << 6) >>> 30;
		out[currentPos++] = (valn << 8) >>> 30;
		out[currentPos++] = (valn << 10) >>> 30;
		out[currentPos++] = (valn << 12) >>> 30;
		out[currentPos++] = (valn << 14) >>> 30;
		out[currentPos++] = (valn << 16) >>> 30;
		out[currentPos++] = (valn << 18) >>> 30;
		out[currentPos++] = (valn << 20) >>> 30;
		out[currentPos++] = (valn << 22) >>> 30; // 10
		out[currentPos++] = (valn << 24) >>> 30;
		out[currentPos++] = (valn << 26) >>> 30;
		out[currentPos++] = (valn << 28) >>> 30;
		out[currentPos++] = (valn << 30) >>> 30;
	}

	private void decode36(int val, int valn, int[] out, int currentPos) {
		// number : 5, bitwidth : 5
		out[currentPos++] = (val << 8) >>> 27;
		out[currentPos++] = (val << 13) >>> 27;
		out[currentPos++] = (val << 18) >>> 27;
		out[currentPos++] = (val << 23) >>> 27;
		out[currentPos++] = (val << 28) >>> 27 | (valn >>> 28);
		// number : 28, bitwidth : 1
		out[currentPos++] = (valn << 4) >>> 31;
		out[currentPos++] = (valn << 5) >>> 31;
		out[currentPos++] = (valn << 6) >>> 31;
		out[currentPos++] = (valn << 7) >>> 31;
		out[currentPos++] = (valn << 8) >>> 31;
		out[currentPos++] = (valn << 9) >>> 31;
		out[currentPos++] = (valn << 10) >>> 31;
		out[currentPos++] = (valn << 11) >>> 31;
		out[currentPos++] = (valn << 12) >>> 31;
		out[currentPos++] = (valn << 13) >>> 31; // 10
		out[currentPos++] = (valn << 14) >>> 31;
		out[currentPos++] = (valn << 15) >>> 31;
		out[currentPos++] = (valn << 16) >>> 31;
		out[currentPos++] = (valn << 17) >>> 31;
		out[currentPos++] = (valn << 18) >>> 31;
		out[currentPos++] = (valn << 19) >>> 31;
		out[currentPos++] = (valn << 20) >>> 31;
		out[currentPos++] = (valn << 21) >>> 31;
		out[currentPos++] = (valn << 22) >>> 31;
		out[currentPos++] = (valn << 23) >>> 31; // 20
		out[currentPos++] = (valn << 24) >>> 31;
		out[currentPos++] = (valn << 25) >>> 31;
		out[currentPos++] = (valn << 26) >>> 31;
		out[currentPos++] = (valn << 27) >>> 31;
		out[currentPos++] = (valn << 28) >>> 31;
		out[currentPos++] = (valn << 29) >>> 31;
		out[currentPos++] = (valn << 30) >>> 31;
		out[currentPos++] = (valn << 31) >>> 31;
	}

	private void decode35(int val, int valn, int[] out, int currentPos) {
		// number : 7, bitwidth : 4
		out[currentPos++] = (val << 8) >>> 28;
		out[currentPos++] = (val << 12) >>> 28;
		out[currentPos++] = (val << 16) >>> 28;
		out[currentPos++] = (val << 20) >>> 28;
		out[currentPos++] = (val << 24) >>> 28;
		out[currentPos++] = (val << 28) >>> 28;
		out[currentPos++] = (valn << 0) >>> 28;
		// number : 1, bitwidth : 28
		out[currentPos++] = (valn << 4) >>> 4;
	}

	private void decode34(int val, int valn, int[] out, int currentPos) {
		// number : 7, bitwidth : 4
		out[currentPos++] = (val << 8) >>> 28;
		out[currentPos++] = (val << 12) >>> 28;
		out[currentPos++] = (val << 16) >>> 28;
		out[currentPos++] = (val << 20) >>> 28;
		out[currentPos++] = (val << 24) >>> 28;
		out[currentPos++] = (val << 28) >>> 28;
		out[currentPos++] = (valn << 0) >>> 28;
		// number : 2, bitwidth : 14
		out[currentPos++] = (valn << 4) >>> 18;
		out[currentPos++] = (valn << 18) >>> 18;
	}

	private void decode33(int val, int valn, int[] out, int currentPos) {
		// number : 7, bitwidth : 4
		out[currentPos++] = (val << 8) >>> 28;
		out[currentPos++] = (val << 12) >>> 28;
		out[currentPos++] = (val << 16) >>> 28;
		out[currentPos++] = (val << 20) >>> 28;
		out[currentPos++] = (val << 24) >>> 28;
		out[currentPos++] = (val << 28) >>> 28;
		out[currentPos++] = (valn << 1) >>> 28;
		// number : 3, bitwidth : 9
		out[currentPos++] = (valn << 5) >>> 23;
		out[currentPos++] = (valn << 14) >>> 23;
		out[currentPos++] = (valn << 23) >>> 23;
	}

	private void decode32(int val, int valn, int[] out, int currentPos) {
		// number : 7, bitwidth : 4
		out[currentPos++] = (val << 8) >>> 28;
		out[currentPos++] = (val << 12) >>> 28;
		out[currentPos++] = (val << 16) >>> 28;
		out[currentPos++] = (val << 20) >>> 28;
		out[currentPos++] = (val << 24) >>> 28;
		out[currentPos++] = (val << 28) >>> 28;
		out[currentPos++] = (valn << 0) >>> 28;
		// number : 4, bitwidth : 7
		out[currentPos++] = (valn << 4) >>> 25;
		out[currentPos++] = (valn << 11) >>> 25;
		out[currentPos++] = (valn << 18) >>> 25;
		out[currentPos++] = (valn << 25) >>> 25;
	}

	private void decode31(int val, int valn, int[] out, int currentPos) {
		// number : 7, bitwidth : 4
		out[currentPos++] = (val << 8) >>> 28;
		out[currentPos++] = (val << 12) >>> 28;
		out[currentPos++] = (val << 16) >>> 28;
		out[currentPos++] = (val << 20) >>> 28;
		out[currentPos++] = (val << 24) >>> 28;
		out[currentPos++] = (val << 28) >>> 28;
		out[currentPos++] = (valn << 3) >>> 28;
		// number : 5, bitwidth : 5
		out[currentPos++] = (valn << 7) >>> 27;
		out[currentPos++] = (valn << 12) >>> 27;
		out[currentPos++] = (valn << 17) >>> 27;
		out[currentPos++] = (valn << 22) >>> 27;
		out[currentPos++] = (valn << 27) >>> 27;
	}

	private void decode30(int val, int valn, int[] out, int currentPos) {
		// number : 7, bitwidth : 4
		out[currentPos++] = (val << 8) >>> 28;
		out[currentPos++] = (val << 12) >>> 28;
		out[currentPos++] = (val << 16) >>> 28;
		out[currentPos++] = (val << 20) >>> 28;
		out[currentPos++] = (val << 24) >>> 28;
		out[currentPos++] = (val << 28) >>> 28;
		out[currentPos++] = (valn << 0) >>> 28;
		// number : 7, bitwidth : 4
		out[currentPos++] = (valn << 4) >>> 28;
		out[currentPos++] = (valn << 8) >>> 28;
		out[currentPos++] = (valn << 12) >>> 28;
		out[currentPos++] = (valn << 16) >>> 28;
		out[currentPos++] = (valn << 20) >>> 28;
		out[currentPos++] = (valn << 24) >>> 28;
		out[currentPos++] = (valn << 28) >>> 28;
	}

	private void decode29(int val, int valn, int[] out, int currentPos) {
		// number : 7, bitwidth : 4
		out[currentPos++] = (val << 8) >>> 28;
		out[currentPos++] = (val << 12) >>> 28;
		out[currentPos++] = (val << 16) >>> 28;
		out[currentPos++] = (val << 20) >>> 28;
		out[currentPos++] = (val << 24) >>> 28;
		out[currentPos++] = (val << 28) >>> 28;
		out[currentPos++] = (valn << 1) >>> 28;
		// number : 9, bitwidth : 3
		out[currentPos++] = (valn << 5) >>> 29;
		out[currentPos++] = (valn << 8) >>> 29;
		out[currentPos++] = (valn << 11) >>> 29;
		out[currentPos++] = (valn << 14) >>> 29;
		out[currentPos++] = (valn << 17) >>> 29;
		out[currentPos++] = (valn << 20) >>> 29;
		out[currentPos++] = (valn << 23) >>> 29;
		out[currentPos++] = (valn << 26) >>> 29;
		out[currentPos++] = (valn << 29) >>> 29;
	}

	private void decode28(int val, int valn, int[] out, int currentPos) {
		// number : 7, bitwidth : 4
		out[currentPos++] = (val << 8) >>> 28;
		out[currentPos++] = (val << 12) >>> 28;
		out[currentPos++] = (val << 16) >>> 28;
		out[currentPos++] = (val << 20) >>> 28;
		out[currentPos++] = (val << 24) >>> 28;
		out[currentPos++] = (val << 28) >>> 28;
		out[currentPos++] = (valn << 0) >>> 28;
		// number : 14, bitwidth : 2
		out[currentPos++] = (valn << 4) >>> 30;
		out[currentPos++] = (valn << 6) >>> 30;
		out[currentPos++] = (valn << 8) >>> 30;
		out[currentPos++] = (valn << 10) >>> 30;
		out[currentPos++] = (valn << 12) >>> 30;
		out[currentPos++] = (valn << 14) >>> 30;
		out[currentPos++] = (valn << 16) >>> 30;
		out[currentPos++] = (valn << 18) >>> 30;
		out[currentPos++] = (valn << 20) >>> 30;
		out[currentPos++] = (valn << 22) >>> 30; // 10
		out[currentPos++] = (valn << 24) >>> 30;
		out[currentPos++] = (valn << 26) >>> 30;
		out[currentPos++] = (valn << 28) >>> 30;
		out[currentPos++] = (valn << 30) >>> 30;
	}

	private void decode27(int val, int valn, int[] out, int currentPos) {
		// number : 7, bitwidth : 4
		out[currentPos++] = (val << 8) >>> 28;
		out[currentPos++] = (val << 12) >>> 28;
		out[currentPos++] = (val << 16) >>> 28;
		out[currentPos++] = (val << 20) >>> 28;
		out[currentPos++] = (val << 24) >>> 28;
		out[currentPos++] = (val << 28) >>> 28;
		out[currentPos++] = (valn << 0) >>> 28;
		// number : 28, bitwidth : 1
		out[currentPos++] = (valn << 4) >>> 31;
		out[currentPos++] = (valn << 5) >>> 31;
		out[currentPos++] = (valn << 6) >>> 31;
		out[currentPos++] = (valn << 7) >>> 31;
		out[currentPos++] = (valn << 8) >>> 31;
		out[currentPos++] = (valn << 9) >>> 31;
		out[currentPos++] = (valn << 10) >>> 31;
		out[currentPos++] = (valn << 11) >>> 31;
		out[currentPos++] = (valn << 12) >>> 31;
		out[currentPos++] = (valn << 13) >>> 31; // 10
		out[currentPos++] = (valn << 14) >>> 31;
		out[currentPos++] = (valn << 15) >>> 31;
		out[currentPos++] = (valn << 16) >>> 31;
		out[currentPos++] = (valn << 17) >>> 31;
		out[currentPos++] = (valn << 18) >>> 31;
		out[currentPos++] = (valn << 19) >>> 31;
		out[currentPos++] = (valn << 20) >>> 31;
		out[currentPos++] = (valn << 21) >>> 31;
		out[currentPos++] = (valn << 22) >>> 31;
		out[currentPos++] = (valn << 23) >>> 31; // 20
		out[currentPos++] = (valn << 24) >>> 31;
		out[currentPos++] = (valn << 25) >>> 31;
		out[currentPos++] = (valn << 26) >>> 31;
		out[currentPos++] = (valn << 27) >>> 31;
		out[currentPos++] = (valn << 28) >>> 31;
		out[currentPos++] = (valn << 29) >>> 31;
		out[currentPos++] = (valn << 30) >>> 31;
		out[currentPos++] = (valn << 31) >>> 31;
	}

	private void decode26(int val, int valn, int[] out, int currentPos) {
		// number : 9, bitwidth : 3
		out[currentPos++] = (val << 8) >>> 29;
		out[currentPos++] = (val << 11) >>> 29;
		out[currentPos++] = (val << 14) >>> 29;
		out[currentPos++] = (val << 17) >>> 29;
		out[currentPos++] = (val << 20) >>> 29;
		out[currentPos++] = (val << 23) >>> 29;
		out[currentPos++] = (val << 26) >>> 29;
		out[currentPos++] = (val << 29) >>> 29;
		out[currentPos++] = (valn << 1) >>> 29;
		// number : 1, bitwidth : 28
		out[currentPos++] = (valn << 4) >>> 4;
	}

	private void decode25(int val, int valn, int[] out, int currentPos) {
		// number : 9, bitwidth : 3
		out[currentPos++] = (val << 8) >>> 29;
		out[currentPos++] = (val << 11) >>> 29;
		out[currentPos++] = (val << 14) >>> 29;
		out[currentPos++] = (val << 17) >>> 29;
		out[currentPos++] = (val << 20) >>> 29;
		out[currentPos++] = (val << 23) >>> 29;
		out[currentPos++] = (val << 26) >>> 29;
		out[currentPos++] = (val << 29) >>> 29;
		out[currentPos++] = (valn << 1) >>> 29;
		// number : 2, bitwidth : 14
		out[currentPos++] = (valn << 4) >>> 18;
		out[currentPos++] = (valn << 18) >>> 18;
	}
	
	private void decode24(int val, int valn, int[] out, int currentPos) {
		// number : 9, bitwidth : 3
		out[currentPos++] = (val << 8) >>> 29;
		out[currentPos++] = (val << 11) >>> 29;
		out[currentPos++] = (val << 14) >>> 29;
		out[currentPos++] = (val << 17) >>> 29;
		out[currentPos++] = (val << 20) >>> 29;
		out[currentPos++] = (val << 23) >>> 29;
		out[currentPos++] = (val << 26) >>> 29;
		out[currentPos++] = (val << 29) >>> 29;
		out[currentPos++] = (valn << 2) >>> 29;
		// number : 3, bitwidth : 9
		out[currentPos++] = (valn << 5) >>> 23;
		out[currentPos++] = (valn << 14) >>> 23;
		out[currentPos++] = (valn << 23) >>> 23;
	}
	
	private void decode23(int val, int valn, int[] out, int currentPos) {
		// number : 9, bitwidth : 3
		out[currentPos++] = (val << 8) >>> 29;
		out[currentPos++] = (val << 11) >>> 29;
		out[currentPos++] = (val << 14) >>> 29;
		out[currentPos++] = (val << 17) >>> 29;
		out[currentPos++] = (val << 20) >>> 29;
		out[currentPos++] = (val << 23) >>> 29;
		out[currentPos++] = (val << 26) >>> 29;
		out[currentPos++] = (val << 29) >>> 29;
		out[currentPos++] = (valn << 1) >>> 29;
		// number : 4, bitwidth : 7
		out[currentPos++] = (valn << 4) >>> 25;
		out[currentPos++] = (valn << 11) >>> 25;
		out[currentPos++] = (valn << 18) >>> 25;
		out[currentPos++] = (valn << 25) >>> 25;
	}

	private void decode22(int val, int valn, int[] out, int currentPos) {
		// number : 9, bitwidth : 3
		out[currentPos++] = (val << 8) >>> 29;
		out[currentPos++] = (val << 11) >>> 29;
		out[currentPos++] = (val << 14) >>> 29;
		out[currentPos++] = (val << 17) >>> 29;
		out[currentPos++] = (val << 20) >>> 29;
		out[currentPos++] = (val << 23) >>> 29;
		out[currentPos++] = (val << 26) >>> 29;
		out[currentPos++] = (val << 29) >>> 29;
		out[currentPos++] = (valn << 4) >>> 29;
		// number : 5, bitwidth : 5
		out[currentPos++] = (valn << 7) >>> 27;
		out[currentPos++] = (valn << 12) >>> 27;
		out[currentPos++] = (valn << 17) >>> 27;
		out[currentPos++] = (valn << 22) >>> 27;
		out[currentPos++] = (valn << 27) >>> 27;
	}

	private void decode21(int val, int valn, int[] out, int currentPos) {
		// number : 9, bitwidth : 3
		out[currentPos++] = (val << 8) >>> 29;
		out[currentPos++] = (val << 11) >>> 29;
		out[currentPos++] = (val << 14) >>> 29;
		out[currentPos++] = (val << 17) >>> 29;
		out[currentPos++] = (val << 20) >>> 29;
		out[currentPos++] = (val << 23) >>> 29;
		out[currentPos++] = (val << 26) >>> 29;
		out[currentPos++] = (val << 29) >>> 29;
		out[currentPos++] = (valn << 1) >>> 29;
		// number : 7, bitwidth : 4
		out[currentPos++] = (valn << 4) >>> 28;
		out[currentPos++] = (valn << 8) >>> 28;
		out[currentPos++] = (valn << 12) >>> 28;
		out[currentPos++] = (valn << 16) >>> 28;
		out[currentPos++] = (valn << 20) >>> 28;
		out[currentPos++] = (valn << 24) >>> 28;
		out[currentPos++] = (valn << 28) >>> 28;
	}

	private void decode20(int val, int valn, int[] out, int currentPos) {
		// number : 9, bitwidth : 3
		out[currentPos++] = (val << 8) >>> 29;
		out[currentPos++] = (val << 11) >>> 29;
		out[currentPos++] = (val << 14) >>> 29;
		out[currentPos++] = (val << 17) >>> 29;
		out[currentPos++] = (val << 20) >>> 29;
		out[currentPos++] = (val << 23) >>> 29;
		out[currentPos++] = (val << 26) >>> 29;
		out[currentPos++] = (val << 29) >>> 29;
		out[currentPos++] = (valn << 2) >>> 29;
		// number : 9, bitwidth : 3
		out[currentPos++] = (valn << 5) >>> 29;
		out[currentPos++] = (valn << 8) >>> 29;
		out[currentPos++] = (valn << 11) >>> 29;
		out[currentPos++] = (valn << 14) >>> 29;
		out[currentPos++] = (valn << 17) >>> 29;
		out[currentPos++] = (valn << 20) >>> 29;
		out[currentPos++] = (valn << 23) >>> 29;
		out[currentPos++] = (valn << 26) >>> 29;
		out[currentPos++] = (valn << 29) >>> 29;
	}

	private void decode19(int val, int valn, int[] out, int currentPos) {
		// number : 9, bitwidth : 3
		out[currentPos++] = (val << 8) >>> 29;
		out[currentPos++] = (val << 11) >>> 29;
		out[currentPos++] = (val << 14) >>> 29;
		out[currentPos++] = (val << 17) >>> 29;
		out[currentPos++] = (val << 20) >>> 29;
		out[currentPos++] = (val << 23) >>> 29;
		out[currentPos++] = (val << 26) >>> 29;
		out[currentPos++] = (val << 29) >>> 29;
		out[currentPos++] = (valn << 1) >>> 29;
		// number : 14, bitwidth : 2
		out[currentPos++] = (valn << 4) >>> 30;
		out[currentPos++] = (valn << 6) >>> 30;
		out[currentPos++] = (valn << 8) >>> 30;
		out[currentPos++] = (valn << 10) >>> 30;
		out[currentPos++] = (valn << 12) >>> 30;
		out[currentPos++] = (valn << 14) >>> 30;
		out[currentPos++] = (valn << 16) >>> 30;
		out[currentPos++] = (valn << 18) >>> 30;
		out[currentPos++] = (valn << 20) >>> 30;
		out[currentPos++] = (valn << 22) >>> 30; // 10
		out[currentPos++] = (valn << 24) >>> 30;
		out[currentPos++] = (valn << 26) >>> 30;
		out[currentPos++] = (valn << 28) >>> 30;
		out[currentPos++] = (valn << 30) >>> 30;
	}

	private void decode18(int val, int valn, int[] out, int currentPos) {
		// number : 9, bitwidth : 3
		out[currentPos++] = (val << 8) >>> 29;
		out[currentPos++] = (val << 11) >>> 29;
		out[currentPos++] = (val << 14) >>> 29;
		out[currentPos++] = (val << 17) >>> 29;
		out[currentPos++] = (val << 20) >>> 29;
		out[currentPos++] = (val << 23) >>> 29;
		out[currentPos++] = (val << 26) >>> 29;
		out[currentPos++] = (val << 29) >>> 29;
		out[currentPos++] = (valn << 1) >>> 29;
		// number : 28, bitwidth : 1
		out[currentPos++] = (valn << 4) >>> 31;
		out[currentPos++] = (valn << 5) >>> 31;
		out[currentPos++] = (valn << 6) >>> 31;
		out[currentPos++] = (valn << 7) >>> 31;
		out[currentPos++] = (valn << 8) >>> 31;
		out[currentPos++] = (valn << 9) >>> 31;
		out[currentPos++] = (valn << 10) >>> 31;
		out[currentPos++] = (valn << 11) >>> 31;
		out[currentPos++] = (valn << 12) >>> 31;
		out[currentPos++] = (valn << 13) >>> 31; // 10
		out[currentPos++] = (valn << 14) >>> 31;
		out[currentPos++] = (valn << 15) >>> 31;
		out[currentPos++] = (valn << 16) >>> 31;
		out[currentPos++] = (valn << 17) >>> 31;
		out[currentPos++] = (valn << 18) >>> 31;
		out[currentPos++] = (valn << 19) >>> 31;
		out[currentPos++] = (valn << 20) >>> 31;
		out[currentPos++] = (valn << 21) >>> 31;
		out[currentPos++] = (valn << 22) >>> 31;
		out[currentPos++] = (valn << 23) >>> 31; // 20
		out[currentPos++] = (valn << 24) >>> 31;
		out[currentPos++] = (valn << 25) >>> 31;
		out[currentPos++] = (valn << 26) >>> 31;
		out[currentPos++] = (valn << 27) >>> 31;
		out[currentPos++] = (valn << 28) >>> 31;
		out[currentPos++] = (valn << 29) >>> 31;
		out[currentPos++] = (valn << 30) >>> 31;
		out[currentPos++] = (valn << 31) >>> 31;
	}

	private void decode17(int val, int valn, int[] out, int currentPos) {
		// number : 14, bitwidth : 2
		out[currentPos++] = (val << 8) >>> 30;
		out[currentPos++] = (val << 10) >>> 30;
		out[currentPos++] = (val << 12) >>> 30;
		out[currentPos++] = (val << 14) >>> 30;
		out[currentPos++] = (val << 16) >>> 30;
		out[currentPos++] = (val << 18) >>> 30;
		out[currentPos++] = (val << 20) >>> 30;
		out[currentPos++] = (val << 22) >>> 30; // 10
		out[currentPos++] = (val << 24) >>> 30;
		out[currentPos++] = (val << 26) >>> 30;
		out[currentPos++] = (val << 28) >>> 30;
		out[currentPos++] = (val << 30) >>> 30;
		out[currentPos++] = (valn << 0) >>> 30;
		out[currentPos++] = (valn << 2) >>> 30;
		// number : 1, bitwidth : 28
		out[currentPos++] = (valn << 4) >>> 4;
	}

	private void decode16(int val, int valn, int[] out, int currentPos) {
		// number : 14, bitwidth : 2
		out[currentPos++] = (val << 8) >>> 30;
		out[currentPos++] = (val << 10) >>> 30;
		out[currentPos++] = (val << 12) >>> 30;
		out[currentPos++] = (val << 14) >>> 30;
		out[currentPos++] = (val << 16) >>> 30;
		out[currentPos++] = (val << 18) >>> 30;
		out[currentPos++] = (val << 20) >>> 30;
		out[currentPos++] = (val << 22) >>> 30; // 10
		out[currentPos++] = (val << 24) >>> 30;
		out[currentPos++] = (val << 26) >>> 30;
		out[currentPos++] = (val << 28) >>> 30;
		out[currentPos++] = (val << 30) >>> 30;
		out[currentPos++] = (valn << 0) >>> 30;
		out[currentPos++] = (valn << 2) >>> 30;
		// number : 2, bitwidth : 14
		out[currentPos++] = (valn << 4) >>> 18;
		out[currentPos++] = (valn << 18) >>> 18;
	}

	private void decode15(int val, int valn, int[] out, int currentPos) {
		// number : 14, bitwidth : 2
		out[currentPos++] = (val << 8) >>> 30;
		out[currentPos++] = (val << 10) >>> 30;
		out[currentPos++] = (val << 12) >>> 30;
		out[currentPos++] = (val << 14) >>> 30;
		out[currentPos++] = (val << 16) >>> 30;
		out[currentPos++] = (val << 18) >>> 30;
		out[currentPos++] = (val << 20) >>> 30;
		out[currentPos++] = (val << 22) >>> 30; // 10
		out[currentPos++] = (val << 24) >>> 30;
		out[currentPos++] = (val << 26) >>> 30;
		out[currentPos++] = (val << 28) >>> 30;
		out[currentPos++] = (val << 30) >>> 30;
		out[currentPos++] = (valn << 1) >>> 30;
		out[currentPos++] = (valn << 3) >>> 30;
		// number : 3, bitwidth : 9
		out[currentPos++] = (valn << 5) >>> 23;
		out[currentPos++] = (valn << 14) >>> 23;
		out[currentPos++] = (valn << 23) >>> 23;
	}

	private void decode14(int val, int valn, int[] out, int currentPos) {
		// number : 14, bitwidth : 2
		out[currentPos++] = (val << 8) >>> 30;
		out[currentPos++] = (val << 10) >>> 30;
		out[currentPos++] = (val << 12) >>> 30;
		out[currentPos++] = (val << 14) >>> 30;
		out[currentPos++] = (val << 16) >>> 30;
		out[currentPos++] = (val << 18) >>> 30;
		out[currentPos++] = (val << 20) >>> 30;
		out[currentPos++] = (val << 22) >>> 30; // 10
		out[currentPos++] = (val << 24) >>> 30;
		out[currentPos++] = (val << 26) >>> 30;
		out[currentPos++] = (val << 28) >>> 30;
		out[currentPos++] = (val << 30) >>> 30;
		out[currentPos++] = (valn << 0) >>> 30;
		out[currentPos++] = (valn << 2) >>> 30;
		// number : 4, bitwidth : 7
		out[currentPos++] = (valn << 4) >>> 25;
		out[currentPos++] = (valn << 11) >>> 25;
		out[currentPos++] = (valn << 18) >>> 25;
		out[currentPos++] = (valn << 25) >>> 25;
	}

	private void decode13(int val, int valn, int[] out, int currentPos) {
		// number : 14, bitwidth : 2
		out[currentPos++] = (val << 8) >>> 30;
		out[currentPos++] = (val << 10) >>> 30;
		out[currentPos++] = (val << 12) >>> 30;
		out[currentPos++] = (val << 14) >>> 30;
		out[currentPos++] = (val << 16) >>> 30;
		out[currentPos++] = (val << 18) >>> 30;
		out[currentPos++] = (val << 20) >>> 30;
		out[currentPos++] = (val << 22) >>> 30; // 10
		out[currentPos++] = (val << 24) >>> 30;
		out[currentPos++] = (val << 26) >>> 30;
		out[currentPos++] = (val << 28) >>> 30;
		out[currentPos++] = (val << 30) >>> 30;
		out[currentPos++] = (valn << 3) >>> 30;
		out[currentPos++] = (valn << 5) >>> 30;
		// number : 5, bitwidth : 5
		out[currentPos++] = (valn << 7) >>> 27;
		out[currentPos++] = (valn << 12) >>> 27;
		out[currentPos++] = (valn << 17) >>> 27;
		out[currentPos++] = (valn << 22) >>> 27;
		out[currentPos++] = (valn << 27) >>> 27;
		
	}

	private void decode12(int val, int valn, int[] out, int currentPos) {
		// number : 14, bitwidth : 2
		out[currentPos++] = (val << 8) >>> 30;
		out[currentPos++] = (val << 10) >>> 30;
		out[currentPos++] = (val << 12) >>> 30;
		out[currentPos++] = (val << 14) >>> 30;
		out[currentPos++] = (val << 16) >>> 30;
		out[currentPos++] = (val << 18) >>> 30;
		out[currentPos++] = (val << 20) >>> 30;
		out[currentPos++] = (val << 22) >>> 30; // 10
		out[currentPos++] = (val << 24) >>> 30;
		out[currentPos++] = (val << 26) >>> 30;
		out[currentPos++] = (val << 28) >>> 30;
		out[currentPos++] = (val << 30) >>> 30;
		out[currentPos++] = (valn << 0) >>> 30;
		out[currentPos++] = (valn << 2) >>> 30;
		// number : 7, bitwidth : 4
		out[currentPos++] = (valn << 4) >>> 28;
		out[currentPos++] = (valn << 8) >>> 28;
		out[currentPos++] = (valn << 12) >>> 28;
		out[currentPos++] = (valn << 16) >>> 28;
		out[currentPos++] = (valn << 20) >>> 28;
		out[currentPos++] = (valn << 24) >>> 28;
		out[currentPos++] = (valn << 28) >>> 28;
		
	}

	private void decode11(int val, int valn, int[] out, int currentPos) {
		// number : 14, bitwidth : 2
		out[currentPos++] = (val << 8) >>> 30;
		out[currentPos++] = (val << 10) >>> 30;
		out[currentPos++] = (val << 12) >>> 30;
		out[currentPos++] = (val << 14) >>> 30;
		out[currentPos++] = (val << 16) >>> 30;
		out[currentPos++] = (val << 18) >>> 30;
		out[currentPos++] = (val << 20) >>> 30;
		out[currentPos++] = (val << 22) >>> 30; // 10
		out[currentPos++] = (val << 24) >>> 30;
		out[currentPos++] = (val << 26) >>> 30;
		out[currentPos++] = (val << 28) >>> 30;
		out[currentPos++] = (val << 30) >>> 30;
		out[currentPos++] = (valn << 1) >>> 30;
		out[currentPos++] = (valn << 3) >>> 30;
		// number : 9, bitwidth : 3
		out[currentPos++] = (valn << 5) >>> 29;
		out[currentPos++] = (valn << 8) >>> 29;
		out[currentPos++] = (valn << 11) >>> 29;
		out[currentPos++] = (valn << 14) >>> 29;
		out[currentPos++] = (valn << 17) >>> 29;
		out[currentPos++] = (valn << 20) >>> 29;
		out[currentPos++] = (valn << 23) >>> 29;
		out[currentPos++] = (valn << 26) >>> 29;
		out[currentPos++] = (valn << 29) >>> 29;
		
	}

	private void decode10(int val, int valn, int[] out, int currentPos) {
		// number : 14, bitwidth : 2
		out[currentPos++] = (val << 8) >>> 30;
		out[currentPos++] = (val << 10) >>> 30;
		out[currentPos++] = (val << 12) >>> 30;
		out[currentPos++] = (val << 14) >>> 30;
		out[currentPos++] = (val << 16) >>> 30;
		out[currentPos++] = (val << 18) >>> 30;
		out[currentPos++] = (val << 20) >>> 30;
		out[currentPos++] = (val << 22) >>> 30; // 10
		out[currentPos++] = (val << 24) >>> 30;
		out[currentPos++] = (val << 26) >>> 30;
		out[currentPos++] = (val << 28) >>> 30;
		out[currentPos++] = (val << 30) >>> 30;
		out[currentPos++] = (valn << 0) >>> 30;
		out[currentPos++] = (valn << 2) >>> 30;
		// number : 14, bitwidth : 2
		out[currentPos++] = (valn << 4) >>> 30;
		out[currentPos++] = (valn << 6) >>> 30;
		out[currentPos++] = (valn << 8) >>> 30;
		out[currentPos++] = (valn << 10) >>> 30;
		out[currentPos++] = (valn << 12) >>> 30;
		out[currentPos++] = (valn << 14) >>> 30;
		out[currentPos++] = (valn << 16) >>> 30;
		out[currentPos++] = (valn << 18) >>> 30;
		out[currentPos++] = (valn << 20) >>> 30;
		out[currentPos++] = (valn << 22) >>> 30; // 10
		out[currentPos++] = (valn << 24) >>> 30;
		out[currentPos++] = (valn << 26) >>> 30;
		out[currentPos++] = (valn << 28) >>> 30;
		out[currentPos++] = (valn << 30) >>> 30;
	}

	private void decode9(int val, int valn, int[] out, int currentPos) {
		// number : 14, bitwidth : 2
		out[currentPos++] = (val << 8) >>> 30;
		out[currentPos++] = (val << 10) >>> 30;
		out[currentPos++] = (val << 12) >>> 30;
		out[currentPos++] = (val << 14) >>> 30;
		out[currentPos++] = (val << 16) >>> 30;
		out[currentPos++] = (val << 18) >>> 30;
		out[currentPos++] = (val << 20) >>> 30;
		out[currentPos++] = (val << 22) >>> 30; // 10
		out[currentPos++] = (val << 24) >>> 30;
		out[currentPos++] = (val << 26) >>> 30;
		out[currentPos++] = (val << 28) >>> 30;
		out[currentPos++] = (val << 30) >>> 30;
		out[currentPos++] = (valn << 0) >>> 30;
		out[currentPos++] = (valn << 2) >>> 30;
		// number : 28, bitwidth : 1
		out[currentPos++] = (valn << 4) >>> 31;
		out[currentPos++] = (valn << 5) >>> 31;
		out[currentPos++] = (valn << 6) >>> 31;
		out[currentPos++] = (valn << 7) >>> 31;
		out[currentPos++] = (valn << 8) >>> 31;
		out[currentPos++] = (valn << 9) >>> 31;
		out[currentPos++] = (valn << 10) >>> 31;
		out[currentPos++] = (valn << 11) >>> 31;
		out[currentPos++] = (valn << 12) >>> 31;
		out[currentPos++] = (valn << 13) >>> 31; // 10
		out[currentPos++] = (valn << 14) >>> 31;
		out[currentPos++] = (valn << 15) >>> 31;
		out[currentPos++] = (valn << 16) >>> 31;
		out[currentPos++] = (valn << 17) >>> 31;
		out[currentPos++] = (valn << 18) >>> 31;
		out[currentPos++] = (valn << 19) >>> 31;
		out[currentPos++] = (valn << 20) >>> 31;
		out[currentPos++] = (valn << 21) >>> 31;
		out[currentPos++] = (valn << 22) >>> 31;
		out[currentPos++] = (valn << 23) >>> 31; // 20
		out[currentPos++] = (valn << 24) >>> 31;
		out[currentPos++] = (valn << 25) >>> 31;
		out[currentPos++] = (valn << 26) >>> 31;
		out[currentPos++] = (valn << 27) >>> 31;
		out[currentPos++] = (valn << 28) >>> 31;
		out[currentPos++] = (valn << 29) >>> 31;
		out[currentPos++] = (valn << 30) >>> 31;
		out[currentPos++] = (valn << 31) >>> 31;
	}

	private void decode8(int val, int valn, int[] out, int currentPos) {
		// number : 28, bitwidth : 1
		out[currentPos++] = (val << 8) >>> 31;
		out[currentPos++] = (val << 9) >>> 31;
		out[currentPos++] = (val << 10) >>> 31;
		out[currentPos++] = (val << 11) >>> 31;
		out[currentPos++] = (val << 12) >>> 31;
		out[currentPos++] = (val << 13) >>> 31; // 10
		out[currentPos++] = (val << 14) >>> 31;
		out[currentPos++] = (val << 15) >>> 31;
		out[currentPos++] = (val << 16) >>> 31;
		out[currentPos++] = (val << 17) >>> 31;
		out[currentPos++] = (val << 18) >>> 31;
		out[currentPos++] = (val << 19) >>> 31;
		out[currentPos++] = (val << 20) >>> 31;
		out[currentPos++] = (val << 21) >>> 31;
		out[currentPos++] = (val << 22) >>> 31;
		out[currentPos++] = (val << 23) >>> 31; // 20
		out[currentPos++] = (val << 24) >>> 31;
		out[currentPos++] = (val << 25) >>> 31;
		out[currentPos++] = (val << 26) >>> 31;
		out[currentPos++] = (val << 27) >>> 31;
		out[currentPos++] = (val << 28) >>> 31;
		out[currentPos++] = (val << 29) >>> 31;
		out[currentPos++] = (val << 30) >>> 31;
		out[currentPos++] = (val << 31) >>> 31;
		out[currentPos++] = valn >>> 31;
		out[currentPos++] = (valn << 1) >>> 31;
		out[currentPos++] = (valn << 2) >>> 31;
		out[currentPos++] = (valn << 3) >>> 31;
		// number : 1, bitwidth : 28
		out[currentPos++] = (valn << 4) >>> 4;
	}

	private void decode7(int val, int valn, int[] out, int currentPos) {
		// number : 28, bitwidth : 1
		out[currentPos++] = (val << 8) >>> 31;
		out[currentPos++] = (val << 9) >>> 31;
		out[currentPos++] = (val << 10) >>> 31;
		out[currentPos++] = (val << 11) >>> 31;
		out[currentPos++] = (val << 12) >>> 31;
		out[currentPos++] = (val << 13) >>> 31; // 10
		out[currentPos++] = (val << 14) >>> 31;
		out[currentPos++] = (val << 15) >>> 31;
		out[currentPos++] = (val << 16) >>> 31;
		out[currentPos++] = (val << 17) >>> 31;
		out[currentPos++] = (val << 18) >>> 31;
		out[currentPos++] = (val << 19) >>> 31;
		out[currentPos++] = (val << 20) >>> 31;
		out[currentPos++] = (val << 21) >>> 31;
		out[currentPos++] = (val << 22) >>> 31;
		out[currentPos++] = (val << 23) >>> 31; // 20
		out[currentPos++] = (val << 24) >>> 31;
		out[currentPos++] = (val << 25) >>> 31;
		out[currentPos++] = (val << 26) >>> 31;
		out[currentPos++] = (val << 27) >>> 31;
		out[currentPos++] = (val << 28) >>> 31;
		out[currentPos++] = (val << 29) >>> 31;
		out[currentPos++] = (val << 30) >>> 31;
		out[currentPos++] = (val << 31) >>> 31;
		out[currentPos++] = valn >>> 31;
		out[currentPos++] = (valn << 1) >>> 31;
		out[currentPos++] = (valn << 2) >>> 31;
		out[currentPos++] = (valn << 3) >>> 31;
		// number : 2, bitwidth : 14
		out[currentPos++] = (valn << 4) >>> 18;
		out[currentPos++] = (valn << 18) >>> 18;
	}

	private void decode6(int val, int valn, int[] out, int currentPos) {
		// number : 28, bitwidth : 1
		out[currentPos++] = (val << 8) >>> 31;
		out[currentPos++] = (val << 9) >>> 31;
		out[currentPos++] = (val << 10) >>> 31;
		out[currentPos++] = (val << 11) >>> 31;
		out[currentPos++] = (val << 12) >>> 31;
		out[currentPos++] = (val << 13) >>> 31; // 10
		out[currentPos++] = (val << 14) >>> 31;
		out[currentPos++] = (val << 15) >>> 31;
		out[currentPos++] = (val << 16) >>> 31;
		out[currentPos++] = (val << 17) >>> 31;
		out[currentPos++] = (val << 18) >>> 31;
		out[currentPos++] = (val << 19) >>> 31;
		out[currentPos++] = (val << 20) >>> 31;
		out[currentPos++] = (val << 21) >>> 31;
		out[currentPos++] = (val << 22) >>> 31;
		out[currentPos++] = (val << 23) >>> 31; // 20
		out[currentPos++] = (val << 24) >>> 31;
		out[currentPos++] = (val << 25) >>> 31;
		out[currentPos++] = (val << 26) >>> 31;
		out[currentPos++] = (val << 27) >>> 31;
		out[currentPos++] = (val << 28) >>> 31;
		out[currentPos++] = (val << 29) >>> 31;
		out[currentPos++] = (val << 30) >>> 31;
		out[currentPos++] = (val << 31) >>> 31;
		out[currentPos++] = (valn << 1) >>> 31;
		out[currentPos++] = (valn << 2) >>> 31;
		out[currentPos++] = (valn << 3) >>> 31;
		out[currentPos++] = (valn << 4) >>> 31;
		// number : 3, bitwidth : 9
		out[currentPos++] = (valn << 5) >>> 23;
		out[currentPos++] = (valn << 14) >>> 23;
		out[currentPos++] = (valn << 23) >>> 23;
	}

	private void decode5(int val, int valn, int[] out, int currentPos) {
		// number : 28, bitwidth : 1
		out[currentPos++] = (val << 8) >>> 31;
		out[currentPos++] = (val << 9) >>> 31;
		out[currentPos++] = (val << 10) >>> 31;
		out[currentPos++] = (val << 11) >>> 31;
		out[currentPos++] = (val << 12) >>> 31;
		out[currentPos++] = (val << 13) >>> 31; // 10
		out[currentPos++] = (val << 14) >>> 31;
		out[currentPos++] = (val << 15) >>> 31;
		out[currentPos++] = (val << 16) >>> 31;
		out[currentPos++] = (val << 17) >>> 31;
		out[currentPos++] = (val << 18) >>> 31;
		out[currentPos++] = (val << 19) >>> 31;
		out[currentPos++] = (val << 20) >>> 31;
		out[currentPos++] = (val << 21) >>> 31;
		out[currentPos++] = (val << 22) >>> 31;
		out[currentPos++] = (val << 23) >>> 31; // 20
		out[currentPos++] = (val << 24) >>> 31;
		out[currentPos++] = (val << 25) >>> 31;
		out[currentPos++] = (val << 26) >>> 31;
		out[currentPos++] = (val << 27) >>> 31;
		out[currentPos++] = (val << 28) >>> 31;
		out[currentPos++] = (val << 29) >>> 31;
		out[currentPos++] = (val << 30) >>> 31;
		out[currentPos++] = (val << 31) >>> 31;
		out[currentPos++] = valn >>> 31;
		out[currentPos++] = (valn << 1) >>> 31;
		out[currentPos++] = (valn << 2) >>> 31;
		out[currentPos++] = (valn << 3) >>> 31;
		// number : 4, bitwidth : 7
		out[currentPos++] = (valn << 4) >>> 25;
		out[currentPos++] = (valn << 11) >>> 25;
		out[currentPos++] = (valn << 18) >>> 25;
		out[currentPos++] = (valn << 25) >>> 25;
	}

	private void decode4(int val, int valn, int[] out, int currentPos) {
		// number : 28, bitwidth : 1
		out[currentPos++] = (val << 8) >>> 31;
		out[currentPos++] = (val << 9) >>> 31;
		out[currentPos++] = (val << 10) >>> 31;
		out[currentPos++] = (val << 11) >>> 31;
		out[currentPos++] = (val << 12) >>> 31;
		out[currentPos++] = (val << 13) >>> 31; // 10
		out[currentPos++] = (val << 14) >>> 31;
		out[currentPos++] = (val << 15) >>> 31;
		out[currentPos++] = (val << 16) >>> 31;
		out[currentPos++] = (val << 17) >>> 31;
		out[currentPos++] = (val << 18) >>> 31;
		out[currentPos++] = (val << 19) >>> 31;
		out[currentPos++] = (val << 20) >>> 31;
		out[currentPos++] = (val << 21) >>> 31;
		out[currentPos++] = (val << 22) >>> 31;
		out[currentPos++] = (val << 23) >>> 31; // 20
		out[currentPos++] = (val << 24) >>> 31;
		out[currentPos++] = (val << 25) >>> 31;
		out[currentPos++] = (val << 26) >>> 31;
		out[currentPos++] = (val << 27) >>> 31;
		out[currentPos++] = (val << 28) >>> 31;
		out[currentPos++] = (val << 29) >>> 31;
		out[currentPos++] = (val << 30) >>> 31;
		out[currentPos++] = (val << 31) >>> 31;
		out[currentPos++] = (valn << 3) >>> 31;// 头部3bit
		out[currentPos++] = (valn << 4) >>> 31;
		out[currentPos++] = (valn << 5) >>> 31;
		out[currentPos++] = (valn << 6) >>> 31;
		// number : 5, bitwidth : 5
		out[currentPos++] = (valn << 7) >>> 27;
		out[currentPos++] = (valn << 12) >>> 27;
		out[currentPos++] = (valn << 17) >>> 27;
		out[currentPos++] = (valn << 22) >>> 27;
		out[currentPos++] = (valn << 27) >>> 27;	
	}

	private void decode3(int val, int valn, int[] out, int currentPos) {
		// number : 28, bitwidth : 1
		out[currentPos++] = (val << 8) >>> 31;
		out[currentPos++] = (val << 9) >>> 31;
		out[currentPos++] = (val << 10) >>> 31;
		out[currentPos++] = (val << 11) >>> 31;
		out[currentPos++] = (val << 12) >>> 31;
		out[currentPos++] = (val << 13) >>> 31; // 10
		out[currentPos++] = (val << 14) >>> 31;
		out[currentPos++] = (val << 15) >>> 31;
		out[currentPos++] = (val << 16) >>> 31;
		out[currentPos++] = (val << 17) >>> 31;
		out[currentPos++] = (val << 18) >>> 31;
		out[currentPos++] = (val << 19) >>> 31;
		out[currentPos++] = (val << 20) >>> 31;
		out[currentPos++] = (val << 21) >>> 31;
		out[currentPos++] = (val << 22) >>> 31;
		out[currentPos++] = (val << 23) >>> 31; // 20
		out[currentPos++] = (val << 24) >>> 31;
		out[currentPos++] = (val << 25) >>> 31;
		out[currentPos++] = (val << 26) >>> 31;
		out[currentPos++] = (val << 27) >>> 31;
		out[currentPos++] = (val << 28) >>> 31;
		out[currentPos++] = (val << 29) >>> 31;
		out[currentPos++] = (val << 30) >>> 31;
		out[currentPos++] = (val << 31) >>> 31;
		out[currentPos++] = valn >>> 31;
		out[currentPos++] = (valn << 1) >>> 31;
		out[currentPos++] = (valn << 2) >>> 31;
		out[currentPos++] = (valn << 3) >>> 31;
		// number : 7, bitwidth : 4
		out[currentPos++] = (valn << 4) >>> 28;
		out[currentPos++] = (valn << 8) >>> 28;
		out[currentPos++] = (valn << 12) >>> 28;
		out[currentPos++] = (valn << 16) >>> 28;
		out[currentPos++] = (valn << 20) >>> 28;
		out[currentPos++] = (valn << 24) >>> 28;
		out[currentPos++] = (valn << 28) >>> 28;		
	}

	private void decode2(int val, int valn, int[] out, int currentPos) {
		// number : 28, bitwidth : 1
		out[currentPos++] = (val << 8) >>> 31;
		out[currentPos++] = (val << 9) >>> 31;
		out[currentPos++] = (val << 10) >>> 31;
		out[currentPos++] = (val << 11) >>> 31;
		out[currentPos++] = (val << 12) >>> 31;
		out[currentPos++] = (val << 13) >>> 31; // 10
		out[currentPos++] = (val << 14) >>> 31;
		out[currentPos++] = (val << 15) >>> 31;
		out[currentPos++] = (val << 16) >>> 31;
		out[currentPos++] = (val << 17) >>> 31;
		out[currentPos++] = (val << 18) >>> 31;
		out[currentPos++] = (val << 19) >>> 31;
		out[currentPos++] = (val << 20) >>> 31;
		out[currentPos++] = (val << 21) >>> 31;
		out[currentPos++] = (val << 22) >>> 31;
		out[currentPos++] = (val << 23) >>> 31; // 20
		out[currentPos++] = (val << 24) >>> 31;
		out[currentPos++] = (val << 25) >>> 31;
		out[currentPos++] = (val << 26) >>> 31;
		out[currentPos++] = (val << 27) >>> 31;
		out[currentPos++] = (val << 28) >>> 31;
		out[currentPos++] = (val << 29) >>> 31;
		out[currentPos++] = (val << 30) >>> 31;
		out[currentPos++] = (val << 31) >>> 31;
		out[currentPos++] = (valn << 1) >>> 31;// 头部1bit
		out[currentPos++] = (valn << 2) >>> 31;
		out[currentPos++] = (valn << 3) >>> 31;
		out[currentPos++] = (valn << 4) >>> 31;
		// number : 9, bitwidth : 3
		out[currentPos++] = (valn << 5) >>> 29;
		out[currentPos++] = (valn << 8) >>> 29;
		out[currentPos++] = (valn << 11) >>> 29;
		out[currentPos++] = (valn << 14) >>> 29;
		out[currentPos++] = (valn << 17) >>> 29;
		out[currentPos++] = (valn << 20) >>> 29;
		out[currentPos++] = (valn << 23) >>> 29;
		out[currentPos++] = (valn << 26) >>> 29;
		out[currentPos++] = (valn << 29) >>> 29;	
	}

	private void decode1(int val, int valn, int[] out, int currentPos) {
		// number : 28, bitwidth : 1
		out[currentPos++] = (val << 8) >>> 31;
		out[currentPos++] = (val << 9) >>> 31;
		out[currentPos++] = (val << 10) >>> 31;
		out[currentPos++] = (val << 11) >>> 31;
		out[currentPos++] = (val << 12) >>> 31;
		out[currentPos++] = (val << 13) >>> 31; // 10
		out[currentPos++] = (val << 14) >>> 31;
		out[currentPos++] = (val << 15) >>> 31;
		out[currentPos++] = (val << 16) >>> 31;
		out[currentPos++] = (val << 17) >>> 31;
		out[currentPos++] = (val << 18) >>> 31;
		out[currentPos++] = (val << 19) >>> 31;
		out[currentPos++] = (val << 20) >>> 31;
		out[currentPos++] = (val << 21) >>> 31;
		out[currentPos++] = (val << 22) >>> 31;
		out[currentPos++] = (val << 23) >>> 31;// 20
		out[currentPos++] = (val << 24) >>> 31;
		out[currentPos++] = (val << 25) >>> 31;
		out[currentPos++] = (val << 26) >>> 31;
		out[currentPos++] = (val << 27) >>> 31;
		out[currentPos++] = (val << 28) >>> 31;
		out[currentPos++] = (val << 29) >>> 31;
		out[currentPos++] = (val << 30) >>> 31;
		out[currentPos++] = (val << 31) >>> 31;
		out[currentPos++] = valn >>> 31;
		out[currentPos++] = (valn << 1) >>> 31;
		out[currentPos++] = (valn << 2) >>> 31;
		out[currentPos++] = (valn << 3) >>> 31;
		// number : 14, bitwidth : 2
		out[currentPos++] = (valn << 4) >>> 30;
		out[currentPos++] = (valn << 6) >>> 30;
		out[currentPos++] = (valn << 8) >>> 30;
		out[currentPos++] = (valn << 10) >>> 30;
		out[currentPos++] = (valn << 12) >>> 30;
		out[currentPos++] = (valn << 14) >>> 30;
		out[currentPos++] = (valn << 16) >>> 30;
		out[currentPos++] = (valn << 18) >>> 30;
		out[currentPos++] = (valn << 20) >>> 30;
		out[currentPos++] = (valn << 22) >>> 30; // 10
		out[currentPos++] = (valn << 24) >>> 30;
		out[currentPos++] = (valn << 26) >>> 30;
		out[currentPos++] = (valn << 28) >>> 30;
		out[currentPos++] = (valn << 30) >>> 30;		
	}

	private void decode0(int val, int valn, int[] out, int currentPos) {
		// number : 28, bitwidth : 1
		out[currentPos++] = (val << 8) >>> 31;
		out[currentPos++] = (val << 9) >>> 31;
		out[currentPos++] = (val << 10) >>> 31;
		out[currentPos++] = (val << 11) >>> 31;
		out[currentPos++] = (val << 12) >>> 31;
		out[currentPos++] = (val << 13) >>> 31; // 10
		out[currentPos++] = (val << 14) >>> 31;
		out[currentPos++] = (val << 15) >>> 31;
		out[currentPos++] = (val << 16) >>> 31;
		out[currentPos++] = (val << 17) >>> 31;
		out[currentPos++] = (val << 18) >>> 31;
		out[currentPos++] = (val << 19) >>> 31;
		out[currentPos++] = (val << 20) >>> 31;
		out[currentPos++] = (val << 21) >>> 31;
		out[currentPos++] = (val << 22) >>> 31;
		out[currentPos++] = (val << 23) >>> 31; // 20
		out[currentPos++] = (val << 24) >>> 31;
		out[currentPos++] = (val << 25) >>> 31;
		out[currentPos++] = (val << 26) >>> 31;
		out[currentPos++] = (val << 27) >>> 31;
		out[currentPos++] = (val << 28) >>> 31;
		out[currentPos++] = (val << 29) >>> 31;
		out[currentPos++] = (val << 30) >>> 31;
		out[currentPos++] = (val << 31) >>> 31;
		out[currentPos++] = valn >>> 31;
		out[currentPos++] = (valn << 1) >>> 31;
		out[currentPos++] = (valn << 2) >>> 31;
		out[currentPos++] = (valn << 3) >>> 31;
		// number : 28, bitwidth : 1
		out[currentPos++] = (valn << 4) >>> 31;
		out[currentPos++] = (valn << 5) >>> 31;
		out[currentPos++] = (valn << 6) >>> 31;
		out[currentPos++] = (valn << 7) >>> 31;
		out[currentPos++] = (valn << 8) >>> 31;
		out[currentPos++] = (valn << 9) >>> 31;
		out[currentPos++] = (valn << 10) >>> 31;
		out[currentPos++] = (valn << 11) >>> 31;
		out[currentPos++] = (valn << 12) >>> 31;
		out[currentPos++] = (valn << 13) >>> 31; // 10
		out[currentPos++] = (valn << 14) >>> 31;
		out[currentPos++] = (valn << 15) >>> 31;
		out[currentPos++] = (valn << 16) >>> 31;
		out[currentPos++] = (valn << 17) >>> 31;
		out[currentPos++] = (valn << 18) >>> 31;
		out[currentPos++] = (valn << 19) >>> 31;
		out[currentPos++] = (valn << 20) >>> 31;
		out[currentPos++] = (valn << 21) >>> 31;
		out[currentPos++] = (valn << 22) >>> 31;
		out[currentPos++] = (valn << 23) >>> 31; // 20
		out[currentPos++] = (valn << 24) >>> 31;
		out[currentPos++] = (valn << 25) >>> 31;
		out[currentPos++] = (valn << 26) >>> 31;
		out[currentPos++] = (valn << 27) >>> 31;
		out[currentPos++] = (valn << 28) >>> 31;
		out[currentPos++] = (valn << 29) >>> 31;
		out[currentPos++] = (valn << 30) >>> 31;
		out[currentPos++] = (valn << 31) >>> 31;
	}


	private final static int bitLength[] = { 1, 2, 3, 4, 5, 7, 9, 14, 28 };

	private final static int codeNum[] = { 28, 14, 9, 7, 5, 4, 3, 2, 1 };

	@Override
	public String toString() {
		return this.getClass().getSimpleName();
	}

	@Override
	public void headlessCompress(int[] in, IntWrapper inpos, int inlength, int[] out, IntWrapper outpos) {
		int tmpoutpos = outpos.get();
		int currentPos = inpos.get();
		int selector1 = 0;
		int selector2 = 0;
		final int finalin = currentPos + inlength;
		while (currentPos < finalin - 28 * 2) {
			int nextCurrentPos = currentPos;
					mainloop1: for (selector1=0; selector1 <= 8; selector1++) {
				int compressedNum = codeNum[selector1];
				//if (finalin <= nextCurrentPos + compressedNum - 1)
				//	compressedNum = finalin - nextCurrentPos;
				int b = bitLength[selector1];
				int max = 1 << b;
				int i = 0;
				for (; i < compressedNum; i++) {
					if (Util.smallerorequalthan(max, in[nextCurrentPos + i]))
						continue mainloop1;
				}
				nextCurrentPos += compressedNum;
				break;
			}
			mainloop2: for (selector2 = 0; selector2 <= 8; selector2++) {
				int compressedNum = codeNum[selector2];
				//if (finalin <= nextCurrentPos + compressedNum - 1)
				//	compressedNum = finalin - nextCurrentPos;
				int b = bitLength[selector2];
				int max = 1 << b;
				int i = 0;
				for (; i < compressedNum; i++) {
					if (Util.smallerorequalthan(max, in[nextCurrentPos + i]))
						continue mainloop2;
				}
				nextCurrentPos += compressedNum;
				break;
			}
			int code = M[selector1][selector2];
			out[tmpoutpos] = 0;
			out[tmpoutpos + 1] = 0;
			switch (code) {
			case 0:
				encode0(in, currentPos, code, out, tmpoutpos);
				break;
			case 1:
				encode1(in, currentPos, code, out, tmpoutpos);
				break;
			case 2:
				encode2(in, currentPos, code, out, tmpoutpos);
				break;
			case 3:
				encode3(in, currentPos, code, out, tmpoutpos);
				break;
			case 4:
				encode4(in, currentPos, code, out, tmpoutpos);
				break;
			case 5:
				encode5(in, currentPos, code, out, tmpoutpos);
				break;
			case 6:
				encode6(in, currentPos, code, out, tmpoutpos);
				break;
			case 7:
				encode7(in, currentPos, code, out, tmpoutpos);
				break;
			case 8:
				encode8(in, currentPos, code, out, tmpoutpos);
				break;
			case 9:
				encode9(in, currentPos, code, out, tmpoutpos);
				break;
			case 10:
				encode10(in, currentPos, code, out, tmpoutpos);
				break;
			case 11:
				encode11(in, currentPos, code, out, tmpoutpos);
				break;
			case 12:
				encode12(in, currentPos, code, out, tmpoutpos);
				break;
			case 13:
				encode13(in, currentPos, code, out, tmpoutpos);
				break;
			case 14:
				encode14(in, currentPos, code, out, tmpoutpos);
				break;
			case 15:
				encode15(in, currentPos, code, out, tmpoutpos);
				break;
			case 16:
				encode16(in, currentPos, code, out, tmpoutpos);
				break;
			case 17:
				encode17(in, currentPos, code, out, tmpoutpos);
				break;
			case 18:
				encode18(in, currentPos, code, out, tmpoutpos);
				break;
			case 19:
				encode19(in, currentPos, code, out, tmpoutpos);
				break;
			case 20:
				encode20(in, currentPos, code, out, tmpoutpos);
				break;
			case 21:
				encode21(in, currentPos, code, out, tmpoutpos);
				break;
			case 22:
				encode22(in, currentPos, code, out, tmpoutpos);
				break;
			case 23:
				encode23(in, currentPos, code, out, tmpoutpos);
				break;
			case 24:
				encode24(in, currentPos, code, out, tmpoutpos);
				break;
			case 25:
				encode25(in, currentPos, code, out, tmpoutpos);
				break;
			case 26:
				encode26(in, currentPos, code, out, tmpoutpos);
				break;
			case 27:
				encode27(in, currentPos, code, out, tmpoutpos);
				break;
			case 28:
				encode28(in, currentPos, code, out, tmpoutpos);
				break;
			case 29:
				encode29(in, currentPos, code, out, tmpoutpos);
				break;
			case 30:
				encode30(in, currentPos, code, out, tmpoutpos);
				break;
			case 31:
				encode31(in, currentPos, code, out, tmpoutpos);
				break;
			case 32:
				encode32(in, currentPos, code, out, tmpoutpos);
				break;
			case 33:
				encode33(in, currentPos, code, out, tmpoutpos);
				break;
			case 34:
				encode34(in, currentPos, code, out, tmpoutpos);
				break;
			case 35:
				encode35(in, currentPos, code, out, tmpoutpos);
				break;
			case 36:
				encode36(in, currentPos, code, out, tmpoutpos);
				break;
			case 37:
				encode37(in, currentPos, code, out, tmpoutpos);
				break;
			case 38:
				encode38(in, currentPos, code, out, tmpoutpos);
				break;
			case 39:
				encode39(in, currentPos, code, out, tmpoutpos);
				break;
			case 40:
				encode40(in, currentPos, code, out, tmpoutpos);
				break;
			case 41:
				encode41(in, currentPos, code, out, tmpoutpos);
				break;
			case 42:
				encode42(in, currentPos, code, out, tmpoutpos);
				break;
			case 43:
				encode43(in, currentPos, code, out, tmpoutpos);
				break;
			case 44:
				encode44(in, currentPos, code, out, tmpoutpos);
				break;
			case 45:
				encode45(in, currentPos, code, out, tmpoutpos);
				break;
			case 46:
				encode46(in, currentPos, code, out, tmpoutpos);
				break;
			case 47:
				encode47(in, currentPos, code, out, tmpoutpos);
				break;
			case 48:
				encode48(in, currentPos, code, out, tmpoutpos);
				break;
			case 49:
				encode49(in, currentPos, code, out, tmpoutpos);
				break;
			case 50:
				encode50(in, currentPos, code, out, tmpoutpos);
				break;
			case 51:
				encode51(in, currentPos, code, out, tmpoutpos);
				break;
			case 52:
				encode52(in, currentPos, code, out, tmpoutpos);
				break;
			case 53:
				encode53(in, currentPos, code, out, tmpoutpos);
				break;
			case 54:
				encode54(in, currentPos, code, out, tmpoutpos);
				break;
			case 55:
				encode55(in, currentPos, code, out, tmpoutpos);
				break;
			case 56:
				encode56(in, currentPos, code, out, tmpoutpos);
				break;
			case 57:
				encode57(in, currentPos, code, out, tmpoutpos);
				break;
			case 58:
				encode58(in, currentPos, code, out, tmpoutpos);
				break;
			case 59:
				encode59(in, currentPos, code, out, tmpoutpos);
				break;
			case 60:
				encode60(in, currentPos, code, out, tmpoutpos);
				break;
			case 61:
				encode61(in, currentPos, code, out, tmpoutpos);
				break;
			case 62:
				encode62(in, currentPos, code, out, tmpoutpos);
				break;
			case 63:
				encode63(in, currentPos, code, out, tmpoutpos);
				break;
			case 64:
				encode64(in, currentPos, code, out, tmpoutpos);
				break;
			case 65:
				encode65(in, currentPos, code, out, tmpoutpos);
				break;
			case 66:
				encode66(in, currentPos, code, out, tmpoutpos);
				break;
			case 67:
				encode67(in, currentPos, code, out, tmpoutpos);
				break;
			case 68:
				encode68(in, currentPos, code, out, tmpoutpos);
				break;
			case 69:
				encode69(in, currentPos, code, out, tmpoutpos);
				break;
			case 70:
				encode70(in, currentPos, code, out, tmpoutpos);
				break;
			case 71:
				encode71(in, currentPos, code, out, tmpoutpos);
				break;
			case 72:
				encode72(in, currentPos, code, out, tmpoutpos);
				break;
			case 73:
				encode73(in, currentPos, code, out, tmpoutpos);
				break;
			case 74:
				encode74(in, currentPos, code, out, tmpoutpos);
				break;
			case 75:
				encode75(in, currentPos, code, out, tmpoutpos);
				break;
			case 76:
				encode76(in, currentPos, code, out, tmpoutpos);
				break;
			case 77:
				encode77(in, currentPos, code, out, tmpoutpos);
				break;
			case 78:
				encode78(in, currentPos, code, out, tmpoutpos);
				break;
			case 79:
				encode79(in, currentPos, code, out, tmpoutpos);
				break;
			case 80:
				encode80(in, currentPos, code, out, tmpoutpos);
				break;
			default:
				throw new RuntimeException("unsupported code");
			}// end switch
			tmpoutpos += 2;
			currentPos = nextCurrentPos;
		}

		outer: while (currentPos < finalin) {
			mainloop: for (int selector = 0; selector < 8; selector++) {
				int res = 0;
				int compressedNum = codeNum[selector];
				if (finalin <= currentPos + compressedNum - 1)
					compressedNum = finalin - currentPos;
				int b = bitLength[selector];
				int max = 1 << b;
				int i = 0;
				for (; i < compressedNum; i++) {
					if (Util.smallerorequalthan(max, in[currentPos + i]))
						continue mainloop;
					res = (res << b) + in[currentPos + i];
				}
				if (compressedNum != codeNum[selector]) {
					res <<= (codeNum[selector] - compressedNum) * b;
				}
				res |= selector << 28;
				out[tmpoutpos++] = res;

				currentPos += compressedNum;
				continue outer;
			}
			final int selector = 8;
			out[tmpoutpos++] = in[currentPos++] | (selector << 28);
		}
		inpos.set(currentPos);
		outpos.set(tmpoutpos);
	}

	@Override
	public void headlessUncompress(int[] in, IntWrapper inpos, int inlength, int[] out, IntWrapper outpos, int num) {
		int currentPos = outpos.get();
		int tmpinpos = inpos.get();
		final int finalout = currentPos + num;
		while (currentPos < finalout - 2 * 28) {

			int val = in[tmpinpos++];
			int valn = in[tmpinpos++];
			int header = val >>> 24;
			switch (header) {
			case 0: {
				decode0(val, valn, out, currentPos);
				currentPos+=56;
				break;
			}
			case 1: { 
				decode1(val, valn, out, currentPos);
				currentPos+=42;
				break;
			}
			case 2: {
				decode2(val, valn, out, currentPos);
				currentPos+=37;
				break;
			}
			case 3: {
				decode3(val, valn, out, currentPos);
				currentPos+=35;		
				break;
			}
			case 4: {
				decode4(val, valn, out, currentPos);
				currentPos+=33;
				break;
			}
			case 5: {
				decode5(val, valn, out, currentPos);
				currentPos+=32;
				break;
			}
			case 6: {
				decode6(val, valn, out, currentPos);
				currentPos+=31;
				break;
			}
			case 7: {
				decode7(val, valn, out, currentPos);
				currentPos+=30;
				break;
			}
			case 8: {
				decode8(val, valn, out, currentPos);
				currentPos+=29;
				break;
			}
			case 9: {
				decode9(val, valn, out, currentPos);
				currentPos+=42;	
				break;
			}
			case 10: {
				decode10(val, valn, out, currentPos);
				currentPos+=28;	
				break;
			}
			case 11: { 
				decode11(val, valn, out, currentPos);
				currentPos+=23;
				break;
			}
			case 12: {
				decode12(val, valn, out, currentPos);
				currentPos+=21;
				break;
			}
			case 13: {
				decode13(val, valn, out, currentPos);
				currentPos+=19;
				break;
			}
			case 14: {
				decode14(val, valn, out, currentPos);
				currentPos+=18;
				break;
			}
			case 15: {
				decode15(val, valn, out, currentPos);
				currentPos+=17;
				break;
			}
			case 16: {
				decode16(val, valn, out, currentPos);
				currentPos+=16;
				break;
			}
			case 17: {
				decode17(val, valn, out, currentPos);
				currentPos+=15;
				break;
			}
			case 18: {
				decode18(val, valn, out, currentPos);
				currentPos+=37;
				break;
			}
			case 19: {
				decode19(val, valn, out, currentPos);
				currentPos+=23;
				break;
			}
			case 20: {
				decode20(val, valn, out, currentPos);
				currentPos+=18;
				break;
			}
			case 21: {
				decode21(val, valn, out, currentPos);
				currentPos+=16;
				break;
			}
			case 22: { 
				decode22(val, valn, out, currentPos);
				currentPos+=14;
				break;
			}
			case 23: {
				decode23(val, valn, out, currentPos);
				currentPos+=13;
				break;
			}
			case 24: {
				decode24(val, valn, out, currentPos);
				currentPos+=12;
				break;
			}
			case 25: {
				decode25(val, valn, out, currentPos);
				currentPos+=11;
				break;
			}
			case 26: {
				decode26(val, valn, out, currentPos);
				currentPos+=10;
				break;
			}
			case 27: {
				decode27(val, valn, out, currentPos);
				currentPos+=35;
				break;
			}
			case 28: {
				decode28(val, valn, out, currentPos);
				currentPos+=21;
				break;
			}
			case 29: { 
				decode29(val, valn, out, currentPos);
				currentPos+=16;
				break;
			}

			case 30: {
				decode30(val, valn, out, currentPos);
				currentPos+=14;
				break;
			}
			case 31: { 
				decode31(val, valn, out, currentPos);
				currentPos+=12;
				break;
			}
			case 32: {
				decode32(val, valn, out, currentPos);
				currentPos+=11;
				break;
			}
			case 33: {
				decode33(val, valn, out, currentPos);
				currentPos+=10;
				break;
			}
			case 34: {
				decode34(val, valn, out, currentPos);
				currentPos+=9;
				break;
			}
			case 35: {
				decode35(val, valn, out, currentPos);
				currentPos+=8;
				break;
			}
			case 36: {
				decode36(val, valn, out, currentPos);
				currentPos+=33;
				break;
			}
			case 37: {
				decode37(val, valn, out, currentPos);
				currentPos+=19;
				break;
			}
			case 38: {
				decode38(val, valn, out, currentPos);
				currentPos+=14;
				break;
			}
			case 39: {
				decode39(val, valn, out, currentPos);
				currentPos+=12;
				break;
			}
			case 40: {
				decode40(val, valn, out, currentPos);
				currentPos+=10;
				break;
			}
			case 41: {
				decode41(val, valn, out, currentPos);
				currentPos+=9;
				break;
			}
			case 42: { 
				decode42(val, valn, out, currentPos);
				currentPos+=8;
				break;
			}
			case 43: { 
				decode43(val, valn, out, currentPos);
				currentPos+=7;
				break;
			}
			case 44: {
				decode44(val, valn, out, currentPos);
				currentPos+=6;
				break;
			}
			case 45: {
				decode45(val, valn, out, currentPos);
				currentPos+=32;
				break;
			}
			case 46: {
				decode46(val, valn, out, currentPos);
				currentPos+=18;
				break;
			}
			case 47: { 
				decode47(val, valn, out, currentPos);
				currentPos+=13;
				break;
			}
			case 48: {
				decode48(val, valn, out, currentPos);
				currentPos+=11;
				break;
			}
			case 49: {
				decode49(val, valn, out, currentPos);
				currentPos+=9;
				break;
			}
			case 50: {
				decode50(val, valn, out, currentPos);
				currentPos+=8;
				break;
			}
			case 51: {
				decode51(val, valn, out, currentPos);
				currentPos+=7;
				break;
			}
			case 52: { 
				decode52(val, valn, out, currentPos);
				currentPos+=6;
				break;
			}
			case 53: {
				decode53(val, valn, out, currentPos);
				currentPos+=5;
				break;
			}
			case 54: {
				decode54(val, valn, out, currentPos);
				currentPos+=31;
				break;
			}
			case 55: {
				decode55(val, valn, out, currentPos);
				currentPos+=17;
				break;
			}
			case 56: {
				decode56(val, valn, out, currentPos);
				currentPos+=12;
				break;
			}
			case 57: {
				decode57(val, valn, out, currentPos);
				currentPos+=10;
				break;
			}
			case 58: { 
				decode58(val, valn, out, currentPos);
				currentPos+=8;
				break;
			}
			case 59: {
				decode59(val, valn, out, currentPos);
				currentPos+=7;
				break;
			}
			case 60: {
				decode60(val, valn, out, currentPos);
				currentPos+=6;
				break;
			}
			case 61: { 
				decode61(val, valn, out, currentPos);
				currentPos+=5;
				break;
			}
			case 62: {
				decode62(val, valn, out, currentPos);
				currentPos+=4;
				break;
			}
			case 63: {
				decode63(val, valn, out, currentPos);
				currentPos+=30;
				break;
			}
			case 64: {
				decode64(val, valn, out, currentPos);
				currentPos+=16;
				break;
			}
			case 65: { 
				decode65(val, valn, out, currentPos);
				currentPos+=11;
				break;
			}
			case 66: { 
				decode66(val, valn, out, currentPos);
				currentPos+=9;
				break;
			}
			case 67: {
				decode67(val, valn, out, currentPos);
				currentPos+=7;
				break;
			}
			case 68: { 
				decode68(val, valn, out, currentPos);
				currentPos+=6;
				break;
			}
			case 69: { 
				decode69(val, valn, out, currentPos);
				currentPos+=5;
				break;
			}
			case 70: {
				decode70(val, valn, out, currentPos);
				currentPos+=4;
				break;
			}
			case 71: {
				decode71(val, valn, out, currentPos);
				currentPos+=3;
				break;
			}
			case 72: { 
				decode72(val, valn, out, currentPos);
				currentPos+=29;
				break;
			}
			case 73: {
				decode73(val, valn, out, currentPos);
				currentPos+=15;
				break;
			}
			case 74: {
				decode74(val, valn, out, currentPos);
				currentPos+=10;
				break;
			}
			case 75: {
				decode75(val, valn, out, currentPos);
				currentPos+=8;
				break;
			}
			case 76: {
				decode76(val, valn, out, currentPos);
				currentPos+=6;
				break;
			}
			case 77: {
				decode77(val, valn, out, currentPos);
				currentPos+=5;
				break;
			}
			case 78: {
				decode78(val, valn, out, currentPos);
				currentPos+=4;
				break;
			}
			case 79: {
				decode79(val, valn, out, currentPos);
				currentPos+=3;
				break;
			}
			case 80: {
				decode80(val, valn, out, currentPos);
				currentPos+=2;
				break;
			}
			default:
				throw new RuntimeException("Wrong code: " + header);
			}// end switch
		} // end while

		while (currentPos < finalout) {
			int val = in[tmpinpos++];
			int header = val >>> 28;
			switch (header) {
			case 0: { // number : 28, bitwidth : 1
				final int howmany = finalout - currentPos < 28 ? finalout - currentPos : 28;
				for (int k = 0; k < howmany; ++k) {
					out[currentPos++] = (val << (k + 4)) >>> 31;
				}
				break;
			}
			case 1: { // number : 14, bitwidth : 2
				final int howmany = finalout - currentPos < 14 ? finalout - currentPos : 14;
				for (int k = 0; k < howmany; ++k) {
					out[currentPos++] = (val << (2 * k + 4)) >>> 30;
				}
				break;
			}
			case 2: { // number : 9, bitwidth : 3
				final int howmany = finalout - currentPos < 9 ? finalout - currentPos : 9;
				for (int k = 0; k < howmany; ++k) {
					out[currentPos++] = (val << (3 * k + 5)) >>> 29;
				}
				break;
			}
			case 3: { // number : 7, bitwidth : 4
				final int howmany = finalout - currentPos < 7 ? finalout - currentPos : 7;
				for (int k = 0; k < howmany; ++k) {
					out[currentPos++] = (val << (4 * k + 4)) >>> 28;
				}
				break;
			}
			case 4: { // number : 5, bitwidth : 5
				final int howmany = finalout - currentPos < 5 ? finalout - currentPos : 5;
				for (int k = 0; k < howmany; ++k) {
					out[currentPos++] = (val << (5 * k + 7)) >>> 27;
				}
				break;
			}
			case 5: { // number : 4, bitwidth : 7
				final int howmany = finalout - currentPos < 4 ? finalout - currentPos : 4;
				for (int k = 0; k < howmany; ++k) {
					out[currentPos++] = (val << (7 * k + 4)) >>> 25;
				}
				break;
			}
			case 6: { // number : 3, bitwidth : 9
				final int howmany = finalout - currentPos < 3 ? finalout - currentPos : 3;
				for (int k = 0; k < howmany; ++k) {
					out[currentPos++] = (val << (9 * k + 5)) >>> 23;
				}
				break;
			}
			case 7: { // number : 2, bitwidth : 14
				final int howmany = finalout - currentPos < 2 ? finalout - currentPos : 2;
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

		outpos.set(finalout);
		inpos.set(tmpinpos);
		
	}
}