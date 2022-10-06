// Copyright (C) 2022 Intel Corporation

// SPDX-License-Identifier: Apache-2.0

package me.lemire.integercompression.vector;

import java.util.Arrays;
import jdk.incubator.vector.*;

/**
 * Vectorized bitpacking routines. This class is a version of the
 * VectorBitPackerTerse class that with less branch instructions. 
 *
 * The code is machine generated from VectorBitPackerTerse.java using helper
 * classes.
 *
 */
public class VectorBitPacker {
  private static final VectorSpecies<Integer> SPECIES_512 =
      IntVector.SPECIES_512;
  private static final VectorSpecies<Integer> SPECIES_256 =
      IntVector.SPECIES_256;
  private static final int VLEN_512 = 16;
  private static final int VLEN_256 = 8;
  private static final int BLOCK_SIZE = 256;

  private static final IntVector MASK_1 =
      IntVector.broadcast(SPECIES_256, (1 << 1) - 1);
  private static final IntVector MASK_2 =
      IntVector.broadcast(SPECIES_512, (1 << 2) - 1);
  private static final IntVector MASK_3 =
      IntVector.broadcast(SPECIES_256, (1 << 3) - 1);
  private static final IntVector MASK_4 =
      IntVector.broadcast(SPECIES_512, (1 << 4) - 1);
  private static final IntVector MASK_5 =
      IntVector.broadcast(SPECIES_256, (1 << 5) - 1);
  private static final IntVector MASK_6 =
      IntVector.broadcast(SPECIES_512, (1 << 6) - 1);
  private static final IntVector MASK_7 =
      IntVector.broadcast(SPECIES_256, (1 << 7) - 1);
  private static final IntVector MASK_8 =
      IntVector.broadcast(SPECIES_512, (1 << 8) - 1);
  private static final IntVector MASK_9 =
      IntVector.broadcast(SPECIES_256, (1 << 9) - 1);
  private static final IntVector MASK_10 =
      IntVector.broadcast(SPECIES_512, (1 << 10) - 1);
  private static final IntVector MASK_11 =
      IntVector.broadcast(SPECIES_256, (1 << 11) - 1);
  private static final IntVector MASK_12 =
      IntVector.broadcast(SPECIES_512, (1 << 12) - 1);
  private static final IntVector MASK_13 =
      IntVector.broadcast(SPECIES_256, (1 << 13) - 1);
  private static final IntVector MASK_14 =
      IntVector.broadcast(SPECIES_512, (1 << 14) - 1);
  private static final IntVector MASK_15 =
      IntVector.broadcast(SPECIES_256, (1 << 15) - 1);
  private static final IntVector MASK_16 =
      IntVector.broadcast(SPECIES_512, (1 << 16) - 1);
  private static final IntVector MASK_17 =
      IntVector.broadcast(SPECIES_256, (1 << 17) - 1);
  private static final IntVector MASK_18 =
      IntVector.broadcast(SPECIES_512, (1 << 18) - 1);
  private static final IntVector MASK_19 =
      IntVector.broadcast(SPECIES_256, (1 << 19) - 1);
  private static final IntVector MASK_20 =
      IntVector.broadcast(SPECIES_512, (1 << 20) - 1);
  private static final IntVector MASK_21 =
      IntVector.broadcast(SPECIES_256, (1 << 21) - 1);
  private static final IntVector MASK_22 =
      IntVector.broadcast(SPECIES_512, (1 << 22) - 1);
  private static final IntVector MASK_23 =
      IntVector.broadcast(SPECIES_256, (1 << 23) - 1);
  private static final IntVector MASK_24 =
      IntVector.broadcast(SPECIES_512, (1 << 24) - 1);
  private static final IntVector MASK_25 =
      IntVector.broadcast(SPECIES_256, (1 << 25) - 1);
  private static final IntVector MASK_26 =
      IntVector.broadcast(SPECIES_512, (1 << 26) - 1);
  private static final IntVector MASK_27 =
      IntVector.broadcast(SPECIES_256, (1 << 27) - 1);
  private static final IntVector MASK_28 =
      IntVector.broadcast(SPECIES_512, (1 << 28) - 1);
  private static final IntVector MASK_29 =
      IntVector.broadcast(SPECIES_256, (1 << 29) - 1);
  private static final IntVector MASK_30 =
      IntVector.broadcast(SPECIES_512, (1 << 30) - 1);
  private static final IntVector MASK_31 =
      IntVector.broadcast(SPECIES_256, (1 << 31) - 1);

  /**
   * Pack 32 integers
   *
   * @param in
   *                source array
   * @param inpos
   *                position in source array
   * @param out
   *                output array
   * @param outpos
   *                position in output array
   * @param b
   *                number of bits to use per integer
   */
  public static void fastpack(final int[] in, int inpos, final int[] out,
                              int outpos, int b) {
    switch (b) {
    case 0:
      break;
    case 1:
      fastpack1(in, inpos, out, outpos);
      break;
    case 2:
      fastpack2(in, inpos, out, outpos);
      break;
    case 3:
      fastpack3(in, inpos, out, outpos);
      break;
    case 4:
      fastpack4(in, inpos, out, outpos);
      break;
    case 5:
      fastpack5(in, inpos, out, outpos);
      break;
    case 6:
      fastpack6(in, inpos, out, outpos);
      break;
    case 7:
      fastpack7(in, inpos, out, outpos);
      break;
    case 8:
      fastpack8(in, inpos, out, outpos);
      break;
    case 9:
      fastpack9(in, inpos, out, outpos);
      break;
    case 10:
      fastpack10(in, inpos, out, outpos);
      break;
    case 11:
      fastpack11(in, inpos, out, outpos);
      break;
    case 12:
      fastpack12(in, inpos, out, outpos);
      break;
    case 13:
      fastpack13(in, inpos, out, outpos);
      break;
    case 14:
      fastpack14(in, inpos, out, outpos);
      break;
    case 15:
      fastpack15(in, inpos, out, outpos);
      break;
    case 16:
      fastpack16(in, inpos, out, outpos);
      break;
    case 17:
      fastpack17(in, inpos, out, outpos);
      break;
    case 18:
      fastpack18(in, inpos, out, outpos);
      break;
    case 19:
      fastpack19(in, inpos, out, outpos);
      break;
    case 20:
      fastpack20(in, inpos, out, outpos);
      break;
    case 21:
      fastpack21(in, inpos, out, outpos);
      break;
    case 22:
      fastpack22(in, inpos, out, outpos);
      break;
    case 23:
      fastpack23(in, inpos, out, outpos);
      break;
    case 24:
      fastpack24(in, inpos, out, outpos);
      break;
    case 25:
      fastpack25(in, inpos, out, outpos);
      break;
    case 26:
      fastpack26(in, inpos, out, outpos);
      break;
    case 27:
      fastpack27(in, inpos, out, outpos);
      break;
    case 28:
      fastpack28(in, inpos, out, outpos);
      break;
    case 29:
      fastpack29(in, inpos, out, outpos);
      break;
    case 30:
      fastpack30(in, inpos, out, outpos);
      break;
    case 31:
      fastpack31(in, inpos, out, outpos);
      break;
    case 32:
      System.arraycopy(in, inpos, out, outpos, BLOCK_SIZE);
      break;
    }
  }

  static void fastpackNoMask(final int[] in, int inpos, final int[] out,
                             int outpos, int b) {
    switch (b) {
    case 0:
      break;
    case 1:
      fastpackNoMask1(in, inpos, out, outpos);
      break;
    case 2:
      fastpackNoMask2(in, inpos, out, outpos);
      break;
    case 3:
      fastpackNoMask3(in, inpos, out, outpos);
      break;
    case 4:
      fastpackNoMask4(in, inpos, out, outpos);
      break;
    case 5:
      fastpackNoMask5(in, inpos, out, outpos);
      break;
    case 6:
      fastpackNoMask6(in, inpos, out, outpos);
      break;
    case 7:
      fastpackNoMask7(in, inpos, out, outpos);
      break;
    case 8:
      fastpackNoMask8(in, inpos, out, outpos);
      break;
    case 9:
      fastpackNoMask9(in, inpos, out, outpos);
      break;
    case 10:
      fastpackNoMask10(in, inpos, out, outpos);
      break;
    case 11:
      fastpackNoMask11(in, inpos, out, outpos);
      break;
    case 12:
      fastpackNoMask12(in, inpos, out, outpos);
      break;
    case 13:
      fastpackNoMask13(in, inpos, out, outpos);
      break;
    case 14:
      fastpackNoMask14(in, inpos, out, outpos);
      break;
    case 15:
      fastpackNoMask15(in, inpos, out, outpos);
      break;
    case 16:
      fastpackNoMask16(in, inpos, out, outpos);
      break;
    case 17:
      fastpackNoMask17(in, inpos, out, outpos);
      break;
    case 18:
      fastpackNoMask18(in, inpos, out, outpos);
      break;
    case 19:
      fastpackNoMask19(in, inpos, out, outpos);
      break;
    case 20:
      fastpackNoMask20(in, inpos, out, outpos);
      break;
    case 21:
      fastpackNoMask21(in, inpos, out, outpos);
      break;
    case 22:
      fastpackNoMask22(in, inpos, out, outpos);
      break;
    case 23:
      fastpackNoMask23(in, inpos, out, outpos);
      break;
    case 24:
      fastpackNoMask24(in, inpos, out, outpos);
      break;
    case 25:
      fastpackNoMask25(in, inpos, out, outpos);
      break;
    case 26:
      fastpackNoMask26(in, inpos, out, outpos);
      break;
    case 27:
      fastpackNoMask27(in, inpos, out, outpos);
      break;
    case 28:
      fastpackNoMask28(in, inpos, out, outpos);
      break;
    case 29:
      fastpackNoMask29(in, inpos, out, outpos);
      break;
    case 30:
      fastpackNoMask30(in, inpos, out, outpos);
      break;
    case 31:
      fastpackNoMask31(in, inpos, out, outpos);
      break;
    case 32:
      System.arraycopy(in, inpos, out, outpos, BLOCK_SIZE);
      break;
    }
  }

  /**
   * Unpack 32 integers
   *
   * @param in
   *                source array
   * @param inpos
   *                position in source array
   * @param out
   *                output array
   * @param outpos
   *                position in output array
   * @param b
   *                number of bits to use per integer
   */
  public static void fastunpack(final int[] in, int inpos, final int[] out,
                                int outpos, int b) {
    switch (b) {
    case 0:
      Arrays.fill(out, outpos, outpos + 256, 0);
      break;
    case 1:
      fastunpack1(in, inpos, out, outpos);
      break;
    case 2:
      fastunpack2(in, inpos, out, outpos);
      break;
    case 3:
      fastunpack3(in, inpos, out, outpos);
      break;
    case 4:
      fastunpack4(in, inpos, out, outpos);
      break;
    case 5:
      fastunpack5(in, inpos, out, outpos);
      break;
    case 6:
      fastunpack6(in, inpos, out, outpos);
      break;
    case 7:
      fastunpack7(in, inpos, out, outpos);
      break;
    case 8:
      fastunpack8(in, inpos, out, outpos);
      break;
    case 9:
      fastunpack9(in, inpos, out, outpos);
      break;
    case 10:
      fastunpack10(in, inpos, out, outpos);
      break;
    case 11:
      fastunpack11(in, inpos, out, outpos);
      break;
    case 12:
      fastunpack12(in, inpos, out, outpos);
      break;
    case 13:
      fastunpack13(in, inpos, out, outpos);
      break;
    case 14:
      fastunpack14(in, inpos, out, outpos);
      break;
    case 15:
      fastunpack15(in, inpos, out, outpos);
      break;
    case 16:
      fastunpack16(in, inpos, out, outpos);
      break;
    case 17:
      fastunpack17(in, inpos, out, outpos);
      break;
    case 18:
      fastunpack18(in, inpos, out, outpos);
      break;
    case 19:
      fastunpack19(in, inpos, out, outpos);
      break;
    case 20:
      fastunpack20(in, inpos, out, outpos);
      break;
    case 21:
      fastunpack21(in, inpos, out, outpos);
      break;
    case 22:
      fastunpack22(in, inpos, out, outpos);
      break;
    case 23:
      fastunpack23(in, inpos, out, outpos);
      break;
    case 24:
      fastunpack24(in, inpos, out, outpos);
      break;
    case 25:
      fastunpack25(in, inpos, out, outpos);
      break;
    case 26:
      fastunpack26(in, inpos, out, outpos);
      break;
    case 27:
      fastunpack27(in, inpos, out, outpos);
      break;
    case 28:
      fastunpack28(in, inpos, out, outpos);
      break;
    case 29:
      fastunpack29(in, inpos, out, outpos);
      break;
    case 30:
      fastunpack30(in, inpos, out, outpos);
      break;
    case 31:
      fastunpack31(in, inpos, out, outpos);
      break;
    case 32:
      System.arraycopy(in, inpos, out, outpos, BLOCK_SIZE);
      break;
    }
  }

  public static int slowpack(final int[] in, int inpos, int inlen,
                             final int[] out, int outpos, int b) {
    if (inlen == 0)
      return outpos;
    if (b == 32) {
      System.arraycopy(in, inpos, out, outpos, inlen);
      return outpos + inlen;
    }
    int mask = (1 << b) - 1;
    int c = 0;
    int l = 0;
    int r = 0;
    int val = 0;
    for (int i = 0; i < inlen; i++) {
      val = in[inpos + i] & mask;
      out[outpos] |= val << (c + r);
      c += b;
      l = (32 - r) % b;
      if (c + r >= 32) {
        if (i < inlen - 1 || l != 0)
          outpos++;
        r = l == 0 ? 0 : b - l;
        if (l != 0)
          out[outpos] = val >> (b - r);
        c = 0;
      }
    }
    return outpos;
  }

  public static int slowunpack(final int[] in, int inpos, final int[] out,
                               int outpos, int outlen, int b) {
    if (outlen == 0) {
      return inpos;
    }
    if (b == 32) {
      System.arraycopy(in, inpos, out, outpos, outlen);
      return inpos + outlen;
    }
    int mask = (1 << b) - 1;
    int limit = outpos + outlen;
    int r = 0;
    int val = 0;
    int i = 0;
    for (; outpos < limit; i++) {
      if (r > 0)
        out[outpos++] =
            (val >>> (32 - (b - r))) | ((in[inpos + i] << (b - r)) & mask);
      val = in[inpos + i];
      int j = 0;
      int l = 32 - r;
      int ll = l % b == 0 ? l : l - b;
      while (j < ll && outpos < limit) {
        out[outpos++] = (val >> (j + r)) & mask;
        j += b;
      }
      r = l % b == 0 ? 0 : b - (l % b);
    }
    return inpos + i;
  }

  public static int numCompressedInts(int n, int b) {
    int width = b % 2 == 0 ? VLEN_512 : VLEN_256;
    if (n <= width)
      return n;
    int intsPerVec = (32 / b) * width;
    int q = (n + intsPerVec - 1) / intsPerVec;
    return q * width;
  }

  private static void fastpack1(final int[] in, int inpos, final int[] out,
                                int outpos) {
    var iV = IntVector.fromArray(SPECIES_256, in, inpos);
    var oV = iV.and(MASK_1);
    iV = IntVector.fromArray(SPECIES_256, in, inpos + 8);
    oV = iV.and(MASK_1).lanewise(VectorOperators.LSHL, 1).or(oV);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 16);
    oV = iV.and(MASK_1).lanewise(VectorOperators.LSHL, 2).or(oV);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 24);
    oV = iV.and(MASK_1).lanewise(VectorOperators.LSHL, 3).or(oV);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 32);
    oV = iV.and(MASK_1).lanewise(VectorOperators.LSHL, 4).or(oV);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 40);
    oV = iV.and(MASK_1).lanewise(VectorOperators.LSHL, 5).or(oV);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 48);
    oV = iV.and(MASK_1).lanewise(VectorOperators.LSHL, 6).or(oV);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 56);
    oV = iV.and(MASK_1).lanewise(VectorOperators.LSHL, 7).or(oV);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 64);
    oV = iV.and(MASK_1).lanewise(VectorOperators.LSHL, 8).or(oV);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 72);
    oV = iV.and(MASK_1).lanewise(VectorOperators.LSHL, 9).or(oV);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 80);
    oV = iV.and(MASK_1).lanewise(VectorOperators.LSHL, 10).or(oV);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 88);
    oV = iV.and(MASK_1).lanewise(VectorOperators.LSHL, 11).or(oV);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 96);
    oV = iV.and(MASK_1).lanewise(VectorOperators.LSHL, 12).or(oV);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 104);
    oV = iV.and(MASK_1).lanewise(VectorOperators.LSHL, 13).or(oV);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 112);
    oV = iV.and(MASK_1).lanewise(VectorOperators.LSHL, 14).or(oV);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 120);
    oV = iV.and(MASK_1).lanewise(VectorOperators.LSHL, 15).or(oV);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 128);
    oV = iV.and(MASK_1).lanewise(VectorOperators.LSHL, 16).or(oV);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 136);
    oV = iV.and(MASK_1).lanewise(VectorOperators.LSHL, 17).or(oV);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 144);
    oV = iV.and(MASK_1).lanewise(VectorOperators.LSHL, 18).or(oV);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 152);
    oV = iV.and(MASK_1).lanewise(VectorOperators.LSHL, 19).or(oV);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 160);
    oV = iV.and(MASK_1).lanewise(VectorOperators.LSHL, 20).or(oV);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 168);
    oV = iV.and(MASK_1).lanewise(VectorOperators.LSHL, 21).or(oV);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 176);
    oV = iV.and(MASK_1).lanewise(VectorOperators.LSHL, 22).or(oV);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 184);
    oV = iV.and(MASK_1).lanewise(VectorOperators.LSHL, 23).or(oV);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 192);
    oV = iV.and(MASK_1).lanewise(VectorOperators.LSHL, 24).or(oV);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 200);
    oV = iV.and(MASK_1).lanewise(VectorOperators.LSHL, 25).or(oV);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 208);
    oV = iV.and(MASK_1).lanewise(VectorOperators.LSHL, 26).or(oV);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 216);
    oV = iV.and(MASK_1).lanewise(VectorOperators.LSHL, 27).or(oV);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 224);
    oV = iV.and(MASK_1).lanewise(VectorOperators.LSHL, 28).or(oV);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 232);
    oV = iV.and(MASK_1).lanewise(VectorOperators.LSHL, 29).or(oV);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 240);
    oV = iV.and(MASK_1).lanewise(VectorOperators.LSHL, 30).or(oV);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 248);
    oV = iV.and(MASK_1).lanewise(VectorOperators.LSHL, 31).or(oV);

    oV.intoArray(out, outpos);
  }

  private static void fastpack2(final int[] in, int inpos, final int[] out,
                                int outpos) {
    var iV = IntVector.fromArray(SPECIES_512, in, inpos);
    var oV = iV.and(MASK_2);
    iV = IntVector.fromArray(SPECIES_512, in, inpos + 16);
    oV = iV.and(MASK_2).lanewise(VectorOperators.LSHL, 2).or(oV);

    iV = IntVector.fromArray(SPECIES_512, in, inpos + 32);
    oV = iV.and(MASK_2).lanewise(VectorOperators.LSHL, 4).or(oV);

    iV = IntVector.fromArray(SPECIES_512, in, inpos + 48);
    oV = iV.and(MASK_2).lanewise(VectorOperators.LSHL, 6).or(oV);

    iV = IntVector.fromArray(SPECIES_512, in, inpos + 64);
    oV = iV.and(MASK_2).lanewise(VectorOperators.LSHL, 8).or(oV);

    iV = IntVector.fromArray(SPECIES_512, in, inpos + 80);
    oV = iV.and(MASK_2).lanewise(VectorOperators.LSHL, 10).or(oV);

    iV = IntVector.fromArray(SPECIES_512, in, inpos + 96);
    oV = iV.and(MASK_2).lanewise(VectorOperators.LSHL, 12).or(oV);

    iV = IntVector.fromArray(SPECIES_512, in, inpos + 112);
    oV = iV.and(MASK_2).lanewise(VectorOperators.LSHL, 14).or(oV);

    iV = IntVector.fromArray(SPECIES_512, in, inpos + 128);
    oV = iV.and(MASK_2).lanewise(VectorOperators.LSHL, 16).or(oV);

    iV = IntVector.fromArray(SPECIES_512, in, inpos + 144);
    oV = iV.and(MASK_2).lanewise(VectorOperators.LSHL, 18).or(oV);

    iV = IntVector.fromArray(SPECIES_512, in, inpos + 160);
    oV = iV.and(MASK_2).lanewise(VectorOperators.LSHL, 20).or(oV);

    iV = IntVector.fromArray(SPECIES_512, in, inpos + 176);
    oV = iV.and(MASK_2).lanewise(VectorOperators.LSHL, 22).or(oV);

    iV = IntVector.fromArray(SPECIES_512, in, inpos + 192);
    oV = iV.and(MASK_2).lanewise(VectorOperators.LSHL, 24).or(oV);

    iV = IntVector.fromArray(SPECIES_512, in, inpos + 208);
    oV = iV.and(MASK_2).lanewise(VectorOperators.LSHL, 26).or(oV);

    iV = IntVector.fromArray(SPECIES_512, in, inpos + 224);
    oV = iV.and(MASK_2).lanewise(VectorOperators.LSHL, 28).or(oV);

    iV = IntVector.fromArray(SPECIES_512, in, inpos + 240);
    oV = iV.and(MASK_2).lanewise(VectorOperators.LSHL, 30).or(oV);

    oV.intoArray(out, outpos);
  }

  private static void fastpack3(final int[] in, int inpos, final int[] out,
                                int outpos) {
    var iV = IntVector.fromArray(SPECIES_256, in, inpos);
    var oV = iV.and(MASK_3);
    iV = IntVector.fromArray(SPECIES_256, in, inpos + 8);
    oV = iV.and(MASK_3).lanewise(VectorOperators.LSHL, 3).or(oV);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 16);
    oV = iV.and(MASK_3).lanewise(VectorOperators.LSHL, 6).or(oV);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 24);
    oV = iV.and(MASK_3).lanewise(VectorOperators.LSHL, 9).or(oV);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 32);
    oV = iV.and(MASK_3).lanewise(VectorOperators.LSHL, 12).or(oV);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 40);
    oV = iV.and(MASK_3).lanewise(VectorOperators.LSHL, 15).or(oV);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 48);
    oV = iV.and(MASK_3).lanewise(VectorOperators.LSHL, 18).or(oV);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 56);
    oV = iV.and(MASK_3).lanewise(VectorOperators.LSHL, 21).or(oV);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 64);
    oV = iV.and(MASK_3).lanewise(VectorOperators.LSHL, 24).or(oV);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 72);
    oV = iV.and(MASK_3).lanewise(VectorOperators.LSHL, 27).or(oV);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 80);
    oV = iV.and(MASK_3).lanewise(VectorOperators.LSHL, 30).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.and(MASK_3).lanewise(VectorOperators.LSHR, 2);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 88);
    oV = iV.and(MASK_3).lanewise(VectorOperators.LSHL, 1).or(oV);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 96);
    oV = iV.and(MASK_3).lanewise(VectorOperators.LSHL, 4).or(oV);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 104);
    oV = iV.and(MASK_3).lanewise(VectorOperators.LSHL, 7).or(oV);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 112);
    oV = iV.and(MASK_3).lanewise(VectorOperators.LSHL, 10).or(oV);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 120);
    oV = iV.and(MASK_3).lanewise(VectorOperators.LSHL, 13).or(oV);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 128);
    oV = iV.and(MASK_3).lanewise(VectorOperators.LSHL, 16).or(oV);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 136);
    oV = iV.and(MASK_3).lanewise(VectorOperators.LSHL, 19).or(oV);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 144);
    oV = iV.and(MASK_3).lanewise(VectorOperators.LSHL, 22).or(oV);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 152);
    oV = iV.and(MASK_3).lanewise(VectorOperators.LSHL, 25).or(oV);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 160);
    oV = iV.and(MASK_3).lanewise(VectorOperators.LSHL, 28).or(oV);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 168);
    oV = iV.and(MASK_3).lanewise(VectorOperators.LSHL, 31).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.and(MASK_3).lanewise(VectorOperators.LSHR, 1);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 176);
    oV = iV.and(MASK_3).lanewise(VectorOperators.LSHL, 2).or(oV);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 184);
    oV = iV.and(MASK_3).lanewise(VectorOperators.LSHL, 5).or(oV);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 192);
    oV = iV.and(MASK_3).lanewise(VectorOperators.LSHL, 8).or(oV);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 200);
    oV = iV.and(MASK_3).lanewise(VectorOperators.LSHL, 11).or(oV);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 208);
    oV = iV.and(MASK_3).lanewise(VectorOperators.LSHL, 14).or(oV);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 216);
    oV = iV.and(MASK_3).lanewise(VectorOperators.LSHL, 17).or(oV);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 224);
    oV = iV.and(MASK_3).lanewise(VectorOperators.LSHL, 20).or(oV);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 232);
    oV = iV.and(MASK_3).lanewise(VectorOperators.LSHL, 23).or(oV);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 240);
    oV = iV.and(MASK_3).lanewise(VectorOperators.LSHL, 26).or(oV);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 248);
    oV = iV.and(MASK_3).lanewise(VectorOperators.LSHL, 29).or(oV);

    oV.intoArray(out, outpos);
  }

  private static void fastpack4(final int[] in, int inpos, final int[] out,
                                int outpos) {
    var iV = IntVector.fromArray(SPECIES_512, in, inpos);
    var oV = iV.and(MASK_4);
    iV = IntVector.fromArray(SPECIES_512, in, inpos + 16);
    oV = iV.and(MASK_4).lanewise(VectorOperators.LSHL, 4).or(oV);

    iV = IntVector.fromArray(SPECIES_512, in, inpos + 32);
    oV = iV.and(MASK_4).lanewise(VectorOperators.LSHL, 8).or(oV);

    iV = IntVector.fromArray(SPECIES_512, in, inpos + 48);
    oV = iV.and(MASK_4).lanewise(VectorOperators.LSHL, 12).or(oV);

    iV = IntVector.fromArray(SPECIES_512, in, inpos + 64);
    oV = iV.and(MASK_4).lanewise(VectorOperators.LSHL, 16).or(oV);

    iV = IntVector.fromArray(SPECIES_512, in, inpos + 80);
    oV = iV.and(MASK_4).lanewise(VectorOperators.LSHL, 20).or(oV);

    iV = IntVector.fromArray(SPECIES_512, in, inpos + 96);
    oV = iV.and(MASK_4).lanewise(VectorOperators.LSHL, 24).or(oV);

    iV = IntVector.fromArray(SPECIES_512, in, inpos + 112);
    oV = iV.and(MASK_4).lanewise(VectorOperators.LSHL, 28).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_512;
    oV = oV.zero(SPECIES_512);

    iV = IntVector.fromArray(SPECIES_512, in, inpos + 128);
    oV = iV.and(MASK_4).or(oV);

    iV = IntVector.fromArray(SPECIES_512, in, inpos + 144);
    oV = iV.and(MASK_4).lanewise(VectorOperators.LSHL, 4).or(oV);

    iV = IntVector.fromArray(SPECIES_512, in, inpos + 160);
    oV = iV.and(MASK_4).lanewise(VectorOperators.LSHL, 8).or(oV);

    iV = IntVector.fromArray(SPECIES_512, in, inpos + 176);
    oV = iV.and(MASK_4).lanewise(VectorOperators.LSHL, 12).or(oV);

    iV = IntVector.fromArray(SPECIES_512, in, inpos + 192);
    oV = iV.and(MASK_4).lanewise(VectorOperators.LSHL, 16).or(oV);

    iV = IntVector.fromArray(SPECIES_512, in, inpos + 208);
    oV = iV.and(MASK_4).lanewise(VectorOperators.LSHL, 20).or(oV);

    iV = IntVector.fromArray(SPECIES_512, in, inpos + 224);
    oV = iV.and(MASK_4).lanewise(VectorOperators.LSHL, 24).or(oV);

    iV = IntVector.fromArray(SPECIES_512, in, inpos + 240);
    oV = iV.and(MASK_4).lanewise(VectorOperators.LSHL, 28).or(oV);

    oV.intoArray(out, outpos);
  }

  private static void fastpack5(final int[] in, int inpos, final int[] out,
                                int outpos) {
    var iV = IntVector.fromArray(SPECIES_256, in, inpos);
    var oV = iV.and(MASK_5);
    iV = IntVector.fromArray(SPECIES_256, in, inpos + 8);
    oV = iV.and(MASK_5).lanewise(VectorOperators.LSHL, 5).or(oV);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 16);
    oV = iV.and(MASK_5).lanewise(VectorOperators.LSHL, 10).or(oV);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 24);
    oV = iV.and(MASK_5).lanewise(VectorOperators.LSHL, 15).or(oV);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 32);
    oV = iV.and(MASK_5).lanewise(VectorOperators.LSHL, 20).or(oV);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 40);
    oV = iV.and(MASK_5).lanewise(VectorOperators.LSHL, 25).or(oV);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 48);
    oV = iV.and(MASK_5).lanewise(VectorOperators.LSHL, 30).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.and(MASK_5).lanewise(VectorOperators.LSHR, 2);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 56);
    oV = iV.and(MASK_5).lanewise(VectorOperators.LSHL, 3).or(oV);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 64);
    oV = iV.and(MASK_5).lanewise(VectorOperators.LSHL, 8).or(oV);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 72);
    oV = iV.and(MASK_5).lanewise(VectorOperators.LSHL, 13).or(oV);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 80);
    oV = iV.and(MASK_5).lanewise(VectorOperators.LSHL, 18).or(oV);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 88);
    oV = iV.and(MASK_5).lanewise(VectorOperators.LSHL, 23).or(oV);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 96);
    oV = iV.and(MASK_5).lanewise(VectorOperators.LSHL, 28).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.and(MASK_5).lanewise(VectorOperators.LSHR, 4);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 104);
    oV = iV.and(MASK_5).lanewise(VectorOperators.LSHL, 1).or(oV);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 112);
    oV = iV.and(MASK_5).lanewise(VectorOperators.LSHL, 6).or(oV);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 120);
    oV = iV.and(MASK_5).lanewise(VectorOperators.LSHL, 11).or(oV);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 128);
    oV = iV.and(MASK_5).lanewise(VectorOperators.LSHL, 16).or(oV);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 136);
    oV = iV.and(MASK_5).lanewise(VectorOperators.LSHL, 21).or(oV);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 144);
    oV = iV.and(MASK_5).lanewise(VectorOperators.LSHL, 26).or(oV);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 152);
    oV = iV.and(MASK_5).lanewise(VectorOperators.LSHL, 31).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.and(MASK_5).lanewise(VectorOperators.LSHR, 1);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 160);
    oV = iV.and(MASK_5).lanewise(VectorOperators.LSHL, 4).or(oV);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 168);
    oV = iV.and(MASK_5).lanewise(VectorOperators.LSHL, 9).or(oV);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 176);
    oV = iV.and(MASK_5).lanewise(VectorOperators.LSHL, 14).or(oV);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 184);
    oV = iV.and(MASK_5).lanewise(VectorOperators.LSHL, 19).or(oV);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 192);
    oV = iV.and(MASK_5).lanewise(VectorOperators.LSHL, 24).or(oV);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 200);
    oV = iV.and(MASK_5).lanewise(VectorOperators.LSHL, 29).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.and(MASK_5).lanewise(VectorOperators.LSHR, 3);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 208);
    oV = iV.and(MASK_5).lanewise(VectorOperators.LSHL, 2).or(oV);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 216);
    oV = iV.and(MASK_5).lanewise(VectorOperators.LSHL, 7).or(oV);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 224);
    oV = iV.and(MASK_5).lanewise(VectorOperators.LSHL, 12).or(oV);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 232);
    oV = iV.and(MASK_5).lanewise(VectorOperators.LSHL, 17).or(oV);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 240);
    oV = iV.and(MASK_5).lanewise(VectorOperators.LSHL, 22).or(oV);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 248);
    oV = iV.and(MASK_5).lanewise(VectorOperators.LSHL, 27).or(oV);

    oV.intoArray(out, outpos);
  }

  private static void fastpack6(final int[] in, int inpos, final int[] out,
                                int outpos) {
    var iV = IntVector.fromArray(SPECIES_512, in, inpos);
    var oV = iV.and(MASK_6);
    iV = IntVector.fromArray(SPECIES_512, in, inpos + 16);
    oV = iV.and(MASK_6).lanewise(VectorOperators.LSHL, 6).or(oV);

    iV = IntVector.fromArray(SPECIES_512, in, inpos + 32);
    oV = iV.and(MASK_6).lanewise(VectorOperators.LSHL, 12).or(oV);

    iV = IntVector.fromArray(SPECIES_512, in, inpos + 48);
    oV = iV.and(MASK_6).lanewise(VectorOperators.LSHL, 18).or(oV);

    iV = IntVector.fromArray(SPECIES_512, in, inpos + 64);
    oV = iV.and(MASK_6).lanewise(VectorOperators.LSHL, 24).or(oV);

    iV = IntVector.fromArray(SPECIES_512, in, inpos + 80);
    oV = iV.and(MASK_6).lanewise(VectorOperators.LSHL, 30).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_512;
    oV = iV.and(MASK_6).lanewise(VectorOperators.LSHR, 2);

    iV = IntVector.fromArray(SPECIES_512, in, inpos + 96);
    oV = iV.and(MASK_6).lanewise(VectorOperators.LSHL, 4).or(oV);

    iV = IntVector.fromArray(SPECIES_512, in, inpos + 112);
    oV = iV.and(MASK_6).lanewise(VectorOperators.LSHL, 10).or(oV);

    iV = IntVector.fromArray(SPECIES_512, in, inpos + 128);
    oV = iV.and(MASK_6).lanewise(VectorOperators.LSHL, 16).or(oV);

    iV = IntVector.fromArray(SPECIES_512, in, inpos + 144);
    oV = iV.and(MASK_6).lanewise(VectorOperators.LSHL, 22).or(oV);

    iV = IntVector.fromArray(SPECIES_512, in, inpos + 160);
    oV = iV.and(MASK_6).lanewise(VectorOperators.LSHL, 28).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_512;

    oV = iV.and(MASK_6).lanewise(VectorOperators.LSHR, 4);

    iV = IntVector.fromArray(SPECIES_512, in, inpos + 176);
    oV = iV.and(MASK_6).lanewise(VectorOperators.LSHL, 2).or(oV);

    iV = IntVector.fromArray(SPECIES_512, in, inpos + 192);
    oV = iV.and(MASK_6).lanewise(VectorOperators.LSHL, 8).or(oV);

    iV = IntVector.fromArray(SPECIES_512, in, inpos + 208);
    oV = iV.and(MASK_6).lanewise(VectorOperators.LSHL, 14).or(oV);

    iV = IntVector.fromArray(SPECIES_512, in, inpos + 224);
    oV = iV.and(MASK_6).lanewise(VectorOperators.LSHL, 20).or(oV);

    iV = IntVector.fromArray(SPECIES_512, in, inpos + 240);
    oV = iV.and(MASK_6).lanewise(VectorOperators.LSHL, 26).or(oV);

    oV.intoArray(out, outpos);
  }

  private static void fastpack7(final int[] in, int inpos, final int[] out,
                                int outpos) {
    var iV = IntVector.fromArray(SPECIES_256, in, inpos);
    var oV = iV.and(MASK_7);
    iV = IntVector.fromArray(SPECIES_256, in, inpos + 8);
    oV = iV.and(MASK_7).lanewise(VectorOperators.LSHL, 7).or(oV);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 16);
    oV = iV.and(MASK_7).lanewise(VectorOperators.LSHL, 14).or(oV);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 24);
    oV = iV.and(MASK_7).lanewise(VectorOperators.LSHL, 21).or(oV);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 32);
    oV = iV.and(MASK_7).lanewise(VectorOperators.LSHL, 28).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.and(MASK_7).lanewise(VectorOperators.LSHR, 4);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 40);
    oV = iV.and(MASK_7).lanewise(VectorOperators.LSHL, 3).or(oV);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 48);
    oV = iV.and(MASK_7).lanewise(VectorOperators.LSHL, 10).or(oV);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 56);
    oV = iV.and(MASK_7).lanewise(VectorOperators.LSHL, 17).or(oV);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 64);
    oV = iV.and(MASK_7).lanewise(VectorOperators.LSHL, 24).or(oV);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 72);
    oV = iV.and(MASK_7).lanewise(VectorOperators.LSHL, 31).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.and(MASK_7).lanewise(VectorOperators.LSHR, 1);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 80);
    oV = iV.and(MASK_7).lanewise(VectorOperators.LSHL, 6).or(oV);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 88);
    oV = iV.and(MASK_7).lanewise(VectorOperators.LSHL, 13).or(oV);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 96);
    oV = iV.and(MASK_7).lanewise(VectorOperators.LSHL, 20).or(oV);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 104);
    oV = iV.and(MASK_7).lanewise(VectorOperators.LSHL, 27).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.and(MASK_7).lanewise(VectorOperators.LSHR, 5);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 112);
    oV = iV.and(MASK_7).lanewise(VectorOperators.LSHL, 2).or(oV);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 120);
    oV = iV.and(MASK_7).lanewise(VectorOperators.LSHL, 9).or(oV);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 128);
    oV = iV.and(MASK_7).lanewise(VectorOperators.LSHL, 16).or(oV);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 136);
    oV = iV.and(MASK_7).lanewise(VectorOperators.LSHL, 23).or(oV);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 144);
    oV = iV.and(MASK_7).lanewise(VectorOperators.LSHL, 30).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.and(MASK_7).lanewise(VectorOperators.LSHR, 2);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 152);
    oV = iV.and(MASK_7).lanewise(VectorOperators.LSHL, 5).or(oV);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 160);
    oV = iV.and(MASK_7).lanewise(VectorOperators.LSHL, 12).or(oV);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 168);
    oV = iV.and(MASK_7).lanewise(VectorOperators.LSHL, 19).or(oV);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 176);
    oV = iV.and(MASK_7).lanewise(VectorOperators.LSHL, 26).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.and(MASK_7).lanewise(VectorOperators.LSHR, 6);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 184);
    oV = iV.and(MASK_7).lanewise(VectorOperators.LSHL, 1).or(oV);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 192);
    oV = iV.and(MASK_7).lanewise(VectorOperators.LSHL, 8).or(oV);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 200);
    oV = iV.and(MASK_7).lanewise(VectorOperators.LSHL, 15).or(oV);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 208);
    oV = iV.and(MASK_7).lanewise(VectorOperators.LSHL, 22).or(oV);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 216);
    oV = iV.and(MASK_7).lanewise(VectorOperators.LSHL, 29).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.and(MASK_7).lanewise(VectorOperators.LSHR, 3);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 224);
    oV = iV.and(MASK_7).lanewise(VectorOperators.LSHL, 4).or(oV);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 232);
    oV = iV.and(MASK_7).lanewise(VectorOperators.LSHL, 11).or(oV);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 240);
    oV = iV.and(MASK_7).lanewise(VectorOperators.LSHL, 18).or(oV);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 248);
    oV = iV.and(MASK_7).lanewise(VectorOperators.LSHL, 25).or(oV);

    oV.intoArray(out, outpos);
  }

  private static void fastpack8(final int[] in, int inpos, final int[] out,
                                int outpos) {
    var iV = IntVector.fromArray(SPECIES_512, in, inpos);
    var oV = iV.and(MASK_8);
    iV = IntVector.fromArray(SPECIES_512, in, inpos + 16);
    oV = iV.and(MASK_8).lanewise(VectorOperators.LSHL, 8).or(oV);

    iV = IntVector.fromArray(SPECIES_512, in, inpos + 32);
    oV = iV.and(MASK_8).lanewise(VectorOperators.LSHL, 16).or(oV);

    iV = IntVector.fromArray(SPECIES_512, in, inpos + 48);
    oV = iV.and(MASK_8).lanewise(VectorOperators.LSHL, 24).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_512;
    oV = oV.zero(SPECIES_512);

    iV = IntVector.fromArray(SPECIES_512, in, inpos + 64);
    oV = iV.and(MASK_8).or(oV);

    iV = IntVector.fromArray(SPECIES_512, in, inpos + 80);
    oV = iV.and(MASK_8).lanewise(VectorOperators.LSHL, 8).or(oV);

    iV = IntVector.fromArray(SPECIES_512, in, inpos + 96);
    oV = iV.and(MASK_8).lanewise(VectorOperators.LSHL, 16).or(oV);

    iV = IntVector.fromArray(SPECIES_512, in, inpos + 112);
    oV = iV.and(MASK_8).lanewise(VectorOperators.LSHL, 24).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_512;

    oV = oV.zero(SPECIES_512);

    iV = IntVector.fromArray(SPECIES_512, in, inpos + 128);
    oV = iV.and(MASK_8).or(oV);

    iV = IntVector.fromArray(SPECIES_512, in, inpos + 144);
    oV = iV.and(MASK_8).lanewise(VectorOperators.LSHL, 8).or(oV);

    iV = IntVector.fromArray(SPECIES_512, in, inpos + 160);
    oV = iV.and(MASK_8).lanewise(VectorOperators.LSHL, 16).or(oV);

    iV = IntVector.fromArray(SPECIES_512, in, inpos + 176);
    oV = iV.and(MASK_8).lanewise(VectorOperators.LSHL, 24).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_512;

    oV = oV.zero(SPECIES_512);

    iV = IntVector.fromArray(SPECIES_512, in, inpos + 192);
    oV = iV.and(MASK_8).or(oV);

    iV = IntVector.fromArray(SPECIES_512, in, inpos + 208);
    oV = iV.and(MASK_8).lanewise(VectorOperators.LSHL, 8).or(oV);

    iV = IntVector.fromArray(SPECIES_512, in, inpos + 224);
    oV = iV.and(MASK_8).lanewise(VectorOperators.LSHL, 16).or(oV);

    iV = IntVector.fromArray(SPECIES_512, in, inpos + 240);
    oV = iV.and(MASK_8).lanewise(VectorOperators.LSHL, 24).or(oV);

    oV.intoArray(out, outpos);
  }

  private static void fastpack9(final int[] in, int inpos, final int[] out,
                                int outpos) {
    var iV = IntVector.fromArray(SPECIES_256, in, inpos);
    var oV = iV.and(MASK_9);
    iV = IntVector.fromArray(SPECIES_256, in, inpos + 8);
    oV = iV.and(MASK_9).lanewise(VectorOperators.LSHL, 9).or(oV);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 16);
    oV = iV.and(MASK_9).lanewise(VectorOperators.LSHL, 18).or(oV);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 24);
    oV = iV.and(MASK_9).lanewise(VectorOperators.LSHL, 27).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.and(MASK_9).lanewise(VectorOperators.LSHR, 5);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 32);
    oV = iV.and(MASK_9).lanewise(VectorOperators.LSHL, 4).or(oV);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 40);
    oV = iV.and(MASK_9).lanewise(VectorOperators.LSHL, 13).or(oV);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 48);
    oV = iV.and(MASK_9).lanewise(VectorOperators.LSHL, 22).or(oV);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 56);
    oV = iV.and(MASK_9).lanewise(VectorOperators.LSHL, 31).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.and(MASK_9).lanewise(VectorOperators.LSHR, 1);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 64);
    oV = iV.and(MASK_9).lanewise(VectorOperators.LSHL, 8).or(oV);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 72);
    oV = iV.and(MASK_9).lanewise(VectorOperators.LSHL, 17).or(oV);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 80);
    oV = iV.and(MASK_9).lanewise(VectorOperators.LSHL, 26).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.and(MASK_9).lanewise(VectorOperators.LSHR, 6);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 88);
    oV = iV.and(MASK_9).lanewise(VectorOperators.LSHL, 3).or(oV);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 96);
    oV = iV.and(MASK_9).lanewise(VectorOperators.LSHL, 12).or(oV);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 104);
    oV = iV.and(MASK_9).lanewise(VectorOperators.LSHL, 21).or(oV);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 112);
    oV = iV.and(MASK_9).lanewise(VectorOperators.LSHL, 30).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.and(MASK_9).lanewise(VectorOperators.LSHR, 2);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 120);
    oV = iV.and(MASK_9).lanewise(VectorOperators.LSHL, 7).or(oV);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 128);
    oV = iV.and(MASK_9).lanewise(VectorOperators.LSHL, 16).or(oV);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 136);
    oV = iV.and(MASK_9).lanewise(VectorOperators.LSHL, 25).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.and(MASK_9).lanewise(VectorOperators.LSHR, 7);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 144);
    oV = iV.and(MASK_9).lanewise(VectorOperators.LSHL, 2).or(oV);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 152);
    oV = iV.and(MASK_9).lanewise(VectorOperators.LSHL, 11).or(oV);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 160);
    oV = iV.and(MASK_9).lanewise(VectorOperators.LSHL, 20).or(oV);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 168);
    oV = iV.and(MASK_9).lanewise(VectorOperators.LSHL, 29).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.and(MASK_9).lanewise(VectorOperators.LSHR, 3);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 176);
    oV = iV.and(MASK_9).lanewise(VectorOperators.LSHL, 6).or(oV);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 184);
    oV = iV.and(MASK_9).lanewise(VectorOperators.LSHL, 15).or(oV);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 192);
    oV = iV.and(MASK_9).lanewise(VectorOperators.LSHL, 24).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.and(MASK_9).lanewise(VectorOperators.LSHR, 8);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 200);
    oV = iV.and(MASK_9).lanewise(VectorOperators.LSHL, 1).or(oV);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 208);
    oV = iV.and(MASK_9).lanewise(VectorOperators.LSHL, 10).or(oV);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 216);
    oV = iV.and(MASK_9).lanewise(VectorOperators.LSHL, 19).or(oV);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 224);
    oV = iV.and(MASK_9).lanewise(VectorOperators.LSHL, 28).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.and(MASK_9).lanewise(VectorOperators.LSHR, 4);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 232);
    oV = iV.and(MASK_9).lanewise(VectorOperators.LSHL, 5).or(oV);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 240);
    oV = iV.and(MASK_9).lanewise(VectorOperators.LSHL, 14).or(oV);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 248);
    oV = iV.and(MASK_9).lanewise(VectorOperators.LSHL, 23).or(oV);

    oV.intoArray(out, outpos);
  }

  private static void fastpack10(final int[] in, int inpos, final int[] out,
                                 int outpos) {
    var iV = IntVector.fromArray(SPECIES_512, in, inpos);
    var oV = iV.and(MASK_10);
    iV = IntVector.fromArray(SPECIES_512, in, inpos + 16);
    oV = iV.and(MASK_10).lanewise(VectorOperators.LSHL, 10).or(oV);

    iV = IntVector.fromArray(SPECIES_512, in, inpos + 32);
    oV = iV.and(MASK_10).lanewise(VectorOperators.LSHL, 20).or(oV);

    iV = IntVector.fromArray(SPECIES_512, in, inpos + 48);
    oV = iV.and(MASK_10).lanewise(VectorOperators.LSHL, 30).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_512;
    oV = iV.and(MASK_10).lanewise(VectorOperators.LSHR, 2);

    iV = IntVector.fromArray(SPECIES_512, in, inpos + 64);
    oV = iV.and(MASK_10).lanewise(VectorOperators.LSHL, 8).or(oV);

    iV = IntVector.fromArray(SPECIES_512, in, inpos + 80);
    oV = iV.and(MASK_10).lanewise(VectorOperators.LSHL, 18).or(oV);

    iV = IntVector.fromArray(SPECIES_512, in, inpos + 96);
    oV = iV.and(MASK_10).lanewise(VectorOperators.LSHL, 28).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_512;

    oV = iV.and(MASK_10).lanewise(VectorOperators.LSHR, 4);

    iV = IntVector.fromArray(SPECIES_512, in, inpos + 112);
    oV = iV.and(MASK_10).lanewise(VectorOperators.LSHL, 6).or(oV);

    iV = IntVector.fromArray(SPECIES_512, in, inpos + 128);
    oV = iV.and(MASK_10).lanewise(VectorOperators.LSHL, 16).or(oV);

    iV = IntVector.fromArray(SPECIES_512, in, inpos + 144);
    oV = iV.and(MASK_10).lanewise(VectorOperators.LSHL, 26).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_512;

    oV = iV.and(MASK_10).lanewise(VectorOperators.LSHR, 6);

    iV = IntVector.fromArray(SPECIES_512, in, inpos + 160);
    oV = iV.and(MASK_10).lanewise(VectorOperators.LSHL, 4).or(oV);

    iV = IntVector.fromArray(SPECIES_512, in, inpos + 176);
    oV = iV.and(MASK_10).lanewise(VectorOperators.LSHL, 14).or(oV);

    iV = IntVector.fromArray(SPECIES_512, in, inpos + 192);
    oV = iV.and(MASK_10).lanewise(VectorOperators.LSHL, 24).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_512;

    oV = iV.and(MASK_10).lanewise(VectorOperators.LSHR, 8);

    iV = IntVector.fromArray(SPECIES_512, in, inpos + 208);
    oV = iV.and(MASK_10).lanewise(VectorOperators.LSHL, 2).or(oV);

    iV = IntVector.fromArray(SPECIES_512, in, inpos + 224);
    oV = iV.and(MASK_10).lanewise(VectorOperators.LSHL, 12).or(oV);

    iV = IntVector.fromArray(SPECIES_512, in, inpos + 240);
    oV = iV.and(MASK_10).lanewise(VectorOperators.LSHL, 22).or(oV);

    oV.intoArray(out, outpos);
  }

  private static void fastpack11(final int[] in, int inpos, final int[] out,
                                 int outpos) {
    var iV = IntVector.fromArray(SPECIES_256, in, inpos);
    var oV = iV.and(MASK_11);
    iV = IntVector.fromArray(SPECIES_256, in, inpos + 8);
    oV = iV.and(MASK_11).lanewise(VectorOperators.LSHL, 11).or(oV);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 16);
    oV = iV.and(MASK_11).lanewise(VectorOperators.LSHL, 22).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.and(MASK_11).lanewise(VectorOperators.LSHR, 10);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 24);
    oV = iV.and(MASK_11).lanewise(VectorOperators.LSHL, 1).or(oV);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 32);
    oV = iV.and(MASK_11).lanewise(VectorOperators.LSHL, 12).or(oV);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 40);
    oV = iV.and(MASK_11).lanewise(VectorOperators.LSHL, 23).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.and(MASK_11).lanewise(VectorOperators.LSHR, 9);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 48);
    oV = iV.and(MASK_11).lanewise(VectorOperators.LSHL, 2).or(oV);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 56);
    oV = iV.and(MASK_11).lanewise(VectorOperators.LSHL, 13).or(oV);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 64);
    oV = iV.and(MASK_11).lanewise(VectorOperators.LSHL, 24).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.and(MASK_11).lanewise(VectorOperators.LSHR, 8);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 72);
    oV = iV.and(MASK_11).lanewise(VectorOperators.LSHL, 3).or(oV);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 80);
    oV = iV.and(MASK_11).lanewise(VectorOperators.LSHL, 14).or(oV);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 88);
    oV = iV.and(MASK_11).lanewise(VectorOperators.LSHL, 25).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.and(MASK_11).lanewise(VectorOperators.LSHR, 7);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 96);
    oV = iV.and(MASK_11).lanewise(VectorOperators.LSHL, 4).or(oV);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 104);
    oV = iV.and(MASK_11).lanewise(VectorOperators.LSHL, 15).or(oV);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 112);
    oV = iV.and(MASK_11).lanewise(VectorOperators.LSHL, 26).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.and(MASK_11).lanewise(VectorOperators.LSHR, 6);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 120);
    oV = iV.and(MASK_11).lanewise(VectorOperators.LSHL, 5).or(oV);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 128);
    oV = iV.and(MASK_11).lanewise(VectorOperators.LSHL, 16).or(oV);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 136);
    oV = iV.and(MASK_11).lanewise(VectorOperators.LSHL, 27).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.and(MASK_11).lanewise(VectorOperators.LSHR, 5);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 144);
    oV = iV.and(MASK_11).lanewise(VectorOperators.LSHL, 6).or(oV);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 152);
    oV = iV.and(MASK_11).lanewise(VectorOperators.LSHL, 17).or(oV);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 160);
    oV = iV.and(MASK_11).lanewise(VectorOperators.LSHL, 28).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.and(MASK_11).lanewise(VectorOperators.LSHR, 4);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 168);
    oV = iV.and(MASK_11).lanewise(VectorOperators.LSHL, 7).or(oV);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 176);
    oV = iV.and(MASK_11).lanewise(VectorOperators.LSHL, 18).or(oV);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 184);
    oV = iV.and(MASK_11).lanewise(VectorOperators.LSHL, 29).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.and(MASK_11).lanewise(VectorOperators.LSHR, 3);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 192);
    oV = iV.and(MASK_11).lanewise(VectorOperators.LSHL, 8).or(oV);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 200);
    oV = iV.and(MASK_11).lanewise(VectorOperators.LSHL, 19).or(oV);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 208);
    oV = iV.and(MASK_11).lanewise(VectorOperators.LSHL, 30).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.and(MASK_11).lanewise(VectorOperators.LSHR, 2);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 216);
    oV = iV.and(MASK_11).lanewise(VectorOperators.LSHL, 9).or(oV);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 224);
    oV = iV.and(MASK_11).lanewise(VectorOperators.LSHL, 20).or(oV);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 232);
    oV = iV.and(MASK_11).lanewise(VectorOperators.LSHL, 31).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.and(MASK_11).lanewise(VectorOperators.LSHR, 1);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 240);
    oV = iV.and(MASK_11).lanewise(VectorOperators.LSHL, 10).or(oV);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 248);
    oV = iV.and(MASK_11).lanewise(VectorOperators.LSHL, 21).or(oV);

    oV.intoArray(out, outpos);
  }

  private static void fastpack12(final int[] in, int inpos, final int[] out,
                                 int outpos) {
    var iV = IntVector.fromArray(SPECIES_512, in, inpos);
    var oV = iV.and(MASK_12);
    iV = IntVector.fromArray(SPECIES_512, in, inpos + 16);
    oV = iV.and(MASK_12).lanewise(VectorOperators.LSHL, 12).or(oV);

    iV = IntVector.fromArray(SPECIES_512, in, inpos + 32);
    oV = iV.and(MASK_12).lanewise(VectorOperators.LSHL, 24).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_512;
    oV = iV.and(MASK_12).lanewise(VectorOperators.LSHR, 8);

    iV = IntVector.fromArray(SPECIES_512, in, inpos + 48);
    oV = iV.and(MASK_12).lanewise(VectorOperators.LSHL, 4).or(oV);

    iV = IntVector.fromArray(SPECIES_512, in, inpos + 64);
    oV = iV.and(MASK_12).lanewise(VectorOperators.LSHL, 16).or(oV);

    iV = IntVector.fromArray(SPECIES_512, in, inpos + 80);
    oV = iV.and(MASK_12).lanewise(VectorOperators.LSHL, 28).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_512;

    oV = iV.and(MASK_12).lanewise(VectorOperators.LSHR, 4);

    iV = IntVector.fromArray(SPECIES_512, in, inpos + 96);
    oV = iV.and(MASK_12).lanewise(VectorOperators.LSHL, 8).or(oV);

    iV = IntVector.fromArray(SPECIES_512, in, inpos + 112);
    oV = iV.and(MASK_12).lanewise(VectorOperators.LSHL, 20).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_512;

    oV = oV.zero(SPECIES_512);

    iV = IntVector.fromArray(SPECIES_512, in, inpos + 128);
    oV = iV.and(MASK_12).or(oV);

    iV = IntVector.fromArray(SPECIES_512, in, inpos + 144);
    oV = iV.and(MASK_12).lanewise(VectorOperators.LSHL, 12).or(oV);

    iV = IntVector.fromArray(SPECIES_512, in, inpos + 160);
    oV = iV.and(MASK_12).lanewise(VectorOperators.LSHL, 24).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_512;

    oV = iV.and(MASK_12).lanewise(VectorOperators.LSHR, 8);

    iV = IntVector.fromArray(SPECIES_512, in, inpos + 176);
    oV = iV.and(MASK_12).lanewise(VectorOperators.LSHL, 4).or(oV);

    iV = IntVector.fromArray(SPECIES_512, in, inpos + 192);
    oV = iV.and(MASK_12).lanewise(VectorOperators.LSHL, 16).or(oV);

    iV = IntVector.fromArray(SPECIES_512, in, inpos + 208);
    oV = iV.and(MASK_12).lanewise(VectorOperators.LSHL, 28).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_512;

    oV = iV.and(MASK_12).lanewise(VectorOperators.LSHR, 4);

    iV = IntVector.fromArray(SPECIES_512, in, inpos + 224);
    oV = iV.and(MASK_12).lanewise(VectorOperators.LSHL, 8).or(oV);

    iV = IntVector.fromArray(SPECIES_512, in, inpos + 240);
    oV = iV.and(MASK_12).lanewise(VectorOperators.LSHL, 20).or(oV);

    oV.intoArray(out, outpos);
  }

  private static void fastpack13(final int[] in, int inpos, final int[] out,
                                 int outpos) {
    var iV = IntVector.fromArray(SPECIES_256, in, inpos);
    var oV = iV.and(MASK_13);
    iV = IntVector.fromArray(SPECIES_256, in, inpos + 8);
    oV = iV.and(MASK_13).lanewise(VectorOperators.LSHL, 13).or(oV);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 16);
    oV = iV.and(MASK_13).lanewise(VectorOperators.LSHL, 26).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.and(MASK_13).lanewise(VectorOperators.LSHR, 6);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 24);
    oV = iV.and(MASK_13).lanewise(VectorOperators.LSHL, 7).or(oV);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 32);
    oV = iV.and(MASK_13).lanewise(VectorOperators.LSHL, 20).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.and(MASK_13).lanewise(VectorOperators.LSHR, 12);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 40);
    oV = iV.and(MASK_13).lanewise(VectorOperators.LSHL, 1).or(oV);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 48);
    oV = iV.and(MASK_13).lanewise(VectorOperators.LSHL, 14).or(oV);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 56);
    oV = iV.and(MASK_13).lanewise(VectorOperators.LSHL, 27).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.and(MASK_13).lanewise(VectorOperators.LSHR, 5);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 64);
    oV = iV.and(MASK_13).lanewise(VectorOperators.LSHL, 8).or(oV);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 72);
    oV = iV.and(MASK_13).lanewise(VectorOperators.LSHL, 21).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.and(MASK_13).lanewise(VectorOperators.LSHR, 11);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 80);
    oV = iV.and(MASK_13).lanewise(VectorOperators.LSHL, 2).or(oV);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 88);
    oV = iV.and(MASK_13).lanewise(VectorOperators.LSHL, 15).or(oV);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 96);
    oV = iV.and(MASK_13).lanewise(VectorOperators.LSHL, 28).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.and(MASK_13).lanewise(VectorOperators.LSHR, 4);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 104);
    oV = iV.and(MASK_13).lanewise(VectorOperators.LSHL, 9).or(oV);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 112);
    oV = iV.and(MASK_13).lanewise(VectorOperators.LSHL, 22).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.and(MASK_13).lanewise(VectorOperators.LSHR, 10);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 120);
    oV = iV.and(MASK_13).lanewise(VectorOperators.LSHL, 3).or(oV);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 128);
    oV = iV.and(MASK_13).lanewise(VectorOperators.LSHL, 16).or(oV);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 136);
    oV = iV.and(MASK_13).lanewise(VectorOperators.LSHL, 29).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.and(MASK_13).lanewise(VectorOperators.LSHR, 3);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 144);
    oV = iV.and(MASK_13).lanewise(VectorOperators.LSHL, 10).or(oV);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 152);
    oV = iV.and(MASK_13).lanewise(VectorOperators.LSHL, 23).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.and(MASK_13).lanewise(VectorOperators.LSHR, 9);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 160);
    oV = iV.and(MASK_13).lanewise(VectorOperators.LSHL, 4).or(oV);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 168);
    oV = iV.and(MASK_13).lanewise(VectorOperators.LSHL, 17).or(oV);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 176);
    oV = iV.and(MASK_13).lanewise(VectorOperators.LSHL, 30).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.and(MASK_13).lanewise(VectorOperators.LSHR, 2);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 184);
    oV = iV.and(MASK_13).lanewise(VectorOperators.LSHL, 11).or(oV);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 192);
    oV = iV.and(MASK_13).lanewise(VectorOperators.LSHL, 24).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.and(MASK_13).lanewise(VectorOperators.LSHR, 8);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 200);
    oV = iV.and(MASK_13).lanewise(VectorOperators.LSHL, 5).or(oV);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 208);
    oV = iV.and(MASK_13).lanewise(VectorOperators.LSHL, 18).or(oV);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 216);
    oV = iV.and(MASK_13).lanewise(VectorOperators.LSHL, 31).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.and(MASK_13).lanewise(VectorOperators.LSHR, 1);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 224);
    oV = iV.and(MASK_13).lanewise(VectorOperators.LSHL, 12).or(oV);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 232);
    oV = iV.and(MASK_13).lanewise(VectorOperators.LSHL, 25).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.and(MASK_13).lanewise(VectorOperators.LSHR, 7);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 240);
    oV = iV.and(MASK_13).lanewise(VectorOperators.LSHL, 6).or(oV);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 248);
    oV = iV.and(MASK_13).lanewise(VectorOperators.LSHL, 19).or(oV);

    oV.intoArray(out, outpos);
  }

  private static void fastpack14(final int[] in, int inpos, final int[] out,
                                 int outpos) {
    var iV = IntVector.fromArray(SPECIES_512, in, inpos);
    var oV = iV.and(MASK_14);
    iV = IntVector.fromArray(SPECIES_512, in, inpos + 16);
    oV = iV.and(MASK_14).lanewise(VectorOperators.LSHL, 14).or(oV);

    iV = IntVector.fromArray(SPECIES_512, in, inpos + 32);
    oV = iV.and(MASK_14).lanewise(VectorOperators.LSHL, 28).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_512;
    oV = iV.and(MASK_14).lanewise(VectorOperators.LSHR, 4);

    iV = IntVector.fromArray(SPECIES_512, in, inpos + 48);
    oV = iV.and(MASK_14).lanewise(VectorOperators.LSHL, 10).or(oV);

    iV = IntVector.fromArray(SPECIES_512, in, inpos + 64);
    oV = iV.and(MASK_14).lanewise(VectorOperators.LSHL, 24).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_512;

    oV = iV.and(MASK_14).lanewise(VectorOperators.LSHR, 8);

    iV = IntVector.fromArray(SPECIES_512, in, inpos + 80);
    oV = iV.and(MASK_14).lanewise(VectorOperators.LSHL, 6).or(oV);

    iV = IntVector.fromArray(SPECIES_512, in, inpos + 96);
    oV = iV.and(MASK_14).lanewise(VectorOperators.LSHL, 20).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_512;

    oV = iV.and(MASK_14).lanewise(VectorOperators.LSHR, 12);

    iV = IntVector.fromArray(SPECIES_512, in, inpos + 112);
    oV = iV.and(MASK_14).lanewise(VectorOperators.LSHL, 2).or(oV);

    iV = IntVector.fromArray(SPECIES_512, in, inpos + 128);
    oV = iV.and(MASK_14).lanewise(VectorOperators.LSHL, 16).or(oV);

    iV = IntVector.fromArray(SPECIES_512, in, inpos + 144);
    oV = iV.and(MASK_14).lanewise(VectorOperators.LSHL, 30).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_512;

    oV = iV.and(MASK_14).lanewise(VectorOperators.LSHR, 2);

    iV = IntVector.fromArray(SPECIES_512, in, inpos + 160);
    oV = iV.and(MASK_14).lanewise(VectorOperators.LSHL, 12).or(oV);

    iV = IntVector.fromArray(SPECIES_512, in, inpos + 176);
    oV = iV.and(MASK_14).lanewise(VectorOperators.LSHL, 26).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_512;

    oV = iV.and(MASK_14).lanewise(VectorOperators.LSHR, 6);

    iV = IntVector.fromArray(SPECIES_512, in, inpos + 192);
    oV = iV.and(MASK_14).lanewise(VectorOperators.LSHL, 8).or(oV);

    iV = IntVector.fromArray(SPECIES_512, in, inpos + 208);
    oV = iV.and(MASK_14).lanewise(VectorOperators.LSHL, 22).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_512;

    oV = iV.and(MASK_14).lanewise(VectorOperators.LSHR, 10);

    iV = IntVector.fromArray(SPECIES_512, in, inpos + 224);
    oV = iV.and(MASK_14).lanewise(VectorOperators.LSHL, 4).or(oV);

    iV = IntVector.fromArray(SPECIES_512, in, inpos + 240);
    oV = iV.and(MASK_14).lanewise(VectorOperators.LSHL, 18).or(oV);

    oV.intoArray(out, outpos);
  }

  private static void fastpack15(final int[] in, int inpos, final int[] out,
                                 int outpos) {
    var iV = IntVector.fromArray(SPECIES_256, in, inpos);
    var oV = iV.and(MASK_15);
    iV = IntVector.fromArray(SPECIES_256, in, inpos + 8);
    oV = iV.and(MASK_15).lanewise(VectorOperators.LSHL, 15).or(oV);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 16);
    oV = iV.and(MASK_15).lanewise(VectorOperators.LSHL, 30).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.and(MASK_15).lanewise(VectorOperators.LSHR, 2);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 24);
    oV = iV.and(MASK_15).lanewise(VectorOperators.LSHL, 13).or(oV);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 32);
    oV = iV.and(MASK_15).lanewise(VectorOperators.LSHL, 28).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.and(MASK_15).lanewise(VectorOperators.LSHR, 4);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 40);
    oV = iV.and(MASK_15).lanewise(VectorOperators.LSHL, 11).or(oV);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 48);
    oV = iV.and(MASK_15).lanewise(VectorOperators.LSHL, 26).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.and(MASK_15).lanewise(VectorOperators.LSHR, 6);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 56);
    oV = iV.and(MASK_15).lanewise(VectorOperators.LSHL, 9).or(oV);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 64);
    oV = iV.and(MASK_15).lanewise(VectorOperators.LSHL, 24).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.and(MASK_15).lanewise(VectorOperators.LSHR, 8);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 72);
    oV = iV.and(MASK_15).lanewise(VectorOperators.LSHL, 7).or(oV);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 80);
    oV = iV.and(MASK_15).lanewise(VectorOperators.LSHL, 22).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.and(MASK_15).lanewise(VectorOperators.LSHR, 10);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 88);
    oV = iV.and(MASK_15).lanewise(VectorOperators.LSHL, 5).or(oV);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 96);
    oV = iV.and(MASK_15).lanewise(VectorOperators.LSHL, 20).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.and(MASK_15).lanewise(VectorOperators.LSHR, 12);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 104);
    oV = iV.and(MASK_15).lanewise(VectorOperators.LSHL, 3).or(oV);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 112);
    oV = iV.and(MASK_15).lanewise(VectorOperators.LSHL, 18).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.and(MASK_15).lanewise(VectorOperators.LSHR, 14);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 120);
    oV = iV.and(MASK_15).lanewise(VectorOperators.LSHL, 1).or(oV);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 128);
    oV = iV.and(MASK_15).lanewise(VectorOperators.LSHL, 16).or(oV);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 136);
    oV = iV.and(MASK_15).lanewise(VectorOperators.LSHL, 31).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.and(MASK_15).lanewise(VectorOperators.LSHR, 1);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 144);
    oV = iV.and(MASK_15).lanewise(VectorOperators.LSHL, 14).or(oV);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 152);
    oV = iV.and(MASK_15).lanewise(VectorOperators.LSHL, 29).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.and(MASK_15).lanewise(VectorOperators.LSHR, 3);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 160);
    oV = iV.and(MASK_15).lanewise(VectorOperators.LSHL, 12).or(oV);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 168);
    oV = iV.and(MASK_15).lanewise(VectorOperators.LSHL, 27).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.and(MASK_15).lanewise(VectorOperators.LSHR, 5);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 176);
    oV = iV.and(MASK_15).lanewise(VectorOperators.LSHL, 10).or(oV);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 184);
    oV = iV.and(MASK_15).lanewise(VectorOperators.LSHL, 25).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.and(MASK_15).lanewise(VectorOperators.LSHR, 7);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 192);
    oV = iV.and(MASK_15).lanewise(VectorOperators.LSHL, 8).or(oV);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 200);
    oV = iV.and(MASK_15).lanewise(VectorOperators.LSHL, 23).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.and(MASK_15).lanewise(VectorOperators.LSHR, 9);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 208);
    oV = iV.and(MASK_15).lanewise(VectorOperators.LSHL, 6).or(oV);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 216);
    oV = iV.and(MASK_15).lanewise(VectorOperators.LSHL, 21).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.and(MASK_15).lanewise(VectorOperators.LSHR, 11);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 224);
    oV = iV.and(MASK_15).lanewise(VectorOperators.LSHL, 4).or(oV);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 232);
    oV = iV.and(MASK_15).lanewise(VectorOperators.LSHL, 19).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.and(MASK_15).lanewise(VectorOperators.LSHR, 13);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 240);
    oV = iV.and(MASK_15).lanewise(VectorOperators.LSHL, 2).or(oV);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 248);
    oV = iV.and(MASK_15).lanewise(VectorOperators.LSHL, 17).or(oV);

    oV.intoArray(out, outpos);
  }

  private static void fastpack16(final int[] in, int inpos, final int[] out,
                                 int outpos) {
    var iV = IntVector.fromArray(SPECIES_512, in, inpos);
    var oV = iV.and(MASK_16);
    iV = IntVector.fromArray(SPECIES_512, in, inpos + 16);
    oV = iV.and(MASK_16).lanewise(VectorOperators.LSHL, 16).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_512;
    oV = oV.zero(SPECIES_512);

    iV = IntVector.fromArray(SPECIES_512, in, inpos + 32);
    oV = iV.and(MASK_16).or(oV);

    iV = IntVector.fromArray(SPECIES_512, in, inpos + 48);
    oV = iV.and(MASK_16).lanewise(VectorOperators.LSHL, 16).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_512;

    oV = oV.zero(SPECIES_512);

    iV = IntVector.fromArray(SPECIES_512, in, inpos + 64);
    oV = iV.and(MASK_16).or(oV);

    iV = IntVector.fromArray(SPECIES_512, in, inpos + 80);
    oV = iV.and(MASK_16).lanewise(VectorOperators.LSHL, 16).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_512;

    oV = oV.zero(SPECIES_512);

    iV = IntVector.fromArray(SPECIES_512, in, inpos + 96);
    oV = iV.and(MASK_16).or(oV);

    iV = IntVector.fromArray(SPECIES_512, in, inpos + 112);
    oV = iV.and(MASK_16).lanewise(VectorOperators.LSHL, 16).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_512;

    oV = oV.zero(SPECIES_512);

    iV = IntVector.fromArray(SPECIES_512, in, inpos + 128);
    oV = iV.and(MASK_16).or(oV);

    iV = IntVector.fromArray(SPECIES_512, in, inpos + 144);
    oV = iV.and(MASK_16).lanewise(VectorOperators.LSHL, 16).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_512;

    oV = oV.zero(SPECIES_512);

    iV = IntVector.fromArray(SPECIES_512, in, inpos + 160);
    oV = iV.and(MASK_16).or(oV);

    iV = IntVector.fromArray(SPECIES_512, in, inpos + 176);
    oV = iV.and(MASK_16).lanewise(VectorOperators.LSHL, 16).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_512;

    oV = oV.zero(SPECIES_512);

    iV = IntVector.fromArray(SPECIES_512, in, inpos + 192);
    oV = iV.and(MASK_16).or(oV);

    iV = IntVector.fromArray(SPECIES_512, in, inpos + 208);
    oV = iV.and(MASK_16).lanewise(VectorOperators.LSHL, 16).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_512;

    oV = oV.zero(SPECIES_512);

    iV = IntVector.fromArray(SPECIES_512, in, inpos + 224);
    oV = iV.and(MASK_16).or(oV);

    iV = IntVector.fromArray(SPECIES_512, in, inpos + 240);
    oV = iV.and(MASK_16).lanewise(VectorOperators.LSHL, 16).or(oV);

    oV.intoArray(out, outpos);
  }

  private static void fastpack17(final int[] in, int inpos, final int[] out,
                                 int outpos) {
    var iV = IntVector.fromArray(SPECIES_256, in, inpos);
    var oV = iV.and(MASK_17);
    iV = IntVector.fromArray(SPECIES_256, in, inpos + 8);
    oV = iV.and(MASK_17).lanewise(VectorOperators.LSHL, 17).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.and(MASK_17).lanewise(VectorOperators.LSHR, 15);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 16);
    oV = iV.and(MASK_17).lanewise(VectorOperators.LSHL, 2).or(oV);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 24);
    oV = iV.and(MASK_17).lanewise(VectorOperators.LSHL, 19).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.and(MASK_17).lanewise(VectorOperators.LSHR, 13);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 32);
    oV = iV.and(MASK_17).lanewise(VectorOperators.LSHL, 4).or(oV);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 40);
    oV = iV.and(MASK_17).lanewise(VectorOperators.LSHL, 21).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.and(MASK_17).lanewise(VectorOperators.LSHR, 11);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 48);
    oV = iV.and(MASK_17).lanewise(VectorOperators.LSHL, 6).or(oV);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 56);
    oV = iV.and(MASK_17).lanewise(VectorOperators.LSHL, 23).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.and(MASK_17).lanewise(VectorOperators.LSHR, 9);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 64);
    oV = iV.and(MASK_17).lanewise(VectorOperators.LSHL, 8).or(oV);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 72);
    oV = iV.and(MASK_17).lanewise(VectorOperators.LSHL, 25).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.and(MASK_17).lanewise(VectorOperators.LSHR, 7);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 80);
    oV = iV.and(MASK_17).lanewise(VectorOperators.LSHL, 10).or(oV);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 88);
    oV = iV.and(MASK_17).lanewise(VectorOperators.LSHL, 27).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.and(MASK_17).lanewise(VectorOperators.LSHR, 5);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 96);
    oV = iV.and(MASK_17).lanewise(VectorOperators.LSHL, 12).or(oV);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 104);
    oV = iV.and(MASK_17).lanewise(VectorOperators.LSHL, 29).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.and(MASK_17).lanewise(VectorOperators.LSHR, 3);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 112);
    oV = iV.and(MASK_17).lanewise(VectorOperators.LSHL, 14).or(oV);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 120);
    oV = iV.and(MASK_17).lanewise(VectorOperators.LSHL, 31).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.and(MASK_17).lanewise(VectorOperators.LSHR, 1);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 128);
    oV = iV.and(MASK_17).lanewise(VectorOperators.LSHL, 16).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.and(MASK_17).lanewise(VectorOperators.LSHR, 16);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 136);
    oV = iV.and(MASK_17).lanewise(VectorOperators.LSHL, 1).or(oV);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 144);
    oV = iV.and(MASK_17).lanewise(VectorOperators.LSHL, 18).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.and(MASK_17).lanewise(VectorOperators.LSHR, 14);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 152);
    oV = iV.and(MASK_17).lanewise(VectorOperators.LSHL, 3).or(oV);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 160);
    oV = iV.and(MASK_17).lanewise(VectorOperators.LSHL, 20).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.and(MASK_17).lanewise(VectorOperators.LSHR, 12);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 168);
    oV = iV.and(MASK_17).lanewise(VectorOperators.LSHL, 5).or(oV);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 176);
    oV = iV.and(MASK_17).lanewise(VectorOperators.LSHL, 22).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.and(MASK_17).lanewise(VectorOperators.LSHR, 10);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 184);
    oV = iV.and(MASK_17).lanewise(VectorOperators.LSHL, 7).or(oV);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 192);
    oV = iV.and(MASK_17).lanewise(VectorOperators.LSHL, 24).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.and(MASK_17).lanewise(VectorOperators.LSHR, 8);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 200);
    oV = iV.and(MASK_17).lanewise(VectorOperators.LSHL, 9).or(oV);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 208);
    oV = iV.and(MASK_17).lanewise(VectorOperators.LSHL, 26).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.and(MASK_17).lanewise(VectorOperators.LSHR, 6);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 216);
    oV = iV.and(MASK_17).lanewise(VectorOperators.LSHL, 11).or(oV);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 224);
    oV = iV.and(MASK_17).lanewise(VectorOperators.LSHL, 28).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.and(MASK_17).lanewise(VectorOperators.LSHR, 4);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 232);
    oV = iV.and(MASK_17).lanewise(VectorOperators.LSHL, 13).or(oV);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 240);
    oV = iV.and(MASK_17).lanewise(VectorOperators.LSHL, 30).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.and(MASK_17).lanewise(VectorOperators.LSHR, 2);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 248);
    oV = iV.and(MASK_17).lanewise(VectorOperators.LSHL, 15).or(oV);

    oV.intoArray(out, outpos);
  }

  private static void fastpack18(final int[] in, int inpos, final int[] out,
                                 int outpos) {
    var iV = IntVector.fromArray(SPECIES_512, in, inpos);
    var oV = iV.and(MASK_18);
    iV = IntVector.fromArray(SPECIES_512, in, inpos + 16);
    oV = iV.and(MASK_18).lanewise(VectorOperators.LSHL, 18).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_512;
    oV = iV.and(MASK_18).lanewise(VectorOperators.LSHR, 14);

    iV = IntVector.fromArray(SPECIES_512, in, inpos + 32);
    oV = iV.and(MASK_18).lanewise(VectorOperators.LSHL, 4).or(oV);

    iV = IntVector.fromArray(SPECIES_512, in, inpos + 48);
    oV = iV.and(MASK_18).lanewise(VectorOperators.LSHL, 22).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_512;

    oV = iV.and(MASK_18).lanewise(VectorOperators.LSHR, 10);

    iV = IntVector.fromArray(SPECIES_512, in, inpos + 64);
    oV = iV.and(MASK_18).lanewise(VectorOperators.LSHL, 8).or(oV);

    iV = IntVector.fromArray(SPECIES_512, in, inpos + 80);
    oV = iV.and(MASK_18).lanewise(VectorOperators.LSHL, 26).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_512;

    oV = iV.and(MASK_18).lanewise(VectorOperators.LSHR, 6);

    iV = IntVector.fromArray(SPECIES_512, in, inpos + 96);
    oV = iV.and(MASK_18).lanewise(VectorOperators.LSHL, 12).or(oV);

    iV = IntVector.fromArray(SPECIES_512, in, inpos + 112);
    oV = iV.and(MASK_18).lanewise(VectorOperators.LSHL, 30).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_512;

    oV = iV.and(MASK_18).lanewise(VectorOperators.LSHR, 2);

    iV = IntVector.fromArray(SPECIES_512, in, inpos + 128);
    oV = iV.and(MASK_18).lanewise(VectorOperators.LSHL, 16).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_512;

    oV = iV.and(MASK_18).lanewise(VectorOperators.LSHR, 16);

    iV = IntVector.fromArray(SPECIES_512, in, inpos + 144);
    oV = iV.and(MASK_18).lanewise(VectorOperators.LSHL, 2).or(oV);

    iV = IntVector.fromArray(SPECIES_512, in, inpos + 160);
    oV = iV.and(MASK_18).lanewise(VectorOperators.LSHL, 20).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_512;

    oV = iV.and(MASK_18).lanewise(VectorOperators.LSHR, 12);

    iV = IntVector.fromArray(SPECIES_512, in, inpos + 176);
    oV = iV.and(MASK_18).lanewise(VectorOperators.LSHL, 6).or(oV);

    iV = IntVector.fromArray(SPECIES_512, in, inpos + 192);
    oV = iV.and(MASK_18).lanewise(VectorOperators.LSHL, 24).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_512;

    oV = iV.and(MASK_18).lanewise(VectorOperators.LSHR, 8);

    iV = IntVector.fromArray(SPECIES_512, in, inpos + 208);
    oV = iV.and(MASK_18).lanewise(VectorOperators.LSHL, 10).or(oV);

    iV = IntVector.fromArray(SPECIES_512, in, inpos + 224);
    oV = iV.and(MASK_18).lanewise(VectorOperators.LSHL, 28).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_512;

    oV = iV.and(MASK_18).lanewise(VectorOperators.LSHR, 4);

    iV = IntVector.fromArray(SPECIES_512, in, inpos + 240);
    oV = iV.and(MASK_18).lanewise(VectorOperators.LSHL, 14).or(oV);

    oV.intoArray(out, outpos);
  }

  private static void fastpack19(final int[] in, int inpos, final int[] out,
                                 int outpos) {
    var iV = IntVector.fromArray(SPECIES_256, in, inpos);
    var oV = iV.and(MASK_19);
    iV = IntVector.fromArray(SPECIES_256, in, inpos + 8);
    oV = iV.and(MASK_19).lanewise(VectorOperators.LSHL, 19).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.and(MASK_19).lanewise(VectorOperators.LSHR, 13);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 16);
    oV = iV.and(MASK_19).lanewise(VectorOperators.LSHL, 6).or(oV);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 24);
    oV = iV.and(MASK_19).lanewise(VectorOperators.LSHL, 25).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.and(MASK_19).lanewise(VectorOperators.LSHR, 7);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 32);
    oV = iV.and(MASK_19).lanewise(VectorOperators.LSHL, 12).or(oV);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 40);
    oV = iV.and(MASK_19).lanewise(VectorOperators.LSHL, 31).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.and(MASK_19).lanewise(VectorOperators.LSHR, 1);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 48);
    oV = iV.and(MASK_19).lanewise(VectorOperators.LSHL, 18).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.and(MASK_19).lanewise(VectorOperators.LSHR, 14);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 56);
    oV = iV.and(MASK_19).lanewise(VectorOperators.LSHL, 5).or(oV);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 64);
    oV = iV.and(MASK_19).lanewise(VectorOperators.LSHL, 24).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.and(MASK_19).lanewise(VectorOperators.LSHR, 8);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 72);
    oV = iV.and(MASK_19).lanewise(VectorOperators.LSHL, 11).or(oV);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 80);
    oV = iV.and(MASK_19).lanewise(VectorOperators.LSHL, 30).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.and(MASK_19).lanewise(VectorOperators.LSHR, 2);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 88);
    oV = iV.and(MASK_19).lanewise(VectorOperators.LSHL, 17).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.and(MASK_19).lanewise(VectorOperators.LSHR, 15);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 96);
    oV = iV.and(MASK_19).lanewise(VectorOperators.LSHL, 4).or(oV);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 104);
    oV = iV.and(MASK_19).lanewise(VectorOperators.LSHL, 23).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.and(MASK_19).lanewise(VectorOperators.LSHR, 9);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 112);
    oV = iV.and(MASK_19).lanewise(VectorOperators.LSHL, 10).or(oV);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 120);
    oV = iV.and(MASK_19).lanewise(VectorOperators.LSHL, 29).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.and(MASK_19).lanewise(VectorOperators.LSHR, 3);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 128);
    oV = iV.and(MASK_19).lanewise(VectorOperators.LSHL, 16).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.and(MASK_19).lanewise(VectorOperators.LSHR, 16);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 136);
    oV = iV.and(MASK_19).lanewise(VectorOperators.LSHL, 3).or(oV);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 144);
    oV = iV.and(MASK_19).lanewise(VectorOperators.LSHL, 22).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.and(MASK_19).lanewise(VectorOperators.LSHR, 10);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 152);
    oV = iV.and(MASK_19).lanewise(VectorOperators.LSHL, 9).or(oV);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 160);
    oV = iV.and(MASK_19).lanewise(VectorOperators.LSHL, 28).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.and(MASK_19).lanewise(VectorOperators.LSHR, 4);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 168);
    oV = iV.and(MASK_19).lanewise(VectorOperators.LSHL, 15).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.and(MASK_19).lanewise(VectorOperators.LSHR, 17);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 176);
    oV = iV.and(MASK_19).lanewise(VectorOperators.LSHL, 2).or(oV);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 184);
    oV = iV.and(MASK_19).lanewise(VectorOperators.LSHL, 21).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.and(MASK_19).lanewise(VectorOperators.LSHR, 11);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 192);
    oV = iV.and(MASK_19).lanewise(VectorOperators.LSHL, 8).or(oV);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 200);
    oV = iV.and(MASK_19).lanewise(VectorOperators.LSHL, 27).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.and(MASK_19).lanewise(VectorOperators.LSHR, 5);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 208);
    oV = iV.and(MASK_19).lanewise(VectorOperators.LSHL, 14).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.and(MASK_19).lanewise(VectorOperators.LSHR, 18);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 216);
    oV = iV.and(MASK_19).lanewise(VectorOperators.LSHL, 1).or(oV);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 224);
    oV = iV.and(MASK_19).lanewise(VectorOperators.LSHL, 20).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.and(MASK_19).lanewise(VectorOperators.LSHR, 12);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 232);
    oV = iV.and(MASK_19).lanewise(VectorOperators.LSHL, 7).or(oV);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 240);
    oV = iV.and(MASK_19).lanewise(VectorOperators.LSHL, 26).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.and(MASK_19).lanewise(VectorOperators.LSHR, 6);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 248);
    oV = iV.and(MASK_19).lanewise(VectorOperators.LSHL, 13).or(oV);

    oV.intoArray(out, outpos);
  }

  private static void fastpack20(final int[] in, int inpos, final int[] out,
                                 int outpos) {
    var iV = IntVector.fromArray(SPECIES_512, in, inpos);
    var oV = iV.and(MASK_20);
    iV = IntVector.fromArray(SPECIES_512, in, inpos + 16);
    oV = iV.and(MASK_20).lanewise(VectorOperators.LSHL, 20).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_512;
    oV = iV.and(MASK_20).lanewise(VectorOperators.LSHR, 12);

    iV = IntVector.fromArray(SPECIES_512, in, inpos + 32);
    oV = iV.and(MASK_20).lanewise(VectorOperators.LSHL, 8).or(oV);

    iV = IntVector.fromArray(SPECIES_512, in, inpos + 48);
    oV = iV.and(MASK_20).lanewise(VectorOperators.LSHL, 28).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_512;

    oV = iV.and(MASK_20).lanewise(VectorOperators.LSHR, 4);

    iV = IntVector.fromArray(SPECIES_512, in, inpos + 64);
    oV = iV.and(MASK_20).lanewise(VectorOperators.LSHL, 16).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_512;

    oV = iV.and(MASK_20).lanewise(VectorOperators.LSHR, 16);

    iV = IntVector.fromArray(SPECIES_512, in, inpos + 80);
    oV = iV.and(MASK_20).lanewise(VectorOperators.LSHL, 4).or(oV);

    iV = IntVector.fromArray(SPECIES_512, in, inpos + 96);
    oV = iV.and(MASK_20).lanewise(VectorOperators.LSHL, 24).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_512;

    oV = iV.and(MASK_20).lanewise(VectorOperators.LSHR, 8);

    iV = IntVector.fromArray(SPECIES_512, in, inpos + 112);
    oV = iV.and(MASK_20).lanewise(VectorOperators.LSHL, 12).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_512;

    oV = oV.zero(SPECIES_512);

    iV = IntVector.fromArray(SPECIES_512, in, inpos + 128);
    oV = iV.and(MASK_20).or(oV);

    iV = IntVector.fromArray(SPECIES_512, in, inpos + 144);
    oV = iV.and(MASK_20).lanewise(VectorOperators.LSHL, 20).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_512;

    oV = iV.and(MASK_20).lanewise(VectorOperators.LSHR, 12);

    iV = IntVector.fromArray(SPECIES_512, in, inpos + 160);
    oV = iV.and(MASK_20).lanewise(VectorOperators.LSHL, 8).or(oV);

    iV = IntVector.fromArray(SPECIES_512, in, inpos + 176);
    oV = iV.and(MASK_20).lanewise(VectorOperators.LSHL, 28).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_512;

    oV = iV.and(MASK_20).lanewise(VectorOperators.LSHR, 4);

    iV = IntVector.fromArray(SPECIES_512, in, inpos + 192);
    oV = iV.and(MASK_20).lanewise(VectorOperators.LSHL, 16).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_512;

    oV = iV.and(MASK_20).lanewise(VectorOperators.LSHR, 16);

    iV = IntVector.fromArray(SPECIES_512, in, inpos + 208);
    oV = iV.and(MASK_20).lanewise(VectorOperators.LSHL, 4).or(oV);

    iV = IntVector.fromArray(SPECIES_512, in, inpos + 224);
    oV = iV.and(MASK_20).lanewise(VectorOperators.LSHL, 24).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_512;

    oV = iV.and(MASK_20).lanewise(VectorOperators.LSHR, 8);

    iV = IntVector.fromArray(SPECIES_512, in, inpos + 240);
    oV = iV.and(MASK_20).lanewise(VectorOperators.LSHL, 12).or(oV);

    oV.intoArray(out, outpos);
  }

  private static void fastpack21(final int[] in, int inpos, final int[] out,
                                 int outpos) {
    var iV = IntVector.fromArray(SPECIES_256, in, inpos);
    var oV = iV.and(MASK_21);
    iV = IntVector.fromArray(SPECIES_256, in, inpos + 8);
    oV = iV.and(MASK_21).lanewise(VectorOperators.LSHL, 21).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.and(MASK_21).lanewise(VectorOperators.LSHR, 11);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 16);
    oV = iV.and(MASK_21).lanewise(VectorOperators.LSHL, 10).or(oV);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 24);
    oV = iV.and(MASK_21).lanewise(VectorOperators.LSHL, 31).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.and(MASK_21).lanewise(VectorOperators.LSHR, 1);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 32);
    oV = iV.and(MASK_21).lanewise(VectorOperators.LSHL, 20).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.and(MASK_21).lanewise(VectorOperators.LSHR, 12);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 40);
    oV = iV.and(MASK_21).lanewise(VectorOperators.LSHL, 9).or(oV);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 48);
    oV = iV.and(MASK_21).lanewise(VectorOperators.LSHL, 30).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.and(MASK_21).lanewise(VectorOperators.LSHR, 2);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 56);
    oV = iV.and(MASK_21).lanewise(VectorOperators.LSHL, 19).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.and(MASK_21).lanewise(VectorOperators.LSHR, 13);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 64);
    oV = iV.and(MASK_21).lanewise(VectorOperators.LSHL, 8).or(oV);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 72);
    oV = iV.and(MASK_21).lanewise(VectorOperators.LSHL, 29).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.and(MASK_21).lanewise(VectorOperators.LSHR, 3);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 80);
    oV = iV.and(MASK_21).lanewise(VectorOperators.LSHL, 18).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.and(MASK_21).lanewise(VectorOperators.LSHR, 14);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 88);
    oV = iV.and(MASK_21).lanewise(VectorOperators.LSHL, 7).or(oV);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 96);
    oV = iV.and(MASK_21).lanewise(VectorOperators.LSHL, 28).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.and(MASK_21).lanewise(VectorOperators.LSHR, 4);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 104);
    oV = iV.and(MASK_21).lanewise(VectorOperators.LSHL, 17).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.and(MASK_21).lanewise(VectorOperators.LSHR, 15);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 112);
    oV = iV.and(MASK_21).lanewise(VectorOperators.LSHL, 6).or(oV);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 120);
    oV = iV.and(MASK_21).lanewise(VectorOperators.LSHL, 27).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.and(MASK_21).lanewise(VectorOperators.LSHR, 5);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 128);
    oV = iV.and(MASK_21).lanewise(VectorOperators.LSHL, 16).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.and(MASK_21).lanewise(VectorOperators.LSHR, 16);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 136);
    oV = iV.and(MASK_21).lanewise(VectorOperators.LSHL, 5).or(oV);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 144);
    oV = iV.and(MASK_21).lanewise(VectorOperators.LSHL, 26).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.and(MASK_21).lanewise(VectorOperators.LSHR, 6);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 152);
    oV = iV.and(MASK_21).lanewise(VectorOperators.LSHL, 15).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.and(MASK_21).lanewise(VectorOperators.LSHR, 17);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 160);
    oV = iV.and(MASK_21).lanewise(VectorOperators.LSHL, 4).or(oV);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 168);
    oV = iV.and(MASK_21).lanewise(VectorOperators.LSHL, 25).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.and(MASK_21).lanewise(VectorOperators.LSHR, 7);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 176);
    oV = iV.and(MASK_21).lanewise(VectorOperators.LSHL, 14).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.and(MASK_21).lanewise(VectorOperators.LSHR, 18);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 184);
    oV = iV.and(MASK_21).lanewise(VectorOperators.LSHL, 3).or(oV);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 192);
    oV = iV.and(MASK_21).lanewise(VectorOperators.LSHL, 24).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.and(MASK_21).lanewise(VectorOperators.LSHR, 8);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 200);
    oV = iV.and(MASK_21).lanewise(VectorOperators.LSHL, 13).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.and(MASK_21).lanewise(VectorOperators.LSHR, 19);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 208);
    oV = iV.and(MASK_21).lanewise(VectorOperators.LSHL, 2).or(oV);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 216);
    oV = iV.and(MASK_21).lanewise(VectorOperators.LSHL, 23).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.and(MASK_21).lanewise(VectorOperators.LSHR, 9);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 224);
    oV = iV.and(MASK_21).lanewise(VectorOperators.LSHL, 12).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.and(MASK_21).lanewise(VectorOperators.LSHR, 20);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 232);
    oV = iV.and(MASK_21).lanewise(VectorOperators.LSHL, 1).or(oV);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 240);
    oV = iV.and(MASK_21).lanewise(VectorOperators.LSHL, 22).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.and(MASK_21).lanewise(VectorOperators.LSHR, 10);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 248);
    oV = iV.and(MASK_21).lanewise(VectorOperators.LSHL, 11).or(oV);

    oV.intoArray(out, outpos);
  }

  private static void fastpack22(final int[] in, int inpos, final int[] out,
                                 int outpos) {
    var iV = IntVector.fromArray(SPECIES_512, in, inpos);
    var oV = iV.and(MASK_22);
    iV = IntVector.fromArray(SPECIES_512, in, inpos + 16);
    oV = iV.and(MASK_22).lanewise(VectorOperators.LSHL, 22).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_512;
    oV = iV.and(MASK_22).lanewise(VectorOperators.LSHR, 10);

    iV = IntVector.fromArray(SPECIES_512, in, inpos + 32);
    oV = iV.and(MASK_22).lanewise(VectorOperators.LSHL, 12).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_512;

    oV = iV.and(MASK_22).lanewise(VectorOperators.LSHR, 20);

    iV = IntVector.fromArray(SPECIES_512, in, inpos + 48);
    oV = iV.and(MASK_22).lanewise(VectorOperators.LSHL, 2).or(oV);

    iV = IntVector.fromArray(SPECIES_512, in, inpos + 64);
    oV = iV.and(MASK_22).lanewise(VectorOperators.LSHL, 24).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_512;

    oV = iV.and(MASK_22).lanewise(VectorOperators.LSHR, 8);

    iV = IntVector.fromArray(SPECIES_512, in, inpos + 80);
    oV = iV.and(MASK_22).lanewise(VectorOperators.LSHL, 14).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_512;

    oV = iV.and(MASK_22).lanewise(VectorOperators.LSHR, 18);

    iV = IntVector.fromArray(SPECIES_512, in, inpos + 96);
    oV = iV.and(MASK_22).lanewise(VectorOperators.LSHL, 4).or(oV);

    iV = IntVector.fromArray(SPECIES_512, in, inpos + 112);
    oV = iV.and(MASK_22).lanewise(VectorOperators.LSHL, 26).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_512;

    oV = iV.and(MASK_22).lanewise(VectorOperators.LSHR, 6);

    iV = IntVector.fromArray(SPECIES_512, in, inpos + 128);
    oV = iV.and(MASK_22).lanewise(VectorOperators.LSHL, 16).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_512;

    oV = iV.and(MASK_22).lanewise(VectorOperators.LSHR, 16);

    iV = IntVector.fromArray(SPECIES_512, in, inpos + 144);
    oV = iV.and(MASK_22).lanewise(VectorOperators.LSHL, 6).or(oV);

    iV = IntVector.fromArray(SPECIES_512, in, inpos + 160);
    oV = iV.and(MASK_22).lanewise(VectorOperators.LSHL, 28).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_512;

    oV = iV.and(MASK_22).lanewise(VectorOperators.LSHR, 4);

    iV = IntVector.fromArray(SPECIES_512, in, inpos + 176);
    oV = iV.and(MASK_22).lanewise(VectorOperators.LSHL, 18).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_512;

    oV = iV.and(MASK_22).lanewise(VectorOperators.LSHR, 14);

    iV = IntVector.fromArray(SPECIES_512, in, inpos + 192);
    oV = iV.and(MASK_22).lanewise(VectorOperators.LSHL, 8).or(oV);

    iV = IntVector.fromArray(SPECIES_512, in, inpos + 208);
    oV = iV.and(MASK_22).lanewise(VectorOperators.LSHL, 30).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_512;

    oV = iV.and(MASK_22).lanewise(VectorOperators.LSHR, 2);

    iV = IntVector.fromArray(SPECIES_512, in, inpos + 224);
    oV = iV.and(MASK_22).lanewise(VectorOperators.LSHL, 20).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_512;

    oV = iV.and(MASK_22).lanewise(VectorOperators.LSHR, 12);

    iV = IntVector.fromArray(SPECIES_512, in, inpos + 240);
    oV = iV.and(MASK_22).lanewise(VectorOperators.LSHL, 10).or(oV);

    oV.intoArray(out, outpos);
  }

  private static void fastpack23(final int[] in, int inpos, final int[] out,
                                 int outpos) {
    var iV = IntVector.fromArray(SPECIES_256, in, inpos);
    var oV = iV.and(MASK_23);
    iV = IntVector.fromArray(SPECIES_256, in, inpos + 8);
    oV = iV.and(MASK_23).lanewise(VectorOperators.LSHL, 23).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.and(MASK_23).lanewise(VectorOperators.LSHR, 9);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 16);
    oV = iV.and(MASK_23).lanewise(VectorOperators.LSHL, 14).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.and(MASK_23).lanewise(VectorOperators.LSHR, 18);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 24);
    oV = iV.and(MASK_23).lanewise(VectorOperators.LSHL, 5).or(oV);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 32);
    oV = iV.and(MASK_23).lanewise(VectorOperators.LSHL, 28).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.and(MASK_23).lanewise(VectorOperators.LSHR, 4);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 40);
    oV = iV.and(MASK_23).lanewise(VectorOperators.LSHL, 19).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.and(MASK_23).lanewise(VectorOperators.LSHR, 13);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 48);
    oV = iV.and(MASK_23).lanewise(VectorOperators.LSHL, 10).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.and(MASK_23).lanewise(VectorOperators.LSHR, 22);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 56);
    oV = iV.and(MASK_23).lanewise(VectorOperators.LSHL, 1).or(oV);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 64);
    oV = iV.and(MASK_23).lanewise(VectorOperators.LSHL, 24).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.and(MASK_23).lanewise(VectorOperators.LSHR, 8);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 72);
    oV = iV.and(MASK_23).lanewise(VectorOperators.LSHL, 15).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.and(MASK_23).lanewise(VectorOperators.LSHR, 17);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 80);
    oV = iV.and(MASK_23).lanewise(VectorOperators.LSHL, 6).or(oV);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 88);
    oV = iV.and(MASK_23).lanewise(VectorOperators.LSHL, 29).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.and(MASK_23).lanewise(VectorOperators.LSHR, 3);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 96);
    oV = iV.and(MASK_23).lanewise(VectorOperators.LSHL, 20).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.and(MASK_23).lanewise(VectorOperators.LSHR, 12);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 104);
    oV = iV.and(MASK_23).lanewise(VectorOperators.LSHL, 11).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.and(MASK_23).lanewise(VectorOperators.LSHR, 21);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 112);
    oV = iV.and(MASK_23).lanewise(VectorOperators.LSHL, 2).or(oV);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 120);
    oV = iV.and(MASK_23).lanewise(VectorOperators.LSHL, 25).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.and(MASK_23).lanewise(VectorOperators.LSHR, 7);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 128);
    oV = iV.and(MASK_23).lanewise(VectorOperators.LSHL, 16).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.and(MASK_23).lanewise(VectorOperators.LSHR, 16);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 136);
    oV = iV.and(MASK_23).lanewise(VectorOperators.LSHL, 7).or(oV);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 144);
    oV = iV.and(MASK_23).lanewise(VectorOperators.LSHL, 30).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.and(MASK_23).lanewise(VectorOperators.LSHR, 2);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 152);
    oV = iV.and(MASK_23).lanewise(VectorOperators.LSHL, 21).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.and(MASK_23).lanewise(VectorOperators.LSHR, 11);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 160);
    oV = iV.and(MASK_23).lanewise(VectorOperators.LSHL, 12).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.and(MASK_23).lanewise(VectorOperators.LSHR, 20);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 168);
    oV = iV.and(MASK_23).lanewise(VectorOperators.LSHL, 3).or(oV);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 176);
    oV = iV.and(MASK_23).lanewise(VectorOperators.LSHL, 26).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.and(MASK_23).lanewise(VectorOperators.LSHR, 6);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 184);
    oV = iV.and(MASK_23).lanewise(VectorOperators.LSHL, 17).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.and(MASK_23).lanewise(VectorOperators.LSHR, 15);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 192);
    oV = iV.and(MASK_23).lanewise(VectorOperators.LSHL, 8).or(oV);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 200);
    oV = iV.and(MASK_23).lanewise(VectorOperators.LSHL, 31).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.and(MASK_23).lanewise(VectorOperators.LSHR, 1);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 208);
    oV = iV.and(MASK_23).lanewise(VectorOperators.LSHL, 22).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.and(MASK_23).lanewise(VectorOperators.LSHR, 10);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 216);
    oV = iV.and(MASK_23).lanewise(VectorOperators.LSHL, 13).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.and(MASK_23).lanewise(VectorOperators.LSHR, 19);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 224);
    oV = iV.and(MASK_23).lanewise(VectorOperators.LSHL, 4).or(oV);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 232);
    oV = iV.and(MASK_23).lanewise(VectorOperators.LSHL, 27).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.and(MASK_23).lanewise(VectorOperators.LSHR, 5);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 240);
    oV = iV.and(MASK_23).lanewise(VectorOperators.LSHL, 18).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.and(MASK_23).lanewise(VectorOperators.LSHR, 14);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 248);
    oV = iV.and(MASK_23).lanewise(VectorOperators.LSHL, 9).or(oV);

    oV.intoArray(out, outpos);
  }

  private static void fastpack24(final int[] in, int inpos, final int[] out,
                                 int outpos) {
    var iV = IntVector.fromArray(SPECIES_512, in, inpos);
    var oV = iV.and(MASK_24);
    iV = IntVector.fromArray(SPECIES_512, in, inpos + 16);
    oV = iV.and(MASK_24).lanewise(VectorOperators.LSHL, 24).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_512;
    oV = iV.and(MASK_24).lanewise(VectorOperators.LSHR, 8);

    iV = IntVector.fromArray(SPECIES_512, in, inpos + 32);
    oV = iV.and(MASK_24).lanewise(VectorOperators.LSHL, 16).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_512;

    oV = iV.and(MASK_24).lanewise(VectorOperators.LSHR, 16);

    iV = IntVector.fromArray(SPECIES_512, in, inpos + 48);
    oV = iV.and(MASK_24).lanewise(VectorOperators.LSHL, 8).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_512;

    oV = oV.zero(SPECIES_512);

    iV = IntVector.fromArray(SPECIES_512, in, inpos + 64);
    oV = iV.and(MASK_24).or(oV);

    iV = IntVector.fromArray(SPECIES_512, in, inpos + 80);
    oV = iV.and(MASK_24).lanewise(VectorOperators.LSHL, 24).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_512;

    oV = iV.and(MASK_24).lanewise(VectorOperators.LSHR, 8);

    iV = IntVector.fromArray(SPECIES_512, in, inpos + 96);
    oV = iV.and(MASK_24).lanewise(VectorOperators.LSHL, 16).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_512;

    oV = iV.and(MASK_24).lanewise(VectorOperators.LSHR, 16);

    iV = IntVector.fromArray(SPECIES_512, in, inpos + 112);
    oV = iV.and(MASK_24).lanewise(VectorOperators.LSHL, 8).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_512;

    oV = oV.zero(SPECIES_512);

    iV = IntVector.fromArray(SPECIES_512, in, inpos + 128);
    oV = iV.and(MASK_24).or(oV);

    iV = IntVector.fromArray(SPECIES_512, in, inpos + 144);
    oV = iV.and(MASK_24).lanewise(VectorOperators.LSHL, 24).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_512;

    oV = iV.and(MASK_24).lanewise(VectorOperators.LSHR, 8);

    iV = IntVector.fromArray(SPECIES_512, in, inpos + 160);
    oV = iV.and(MASK_24).lanewise(VectorOperators.LSHL, 16).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_512;

    oV = iV.and(MASK_24).lanewise(VectorOperators.LSHR, 16);

    iV = IntVector.fromArray(SPECIES_512, in, inpos + 176);
    oV = iV.and(MASK_24).lanewise(VectorOperators.LSHL, 8).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_512;

    oV = oV.zero(SPECIES_512);

    iV = IntVector.fromArray(SPECIES_512, in, inpos + 192);
    oV = iV.and(MASK_24).or(oV);

    iV = IntVector.fromArray(SPECIES_512, in, inpos + 208);
    oV = iV.and(MASK_24).lanewise(VectorOperators.LSHL, 24).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_512;

    oV = iV.and(MASK_24).lanewise(VectorOperators.LSHR, 8);

    iV = IntVector.fromArray(SPECIES_512, in, inpos + 224);
    oV = iV.and(MASK_24).lanewise(VectorOperators.LSHL, 16).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_512;

    oV = iV.and(MASK_24).lanewise(VectorOperators.LSHR, 16);

    iV = IntVector.fromArray(SPECIES_512, in, inpos + 240);
    oV = iV.and(MASK_24).lanewise(VectorOperators.LSHL, 8).or(oV);

    oV.intoArray(out, outpos);
  }

  private static void fastpack25(final int[] in, int inpos, final int[] out,
                                 int outpos) {
    var iV = IntVector.fromArray(SPECIES_256, in, inpos);
    var oV = iV.and(MASK_25);
    iV = IntVector.fromArray(SPECIES_256, in, inpos + 8);
    oV = iV.and(MASK_25).lanewise(VectorOperators.LSHL, 25).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.and(MASK_25).lanewise(VectorOperators.LSHR, 7);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 16);
    oV = iV.and(MASK_25).lanewise(VectorOperators.LSHL, 18).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.and(MASK_25).lanewise(VectorOperators.LSHR, 14);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 24);
    oV = iV.and(MASK_25).lanewise(VectorOperators.LSHL, 11).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.and(MASK_25).lanewise(VectorOperators.LSHR, 21);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 32);
    oV = iV.and(MASK_25).lanewise(VectorOperators.LSHL, 4).or(oV);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 40);
    oV = iV.and(MASK_25).lanewise(VectorOperators.LSHL, 29).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.and(MASK_25).lanewise(VectorOperators.LSHR, 3);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 48);
    oV = iV.and(MASK_25).lanewise(VectorOperators.LSHL, 22).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.and(MASK_25).lanewise(VectorOperators.LSHR, 10);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 56);
    oV = iV.and(MASK_25).lanewise(VectorOperators.LSHL, 15).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.and(MASK_25).lanewise(VectorOperators.LSHR, 17);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 64);
    oV = iV.and(MASK_25).lanewise(VectorOperators.LSHL, 8).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.and(MASK_25).lanewise(VectorOperators.LSHR, 24);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 72);
    oV = iV.and(MASK_25).lanewise(VectorOperators.LSHL, 1).or(oV);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 80);
    oV = iV.and(MASK_25).lanewise(VectorOperators.LSHL, 26).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.and(MASK_25).lanewise(VectorOperators.LSHR, 6);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 88);
    oV = iV.and(MASK_25).lanewise(VectorOperators.LSHL, 19).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.and(MASK_25).lanewise(VectorOperators.LSHR, 13);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 96);
    oV = iV.and(MASK_25).lanewise(VectorOperators.LSHL, 12).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.and(MASK_25).lanewise(VectorOperators.LSHR, 20);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 104);
    oV = iV.and(MASK_25).lanewise(VectorOperators.LSHL, 5).or(oV);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 112);
    oV = iV.and(MASK_25).lanewise(VectorOperators.LSHL, 30).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.and(MASK_25).lanewise(VectorOperators.LSHR, 2);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 120);
    oV = iV.and(MASK_25).lanewise(VectorOperators.LSHL, 23).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.and(MASK_25).lanewise(VectorOperators.LSHR, 9);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 128);
    oV = iV.and(MASK_25).lanewise(VectorOperators.LSHL, 16).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.and(MASK_25).lanewise(VectorOperators.LSHR, 16);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 136);
    oV = iV.and(MASK_25).lanewise(VectorOperators.LSHL, 9).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.and(MASK_25).lanewise(VectorOperators.LSHR, 23);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 144);
    oV = iV.and(MASK_25).lanewise(VectorOperators.LSHL, 2).or(oV);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 152);
    oV = iV.and(MASK_25).lanewise(VectorOperators.LSHL, 27).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.and(MASK_25).lanewise(VectorOperators.LSHR, 5);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 160);
    oV = iV.and(MASK_25).lanewise(VectorOperators.LSHL, 20).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.and(MASK_25).lanewise(VectorOperators.LSHR, 12);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 168);
    oV = iV.and(MASK_25).lanewise(VectorOperators.LSHL, 13).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.and(MASK_25).lanewise(VectorOperators.LSHR, 19);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 176);
    oV = iV.and(MASK_25).lanewise(VectorOperators.LSHL, 6).or(oV);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 184);
    oV = iV.and(MASK_25).lanewise(VectorOperators.LSHL, 31).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.and(MASK_25).lanewise(VectorOperators.LSHR, 1);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 192);
    oV = iV.and(MASK_25).lanewise(VectorOperators.LSHL, 24).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.and(MASK_25).lanewise(VectorOperators.LSHR, 8);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 200);
    oV = iV.and(MASK_25).lanewise(VectorOperators.LSHL, 17).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.and(MASK_25).lanewise(VectorOperators.LSHR, 15);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 208);
    oV = iV.and(MASK_25).lanewise(VectorOperators.LSHL, 10).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.and(MASK_25).lanewise(VectorOperators.LSHR, 22);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 216);
    oV = iV.and(MASK_25).lanewise(VectorOperators.LSHL, 3).or(oV);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 224);
    oV = iV.and(MASK_25).lanewise(VectorOperators.LSHL, 28).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.and(MASK_25).lanewise(VectorOperators.LSHR, 4);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 232);
    oV = iV.and(MASK_25).lanewise(VectorOperators.LSHL, 21).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.and(MASK_25).lanewise(VectorOperators.LSHR, 11);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 240);
    oV = iV.and(MASK_25).lanewise(VectorOperators.LSHL, 14).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.and(MASK_25).lanewise(VectorOperators.LSHR, 18);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 248);
    oV = iV.and(MASK_25).lanewise(VectorOperators.LSHL, 7).or(oV);

    oV.intoArray(out, outpos);
  }

  private static void fastpack26(final int[] in, int inpos, final int[] out,
                                 int outpos) {
    var iV = IntVector.fromArray(SPECIES_512, in, inpos);
    var oV = iV.and(MASK_26);
    iV = IntVector.fromArray(SPECIES_512, in, inpos + 16);
    oV = iV.and(MASK_26).lanewise(VectorOperators.LSHL, 26).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_512;
    oV = iV.and(MASK_26).lanewise(VectorOperators.LSHR, 6);

    iV = IntVector.fromArray(SPECIES_512, in, inpos + 32);
    oV = iV.and(MASK_26).lanewise(VectorOperators.LSHL, 20).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_512;

    oV = iV.and(MASK_26).lanewise(VectorOperators.LSHR, 12);

    iV = IntVector.fromArray(SPECIES_512, in, inpos + 48);
    oV = iV.and(MASK_26).lanewise(VectorOperators.LSHL, 14).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_512;

    oV = iV.and(MASK_26).lanewise(VectorOperators.LSHR, 18);

    iV = IntVector.fromArray(SPECIES_512, in, inpos + 64);
    oV = iV.and(MASK_26).lanewise(VectorOperators.LSHL, 8).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_512;

    oV = iV.and(MASK_26).lanewise(VectorOperators.LSHR, 24);

    iV = IntVector.fromArray(SPECIES_512, in, inpos + 80);
    oV = iV.and(MASK_26).lanewise(VectorOperators.LSHL, 2).or(oV);

    iV = IntVector.fromArray(SPECIES_512, in, inpos + 96);
    oV = iV.and(MASK_26).lanewise(VectorOperators.LSHL, 28).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_512;

    oV = iV.and(MASK_26).lanewise(VectorOperators.LSHR, 4);

    iV = IntVector.fromArray(SPECIES_512, in, inpos + 112);
    oV = iV.and(MASK_26).lanewise(VectorOperators.LSHL, 22).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_512;

    oV = iV.and(MASK_26).lanewise(VectorOperators.LSHR, 10);

    iV = IntVector.fromArray(SPECIES_512, in, inpos + 128);
    oV = iV.and(MASK_26).lanewise(VectorOperators.LSHL, 16).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_512;

    oV = iV.and(MASK_26).lanewise(VectorOperators.LSHR, 16);

    iV = IntVector.fromArray(SPECIES_512, in, inpos + 144);
    oV = iV.and(MASK_26).lanewise(VectorOperators.LSHL, 10).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_512;

    oV = iV.and(MASK_26).lanewise(VectorOperators.LSHR, 22);

    iV = IntVector.fromArray(SPECIES_512, in, inpos + 160);
    oV = iV.and(MASK_26).lanewise(VectorOperators.LSHL, 4).or(oV);

    iV = IntVector.fromArray(SPECIES_512, in, inpos + 176);
    oV = iV.and(MASK_26).lanewise(VectorOperators.LSHL, 30).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_512;

    oV = iV.and(MASK_26).lanewise(VectorOperators.LSHR, 2);

    iV = IntVector.fromArray(SPECIES_512, in, inpos + 192);
    oV = iV.and(MASK_26).lanewise(VectorOperators.LSHL, 24).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_512;

    oV = iV.and(MASK_26).lanewise(VectorOperators.LSHR, 8);

    iV = IntVector.fromArray(SPECIES_512, in, inpos + 208);
    oV = iV.and(MASK_26).lanewise(VectorOperators.LSHL, 18).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_512;

    oV = iV.and(MASK_26).lanewise(VectorOperators.LSHR, 14);

    iV = IntVector.fromArray(SPECIES_512, in, inpos + 224);
    oV = iV.and(MASK_26).lanewise(VectorOperators.LSHL, 12).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_512;

    oV = iV.and(MASK_26).lanewise(VectorOperators.LSHR, 20);

    iV = IntVector.fromArray(SPECIES_512, in, inpos + 240);
    oV = iV.and(MASK_26).lanewise(VectorOperators.LSHL, 6).or(oV);

    oV.intoArray(out, outpos);
  }

  private static void fastpack27(final int[] in, int inpos, final int[] out,
                                 int outpos) {
    var iV = IntVector.fromArray(SPECIES_256, in, inpos);
    var oV = iV.and(MASK_27);
    iV = IntVector.fromArray(SPECIES_256, in, inpos + 8);
    oV = iV.and(MASK_27).lanewise(VectorOperators.LSHL, 27).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.and(MASK_27).lanewise(VectorOperators.LSHR, 5);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 16);
    oV = iV.and(MASK_27).lanewise(VectorOperators.LSHL, 22).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.and(MASK_27).lanewise(VectorOperators.LSHR, 10);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 24);
    oV = iV.and(MASK_27).lanewise(VectorOperators.LSHL, 17).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.and(MASK_27).lanewise(VectorOperators.LSHR, 15);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 32);
    oV = iV.and(MASK_27).lanewise(VectorOperators.LSHL, 12).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.and(MASK_27).lanewise(VectorOperators.LSHR, 20);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 40);
    oV = iV.and(MASK_27).lanewise(VectorOperators.LSHL, 7).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.and(MASK_27).lanewise(VectorOperators.LSHR, 25);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 48);
    oV = iV.and(MASK_27).lanewise(VectorOperators.LSHL, 2).or(oV);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 56);
    oV = iV.and(MASK_27).lanewise(VectorOperators.LSHL, 29).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.and(MASK_27).lanewise(VectorOperators.LSHR, 3);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 64);
    oV = iV.and(MASK_27).lanewise(VectorOperators.LSHL, 24).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.and(MASK_27).lanewise(VectorOperators.LSHR, 8);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 72);
    oV = iV.and(MASK_27).lanewise(VectorOperators.LSHL, 19).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.and(MASK_27).lanewise(VectorOperators.LSHR, 13);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 80);
    oV = iV.and(MASK_27).lanewise(VectorOperators.LSHL, 14).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.and(MASK_27).lanewise(VectorOperators.LSHR, 18);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 88);
    oV = iV.and(MASK_27).lanewise(VectorOperators.LSHL, 9).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.and(MASK_27).lanewise(VectorOperators.LSHR, 23);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 96);
    oV = iV.and(MASK_27).lanewise(VectorOperators.LSHL, 4).or(oV);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 104);
    oV = iV.and(MASK_27).lanewise(VectorOperators.LSHL, 31).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.and(MASK_27).lanewise(VectorOperators.LSHR, 1);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 112);
    oV = iV.and(MASK_27).lanewise(VectorOperators.LSHL, 26).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.and(MASK_27).lanewise(VectorOperators.LSHR, 6);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 120);
    oV = iV.and(MASK_27).lanewise(VectorOperators.LSHL, 21).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.and(MASK_27).lanewise(VectorOperators.LSHR, 11);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 128);
    oV = iV.and(MASK_27).lanewise(VectorOperators.LSHL, 16).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.and(MASK_27).lanewise(VectorOperators.LSHR, 16);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 136);
    oV = iV.and(MASK_27).lanewise(VectorOperators.LSHL, 11).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.and(MASK_27).lanewise(VectorOperators.LSHR, 21);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 144);
    oV = iV.and(MASK_27).lanewise(VectorOperators.LSHL, 6).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.and(MASK_27).lanewise(VectorOperators.LSHR, 26);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 152);
    oV = iV.and(MASK_27).lanewise(VectorOperators.LSHL, 1).or(oV);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 160);
    oV = iV.and(MASK_27).lanewise(VectorOperators.LSHL, 28).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.and(MASK_27).lanewise(VectorOperators.LSHR, 4);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 168);
    oV = iV.and(MASK_27).lanewise(VectorOperators.LSHL, 23).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.and(MASK_27).lanewise(VectorOperators.LSHR, 9);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 176);
    oV = iV.and(MASK_27).lanewise(VectorOperators.LSHL, 18).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.and(MASK_27).lanewise(VectorOperators.LSHR, 14);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 184);
    oV = iV.and(MASK_27).lanewise(VectorOperators.LSHL, 13).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.and(MASK_27).lanewise(VectorOperators.LSHR, 19);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 192);
    oV = iV.and(MASK_27).lanewise(VectorOperators.LSHL, 8).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.and(MASK_27).lanewise(VectorOperators.LSHR, 24);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 200);
    oV = iV.and(MASK_27).lanewise(VectorOperators.LSHL, 3).or(oV);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 208);
    oV = iV.and(MASK_27).lanewise(VectorOperators.LSHL, 30).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.and(MASK_27).lanewise(VectorOperators.LSHR, 2);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 216);
    oV = iV.and(MASK_27).lanewise(VectorOperators.LSHL, 25).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.and(MASK_27).lanewise(VectorOperators.LSHR, 7);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 224);
    oV = iV.and(MASK_27).lanewise(VectorOperators.LSHL, 20).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.and(MASK_27).lanewise(VectorOperators.LSHR, 12);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 232);
    oV = iV.and(MASK_27).lanewise(VectorOperators.LSHL, 15).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.and(MASK_27).lanewise(VectorOperators.LSHR, 17);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 240);
    oV = iV.and(MASK_27).lanewise(VectorOperators.LSHL, 10).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.and(MASK_27).lanewise(VectorOperators.LSHR, 22);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 248);
    oV = iV.and(MASK_27).lanewise(VectorOperators.LSHL, 5).or(oV);

    oV.intoArray(out, outpos);
  }

  private static void fastpack28(final int[] in, int inpos, final int[] out,
                                 int outpos) {
    var iV = IntVector.fromArray(SPECIES_512, in, inpos);
    var oV = iV.and(MASK_28);
    iV = IntVector.fromArray(SPECIES_512, in, inpos + 16);
    oV = iV.and(MASK_28).lanewise(VectorOperators.LSHL, 28).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_512;
    oV = iV.and(MASK_28).lanewise(VectorOperators.LSHR, 4);

    iV = IntVector.fromArray(SPECIES_512, in, inpos + 32);
    oV = iV.and(MASK_28).lanewise(VectorOperators.LSHL, 24).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_512;

    oV = iV.and(MASK_28).lanewise(VectorOperators.LSHR, 8);

    iV = IntVector.fromArray(SPECIES_512, in, inpos + 48);
    oV = iV.and(MASK_28).lanewise(VectorOperators.LSHL, 20).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_512;

    oV = iV.and(MASK_28).lanewise(VectorOperators.LSHR, 12);

    iV = IntVector.fromArray(SPECIES_512, in, inpos + 64);
    oV = iV.and(MASK_28).lanewise(VectorOperators.LSHL, 16).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_512;

    oV = iV.and(MASK_28).lanewise(VectorOperators.LSHR, 16);

    iV = IntVector.fromArray(SPECIES_512, in, inpos + 80);
    oV = iV.and(MASK_28).lanewise(VectorOperators.LSHL, 12).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_512;

    oV = iV.and(MASK_28).lanewise(VectorOperators.LSHR, 20);

    iV = IntVector.fromArray(SPECIES_512, in, inpos + 96);
    oV = iV.and(MASK_28).lanewise(VectorOperators.LSHL, 8).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_512;

    oV = iV.and(MASK_28).lanewise(VectorOperators.LSHR, 24);

    iV = IntVector.fromArray(SPECIES_512, in, inpos + 112);
    oV = iV.and(MASK_28).lanewise(VectorOperators.LSHL, 4).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_512;

    oV = oV.zero(SPECIES_512);

    iV = IntVector.fromArray(SPECIES_512, in, inpos + 128);
    oV = iV.and(MASK_28).or(oV);

    iV = IntVector.fromArray(SPECIES_512, in, inpos + 144);
    oV = iV.and(MASK_28).lanewise(VectorOperators.LSHL, 28).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_512;

    oV = iV.and(MASK_28).lanewise(VectorOperators.LSHR, 4);

    iV = IntVector.fromArray(SPECIES_512, in, inpos + 160);
    oV = iV.and(MASK_28).lanewise(VectorOperators.LSHL, 24).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_512;

    oV = iV.and(MASK_28).lanewise(VectorOperators.LSHR, 8);

    iV = IntVector.fromArray(SPECIES_512, in, inpos + 176);
    oV = iV.and(MASK_28).lanewise(VectorOperators.LSHL, 20).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_512;

    oV = iV.and(MASK_28).lanewise(VectorOperators.LSHR, 12);

    iV = IntVector.fromArray(SPECIES_512, in, inpos + 192);
    oV = iV.and(MASK_28).lanewise(VectorOperators.LSHL, 16).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_512;

    oV = iV.and(MASK_28).lanewise(VectorOperators.LSHR, 16);

    iV = IntVector.fromArray(SPECIES_512, in, inpos + 208);
    oV = iV.and(MASK_28).lanewise(VectorOperators.LSHL, 12).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_512;

    oV = iV.and(MASK_28).lanewise(VectorOperators.LSHR, 20);

    iV = IntVector.fromArray(SPECIES_512, in, inpos + 224);
    oV = iV.and(MASK_28).lanewise(VectorOperators.LSHL, 8).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_512;

    oV = iV.and(MASK_28).lanewise(VectorOperators.LSHR, 24);

    iV = IntVector.fromArray(SPECIES_512, in, inpos + 240);
    oV = iV.and(MASK_28).lanewise(VectorOperators.LSHL, 4).or(oV);

    oV.intoArray(out, outpos);
  }

  private static void fastpack29(final int[] in, int inpos, final int[] out,
                                 int outpos) {
    var iV = IntVector.fromArray(SPECIES_256, in, inpos);
    var oV = iV.and(MASK_29);
    iV = IntVector.fromArray(SPECIES_256, in, inpos + 8);
    oV = iV.and(MASK_29).lanewise(VectorOperators.LSHL, 29).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.and(MASK_29).lanewise(VectorOperators.LSHR, 3);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 16);
    oV = iV.and(MASK_29).lanewise(VectorOperators.LSHL, 26).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.and(MASK_29).lanewise(VectorOperators.LSHR, 6);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 24);
    oV = iV.and(MASK_29).lanewise(VectorOperators.LSHL, 23).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.and(MASK_29).lanewise(VectorOperators.LSHR, 9);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 32);
    oV = iV.and(MASK_29).lanewise(VectorOperators.LSHL, 20).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.and(MASK_29).lanewise(VectorOperators.LSHR, 12);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 40);
    oV = iV.and(MASK_29).lanewise(VectorOperators.LSHL, 17).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.and(MASK_29).lanewise(VectorOperators.LSHR, 15);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 48);
    oV = iV.and(MASK_29).lanewise(VectorOperators.LSHL, 14).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.and(MASK_29).lanewise(VectorOperators.LSHR, 18);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 56);
    oV = iV.and(MASK_29).lanewise(VectorOperators.LSHL, 11).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.and(MASK_29).lanewise(VectorOperators.LSHR, 21);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 64);
    oV = iV.and(MASK_29).lanewise(VectorOperators.LSHL, 8).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.and(MASK_29).lanewise(VectorOperators.LSHR, 24);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 72);
    oV = iV.and(MASK_29).lanewise(VectorOperators.LSHL, 5).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.and(MASK_29).lanewise(VectorOperators.LSHR, 27);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 80);
    oV = iV.and(MASK_29).lanewise(VectorOperators.LSHL, 2).or(oV);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 88);
    oV = iV.and(MASK_29).lanewise(VectorOperators.LSHL, 31).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.and(MASK_29).lanewise(VectorOperators.LSHR, 1);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 96);
    oV = iV.and(MASK_29).lanewise(VectorOperators.LSHL, 28).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.and(MASK_29).lanewise(VectorOperators.LSHR, 4);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 104);
    oV = iV.and(MASK_29).lanewise(VectorOperators.LSHL, 25).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.and(MASK_29).lanewise(VectorOperators.LSHR, 7);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 112);
    oV = iV.and(MASK_29).lanewise(VectorOperators.LSHL, 22).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.and(MASK_29).lanewise(VectorOperators.LSHR, 10);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 120);
    oV = iV.and(MASK_29).lanewise(VectorOperators.LSHL, 19).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.and(MASK_29).lanewise(VectorOperators.LSHR, 13);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 128);
    oV = iV.and(MASK_29).lanewise(VectorOperators.LSHL, 16).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.and(MASK_29).lanewise(VectorOperators.LSHR, 16);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 136);
    oV = iV.and(MASK_29).lanewise(VectorOperators.LSHL, 13).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.and(MASK_29).lanewise(VectorOperators.LSHR, 19);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 144);
    oV = iV.and(MASK_29).lanewise(VectorOperators.LSHL, 10).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.and(MASK_29).lanewise(VectorOperators.LSHR, 22);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 152);
    oV = iV.and(MASK_29).lanewise(VectorOperators.LSHL, 7).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.and(MASK_29).lanewise(VectorOperators.LSHR, 25);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 160);
    oV = iV.and(MASK_29).lanewise(VectorOperators.LSHL, 4).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.and(MASK_29).lanewise(VectorOperators.LSHR, 28);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 168);
    oV = iV.and(MASK_29).lanewise(VectorOperators.LSHL, 1).or(oV);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 176);
    oV = iV.and(MASK_29).lanewise(VectorOperators.LSHL, 30).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.and(MASK_29).lanewise(VectorOperators.LSHR, 2);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 184);
    oV = iV.and(MASK_29).lanewise(VectorOperators.LSHL, 27).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.and(MASK_29).lanewise(VectorOperators.LSHR, 5);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 192);
    oV = iV.and(MASK_29).lanewise(VectorOperators.LSHL, 24).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.and(MASK_29).lanewise(VectorOperators.LSHR, 8);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 200);
    oV = iV.and(MASK_29).lanewise(VectorOperators.LSHL, 21).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.and(MASK_29).lanewise(VectorOperators.LSHR, 11);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 208);
    oV = iV.and(MASK_29).lanewise(VectorOperators.LSHL, 18).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.and(MASK_29).lanewise(VectorOperators.LSHR, 14);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 216);
    oV = iV.and(MASK_29).lanewise(VectorOperators.LSHL, 15).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.and(MASK_29).lanewise(VectorOperators.LSHR, 17);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 224);
    oV = iV.and(MASK_29).lanewise(VectorOperators.LSHL, 12).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.and(MASK_29).lanewise(VectorOperators.LSHR, 20);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 232);
    oV = iV.and(MASK_29).lanewise(VectorOperators.LSHL, 9).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.and(MASK_29).lanewise(VectorOperators.LSHR, 23);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 240);
    oV = iV.and(MASK_29).lanewise(VectorOperators.LSHL, 6).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.and(MASK_29).lanewise(VectorOperators.LSHR, 26);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 248);
    oV = iV.and(MASK_29).lanewise(VectorOperators.LSHL, 3).or(oV);

    oV.intoArray(out, outpos);
  }

  private static void fastpack30(final int[] in, int inpos, final int[] out,
                                 int outpos) {
    var iV = IntVector.fromArray(SPECIES_512, in, inpos);
    var oV = iV.and(MASK_30);
    iV = IntVector.fromArray(SPECIES_512, in, inpos + 16);
    oV = iV.and(MASK_30).lanewise(VectorOperators.LSHL, 30).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_512;
    oV = iV.and(MASK_30).lanewise(VectorOperators.LSHR, 2);

    iV = IntVector.fromArray(SPECIES_512, in, inpos + 32);
    oV = iV.and(MASK_30).lanewise(VectorOperators.LSHL, 28).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_512;

    oV = iV.and(MASK_30).lanewise(VectorOperators.LSHR, 4);

    iV = IntVector.fromArray(SPECIES_512, in, inpos + 48);
    oV = iV.and(MASK_30).lanewise(VectorOperators.LSHL, 26).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_512;

    oV = iV.and(MASK_30).lanewise(VectorOperators.LSHR, 6);

    iV = IntVector.fromArray(SPECIES_512, in, inpos + 64);
    oV = iV.and(MASK_30).lanewise(VectorOperators.LSHL, 24).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_512;

    oV = iV.and(MASK_30).lanewise(VectorOperators.LSHR, 8);

    iV = IntVector.fromArray(SPECIES_512, in, inpos + 80);
    oV = iV.and(MASK_30).lanewise(VectorOperators.LSHL, 22).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_512;

    oV = iV.and(MASK_30).lanewise(VectorOperators.LSHR, 10);

    iV = IntVector.fromArray(SPECIES_512, in, inpos + 96);
    oV = iV.and(MASK_30).lanewise(VectorOperators.LSHL, 20).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_512;

    oV = iV.and(MASK_30).lanewise(VectorOperators.LSHR, 12);

    iV = IntVector.fromArray(SPECIES_512, in, inpos + 112);
    oV = iV.and(MASK_30).lanewise(VectorOperators.LSHL, 18).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_512;

    oV = iV.and(MASK_30).lanewise(VectorOperators.LSHR, 14);

    iV = IntVector.fromArray(SPECIES_512, in, inpos + 128);
    oV = iV.and(MASK_30).lanewise(VectorOperators.LSHL, 16).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_512;

    oV = iV.and(MASK_30).lanewise(VectorOperators.LSHR, 16);

    iV = IntVector.fromArray(SPECIES_512, in, inpos + 144);
    oV = iV.and(MASK_30).lanewise(VectorOperators.LSHL, 14).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_512;

    oV = iV.and(MASK_30).lanewise(VectorOperators.LSHR, 18);

    iV = IntVector.fromArray(SPECIES_512, in, inpos + 160);
    oV = iV.and(MASK_30).lanewise(VectorOperators.LSHL, 12).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_512;

    oV = iV.and(MASK_30).lanewise(VectorOperators.LSHR, 20);

    iV = IntVector.fromArray(SPECIES_512, in, inpos + 176);
    oV = iV.and(MASK_30).lanewise(VectorOperators.LSHL, 10).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_512;

    oV = iV.and(MASK_30).lanewise(VectorOperators.LSHR, 22);

    iV = IntVector.fromArray(SPECIES_512, in, inpos + 192);
    oV = iV.and(MASK_30).lanewise(VectorOperators.LSHL, 8).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_512;

    oV = iV.and(MASK_30).lanewise(VectorOperators.LSHR, 24);

    iV = IntVector.fromArray(SPECIES_512, in, inpos + 208);
    oV = iV.and(MASK_30).lanewise(VectorOperators.LSHL, 6).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_512;

    oV = iV.and(MASK_30).lanewise(VectorOperators.LSHR, 26);

    iV = IntVector.fromArray(SPECIES_512, in, inpos + 224);
    oV = iV.and(MASK_30).lanewise(VectorOperators.LSHL, 4).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_512;

    oV = iV.and(MASK_30).lanewise(VectorOperators.LSHR, 28);

    iV = IntVector.fromArray(SPECIES_512, in, inpos + 240);
    oV = iV.and(MASK_30).lanewise(VectorOperators.LSHL, 2).or(oV);

    oV.intoArray(out, outpos);
  }

  private static void fastpack31(final int[] in, int inpos, final int[] out,
                                 int outpos) {
    var iV = IntVector.fromArray(SPECIES_256, in, inpos);
    var oV = iV.and(MASK_31);
    iV = IntVector.fromArray(SPECIES_256, in, inpos + 8);
    oV = iV.and(MASK_31).lanewise(VectorOperators.LSHL, 31).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.and(MASK_31).lanewise(VectorOperators.LSHR, 1);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 16);
    oV = iV.and(MASK_31).lanewise(VectorOperators.LSHL, 30).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.and(MASK_31).lanewise(VectorOperators.LSHR, 2);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 24);
    oV = iV.and(MASK_31).lanewise(VectorOperators.LSHL, 29).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.and(MASK_31).lanewise(VectorOperators.LSHR, 3);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 32);
    oV = iV.and(MASK_31).lanewise(VectorOperators.LSHL, 28).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.and(MASK_31).lanewise(VectorOperators.LSHR, 4);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 40);
    oV = iV.and(MASK_31).lanewise(VectorOperators.LSHL, 27).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.and(MASK_31).lanewise(VectorOperators.LSHR, 5);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 48);
    oV = iV.and(MASK_31).lanewise(VectorOperators.LSHL, 26).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.and(MASK_31).lanewise(VectorOperators.LSHR, 6);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 56);
    oV = iV.and(MASK_31).lanewise(VectorOperators.LSHL, 25).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.and(MASK_31).lanewise(VectorOperators.LSHR, 7);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 64);
    oV = iV.and(MASK_31).lanewise(VectorOperators.LSHL, 24).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.and(MASK_31).lanewise(VectorOperators.LSHR, 8);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 72);
    oV = iV.and(MASK_31).lanewise(VectorOperators.LSHL, 23).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.and(MASK_31).lanewise(VectorOperators.LSHR, 9);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 80);
    oV = iV.and(MASK_31).lanewise(VectorOperators.LSHL, 22).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.and(MASK_31).lanewise(VectorOperators.LSHR, 10);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 88);
    oV = iV.and(MASK_31).lanewise(VectorOperators.LSHL, 21).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.and(MASK_31).lanewise(VectorOperators.LSHR, 11);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 96);
    oV = iV.and(MASK_31).lanewise(VectorOperators.LSHL, 20).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.and(MASK_31).lanewise(VectorOperators.LSHR, 12);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 104);
    oV = iV.and(MASK_31).lanewise(VectorOperators.LSHL, 19).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.and(MASK_31).lanewise(VectorOperators.LSHR, 13);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 112);
    oV = iV.and(MASK_31).lanewise(VectorOperators.LSHL, 18).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.and(MASK_31).lanewise(VectorOperators.LSHR, 14);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 120);
    oV = iV.and(MASK_31).lanewise(VectorOperators.LSHL, 17).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.and(MASK_31).lanewise(VectorOperators.LSHR, 15);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 128);
    oV = iV.and(MASK_31).lanewise(VectorOperators.LSHL, 16).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.and(MASK_31).lanewise(VectorOperators.LSHR, 16);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 136);
    oV = iV.and(MASK_31).lanewise(VectorOperators.LSHL, 15).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.and(MASK_31).lanewise(VectorOperators.LSHR, 17);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 144);
    oV = iV.and(MASK_31).lanewise(VectorOperators.LSHL, 14).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.and(MASK_31).lanewise(VectorOperators.LSHR, 18);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 152);
    oV = iV.and(MASK_31).lanewise(VectorOperators.LSHL, 13).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.and(MASK_31).lanewise(VectorOperators.LSHR, 19);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 160);
    oV = iV.and(MASK_31).lanewise(VectorOperators.LSHL, 12).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.and(MASK_31).lanewise(VectorOperators.LSHR, 20);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 168);
    oV = iV.and(MASK_31).lanewise(VectorOperators.LSHL, 11).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.and(MASK_31).lanewise(VectorOperators.LSHR, 21);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 176);
    oV = iV.and(MASK_31).lanewise(VectorOperators.LSHL, 10).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.and(MASK_31).lanewise(VectorOperators.LSHR, 22);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 184);
    oV = iV.and(MASK_31).lanewise(VectorOperators.LSHL, 9).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.and(MASK_31).lanewise(VectorOperators.LSHR, 23);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 192);
    oV = iV.and(MASK_31).lanewise(VectorOperators.LSHL, 8).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.and(MASK_31).lanewise(VectorOperators.LSHR, 24);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 200);
    oV = iV.and(MASK_31).lanewise(VectorOperators.LSHL, 7).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.and(MASK_31).lanewise(VectorOperators.LSHR, 25);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 208);
    oV = iV.and(MASK_31).lanewise(VectorOperators.LSHL, 6).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.and(MASK_31).lanewise(VectorOperators.LSHR, 26);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 216);
    oV = iV.and(MASK_31).lanewise(VectorOperators.LSHL, 5).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.and(MASK_31).lanewise(VectorOperators.LSHR, 27);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 224);
    oV = iV.and(MASK_31).lanewise(VectorOperators.LSHL, 4).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.and(MASK_31).lanewise(VectorOperators.LSHR, 28);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 232);
    oV = iV.and(MASK_31).lanewise(VectorOperators.LSHL, 3).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.and(MASK_31).lanewise(VectorOperators.LSHR, 29);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 240);
    oV = iV.and(MASK_31).lanewise(VectorOperators.LSHL, 2).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.and(MASK_31).lanewise(VectorOperators.LSHR, 30);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 248);
    oV = iV.and(MASK_31).lanewise(VectorOperators.LSHL, 1).or(oV);

    oV.intoArray(out, outpos);
  }

  private static void fastpackNoMask1(final int[] in, int inpos,
                                      final int[] out, int outpos) {
    var iV = IntVector.fromArray(SPECIES_256, in, inpos);
    var oV = iV;
    iV = IntVector.fromArray(SPECIES_256, in, inpos + 8);
    oV = iV.lanewise(VectorOperators.LSHL, 1).or(oV);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 16);
    oV = iV.lanewise(VectorOperators.LSHL, 2).or(oV);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 24);
    oV = iV.lanewise(VectorOperators.LSHL, 3).or(oV);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 32);
    oV = iV.lanewise(VectorOperators.LSHL, 4).or(oV);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 40);
    oV = iV.lanewise(VectorOperators.LSHL, 5).or(oV);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 48);
    oV = iV.lanewise(VectorOperators.LSHL, 6).or(oV);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 56);
    oV = iV.lanewise(VectorOperators.LSHL, 7).or(oV);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 64);
    oV = iV.lanewise(VectorOperators.LSHL, 8).or(oV);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 72);
    oV = iV.lanewise(VectorOperators.LSHL, 9).or(oV);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 80);
    oV = iV.lanewise(VectorOperators.LSHL, 10).or(oV);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 88);
    oV = iV.lanewise(VectorOperators.LSHL, 11).or(oV);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 96);
    oV = iV.lanewise(VectorOperators.LSHL, 12).or(oV);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 104);
    oV = iV.lanewise(VectorOperators.LSHL, 13).or(oV);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 112);
    oV = iV.lanewise(VectorOperators.LSHL, 14).or(oV);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 120);
    oV = iV.lanewise(VectorOperators.LSHL, 15).or(oV);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 128);
    oV = iV.lanewise(VectorOperators.LSHL, 16).or(oV);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 136);
    oV = iV.lanewise(VectorOperators.LSHL, 17).or(oV);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 144);
    oV = iV.lanewise(VectorOperators.LSHL, 18).or(oV);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 152);
    oV = iV.lanewise(VectorOperators.LSHL, 19).or(oV);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 160);
    oV = iV.lanewise(VectorOperators.LSHL, 20).or(oV);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 168);
    oV = iV.lanewise(VectorOperators.LSHL, 21).or(oV);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 176);
    oV = iV.lanewise(VectorOperators.LSHL, 22).or(oV);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 184);
    oV = iV.lanewise(VectorOperators.LSHL, 23).or(oV);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 192);
    oV = iV.lanewise(VectorOperators.LSHL, 24).or(oV);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 200);
    oV = iV.lanewise(VectorOperators.LSHL, 25).or(oV);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 208);
    oV = iV.lanewise(VectorOperators.LSHL, 26).or(oV);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 216);
    oV = iV.lanewise(VectorOperators.LSHL, 27).or(oV);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 224);
    oV = iV.lanewise(VectorOperators.LSHL, 28).or(oV);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 232);
    oV = iV.lanewise(VectorOperators.LSHL, 29).or(oV);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 240);
    oV = iV.lanewise(VectorOperators.LSHL, 30).or(oV);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 248);
    oV = iV.lanewise(VectorOperators.LSHL, 31).or(oV);

    oV.intoArray(out, outpos);
  }

  private static void fastpackNoMask2(final int[] in, int inpos,
                                      final int[] out, int outpos) {
    var iV = IntVector.fromArray(SPECIES_512, in, inpos);
    var oV = iV;
    iV = IntVector.fromArray(SPECIES_512, in, inpos + 16);
    oV = iV.lanewise(VectorOperators.LSHL, 2).or(oV);

    iV = IntVector.fromArray(SPECIES_512, in, inpos + 32);
    oV = iV.lanewise(VectorOperators.LSHL, 4).or(oV);

    iV = IntVector.fromArray(SPECIES_512, in, inpos + 48);
    oV = iV.lanewise(VectorOperators.LSHL, 6).or(oV);

    iV = IntVector.fromArray(SPECIES_512, in, inpos + 64);
    oV = iV.lanewise(VectorOperators.LSHL, 8).or(oV);

    iV = IntVector.fromArray(SPECIES_512, in, inpos + 80);
    oV = iV.lanewise(VectorOperators.LSHL, 10).or(oV);

    iV = IntVector.fromArray(SPECIES_512, in, inpos + 96);
    oV = iV.lanewise(VectorOperators.LSHL, 12).or(oV);

    iV = IntVector.fromArray(SPECIES_512, in, inpos + 112);
    oV = iV.lanewise(VectorOperators.LSHL, 14).or(oV);

    iV = IntVector.fromArray(SPECIES_512, in, inpos + 128);
    oV = iV.lanewise(VectorOperators.LSHL, 16).or(oV);

    iV = IntVector.fromArray(SPECIES_512, in, inpos + 144);
    oV = iV.lanewise(VectorOperators.LSHL, 18).or(oV);

    iV = IntVector.fromArray(SPECIES_512, in, inpos + 160);
    oV = iV.lanewise(VectorOperators.LSHL, 20).or(oV);

    iV = IntVector.fromArray(SPECIES_512, in, inpos + 176);
    oV = iV.lanewise(VectorOperators.LSHL, 22).or(oV);

    iV = IntVector.fromArray(SPECIES_512, in, inpos + 192);
    oV = iV.lanewise(VectorOperators.LSHL, 24).or(oV);

    iV = IntVector.fromArray(SPECIES_512, in, inpos + 208);
    oV = iV.lanewise(VectorOperators.LSHL, 26).or(oV);

    iV = IntVector.fromArray(SPECIES_512, in, inpos + 224);
    oV = iV.lanewise(VectorOperators.LSHL, 28).or(oV);

    iV = IntVector.fromArray(SPECIES_512, in, inpos + 240);
    oV = iV.lanewise(VectorOperators.LSHL, 30).or(oV);

    oV.intoArray(out, outpos);
  }

  private static void fastpackNoMask3(final int[] in, int inpos,
                                      final int[] out, int outpos) {
    var iV = IntVector.fromArray(SPECIES_256, in, inpos);
    var oV = iV;
    iV = IntVector.fromArray(SPECIES_256, in, inpos + 8);
    oV = iV.lanewise(VectorOperators.LSHL, 3).or(oV);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 16);
    oV = iV.lanewise(VectorOperators.LSHL, 6).or(oV);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 24);
    oV = iV.lanewise(VectorOperators.LSHL, 9).or(oV);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 32);
    oV = iV.lanewise(VectorOperators.LSHL, 12).or(oV);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 40);
    oV = iV.lanewise(VectorOperators.LSHL, 15).or(oV);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 48);
    oV = iV.lanewise(VectorOperators.LSHL, 18).or(oV);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 56);
    oV = iV.lanewise(VectorOperators.LSHL, 21).or(oV);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 64);
    oV = iV.lanewise(VectorOperators.LSHL, 24).or(oV);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 72);
    oV = iV.lanewise(VectorOperators.LSHL, 27).or(oV);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 80);
    oV = iV.lanewise(VectorOperators.LSHL, 30).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.lanewise(VectorOperators.LSHR, 2);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 88);
    oV = iV.lanewise(VectorOperators.LSHL, 1).or(oV);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 96);
    oV = iV.lanewise(VectorOperators.LSHL, 4).or(oV);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 104);
    oV = iV.lanewise(VectorOperators.LSHL, 7).or(oV);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 112);
    oV = iV.lanewise(VectorOperators.LSHL, 10).or(oV);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 120);
    oV = iV.lanewise(VectorOperators.LSHL, 13).or(oV);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 128);
    oV = iV.lanewise(VectorOperators.LSHL, 16).or(oV);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 136);
    oV = iV.lanewise(VectorOperators.LSHL, 19).or(oV);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 144);
    oV = iV.lanewise(VectorOperators.LSHL, 22).or(oV);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 152);
    oV = iV.lanewise(VectorOperators.LSHL, 25).or(oV);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 160);
    oV = iV.lanewise(VectorOperators.LSHL, 28).or(oV);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 168);
    oV = iV.lanewise(VectorOperators.LSHL, 31).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.lanewise(VectorOperators.LSHR, 1);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 176);
    oV = iV.lanewise(VectorOperators.LSHL, 2).or(oV);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 184);
    oV = iV.lanewise(VectorOperators.LSHL, 5).or(oV);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 192);
    oV = iV.lanewise(VectorOperators.LSHL, 8).or(oV);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 200);
    oV = iV.lanewise(VectorOperators.LSHL, 11).or(oV);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 208);
    oV = iV.lanewise(VectorOperators.LSHL, 14).or(oV);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 216);
    oV = iV.lanewise(VectorOperators.LSHL, 17).or(oV);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 224);
    oV = iV.lanewise(VectorOperators.LSHL, 20).or(oV);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 232);
    oV = iV.lanewise(VectorOperators.LSHL, 23).or(oV);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 240);
    oV = iV.lanewise(VectorOperators.LSHL, 26).or(oV);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 248);
    oV = iV.lanewise(VectorOperators.LSHL, 29).or(oV);

    oV.intoArray(out, outpos);
  }

  private static void fastpackNoMask4(final int[] in, int inpos,
                                      final int[] out, int outpos) {
    var iV = IntVector.fromArray(SPECIES_512, in, inpos);
    var oV = iV;
    iV = IntVector.fromArray(SPECIES_512, in, inpos + 16);
    oV = iV.lanewise(VectorOperators.LSHL, 4).or(oV);

    iV = IntVector.fromArray(SPECIES_512, in, inpos + 32);
    oV = iV.lanewise(VectorOperators.LSHL, 8).or(oV);

    iV = IntVector.fromArray(SPECIES_512, in, inpos + 48);
    oV = iV.lanewise(VectorOperators.LSHL, 12).or(oV);

    iV = IntVector.fromArray(SPECIES_512, in, inpos + 64);
    oV = iV.lanewise(VectorOperators.LSHL, 16).or(oV);

    iV = IntVector.fromArray(SPECIES_512, in, inpos + 80);
    oV = iV.lanewise(VectorOperators.LSHL, 20).or(oV);

    iV = IntVector.fromArray(SPECIES_512, in, inpos + 96);
    oV = iV.lanewise(VectorOperators.LSHL, 24).or(oV);

    iV = IntVector.fromArray(SPECIES_512, in, inpos + 112);
    oV = iV.lanewise(VectorOperators.LSHL, 28).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_512;
    oV = oV.zero(SPECIES_512);

    iV = IntVector.fromArray(SPECIES_512, in, inpos + 128);
    oV = iV.or(oV);

    iV = IntVector.fromArray(SPECIES_512, in, inpos + 144);
    oV = iV.lanewise(VectorOperators.LSHL, 4).or(oV);

    iV = IntVector.fromArray(SPECIES_512, in, inpos + 160);
    oV = iV.lanewise(VectorOperators.LSHL, 8).or(oV);

    iV = IntVector.fromArray(SPECIES_512, in, inpos + 176);
    oV = iV.lanewise(VectorOperators.LSHL, 12).or(oV);

    iV = IntVector.fromArray(SPECIES_512, in, inpos + 192);
    oV = iV.lanewise(VectorOperators.LSHL, 16).or(oV);

    iV = IntVector.fromArray(SPECIES_512, in, inpos + 208);
    oV = iV.lanewise(VectorOperators.LSHL, 20).or(oV);

    iV = IntVector.fromArray(SPECIES_512, in, inpos + 224);
    oV = iV.lanewise(VectorOperators.LSHL, 24).or(oV);

    iV = IntVector.fromArray(SPECIES_512, in, inpos + 240);
    oV = iV.lanewise(VectorOperators.LSHL, 28).or(oV);

    oV.intoArray(out, outpos);
  }

  private static void fastpackNoMask5(final int[] in, int inpos,
                                      final int[] out, int outpos) {
    var iV = IntVector.fromArray(SPECIES_256, in, inpos);
    var oV = iV;
    iV = IntVector.fromArray(SPECIES_256, in, inpos + 8);
    oV = iV.lanewise(VectorOperators.LSHL, 5).or(oV);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 16);
    oV = iV.lanewise(VectorOperators.LSHL, 10).or(oV);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 24);
    oV = iV.lanewise(VectorOperators.LSHL, 15).or(oV);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 32);
    oV = iV.lanewise(VectorOperators.LSHL, 20).or(oV);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 40);
    oV = iV.lanewise(VectorOperators.LSHL, 25).or(oV);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 48);
    oV = iV.lanewise(VectorOperators.LSHL, 30).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.lanewise(VectorOperators.LSHR, 2);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 56);
    oV = iV.lanewise(VectorOperators.LSHL, 3).or(oV);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 64);
    oV = iV.lanewise(VectorOperators.LSHL, 8).or(oV);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 72);
    oV = iV.lanewise(VectorOperators.LSHL, 13).or(oV);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 80);
    oV = iV.lanewise(VectorOperators.LSHL, 18).or(oV);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 88);
    oV = iV.lanewise(VectorOperators.LSHL, 23).or(oV);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 96);
    oV = iV.lanewise(VectorOperators.LSHL, 28).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.lanewise(VectorOperators.LSHR, 4);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 104);
    oV = iV.lanewise(VectorOperators.LSHL, 1).or(oV);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 112);
    oV = iV.lanewise(VectorOperators.LSHL, 6).or(oV);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 120);
    oV = iV.lanewise(VectorOperators.LSHL, 11).or(oV);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 128);
    oV = iV.lanewise(VectorOperators.LSHL, 16).or(oV);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 136);
    oV = iV.lanewise(VectorOperators.LSHL, 21).or(oV);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 144);
    oV = iV.lanewise(VectorOperators.LSHL, 26).or(oV);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 152);
    oV = iV.lanewise(VectorOperators.LSHL, 31).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.lanewise(VectorOperators.LSHR, 1);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 160);
    oV = iV.lanewise(VectorOperators.LSHL, 4).or(oV);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 168);
    oV = iV.lanewise(VectorOperators.LSHL, 9).or(oV);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 176);
    oV = iV.lanewise(VectorOperators.LSHL, 14).or(oV);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 184);
    oV = iV.lanewise(VectorOperators.LSHL, 19).or(oV);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 192);
    oV = iV.lanewise(VectorOperators.LSHL, 24).or(oV);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 200);
    oV = iV.lanewise(VectorOperators.LSHL, 29).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.lanewise(VectorOperators.LSHR, 3);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 208);
    oV = iV.lanewise(VectorOperators.LSHL, 2).or(oV);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 216);
    oV = iV.lanewise(VectorOperators.LSHL, 7).or(oV);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 224);
    oV = iV.lanewise(VectorOperators.LSHL, 12).or(oV);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 232);
    oV = iV.lanewise(VectorOperators.LSHL, 17).or(oV);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 240);
    oV = iV.lanewise(VectorOperators.LSHL, 22).or(oV);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 248);
    oV = iV.lanewise(VectorOperators.LSHL, 27).or(oV);

    oV.intoArray(out, outpos);
  }

  private static void fastpackNoMask6(final int[] in, int inpos,
                                      final int[] out, int outpos) {
    var iV = IntVector.fromArray(SPECIES_512, in, inpos);
    var oV = iV;
    iV = IntVector.fromArray(SPECIES_512, in, inpos + 16);
    oV = iV.lanewise(VectorOperators.LSHL, 6).or(oV);

    iV = IntVector.fromArray(SPECIES_512, in, inpos + 32);
    oV = iV.lanewise(VectorOperators.LSHL, 12).or(oV);

    iV = IntVector.fromArray(SPECIES_512, in, inpos + 48);
    oV = iV.lanewise(VectorOperators.LSHL, 18).or(oV);

    iV = IntVector.fromArray(SPECIES_512, in, inpos + 64);
    oV = iV.lanewise(VectorOperators.LSHL, 24).or(oV);

    iV = IntVector.fromArray(SPECIES_512, in, inpos + 80);
    oV = iV.lanewise(VectorOperators.LSHL, 30).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_512;
    oV = iV.lanewise(VectorOperators.LSHR, 2);

    iV = IntVector.fromArray(SPECIES_512, in, inpos + 96);
    oV = iV.lanewise(VectorOperators.LSHL, 4).or(oV);

    iV = IntVector.fromArray(SPECIES_512, in, inpos + 112);
    oV = iV.lanewise(VectorOperators.LSHL, 10).or(oV);

    iV = IntVector.fromArray(SPECIES_512, in, inpos + 128);
    oV = iV.lanewise(VectorOperators.LSHL, 16).or(oV);

    iV = IntVector.fromArray(SPECIES_512, in, inpos + 144);
    oV = iV.lanewise(VectorOperators.LSHL, 22).or(oV);

    iV = IntVector.fromArray(SPECIES_512, in, inpos + 160);
    oV = iV.lanewise(VectorOperators.LSHL, 28).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_512;

    oV = iV.lanewise(VectorOperators.LSHR, 4);

    iV = IntVector.fromArray(SPECIES_512, in, inpos + 176);
    oV = iV.lanewise(VectorOperators.LSHL, 2).or(oV);

    iV = IntVector.fromArray(SPECIES_512, in, inpos + 192);
    oV = iV.lanewise(VectorOperators.LSHL, 8).or(oV);

    iV = IntVector.fromArray(SPECIES_512, in, inpos + 208);
    oV = iV.lanewise(VectorOperators.LSHL, 14).or(oV);

    iV = IntVector.fromArray(SPECIES_512, in, inpos + 224);
    oV = iV.lanewise(VectorOperators.LSHL, 20).or(oV);

    iV = IntVector.fromArray(SPECIES_512, in, inpos + 240);
    oV = iV.lanewise(VectorOperators.LSHL, 26).or(oV);

    oV.intoArray(out, outpos);
  }

  private static void fastpackNoMask7(final int[] in, int inpos,
                                      final int[] out, int outpos) {
    var iV = IntVector.fromArray(SPECIES_256, in, inpos);
    var oV = iV;
    iV = IntVector.fromArray(SPECIES_256, in, inpos + 8);
    oV = iV.lanewise(VectorOperators.LSHL, 7).or(oV);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 16);
    oV = iV.lanewise(VectorOperators.LSHL, 14).or(oV);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 24);
    oV = iV.lanewise(VectorOperators.LSHL, 21).or(oV);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 32);
    oV = iV.lanewise(VectorOperators.LSHL, 28).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.lanewise(VectorOperators.LSHR, 4);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 40);
    oV = iV.lanewise(VectorOperators.LSHL, 3).or(oV);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 48);
    oV = iV.lanewise(VectorOperators.LSHL, 10).or(oV);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 56);
    oV = iV.lanewise(VectorOperators.LSHL, 17).or(oV);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 64);
    oV = iV.lanewise(VectorOperators.LSHL, 24).or(oV);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 72);
    oV = iV.lanewise(VectorOperators.LSHL, 31).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.lanewise(VectorOperators.LSHR, 1);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 80);
    oV = iV.lanewise(VectorOperators.LSHL, 6).or(oV);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 88);
    oV = iV.lanewise(VectorOperators.LSHL, 13).or(oV);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 96);
    oV = iV.lanewise(VectorOperators.LSHL, 20).or(oV);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 104);
    oV = iV.lanewise(VectorOperators.LSHL, 27).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.lanewise(VectorOperators.LSHR, 5);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 112);
    oV = iV.lanewise(VectorOperators.LSHL, 2).or(oV);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 120);
    oV = iV.lanewise(VectorOperators.LSHL, 9).or(oV);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 128);
    oV = iV.lanewise(VectorOperators.LSHL, 16).or(oV);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 136);
    oV = iV.lanewise(VectorOperators.LSHL, 23).or(oV);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 144);
    oV = iV.lanewise(VectorOperators.LSHL, 30).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.lanewise(VectorOperators.LSHR, 2);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 152);
    oV = iV.lanewise(VectorOperators.LSHL, 5).or(oV);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 160);
    oV = iV.lanewise(VectorOperators.LSHL, 12).or(oV);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 168);
    oV = iV.lanewise(VectorOperators.LSHL, 19).or(oV);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 176);
    oV = iV.lanewise(VectorOperators.LSHL, 26).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.lanewise(VectorOperators.LSHR, 6);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 184);
    oV = iV.lanewise(VectorOperators.LSHL, 1).or(oV);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 192);
    oV = iV.lanewise(VectorOperators.LSHL, 8).or(oV);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 200);
    oV = iV.lanewise(VectorOperators.LSHL, 15).or(oV);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 208);
    oV = iV.lanewise(VectorOperators.LSHL, 22).or(oV);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 216);
    oV = iV.lanewise(VectorOperators.LSHL, 29).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.lanewise(VectorOperators.LSHR, 3);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 224);
    oV = iV.lanewise(VectorOperators.LSHL, 4).or(oV);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 232);
    oV = iV.lanewise(VectorOperators.LSHL, 11).or(oV);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 240);
    oV = iV.lanewise(VectorOperators.LSHL, 18).or(oV);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 248);
    oV = iV.lanewise(VectorOperators.LSHL, 25).or(oV);

    oV.intoArray(out, outpos);
  }

  private static void fastpackNoMask8(final int[] in, int inpos,
                                      final int[] out, int outpos) {
    var iV = IntVector.fromArray(SPECIES_512, in, inpos);
    var oV = iV;
    iV = IntVector.fromArray(SPECIES_512, in, inpos + 16);
    oV = iV.lanewise(VectorOperators.LSHL, 8).or(oV);

    iV = IntVector.fromArray(SPECIES_512, in, inpos + 32);
    oV = iV.lanewise(VectorOperators.LSHL, 16).or(oV);

    iV = IntVector.fromArray(SPECIES_512, in, inpos + 48);
    oV = iV.lanewise(VectorOperators.LSHL, 24).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_512;
    oV = oV.zero(SPECIES_512);

    iV = IntVector.fromArray(SPECIES_512, in, inpos + 64);
    oV = iV.or(oV);

    iV = IntVector.fromArray(SPECIES_512, in, inpos + 80);
    oV = iV.lanewise(VectorOperators.LSHL, 8).or(oV);

    iV = IntVector.fromArray(SPECIES_512, in, inpos + 96);
    oV = iV.lanewise(VectorOperators.LSHL, 16).or(oV);

    iV = IntVector.fromArray(SPECIES_512, in, inpos + 112);
    oV = iV.lanewise(VectorOperators.LSHL, 24).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_512;

    oV = oV.zero(SPECIES_512);

    iV = IntVector.fromArray(SPECIES_512, in, inpos + 128);
    oV = iV.or(oV);

    iV = IntVector.fromArray(SPECIES_512, in, inpos + 144);
    oV = iV.lanewise(VectorOperators.LSHL, 8).or(oV);

    iV = IntVector.fromArray(SPECIES_512, in, inpos + 160);
    oV = iV.lanewise(VectorOperators.LSHL, 16).or(oV);

    iV = IntVector.fromArray(SPECIES_512, in, inpos + 176);
    oV = iV.lanewise(VectorOperators.LSHL, 24).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_512;

    oV = oV.zero(SPECIES_512);

    iV = IntVector.fromArray(SPECIES_512, in, inpos + 192);
    oV = iV.or(oV);

    iV = IntVector.fromArray(SPECIES_512, in, inpos + 208);
    oV = iV.lanewise(VectorOperators.LSHL, 8).or(oV);

    iV = IntVector.fromArray(SPECIES_512, in, inpos + 224);
    oV = iV.lanewise(VectorOperators.LSHL, 16).or(oV);

    iV = IntVector.fromArray(SPECIES_512, in, inpos + 240);
    oV = iV.lanewise(VectorOperators.LSHL, 24).or(oV);

    oV.intoArray(out, outpos);
  }

  private static void fastpackNoMask9(final int[] in, int inpos,
                                      final int[] out, int outpos) {
    var iV = IntVector.fromArray(SPECIES_256, in, inpos);
    var oV = iV;
    iV = IntVector.fromArray(SPECIES_256, in, inpos + 8);
    oV = iV.lanewise(VectorOperators.LSHL, 9).or(oV);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 16);
    oV = iV.lanewise(VectorOperators.LSHL, 18).or(oV);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 24);
    oV = iV.lanewise(VectorOperators.LSHL, 27).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.lanewise(VectorOperators.LSHR, 5);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 32);
    oV = iV.lanewise(VectorOperators.LSHL, 4).or(oV);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 40);
    oV = iV.lanewise(VectorOperators.LSHL, 13).or(oV);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 48);
    oV = iV.lanewise(VectorOperators.LSHL, 22).or(oV);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 56);
    oV = iV.lanewise(VectorOperators.LSHL, 31).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.lanewise(VectorOperators.LSHR, 1);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 64);
    oV = iV.lanewise(VectorOperators.LSHL, 8).or(oV);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 72);
    oV = iV.lanewise(VectorOperators.LSHL, 17).or(oV);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 80);
    oV = iV.lanewise(VectorOperators.LSHL, 26).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.lanewise(VectorOperators.LSHR, 6);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 88);
    oV = iV.lanewise(VectorOperators.LSHL, 3).or(oV);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 96);
    oV = iV.lanewise(VectorOperators.LSHL, 12).or(oV);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 104);
    oV = iV.lanewise(VectorOperators.LSHL, 21).or(oV);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 112);
    oV = iV.lanewise(VectorOperators.LSHL, 30).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.lanewise(VectorOperators.LSHR, 2);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 120);
    oV = iV.lanewise(VectorOperators.LSHL, 7).or(oV);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 128);
    oV = iV.lanewise(VectorOperators.LSHL, 16).or(oV);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 136);
    oV = iV.lanewise(VectorOperators.LSHL, 25).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.lanewise(VectorOperators.LSHR, 7);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 144);
    oV = iV.lanewise(VectorOperators.LSHL, 2).or(oV);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 152);
    oV = iV.lanewise(VectorOperators.LSHL, 11).or(oV);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 160);
    oV = iV.lanewise(VectorOperators.LSHL, 20).or(oV);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 168);
    oV = iV.lanewise(VectorOperators.LSHL, 29).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.lanewise(VectorOperators.LSHR, 3);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 176);
    oV = iV.lanewise(VectorOperators.LSHL, 6).or(oV);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 184);
    oV = iV.lanewise(VectorOperators.LSHL, 15).or(oV);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 192);
    oV = iV.lanewise(VectorOperators.LSHL, 24).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.lanewise(VectorOperators.LSHR, 8);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 200);
    oV = iV.lanewise(VectorOperators.LSHL, 1).or(oV);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 208);
    oV = iV.lanewise(VectorOperators.LSHL, 10).or(oV);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 216);
    oV = iV.lanewise(VectorOperators.LSHL, 19).or(oV);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 224);
    oV = iV.lanewise(VectorOperators.LSHL, 28).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.lanewise(VectorOperators.LSHR, 4);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 232);
    oV = iV.lanewise(VectorOperators.LSHL, 5).or(oV);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 240);
    oV = iV.lanewise(VectorOperators.LSHL, 14).or(oV);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 248);
    oV = iV.lanewise(VectorOperators.LSHL, 23).or(oV);

    oV.intoArray(out, outpos);
  }

  private static void fastpackNoMask10(final int[] in, int inpos,
                                       final int[] out, int outpos) {
    var iV = IntVector.fromArray(SPECIES_512, in, inpos);
    var oV = iV;
    iV = IntVector.fromArray(SPECIES_512, in, inpos + 16);
    oV = iV.lanewise(VectorOperators.LSHL, 10).or(oV);

    iV = IntVector.fromArray(SPECIES_512, in, inpos + 32);
    oV = iV.lanewise(VectorOperators.LSHL, 20).or(oV);

    iV = IntVector.fromArray(SPECIES_512, in, inpos + 48);
    oV = iV.lanewise(VectorOperators.LSHL, 30).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_512;
    oV = iV.lanewise(VectorOperators.LSHR, 2);

    iV = IntVector.fromArray(SPECIES_512, in, inpos + 64);
    oV = iV.lanewise(VectorOperators.LSHL, 8).or(oV);

    iV = IntVector.fromArray(SPECIES_512, in, inpos + 80);
    oV = iV.lanewise(VectorOperators.LSHL, 18).or(oV);

    iV = IntVector.fromArray(SPECIES_512, in, inpos + 96);
    oV = iV.lanewise(VectorOperators.LSHL, 28).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_512;

    oV = iV.lanewise(VectorOperators.LSHR, 4);

    iV = IntVector.fromArray(SPECIES_512, in, inpos + 112);
    oV = iV.lanewise(VectorOperators.LSHL, 6).or(oV);

    iV = IntVector.fromArray(SPECIES_512, in, inpos + 128);
    oV = iV.lanewise(VectorOperators.LSHL, 16).or(oV);

    iV = IntVector.fromArray(SPECIES_512, in, inpos + 144);
    oV = iV.lanewise(VectorOperators.LSHL, 26).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_512;

    oV = iV.lanewise(VectorOperators.LSHR, 6);

    iV = IntVector.fromArray(SPECIES_512, in, inpos + 160);
    oV = iV.lanewise(VectorOperators.LSHL, 4).or(oV);

    iV = IntVector.fromArray(SPECIES_512, in, inpos + 176);
    oV = iV.lanewise(VectorOperators.LSHL, 14).or(oV);

    iV = IntVector.fromArray(SPECIES_512, in, inpos + 192);
    oV = iV.lanewise(VectorOperators.LSHL, 24).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_512;

    oV = iV.lanewise(VectorOperators.LSHR, 8);

    iV = IntVector.fromArray(SPECIES_512, in, inpos + 208);
    oV = iV.lanewise(VectorOperators.LSHL, 2).or(oV);

    iV = IntVector.fromArray(SPECIES_512, in, inpos + 224);
    oV = iV.lanewise(VectorOperators.LSHL, 12).or(oV);

    iV = IntVector.fromArray(SPECIES_512, in, inpos + 240);
    oV = iV.lanewise(VectorOperators.LSHL, 22).or(oV);

    oV.intoArray(out, outpos);
  }

  private static void fastpackNoMask11(final int[] in, int inpos,
                                       final int[] out, int outpos) {
    var iV = IntVector.fromArray(SPECIES_256, in, inpos);
    var oV = iV;
    iV = IntVector.fromArray(SPECIES_256, in, inpos + 8);
    oV = iV.lanewise(VectorOperators.LSHL, 11).or(oV);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 16);
    oV = iV.lanewise(VectorOperators.LSHL, 22).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.lanewise(VectorOperators.LSHR, 10);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 24);
    oV = iV.lanewise(VectorOperators.LSHL, 1).or(oV);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 32);
    oV = iV.lanewise(VectorOperators.LSHL, 12).or(oV);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 40);
    oV = iV.lanewise(VectorOperators.LSHL, 23).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.lanewise(VectorOperators.LSHR, 9);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 48);
    oV = iV.lanewise(VectorOperators.LSHL, 2).or(oV);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 56);
    oV = iV.lanewise(VectorOperators.LSHL, 13).or(oV);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 64);
    oV = iV.lanewise(VectorOperators.LSHL, 24).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.lanewise(VectorOperators.LSHR, 8);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 72);
    oV = iV.lanewise(VectorOperators.LSHL, 3).or(oV);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 80);
    oV = iV.lanewise(VectorOperators.LSHL, 14).or(oV);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 88);
    oV = iV.lanewise(VectorOperators.LSHL, 25).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.lanewise(VectorOperators.LSHR, 7);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 96);
    oV = iV.lanewise(VectorOperators.LSHL, 4).or(oV);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 104);
    oV = iV.lanewise(VectorOperators.LSHL, 15).or(oV);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 112);
    oV = iV.lanewise(VectorOperators.LSHL, 26).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.lanewise(VectorOperators.LSHR, 6);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 120);
    oV = iV.lanewise(VectorOperators.LSHL, 5).or(oV);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 128);
    oV = iV.lanewise(VectorOperators.LSHL, 16).or(oV);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 136);
    oV = iV.lanewise(VectorOperators.LSHL, 27).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.lanewise(VectorOperators.LSHR, 5);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 144);
    oV = iV.lanewise(VectorOperators.LSHL, 6).or(oV);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 152);
    oV = iV.lanewise(VectorOperators.LSHL, 17).or(oV);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 160);
    oV = iV.lanewise(VectorOperators.LSHL, 28).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.lanewise(VectorOperators.LSHR, 4);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 168);
    oV = iV.lanewise(VectorOperators.LSHL, 7).or(oV);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 176);
    oV = iV.lanewise(VectorOperators.LSHL, 18).or(oV);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 184);
    oV = iV.lanewise(VectorOperators.LSHL, 29).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.lanewise(VectorOperators.LSHR, 3);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 192);
    oV = iV.lanewise(VectorOperators.LSHL, 8).or(oV);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 200);
    oV = iV.lanewise(VectorOperators.LSHL, 19).or(oV);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 208);
    oV = iV.lanewise(VectorOperators.LSHL, 30).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.lanewise(VectorOperators.LSHR, 2);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 216);
    oV = iV.lanewise(VectorOperators.LSHL, 9).or(oV);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 224);
    oV = iV.lanewise(VectorOperators.LSHL, 20).or(oV);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 232);
    oV = iV.lanewise(VectorOperators.LSHL, 31).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.lanewise(VectorOperators.LSHR, 1);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 240);
    oV = iV.lanewise(VectorOperators.LSHL, 10).or(oV);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 248);
    oV = iV.lanewise(VectorOperators.LSHL, 21).or(oV);

    oV.intoArray(out, outpos);
  }

  private static void fastpackNoMask12(final int[] in, int inpos,
                                       final int[] out, int outpos) {
    var iV = IntVector.fromArray(SPECIES_512, in, inpos);
    var oV = iV;
    iV = IntVector.fromArray(SPECIES_512, in, inpos + 16);
    oV = iV.lanewise(VectorOperators.LSHL, 12).or(oV);

    iV = IntVector.fromArray(SPECIES_512, in, inpos + 32);
    oV = iV.lanewise(VectorOperators.LSHL, 24).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_512;
    oV = iV.lanewise(VectorOperators.LSHR, 8);

    iV = IntVector.fromArray(SPECIES_512, in, inpos + 48);
    oV = iV.lanewise(VectorOperators.LSHL, 4).or(oV);

    iV = IntVector.fromArray(SPECIES_512, in, inpos + 64);
    oV = iV.lanewise(VectorOperators.LSHL, 16).or(oV);

    iV = IntVector.fromArray(SPECIES_512, in, inpos + 80);
    oV = iV.lanewise(VectorOperators.LSHL, 28).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_512;

    oV = iV.lanewise(VectorOperators.LSHR, 4);

    iV = IntVector.fromArray(SPECIES_512, in, inpos + 96);
    oV = iV.lanewise(VectorOperators.LSHL, 8).or(oV);

    iV = IntVector.fromArray(SPECIES_512, in, inpos + 112);
    oV = iV.lanewise(VectorOperators.LSHL, 20).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_512;

    oV = oV.zero(SPECIES_512);

    iV = IntVector.fromArray(SPECIES_512, in, inpos + 128);
    oV = iV.or(oV);

    iV = IntVector.fromArray(SPECIES_512, in, inpos + 144);
    oV = iV.lanewise(VectorOperators.LSHL, 12).or(oV);

    iV = IntVector.fromArray(SPECIES_512, in, inpos + 160);
    oV = iV.lanewise(VectorOperators.LSHL, 24).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_512;

    oV = iV.lanewise(VectorOperators.LSHR, 8);

    iV = IntVector.fromArray(SPECIES_512, in, inpos + 176);
    oV = iV.lanewise(VectorOperators.LSHL, 4).or(oV);

    iV = IntVector.fromArray(SPECIES_512, in, inpos + 192);
    oV = iV.lanewise(VectorOperators.LSHL, 16).or(oV);

    iV = IntVector.fromArray(SPECIES_512, in, inpos + 208);
    oV = iV.lanewise(VectorOperators.LSHL, 28).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_512;

    oV = iV.lanewise(VectorOperators.LSHR, 4);

    iV = IntVector.fromArray(SPECIES_512, in, inpos + 224);
    oV = iV.lanewise(VectorOperators.LSHL, 8).or(oV);

    iV = IntVector.fromArray(SPECIES_512, in, inpos + 240);
    oV = iV.lanewise(VectorOperators.LSHL, 20).or(oV);

    oV.intoArray(out, outpos);
  }

  private static void fastpackNoMask13(final int[] in, int inpos,
                                       final int[] out, int outpos) {
    var iV = IntVector.fromArray(SPECIES_256, in, inpos);
    var oV = iV;
    iV = IntVector.fromArray(SPECIES_256, in, inpos + 8);
    oV = iV.lanewise(VectorOperators.LSHL, 13).or(oV);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 16);
    oV = iV.lanewise(VectorOperators.LSHL, 26).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.lanewise(VectorOperators.LSHR, 6);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 24);
    oV = iV.lanewise(VectorOperators.LSHL, 7).or(oV);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 32);
    oV = iV.lanewise(VectorOperators.LSHL, 20).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.lanewise(VectorOperators.LSHR, 12);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 40);
    oV = iV.lanewise(VectorOperators.LSHL, 1).or(oV);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 48);
    oV = iV.lanewise(VectorOperators.LSHL, 14).or(oV);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 56);
    oV = iV.lanewise(VectorOperators.LSHL, 27).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.lanewise(VectorOperators.LSHR, 5);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 64);
    oV = iV.lanewise(VectorOperators.LSHL, 8).or(oV);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 72);
    oV = iV.lanewise(VectorOperators.LSHL, 21).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.lanewise(VectorOperators.LSHR, 11);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 80);
    oV = iV.lanewise(VectorOperators.LSHL, 2).or(oV);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 88);
    oV = iV.lanewise(VectorOperators.LSHL, 15).or(oV);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 96);
    oV = iV.lanewise(VectorOperators.LSHL, 28).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.lanewise(VectorOperators.LSHR, 4);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 104);
    oV = iV.lanewise(VectorOperators.LSHL, 9).or(oV);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 112);
    oV = iV.lanewise(VectorOperators.LSHL, 22).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.lanewise(VectorOperators.LSHR, 10);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 120);
    oV = iV.lanewise(VectorOperators.LSHL, 3).or(oV);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 128);
    oV = iV.lanewise(VectorOperators.LSHL, 16).or(oV);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 136);
    oV = iV.lanewise(VectorOperators.LSHL, 29).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.lanewise(VectorOperators.LSHR, 3);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 144);
    oV = iV.lanewise(VectorOperators.LSHL, 10).or(oV);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 152);
    oV = iV.lanewise(VectorOperators.LSHL, 23).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.lanewise(VectorOperators.LSHR, 9);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 160);
    oV = iV.lanewise(VectorOperators.LSHL, 4).or(oV);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 168);
    oV = iV.lanewise(VectorOperators.LSHL, 17).or(oV);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 176);
    oV = iV.lanewise(VectorOperators.LSHL, 30).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.lanewise(VectorOperators.LSHR, 2);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 184);
    oV = iV.lanewise(VectorOperators.LSHL, 11).or(oV);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 192);
    oV = iV.lanewise(VectorOperators.LSHL, 24).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.lanewise(VectorOperators.LSHR, 8);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 200);
    oV = iV.lanewise(VectorOperators.LSHL, 5).or(oV);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 208);
    oV = iV.lanewise(VectorOperators.LSHL, 18).or(oV);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 216);
    oV = iV.lanewise(VectorOperators.LSHL, 31).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.lanewise(VectorOperators.LSHR, 1);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 224);
    oV = iV.lanewise(VectorOperators.LSHL, 12).or(oV);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 232);
    oV = iV.lanewise(VectorOperators.LSHL, 25).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.lanewise(VectorOperators.LSHR, 7);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 240);
    oV = iV.lanewise(VectorOperators.LSHL, 6).or(oV);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 248);
    oV = iV.lanewise(VectorOperators.LSHL, 19).or(oV);

    oV.intoArray(out, outpos);
  }

  private static void fastpackNoMask14(final int[] in, int inpos,
                                       final int[] out, int outpos) {
    var iV = IntVector.fromArray(SPECIES_512, in, inpos);
    var oV = iV;
    iV = IntVector.fromArray(SPECIES_512, in, inpos + 16);
    oV = iV.lanewise(VectorOperators.LSHL, 14).or(oV);

    iV = IntVector.fromArray(SPECIES_512, in, inpos + 32);
    oV = iV.lanewise(VectorOperators.LSHL, 28).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_512;
    oV = iV.lanewise(VectorOperators.LSHR, 4);

    iV = IntVector.fromArray(SPECIES_512, in, inpos + 48);
    oV = iV.lanewise(VectorOperators.LSHL, 10).or(oV);

    iV = IntVector.fromArray(SPECIES_512, in, inpos + 64);
    oV = iV.lanewise(VectorOperators.LSHL, 24).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_512;

    oV = iV.lanewise(VectorOperators.LSHR, 8);

    iV = IntVector.fromArray(SPECIES_512, in, inpos + 80);
    oV = iV.lanewise(VectorOperators.LSHL, 6).or(oV);

    iV = IntVector.fromArray(SPECIES_512, in, inpos + 96);
    oV = iV.lanewise(VectorOperators.LSHL, 20).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_512;

    oV = iV.lanewise(VectorOperators.LSHR, 12);

    iV = IntVector.fromArray(SPECIES_512, in, inpos + 112);
    oV = iV.lanewise(VectorOperators.LSHL, 2).or(oV);

    iV = IntVector.fromArray(SPECIES_512, in, inpos + 128);
    oV = iV.lanewise(VectorOperators.LSHL, 16).or(oV);

    iV = IntVector.fromArray(SPECIES_512, in, inpos + 144);
    oV = iV.lanewise(VectorOperators.LSHL, 30).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_512;

    oV = iV.lanewise(VectorOperators.LSHR, 2);

    iV = IntVector.fromArray(SPECIES_512, in, inpos + 160);
    oV = iV.lanewise(VectorOperators.LSHL, 12).or(oV);

    iV = IntVector.fromArray(SPECIES_512, in, inpos + 176);
    oV = iV.lanewise(VectorOperators.LSHL, 26).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_512;

    oV = iV.lanewise(VectorOperators.LSHR, 6);

    iV = IntVector.fromArray(SPECIES_512, in, inpos + 192);
    oV = iV.lanewise(VectorOperators.LSHL, 8).or(oV);

    iV = IntVector.fromArray(SPECIES_512, in, inpos + 208);
    oV = iV.lanewise(VectorOperators.LSHL, 22).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_512;

    oV = iV.lanewise(VectorOperators.LSHR, 10);

    iV = IntVector.fromArray(SPECIES_512, in, inpos + 224);
    oV = iV.lanewise(VectorOperators.LSHL, 4).or(oV);

    iV = IntVector.fromArray(SPECIES_512, in, inpos + 240);
    oV = iV.lanewise(VectorOperators.LSHL, 18).or(oV);

    oV.intoArray(out, outpos);
  }

  private static void fastpackNoMask15(final int[] in, int inpos,
                                       final int[] out, int outpos) {
    var iV = IntVector.fromArray(SPECIES_256, in, inpos);
    var oV = iV;
    iV = IntVector.fromArray(SPECIES_256, in, inpos + 8);
    oV = iV.lanewise(VectorOperators.LSHL, 15).or(oV);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 16);
    oV = iV.lanewise(VectorOperators.LSHL, 30).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.lanewise(VectorOperators.LSHR, 2);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 24);
    oV = iV.lanewise(VectorOperators.LSHL, 13).or(oV);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 32);
    oV = iV.lanewise(VectorOperators.LSHL, 28).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.lanewise(VectorOperators.LSHR, 4);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 40);
    oV = iV.lanewise(VectorOperators.LSHL, 11).or(oV);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 48);
    oV = iV.lanewise(VectorOperators.LSHL, 26).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.lanewise(VectorOperators.LSHR, 6);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 56);
    oV = iV.lanewise(VectorOperators.LSHL, 9).or(oV);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 64);
    oV = iV.lanewise(VectorOperators.LSHL, 24).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.lanewise(VectorOperators.LSHR, 8);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 72);
    oV = iV.lanewise(VectorOperators.LSHL, 7).or(oV);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 80);
    oV = iV.lanewise(VectorOperators.LSHL, 22).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.lanewise(VectorOperators.LSHR, 10);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 88);
    oV = iV.lanewise(VectorOperators.LSHL, 5).or(oV);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 96);
    oV = iV.lanewise(VectorOperators.LSHL, 20).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.lanewise(VectorOperators.LSHR, 12);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 104);
    oV = iV.lanewise(VectorOperators.LSHL, 3).or(oV);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 112);
    oV = iV.lanewise(VectorOperators.LSHL, 18).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.lanewise(VectorOperators.LSHR, 14);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 120);
    oV = iV.lanewise(VectorOperators.LSHL, 1).or(oV);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 128);
    oV = iV.lanewise(VectorOperators.LSHL, 16).or(oV);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 136);
    oV = iV.lanewise(VectorOperators.LSHL, 31).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.lanewise(VectorOperators.LSHR, 1);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 144);
    oV = iV.lanewise(VectorOperators.LSHL, 14).or(oV);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 152);
    oV = iV.lanewise(VectorOperators.LSHL, 29).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.lanewise(VectorOperators.LSHR, 3);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 160);
    oV = iV.lanewise(VectorOperators.LSHL, 12).or(oV);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 168);
    oV = iV.lanewise(VectorOperators.LSHL, 27).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.lanewise(VectorOperators.LSHR, 5);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 176);
    oV = iV.lanewise(VectorOperators.LSHL, 10).or(oV);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 184);
    oV = iV.lanewise(VectorOperators.LSHL, 25).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.lanewise(VectorOperators.LSHR, 7);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 192);
    oV = iV.lanewise(VectorOperators.LSHL, 8).or(oV);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 200);
    oV = iV.lanewise(VectorOperators.LSHL, 23).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.lanewise(VectorOperators.LSHR, 9);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 208);
    oV = iV.lanewise(VectorOperators.LSHL, 6).or(oV);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 216);
    oV = iV.lanewise(VectorOperators.LSHL, 21).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.lanewise(VectorOperators.LSHR, 11);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 224);
    oV = iV.lanewise(VectorOperators.LSHL, 4).or(oV);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 232);
    oV = iV.lanewise(VectorOperators.LSHL, 19).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.lanewise(VectorOperators.LSHR, 13);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 240);
    oV = iV.lanewise(VectorOperators.LSHL, 2).or(oV);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 248);
    oV = iV.lanewise(VectorOperators.LSHL, 17).or(oV);

    oV.intoArray(out, outpos);
  }

  private static void fastpackNoMask16(final int[] in, int inpos,
                                       final int[] out, int outpos) {
    var iV = IntVector.fromArray(SPECIES_512, in, inpos);
    var oV = iV;
    iV = IntVector.fromArray(SPECIES_512, in, inpos + 16);
    oV = iV.lanewise(VectorOperators.LSHL, 16).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_512;
    oV = oV.zero(SPECIES_512);

    iV = IntVector.fromArray(SPECIES_512, in, inpos + 32);
    oV = iV.or(oV);

    iV = IntVector.fromArray(SPECIES_512, in, inpos + 48);
    oV = iV.lanewise(VectorOperators.LSHL, 16).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_512;

    oV = oV.zero(SPECIES_512);

    iV = IntVector.fromArray(SPECIES_512, in, inpos + 64);
    oV = iV.or(oV);

    iV = IntVector.fromArray(SPECIES_512, in, inpos + 80);
    oV = iV.lanewise(VectorOperators.LSHL, 16).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_512;

    oV = oV.zero(SPECIES_512);

    iV = IntVector.fromArray(SPECIES_512, in, inpos + 96);
    oV = iV.or(oV);

    iV = IntVector.fromArray(SPECIES_512, in, inpos + 112);
    oV = iV.lanewise(VectorOperators.LSHL, 16).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_512;

    oV = oV.zero(SPECIES_512);

    iV = IntVector.fromArray(SPECIES_512, in, inpos + 128);
    oV = iV.or(oV);

    iV = IntVector.fromArray(SPECIES_512, in, inpos + 144);
    oV = iV.lanewise(VectorOperators.LSHL, 16).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_512;

    oV = oV.zero(SPECIES_512);

    iV = IntVector.fromArray(SPECIES_512, in, inpos + 160);
    oV = iV.or(oV);

    iV = IntVector.fromArray(SPECIES_512, in, inpos + 176);
    oV = iV.lanewise(VectorOperators.LSHL, 16).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_512;

    oV = oV.zero(SPECIES_512);

    iV = IntVector.fromArray(SPECIES_512, in, inpos + 192);
    oV = iV.or(oV);

    iV = IntVector.fromArray(SPECIES_512, in, inpos + 208);
    oV = iV.lanewise(VectorOperators.LSHL, 16).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_512;

    oV = oV.zero(SPECIES_512);

    iV = IntVector.fromArray(SPECIES_512, in, inpos + 224);
    oV = iV.or(oV);

    iV = IntVector.fromArray(SPECIES_512, in, inpos + 240);
    oV = iV.lanewise(VectorOperators.LSHL, 16).or(oV);

    oV.intoArray(out, outpos);
  }

  private static void fastpackNoMask17(final int[] in, int inpos,
                                       final int[] out, int outpos) {
    var iV = IntVector.fromArray(SPECIES_256, in, inpos);
    var oV = iV;
    iV = IntVector.fromArray(SPECIES_256, in, inpos + 8);
    oV = iV.lanewise(VectorOperators.LSHL, 17).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.lanewise(VectorOperators.LSHR, 15);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 16);
    oV = iV.lanewise(VectorOperators.LSHL, 2).or(oV);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 24);
    oV = iV.lanewise(VectorOperators.LSHL, 19).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.lanewise(VectorOperators.LSHR, 13);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 32);
    oV = iV.lanewise(VectorOperators.LSHL, 4).or(oV);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 40);
    oV = iV.lanewise(VectorOperators.LSHL, 21).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.lanewise(VectorOperators.LSHR, 11);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 48);
    oV = iV.lanewise(VectorOperators.LSHL, 6).or(oV);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 56);
    oV = iV.lanewise(VectorOperators.LSHL, 23).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.lanewise(VectorOperators.LSHR, 9);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 64);
    oV = iV.lanewise(VectorOperators.LSHL, 8).or(oV);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 72);
    oV = iV.lanewise(VectorOperators.LSHL, 25).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.lanewise(VectorOperators.LSHR, 7);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 80);
    oV = iV.lanewise(VectorOperators.LSHL, 10).or(oV);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 88);
    oV = iV.lanewise(VectorOperators.LSHL, 27).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.lanewise(VectorOperators.LSHR, 5);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 96);
    oV = iV.lanewise(VectorOperators.LSHL, 12).or(oV);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 104);
    oV = iV.lanewise(VectorOperators.LSHL, 29).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.lanewise(VectorOperators.LSHR, 3);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 112);
    oV = iV.lanewise(VectorOperators.LSHL, 14).or(oV);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 120);
    oV = iV.lanewise(VectorOperators.LSHL, 31).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.lanewise(VectorOperators.LSHR, 1);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 128);
    oV = iV.lanewise(VectorOperators.LSHL, 16).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.lanewise(VectorOperators.LSHR, 16);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 136);
    oV = iV.lanewise(VectorOperators.LSHL, 1).or(oV);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 144);
    oV = iV.lanewise(VectorOperators.LSHL, 18).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.lanewise(VectorOperators.LSHR, 14);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 152);
    oV = iV.lanewise(VectorOperators.LSHL, 3).or(oV);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 160);
    oV = iV.lanewise(VectorOperators.LSHL, 20).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.lanewise(VectorOperators.LSHR, 12);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 168);
    oV = iV.lanewise(VectorOperators.LSHL, 5).or(oV);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 176);
    oV = iV.lanewise(VectorOperators.LSHL, 22).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.lanewise(VectorOperators.LSHR, 10);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 184);
    oV = iV.lanewise(VectorOperators.LSHL, 7).or(oV);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 192);
    oV = iV.lanewise(VectorOperators.LSHL, 24).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.lanewise(VectorOperators.LSHR, 8);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 200);
    oV = iV.lanewise(VectorOperators.LSHL, 9).or(oV);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 208);
    oV = iV.lanewise(VectorOperators.LSHL, 26).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.lanewise(VectorOperators.LSHR, 6);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 216);
    oV = iV.lanewise(VectorOperators.LSHL, 11).or(oV);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 224);
    oV = iV.lanewise(VectorOperators.LSHL, 28).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.lanewise(VectorOperators.LSHR, 4);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 232);
    oV = iV.lanewise(VectorOperators.LSHL, 13).or(oV);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 240);
    oV = iV.lanewise(VectorOperators.LSHL, 30).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.lanewise(VectorOperators.LSHR, 2);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 248);
    oV = iV.lanewise(VectorOperators.LSHL, 15).or(oV);

    oV.intoArray(out, outpos);
  }

  private static void fastpackNoMask18(final int[] in, int inpos,
                                       final int[] out, int outpos) {
    var iV = IntVector.fromArray(SPECIES_512, in, inpos);
    var oV = iV;
    iV = IntVector.fromArray(SPECIES_512, in, inpos + 16);
    oV = iV.lanewise(VectorOperators.LSHL, 18).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_512;
    oV = iV.lanewise(VectorOperators.LSHR, 14);

    iV = IntVector.fromArray(SPECIES_512, in, inpos + 32);
    oV = iV.lanewise(VectorOperators.LSHL, 4).or(oV);

    iV = IntVector.fromArray(SPECIES_512, in, inpos + 48);
    oV = iV.lanewise(VectorOperators.LSHL, 22).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_512;

    oV = iV.lanewise(VectorOperators.LSHR, 10);

    iV = IntVector.fromArray(SPECIES_512, in, inpos + 64);
    oV = iV.lanewise(VectorOperators.LSHL, 8).or(oV);

    iV = IntVector.fromArray(SPECIES_512, in, inpos + 80);
    oV = iV.lanewise(VectorOperators.LSHL, 26).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_512;

    oV = iV.lanewise(VectorOperators.LSHR, 6);

    iV = IntVector.fromArray(SPECIES_512, in, inpos + 96);
    oV = iV.lanewise(VectorOperators.LSHL, 12).or(oV);

    iV = IntVector.fromArray(SPECIES_512, in, inpos + 112);
    oV = iV.lanewise(VectorOperators.LSHL, 30).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_512;

    oV = iV.lanewise(VectorOperators.LSHR, 2);

    iV = IntVector.fromArray(SPECIES_512, in, inpos + 128);
    oV = iV.lanewise(VectorOperators.LSHL, 16).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_512;

    oV = iV.lanewise(VectorOperators.LSHR, 16);

    iV = IntVector.fromArray(SPECIES_512, in, inpos + 144);
    oV = iV.lanewise(VectorOperators.LSHL, 2).or(oV);

    iV = IntVector.fromArray(SPECIES_512, in, inpos + 160);
    oV = iV.lanewise(VectorOperators.LSHL, 20).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_512;

    oV = iV.lanewise(VectorOperators.LSHR, 12);

    iV = IntVector.fromArray(SPECIES_512, in, inpos + 176);
    oV = iV.lanewise(VectorOperators.LSHL, 6).or(oV);

    iV = IntVector.fromArray(SPECIES_512, in, inpos + 192);
    oV = iV.lanewise(VectorOperators.LSHL, 24).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_512;

    oV = iV.lanewise(VectorOperators.LSHR, 8);

    iV = IntVector.fromArray(SPECIES_512, in, inpos + 208);
    oV = iV.lanewise(VectorOperators.LSHL, 10).or(oV);

    iV = IntVector.fromArray(SPECIES_512, in, inpos + 224);
    oV = iV.lanewise(VectorOperators.LSHL, 28).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_512;

    oV = iV.lanewise(VectorOperators.LSHR, 4);

    iV = IntVector.fromArray(SPECIES_512, in, inpos + 240);
    oV = iV.lanewise(VectorOperators.LSHL, 14).or(oV);

    oV.intoArray(out, outpos);
  }

  private static void fastpackNoMask19(final int[] in, int inpos,
                                       final int[] out, int outpos) {
    var iV = IntVector.fromArray(SPECIES_256, in, inpos);
    var oV = iV;
    iV = IntVector.fromArray(SPECIES_256, in, inpos + 8);
    oV = iV.lanewise(VectorOperators.LSHL, 19).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.lanewise(VectorOperators.LSHR, 13);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 16);
    oV = iV.lanewise(VectorOperators.LSHL, 6).or(oV);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 24);
    oV = iV.lanewise(VectorOperators.LSHL, 25).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.lanewise(VectorOperators.LSHR, 7);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 32);
    oV = iV.lanewise(VectorOperators.LSHL, 12).or(oV);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 40);
    oV = iV.lanewise(VectorOperators.LSHL, 31).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.lanewise(VectorOperators.LSHR, 1);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 48);
    oV = iV.lanewise(VectorOperators.LSHL, 18).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.lanewise(VectorOperators.LSHR, 14);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 56);
    oV = iV.lanewise(VectorOperators.LSHL, 5).or(oV);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 64);
    oV = iV.lanewise(VectorOperators.LSHL, 24).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.lanewise(VectorOperators.LSHR, 8);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 72);
    oV = iV.lanewise(VectorOperators.LSHL, 11).or(oV);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 80);
    oV = iV.lanewise(VectorOperators.LSHL, 30).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.lanewise(VectorOperators.LSHR, 2);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 88);
    oV = iV.lanewise(VectorOperators.LSHL, 17).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.lanewise(VectorOperators.LSHR, 15);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 96);
    oV = iV.lanewise(VectorOperators.LSHL, 4).or(oV);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 104);
    oV = iV.lanewise(VectorOperators.LSHL, 23).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.lanewise(VectorOperators.LSHR, 9);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 112);
    oV = iV.lanewise(VectorOperators.LSHL, 10).or(oV);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 120);
    oV = iV.lanewise(VectorOperators.LSHL, 29).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.lanewise(VectorOperators.LSHR, 3);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 128);
    oV = iV.lanewise(VectorOperators.LSHL, 16).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.lanewise(VectorOperators.LSHR, 16);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 136);
    oV = iV.lanewise(VectorOperators.LSHL, 3).or(oV);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 144);
    oV = iV.lanewise(VectorOperators.LSHL, 22).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.lanewise(VectorOperators.LSHR, 10);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 152);
    oV = iV.lanewise(VectorOperators.LSHL, 9).or(oV);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 160);
    oV = iV.lanewise(VectorOperators.LSHL, 28).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.lanewise(VectorOperators.LSHR, 4);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 168);
    oV = iV.lanewise(VectorOperators.LSHL, 15).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.lanewise(VectorOperators.LSHR, 17);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 176);
    oV = iV.lanewise(VectorOperators.LSHL, 2).or(oV);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 184);
    oV = iV.lanewise(VectorOperators.LSHL, 21).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.lanewise(VectorOperators.LSHR, 11);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 192);
    oV = iV.lanewise(VectorOperators.LSHL, 8).or(oV);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 200);
    oV = iV.lanewise(VectorOperators.LSHL, 27).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.lanewise(VectorOperators.LSHR, 5);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 208);
    oV = iV.lanewise(VectorOperators.LSHL, 14).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.lanewise(VectorOperators.LSHR, 18);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 216);
    oV = iV.lanewise(VectorOperators.LSHL, 1).or(oV);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 224);
    oV = iV.lanewise(VectorOperators.LSHL, 20).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.lanewise(VectorOperators.LSHR, 12);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 232);
    oV = iV.lanewise(VectorOperators.LSHL, 7).or(oV);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 240);
    oV = iV.lanewise(VectorOperators.LSHL, 26).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.lanewise(VectorOperators.LSHR, 6);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 248);
    oV = iV.lanewise(VectorOperators.LSHL, 13).or(oV);

    oV.intoArray(out, outpos);
  }

  private static void fastpackNoMask20(final int[] in, int inpos,
                                       final int[] out, int outpos) {
    var iV = IntVector.fromArray(SPECIES_512, in, inpos);
    var oV = iV;
    iV = IntVector.fromArray(SPECIES_512, in, inpos + 16);
    oV = iV.lanewise(VectorOperators.LSHL, 20).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_512;
    oV = iV.lanewise(VectorOperators.LSHR, 12);

    iV = IntVector.fromArray(SPECIES_512, in, inpos + 32);
    oV = iV.lanewise(VectorOperators.LSHL, 8).or(oV);

    iV = IntVector.fromArray(SPECIES_512, in, inpos + 48);
    oV = iV.lanewise(VectorOperators.LSHL, 28).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_512;

    oV = iV.lanewise(VectorOperators.LSHR, 4);

    iV = IntVector.fromArray(SPECIES_512, in, inpos + 64);
    oV = iV.lanewise(VectorOperators.LSHL, 16).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_512;

    oV = iV.lanewise(VectorOperators.LSHR, 16);

    iV = IntVector.fromArray(SPECIES_512, in, inpos + 80);
    oV = iV.lanewise(VectorOperators.LSHL, 4).or(oV);

    iV = IntVector.fromArray(SPECIES_512, in, inpos + 96);
    oV = iV.lanewise(VectorOperators.LSHL, 24).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_512;

    oV = iV.lanewise(VectorOperators.LSHR, 8);

    iV = IntVector.fromArray(SPECIES_512, in, inpos + 112);
    oV = iV.lanewise(VectorOperators.LSHL, 12).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_512;

    oV = oV.zero(SPECIES_512);

    iV = IntVector.fromArray(SPECIES_512, in, inpos + 128);
    oV = iV.or(oV);

    iV = IntVector.fromArray(SPECIES_512, in, inpos + 144);
    oV = iV.lanewise(VectorOperators.LSHL, 20).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_512;

    oV = iV.lanewise(VectorOperators.LSHR, 12);

    iV = IntVector.fromArray(SPECIES_512, in, inpos + 160);
    oV = iV.lanewise(VectorOperators.LSHL, 8).or(oV);

    iV = IntVector.fromArray(SPECIES_512, in, inpos + 176);
    oV = iV.lanewise(VectorOperators.LSHL, 28).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_512;

    oV = iV.lanewise(VectorOperators.LSHR, 4);

    iV = IntVector.fromArray(SPECIES_512, in, inpos + 192);
    oV = iV.lanewise(VectorOperators.LSHL, 16).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_512;

    oV = iV.lanewise(VectorOperators.LSHR, 16);

    iV = IntVector.fromArray(SPECIES_512, in, inpos + 208);
    oV = iV.lanewise(VectorOperators.LSHL, 4).or(oV);

    iV = IntVector.fromArray(SPECIES_512, in, inpos + 224);
    oV = iV.lanewise(VectorOperators.LSHL, 24).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_512;

    oV = iV.lanewise(VectorOperators.LSHR, 8);

    iV = IntVector.fromArray(SPECIES_512, in, inpos + 240);
    oV = iV.lanewise(VectorOperators.LSHL, 12).or(oV);

    oV.intoArray(out, outpos);
  }

  private static void fastpackNoMask21(final int[] in, int inpos,
                                       final int[] out, int outpos) {
    var iV = IntVector.fromArray(SPECIES_256, in, inpos);
    var oV = iV;
    iV = IntVector.fromArray(SPECIES_256, in, inpos + 8);
    oV = iV.lanewise(VectorOperators.LSHL, 21).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.lanewise(VectorOperators.LSHR, 11);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 16);
    oV = iV.lanewise(VectorOperators.LSHL, 10).or(oV);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 24);
    oV = iV.lanewise(VectorOperators.LSHL, 31).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.lanewise(VectorOperators.LSHR, 1);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 32);
    oV = iV.lanewise(VectorOperators.LSHL, 20).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.lanewise(VectorOperators.LSHR, 12);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 40);
    oV = iV.lanewise(VectorOperators.LSHL, 9).or(oV);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 48);
    oV = iV.lanewise(VectorOperators.LSHL, 30).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.lanewise(VectorOperators.LSHR, 2);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 56);
    oV = iV.lanewise(VectorOperators.LSHL, 19).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.lanewise(VectorOperators.LSHR, 13);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 64);
    oV = iV.lanewise(VectorOperators.LSHL, 8).or(oV);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 72);
    oV = iV.lanewise(VectorOperators.LSHL, 29).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.lanewise(VectorOperators.LSHR, 3);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 80);
    oV = iV.lanewise(VectorOperators.LSHL, 18).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.lanewise(VectorOperators.LSHR, 14);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 88);
    oV = iV.lanewise(VectorOperators.LSHL, 7).or(oV);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 96);
    oV = iV.lanewise(VectorOperators.LSHL, 28).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.lanewise(VectorOperators.LSHR, 4);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 104);
    oV = iV.lanewise(VectorOperators.LSHL, 17).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.lanewise(VectorOperators.LSHR, 15);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 112);
    oV = iV.lanewise(VectorOperators.LSHL, 6).or(oV);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 120);
    oV = iV.lanewise(VectorOperators.LSHL, 27).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.lanewise(VectorOperators.LSHR, 5);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 128);
    oV = iV.lanewise(VectorOperators.LSHL, 16).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.lanewise(VectorOperators.LSHR, 16);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 136);
    oV = iV.lanewise(VectorOperators.LSHL, 5).or(oV);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 144);
    oV = iV.lanewise(VectorOperators.LSHL, 26).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.lanewise(VectorOperators.LSHR, 6);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 152);
    oV = iV.lanewise(VectorOperators.LSHL, 15).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.lanewise(VectorOperators.LSHR, 17);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 160);
    oV = iV.lanewise(VectorOperators.LSHL, 4).or(oV);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 168);
    oV = iV.lanewise(VectorOperators.LSHL, 25).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.lanewise(VectorOperators.LSHR, 7);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 176);
    oV = iV.lanewise(VectorOperators.LSHL, 14).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.lanewise(VectorOperators.LSHR, 18);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 184);
    oV = iV.lanewise(VectorOperators.LSHL, 3).or(oV);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 192);
    oV = iV.lanewise(VectorOperators.LSHL, 24).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.lanewise(VectorOperators.LSHR, 8);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 200);
    oV = iV.lanewise(VectorOperators.LSHL, 13).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.lanewise(VectorOperators.LSHR, 19);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 208);
    oV = iV.lanewise(VectorOperators.LSHL, 2).or(oV);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 216);
    oV = iV.lanewise(VectorOperators.LSHL, 23).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.lanewise(VectorOperators.LSHR, 9);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 224);
    oV = iV.lanewise(VectorOperators.LSHL, 12).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.lanewise(VectorOperators.LSHR, 20);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 232);
    oV = iV.lanewise(VectorOperators.LSHL, 1).or(oV);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 240);
    oV = iV.lanewise(VectorOperators.LSHL, 22).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.lanewise(VectorOperators.LSHR, 10);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 248);
    oV = iV.lanewise(VectorOperators.LSHL, 11).or(oV);

    oV.intoArray(out, outpos);
  }

  private static void fastpackNoMask22(final int[] in, int inpos,
                                       final int[] out, int outpos) {
    var iV = IntVector.fromArray(SPECIES_512, in, inpos);
    var oV = iV;
    iV = IntVector.fromArray(SPECIES_512, in, inpos + 16);
    oV = iV.lanewise(VectorOperators.LSHL, 22).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_512;
    oV = iV.lanewise(VectorOperators.LSHR, 10);

    iV = IntVector.fromArray(SPECIES_512, in, inpos + 32);
    oV = iV.lanewise(VectorOperators.LSHL, 12).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_512;

    oV = iV.lanewise(VectorOperators.LSHR, 20);

    iV = IntVector.fromArray(SPECIES_512, in, inpos + 48);
    oV = iV.lanewise(VectorOperators.LSHL, 2).or(oV);

    iV = IntVector.fromArray(SPECIES_512, in, inpos + 64);
    oV = iV.lanewise(VectorOperators.LSHL, 24).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_512;

    oV = iV.lanewise(VectorOperators.LSHR, 8);

    iV = IntVector.fromArray(SPECIES_512, in, inpos + 80);
    oV = iV.lanewise(VectorOperators.LSHL, 14).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_512;

    oV = iV.lanewise(VectorOperators.LSHR, 18);

    iV = IntVector.fromArray(SPECIES_512, in, inpos + 96);
    oV = iV.lanewise(VectorOperators.LSHL, 4).or(oV);

    iV = IntVector.fromArray(SPECIES_512, in, inpos + 112);
    oV = iV.lanewise(VectorOperators.LSHL, 26).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_512;

    oV = iV.lanewise(VectorOperators.LSHR, 6);

    iV = IntVector.fromArray(SPECIES_512, in, inpos + 128);
    oV = iV.lanewise(VectorOperators.LSHL, 16).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_512;

    oV = iV.lanewise(VectorOperators.LSHR, 16);

    iV = IntVector.fromArray(SPECIES_512, in, inpos + 144);
    oV = iV.lanewise(VectorOperators.LSHL, 6).or(oV);

    iV = IntVector.fromArray(SPECIES_512, in, inpos + 160);
    oV = iV.lanewise(VectorOperators.LSHL, 28).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_512;

    oV = iV.lanewise(VectorOperators.LSHR, 4);

    iV = IntVector.fromArray(SPECIES_512, in, inpos + 176);
    oV = iV.lanewise(VectorOperators.LSHL, 18).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_512;

    oV = iV.lanewise(VectorOperators.LSHR, 14);

    iV = IntVector.fromArray(SPECIES_512, in, inpos + 192);
    oV = iV.lanewise(VectorOperators.LSHL, 8).or(oV);

    iV = IntVector.fromArray(SPECIES_512, in, inpos + 208);
    oV = iV.lanewise(VectorOperators.LSHL, 30).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_512;

    oV = iV.lanewise(VectorOperators.LSHR, 2);

    iV = IntVector.fromArray(SPECIES_512, in, inpos + 224);
    oV = iV.lanewise(VectorOperators.LSHL, 20).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_512;

    oV = iV.lanewise(VectorOperators.LSHR, 12);

    iV = IntVector.fromArray(SPECIES_512, in, inpos + 240);
    oV = iV.lanewise(VectorOperators.LSHL, 10).or(oV);

    oV.intoArray(out, outpos);
  }

  private static void fastpackNoMask23(final int[] in, int inpos,
                                       final int[] out, int outpos) {
    var iV = IntVector.fromArray(SPECIES_256, in, inpos);
    var oV = iV;
    iV = IntVector.fromArray(SPECIES_256, in, inpos + 8);
    oV = iV.lanewise(VectorOperators.LSHL, 23).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.lanewise(VectorOperators.LSHR, 9);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 16);
    oV = iV.lanewise(VectorOperators.LSHL, 14).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.lanewise(VectorOperators.LSHR, 18);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 24);
    oV = iV.lanewise(VectorOperators.LSHL, 5).or(oV);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 32);
    oV = iV.lanewise(VectorOperators.LSHL, 28).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.lanewise(VectorOperators.LSHR, 4);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 40);
    oV = iV.lanewise(VectorOperators.LSHL, 19).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.lanewise(VectorOperators.LSHR, 13);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 48);
    oV = iV.lanewise(VectorOperators.LSHL, 10).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.lanewise(VectorOperators.LSHR, 22);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 56);
    oV = iV.lanewise(VectorOperators.LSHL, 1).or(oV);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 64);
    oV = iV.lanewise(VectorOperators.LSHL, 24).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.lanewise(VectorOperators.LSHR, 8);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 72);
    oV = iV.lanewise(VectorOperators.LSHL, 15).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.lanewise(VectorOperators.LSHR, 17);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 80);
    oV = iV.lanewise(VectorOperators.LSHL, 6).or(oV);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 88);
    oV = iV.lanewise(VectorOperators.LSHL, 29).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.lanewise(VectorOperators.LSHR, 3);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 96);
    oV = iV.lanewise(VectorOperators.LSHL, 20).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.lanewise(VectorOperators.LSHR, 12);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 104);
    oV = iV.lanewise(VectorOperators.LSHL, 11).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.lanewise(VectorOperators.LSHR, 21);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 112);
    oV = iV.lanewise(VectorOperators.LSHL, 2).or(oV);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 120);
    oV = iV.lanewise(VectorOperators.LSHL, 25).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.lanewise(VectorOperators.LSHR, 7);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 128);
    oV = iV.lanewise(VectorOperators.LSHL, 16).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.lanewise(VectorOperators.LSHR, 16);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 136);
    oV = iV.lanewise(VectorOperators.LSHL, 7).or(oV);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 144);
    oV = iV.lanewise(VectorOperators.LSHL, 30).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.lanewise(VectorOperators.LSHR, 2);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 152);
    oV = iV.lanewise(VectorOperators.LSHL, 21).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.lanewise(VectorOperators.LSHR, 11);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 160);
    oV = iV.lanewise(VectorOperators.LSHL, 12).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.lanewise(VectorOperators.LSHR, 20);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 168);
    oV = iV.lanewise(VectorOperators.LSHL, 3).or(oV);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 176);
    oV = iV.lanewise(VectorOperators.LSHL, 26).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.lanewise(VectorOperators.LSHR, 6);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 184);
    oV = iV.lanewise(VectorOperators.LSHL, 17).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.lanewise(VectorOperators.LSHR, 15);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 192);
    oV = iV.lanewise(VectorOperators.LSHL, 8).or(oV);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 200);
    oV = iV.lanewise(VectorOperators.LSHL, 31).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.lanewise(VectorOperators.LSHR, 1);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 208);
    oV = iV.lanewise(VectorOperators.LSHL, 22).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.lanewise(VectorOperators.LSHR, 10);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 216);
    oV = iV.lanewise(VectorOperators.LSHL, 13).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.lanewise(VectorOperators.LSHR, 19);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 224);
    oV = iV.lanewise(VectorOperators.LSHL, 4).or(oV);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 232);
    oV = iV.lanewise(VectorOperators.LSHL, 27).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.lanewise(VectorOperators.LSHR, 5);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 240);
    oV = iV.lanewise(VectorOperators.LSHL, 18).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.lanewise(VectorOperators.LSHR, 14);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 248);
    oV = iV.lanewise(VectorOperators.LSHL, 9).or(oV);

    oV.intoArray(out, outpos);
  }

  private static void fastpackNoMask24(final int[] in, int inpos,
                                       final int[] out, int outpos) {
    var iV = IntVector.fromArray(SPECIES_512, in, inpos);
    var oV = iV;
    iV = IntVector.fromArray(SPECIES_512, in, inpos + 16);
    oV = iV.lanewise(VectorOperators.LSHL, 24).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_512;
    oV = iV.lanewise(VectorOperators.LSHR, 8);

    iV = IntVector.fromArray(SPECIES_512, in, inpos + 32);
    oV = iV.lanewise(VectorOperators.LSHL, 16).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_512;

    oV = iV.lanewise(VectorOperators.LSHR, 16);

    iV = IntVector.fromArray(SPECIES_512, in, inpos + 48);
    oV = iV.lanewise(VectorOperators.LSHL, 8).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_512;

    oV = oV.zero(SPECIES_512);

    iV = IntVector.fromArray(SPECIES_512, in, inpos + 64);
    oV = iV.or(oV);

    iV = IntVector.fromArray(SPECIES_512, in, inpos + 80);
    oV = iV.lanewise(VectorOperators.LSHL, 24).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_512;

    oV = iV.lanewise(VectorOperators.LSHR, 8);

    iV = IntVector.fromArray(SPECIES_512, in, inpos + 96);
    oV = iV.lanewise(VectorOperators.LSHL, 16).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_512;

    oV = iV.lanewise(VectorOperators.LSHR, 16);

    iV = IntVector.fromArray(SPECIES_512, in, inpos + 112);
    oV = iV.lanewise(VectorOperators.LSHL, 8).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_512;

    oV = oV.zero(SPECIES_512);

    iV = IntVector.fromArray(SPECIES_512, in, inpos + 128);
    oV = iV.or(oV);

    iV = IntVector.fromArray(SPECIES_512, in, inpos + 144);
    oV = iV.lanewise(VectorOperators.LSHL, 24).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_512;

    oV = iV.lanewise(VectorOperators.LSHR, 8);

    iV = IntVector.fromArray(SPECIES_512, in, inpos + 160);
    oV = iV.lanewise(VectorOperators.LSHL, 16).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_512;

    oV = iV.lanewise(VectorOperators.LSHR, 16);

    iV = IntVector.fromArray(SPECIES_512, in, inpos + 176);
    oV = iV.lanewise(VectorOperators.LSHL, 8).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_512;

    oV = oV.zero(SPECIES_512);

    iV = IntVector.fromArray(SPECIES_512, in, inpos + 192);
    oV = iV.or(oV);

    iV = IntVector.fromArray(SPECIES_512, in, inpos + 208);
    oV = iV.lanewise(VectorOperators.LSHL, 24).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_512;

    oV = iV.lanewise(VectorOperators.LSHR, 8);

    iV = IntVector.fromArray(SPECIES_512, in, inpos + 224);
    oV = iV.lanewise(VectorOperators.LSHL, 16).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_512;

    oV = iV.lanewise(VectorOperators.LSHR, 16);

    iV = IntVector.fromArray(SPECIES_512, in, inpos + 240);
    oV = iV.lanewise(VectorOperators.LSHL, 8).or(oV);

    oV.intoArray(out, outpos);
  }

  private static void fastpackNoMask25(final int[] in, int inpos,
                                       final int[] out, int outpos) {
    var iV = IntVector.fromArray(SPECIES_256, in, inpos);
    var oV = iV;
    iV = IntVector.fromArray(SPECIES_256, in, inpos + 8);
    oV = iV.lanewise(VectorOperators.LSHL, 25).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.lanewise(VectorOperators.LSHR, 7);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 16);
    oV = iV.lanewise(VectorOperators.LSHL, 18).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.lanewise(VectorOperators.LSHR, 14);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 24);
    oV = iV.lanewise(VectorOperators.LSHL, 11).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.lanewise(VectorOperators.LSHR, 21);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 32);
    oV = iV.lanewise(VectorOperators.LSHL, 4).or(oV);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 40);
    oV = iV.lanewise(VectorOperators.LSHL, 29).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.lanewise(VectorOperators.LSHR, 3);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 48);
    oV = iV.lanewise(VectorOperators.LSHL, 22).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.lanewise(VectorOperators.LSHR, 10);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 56);
    oV = iV.lanewise(VectorOperators.LSHL, 15).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.lanewise(VectorOperators.LSHR, 17);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 64);
    oV = iV.lanewise(VectorOperators.LSHL, 8).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.lanewise(VectorOperators.LSHR, 24);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 72);
    oV = iV.lanewise(VectorOperators.LSHL, 1).or(oV);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 80);
    oV = iV.lanewise(VectorOperators.LSHL, 26).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.lanewise(VectorOperators.LSHR, 6);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 88);
    oV = iV.lanewise(VectorOperators.LSHL, 19).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.lanewise(VectorOperators.LSHR, 13);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 96);
    oV = iV.lanewise(VectorOperators.LSHL, 12).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.lanewise(VectorOperators.LSHR, 20);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 104);
    oV = iV.lanewise(VectorOperators.LSHL, 5).or(oV);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 112);
    oV = iV.lanewise(VectorOperators.LSHL, 30).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.lanewise(VectorOperators.LSHR, 2);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 120);
    oV = iV.lanewise(VectorOperators.LSHL, 23).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.lanewise(VectorOperators.LSHR, 9);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 128);
    oV = iV.lanewise(VectorOperators.LSHL, 16).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.lanewise(VectorOperators.LSHR, 16);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 136);
    oV = iV.lanewise(VectorOperators.LSHL, 9).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.lanewise(VectorOperators.LSHR, 23);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 144);
    oV = iV.lanewise(VectorOperators.LSHL, 2).or(oV);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 152);
    oV = iV.lanewise(VectorOperators.LSHL, 27).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.lanewise(VectorOperators.LSHR, 5);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 160);
    oV = iV.lanewise(VectorOperators.LSHL, 20).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.lanewise(VectorOperators.LSHR, 12);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 168);
    oV = iV.lanewise(VectorOperators.LSHL, 13).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.lanewise(VectorOperators.LSHR, 19);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 176);
    oV = iV.lanewise(VectorOperators.LSHL, 6).or(oV);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 184);
    oV = iV.lanewise(VectorOperators.LSHL, 31).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.lanewise(VectorOperators.LSHR, 1);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 192);
    oV = iV.lanewise(VectorOperators.LSHL, 24).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.lanewise(VectorOperators.LSHR, 8);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 200);
    oV = iV.lanewise(VectorOperators.LSHL, 17).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.lanewise(VectorOperators.LSHR, 15);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 208);
    oV = iV.lanewise(VectorOperators.LSHL, 10).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.lanewise(VectorOperators.LSHR, 22);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 216);
    oV = iV.lanewise(VectorOperators.LSHL, 3).or(oV);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 224);
    oV = iV.lanewise(VectorOperators.LSHL, 28).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.lanewise(VectorOperators.LSHR, 4);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 232);
    oV = iV.lanewise(VectorOperators.LSHL, 21).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.lanewise(VectorOperators.LSHR, 11);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 240);
    oV = iV.lanewise(VectorOperators.LSHL, 14).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.lanewise(VectorOperators.LSHR, 18);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 248);
    oV = iV.lanewise(VectorOperators.LSHL, 7).or(oV);

    oV.intoArray(out, outpos);
  }

  private static void fastpackNoMask26(final int[] in, int inpos,
                                       final int[] out, int outpos) {
    var iV = IntVector.fromArray(SPECIES_512, in, inpos);
    var oV = iV;
    iV = IntVector.fromArray(SPECIES_512, in, inpos + 16);
    oV = iV.lanewise(VectorOperators.LSHL, 26).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_512;
    oV = iV.lanewise(VectorOperators.LSHR, 6);

    iV = IntVector.fromArray(SPECIES_512, in, inpos + 32);
    oV = iV.lanewise(VectorOperators.LSHL, 20).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_512;

    oV = iV.lanewise(VectorOperators.LSHR, 12);

    iV = IntVector.fromArray(SPECIES_512, in, inpos + 48);
    oV = iV.lanewise(VectorOperators.LSHL, 14).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_512;

    oV = iV.lanewise(VectorOperators.LSHR, 18);

    iV = IntVector.fromArray(SPECIES_512, in, inpos + 64);
    oV = iV.lanewise(VectorOperators.LSHL, 8).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_512;

    oV = iV.lanewise(VectorOperators.LSHR, 24);

    iV = IntVector.fromArray(SPECIES_512, in, inpos + 80);
    oV = iV.lanewise(VectorOperators.LSHL, 2).or(oV);

    iV = IntVector.fromArray(SPECIES_512, in, inpos + 96);
    oV = iV.lanewise(VectorOperators.LSHL, 28).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_512;

    oV = iV.lanewise(VectorOperators.LSHR, 4);

    iV = IntVector.fromArray(SPECIES_512, in, inpos + 112);
    oV = iV.lanewise(VectorOperators.LSHL, 22).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_512;

    oV = iV.lanewise(VectorOperators.LSHR, 10);

    iV = IntVector.fromArray(SPECIES_512, in, inpos + 128);
    oV = iV.lanewise(VectorOperators.LSHL, 16).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_512;

    oV = iV.lanewise(VectorOperators.LSHR, 16);

    iV = IntVector.fromArray(SPECIES_512, in, inpos + 144);
    oV = iV.lanewise(VectorOperators.LSHL, 10).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_512;

    oV = iV.lanewise(VectorOperators.LSHR, 22);

    iV = IntVector.fromArray(SPECIES_512, in, inpos + 160);
    oV = iV.lanewise(VectorOperators.LSHL, 4).or(oV);

    iV = IntVector.fromArray(SPECIES_512, in, inpos + 176);
    oV = iV.lanewise(VectorOperators.LSHL, 30).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_512;

    oV = iV.lanewise(VectorOperators.LSHR, 2);

    iV = IntVector.fromArray(SPECIES_512, in, inpos + 192);
    oV = iV.lanewise(VectorOperators.LSHL, 24).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_512;

    oV = iV.lanewise(VectorOperators.LSHR, 8);

    iV = IntVector.fromArray(SPECIES_512, in, inpos + 208);
    oV = iV.lanewise(VectorOperators.LSHL, 18).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_512;

    oV = iV.lanewise(VectorOperators.LSHR, 14);

    iV = IntVector.fromArray(SPECIES_512, in, inpos + 224);
    oV = iV.lanewise(VectorOperators.LSHL, 12).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_512;

    oV = iV.lanewise(VectorOperators.LSHR, 20);

    iV = IntVector.fromArray(SPECIES_512, in, inpos + 240);
    oV = iV.lanewise(VectorOperators.LSHL, 6).or(oV);

    oV.intoArray(out, outpos);
  }

  private static void fastpackNoMask27(final int[] in, int inpos,
                                       final int[] out, int outpos) {
    var iV = IntVector.fromArray(SPECIES_256, in, inpos);
    var oV = iV;
    iV = IntVector.fromArray(SPECIES_256, in, inpos + 8);
    oV = iV.lanewise(VectorOperators.LSHL, 27).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.lanewise(VectorOperators.LSHR, 5);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 16);
    oV = iV.lanewise(VectorOperators.LSHL, 22).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.lanewise(VectorOperators.LSHR, 10);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 24);
    oV = iV.lanewise(VectorOperators.LSHL, 17).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.lanewise(VectorOperators.LSHR, 15);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 32);
    oV = iV.lanewise(VectorOperators.LSHL, 12).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.lanewise(VectorOperators.LSHR, 20);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 40);
    oV = iV.lanewise(VectorOperators.LSHL, 7).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.lanewise(VectorOperators.LSHR, 25);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 48);
    oV = iV.lanewise(VectorOperators.LSHL, 2).or(oV);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 56);
    oV = iV.lanewise(VectorOperators.LSHL, 29).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.lanewise(VectorOperators.LSHR, 3);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 64);
    oV = iV.lanewise(VectorOperators.LSHL, 24).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.lanewise(VectorOperators.LSHR, 8);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 72);
    oV = iV.lanewise(VectorOperators.LSHL, 19).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.lanewise(VectorOperators.LSHR, 13);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 80);
    oV = iV.lanewise(VectorOperators.LSHL, 14).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.lanewise(VectorOperators.LSHR, 18);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 88);
    oV = iV.lanewise(VectorOperators.LSHL, 9).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.lanewise(VectorOperators.LSHR, 23);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 96);
    oV = iV.lanewise(VectorOperators.LSHL, 4).or(oV);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 104);
    oV = iV.lanewise(VectorOperators.LSHL, 31).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.lanewise(VectorOperators.LSHR, 1);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 112);
    oV = iV.lanewise(VectorOperators.LSHL, 26).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.lanewise(VectorOperators.LSHR, 6);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 120);
    oV = iV.lanewise(VectorOperators.LSHL, 21).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.lanewise(VectorOperators.LSHR, 11);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 128);
    oV = iV.lanewise(VectorOperators.LSHL, 16).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.lanewise(VectorOperators.LSHR, 16);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 136);
    oV = iV.lanewise(VectorOperators.LSHL, 11).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.lanewise(VectorOperators.LSHR, 21);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 144);
    oV = iV.lanewise(VectorOperators.LSHL, 6).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.lanewise(VectorOperators.LSHR, 26);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 152);
    oV = iV.lanewise(VectorOperators.LSHL, 1).or(oV);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 160);
    oV = iV.lanewise(VectorOperators.LSHL, 28).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.lanewise(VectorOperators.LSHR, 4);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 168);
    oV = iV.lanewise(VectorOperators.LSHL, 23).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.lanewise(VectorOperators.LSHR, 9);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 176);
    oV = iV.lanewise(VectorOperators.LSHL, 18).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.lanewise(VectorOperators.LSHR, 14);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 184);
    oV = iV.lanewise(VectorOperators.LSHL, 13).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.lanewise(VectorOperators.LSHR, 19);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 192);
    oV = iV.lanewise(VectorOperators.LSHL, 8).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.lanewise(VectorOperators.LSHR, 24);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 200);
    oV = iV.lanewise(VectorOperators.LSHL, 3).or(oV);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 208);
    oV = iV.lanewise(VectorOperators.LSHL, 30).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.lanewise(VectorOperators.LSHR, 2);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 216);
    oV = iV.lanewise(VectorOperators.LSHL, 25).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.lanewise(VectorOperators.LSHR, 7);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 224);
    oV = iV.lanewise(VectorOperators.LSHL, 20).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.lanewise(VectorOperators.LSHR, 12);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 232);
    oV = iV.lanewise(VectorOperators.LSHL, 15).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.lanewise(VectorOperators.LSHR, 17);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 240);
    oV = iV.lanewise(VectorOperators.LSHL, 10).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.lanewise(VectorOperators.LSHR, 22);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 248);
    oV = iV.lanewise(VectorOperators.LSHL, 5).or(oV);

    oV.intoArray(out, outpos);
  }

  private static void fastpackNoMask28(final int[] in, int inpos,
                                       final int[] out, int outpos) {
    var iV = IntVector.fromArray(SPECIES_512, in, inpos);
    var oV = iV;
    iV = IntVector.fromArray(SPECIES_512, in, inpos + 16);
    oV = iV.lanewise(VectorOperators.LSHL, 28).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_512;
    oV = iV.lanewise(VectorOperators.LSHR, 4);

    iV = IntVector.fromArray(SPECIES_512, in, inpos + 32);
    oV = iV.lanewise(VectorOperators.LSHL, 24).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_512;

    oV = iV.lanewise(VectorOperators.LSHR, 8);

    iV = IntVector.fromArray(SPECIES_512, in, inpos + 48);
    oV = iV.lanewise(VectorOperators.LSHL, 20).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_512;

    oV = iV.lanewise(VectorOperators.LSHR, 12);

    iV = IntVector.fromArray(SPECIES_512, in, inpos + 64);
    oV = iV.lanewise(VectorOperators.LSHL, 16).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_512;

    oV = iV.lanewise(VectorOperators.LSHR, 16);

    iV = IntVector.fromArray(SPECIES_512, in, inpos + 80);
    oV = iV.lanewise(VectorOperators.LSHL, 12).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_512;

    oV = iV.lanewise(VectorOperators.LSHR, 20);

    iV = IntVector.fromArray(SPECIES_512, in, inpos + 96);
    oV = iV.lanewise(VectorOperators.LSHL, 8).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_512;

    oV = iV.lanewise(VectorOperators.LSHR, 24);

    iV = IntVector.fromArray(SPECIES_512, in, inpos + 112);
    oV = iV.lanewise(VectorOperators.LSHL, 4).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_512;

    oV = oV.zero(SPECIES_512);

    iV = IntVector.fromArray(SPECIES_512, in, inpos + 128);
    oV = iV.or(oV);

    iV = IntVector.fromArray(SPECIES_512, in, inpos + 144);
    oV = iV.lanewise(VectorOperators.LSHL, 28).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_512;

    oV = iV.lanewise(VectorOperators.LSHR, 4);

    iV = IntVector.fromArray(SPECIES_512, in, inpos + 160);
    oV = iV.lanewise(VectorOperators.LSHL, 24).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_512;

    oV = iV.lanewise(VectorOperators.LSHR, 8);

    iV = IntVector.fromArray(SPECIES_512, in, inpos + 176);
    oV = iV.lanewise(VectorOperators.LSHL, 20).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_512;

    oV = iV.lanewise(VectorOperators.LSHR, 12);

    iV = IntVector.fromArray(SPECIES_512, in, inpos + 192);
    oV = iV.lanewise(VectorOperators.LSHL, 16).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_512;

    oV = iV.lanewise(VectorOperators.LSHR, 16);

    iV = IntVector.fromArray(SPECIES_512, in, inpos + 208);
    oV = iV.lanewise(VectorOperators.LSHL, 12).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_512;

    oV = iV.lanewise(VectorOperators.LSHR, 20);

    iV = IntVector.fromArray(SPECIES_512, in, inpos + 224);
    oV = iV.lanewise(VectorOperators.LSHL, 8).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_512;

    oV = iV.lanewise(VectorOperators.LSHR, 24);

    iV = IntVector.fromArray(SPECIES_512, in, inpos + 240);
    oV = iV.lanewise(VectorOperators.LSHL, 4).or(oV);

    oV.intoArray(out, outpos);
  }

  private static void fastpackNoMask29(final int[] in, int inpos,
                                       final int[] out, int outpos) {
    var iV = IntVector.fromArray(SPECIES_256, in, inpos);
    var oV = iV;
    iV = IntVector.fromArray(SPECIES_256, in, inpos + 8);
    oV = iV.lanewise(VectorOperators.LSHL, 29).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.lanewise(VectorOperators.LSHR, 3);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 16);
    oV = iV.lanewise(VectorOperators.LSHL, 26).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.lanewise(VectorOperators.LSHR, 6);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 24);
    oV = iV.lanewise(VectorOperators.LSHL, 23).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.lanewise(VectorOperators.LSHR, 9);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 32);
    oV = iV.lanewise(VectorOperators.LSHL, 20).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.lanewise(VectorOperators.LSHR, 12);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 40);
    oV = iV.lanewise(VectorOperators.LSHL, 17).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.lanewise(VectorOperators.LSHR, 15);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 48);
    oV = iV.lanewise(VectorOperators.LSHL, 14).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.lanewise(VectorOperators.LSHR, 18);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 56);
    oV = iV.lanewise(VectorOperators.LSHL, 11).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.lanewise(VectorOperators.LSHR, 21);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 64);
    oV = iV.lanewise(VectorOperators.LSHL, 8).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.lanewise(VectorOperators.LSHR, 24);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 72);
    oV = iV.lanewise(VectorOperators.LSHL, 5).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.lanewise(VectorOperators.LSHR, 27);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 80);
    oV = iV.lanewise(VectorOperators.LSHL, 2).or(oV);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 88);
    oV = iV.lanewise(VectorOperators.LSHL, 31).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.lanewise(VectorOperators.LSHR, 1);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 96);
    oV = iV.lanewise(VectorOperators.LSHL, 28).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.lanewise(VectorOperators.LSHR, 4);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 104);
    oV = iV.lanewise(VectorOperators.LSHL, 25).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.lanewise(VectorOperators.LSHR, 7);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 112);
    oV = iV.lanewise(VectorOperators.LSHL, 22).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.lanewise(VectorOperators.LSHR, 10);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 120);
    oV = iV.lanewise(VectorOperators.LSHL, 19).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.lanewise(VectorOperators.LSHR, 13);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 128);
    oV = iV.lanewise(VectorOperators.LSHL, 16).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.lanewise(VectorOperators.LSHR, 16);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 136);
    oV = iV.lanewise(VectorOperators.LSHL, 13).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.lanewise(VectorOperators.LSHR, 19);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 144);
    oV = iV.lanewise(VectorOperators.LSHL, 10).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.lanewise(VectorOperators.LSHR, 22);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 152);
    oV = iV.lanewise(VectorOperators.LSHL, 7).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.lanewise(VectorOperators.LSHR, 25);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 160);
    oV = iV.lanewise(VectorOperators.LSHL, 4).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.lanewise(VectorOperators.LSHR, 28);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 168);
    oV = iV.lanewise(VectorOperators.LSHL, 1).or(oV);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 176);
    oV = iV.lanewise(VectorOperators.LSHL, 30).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.lanewise(VectorOperators.LSHR, 2);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 184);
    oV = iV.lanewise(VectorOperators.LSHL, 27).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.lanewise(VectorOperators.LSHR, 5);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 192);
    oV = iV.lanewise(VectorOperators.LSHL, 24).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.lanewise(VectorOperators.LSHR, 8);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 200);
    oV = iV.lanewise(VectorOperators.LSHL, 21).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.lanewise(VectorOperators.LSHR, 11);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 208);
    oV = iV.lanewise(VectorOperators.LSHL, 18).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.lanewise(VectorOperators.LSHR, 14);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 216);
    oV = iV.lanewise(VectorOperators.LSHL, 15).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.lanewise(VectorOperators.LSHR, 17);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 224);
    oV = iV.lanewise(VectorOperators.LSHL, 12).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.lanewise(VectorOperators.LSHR, 20);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 232);
    oV = iV.lanewise(VectorOperators.LSHL, 9).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.lanewise(VectorOperators.LSHR, 23);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 240);
    oV = iV.lanewise(VectorOperators.LSHL, 6).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.lanewise(VectorOperators.LSHR, 26);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 248);
    oV = iV.lanewise(VectorOperators.LSHL, 3).or(oV);

    oV.intoArray(out, outpos);
  }

  private static void fastpackNoMask30(final int[] in, int inpos,
                                       final int[] out, int outpos) {
    var iV = IntVector.fromArray(SPECIES_512, in, inpos);
    var oV = iV;
    iV = IntVector.fromArray(SPECIES_512, in, inpos + 16);
    oV = iV.lanewise(VectorOperators.LSHL, 30).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_512;
    oV = iV.lanewise(VectorOperators.LSHR, 2);

    iV = IntVector.fromArray(SPECIES_512, in, inpos + 32);
    oV = iV.lanewise(VectorOperators.LSHL, 28).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_512;

    oV = iV.lanewise(VectorOperators.LSHR, 4);

    iV = IntVector.fromArray(SPECIES_512, in, inpos + 48);
    oV = iV.lanewise(VectorOperators.LSHL, 26).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_512;

    oV = iV.lanewise(VectorOperators.LSHR, 6);

    iV = IntVector.fromArray(SPECIES_512, in, inpos + 64);
    oV = iV.lanewise(VectorOperators.LSHL, 24).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_512;

    oV = iV.lanewise(VectorOperators.LSHR, 8);

    iV = IntVector.fromArray(SPECIES_512, in, inpos + 80);
    oV = iV.lanewise(VectorOperators.LSHL, 22).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_512;

    oV = iV.lanewise(VectorOperators.LSHR, 10);

    iV = IntVector.fromArray(SPECIES_512, in, inpos + 96);
    oV = iV.lanewise(VectorOperators.LSHL, 20).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_512;

    oV = iV.lanewise(VectorOperators.LSHR, 12);

    iV = IntVector.fromArray(SPECIES_512, in, inpos + 112);
    oV = iV.lanewise(VectorOperators.LSHL, 18).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_512;

    oV = iV.lanewise(VectorOperators.LSHR, 14);

    iV = IntVector.fromArray(SPECIES_512, in, inpos + 128);
    oV = iV.lanewise(VectorOperators.LSHL, 16).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_512;

    oV = iV.lanewise(VectorOperators.LSHR, 16);

    iV = IntVector.fromArray(SPECIES_512, in, inpos + 144);
    oV = iV.lanewise(VectorOperators.LSHL, 14).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_512;

    oV = iV.lanewise(VectorOperators.LSHR, 18);

    iV = IntVector.fromArray(SPECIES_512, in, inpos + 160);
    oV = iV.lanewise(VectorOperators.LSHL, 12).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_512;

    oV = iV.lanewise(VectorOperators.LSHR, 20);

    iV = IntVector.fromArray(SPECIES_512, in, inpos + 176);
    oV = iV.lanewise(VectorOperators.LSHL, 10).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_512;

    oV = iV.lanewise(VectorOperators.LSHR, 22);

    iV = IntVector.fromArray(SPECIES_512, in, inpos + 192);
    oV = iV.lanewise(VectorOperators.LSHL, 8).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_512;

    oV = iV.lanewise(VectorOperators.LSHR, 24);

    iV = IntVector.fromArray(SPECIES_512, in, inpos + 208);
    oV = iV.lanewise(VectorOperators.LSHL, 6).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_512;

    oV = iV.lanewise(VectorOperators.LSHR, 26);

    iV = IntVector.fromArray(SPECIES_512, in, inpos + 224);
    oV = iV.lanewise(VectorOperators.LSHL, 4).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_512;

    oV = iV.lanewise(VectorOperators.LSHR, 28);

    iV = IntVector.fromArray(SPECIES_512, in, inpos + 240);
    oV = iV.lanewise(VectorOperators.LSHL, 2).or(oV);

    oV.intoArray(out, outpos);
  }

  private static void fastpackNoMask31(final int[] in, int inpos,
                                       final int[] out, int outpos) {
    var iV = IntVector.fromArray(SPECIES_256, in, inpos);
    var oV = iV;
    iV = IntVector.fromArray(SPECIES_256, in, inpos + 8);
    oV = iV.lanewise(VectorOperators.LSHL, 31).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.lanewise(VectorOperators.LSHR, 1);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 16);
    oV = iV.lanewise(VectorOperators.LSHL, 30).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.lanewise(VectorOperators.LSHR, 2);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 24);
    oV = iV.lanewise(VectorOperators.LSHL, 29).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.lanewise(VectorOperators.LSHR, 3);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 32);
    oV = iV.lanewise(VectorOperators.LSHL, 28).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.lanewise(VectorOperators.LSHR, 4);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 40);
    oV = iV.lanewise(VectorOperators.LSHL, 27).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.lanewise(VectorOperators.LSHR, 5);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 48);
    oV = iV.lanewise(VectorOperators.LSHL, 26).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.lanewise(VectorOperators.LSHR, 6);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 56);
    oV = iV.lanewise(VectorOperators.LSHL, 25).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.lanewise(VectorOperators.LSHR, 7);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 64);
    oV = iV.lanewise(VectorOperators.LSHL, 24).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.lanewise(VectorOperators.LSHR, 8);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 72);
    oV = iV.lanewise(VectorOperators.LSHL, 23).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.lanewise(VectorOperators.LSHR, 9);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 80);
    oV = iV.lanewise(VectorOperators.LSHL, 22).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.lanewise(VectorOperators.LSHR, 10);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 88);
    oV = iV.lanewise(VectorOperators.LSHL, 21).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.lanewise(VectorOperators.LSHR, 11);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 96);
    oV = iV.lanewise(VectorOperators.LSHL, 20).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.lanewise(VectorOperators.LSHR, 12);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 104);
    oV = iV.lanewise(VectorOperators.LSHL, 19).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.lanewise(VectorOperators.LSHR, 13);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 112);
    oV = iV.lanewise(VectorOperators.LSHL, 18).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.lanewise(VectorOperators.LSHR, 14);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 120);
    oV = iV.lanewise(VectorOperators.LSHL, 17).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.lanewise(VectorOperators.LSHR, 15);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 128);
    oV = iV.lanewise(VectorOperators.LSHL, 16).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.lanewise(VectorOperators.LSHR, 16);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 136);
    oV = iV.lanewise(VectorOperators.LSHL, 15).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.lanewise(VectorOperators.LSHR, 17);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 144);
    oV = iV.lanewise(VectorOperators.LSHL, 14).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.lanewise(VectorOperators.LSHR, 18);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 152);
    oV = iV.lanewise(VectorOperators.LSHL, 13).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.lanewise(VectorOperators.LSHR, 19);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 160);
    oV = iV.lanewise(VectorOperators.LSHL, 12).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.lanewise(VectorOperators.LSHR, 20);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 168);
    oV = iV.lanewise(VectorOperators.LSHL, 11).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.lanewise(VectorOperators.LSHR, 21);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 176);
    oV = iV.lanewise(VectorOperators.LSHL, 10).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.lanewise(VectorOperators.LSHR, 22);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 184);
    oV = iV.lanewise(VectorOperators.LSHL, 9).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.lanewise(VectorOperators.LSHR, 23);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 192);
    oV = iV.lanewise(VectorOperators.LSHL, 8).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.lanewise(VectorOperators.LSHR, 24);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 200);
    oV = iV.lanewise(VectorOperators.LSHL, 7).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.lanewise(VectorOperators.LSHR, 25);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 208);
    oV = iV.lanewise(VectorOperators.LSHL, 6).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.lanewise(VectorOperators.LSHR, 26);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 216);
    oV = iV.lanewise(VectorOperators.LSHL, 5).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.lanewise(VectorOperators.LSHR, 27);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 224);
    oV = iV.lanewise(VectorOperators.LSHL, 4).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.lanewise(VectorOperators.LSHR, 28);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 232);
    oV = iV.lanewise(VectorOperators.LSHL, 3).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.lanewise(VectorOperators.LSHR, 29);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 240);
    oV = iV.lanewise(VectorOperators.LSHL, 2).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.lanewise(VectorOperators.LSHR, 30);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 248);
    oV = iV.lanewise(VectorOperators.LSHL, 1).or(oV);

    oV.intoArray(out, outpos);
  }

  private static void fastunpack1(final int[] in, int inpos, final int[] out,
                                  int outpos) {
    var iV = IntVector.fromArray(SPECIES_256, in, inpos);
    iV.and(MASK_1).intoArray(out, outpos);
    outpos += VLEN_256;

    iV.lanewise(VectorOperators.LSHR, 1).and(MASK_1).intoArray(out, outpos);
    outpos += VLEN_256;

    iV.lanewise(VectorOperators.LSHR, 2).and(MASK_1).intoArray(out, outpos);
    outpos += VLEN_256;

    iV.lanewise(VectorOperators.LSHR, 3).and(MASK_1).intoArray(out, outpos);
    outpos += VLEN_256;

    iV.lanewise(VectorOperators.LSHR, 4).and(MASK_1).intoArray(out, outpos);
    outpos += VLEN_256;

    iV.lanewise(VectorOperators.LSHR, 5).and(MASK_1).intoArray(out, outpos);
    outpos += VLEN_256;

    iV.lanewise(VectorOperators.LSHR, 6).and(MASK_1).intoArray(out, outpos);
    outpos += VLEN_256;

    iV.lanewise(VectorOperators.LSHR, 7).and(MASK_1).intoArray(out, outpos);
    outpos += VLEN_256;

    iV.lanewise(VectorOperators.LSHR, 8).and(MASK_1).intoArray(out, outpos);
    outpos += VLEN_256;

    iV.lanewise(VectorOperators.LSHR, 9).and(MASK_1).intoArray(out, outpos);
    outpos += VLEN_256;

    iV.lanewise(VectorOperators.LSHR, 10).and(MASK_1).intoArray(out, outpos);
    outpos += VLEN_256;

    iV.lanewise(VectorOperators.LSHR, 11).and(MASK_1).intoArray(out, outpos);
    outpos += VLEN_256;

    iV.lanewise(VectorOperators.LSHR, 12).and(MASK_1).intoArray(out, outpos);
    outpos += VLEN_256;

    iV.lanewise(VectorOperators.LSHR, 13).and(MASK_1).intoArray(out, outpos);
    outpos += VLEN_256;

    iV.lanewise(VectorOperators.LSHR, 14).and(MASK_1).intoArray(out, outpos);
    outpos += VLEN_256;

    iV.lanewise(VectorOperators.LSHR, 15).and(MASK_1).intoArray(out, outpos);
    outpos += VLEN_256;

    iV.lanewise(VectorOperators.LSHR, 16).and(MASK_1).intoArray(out, outpos);
    outpos += VLEN_256;

    iV.lanewise(VectorOperators.LSHR, 17).and(MASK_1).intoArray(out, outpos);
    outpos += VLEN_256;

    iV.lanewise(VectorOperators.LSHR, 18).and(MASK_1).intoArray(out, outpos);
    outpos += VLEN_256;

    iV.lanewise(VectorOperators.LSHR, 19).and(MASK_1).intoArray(out, outpos);
    outpos += VLEN_256;

    iV.lanewise(VectorOperators.LSHR, 20).and(MASK_1).intoArray(out, outpos);
    outpos += VLEN_256;

    iV.lanewise(VectorOperators.LSHR, 21).and(MASK_1).intoArray(out, outpos);
    outpos += VLEN_256;

    iV.lanewise(VectorOperators.LSHR, 22).and(MASK_1).intoArray(out, outpos);
    outpos += VLEN_256;

    iV.lanewise(VectorOperators.LSHR, 23).and(MASK_1).intoArray(out, outpos);
    outpos += VLEN_256;

    iV.lanewise(VectorOperators.LSHR, 24).and(MASK_1).intoArray(out, outpos);
    outpos += VLEN_256;

    iV.lanewise(VectorOperators.LSHR, 25).and(MASK_1).intoArray(out, outpos);
    outpos += VLEN_256;

    iV.lanewise(VectorOperators.LSHR, 26).and(MASK_1).intoArray(out, outpos);
    outpos += VLEN_256;

    iV.lanewise(VectorOperators.LSHR, 27).and(MASK_1).intoArray(out, outpos);
    outpos += VLEN_256;

    iV.lanewise(VectorOperators.LSHR, 28).and(MASK_1).intoArray(out, outpos);
    outpos += VLEN_256;

    iV.lanewise(VectorOperators.LSHR, 29).and(MASK_1).intoArray(out, outpos);
    outpos += VLEN_256;

    iV.lanewise(VectorOperators.LSHR, 30).and(MASK_1).intoArray(out, outpos);
    outpos += VLEN_256;

    iV.lanewise(VectorOperators.LSHR, 31).and(MASK_1).intoArray(out, outpos);
    outpos += VLEN_256;
  }

  private static void fastunpack2(final int[] in, int inpos, final int[] out,
                                  int outpos) {
    var iV = IntVector.fromArray(SPECIES_512, in, inpos);
    iV.and(MASK_2).intoArray(out, outpos);
    outpos += VLEN_512;

    iV.lanewise(VectorOperators.LSHR, 2).and(MASK_2).intoArray(out, outpos);
    outpos += VLEN_512;

    iV.lanewise(VectorOperators.LSHR, 4).and(MASK_2).intoArray(out, outpos);
    outpos += VLEN_512;

    iV.lanewise(VectorOperators.LSHR, 6).and(MASK_2).intoArray(out, outpos);
    outpos += VLEN_512;

    iV.lanewise(VectorOperators.LSHR, 8).and(MASK_2).intoArray(out, outpos);
    outpos += VLEN_512;

    iV.lanewise(VectorOperators.LSHR, 10).and(MASK_2).intoArray(out, outpos);
    outpos += VLEN_512;

    iV.lanewise(VectorOperators.LSHR, 12).and(MASK_2).intoArray(out, outpos);
    outpos += VLEN_512;

    iV.lanewise(VectorOperators.LSHR, 14).and(MASK_2).intoArray(out, outpos);
    outpos += VLEN_512;

    iV.lanewise(VectorOperators.LSHR, 16).and(MASK_2).intoArray(out, outpos);
    outpos += VLEN_512;

    iV.lanewise(VectorOperators.LSHR, 18).and(MASK_2).intoArray(out, outpos);
    outpos += VLEN_512;

    iV.lanewise(VectorOperators.LSHR, 20).and(MASK_2).intoArray(out, outpos);
    outpos += VLEN_512;

    iV.lanewise(VectorOperators.LSHR, 22).and(MASK_2).intoArray(out, outpos);
    outpos += VLEN_512;

    iV.lanewise(VectorOperators.LSHR, 24).and(MASK_2).intoArray(out, outpos);
    outpos += VLEN_512;

    iV.lanewise(VectorOperators.LSHR, 26).and(MASK_2).intoArray(out, outpos);
    outpos += VLEN_512;

    iV.lanewise(VectorOperators.LSHR, 28).and(MASK_2).intoArray(out, outpos);
    outpos += VLEN_512;

    iV.lanewise(VectorOperators.LSHR, 30).and(MASK_2).intoArray(out, outpos);
    outpos += VLEN_512;
  }

  private static void fastunpack3(final int[] in, int inpos, final int[] out,
                                  int outpos) {
    var iV = IntVector.fromArray(SPECIES_256, in, inpos);
    iV.and(MASK_3).intoArray(out, outpos);
    outpos += VLEN_256;

    iV.lanewise(VectorOperators.LSHR, 3).and(MASK_3).intoArray(out, outpos);
    outpos += VLEN_256;

    iV.lanewise(VectorOperators.LSHR, 6).and(MASK_3).intoArray(out, outpos);
    outpos += VLEN_256;

    iV.lanewise(VectorOperators.LSHR, 9).and(MASK_3).intoArray(out, outpos);
    outpos += VLEN_256;

    iV.lanewise(VectorOperators.LSHR, 12).and(MASK_3).intoArray(out, outpos);
    outpos += VLEN_256;

    iV.lanewise(VectorOperators.LSHR, 15).and(MASK_3).intoArray(out, outpos);
    outpos += VLEN_256;

    iV.lanewise(VectorOperators.LSHR, 18).and(MASK_3).intoArray(out, outpos);
    outpos += VLEN_256;

    iV.lanewise(VectorOperators.LSHR, 21).and(MASK_3).intoArray(out, outpos);
    outpos += VLEN_256;

    iV.lanewise(VectorOperators.LSHR, 24).and(MASK_3).intoArray(out, outpos);
    outpos += VLEN_256;

    iV.lanewise(VectorOperators.LSHR, 27).and(MASK_3).intoArray(out, outpos);
    outpos += VLEN_256;

    var oV = iV.lanewise(VectorOperators.LSHR, 30).and(MASK_3);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 8);
    oV = iV.and(1).lanewise(VectorOperators.LSHL, 2).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    iV.lanewise(VectorOperators.LSHR, 1).and(MASK_3).intoArray(out, outpos);
    outpos += VLEN_256;

    iV.lanewise(VectorOperators.LSHR, 4).and(MASK_3).intoArray(out, outpos);
    outpos += VLEN_256;

    iV.lanewise(VectorOperators.LSHR, 7).and(MASK_3).intoArray(out, outpos);
    outpos += VLEN_256;

    iV.lanewise(VectorOperators.LSHR, 10).and(MASK_3).intoArray(out, outpos);
    outpos += VLEN_256;

    iV.lanewise(VectorOperators.LSHR, 13).and(MASK_3).intoArray(out, outpos);
    outpos += VLEN_256;

    iV.lanewise(VectorOperators.LSHR, 16).and(MASK_3).intoArray(out, outpos);
    outpos += VLEN_256;

    iV.lanewise(VectorOperators.LSHR, 19).and(MASK_3).intoArray(out, outpos);
    outpos += VLEN_256;

    iV.lanewise(VectorOperators.LSHR, 22).and(MASK_3).intoArray(out, outpos);
    outpos += VLEN_256;

    iV.lanewise(VectorOperators.LSHR, 25).and(MASK_3).intoArray(out, outpos);
    outpos += VLEN_256;

    iV.lanewise(VectorOperators.LSHR, 28).and(MASK_3).intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.lanewise(VectorOperators.LSHR, 31).and(MASK_3);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 16);
    oV = iV.and(3).lanewise(VectorOperators.LSHL, 1).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    iV.lanewise(VectorOperators.LSHR, 2).and(MASK_3).intoArray(out, outpos);
    outpos += VLEN_256;

    iV.lanewise(VectorOperators.LSHR, 5).and(MASK_3).intoArray(out, outpos);
    outpos += VLEN_256;

    iV.lanewise(VectorOperators.LSHR, 8).and(MASK_3).intoArray(out, outpos);
    outpos += VLEN_256;

    iV.lanewise(VectorOperators.LSHR, 11).and(MASK_3).intoArray(out, outpos);
    outpos += VLEN_256;

    iV.lanewise(VectorOperators.LSHR, 14).and(MASK_3).intoArray(out, outpos);
    outpos += VLEN_256;

    iV.lanewise(VectorOperators.LSHR, 17).and(MASK_3).intoArray(out, outpos);
    outpos += VLEN_256;

    iV.lanewise(VectorOperators.LSHR, 20).and(MASK_3).intoArray(out, outpos);
    outpos += VLEN_256;

    iV.lanewise(VectorOperators.LSHR, 23).and(MASK_3).intoArray(out, outpos);
    outpos += VLEN_256;

    iV.lanewise(VectorOperators.LSHR, 26).and(MASK_3).intoArray(out, outpos);
    outpos += VLEN_256;

    iV.lanewise(VectorOperators.LSHR, 29).and(MASK_3).intoArray(out, outpos);
    outpos += VLEN_256;
  }

  private static void fastunpack4(final int[] in, int inpos, final int[] out,
                                  int outpos) {
    var iV = IntVector.fromArray(SPECIES_512, in, inpos);
    iV.and(MASK_4).intoArray(out, outpos);
    outpos += VLEN_512;

    iV.lanewise(VectorOperators.LSHR, 4).and(MASK_4).intoArray(out, outpos);
    outpos += VLEN_512;

    iV.lanewise(VectorOperators.LSHR, 8).and(MASK_4).intoArray(out, outpos);
    outpos += VLEN_512;

    iV.lanewise(VectorOperators.LSHR, 12).and(MASK_4).intoArray(out, outpos);
    outpos += VLEN_512;

    iV.lanewise(VectorOperators.LSHR, 16).and(MASK_4).intoArray(out, outpos);
    outpos += VLEN_512;

    iV.lanewise(VectorOperators.LSHR, 20).and(MASK_4).intoArray(out, outpos);
    outpos += VLEN_512;

    iV.lanewise(VectorOperators.LSHR, 24).and(MASK_4).intoArray(out, outpos);
    outpos += VLEN_512;

    iV.lanewise(VectorOperators.LSHR, 28).and(MASK_4).intoArray(out, outpos);
    outpos += VLEN_512;

    var oV = iV.and(MASK_4);
    oV = oV.zero(SPECIES_512);

    iV = IntVector.fromArray(SPECIES_512, in, inpos + 16);
    oV = iV.and(0xf).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_512;

    iV.lanewise(VectorOperators.LSHR, 4).and(MASK_4).intoArray(out, outpos);
    outpos += VLEN_512;

    iV.lanewise(VectorOperators.LSHR, 8).and(MASK_4).intoArray(out, outpos);
    outpos += VLEN_512;

    iV.lanewise(VectorOperators.LSHR, 12).and(MASK_4).intoArray(out, outpos);
    outpos += VLEN_512;

    iV.lanewise(VectorOperators.LSHR, 16).and(MASK_4).intoArray(out, outpos);
    outpos += VLEN_512;

    iV.lanewise(VectorOperators.LSHR, 20).and(MASK_4).intoArray(out, outpos);
    outpos += VLEN_512;

    iV.lanewise(VectorOperators.LSHR, 24).and(MASK_4).intoArray(out, outpos);
    outpos += VLEN_512;

    iV.lanewise(VectorOperators.LSHR, 28).and(MASK_4).intoArray(out, outpos);
    outpos += VLEN_512;
  }

  private static void fastunpack5(final int[] in, int inpos, final int[] out,
                                  int outpos) {
    var iV = IntVector.fromArray(SPECIES_256, in, inpos);
    iV.and(MASK_5).intoArray(out, outpos);
    outpos += VLEN_256;

    iV.lanewise(VectorOperators.LSHR, 5).and(MASK_5).intoArray(out, outpos);
    outpos += VLEN_256;

    iV.lanewise(VectorOperators.LSHR, 10).and(MASK_5).intoArray(out, outpos);
    outpos += VLEN_256;

    iV.lanewise(VectorOperators.LSHR, 15).and(MASK_5).intoArray(out, outpos);
    outpos += VLEN_256;

    iV.lanewise(VectorOperators.LSHR, 20).and(MASK_5).intoArray(out, outpos);
    outpos += VLEN_256;

    iV.lanewise(VectorOperators.LSHR, 25).and(MASK_5).intoArray(out, outpos);
    outpos += VLEN_256;

    var oV = iV.lanewise(VectorOperators.LSHR, 30).and(MASK_5);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 8);
    oV = iV.and(7).lanewise(VectorOperators.LSHL, 2).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    iV.lanewise(VectorOperators.LSHR, 3).and(MASK_5).intoArray(out, outpos);
    outpos += VLEN_256;

    iV.lanewise(VectorOperators.LSHR, 8).and(MASK_5).intoArray(out, outpos);
    outpos += VLEN_256;

    iV.lanewise(VectorOperators.LSHR, 13).and(MASK_5).intoArray(out, outpos);
    outpos += VLEN_256;

    iV.lanewise(VectorOperators.LSHR, 18).and(MASK_5).intoArray(out, outpos);
    outpos += VLEN_256;

    iV.lanewise(VectorOperators.LSHR, 23).and(MASK_5).intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.lanewise(VectorOperators.LSHR, 28).and(MASK_5);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 16);
    oV = iV.and(1).lanewise(VectorOperators.LSHL, 4).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    iV.lanewise(VectorOperators.LSHR, 1).and(MASK_5).intoArray(out, outpos);
    outpos += VLEN_256;

    iV.lanewise(VectorOperators.LSHR, 6).and(MASK_5).intoArray(out, outpos);
    outpos += VLEN_256;

    iV.lanewise(VectorOperators.LSHR, 11).and(MASK_5).intoArray(out, outpos);
    outpos += VLEN_256;

    iV.lanewise(VectorOperators.LSHR, 16).and(MASK_5).intoArray(out, outpos);
    outpos += VLEN_256;

    iV.lanewise(VectorOperators.LSHR, 21).and(MASK_5).intoArray(out, outpos);
    outpos += VLEN_256;

    iV.lanewise(VectorOperators.LSHR, 26).and(MASK_5).intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.lanewise(VectorOperators.LSHR, 31).and(MASK_5);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 24);
    oV = iV.and(0xf).lanewise(VectorOperators.LSHL, 1).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    iV.lanewise(VectorOperators.LSHR, 4).and(MASK_5).intoArray(out, outpos);
    outpos += VLEN_256;

    iV.lanewise(VectorOperators.LSHR, 9).and(MASK_5).intoArray(out, outpos);
    outpos += VLEN_256;

    iV.lanewise(VectorOperators.LSHR, 14).and(MASK_5).intoArray(out, outpos);
    outpos += VLEN_256;

    iV.lanewise(VectorOperators.LSHR, 19).and(MASK_5).intoArray(out, outpos);
    outpos += VLEN_256;

    iV.lanewise(VectorOperators.LSHR, 24).and(MASK_5).intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.lanewise(VectorOperators.LSHR, 29).and(MASK_5);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 32);
    oV = iV.and(3).lanewise(VectorOperators.LSHL, 3).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    iV.lanewise(VectorOperators.LSHR, 2).and(MASK_5).intoArray(out, outpos);
    outpos += VLEN_256;

    iV.lanewise(VectorOperators.LSHR, 7).and(MASK_5).intoArray(out, outpos);
    outpos += VLEN_256;

    iV.lanewise(VectorOperators.LSHR, 12).and(MASK_5).intoArray(out, outpos);
    outpos += VLEN_256;

    iV.lanewise(VectorOperators.LSHR, 17).and(MASK_5).intoArray(out, outpos);
    outpos += VLEN_256;

    iV.lanewise(VectorOperators.LSHR, 22).and(MASK_5).intoArray(out, outpos);
    outpos += VLEN_256;

    iV.lanewise(VectorOperators.LSHR, 27).and(MASK_5).intoArray(out, outpos);
    outpos += VLEN_256;
  }

  private static void fastunpack6(final int[] in, int inpos, final int[] out,
                                  int outpos) {
    var iV = IntVector.fromArray(SPECIES_512, in, inpos);
    iV.and(MASK_6).intoArray(out, outpos);
    outpos += VLEN_512;

    iV.lanewise(VectorOperators.LSHR, 6).and(MASK_6).intoArray(out, outpos);
    outpos += VLEN_512;

    iV.lanewise(VectorOperators.LSHR, 12).and(MASK_6).intoArray(out, outpos);
    outpos += VLEN_512;

    iV.lanewise(VectorOperators.LSHR, 18).and(MASK_6).intoArray(out, outpos);
    outpos += VLEN_512;

    iV.lanewise(VectorOperators.LSHR, 24).and(MASK_6).intoArray(out, outpos);
    outpos += VLEN_512;

    var oV = iV.lanewise(VectorOperators.LSHR, 30).and(MASK_6);

    iV = IntVector.fromArray(SPECIES_512, in, inpos + 16);
    oV = iV.and(0xf).lanewise(VectorOperators.LSHL, 2).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_512;

    iV.lanewise(VectorOperators.LSHR, 4).and(MASK_6).intoArray(out, outpos);
    outpos += VLEN_512;

    iV.lanewise(VectorOperators.LSHR, 10).and(MASK_6).intoArray(out, outpos);
    outpos += VLEN_512;

    iV.lanewise(VectorOperators.LSHR, 16).and(MASK_6).intoArray(out, outpos);
    outpos += VLEN_512;

    iV.lanewise(VectorOperators.LSHR, 22).and(MASK_6).intoArray(out, outpos);
    outpos += VLEN_512;

    oV = iV.lanewise(VectorOperators.LSHR, 28).and(MASK_6);

    iV = IntVector.fromArray(SPECIES_512, in, inpos + 32);
    oV = iV.and(3).lanewise(VectorOperators.LSHL, 4).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_512;

    iV.lanewise(VectorOperators.LSHR, 2).and(MASK_6).intoArray(out, outpos);
    outpos += VLEN_512;

    iV.lanewise(VectorOperators.LSHR, 8).and(MASK_6).intoArray(out, outpos);
    outpos += VLEN_512;

    iV.lanewise(VectorOperators.LSHR, 14).and(MASK_6).intoArray(out, outpos);
    outpos += VLEN_512;

    iV.lanewise(VectorOperators.LSHR, 20).and(MASK_6).intoArray(out, outpos);
    outpos += VLEN_512;

    iV.lanewise(VectorOperators.LSHR, 26).and(MASK_6).intoArray(out, outpos);
    outpos += VLEN_512;
  }

  private static void fastunpack7(final int[] in, int inpos, final int[] out,
                                  int outpos) {
    var iV = IntVector.fromArray(SPECIES_256, in, inpos);
    iV.and(MASK_7).intoArray(out, outpos);
    outpos += VLEN_256;

    iV.lanewise(VectorOperators.LSHR, 7).and(MASK_7).intoArray(out, outpos);
    outpos += VLEN_256;

    iV.lanewise(VectorOperators.LSHR, 14).and(MASK_7).intoArray(out, outpos);
    outpos += VLEN_256;

    iV.lanewise(VectorOperators.LSHR, 21).and(MASK_7).intoArray(out, outpos);
    outpos += VLEN_256;

    var oV = iV.lanewise(VectorOperators.LSHR, 28).and(MASK_7);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 8);
    oV = iV.and(7).lanewise(VectorOperators.LSHL, 4).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    iV.lanewise(VectorOperators.LSHR, 3).and(MASK_7).intoArray(out, outpos);
    outpos += VLEN_256;

    iV.lanewise(VectorOperators.LSHR, 10).and(MASK_7).intoArray(out, outpos);
    outpos += VLEN_256;

    iV.lanewise(VectorOperators.LSHR, 17).and(MASK_7).intoArray(out, outpos);
    outpos += VLEN_256;

    iV.lanewise(VectorOperators.LSHR, 24).and(MASK_7).intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.lanewise(VectorOperators.LSHR, 31).and(MASK_7);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 16);
    oV = iV.and(0x3f).lanewise(VectorOperators.LSHL, 1).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    iV.lanewise(VectorOperators.LSHR, 6).and(MASK_7).intoArray(out, outpos);
    outpos += VLEN_256;

    iV.lanewise(VectorOperators.LSHR, 13).and(MASK_7).intoArray(out, outpos);
    outpos += VLEN_256;

    iV.lanewise(VectorOperators.LSHR, 20).and(MASK_7).intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.lanewise(VectorOperators.LSHR, 27).and(MASK_7);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 24);
    oV = iV.and(3).lanewise(VectorOperators.LSHL, 5).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    iV.lanewise(VectorOperators.LSHR, 2).and(MASK_7).intoArray(out, outpos);
    outpos += VLEN_256;

    iV.lanewise(VectorOperators.LSHR, 9).and(MASK_7).intoArray(out, outpos);
    outpos += VLEN_256;

    iV.lanewise(VectorOperators.LSHR, 16).and(MASK_7).intoArray(out, outpos);
    outpos += VLEN_256;

    iV.lanewise(VectorOperators.LSHR, 23).and(MASK_7).intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.lanewise(VectorOperators.LSHR, 30).and(MASK_7);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 32);
    oV = iV.and(0x1f).lanewise(VectorOperators.LSHL, 2).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    iV.lanewise(VectorOperators.LSHR, 5).and(MASK_7).intoArray(out, outpos);
    outpos += VLEN_256;

    iV.lanewise(VectorOperators.LSHR, 12).and(MASK_7).intoArray(out, outpos);
    outpos += VLEN_256;

    iV.lanewise(VectorOperators.LSHR, 19).and(MASK_7).intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.lanewise(VectorOperators.LSHR, 26).and(MASK_7);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 40);
    oV = iV.and(1).lanewise(VectorOperators.LSHL, 6).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    iV.lanewise(VectorOperators.LSHR, 1).and(MASK_7).intoArray(out, outpos);
    outpos += VLEN_256;

    iV.lanewise(VectorOperators.LSHR, 8).and(MASK_7).intoArray(out, outpos);
    outpos += VLEN_256;

    iV.lanewise(VectorOperators.LSHR, 15).and(MASK_7).intoArray(out, outpos);
    outpos += VLEN_256;

    iV.lanewise(VectorOperators.LSHR, 22).and(MASK_7).intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.lanewise(VectorOperators.LSHR, 29).and(MASK_7);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 48);
    oV = iV.and(0xf).lanewise(VectorOperators.LSHL, 3).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    iV.lanewise(VectorOperators.LSHR, 4).and(MASK_7).intoArray(out, outpos);
    outpos += VLEN_256;

    iV.lanewise(VectorOperators.LSHR, 11).and(MASK_7).intoArray(out, outpos);
    outpos += VLEN_256;

    iV.lanewise(VectorOperators.LSHR, 18).and(MASK_7).intoArray(out, outpos);
    outpos += VLEN_256;

    iV.lanewise(VectorOperators.LSHR, 25).and(MASK_7).intoArray(out, outpos);
    outpos += VLEN_256;
  }

  private static void fastunpack8(final int[] in, int inpos, final int[] out,
                                  int outpos) {
    var iV = IntVector.fromArray(SPECIES_512, in, inpos);
    iV.and(MASK_8).intoArray(out, outpos);
    outpos += VLEN_512;

    iV.lanewise(VectorOperators.LSHR, 8).and(MASK_8).intoArray(out, outpos);
    outpos += VLEN_512;

    iV.lanewise(VectorOperators.LSHR, 16).and(MASK_8).intoArray(out, outpos);
    outpos += VLEN_512;

    iV.lanewise(VectorOperators.LSHR, 24).and(MASK_8).intoArray(out, outpos);
    outpos += VLEN_512;

    var oV = iV.and(MASK_8);
    oV = oV.zero(SPECIES_512);

    iV = IntVector.fromArray(SPECIES_512, in, inpos + 16);
    oV = iV.and(0xff).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_512;

    iV.lanewise(VectorOperators.LSHR, 8).and(MASK_8).intoArray(out, outpos);
    outpos += VLEN_512;

    iV.lanewise(VectorOperators.LSHR, 16).and(MASK_8).intoArray(out, outpos);
    outpos += VLEN_512;

    iV.lanewise(VectorOperators.LSHR, 24).and(MASK_8).intoArray(out, outpos);
    outpos += VLEN_512;

    oV = oV.zero(SPECIES_512);

    iV = IntVector.fromArray(SPECIES_512, in, inpos + 32);
    oV = iV.and(0xff).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_512;

    iV.lanewise(VectorOperators.LSHR, 8).and(MASK_8).intoArray(out, outpos);
    outpos += VLEN_512;

    iV.lanewise(VectorOperators.LSHR, 16).and(MASK_8).intoArray(out, outpos);
    outpos += VLEN_512;

    iV.lanewise(VectorOperators.LSHR, 24).and(MASK_8).intoArray(out, outpos);
    outpos += VLEN_512;

    oV = oV.zero(SPECIES_512);

    iV = IntVector.fromArray(SPECIES_512, in, inpos + 48);
    oV = iV.and(0xff).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_512;

    iV.lanewise(VectorOperators.LSHR, 8).and(MASK_8).intoArray(out, outpos);
    outpos += VLEN_512;

    iV.lanewise(VectorOperators.LSHR, 16).and(MASK_8).intoArray(out, outpos);
    outpos += VLEN_512;

    iV.lanewise(VectorOperators.LSHR, 24).and(MASK_8).intoArray(out, outpos);
    outpos += VLEN_512;
  }

  private static void fastunpack9(final int[] in, int inpos, final int[] out,
                                  int outpos) {
    var iV = IntVector.fromArray(SPECIES_256, in, inpos);
    iV.and(MASK_9).intoArray(out, outpos);
    outpos += VLEN_256;

    iV.lanewise(VectorOperators.LSHR, 9).and(MASK_9).intoArray(out, outpos);
    outpos += VLEN_256;

    iV.lanewise(VectorOperators.LSHR, 18).and(MASK_9).intoArray(out, outpos);
    outpos += VLEN_256;

    var oV = iV.lanewise(VectorOperators.LSHR, 27).and(MASK_9);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 8);
    oV = iV.and(0xf).lanewise(VectorOperators.LSHL, 5).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    iV.lanewise(VectorOperators.LSHR, 4).and(MASK_9).intoArray(out, outpos);
    outpos += VLEN_256;

    iV.lanewise(VectorOperators.LSHR, 13).and(MASK_9).intoArray(out, outpos);
    outpos += VLEN_256;

    iV.lanewise(VectorOperators.LSHR, 22).and(MASK_9).intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.lanewise(VectorOperators.LSHR, 31).and(MASK_9);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 16);
    oV = iV.and(0xff).lanewise(VectorOperators.LSHL, 1).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    iV.lanewise(VectorOperators.LSHR, 8).and(MASK_9).intoArray(out, outpos);
    outpos += VLEN_256;

    iV.lanewise(VectorOperators.LSHR, 17).and(MASK_9).intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.lanewise(VectorOperators.LSHR, 26).and(MASK_9);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 24);
    oV = iV.and(7).lanewise(VectorOperators.LSHL, 6).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    iV.lanewise(VectorOperators.LSHR, 3).and(MASK_9).intoArray(out, outpos);
    outpos += VLEN_256;

    iV.lanewise(VectorOperators.LSHR, 12).and(MASK_9).intoArray(out, outpos);
    outpos += VLEN_256;

    iV.lanewise(VectorOperators.LSHR, 21).and(MASK_9).intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.lanewise(VectorOperators.LSHR, 30).and(MASK_9);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 32);
    oV = iV.and(0x7f).lanewise(VectorOperators.LSHL, 2).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    iV.lanewise(VectorOperators.LSHR, 7).and(MASK_9).intoArray(out, outpos);
    outpos += VLEN_256;

    iV.lanewise(VectorOperators.LSHR, 16).and(MASK_9).intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.lanewise(VectorOperators.LSHR, 25).and(MASK_9);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 40);
    oV = iV.and(3).lanewise(VectorOperators.LSHL, 7).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    iV.lanewise(VectorOperators.LSHR, 2).and(MASK_9).intoArray(out, outpos);
    outpos += VLEN_256;

    iV.lanewise(VectorOperators.LSHR, 11).and(MASK_9).intoArray(out, outpos);
    outpos += VLEN_256;

    iV.lanewise(VectorOperators.LSHR, 20).and(MASK_9).intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.lanewise(VectorOperators.LSHR, 29).and(MASK_9);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 48);
    oV = iV.and(0x3f).lanewise(VectorOperators.LSHL, 3).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    iV.lanewise(VectorOperators.LSHR, 6).and(MASK_9).intoArray(out, outpos);
    outpos += VLEN_256;

    iV.lanewise(VectorOperators.LSHR, 15).and(MASK_9).intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.lanewise(VectorOperators.LSHR, 24).and(MASK_9);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 56);
    oV = iV.and(1).lanewise(VectorOperators.LSHL, 8).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    iV.lanewise(VectorOperators.LSHR, 1).and(MASK_9).intoArray(out, outpos);
    outpos += VLEN_256;

    iV.lanewise(VectorOperators.LSHR, 10).and(MASK_9).intoArray(out, outpos);
    outpos += VLEN_256;

    iV.lanewise(VectorOperators.LSHR, 19).and(MASK_9).intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.lanewise(VectorOperators.LSHR, 28).and(MASK_9);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 64);
    oV = iV.and(0x1f).lanewise(VectorOperators.LSHL, 4).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    iV.lanewise(VectorOperators.LSHR, 5).and(MASK_9).intoArray(out, outpos);
    outpos += VLEN_256;

    iV.lanewise(VectorOperators.LSHR, 14).and(MASK_9).intoArray(out, outpos);
    outpos += VLEN_256;

    iV.lanewise(VectorOperators.LSHR, 23).and(MASK_9).intoArray(out, outpos);
    outpos += VLEN_256;
  }

  private static void fastunpack10(final int[] in, int inpos, final int[] out,
                                   int outpos) {
    var iV = IntVector.fromArray(SPECIES_512, in, inpos);
    iV.and(MASK_10).intoArray(out, outpos);
    outpos += VLEN_512;

    iV.lanewise(VectorOperators.LSHR, 10).and(MASK_10).intoArray(out, outpos);
    outpos += VLEN_512;

    iV.lanewise(VectorOperators.LSHR, 20).and(MASK_10).intoArray(out, outpos);
    outpos += VLEN_512;

    var oV = iV.lanewise(VectorOperators.LSHR, 30).and(MASK_10);

    iV = IntVector.fromArray(SPECIES_512, in, inpos + 16);
    oV = iV.and(0xff).lanewise(VectorOperators.LSHL, 2).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_512;

    iV.lanewise(VectorOperators.LSHR, 8).and(MASK_10).intoArray(out, outpos);
    outpos += VLEN_512;

    iV.lanewise(VectorOperators.LSHR, 18).and(MASK_10).intoArray(out, outpos);
    outpos += VLEN_512;

    oV = iV.lanewise(VectorOperators.LSHR, 28).and(MASK_10);

    iV = IntVector.fromArray(SPECIES_512, in, inpos + 32);
    oV = iV.and(0x3f).lanewise(VectorOperators.LSHL, 4).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_512;

    iV.lanewise(VectorOperators.LSHR, 6).and(MASK_10).intoArray(out, outpos);
    outpos += VLEN_512;

    iV.lanewise(VectorOperators.LSHR, 16).and(MASK_10).intoArray(out, outpos);
    outpos += VLEN_512;

    oV = iV.lanewise(VectorOperators.LSHR, 26).and(MASK_10);

    iV = IntVector.fromArray(SPECIES_512, in, inpos + 48);
    oV = iV.and(0xf).lanewise(VectorOperators.LSHL, 6).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_512;

    iV.lanewise(VectorOperators.LSHR, 4).and(MASK_10).intoArray(out, outpos);
    outpos += VLEN_512;

    iV.lanewise(VectorOperators.LSHR, 14).and(MASK_10).intoArray(out, outpos);
    outpos += VLEN_512;

    oV = iV.lanewise(VectorOperators.LSHR, 24).and(MASK_10);

    iV = IntVector.fromArray(SPECIES_512, in, inpos + 64);
    oV = iV.and(3).lanewise(VectorOperators.LSHL, 8).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_512;

    iV.lanewise(VectorOperators.LSHR, 2).and(MASK_10).intoArray(out, outpos);
    outpos += VLEN_512;

    iV.lanewise(VectorOperators.LSHR, 12).and(MASK_10).intoArray(out, outpos);
    outpos += VLEN_512;

    iV.lanewise(VectorOperators.LSHR, 22).and(MASK_10).intoArray(out, outpos);
    outpos += VLEN_512;
  }

  private static void fastunpack11(final int[] in, int inpos, final int[] out,
                                   int outpos) {
    var iV = IntVector.fromArray(SPECIES_256, in, inpos);
    iV.and(MASK_11).intoArray(out, outpos);
    outpos += VLEN_256;

    iV.lanewise(VectorOperators.LSHR, 11).and(MASK_11).intoArray(out, outpos);
    outpos += VLEN_256;

    var oV = iV.lanewise(VectorOperators.LSHR, 22).and(MASK_11);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 8);
    oV = iV.and(1).lanewise(VectorOperators.LSHL, 10).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    iV.lanewise(VectorOperators.LSHR, 1).and(MASK_11).intoArray(out, outpos);
    outpos += VLEN_256;

    iV.lanewise(VectorOperators.LSHR, 12).and(MASK_11).intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.lanewise(VectorOperators.LSHR, 23).and(MASK_11);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 16);
    oV = iV.and(3).lanewise(VectorOperators.LSHL, 9).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    iV.lanewise(VectorOperators.LSHR, 2).and(MASK_11).intoArray(out, outpos);
    outpos += VLEN_256;

    iV.lanewise(VectorOperators.LSHR, 13).and(MASK_11).intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.lanewise(VectorOperators.LSHR, 24).and(MASK_11);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 24);
    oV = iV.and(7).lanewise(VectorOperators.LSHL, 8).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    iV.lanewise(VectorOperators.LSHR, 3).and(MASK_11).intoArray(out, outpos);
    outpos += VLEN_256;

    iV.lanewise(VectorOperators.LSHR, 14).and(MASK_11).intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.lanewise(VectorOperators.LSHR, 25).and(MASK_11);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 32);
    oV = iV.and(0xf).lanewise(VectorOperators.LSHL, 7).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    iV.lanewise(VectorOperators.LSHR, 4).and(MASK_11).intoArray(out, outpos);
    outpos += VLEN_256;

    iV.lanewise(VectorOperators.LSHR, 15).and(MASK_11).intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.lanewise(VectorOperators.LSHR, 26).and(MASK_11);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 40);
    oV = iV.and(0x1f).lanewise(VectorOperators.LSHL, 6).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    iV.lanewise(VectorOperators.LSHR, 5).and(MASK_11).intoArray(out, outpos);
    outpos += VLEN_256;

    iV.lanewise(VectorOperators.LSHR, 16).and(MASK_11).intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.lanewise(VectorOperators.LSHR, 27).and(MASK_11);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 48);
    oV = iV.and(0x3f).lanewise(VectorOperators.LSHL, 5).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    iV.lanewise(VectorOperators.LSHR, 6).and(MASK_11).intoArray(out, outpos);
    outpos += VLEN_256;

    iV.lanewise(VectorOperators.LSHR, 17).and(MASK_11).intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.lanewise(VectorOperators.LSHR, 28).and(MASK_11);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 56);
    oV = iV.and(0x7f).lanewise(VectorOperators.LSHL, 4).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    iV.lanewise(VectorOperators.LSHR, 7).and(MASK_11).intoArray(out, outpos);
    outpos += VLEN_256;

    iV.lanewise(VectorOperators.LSHR, 18).and(MASK_11).intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.lanewise(VectorOperators.LSHR, 29).and(MASK_11);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 64);
    oV = iV.and(0xff).lanewise(VectorOperators.LSHL, 3).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    iV.lanewise(VectorOperators.LSHR, 8).and(MASK_11).intoArray(out, outpos);
    outpos += VLEN_256;

    iV.lanewise(VectorOperators.LSHR, 19).and(MASK_11).intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.lanewise(VectorOperators.LSHR, 30).and(MASK_11);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 72);
    oV = iV.and(0x1ff).lanewise(VectorOperators.LSHL, 2).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    iV.lanewise(VectorOperators.LSHR, 9).and(MASK_11).intoArray(out, outpos);
    outpos += VLEN_256;

    iV.lanewise(VectorOperators.LSHR, 20).and(MASK_11).intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.lanewise(VectorOperators.LSHR, 31).and(MASK_11);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 80);
    oV = iV.and(0x3ff).lanewise(VectorOperators.LSHL, 1).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    iV.lanewise(VectorOperators.LSHR, 10).and(MASK_11).intoArray(out, outpos);
    outpos += VLEN_256;

    iV.lanewise(VectorOperators.LSHR, 21).and(MASK_11).intoArray(out, outpos);
    outpos += VLEN_256;
  }

  private static void fastunpack12(final int[] in, int inpos, final int[] out,
                                   int outpos) {
    var iV = IntVector.fromArray(SPECIES_512, in, inpos);
    iV.and(MASK_12).intoArray(out, outpos);
    outpos += VLEN_512;

    iV.lanewise(VectorOperators.LSHR, 12).and(MASK_12).intoArray(out, outpos);
    outpos += VLEN_512;

    var oV = iV.lanewise(VectorOperators.LSHR, 24).and(MASK_12);

    iV = IntVector.fromArray(SPECIES_512, in, inpos + 16);
    oV = iV.and(0xf).lanewise(VectorOperators.LSHL, 8).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_512;

    iV.lanewise(VectorOperators.LSHR, 4).and(MASK_12).intoArray(out, outpos);
    outpos += VLEN_512;

    iV.lanewise(VectorOperators.LSHR, 16).and(MASK_12).intoArray(out, outpos);
    outpos += VLEN_512;

    oV = iV.lanewise(VectorOperators.LSHR, 28).and(MASK_12);

    iV = IntVector.fromArray(SPECIES_512, in, inpos + 32);
    oV = iV.and(0xff).lanewise(VectorOperators.LSHL, 4).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_512;

    iV.lanewise(VectorOperators.LSHR, 8).and(MASK_12).intoArray(out, outpos);
    outpos += VLEN_512;

    iV.lanewise(VectorOperators.LSHR, 20).and(MASK_12).intoArray(out, outpos);
    outpos += VLEN_512;

    oV = oV.zero(SPECIES_512);

    iV = IntVector.fromArray(SPECIES_512, in, inpos + 48);
    oV = iV.and(0xfff).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_512;

    iV.lanewise(VectorOperators.LSHR, 12).and(MASK_12).intoArray(out, outpos);
    outpos += VLEN_512;

    oV = iV.lanewise(VectorOperators.LSHR, 24).and(MASK_12);

    iV = IntVector.fromArray(SPECIES_512, in, inpos + 64);
    oV = iV.and(0xf).lanewise(VectorOperators.LSHL, 8).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_512;

    iV.lanewise(VectorOperators.LSHR, 4).and(MASK_12).intoArray(out, outpos);
    outpos += VLEN_512;

    iV.lanewise(VectorOperators.LSHR, 16).and(MASK_12).intoArray(out, outpos);
    outpos += VLEN_512;

    oV = iV.lanewise(VectorOperators.LSHR, 28).and(MASK_12);

    iV = IntVector.fromArray(SPECIES_512, in, inpos + 80);
    oV = iV.and(0xff).lanewise(VectorOperators.LSHL, 4).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_512;

    iV.lanewise(VectorOperators.LSHR, 8).and(MASK_12).intoArray(out, outpos);
    outpos += VLEN_512;

    iV.lanewise(VectorOperators.LSHR, 20).and(MASK_12).intoArray(out, outpos);
    outpos += VLEN_512;
  }

  private static void fastunpack13(final int[] in, int inpos, final int[] out,
                                   int outpos) {
    var iV = IntVector.fromArray(SPECIES_256, in, inpos);
    iV.and(MASK_13).intoArray(out, outpos);
    outpos += VLEN_256;

    iV.lanewise(VectorOperators.LSHR, 13).and(MASK_13).intoArray(out, outpos);
    outpos += VLEN_256;

    var oV = iV.lanewise(VectorOperators.LSHR, 26).and(MASK_13);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 8);
    oV = iV.and(0x7f).lanewise(VectorOperators.LSHL, 6).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    iV.lanewise(VectorOperators.LSHR, 7).and(MASK_13).intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.lanewise(VectorOperators.LSHR, 20).and(MASK_13);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 16);
    oV = iV.and(1).lanewise(VectorOperators.LSHL, 12).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    iV.lanewise(VectorOperators.LSHR, 1).and(MASK_13).intoArray(out, outpos);
    outpos += VLEN_256;

    iV.lanewise(VectorOperators.LSHR, 14).and(MASK_13).intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.lanewise(VectorOperators.LSHR, 27).and(MASK_13);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 24);
    oV = iV.and(0xff).lanewise(VectorOperators.LSHL, 5).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    iV.lanewise(VectorOperators.LSHR, 8).and(MASK_13).intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.lanewise(VectorOperators.LSHR, 21).and(MASK_13);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 32);
    oV = iV.and(3).lanewise(VectorOperators.LSHL, 11).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    iV.lanewise(VectorOperators.LSHR, 2).and(MASK_13).intoArray(out, outpos);
    outpos += VLEN_256;

    iV.lanewise(VectorOperators.LSHR, 15).and(MASK_13).intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.lanewise(VectorOperators.LSHR, 28).and(MASK_13);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 40);
    oV = iV.and(0x1ff).lanewise(VectorOperators.LSHL, 4).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    iV.lanewise(VectorOperators.LSHR, 9).and(MASK_13).intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.lanewise(VectorOperators.LSHR, 22).and(MASK_13);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 48);
    oV = iV.and(7).lanewise(VectorOperators.LSHL, 10).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    iV.lanewise(VectorOperators.LSHR, 3).and(MASK_13).intoArray(out, outpos);
    outpos += VLEN_256;

    iV.lanewise(VectorOperators.LSHR, 16).and(MASK_13).intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.lanewise(VectorOperators.LSHR, 29).and(MASK_13);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 56);
    oV = iV.and(0x3ff).lanewise(VectorOperators.LSHL, 3).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    iV.lanewise(VectorOperators.LSHR, 10).and(MASK_13).intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.lanewise(VectorOperators.LSHR, 23).and(MASK_13);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 64);
    oV = iV.and(0xf).lanewise(VectorOperators.LSHL, 9).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    iV.lanewise(VectorOperators.LSHR, 4).and(MASK_13).intoArray(out, outpos);
    outpos += VLEN_256;

    iV.lanewise(VectorOperators.LSHR, 17).and(MASK_13).intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.lanewise(VectorOperators.LSHR, 30).and(MASK_13);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 72);
    oV = iV.and(0x7ff).lanewise(VectorOperators.LSHL, 2).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    iV.lanewise(VectorOperators.LSHR, 11).and(MASK_13).intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.lanewise(VectorOperators.LSHR, 24).and(MASK_13);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 80);
    oV = iV.and(0x1f).lanewise(VectorOperators.LSHL, 8).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    iV.lanewise(VectorOperators.LSHR, 5).and(MASK_13).intoArray(out, outpos);
    outpos += VLEN_256;

    iV.lanewise(VectorOperators.LSHR, 18).and(MASK_13).intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.lanewise(VectorOperators.LSHR, 31).and(MASK_13);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 88);
    oV = iV.and(0xfff).lanewise(VectorOperators.LSHL, 1).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    iV.lanewise(VectorOperators.LSHR, 12).and(MASK_13).intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.lanewise(VectorOperators.LSHR, 25).and(MASK_13);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 96);
    oV = iV.and(0x3f).lanewise(VectorOperators.LSHL, 7).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    iV.lanewise(VectorOperators.LSHR, 6).and(MASK_13).intoArray(out, outpos);
    outpos += VLEN_256;

    iV.lanewise(VectorOperators.LSHR, 19).and(MASK_13).intoArray(out, outpos);
    outpos += VLEN_256;
  }

  private static void fastunpack14(final int[] in, int inpos, final int[] out,
                                   int outpos) {
    var iV = IntVector.fromArray(SPECIES_512, in, inpos);
    iV.and(MASK_14).intoArray(out, outpos);
    outpos += VLEN_512;

    iV.lanewise(VectorOperators.LSHR, 14).and(MASK_14).intoArray(out, outpos);
    outpos += VLEN_512;

    var oV = iV.lanewise(VectorOperators.LSHR, 28).and(MASK_14);

    iV = IntVector.fromArray(SPECIES_512, in, inpos + 16);
    oV = iV.and(0x3ff).lanewise(VectorOperators.LSHL, 4).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_512;

    iV.lanewise(VectorOperators.LSHR, 10).and(MASK_14).intoArray(out, outpos);
    outpos += VLEN_512;

    oV = iV.lanewise(VectorOperators.LSHR, 24).and(MASK_14);

    iV = IntVector.fromArray(SPECIES_512, in, inpos + 32);
    oV = iV.and(0x3f).lanewise(VectorOperators.LSHL, 8).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_512;

    iV.lanewise(VectorOperators.LSHR, 6).and(MASK_14).intoArray(out, outpos);
    outpos += VLEN_512;

    oV = iV.lanewise(VectorOperators.LSHR, 20).and(MASK_14);

    iV = IntVector.fromArray(SPECIES_512, in, inpos + 48);
    oV = iV.and(3).lanewise(VectorOperators.LSHL, 12).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_512;

    iV.lanewise(VectorOperators.LSHR, 2).and(MASK_14).intoArray(out, outpos);
    outpos += VLEN_512;

    iV.lanewise(VectorOperators.LSHR, 16).and(MASK_14).intoArray(out, outpos);
    outpos += VLEN_512;

    oV = iV.lanewise(VectorOperators.LSHR, 30).and(MASK_14);

    iV = IntVector.fromArray(SPECIES_512, in, inpos + 64);
    oV = iV.and(0xfff).lanewise(VectorOperators.LSHL, 2).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_512;

    iV.lanewise(VectorOperators.LSHR, 12).and(MASK_14).intoArray(out, outpos);
    outpos += VLEN_512;

    oV = iV.lanewise(VectorOperators.LSHR, 26).and(MASK_14);

    iV = IntVector.fromArray(SPECIES_512, in, inpos + 80);
    oV = iV.and(0xff).lanewise(VectorOperators.LSHL, 6).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_512;

    iV.lanewise(VectorOperators.LSHR, 8).and(MASK_14).intoArray(out, outpos);
    outpos += VLEN_512;

    oV = iV.lanewise(VectorOperators.LSHR, 22).and(MASK_14);

    iV = IntVector.fromArray(SPECIES_512, in, inpos + 96);
    oV = iV.and(0xf).lanewise(VectorOperators.LSHL, 10).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_512;

    iV.lanewise(VectorOperators.LSHR, 4).and(MASK_14).intoArray(out, outpos);
    outpos += VLEN_512;

    iV.lanewise(VectorOperators.LSHR, 18).and(MASK_14).intoArray(out, outpos);
    outpos += VLEN_512;
  }

  private static void fastunpack15(final int[] in, int inpos, final int[] out,
                                   int outpos) {
    var iV = IntVector.fromArray(SPECIES_256, in, inpos);
    iV.and(MASK_15).intoArray(out, outpos);
    outpos += VLEN_256;

    iV.lanewise(VectorOperators.LSHR, 15).and(MASK_15).intoArray(out, outpos);
    outpos += VLEN_256;

    var oV = iV.lanewise(VectorOperators.LSHR, 30).and(MASK_15);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 8);
    oV = iV.and(0x1fff).lanewise(VectorOperators.LSHL, 2).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    iV.lanewise(VectorOperators.LSHR, 13).and(MASK_15).intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.lanewise(VectorOperators.LSHR, 28).and(MASK_15);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 16);
    oV = iV.and(0x7ff).lanewise(VectorOperators.LSHL, 4).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    iV.lanewise(VectorOperators.LSHR, 11).and(MASK_15).intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.lanewise(VectorOperators.LSHR, 26).and(MASK_15);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 24);
    oV = iV.and(0x1ff).lanewise(VectorOperators.LSHL, 6).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    iV.lanewise(VectorOperators.LSHR, 9).and(MASK_15).intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.lanewise(VectorOperators.LSHR, 24).and(MASK_15);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 32);
    oV = iV.and(0x7f).lanewise(VectorOperators.LSHL, 8).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    iV.lanewise(VectorOperators.LSHR, 7).and(MASK_15).intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.lanewise(VectorOperators.LSHR, 22).and(MASK_15);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 40);
    oV = iV.and(0x1f).lanewise(VectorOperators.LSHL, 10).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    iV.lanewise(VectorOperators.LSHR, 5).and(MASK_15).intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.lanewise(VectorOperators.LSHR, 20).and(MASK_15);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 48);
    oV = iV.and(7).lanewise(VectorOperators.LSHL, 12).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    iV.lanewise(VectorOperators.LSHR, 3).and(MASK_15).intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.lanewise(VectorOperators.LSHR, 18).and(MASK_15);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 56);
    oV = iV.and(1).lanewise(VectorOperators.LSHL, 14).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    iV.lanewise(VectorOperators.LSHR, 1).and(MASK_15).intoArray(out, outpos);
    outpos += VLEN_256;

    iV.lanewise(VectorOperators.LSHR, 16).and(MASK_15).intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.lanewise(VectorOperators.LSHR, 31).and(MASK_15);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 64);
    oV = iV.and(0x3fff).lanewise(VectorOperators.LSHL, 1).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    iV.lanewise(VectorOperators.LSHR, 14).and(MASK_15).intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.lanewise(VectorOperators.LSHR, 29).and(MASK_15);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 72);
    oV = iV.and(0xfff).lanewise(VectorOperators.LSHL, 3).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    iV.lanewise(VectorOperators.LSHR, 12).and(MASK_15).intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.lanewise(VectorOperators.LSHR, 27).and(MASK_15);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 80);
    oV = iV.and(0x3ff).lanewise(VectorOperators.LSHL, 5).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    iV.lanewise(VectorOperators.LSHR, 10).and(MASK_15).intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.lanewise(VectorOperators.LSHR, 25).and(MASK_15);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 88);
    oV = iV.and(0xff).lanewise(VectorOperators.LSHL, 7).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    iV.lanewise(VectorOperators.LSHR, 8).and(MASK_15).intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.lanewise(VectorOperators.LSHR, 23).and(MASK_15);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 96);
    oV = iV.and(0x3f).lanewise(VectorOperators.LSHL, 9).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    iV.lanewise(VectorOperators.LSHR, 6).and(MASK_15).intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.lanewise(VectorOperators.LSHR, 21).and(MASK_15);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 104);
    oV = iV.and(0xf).lanewise(VectorOperators.LSHL, 11).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    iV.lanewise(VectorOperators.LSHR, 4).and(MASK_15).intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.lanewise(VectorOperators.LSHR, 19).and(MASK_15);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 112);
    oV = iV.and(3).lanewise(VectorOperators.LSHL, 13).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    iV.lanewise(VectorOperators.LSHR, 2).and(MASK_15).intoArray(out, outpos);
    outpos += VLEN_256;

    iV.lanewise(VectorOperators.LSHR, 17).and(MASK_15).intoArray(out, outpos);
    outpos += VLEN_256;
  }

  private static void fastunpack16(final int[] in, int inpos, final int[] out,
                                   int outpos) {
    var iV = IntVector.fromArray(SPECIES_512, in, inpos);
    iV.and(MASK_16).intoArray(out, outpos);
    outpos += VLEN_512;

    iV.lanewise(VectorOperators.LSHR, 16).and(MASK_16).intoArray(out, outpos);
    outpos += VLEN_512;

    var oV = iV.and(MASK_16);
    oV = oV.zero(SPECIES_512);

    iV = IntVector.fromArray(SPECIES_512, in, inpos + 16);
    oV = iV.and(0xffff).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_512;

    iV.lanewise(VectorOperators.LSHR, 16).and(MASK_16).intoArray(out, outpos);
    outpos += VLEN_512;

    oV = oV.zero(SPECIES_512);

    iV = IntVector.fromArray(SPECIES_512, in, inpos + 32);
    oV = iV.and(0xffff).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_512;

    iV.lanewise(VectorOperators.LSHR, 16).and(MASK_16).intoArray(out, outpos);
    outpos += VLEN_512;

    oV = oV.zero(SPECIES_512);

    iV = IntVector.fromArray(SPECIES_512, in, inpos + 48);
    oV = iV.and(0xffff).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_512;

    iV.lanewise(VectorOperators.LSHR, 16).and(MASK_16).intoArray(out, outpos);
    outpos += VLEN_512;

    oV = oV.zero(SPECIES_512);

    iV = IntVector.fromArray(SPECIES_512, in, inpos + 64);
    oV = iV.and(0xffff).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_512;

    iV.lanewise(VectorOperators.LSHR, 16).and(MASK_16).intoArray(out, outpos);
    outpos += VLEN_512;

    oV = oV.zero(SPECIES_512);

    iV = IntVector.fromArray(SPECIES_512, in, inpos + 80);
    oV = iV.and(0xffff).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_512;

    iV.lanewise(VectorOperators.LSHR, 16).and(MASK_16).intoArray(out, outpos);
    outpos += VLEN_512;

    oV = oV.zero(SPECIES_512);

    iV = IntVector.fromArray(SPECIES_512, in, inpos + 96);
    oV = iV.and(0xffff).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_512;

    iV.lanewise(VectorOperators.LSHR, 16).and(MASK_16).intoArray(out, outpos);
    outpos += VLEN_512;

    oV = oV.zero(SPECIES_512);

    iV = IntVector.fromArray(SPECIES_512, in, inpos + 112);
    oV = iV.and(0xffff).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_512;

    iV.lanewise(VectorOperators.LSHR, 16).and(MASK_16).intoArray(out, outpos);
    outpos += VLEN_512;
  }

  private static void fastunpack17(final int[] in, int inpos, final int[] out,
                                   int outpos) {
    var iV = IntVector.fromArray(SPECIES_256, in, inpos);
    iV.and(MASK_17).intoArray(out, outpos);
    outpos += VLEN_256;

    var oV = iV.lanewise(VectorOperators.LSHR, 17).and(MASK_17);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 8);
    oV = iV.and(3).lanewise(VectorOperators.LSHL, 15).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    iV.lanewise(VectorOperators.LSHR, 2).and(MASK_17).intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.lanewise(VectorOperators.LSHR, 19).and(MASK_17);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 16);
    oV = iV.and(0xf).lanewise(VectorOperators.LSHL, 13).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    iV.lanewise(VectorOperators.LSHR, 4).and(MASK_17).intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.lanewise(VectorOperators.LSHR, 21).and(MASK_17);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 24);
    oV = iV.and(0x3f).lanewise(VectorOperators.LSHL, 11).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    iV.lanewise(VectorOperators.LSHR, 6).and(MASK_17).intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.lanewise(VectorOperators.LSHR, 23).and(MASK_17);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 32);
    oV = iV.and(0xff).lanewise(VectorOperators.LSHL, 9).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    iV.lanewise(VectorOperators.LSHR, 8).and(MASK_17).intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.lanewise(VectorOperators.LSHR, 25).and(MASK_17);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 40);
    oV = iV.and(0x3ff).lanewise(VectorOperators.LSHL, 7).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    iV.lanewise(VectorOperators.LSHR, 10).and(MASK_17).intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.lanewise(VectorOperators.LSHR, 27).and(MASK_17);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 48);
    oV = iV.and(0xfff).lanewise(VectorOperators.LSHL, 5).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    iV.lanewise(VectorOperators.LSHR, 12).and(MASK_17).intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.lanewise(VectorOperators.LSHR, 29).and(MASK_17);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 56);
    oV = iV.and(0x3fff).lanewise(VectorOperators.LSHL, 3).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    iV.lanewise(VectorOperators.LSHR, 14).and(MASK_17).intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.lanewise(VectorOperators.LSHR, 31).and(MASK_17);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 64);
    oV = iV.and(0xffff).lanewise(VectorOperators.LSHL, 1).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.lanewise(VectorOperators.LSHR, 16).and(MASK_17);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 72);
    oV = iV.and(1).lanewise(VectorOperators.LSHL, 16).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    iV.lanewise(VectorOperators.LSHR, 1).and(MASK_17).intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.lanewise(VectorOperators.LSHR, 18).and(MASK_17);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 80);
    oV = iV.and(7).lanewise(VectorOperators.LSHL, 14).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    iV.lanewise(VectorOperators.LSHR, 3).and(MASK_17).intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.lanewise(VectorOperators.LSHR, 20).and(MASK_17);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 88);
    oV = iV.and(0x1f).lanewise(VectorOperators.LSHL, 12).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    iV.lanewise(VectorOperators.LSHR, 5).and(MASK_17).intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.lanewise(VectorOperators.LSHR, 22).and(MASK_17);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 96);
    oV = iV.and(0x7f).lanewise(VectorOperators.LSHL, 10).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    iV.lanewise(VectorOperators.LSHR, 7).and(MASK_17).intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.lanewise(VectorOperators.LSHR, 24).and(MASK_17);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 104);
    oV = iV.and(0x1ff).lanewise(VectorOperators.LSHL, 8).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    iV.lanewise(VectorOperators.LSHR, 9).and(MASK_17).intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.lanewise(VectorOperators.LSHR, 26).and(MASK_17);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 112);
    oV = iV.and(0x7ff).lanewise(VectorOperators.LSHL, 6).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    iV.lanewise(VectorOperators.LSHR, 11).and(MASK_17).intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.lanewise(VectorOperators.LSHR, 28).and(MASK_17);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 120);
    oV = iV.and(0x1fff).lanewise(VectorOperators.LSHL, 4).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    iV.lanewise(VectorOperators.LSHR, 13).and(MASK_17).intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.lanewise(VectorOperators.LSHR, 30).and(MASK_17);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 128);
    oV = iV.and(0x7fff).lanewise(VectorOperators.LSHL, 2).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    iV.lanewise(VectorOperators.LSHR, 15).and(MASK_17).intoArray(out, outpos);
    outpos += VLEN_256;
  }

  private static void fastunpack18(final int[] in, int inpos, final int[] out,
                                   int outpos) {
    var iV = IntVector.fromArray(SPECIES_512, in, inpos);
    iV.and(MASK_18).intoArray(out, outpos);
    outpos += VLEN_512;

    var oV = iV.lanewise(VectorOperators.LSHR, 18).and(MASK_18);

    iV = IntVector.fromArray(SPECIES_512, in, inpos + 16);
    oV = iV.and(0xf).lanewise(VectorOperators.LSHL, 14).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_512;

    iV.lanewise(VectorOperators.LSHR, 4).and(MASK_18).intoArray(out, outpos);
    outpos += VLEN_512;

    oV = iV.lanewise(VectorOperators.LSHR, 22).and(MASK_18);

    iV = IntVector.fromArray(SPECIES_512, in, inpos + 32);
    oV = iV.and(0xff).lanewise(VectorOperators.LSHL, 10).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_512;

    iV.lanewise(VectorOperators.LSHR, 8).and(MASK_18).intoArray(out, outpos);
    outpos += VLEN_512;

    oV = iV.lanewise(VectorOperators.LSHR, 26).and(MASK_18);

    iV = IntVector.fromArray(SPECIES_512, in, inpos + 48);
    oV = iV.and(0xfff).lanewise(VectorOperators.LSHL, 6).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_512;

    iV.lanewise(VectorOperators.LSHR, 12).and(MASK_18).intoArray(out, outpos);
    outpos += VLEN_512;

    oV = iV.lanewise(VectorOperators.LSHR, 30).and(MASK_18);

    iV = IntVector.fromArray(SPECIES_512, in, inpos + 64);
    oV = iV.and(0xffff).lanewise(VectorOperators.LSHL, 2).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_512;

    oV = iV.lanewise(VectorOperators.LSHR, 16).and(MASK_18);

    iV = IntVector.fromArray(SPECIES_512, in, inpos + 80);
    oV = iV.and(3).lanewise(VectorOperators.LSHL, 16).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_512;

    iV.lanewise(VectorOperators.LSHR, 2).and(MASK_18).intoArray(out, outpos);
    outpos += VLEN_512;

    oV = iV.lanewise(VectorOperators.LSHR, 20).and(MASK_18);

    iV = IntVector.fromArray(SPECIES_512, in, inpos + 96);
    oV = iV.and(0x3f).lanewise(VectorOperators.LSHL, 12).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_512;

    iV.lanewise(VectorOperators.LSHR, 6).and(MASK_18).intoArray(out, outpos);
    outpos += VLEN_512;

    oV = iV.lanewise(VectorOperators.LSHR, 24).and(MASK_18);

    iV = IntVector.fromArray(SPECIES_512, in, inpos + 112);
    oV = iV.and(0x3ff).lanewise(VectorOperators.LSHL, 8).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_512;

    iV.lanewise(VectorOperators.LSHR, 10).and(MASK_18).intoArray(out, outpos);
    outpos += VLEN_512;

    oV = iV.lanewise(VectorOperators.LSHR, 28).and(MASK_18);

    iV = IntVector.fromArray(SPECIES_512, in, inpos + 128);
    oV = iV.and(0x3fff).lanewise(VectorOperators.LSHL, 4).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_512;

    iV.lanewise(VectorOperators.LSHR, 14).and(MASK_18).intoArray(out, outpos);
    outpos += VLEN_512;
  }

  private static void fastunpack19(final int[] in, int inpos, final int[] out,
                                   int outpos) {
    var iV = IntVector.fromArray(SPECIES_256, in, inpos);
    iV.and(MASK_19).intoArray(out, outpos);
    outpos += VLEN_256;

    var oV = iV.lanewise(VectorOperators.LSHR, 19).and(MASK_19);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 8);
    oV = iV.and(0x3f).lanewise(VectorOperators.LSHL, 13).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    iV.lanewise(VectorOperators.LSHR, 6).and(MASK_19).intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.lanewise(VectorOperators.LSHR, 25).and(MASK_19);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 16);
    oV = iV.and(0xfff).lanewise(VectorOperators.LSHL, 7).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    iV.lanewise(VectorOperators.LSHR, 12).and(MASK_19).intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.lanewise(VectorOperators.LSHR, 31).and(MASK_19);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 24);
    oV = iV.and(0x3ffff).lanewise(VectorOperators.LSHL, 1).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.lanewise(VectorOperators.LSHR, 18).and(MASK_19);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 32);
    oV = iV.and(0x1f).lanewise(VectorOperators.LSHL, 14).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    iV.lanewise(VectorOperators.LSHR, 5).and(MASK_19).intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.lanewise(VectorOperators.LSHR, 24).and(MASK_19);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 40);
    oV = iV.and(0x7ff).lanewise(VectorOperators.LSHL, 8).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    iV.lanewise(VectorOperators.LSHR, 11).and(MASK_19).intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.lanewise(VectorOperators.LSHR, 30).and(MASK_19);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 48);
    oV = iV.and(0x1ffff).lanewise(VectorOperators.LSHL, 2).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.lanewise(VectorOperators.LSHR, 17).and(MASK_19);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 56);
    oV = iV.and(0xf).lanewise(VectorOperators.LSHL, 15).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    iV.lanewise(VectorOperators.LSHR, 4).and(MASK_19).intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.lanewise(VectorOperators.LSHR, 23).and(MASK_19);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 64);
    oV = iV.and(0x3ff).lanewise(VectorOperators.LSHL, 9).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    iV.lanewise(VectorOperators.LSHR, 10).and(MASK_19).intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.lanewise(VectorOperators.LSHR, 29).and(MASK_19);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 72);
    oV = iV.and(0xffff).lanewise(VectorOperators.LSHL, 3).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.lanewise(VectorOperators.LSHR, 16).and(MASK_19);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 80);
    oV = iV.and(7).lanewise(VectorOperators.LSHL, 16).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    iV.lanewise(VectorOperators.LSHR, 3).and(MASK_19).intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.lanewise(VectorOperators.LSHR, 22).and(MASK_19);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 88);
    oV = iV.and(0x1ff).lanewise(VectorOperators.LSHL, 10).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    iV.lanewise(VectorOperators.LSHR, 9).and(MASK_19).intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.lanewise(VectorOperators.LSHR, 28).and(MASK_19);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 96);
    oV = iV.and(0x7fff).lanewise(VectorOperators.LSHL, 4).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.lanewise(VectorOperators.LSHR, 15).and(MASK_19);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 104);
    oV = iV.and(3).lanewise(VectorOperators.LSHL, 17).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    iV.lanewise(VectorOperators.LSHR, 2).and(MASK_19).intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.lanewise(VectorOperators.LSHR, 21).and(MASK_19);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 112);
    oV = iV.and(0xff).lanewise(VectorOperators.LSHL, 11).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    iV.lanewise(VectorOperators.LSHR, 8).and(MASK_19).intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.lanewise(VectorOperators.LSHR, 27).and(MASK_19);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 120);
    oV = iV.and(0x3fff).lanewise(VectorOperators.LSHL, 5).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.lanewise(VectorOperators.LSHR, 14).and(MASK_19);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 128);
    oV = iV.and(1).lanewise(VectorOperators.LSHL, 18).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    iV.lanewise(VectorOperators.LSHR, 1).and(MASK_19).intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.lanewise(VectorOperators.LSHR, 20).and(MASK_19);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 136);
    oV = iV.and(0x7f).lanewise(VectorOperators.LSHL, 12).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    iV.lanewise(VectorOperators.LSHR, 7).and(MASK_19).intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.lanewise(VectorOperators.LSHR, 26).and(MASK_19);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 144);
    oV = iV.and(0x1fff).lanewise(VectorOperators.LSHL, 6).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    iV.lanewise(VectorOperators.LSHR, 13).and(MASK_19).intoArray(out, outpos);
    outpos += VLEN_256;
  }

  private static void fastunpack20(final int[] in, int inpos, final int[] out,
                                   int outpos) {
    var iV = IntVector.fromArray(SPECIES_512, in, inpos);
    iV.and(MASK_20).intoArray(out, outpos);
    outpos += VLEN_512;

    var oV = iV.lanewise(VectorOperators.LSHR, 20).and(MASK_20);

    iV = IntVector.fromArray(SPECIES_512, in, inpos + 16);
    oV = iV.and(0xff).lanewise(VectorOperators.LSHL, 12).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_512;

    iV.lanewise(VectorOperators.LSHR, 8).and(MASK_20).intoArray(out, outpos);
    outpos += VLEN_512;

    oV = iV.lanewise(VectorOperators.LSHR, 28).and(MASK_20);

    iV = IntVector.fromArray(SPECIES_512, in, inpos + 32);
    oV = iV.and(0xffff).lanewise(VectorOperators.LSHL, 4).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_512;

    oV = iV.lanewise(VectorOperators.LSHR, 16).and(MASK_20);

    iV = IntVector.fromArray(SPECIES_512, in, inpos + 48);
    oV = iV.and(0xf).lanewise(VectorOperators.LSHL, 16).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_512;

    iV.lanewise(VectorOperators.LSHR, 4).and(MASK_20).intoArray(out, outpos);
    outpos += VLEN_512;

    oV = iV.lanewise(VectorOperators.LSHR, 24).and(MASK_20);

    iV = IntVector.fromArray(SPECIES_512, in, inpos + 64);
    oV = iV.and(0xfff).lanewise(VectorOperators.LSHL, 8).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_512;

    iV.lanewise(VectorOperators.LSHR, 12).and(MASK_20).intoArray(out, outpos);
    outpos += VLEN_512;

    oV = oV.zero(SPECIES_512);

    iV = IntVector.fromArray(SPECIES_512, in, inpos + 80);
    oV = iV.and(0xfffff).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_512;

    oV = iV.lanewise(VectorOperators.LSHR, 20).and(MASK_20);

    iV = IntVector.fromArray(SPECIES_512, in, inpos + 96);
    oV = iV.and(0xff).lanewise(VectorOperators.LSHL, 12).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_512;

    iV.lanewise(VectorOperators.LSHR, 8).and(MASK_20).intoArray(out, outpos);
    outpos += VLEN_512;

    oV = iV.lanewise(VectorOperators.LSHR, 28).and(MASK_20);

    iV = IntVector.fromArray(SPECIES_512, in, inpos + 112);
    oV = iV.and(0xffff).lanewise(VectorOperators.LSHL, 4).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_512;

    oV = iV.lanewise(VectorOperators.LSHR, 16).and(MASK_20);

    iV = IntVector.fromArray(SPECIES_512, in, inpos + 128);
    oV = iV.and(0xf).lanewise(VectorOperators.LSHL, 16).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_512;

    iV.lanewise(VectorOperators.LSHR, 4).and(MASK_20).intoArray(out, outpos);
    outpos += VLEN_512;

    oV = iV.lanewise(VectorOperators.LSHR, 24).and(MASK_20);

    iV = IntVector.fromArray(SPECIES_512, in, inpos + 144);
    oV = iV.and(0xfff).lanewise(VectorOperators.LSHL, 8).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_512;

    iV.lanewise(VectorOperators.LSHR, 12).and(MASK_20).intoArray(out, outpos);
    outpos += VLEN_512;
  }

  private static void fastunpack21(final int[] in, int inpos, final int[] out,
                                   int outpos) {
    var iV = IntVector.fromArray(SPECIES_256, in, inpos);
    iV.and(MASK_21).intoArray(out, outpos);
    outpos += VLEN_256;

    var oV = iV.lanewise(VectorOperators.LSHR, 21).and(MASK_21);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 8);
    oV = iV.and(0x3ff).lanewise(VectorOperators.LSHL, 11).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    iV.lanewise(VectorOperators.LSHR, 10).and(MASK_21).intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.lanewise(VectorOperators.LSHR, 31).and(MASK_21);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 16);
    oV = iV.and(0xfffff).lanewise(VectorOperators.LSHL, 1).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.lanewise(VectorOperators.LSHR, 20).and(MASK_21);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 24);
    oV = iV.and(0x1ff).lanewise(VectorOperators.LSHL, 12).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    iV.lanewise(VectorOperators.LSHR, 9).and(MASK_21).intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.lanewise(VectorOperators.LSHR, 30).and(MASK_21);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 32);
    oV = iV.and(0x7ffff).lanewise(VectorOperators.LSHL, 2).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.lanewise(VectorOperators.LSHR, 19).and(MASK_21);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 40);
    oV = iV.and(0xff).lanewise(VectorOperators.LSHL, 13).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    iV.lanewise(VectorOperators.LSHR, 8).and(MASK_21).intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.lanewise(VectorOperators.LSHR, 29).and(MASK_21);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 48);
    oV = iV.and(0x3ffff).lanewise(VectorOperators.LSHL, 3).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.lanewise(VectorOperators.LSHR, 18).and(MASK_21);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 56);
    oV = iV.and(0x7f).lanewise(VectorOperators.LSHL, 14).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    iV.lanewise(VectorOperators.LSHR, 7).and(MASK_21).intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.lanewise(VectorOperators.LSHR, 28).and(MASK_21);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 64);
    oV = iV.and(0x1ffff).lanewise(VectorOperators.LSHL, 4).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.lanewise(VectorOperators.LSHR, 17).and(MASK_21);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 72);
    oV = iV.and(0x3f).lanewise(VectorOperators.LSHL, 15).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    iV.lanewise(VectorOperators.LSHR, 6).and(MASK_21).intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.lanewise(VectorOperators.LSHR, 27).and(MASK_21);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 80);
    oV = iV.and(0xffff).lanewise(VectorOperators.LSHL, 5).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.lanewise(VectorOperators.LSHR, 16).and(MASK_21);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 88);
    oV = iV.and(0x1f).lanewise(VectorOperators.LSHL, 16).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    iV.lanewise(VectorOperators.LSHR, 5).and(MASK_21).intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.lanewise(VectorOperators.LSHR, 26).and(MASK_21);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 96);
    oV = iV.and(0x7fff).lanewise(VectorOperators.LSHL, 6).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.lanewise(VectorOperators.LSHR, 15).and(MASK_21);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 104);
    oV = iV.and(0xf).lanewise(VectorOperators.LSHL, 17).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    iV.lanewise(VectorOperators.LSHR, 4).and(MASK_21).intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.lanewise(VectorOperators.LSHR, 25).and(MASK_21);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 112);
    oV = iV.and(0x3fff).lanewise(VectorOperators.LSHL, 7).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.lanewise(VectorOperators.LSHR, 14).and(MASK_21);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 120);
    oV = iV.and(7).lanewise(VectorOperators.LSHL, 18).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    iV.lanewise(VectorOperators.LSHR, 3).and(MASK_21).intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.lanewise(VectorOperators.LSHR, 24).and(MASK_21);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 128);
    oV = iV.and(0x1fff).lanewise(VectorOperators.LSHL, 8).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.lanewise(VectorOperators.LSHR, 13).and(MASK_21);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 136);
    oV = iV.and(3).lanewise(VectorOperators.LSHL, 19).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    iV.lanewise(VectorOperators.LSHR, 2).and(MASK_21).intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.lanewise(VectorOperators.LSHR, 23).and(MASK_21);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 144);
    oV = iV.and(0xfff).lanewise(VectorOperators.LSHL, 9).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.lanewise(VectorOperators.LSHR, 12).and(MASK_21);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 152);
    oV = iV.and(1).lanewise(VectorOperators.LSHL, 20).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    iV.lanewise(VectorOperators.LSHR, 1).and(MASK_21).intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.lanewise(VectorOperators.LSHR, 22).and(MASK_21);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 160);
    oV = iV.and(0x7ff).lanewise(VectorOperators.LSHL, 10).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    iV.lanewise(VectorOperators.LSHR, 11).and(MASK_21).intoArray(out, outpos);
    outpos += VLEN_256;
  }

  private static void fastunpack22(final int[] in, int inpos, final int[] out,
                                   int outpos) {
    var iV = IntVector.fromArray(SPECIES_512, in, inpos);
    iV.and(MASK_22).intoArray(out, outpos);
    outpos += VLEN_512;

    var oV = iV.lanewise(VectorOperators.LSHR, 22).and(MASK_22);

    iV = IntVector.fromArray(SPECIES_512, in, inpos + 16);
    oV = iV.and(0xfff).lanewise(VectorOperators.LSHL, 10).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_512;

    oV = iV.lanewise(VectorOperators.LSHR, 12).and(MASK_22);

    iV = IntVector.fromArray(SPECIES_512, in, inpos + 32);
    oV = iV.and(3).lanewise(VectorOperators.LSHL, 20).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_512;

    iV.lanewise(VectorOperators.LSHR, 2).and(MASK_22).intoArray(out, outpos);
    outpos += VLEN_512;

    oV = iV.lanewise(VectorOperators.LSHR, 24).and(MASK_22);

    iV = IntVector.fromArray(SPECIES_512, in, inpos + 48);
    oV = iV.and(0x3fff).lanewise(VectorOperators.LSHL, 8).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_512;

    oV = iV.lanewise(VectorOperators.LSHR, 14).and(MASK_22);

    iV = IntVector.fromArray(SPECIES_512, in, inpos + 64);
    oV = iV.and(0xf).lanewise(VectorOperators.LSHL, 18).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_512;

    iV.lanewise(VectorOperators.LSHR, 4).and(MASK_22).intoArray(out, outpos);
    outpos += VLEN_512;

    oV = iV.lanewise(VectorOperators.LSHR, 26).and(MASK_22);

    iV = IntVector.fromArray(SPECIES_512, in, inpos + 80);
    oV = iV.and(0xffff).lanewise(VectorOperators.LSHL, 6).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_512;

    oV = iV.lanewise(VectorOperators.LSHR, 16).and(MASK_22);

    iV = IntVector.fromArray(SPECIES_512, in, inpos + 96);
    oV = iV.and(0x3f).lanewise(VectorOperators.LSHL, 16).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_512;

    iV.lanewise(VectorOperators.LSHR, 6).and(MASK_22).intoArray(out, outpos);
    outpos += VLEN_512;

    oV = iV.lanewise(VectorOperators.LSHR, 28).and(MASK_22);

    iV = IntVector.fromArray(SPECIES_512, in, inpos + 112);
    oV = iV.and(0x3ffff).lanewise(VectorOperators.LSHL, 4).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_512;

    oV = iV.lanewise(VectorOperators.LSHR, 18).and(MASK_22);

    iV = IntVector.fromArray(SPECIES_512, in, inpos + 128);
    oV = iV.and(0xff).lanewise(VectorOperators.LSHL, 14).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_512;

    iV.lanewise(VectorOperators.LSHR, 8).and(MASK_22).intoArray(out, outpos);
    outpos += VLEN_512;

    oV = iV.lanewise(VectorOperators.LSHR, 30).and(MASK_22);

    iV = IntVector.fromArray(SPECIES_512, in, inpos + 144);
    oV = iV.and(0xfffff).lanewise(VectorOperators.LSHL, 2).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_512;

    oV = iV.lanewise(VectorOperators.LSHR, 20).and(MASK_22);

    iV = IntVector.fromArray(SPECIES_512, in, inpos + 160);
    oV = iV.and(0x3ff).lanewise(VectorOperators.LSHL, 12).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_512;

    iV.lanewise(VectorOperators.LSHR, 10).and(MASK_22).intoArray(out, outpos);
    outpos += VLEN_512;
  }

  private static void fastunpack23(final int[] in, int inpos, final int[] out,
                                   int outpos) {
    var iV = IntVector.fromArray(SPECIES_256, in, inpos);
    iV.and(MASK_23).intoArray(out, outpos);
    outpos += VLEN_256;

    var oV = iV.lanewise(VectorOperators.LSHR, 23).and(MASK_23);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 8);
    oV = iV.and(0x3fff).lanewise(VectorOperators.LSHL, 9).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.lanewise(VectorOperators.LSHR, 14).and(MASK_23);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 16);
    oV = iV.and(0x1f).lanewise(VectorOperators.LSHL, 18).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    iV.lanewise(VectorOperators.LSHR, 5).and(MASK_23).intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.lanewise(VectorOperators.LSHR, 28).and(MASK_23);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 24);
    oV = iV.and(0x7ffff).lanewise(VectorOperators.LSHL, 4).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.lanewise(VectorOperators.LSHR, 19).and(MASK_23);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 32);
    oV = iV.and(0x3ff).lanewise(VectorOperators.LSHL, 13).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.lanewise(VectorOperators.LSHR, 10).and(MASK_23);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 40);
    oV = iV.and(1).lanewise(VectorOperators.LSHL, 22).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    iV.lanewise(VectorOperators.LSHR, 1).and(MASK_23).intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.lanewise(VectorOperators.LSHR, 24).and(MASK_23);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 48);
    oV = iV.and(0x7fff).lanewise(VectorOperators.LSHL, 8).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.lanewise(VectorOperators.LSHR, 15).and(MASK_23);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 56);
    oV = iV.and(0x3f).lanewise(VectorOperators.LSHL, 17).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    iV.lanewise(VectorOperators.LSHR, 6).and(MASK_23).intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.lanewise(VectorOperators.LSHR, 29).and(MASK_23);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 64);
    oV = iV.and(0xfffff).lanewise(VectorOperators.LSHL, 3).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.lanewise(VectorOperators.LSHR, 20).and(MASK_23);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 72);
    oV = iV.and(0x7ff).lanewise(VectorOperators.LSHL, 12).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.lanewise(VectorOperators.LSHR, 11).and(MASK_23);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 80);
    oV = iV.and(3).lanewise(VectorOperators.LSHL, 21).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    iV.lanewise(VectorOperators.LSHR, 2).and(MASK_23).intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.lanewise(VectorOperators.LSHR, 25).and(MASK_23);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 88);
    oV = iV.and(0xffff).lanewise(VectorOperators.LSHL, 7).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.lanewise(VectorOperators.LSHR, 16).and(MASK_23);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 96);
    oV = iV.and(0x7f).lanewise(VectorOperators.LSHL, 16).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    iV.lanewise(VectorOperators.LSHR, 7).and(MASK_23).intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.lanewise(VectorOperators.LSHR, 30).and(MASK_23);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 104);
    oV = iV.and(0x1fffff).lanewise(VectorOperators.LSHL, 2).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.lanewise(VectorOperators.LSHR, 21).and(MASK_23);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 112);
    oV = iV.and(0xfff).lanewise(VectorOperators.LSHL, 11).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.lanewise(VectorOperators.LSHR, 12).and(MASK_23);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 120);
    oV = iV.and(7).lanewise(VectorOperators.LSHL, 20).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    iV.lanewise(VectorOperators.LSHR, 3).and(MASK_23).intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.lanewise(VectorOperators.LSHR, 26).and(MASK_23);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 128);
    oV = iV.and(0x1ffff).lanewise(VectorOperators.LSHL, 6).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.lanewise(VectorOperators.LSHR, 17).and(MASK_23);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 136);
    oV = iV.and(0xff).lanewise(VectorOperators.LSHL, 15).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    iV.lanewise(VectorOperators.LSHR, 8).and(MASK_23).intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.lanewise(VectorOperators.LSHR, 31).and(MASK_23);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 144);
    oV = iV.and(0x3fffff).lanewise(VectorOperators.LSHL, 1).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.lanewise(VectorOperators.LSHR, 22).and(MASK_23);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 152);
    oV = iV.and(0x1fff).lanewise(VectorOperators.LSHL, 10).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.lanewise(VectorOperators.LSHR, 13).and(MASK_23);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 160);
    oV = iV.and(0xf).lanewise(VectorOperators.LSHL, 19).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    iV.lanewise(VectorOperators.LSHR, 4).and(MASK_23).intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.lanewise(VectorOperators.LSHR, 27).and(MASK_23);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 168);
    oV = iV.and(0x3ffff).lanewise(VectorOperators.LSHL, 5).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.lanewise(VectorOperators.LSHR, 18).and(MASK_23);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 176);
    oV = iV.and(0x1ff).lanewise(VectorOperators.LSHL, 14).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    iV.lanewise(VectorOperators.LSHR, 9).and(MASK_23).intoArray(out, outpos);
    outpos += VLEN_256;
  }

  private static void fastunpack24(final int[] in, int inpos, final int[] out,
                                   int outpos) {
    var iV = IntVector.fromArray(SPECIES_512, in, inpos);
    iV.and(MASK_24).intoArray(out, outpos);
    outpos += VLEN_512;

    var oV = iV.lanewise(VectorOperators.LSHR, 24).and(MASK_24);

    iV = IntVector.fromArray(SPECIES_512, in, inpos + 16);
    oV = iV.and(0xffff).lanewise(VectorOperators.LSHL, 8).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_512;

    oV = iV.lanewise(VectorOperators.LSHR, 16).and(MASK_24);

    iV = IntVector.fromArray(SPECIES_512, in, inpos + 32);
    oV = iV.and(0xff).lanewise(VectorOperators.LSHL, 16).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_512;

    iV.lanewise(VectorOperators.LSHR, 8).and(MASK_24).intoArray(out, outpos);
    outpos += VLEN_512;

    oV = oV.zero(SPECIES_512);

    iV = IntVector.fromArray(SPECIES_512, in, inpos + 48);
    oV = iV.and(0xffffff).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_512;

    oV = iV.lanewise(VectorOperators.LSHR, 24).and(MASK_24);

    iV = IntVector.fromArray(SPECIES_512, in, inpos + 64);
    oV = iV.and(0xffff).lanewise(VectorOperators.LSHL, 8).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_512;

    oV = iV.lanewise(VectorOperators.LSHR, 16).and(MASK_24);

    iV = IntVector.fromArray(SPECIES_512, in, inpos + 80);
    oV = iV.and(0xff).lanewise(VectorOperators.LSHL, 16).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_512;

    iV.lanewise(VectorOperators.LSHR, 8).and(MASK_24).intoArray(out, outpos);
    outpos += VLEN_512;

    oV = oV.zero(SPECIES_512);

    iV = IntVector.fromArray(SPECIES_512, in, inpos + 96);
    oV = iV.and(0xffffff).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_512;

    oV = iV.lanewise(VectorOperators.LSHR, 24).and(MASK_24);

    iV = IntVector.fromArray(SPECIES_512, in, inpos + 112);
    oV = iV.and(0xffff).lanewise(VectorOperators.LSHL, 8).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_512;

    oV = iV.lanewise(VectorOperators.LSHR, 16).and(MASK_24);

    iV = IntVector.fromArray(SPECIES_512, in, inpos + 128);
    oV = iV.and(0xff).lanewise(VectorOperators.LSHL, 16).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_512;

    iV.lanewise(VectorOperators.LSHR, 8).and(MASK_24).intoArray(out, outpos);
    outpos += VLEN_512;

    oV = oV.zero(SPECIES_512);

    iV = IntVector.fromArray(SPECIES_512, in, inpos + 144);
    oV = iV.and(0xffffff).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_512;

    oV = iV.lanewise(VectorOperators.LSHR, 24).and(MASK_24);

    iV = IntVector.fromArray(SPECIES_512, in, inpos + 160);
    oV = iV.and(0xffff).lanewise(VectorOperators.LSHL, 8).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_512;

    oV = iV.lanewise(VectorOperators.LSHR, 16).and(MASK_24);

    iV = IntVector.fromArray(SPECIES_512, in, inpos + 176);
    oV = iV.and(0xff).lanewise(VectorOperators.LSHL, 16).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_512;

    iV.lanewise(VectorOperators.LSHR, 8).and(MASK_24).intoArray(out, outpos);
    outpos += VLEN_512;
  }

  private static void fastunpack25(final int[] in, int inpos, final int[] out,
                                   int outpos) {
    var iV = IntVector.fromArray(SPECIES_256, in, inpos);
    iV.and(MASK_25).intoArray(out, outpos);
    outpos += VLEN_256;

    var oV = iV.lanewise(VectorOperators.LSHR, 25).and(MASK_25);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 8);
    oV = iV.and(0x3ffff).lanewise(VectorOperators.LSHL, 7).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.lanewise(VectorOperators.LSHR, 18).and(MASK_25);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 16);
    oV = iV.and(0x7ff).lanewise(VectorOperators.LSHL, 14).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.lanewise(VectorOperators.LSHR, 11).and(MASK_25);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 24);
    oV = iV.and(0xf).lanewise(VectorOperators.LSHL, 21).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    iV.lanewise(VectorOperators.LSHR, 4).and(MASK_25).intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.lanewise(VectorOperators.LSHR, 29).and(MASK_25);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 32);
    oV = iV.and(0x3fffff).lanewise(VectorOperators.LSHL, 3).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.lanewise(VectorOperators.LSHR, 22).and(MASK_25);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 40);
    oV = iV.and(0x7fff).lanewise(VectorOperators.LSHL, 10).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.lanewise(VectorOperators.LSHR, 15).and(MASK_25);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 48);
    oV = iV.and(0xff).lanewise(VectorOperators.LSHL, 17).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.lanewise(VectorOperators.LSHR, 8).and(MASK_25);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 56);
    oV = iV.and(1).lanewise(VectorOperators.LSHL, 24).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    iV.lanewise(VectorOperators.LSHR, 1).and(MASK_25).intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.lanewise(VectorOperators.LSHR, 26).and(MASK_25);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 64);
    oV = iV.and(0x7ffff).lanewise(VectorOperators.LSHL, 6).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.lanewise(VectorOperators.LSHR, 19).and(MASK_25);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 72);
    oV = iV.and(0xfff).lanewise(VectorOperators.LSHL, 13).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.lanewise(VectorOperators.LSHR, 12).and(MASK_25);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 80);
    oV = iV.and(0x1f).lanewise(VectorOperators.LSHL, 20).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    iV.lanewise(VectorOperators.LSHR, 5).and(MASK_25).intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.lanewise(VectorOperators.LSHR, 30).and(MASK_25);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 88);
    oV = iV.and(0x7fffff).lanewise(VectorOperators.LSHL, 2).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.lanewise(VectorOperators.LSHR, 23).and(MASK_25);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 96);
    oV = iV.and(0xffff).lanewise(VectorOperators.LSHL, 9).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.lanewise(VectorOperators.LSHR, 16).and(MASK_25);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 104);
    oV = iV.and(0x1ff).lanewise(VectorOperators.LSHL, 16).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.lanewise(VectorOperators.LSHR, 9).and(MASK_25);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 112);
    oV = iV.and(3).lanewise(VectorOperators.LSHL, 23).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    iV.lanewise(VectorOperators.LSHR, 2).and(MASK_25).intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.lanewise(VectorOperators.LSHR, 27).and(MASK_25);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 120);
    oV = iV.and(0xfffff).lanewise(VectorOperators.LSHL, 5).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.lanewise(VectorOperators.LSHR, 20).and(MASK_25);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 128);
    oV = iV.and(0x1fff).lanewise(VectorOperators.LSHL, 12).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.lanewise(VectorOperators.LSHR, 13).and(MASK_25);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 136);
    oV = iV.and(0x3f).lanewise(VectorOperators.LSHL, 19).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    iV.lanewise(VectorOperators.LSHR, 6).and(MASK_25).intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.lanewise(VectorOperators.LSHR, 31).and(MASK_25);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 144);
    oV = iV.and(0xffffff).lanewise(VectorOperators.LSHL, 1).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.lanewise(VectorOperators.LSHR, 24).and(MASK_25);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 152);
    oV = iV.and(0x1ffff).lanewise(VectorOperators.LSHL, 8).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.lanewise(VectorOperators.LSHR, 17).and(MASK_25);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 160);
    oV = iV.and(0x3ff).lanewise(VectorOperators.LSHL, 15).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.lanewise(VectorOperators.LSHR, 10).and(MASK_25);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 168);
    oV = iV.and(7).lanewise(VectorOperators.LSHL, 22).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    iV.lanewise(VectorOperators.LSHR, 3).and(MASK_25).intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.lanewise(VectorOperators.LSHR, 28).and(MASK_25);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 176);
    oV = iV.and(0x1fffff).lanewise(VectorOperators.LSHL, 4).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.lanewise(VectorOperators.LSHR, 21).and(MASK_25);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 184);
    oV = iV.and(0x3fff).lanewise(VectorOperators.LSHL, 11).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.lanewise(VectorOperators.LSHR, 14).and(MASK_25);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 192);
    oV = iV.and(0x7f).lanewise(VectorOperators.LSHL, 18).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    iV.lanewise(VectorOperators.LSHR, 7).and(MASK_25).intoArray(out, outpos);
    outpos += VLEN_256;
  }

  private static void fastunpack26(final int[] in, int inpos, final int[] out,
                                   int outpos) {
    var iV = IntVector.fromArray(SPECIES_512, in, inpos);
    iV.and(MASK_26).intoArray(out, outpos);
    outpos += VLEN_512;

    var oV = iV.lanewise(VectorOperators.LSHR, 26).and(MASK_26);

    iV = IntVector.fromArray(SPECIES_512, in, inpos + 16);
    oV = iV.and(0xfffff).lanewise(VectorOperators.LSHL, 6).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_512;

    oV = iV.lanewise(VectorOperators.LSHR, 20).and(MASK_26);

    iV = IntVector.fromArray(SPECIES_512, in, inpos + 32);
    oV = iV.and(0x3fff).lanewise(VectorOperators.LSHL, 12).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_512;

    oV = iV.lanewise(VectorOperators.LSHR, 14).and(MASK_26);

    iV = IntVector.fromArray(SPECIES_512, in, inpos + 48);
    oV = iV.and(0xff).lanewise(VectorOperators.LSHL, 18).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_512;

    oV = iV.lanewise(VectorOperators.LSHR, 8).and(MASK_26);

    iV = IntVector.fromArray(SPECIES_512, in, inpos + 64);
    oV = iV.and(3).lanewise(VectorOperators.LSHL, 24).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_512;

    iV.lanewise(VectorOperators.LSHR, 2).and(MASK_26).intoArray(out, outpos);
    outpos += VLEN_512;

    oV = iV.lanewise(VectorOperators.LSHR, 28).and(MASK_26);

    iV = IntVector.fromArray(SPECIES_512, in, inpos + 80);
    oV = iV.and(0x3fffff).lanewise(VectorOperators.LSHL, 4).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_512;

    oV = iV.lanewise(VectorOperators.LSHR, 22).and(MASK_26);

    iV = IntVector.fromArray(SPECIES_512, in, inpos + 96);
    oV = iV.and(0xffff).lanewise(VectorOperators.LSHL, 10).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_512;

    oV = iV.lanewise(VectorOperators.LSHR, 16).and(MASK_26);

    iV = IntVector.fromArray(SPECIES_512, in, inpos + 112);
    oV = iV.and(0x3ff).lanewise(VectorOperators.LSHL, 16).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_512;

    oV = iV.lanewise(VectorOperators.LSHR, 10).and(MASK_26);

    iV = IntVector.fromArray(SPECIES_512, in, inpos + 128);
    oV = iV.and(0xf).lanewise(VectorOperators.LSHL, 22).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_512;

    iV.lanewise(VectorOperators.LSHR, 4).and(MASK_26).intoArray(out, outpos);
    outpos += VLEN_512;

    oV = iV.lanewise(VectorOperators.LSHR, 30).and(MASK_26);

    iV = IntVector.fromArray(SPECIES_512, in, inpos + 144);
    oV = iV.and(0xffffff).lanewise(VectorOperators.LSHL, 2).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_512;

    oV = iV.lanewise(VectorOperators.LSHR, 24).and(MASK_26);

    iV = IntVector.fromArray(SPECIES_512, in, inpos + 160);
    oV = iV.and(0x3ffff).lanewise(VectorOperators.LSHL, 8).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_512;

    oV = iV.lanewise(VectorOperators.LSHR, 18).and(MASK_26);

    iV = IntVector.fromArray(SPECIES_512, in, inpos + 176);
    oV = iV.and(0xfff).lanewise(VectorOperators.LSHL, 14).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_512;

    oV = iV.lanewise(VectorOperators.LSHR, 12).and(MASK_26);

    iV = IntVector.fromArray(SPECIES_512, in, inpos + 192);
    oV = iV.and(0x3f).lanewise(VectorOperators.LSHL, 20).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_512;

    iV.lanewise(VectorOperators.LSHR, 6).and(MASK_26).intoArray(out, outpos);
    outpos += VLEN_512;
  }

  private static void fastunpack27(final int[] in, int inpos, final int[] out,
                                   int outpos) {
    var iV = IntVector.fromArray(SPECIES_256, in, inpos);
    iV.and(MASK_27).intoArray(out, outpos);
    outpos += VLEN_256;

    var oV = iV.lanewise(VectorOperators.LSHR, 27).and(MASK_27);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 8);
    oV = iV.and(0x3fffff).lanewise(VectorOperators.LSHL, 5).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.lanewise(VectorOperators.LSHR, 22).and(MASK_27);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 16);
    oV = iV.and(0x1ffff).lanewise(VectorOperators.LSHL, 10).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.lanewise(VectorOperators.LSHR, 17).and(MASK_27);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 24);
    oV = iV.and(0xfff).lanewise(VectorOperators.LSHL, 15).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.lanewise(VectorOperators.LSHR, 12).and(MASK_27);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 32);
    oV = iV.and(0x7f).lanewise(VectorOperators.LSHL, 20).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.lanewise(VectorOperators.LSHR, 7).and(MASK_27);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 40);
    oV = iV.and(3).lanewise(VectorOperators.LSHL, 25).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    iV.lanewise(VectorOperators.LSHR, 2).and(MASK_27).intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.lanewise(VectorOperators.LSHR, 29).and(MASK_27);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 48);
    oV = iV.and(0xffffff).lanewise(VectorOperators.LSHL, 3).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.lanewise(VectorOperators.LSHR, 24).and(MASK_27);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 56);
    oV = iV.and(0x7ffff).lanewise(VectorOperators.LSHL, 8).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.lanewise(VectorOperators.LSHR, 19).and(MASK_27);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 64);
    oV = iV.and(0x3fff).lanewise(VectorOperators.LSHL, 13).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.lanewise(VectorOperators.LSHR, 14).and(MASK_27);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 72);
    oV = iV.and(0x1ff).lanewise(VectorOperators.LSHL, 18).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.lanewise(VectorOperators.LSHR, 9).and(MASK_27);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 80);
    oV = iV.and(0xf).lanewise(VectorOperators.LSHL, 23).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    iV.lanewise(VectorOperators.LSHR, 4).and(MASK_27).intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.lanewise(VectorOperators.LSHR, 31).and(MASK_27);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 88);
    oV = iV.and(0x3ffffff).lanewise(VectorOperators.LSHL, 1).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.lanewise(VectorOperators.LSHR, 26).and(MASK_27);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 96);
    oV = iV.and(0x1fffff).lanewise(VectorOperators.LSHL, 6).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.lanewise(VectorOperators.LSHR, 21).and(MASK_27);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 104);
    oV = iV.and(0xffff).lanewise(VectorOperators.LSHL, 11).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.lanewise(VectorOperators.LSHR, 16).and(MASK_27);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 112);
    oV = iV.and(0x7ff).lanewise(VectorOperators.LSHL, 16).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.lanewise(VectorOperators.LSHR, 11).and(MASK_27);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 120);
    oV = iV.and(0x3f).lanewise(VectorOperators.LSHL, 21).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.lanewise(VectorOperators.LSHR, 6).and(MASK_27);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 128);
    oV = iV.and(1).lanewise(VectorOperators.LSHL, 26).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    iV.lanewise(VectorOperators.LSHR, 1).and(MASK_27).intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.lanewise(VectorOperators.LSHR, 28).and(MASK_27);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 136);
    oV = iV.and(0x7fffff).lanewise(VectorOperators.LSHL, 4).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.lanewise(VectorOperators.LSHR, 23).and(MASK_27);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 144);
    oV = iV.and(0x3ffff).lanewise(VectorOperators.LSHL, 9).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.lanewise(VectorOperators.LSHR, 18).and(MASK_27);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 152);
    oV = iV.and(0x1fff).lanewise(VectorOperators.LSHL, 14).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.lanewise(VectorOperators.LSHR, 13).and(MASK_27);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 160);
    oV = iV.and(0xff).lanewise(VectorOperators.LSHL, 19).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.lanewise(VectorOperators.LSHR, 8).and(MASK_27);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 168);
    oV = iV.and(7).lanewise(VectorOperators.LSHL, 24).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    iV.lanewise(VectorOperators.LSHR, 3).and(MASK_27).intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.lanewise(VectorOperators.LSHR, 30).and(MASK_27);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 176);
    oV = iV.and(0x1ffffff).lanewise(VectorOperators.LSHL, 2).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.lanewise(VectorOperators.LSHR, 25).and(MASK_27);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 184);
    oV = iV.and(0xfffff).lanewise(VectorOperators.LSHL, 7).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.lanewise(VectorOperators.LSHR, 20).and(MASK_27);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 192);
    oV = iV.and(0x7fff).lanewise(VectorOperators.LSHL, 12).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.lanewise(VectorOperators.LSHR, 15).and(MASK_27);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 200);
    oV = iV.and(0x3ff).lanewise(VectorOperators.LSHL, 17).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.lanewise(VectorOperators.LSHR, 10).and(MASK_27);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 208);
    oV = iV.and(0x1f).lanewise(VectorOperators.LSHL, 22).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    iV.lanewise(VectorOperators.LSHR, 5).and(MASK_27).intoArray(out, outpos);
    outpos += VLEN_256;
  }

  private static void fastunpack28(final int[] in, int inpos, final int[] out,
                                   int outpos) {
    var iV = IntVector.fromArray(SPECIES_512, in, inpos);
    iV.and(MASK_28).intoArray(out, outpos);
    outpos += VLEN_512;

    var oV = iV.lanewise(VectorOperators.LSHR, 28).and(MASK_28);

    iV = IntVector.fromArray(SPECIES_512, in, inpos + 16);
    oV = iV.and(0xffffff).lanewise(VectorOperators.LSHL, 4).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_512;

    oV = iV.lanewise(VectorOperators.LSHR, 24).and(MASK_28);

    iV = IntVector.fromArray(SPECIES_512, in, inpos + 32);
    oV = iV.and(0xfffff).lanewise(VectorOperators.LSHL, 8).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_512;

    oV = iV.lanewise(VectorOperators.LSHR, 20).and(MASK_28);

    iV = IntVector.fromArray(SPECIES_512, in, inpos + 48);
    oV = iV.and(0xffff).lanewise(VectorOperators.LSHL, 12).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_512;

    oV = iV.lanewise(VectorOperators.LSHR, 16).and(MASK_28);

    iV = IntVector.fromArray(SPECIES_512, in, inpos + 64);
    oV = iV.and(0xfff).lanewise(VectorOperators.LSHL, 16).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_512;

    oV = iV.lanewise(VectorOperators.LSHR, 12).and(MASK_28);

    iV = IntVector.fromArray(SPECIES_512, in, inpos + 80);
    oV = iV.and(0xff).lanewise(VectorOperators.LSHL, 20).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_512;

    oV = iV.lanewise(VectorOperators.LSHR, 8).and(MASK_28);

    iV = IntVector.fromArray(SPECIES_512, in, inpos + 96);
    oV = iV.and(0xf).lanewise(VectorOperators.LSHL, 24).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_512;

    iV.lanewise(VectorOperators.LSHR, 4).and(MASK_28).intoArray(out, outpos);
    outpos += VLEN_512;

    oV = oV.zero(SPECIES_512);

    iV = IntVector.fromArray(SPECIES_512, in, inpos + 112);
    oV = iV.and(0xfffffff).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_512;

    oV = iV.lanewise(VectorOperators.LSHR, 28).and(MASK_28);

    iV = IntVector.fromArray(SPECIES_512, in, inpos + 128);
    oV = iV.and(0xffffff).lanewise(VectorOperators.LSHL, 4).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_512;

    oV = iV.lanewise(VectorOperators.LSHR, 24).and(MASK_28);

    iV = IntVector.fromArray(SPECIES_512, in, inpos + 144);
    oV = iV.and(0xfffff).lanewise(VectorOperators.LSHL, 8).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_512;

    oV = iV.lanewise(VectorOperators.LSHR, 20).and(MASK_28);

    iV = IntVector.fromArray(SPECIES_512, in, inpos + 160);
    oV = iV.and(0xffff).lanewise(VectorOperators.LSHL, 12).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_512;

    oV = iV.lanewise(VectorOperators.LSHR, 16).and(MASK_28);

    iV = IntVector.fromArray(SPECIES_512, in, inpos + 176);
    oV = iV.and(0xfff).lanewise(VectorOperators.LSHL, 16).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_512;

    oV = iV.lanewise(VectorOperators.LSHR, 12).and(MASK_28);

    iV = IntVector.fromArray(SPECIES_512, in, inpos + 192);
    oV = iV.and(0xff).lanewise(VectorOperators.LSHL, 20).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_512;

    oV = iV.lanewise(VectorOperators.LSHR, 8).and(MASK_28);

    iV = IntVector.fromArray(SPECIES_512, in, inpos + 208);
    oV = iV.and(0xf).lanewise(VectorOperators.LSHL, 24).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_512;

    iV.lanewise(VectorOperators.LSHR, 4).and(MASK_28).intoArray(out, outpos);
    outpos += VLEN_512;
  }

  private static void fastunpack29(final int[] in, int inpos, final int[] out,
                                   int outpos) {
    var iV = IntVector.fromArray(SPECIES_256, in, inpos);
    iV.and(MASK_29).intoArray(out, outpos);
    outpos += VLEN_256;

    var oV = iV.lanewise(VectorOperators.LSHR, 29).and(MASK_29);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 8);
    oV = iV.and(0x3ffffff).lanewise(VectorOperators.LSHL, 3).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.lanewise(VectorOperators.LSHR, 26).and(MASK_29);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 16);
    oV = iV.and(0x7fffff).lanewise(VectorOperators.LSHL, 6).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.lanewise(VectorOperators.LSHR, 23).and(MASK_29);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 24);
    oV = iV.and(0xfffff).lanewise(VectorOperators.LSHL, 9).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.lanewise(VectorOperators.LSHR, 20).and(MASK_29);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 32);
    oV = iV.and(0x1ffff).lanewise(VectorOperators.LSHL, 12).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.lanewise(VectorOperators.LSHR, 17).and(MASK_29);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 40);
    oV = iV.and(0x3fff).lanewise(VectorOperators.LSHL, 15).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.lanewise(VectorOperators.LSHR, 14).and(MASK_29);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 48);
    oV = iV.and(0x7ff).lanewise(VectorOperators.LSHL, 18).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.lanewise(VectorOperators.LSHR, 11).and(MASK_29);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 56);
    oV = iV.and(0xff).lanewise(VectorOperators.LSHL, 21).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.lanewise(VectorOperators.LSHR, 8).and(MASK_29);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 64);
    oV = iV.and(0x1f).lanewise(VectorOperators.LSHL, 24).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.lanewise(VectorOperators.LSHR, 5).and(MASK_29);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 72);
    oV = iV.and(3).lanewise(VectorOperators.LSHL, 27).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    iV.lanewise(VectorOperators.LSHR, 2).and(MASK_29).intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.lanewise(VectorOperators.LSHR, 31).and(MASK_29);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 80);
    oV = iV.and(0xfffffff).lanewise(VectorOperators.LSHL, 1).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.lanewise(VectorOperators.LSHR, 28).and(MASK_29);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 88);
    oV = iV.and(0x1ffffff).lanewise(VectorOperators.LSHL, 4).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.lanewise(VectorOperators.LSHR, 25).and(MASK_29);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 96);
    oV = iV.and(0x3fffff).lanewise(VectorOperators.LSHL, 7).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.lanewise(VectorOperators.LSHR, 22).and(MASK_29);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 104);
    oV = iV.and(0x7ffff).lanewise(VectorOperators.LSHL, 10).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.lanewise(VectorOperators.LSHR, 19).and(MASK_29);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 112);
    oV = iV.and(0xffff).lanewise(VectorOperators.LSHL, 13).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.lanewise(VectorOperators.LSHR, 16).and(MASK_29);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 120);
    oV = iV.and(0x1fff).lanewise(VectorOperators.LSHL, 16).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.lanewise(VectorOperators.LSHR, 13).and(MASK_29);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 128);
    oV = iV.and(0x3ff).lanewise(VectorOperators.LSHL, 19).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.lanewise(VectorOperators.LSHR, 10).and(MASK_29);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 136);
    oV = iV.and(0x7f).lanewise(VectorOperators.LSHL, 22).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.lanewise(VectorOperators.LSHR, 7).and(MASK_29);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 144);
    oV = iV.and(0xf).lanewise(VectorOperators.LSHL, 25).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.lanewise(VectorOperators.LSHR, 4).and(MASK_29);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 152);
    oV = iV.and(1).lanewise(VectorOperators.LSHL, 28).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    iV.lanewise(VectorOperators.LSHR, 1).and(MASK_29).intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.lanewise(VectorOperators.LSHR, 30).and(MASK_29);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 160);
    oV = iV.and(0x7ffffff).lanewise(VectorOperators.LSHL, 2).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.lanewise(VectorOperators.LSHR, 27).and(MASK_29);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 168);
    oV = iV.and(0xffffff).lanewise(VectorOperators.LSHL, 5).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.lanewise(VectorOperators.LSHR, 24).and(MASK_29);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 176);
    oV = iV.and(0x1fffff).lanewise(VectorOperators.LSHL, 8).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.lanewise(VectorOperators.LSHR, 21).and(MASK_29);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 184);
    oV = iV.and(0x3ffff).lanewise(VectorOperators.LSHL, 11).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.lanewise(VectorOperators.LSHR, 18).and(MASK_29);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 192);
    oV = iV.and(0x7fff).lanewise(VectorOperators.LSHL, 14).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.lanewise(VectorOperators.LSHR, 15).and(MASK_29);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 200);
    oV = iV.and(0xfff).lanewise(VectorOperators.LSHL, 17).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.lanewise(VectorOperators.LSHR, 12).and(MASK_29);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 208);
    oV = iV.and(0x1ff).lanewise(VectorOperators.LSHL, 20).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.lanewise(VectorOperators.LSHR, 9).and(MASK_29);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 216);
    oV = iV.and(0x3f).lanewise(VectorOperators.LSHL, 23).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.lanewise(VectorOperators.LSHR, 6).and(MASK_29);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 224);
    oV = iV.and(7).lanewise(VectorOperators.LSHL, 26).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    iV.lanewise(VectorOperators.LSHR, 3).and(MASK_29).intoArray(out, outpos);
    outpos += VLEN_256;
  }

  private static void fastunpack30(final int[] in, int inpos, final int[] out,
                                   int outpos) {
    var iV = IntVector.fromArray(SPECIES_512, in, inpos);
    iV.and(MASK_30).intoArray(out, outpos);
    outpos += VLEN_512;

    var oV = iV.lanewise(VectorOperators.LSHR, 30).and(MASK_30);

    iV = IntVector.fromArray(SPECIES_512, in, inpos + 16);
    oV = iV.and(0xfffffff).lanewise(VectorOperators.LSHL, 2).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_512;

    oV = iV.lanewise(VectorOperators.LSHR, 28).and(MASK_30);

    iV = IntVector.fromArray(SPECIES_512, in, inpos + 32);
    oV = iV.and(0x3ffffff).lanewise(VectorOperators.LSHL, 4).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_512;

    oV = iV.lanewise(VectorOperators.LSHR, 26).and(MASK_30);

    iV = IntVector.fromArray(SPECIES_512, in, inpos + 48);
    oV = iV.and(0xffffff).lanewise(VectorOperators.LSHL, 6).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_512;

    oV = iV.lanewise(VectorOperators.LSHR, 24).and(MASK_30);

    iV = IntVector.fromArray(SPECIES_512, in, inpos + 64);
    oV = iV.and(0x3fffff).lanewise(VectorOperators.LSHL, 8).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_512;

    oV = iV.lanewise(VectorOperators.LSHR, 22).and(MASK_30);

    iV = IntVector.fromArray(SPECIES_512, in, inpos + 80);
    oV = iV.and(0xfffff).lanewise(VectorOperators.LSHL, 10).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_512;

    oV = iV.lanewise(VectorOperators.LSHR, 20).and(MASK_30);

    iV = IntVector.fromArray(SPECIES_512, in, inpos + 96);
    oV = iV.and(0x3ffff).lanewise(VectorOperators.LSHL, 12).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_512;

    oV = iV.lanewise(VectorOperators.LSHR, 18).and(MASK_30);

    iV = IntVector.fromArray(SPECIES_512, in, inpos + 112);
    oV = iV.and(0xffff).lanewise(VectorOperators.LSHL, 14).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_512;

    oV = iV.lanewise(VectorOperators.LSHR, 16).and(MASK_30);

    iV = IntVector.fromArray(SPECIES_512, in, inpos + 128);
    oV = iV.and(0x3fff).lanewise(VectorOperators.LSHL, 16).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_512;

    oV = iV.lanewise(VectorOperators.LSHR, 14).and(MASK_30);

    iV = IntVector.fromArray(SPECIES_512, in, inpos + 144);
    oV = iV.and(0xfff).lanewise(VectorOperators.LSHL, 18).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_512;

    oV = iV.lanewise(VectorOperators.LSHR, 12).and(MASK_30);

    iV = IntVector.fromArray(SPECIES_512, in, inpos + 160);
    oV = iV.and(0x3ff).lanewise(VectorOperators.LSHL, 20).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_512;

    oV = iV.lanewise(VectorOperators.LSHR, 10).and(MASK_30);

    iV = IntVector.fromArray(SPECIES_512, in, inpos + 176);
    oV = iV.and(0xff).lanewise(VectorOperators.LSHL, 22).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_512;

    oV = iV.lanewise(VectorOperators.LSHR, 8).and(MASK_30);

    iV = IntVector.fromArray(SPECIES_512, in, inpos + 192);
    oV = iV.and(0x3f).lanewise(VectorOperators.LSHL, 24).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_512;

    oV = iV.lanewise(VectorOperators.LSHR, 6).and(MASK_30);

    iV = IntVector.fromArray(SPECIES_512, in, inpos + 208);
    oV = iV.and(0xf).lanewise(VectorOperators.LSHL, 26).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_512;

    oV = iV.lanewise(VectorOperators.LSHR, 4).and(MASK_30);

    iV = IntVector.fromArray(SPECIES_512, in, inpos + 224);
    oV = iV.and(3).lanewise(VectorOperators.LSHL, 28).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_512;

    iV.lanewise(VectorOperators.LSHR, 2).and(MASK_30).intoArray(out, outpos);
    outpos += VLEN_512;
  }

  private static void fastunpack31(final int[] in, int inpos, final int[] out,
                                   int outpos) {
    var iV = IntVector.fromArray(SPECIES_256, in, inpos);
    iV.and(MASK_31).intoArray(out, outpos);
    outpos += VLEN_256;

    var oV = iV.lanewise(VectorOperators.LSHR, 31).and(MASK_31);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 8);
    oV = iV.and(0x3fffffff).lanewise(VectorOperators.LSHL, 1).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.lanewise(VectorOperators.LSHR, 30).and(MASK_31);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 16);
    oV = iV.and(0x1fffffff).lanewise(VectorOperators.LSHL, 2).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.lanewise(VectorOperators.LSHR, 29).and(MASK_31);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 24);
    oV = iV.and(0xfffffff).lanewise(VectorOperators.LSHL, 3).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.lanewise(VectorOperators.LSHR, 28).and(MASK_31);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 32);
    oV = iV.and(0x7ffffff).lanewise(VectorOperators.LSHL, 4).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.lanewise(VectorOperators.LSHR, 27).and(MASK_31);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 40);
    oV = iV.and(0x3ffffff).lanewise(VectorOperators.LSHL, 5).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.lanewise(VectorOperators.LSHR, 26).and(MASK_31);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 48);
    oV = iV.and(0x1ffffff).lanewise(VectorOperators.LSHL, 6).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.lanewise(VectorOperators.LSHR, 25).and(MASK_31);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 56);
    oV = iV.and(0xffffff).lanewise(VectorOperators.LSHL, 7).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.lanewise(VectorOperators.LSHR, 24).and(MASK_31);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 64);
    oV = iV.and(0x7fffff).lanewise(VectorOperators.LSHL, 8).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.lanewise(VectorOperators.LSHR, 23).and(MASK_31);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 72);
    oV = iV.and(0x3fffff).lanewise(VectorOperators.LSHL, 9).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.lanewise(VectorOperators.LSHR, 22).and(MASK_31);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 80);
    oV = iV.and(0x1fffff).lanewise(VectorOperators.LSHL, 10).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.lanewise(VectorOperators.LSHR, 21).and(MASK_31);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 88);
    oV = iV.and(0xfffff).lanewise(VectorOperators.LSHL, 11).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.lanewise(VectorOperators.LSHR, 20).and(MASK_31);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 96);
    oV = iV.and(0x7ffff).lanewise(VectorOperators.LSHL, 12).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.lanewise(VectorOperators.LSHR, 19).and(MASK_31);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 104);
    oV = iV.and(0x3ffff).lanewise(VectorOperators.LSHL, 13).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.lanewise(VectorOperators.LSHR, 18).and(MASK_31);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 112);
    oV = iV.and(0x1ffff).lanewise(VectorOperators.LSHL, 14).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.lanewise(VectorOperators.LSHR, 17).and(MASK_31);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 120);
    oV = iV.and(0xffff).lanewise(VectorOperators.LSHL, 15).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.lanewise(VectorOperators.LSHR, 16).and(MASK_31);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 128);
    oV = iV.and(0x7fff).lanewise(VectorOperators.LSHL, 16).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.lanewise(VectorOperators.LSHR, 15).and(MASK_31);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 136);
    oV = iV.and(0x3fff).lanewise(VectorOperators.LSHL, 17).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.lanewise(VectorOperators.LSHR, 14).and(MASK_31);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 144);
    oV = iV.and(0x1fff).lanewise(VectorOperators.LSHL, 18).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.lanewise(VectorOperators.LSHR, 13).and(MASK_31);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 152);
    oV = iV.and(0xfff).lanewise(VectorOperators.LSHL, 19).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.lanewise(VectorOperators.LSHR, 12).and(MASK_31);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 160);
    oV = iV.and(0x7ff).lanewise(VectorOperators.LSHL, 20).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.lanewise(VectorOperators.LSHR, 11).and(MASK_31);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 168);
    oV = iV.and(0x3ff).lanewise(VectorOperators.LSHL, 21).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.lanewise(VectorOperators.LSHR, 10).and(MASK_31);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 176);
    oV = iV.and(0x1ff).lanewise(VectorOperators.LSHL, 22).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.lanewise(VectorOperators.LSHR, 9).and(MASK_31);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 184);
    oV = iV.and(0xff).lanewise(VectorOperators.LSHL, 23).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.lanewise(VectorOperators.LSHR, 8).and(MASK_31);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 192);
    oV = iV.and(0x7f).lanewise(VectorOperators.LSHL, 24).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.lanewise(VectorOperators.LSHR, 7).and(MASK_31);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 200);
    oV = iV.and(0x3f).lanewise(VectorOperators.LSHL, 25).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.lanewise(VectorOperators.LSHR, 6).and(MASK_31);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 208);
    oV = iV.and(0x1f).lanewise(VectorOperators.LSHL, 26).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.lanewise(VectorOperators.LSHR, 5).and(MASK_31);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 216);
    oV = iV.and(0xf).lanewise(VectorOperators.LSHL, 27).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.lanewise(VectorOperators.LSHR, 4).and(MASK_31);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 224);
    oV = iV.and(7).lanewise(VectorOperators.LSHL, 28).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.lanewise(VectorOperators.LSHR, 3).and(MASK_31);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 232);
    oV = iV.and(3).lanewise(VectorOperators.LSHL, 29).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    oV = iV.lanewise(VectorOperators.LSHR, 2).and(MASK_31);

    iV = IntVector.fromArray(SPECIES_256, in, inpos + 240);
    oV = iV.and(1).lanewise(VectorOperators.LSHL, 30).or(oV);

    oV.intoArray(out, outpos);
    outpos += VLEN_256;

    iV.lanewise(VectorOperators.LSHR, 1).and(MASK_31).intoArray(out, outpos);
    outpos += VLEN_256;
  }
}
