package com.kamikaze.pfordelta;

/**
 * This is a version of the kamikaze PForDelta library that was slightly cleaned
 * up by D. Lemire. It is included in the JavaFastPFOR library for comparison
 * purposes. As the original
 */
public class PForDeltaUnpack128 {

        static protected void unpack(int[] out, int[] in, int bits) {
                switch (bits) {
                case 0:
                        unpack0(out, in);
                        break;
                case 1:
                        unpack1(out, in);
                        break;
                case 2:
                        unpack2(out, in);
                        break;
                case 3:
                        unpack3(out, in);
                        break;
                case 4:
                        unpack4(out, in);
                        break;
                case 5:
                        unpack5(out, in);
                        break;
                case 6:
                        unpack6(out, in);
                        break;
                case 7:
                        unpack7(out, in);
                        break;
                case 8:
                        unpack8(out, in);
                        break;
                case 9:
                        unpack9(out, in);
                        break;
                case 10:
                        unpack10(out, in);
                        break;
                case 11:
                        unpack11(out, in);
                        break;
                case 12:
                        unpack12(out, in);
                        break;
                case 13:
                        unpack13(out, in);
                        break;
                case 16:
                        unpack16(out, in);
                        break;
                case 20:
                        unpack20(out, in);
                        break;
                case 28:
                        unpack28(out, in);
                        break;
                default:
                        break;
                }
        }

        static private void unpack0(int[] out, int[] in) {
        }

        static private void unpack1(int[] out, int[] in) {
                int i, w;
                int outOffset = 0;
                final int mask = 1;
                for (i = 0, w = 1; i < 4; ++i, w += 1) {
                        int curInputValue0 = in[w];
                        out[0 + outOffset] = curInputValue0 & mask;
                        out[1 + outOffset] = (curInputValue0 >>> 1) & mask;
                        out[2 + outOffset] = (curInputValue0 >>> 2) & mask;
                        out[3 + outOffset] = (curInputValue0 >>> 3) & mask;
                        out[4 + outOffset] = (curInputValue0 >>> 4) & mask;
                        out[5 + outOffset] = (curInputValue0 >>> 5) & mask;
                        out[6 + outOffset] = (curInputValue0 >>> 6) & mask;
                        out[7 + outOffset] = (curInputValue0 >>> 7) & mask;
                        out[8 + outOffset] = (curInputValue0 >>> 8) & mask;
                        out[9 + outOffset] = (curInputValue0 >>> 9) & mask;
                        out[10 + outOffset] = (curInputValue0 >>> 10) & mask;
                        out[11 + outOffset] = (curInputValue0 >>> 11) & mask;
                        out[12 + outOffset] = (curInputValue0 >>> 12) & mask;
                        out[13 + outOffset] = (curInputValue0 >>> 13) & mask;
                        out[14 + outOffset] = (curInputValue0 >>> 14) & mask;
                        out[15 + outOffset] = (curInputValue0 >>> 15) & mask;
                        out[16 + outOffset] = (curInputValue0 >>> 16) & mask;
                        out[17 + outOffset] = (curInputValue0 >>> 17) & mask;
                        out[18 + outOffset] = (curInputValue0 >>> 18) & mask;
                        out[19 + outOffset] = (curInputValue0 >>> 19) & mask;
                        out[20 + outOffset] = (curInputValue0 >>> 20) & mask;
                        out[21 + outOffset] = (curInputValue0 >>> 21) & mask;
                        out[22 + outOffset] = (curInputValue0 >>> 22) & mask;
                        out[23 + outOffset] = (curInputValue0 >>> 23) & mask;
                        out[24 + outOffset] = (curInputValue0 >>> 24) & mask;
                        out[25 + outOffset] = (curInputValue0 >>> 25) & mask;
                        out[26 + outOffset] = (curInputValue0 >>> 26) & mask;
                        out[27 + outOffset] = (curInputValue0 >>> 27) & mask;
                        out[28 + outOffset] = (curInputValue0 >>> 28) & mask;
                        out[29 + outOffset] = (curInputValue0 >>> 29) & mask;
                        out[30 + outOffset] = (curInputValue0 >>> 30) & mask;
                        out[31 + outOffset] = curInputValue0 >>> 31;
                        outOffset += 32;
                }
        }

        static private void unpack2(int[] out, int[] in) {
                int i, w;
                int outOffset = 0;
                final int mask = 3;
                for (i = 0, w = 1; i < 4; ++i, w += 2) {
                        int curInputValue0 = in[w];
                        int curInputValue1 = in[w + 1];
                        out[0 + outOffset] = curInputValue0 & mask;
                        out[1 + outOffset] = (curInputValue0 >>> 2) & mask;
                        out[2 + outOffset] = (curInputValue0 >>> 4) & mask;
                        out[3 + outOffset] = (curInputValue0 >>> 6) & mask;
                        out[4 + outOffset] = (curInputValue0 >>> 8) & mask;
                        out[5 + outOffset] = (curInputValue0 >>> 10) & mask;
                        out[6 + outOffset] = (curInputValue0 >>> 12) & mask;
                        out[7 + outOffset] = (curInputValue0 >>> 14) & mask;
                        out[8 + outOffset] = (curInputValue0 >>> 16) & mask;
                        out[9 + outOffset] = (curInputValue0 >>> 18) & mask;
                        out[10 + outOffset] = (curInputValue0 >>> 20) & mask;
                        out[11 + outOffset] = (curInputValue0 >>> 22) & mask;
                        out[12 + outOffset] = (curInputValue0 >>> 24) & mask;
                        out[13 + outOffset] = (curInputValue0 >>> 26) & mask;
                        out[14 + outOffset] = (curInputValue0 >>> 28) & mask;
                        out[15 + outOffset] = curInputValue0 >>> 30;
                        out[16 + outOffset] = curInputValue1 & mask;
                        out[17 + outOffset] = (curInputValue1 >>> 2) & mask;
                        out[18 + outOffset] = (curInputValue1 >>> 4) & mask;
                        out[19 + outOffset] = (curInputValue1 >>> 6) & mask;
                        out[20 + outOffset] = (curInputValue1 >>> 8) & mask;
                        out[21 + outOffset] = (curInputValue1 >>> 10) & mask;
                        out[22 + outOffset] = (curInputValue1 >>> 12) & mask;
                        out[23 + outOffset] = (curInputValue1 >>> 14) & mask;
                        out[24 + outOffset] = (curInputValue1 >>> 16) & mask;
                        out[25 + outOffset] = (curInputValue1 >>> 18) & mask;
                        out[26 + outOffset] = (curInputValue1 >>> 20) & mask;
                        out[27 + outOffset] = (curInputValue1 >>> 22) & mask;
                        out[28 + outOffset] = (curInputValue1 >>> 24) & mask;
                        out[29 + outOffset] = (curInputValue1 >>> 26) & mask;
                        out[30 + outOffset] = (curInputValue1 >>> 28) & mask;
                        out[31 + outOffset] = curInputValue1 >>> 30;
                        outOffset += 32;
                }
        }

        static private void unpack3(int[] out, int[] in) {
                int i, w;
                int outOffset = 0;
                final int mask = 7;
                for (i = 0, w = 1; i < 4; ++i, w += 3) {
                        int curInputValue0 = in[w];
                        int curInputValue1 = in[w + 1];
                        int curInputValue2 = in[w + 2];
                        out[0 + outOffset] = curInputValue0 & mask;
                        out[1 + outOffset] = (curInputValue0 >>> 3) & mask;
                        out[2 + outOffset] = (curInputValue0 >>> 6) & mask;
                        out[3 + outOffset] = (curInputValue0 >>> 9) & mask;
                        out[4 + outOffset] = (curInputValue0 >>> 12) & mask;
                        out[5 + outOffset] = (curInputValue0 >>> 15) & mask;
                        out[6 + outOffset] = (curInputValue0 >>> 18) & mask;
                        out[7 + outOffset] = (curInputValue0 >>> 21) & mask;
                        out[8 + outOffset] = (curInputValue0 >>> 24) & mask;
                        out[9 + outOffset] = (curInputValue0 >>> 27) & mask;
                        out[10 + outOffset] = ((curInputValue0 >>> 30) | (curInputValue1 << 2))
                                & mask;
                        out[11 + outOffset] = (curInputValue1 >>> 1) & mask;
                        out[12 + outOffset] = (curInputValue1 >>> 4) & mask;
                        out[13 + outOffset] = (curInputValue1 >>> 7) & mask;
                        out[14 + outOffset] = (curInputValue1 >>> 10) & mask;
                        out[15 + outOffset] = (curInputValue1 >>> 13) & mask;
                        out[16 + outOffset] = (curInputValue1 >>> 16) & mask;
                        out[17 + outOffset] = (curInputValue1 >>> 19) & mask;
                        out[18 + outOffset] = (curInputValue1 >>> 22) & mask;
                        out[19 + outOffset] = (curInputValue1 >>> 25) & mask;
                        out[20 + outOffset] = (curInputValue1 >>> 28) & mask;
                        out[21 + outOffset] = ((curInputValue1 >>> 31) | (curInputValue2 << 1))
                                & mask;
                        out[22 + outOffset] = (curInputValue2 >>> 2) & mask;
                        out[23 + outOffset] = (curInputValue2 >>> 5) & mask;
                        out[24 + outOffset] = (curInputValue2 >>> 8) & mask;
                        out[25 + outOffset] = (curInputValue2 >>> 11) & mask;
                        out[26 + outOffset] = (curInputValue2 >>> 14) & mask;
                        out[27 + outOffset] = (curInputValue2 >>> 17) & mask;
                        out[28 + outOffset] = (curInputValue2 >>> 20) & mask;
                        out[29 + outOffset] = (curInputValue2 >>> 23) & mask;
                        out[30 + outOffset] = (curInputValue2 >>> 26) & mask;
                        out[31 + outOffset] = curInputValue2 >>> 29;
                        outOffset += 32;
                }
        }

        static private void unpack4(int[] out, int[] in) {
                int i, w;
                int outOffset = 0;
                final int mask = 15;
                for (i = 0, w = 1; i < 4; ++i, w += 4) {
                        int curInputValue0 = in[w];
                        int curInputValue1 = in[w + 1];
                        int curInputValue2 = in[w + 2];
                        int curInputValue3 = in[w + 3];
                        out[0 + outOffset] = curInputValue0 & mask;
                        out[1 + outOffset] = (curInputValue0 >>> 4) & mask;
                        out[2 + outOffset] = (curInputValue0 >>> 8) & mask;
                        out[3 + outOffset] = (curInputValue0 >>> 12) & mask;
                        out[4 + outOffset] = (curInputValue0 >>> 16) & mask;
                        out[5 + outOffset] = (curInputValue0 >>> 20) & mask;
                        out[6 + outOffset] = (curInputValue0 >>> 24) & mask;
                        out[7 + outOffset] = curInputValue0 >>> 28;
                        out[8 + outOffset] = curInputValue1 & mask;
                        out[9 + outOffset] = (curInputValue1 >>> 4) & mask;
                        out[10 + outOffset] = (curInputValue1 >>> 8) & mask;
                        out[11 + outOffset] = (curInputValue1 >>> 12) & mask;
                        out[12 + outOffset] = (curInputValue1 >>> 16) & mask;
                        out[13 + outOffset] = (curInputValue1 >>> 20) & mask;
                        out[14 + outOffset] = (curInputValue1 >>> 24) & mask;
                        out[15 + outOffset] = curInputValue1 >>> 28;
                        out[16 + outOffset] = curInputValue2 & mask;
                        out[17 + outOffset] = (curInputValue2 >>> 4) & mask;
                        out[18 + outOffset] = (curInputValue2 >>> 8) & mask;
                        out[19 + outOffset] = (curInputValue2 >>> 12) & mask;
                        out[20 + outOffset] = (curInputValue2 >>> 16) & mask;
                        out[21 + outOffset] = (curInputValue2 >>> 20) & mask;
                        out[22 + outOffset] = (curInputValue2 >>> 24) & mask;
                        out[23 + outOffset] = curInputValue2 >>> 28;
                        out[24 + outOffset] = curInputValue3 & mask;
                        out[25 + outOffset] = (curInputValue3 >>> 4) & mask;
                        out[26 + outOffset] = (curInputValue3 >>> 8) & mask;
                        out[27 + outOffset] = (curInputValue3 >>> 12) & mask;
                        out[28 + outOffset] = (curInputValue3 >>> 16) & mask;
                        out[29 + outOffset] = (curInputValue3 >>> 20) & mask;
                        out[30 + outOffset] = (curInputValue3 >>> 24) & mask;
                        out[31 + outOffset] = curInputValue3 >>> 28;
                        outOffset += 32;
                }
        }

        static private void unpack5(int[] out, int[] in) {
                int i, w;
                int outOffset = 0;
                final int mask = 31;
                for (i = 0, w = 1; i < 4; ++i, w += 5) {
                        int curInputValue0 = in[w];
                        int curInputValue1 = in[w + 1];
                        int curInputValue2 = in[w + 2];
                        int curInputValue3 = in[w + 3];
                        int curInputValue4 = in[w + 4];
                        out[0 + outOffset] = curInputValue0 & mask;
                        out[1 + outOffset] = (curInputValue0 >>> 5) & mask;
                        out[2 + outOffset] = (curInputValue0 >>> 10) & mask;
                        out[3 + outOffset] = (curInputValue0 >>> 15) & mask;
                        out[4 + outOffset] = (curInputValue0 >>> 20) & mask;
                        out[5 + outOffset] = (curInputValue0 >>> 25) & mask;
                        out[6 + outOffset] = ((curInputValue0 >>> 30) | (curInputValue1 << 2))
                                & mask;
                        out[7 + outOffset] = (curInputValue1 >>> 3) & mask;
                        out[8 + outOffset] = (curInputValue1 >>> 8) & mask;
                        out[9 + outOffset] = (curInputValue1 >>> 13) & mask;
                        out[10 + outOffset] = (curInputValue1 >>> 18) & mask;
                        out[11 + outOffset] = (curInputValue1 >>> 23) & mask;
                        out[12 + outOffset] = ((curInputValue1 >>> 28) | (curInputValue2 << 4))
                                & mask;
                        out[13 + outOffset] = (curInputValue2 >>> 1) & mask;
                        out[14 + outOffset] = (curInputValue2 >>> 6) & mask;
                        out[15 + outOffset] = (curInputValue2 >>> 11) & mask;
                        out[16 + outOffset] = (curInputValue2 >>> 16) & mask;
                        out[17 + outOffset] = (curInputValue2 >>> 21) & mask;
                        out[18 + outOffset] = (curInputValue2 >>> 26) & mask;
                        out[19 + outOffset] = ((curInputValue2 >>> 31) | (curInputValue3 << 1))
                                & mask;
                        out[20 + outOffset] = (curInputValue3 >>> 4) & mask;
                        out[21 + outOffset] = (curInputValue3 >>> 9) & mask;
                        out[22 + outOffset] = (curInputValue3 >>> 14) & mask;
                        out[23 + outOffset] = (curInputValue3 >>> 19) & mask;
                        out[24 + outOffset] = (curInputValue3 >>> 24) & mask;
                        out[25 + outOffset] = ((curInputValue3 >>> 29) | (curInputValue4 << 3))
                                & mask;
                        out[26 + outOffset] = (curInputValue4 >>> 2) & mask;
                        out[27 + outOffset] = (curInputValue4 >>> 7) & mask;
                        out[28 + outOffset] = (curInputValue4 >>> 12) & mask;
                        out[29 + outOffset] = (curInputValue4 >>> 17) & mask;
                        out[30 + outOffset] = (curInputValue4 >>> 22) & mask;
                        out[31 + outOffset] = curInputValue4 >>> 27;
                        outOffset += 32;
                }
        }

        static private void unpack6(int[] out, int[] in) {
                int i, w;
                int outOffset = 0;
                final int mask = 63;
                for (i = 0, w = 1; i < 4; ++i, w += 6) {
                        int curInputValue0 = in[w];
                        int curInputValue1 = in[w + 1];
                        int curInputValue2 = in[w + 2];
                        int curInputValue3 = in[w + 3];
                        int curInputValue4 = in[w + 4];
                        int curInputValue5 = in[w + 5];
                        out[0 + outOffset] = curInputValue0 & mask;
                        out[1 + outOffset] = (curInputValue0 >>> 6) & mask;
                        out[2 + outOffset] = (curInputValue0 >>> 12) & mask;
                        out[3 + outOffset] = (curInputValue0 >>> 18) & mask;
                        out[4 + outOffset] = (curInputValue0 >>> 24) & mask;
                        out[5 + outOffset] = ((curInputValue0 >>> 30) | (curInputValue1 << 2))
                                & mask;
                        out[6 + outOffset] = (curInputValue1 >>> 4) & mask;
                        out[7 + outOffset] = (curInputValue1 >>> 10) & mask;
                        out[8 + outOffset] = (curInputValue1 >>> 16) & mask;
                        out[9 + outOffset] = (curInputValue1 >>> 22) & mask;
                        out[10 + outOffset] = ((curInputValue1 >>> 28) | (curInputValue2 << 4))
                                & mask;
                        out[11 + outOffset] = (curInputValue2 >>> 2) & mask;
                        out[12 + outOffset] = (curInputValue2 >>> 8) & mask;
                        out[13 + outOffset] = (curInputValue2 >>> 14) & mask;
                        out[14 + outOffset] = (curInputValue2 >>> 20) & mask;
                        out[15 + outOffset] = curInputValue2 >>> 26;
                        out[16 + outOffset] = curInputValue3 & mask;
                        out[17 + outOffset] = (curInputValue3 >>> 6) & mask;
                        out[18 + outOffset] = (curInputValue3 >>> 12) & mask;
                        out[19 + outOffset] = (curInputValue3 >>> 18) & mask;
                        out[20 + outOffset] = (curInputValue3 >>> 24) & mask;
                        out[21 + outOffset] = ((curInputValue3 >>> 30) | (curInputValue4 << 2))
                                & mask;
                        out[22 + outOffset] = (curInputValue4 >>> 4) & mask;
                        out[23 + outOffset] = (curInputValue4 >>> 10) & mask;
                        out[24 + outOffset] = (curInputValue4 >>> 16) & mask;
                        out[25 + outOffset] = (curInputValue4 >>> 22) & mask;
                        out[26 + outOffset] = ((curInputValue4 >>> 28) | (curInputValue5 << 4))
                                & mask;
                        out[27 + outOffset] = (curInputValue5 >>> 2) & mask;
                        out[28 + outOffset] = (curInputValue5 >>> 8) & mask;
                        out[29 + outOffset] = (curInputValue5 >>> 14) & mask;
                        out[30 + outOffset] = (curInputValue5 >>> 20) & mask;
                        out[31 + outOffset] = curInputValue5 >>> 26;
                        outOffset += 32;
                }
        }

        static private void unpack7(int[] out, int[] in) {
                int i, w;
                int outOffset = 0;
                final int mask = 127;
                for (i = 0, w = 1; i < 4; ++i, w += 7) {
                        int curInputValue0 = in[w];
                        int curInputValue1 = in[w + 1];
                        int curInputValue2 = in[w + 2];
                        int curInputValue3 = in[w + 3];
                        int curInputValue4 = in[w + 4];
                        int curInputValue5 = in[w + 5];
                        int curInputValue6 = in[w + 6];
                        out[0 + outOffset] = curInputValue0 & mask;
                        out[1 + outOffset] = (curInputValue0 >>> 7) & mask;
                        out[2 + outOffset] = (curInputValue0 >>> 14) & mask;
                        out[3 + outOffset] = (curInputValue0 >>> 21) & mask;
                        out[4 + outOffset] = ((curInputValue0 >>> 28) | (curInputValue1 << 4))
                                & mask;
                        out[5 + outOffset] = (curInputValue1 >>> 3) & mask;
                        out[6 + outOffset] = (curInputValue1 >>> 10) & mask;
                        out[7 + outOffset] = (curInputValue1 >>> 17) & mask;
                        out[8 + outOffset] = (curInputValue1 >>> 24) & mask;
                        out[9 + outOffset] = ((curInputValue1 >>> 31) | (curInputValue2 << 1))
                                & mask;
                        out[10 + outOffset] = (curInputValue2 >>> 6) & mask;
                        out[11 + outOffset] = (curInputValue2 >>> 13) & mask;
                        out[12 + outOffset] = (curInputValue2 >>> 20) & mask;
                        out[13 + outOffset] = ((curInputValue2 >>> 27) | (curInputValue3 << 5))
                                & mask;
                        out[14 + outOffset] = (curInputValue3 >>> 2) & mask;
                        out[15 + outOffset] = (curInputValue3 >>> 9) & mask;
                        out[16 + outOffset] = (curInputValue3 >>> 16) & mask;
                        out[17 + outOffset] = (curInputValue3 >>> 23) & mask;
                        out[18 + outOffset] = ((curInputValue3 >>> 30) | (curInputValue4 << 2))
                                & mask;
                        out[19 + outOffset] = (curInputValue4 >>> 5) & mask;
                        out[20 + outOffset] = (curInputValue4 >>> 12) & mask;
                        out[21 + outOffset] = (curInputValue4 >>> 19) & mask;
                        out[22 + outOffset] = ((curInputValue4 >>> 26) | (curInputValue5 << 6))
                                & mask;
                        out[23 + outOffset] = (curInputValue5 >>> 1) & mask;
                        out[24 + outOffset] = (curInputValue5 >>> 8) & mask;
                        out[25 + outOffset] = (curInputValue5 >>> 15) & mask;
                        out[26 + outOffset] = (curInputValue5 >>> 22) & mask;
                        out[27 + outOffset] = ((curInputValue5 >>> 29) | (curInputValue6 << 3))
                                & mask;
                        out[28 + outOffset] = (curInputValue6 >>> 4) & mask;
                        out[29 + outOffset] = (curInputValue6 >>> 11) & mask;
                        out[30 + outOffset] = (curInputValue6 >>> 18) & mask;
                        out[31 + outOffset] = curInputValue6 >>> 25;
                        outOffset += 32;
                }
        }

        static private void unpack8(int[] out, int[] in) {
                int i, w;
                int outOffset = 0;
                final int mask = 255;
                for (i = 0, w = 1; i < 4; ++i, w += 8) {
                        int curInputValue0 = in[w];
                        int curInputValue1 = in[w + 1];
                        int curInputValue2 = in[w + 2];
                        int curInputValue3 = in[w + 3];
                        int curInputValue4 = in[w + 4];
                        int curInputValue5 = in[w + 5];
                        int curInputValue6 = in[w + 6];
                        int curInputValue7 = in[w + 7];
                        out[0 + outOffset] = curInputValue0 & mask;
                        out[1 + outOffset] = (curInputValue0 >>> 8) & mask;
                        out[2 + outOffset] = (curInputValue0 >>> 16) & mask;
                        out[3 + outOffset] = curInputValue0 >>> 24;
                        out[4 + outOffset] = curInputValue1 & mask;
                        out[5 + outOffset] = (curInputValue1 >>> 8) & mask;
                        out[6 + outOffset] = (curInputValue1 >>> 16) & mask;
                        out[7 + outOffset] = curInputValue1 >>> 24;
                        out[8 + outOffset] = curInputValue2 & mask;
                        out[9 + outOffset] = (curInputValue2 >>> 8) & mask;
                        out[10 + outOffset] = (curInputValue2 >>> 16) & mask;
                        out[11 + outOffset] = curInputValue2 >>> 24;
                        out[12 + outOffset] = curInputValue3 & mask;
                        out[13 + outOffset] = (curInputValue3 >>> 8) & mask;
                        out[14 + outOffset] = (curInputValue3 >>> 16) & mask;
                        out[15 + outOffset] = curInputValue3 >>> 24;
                        out[16 + outOffset] = curInputValue4 & mask;
                        out[17 + outOffset] = (curInputValue4 >>> 8) & mask;
                        out[18 + outOffset] = (curInputValue4 >>> 16) & mask;
                        out[19 + outOffset] = curInputValue4 >>> 24;
                        out[20 + outOffset] = curInputValue5 & mask;
                        out[21 + outOffset] = (curInputValue5 >>> 8) & mask;
                        out[22 + outOffset] = (curInputValue5 >>> 16) & mask;
                        out[23 + outOffset] = curInputValue5 >>> 24;
                        out[24 + outOffset] = curInputValue6 & mask;
                        out[25 + outOffset] = (curInputValue6 >>> 8) & mask;
                        out[26 + outOffset] = (curInputValue6 >>> 16) & mask;
                        out[27 + outOffset] = curInputValue6 >>> 24;
                        out[28 + outOffset] = curInputValue7 & mask;
                        out[29 + outOffset] = (curInputValue7 >>> 8) & mask;
                        out[30 + outOffset] = (curInputValue7 >>> 16) & mask;
                        out[31 + outOffset] = curInputValue7 >>> 24;
                        outOffset += 32;
                }
        }

        static private void unpack9(int[] out, int[] in) {
                int i, w;
                int outOffset = 0;
                final int mask = 511;
                for (i = 0, w = 1; i < 4; ++i, w += 9) {
                        int curInputValue0 = in[w];
                        int curInputValue1 = in[w + 1];
                        int curInputValue2 = in[w + 2];
                        int curInputValue3 = in[w + 3];
                        int curInputValue4 = in[w + 4];
                        int curInputValue5 = in[w + 5];
                        int curInputValue6 = in[w + 6];
                        int curInputValue7 = in[w + 7];
                        int curInputValue8 = in[w + 8];
                        out[0 + outOffset] = curInputValue0 & mask;
                        out[1 + outOffset] = (curInputValue0 >>> 9) & mask;
                        out[2 + outOffset] = (curInputValue0 >>> 18) & mask;
                        out[3 + outOffset] = ((curInputValue0 >>> 27) | (curInputValue1 << 5))
                                & mask;
                        out[4 + outOffset] = (curInputValue1 >>> 4) & mask;
                        out[5 + outOffset] = (curInputValue1 >>> 13) & mask;
                        out[6 + outOffset] = (curInputValue1 >>> 22) & mask;
                        out[7 + outOffset] = ((curInputValue1 >>> 31) | (curInputValue2 << 1))
                                & mask;
                        out[8 + outOffset] = (curInputValue2 >>> 8) & mask;
                        out[9 + outOffset] = (curInputValue2 >>> 17) & mask;
                        out[10 + outOffset] = ((curInputValue2 >>> 26) | (curInputValue3 << 6))
                                & mask;
                        out[11 + outOffset] = (curInputValue3 >>> 3) & mask;
                        out[12 + outOffset] = (curInputValue3 >>> 12) & mask;
                        out[13 + outOffset] = (curInputValue3 >>> 21) & mask;
                        out[14 + outOffset] = ((curInputValue3 >>> 30) | (curInputValue4 << 2))
                                & mask;
                        out[15 + outOffset] = (curInputValue4 >>> 7) & mask;
                        out[16 + outOffset] = (curInputValue4 >>> 16) & mask;
                        out[17 + outOffset] = ((curInputValue4 >>> 25) | (curInputValue5 << 7))
                                & mask;
                        out[18 + outOffset] = (curInputValue5 >>> 2) & mask;
                        out[19 + outOffset] = (curInputValue5 >>> 11) & mask;
                        out[20 + outOffset] = (curInputValue5 >>> 20) & mask;
                        out[21 + outOffset] = ((curInputValue5 >>> 29) | (curInputValue6 << 3))
                                & mask;
                        out[22 + outOffset] = (curInputValue6 >>> 6) & mask;
                        out[23 + outOffset] = (curInputValue6 >>> 15) & mask;
                        out[24 + outOffset] = ((curInputValue6 >>> 24) | (curInputValue7 << 8))
                                & mask;
                        out[25 + outOffset] = (curInputValue7 >>> 1) & mask;
                        out[26 + outOffset] = (curInputValue7 >>> 10) & mask;
                        out[27 + outOffset] = (curInputValue7 >>> 19) & mask;
                        out[28 + outOffset] = ((curInputValue7 >>> 28) | (curInputValue8 << 4))
                                & mask;
                        out[29 + outOffset] = (curInputValue8 >>> 5) & mask;
                        out[30 + outOffset] = (curInputValue8 >>> 14) & mask;
                        out[31 + outOffset] = curInputValue8 >>> 23;
                        outOffset += 32;
                }
        }

        static private void unpack10(int[] out, int[] in) {
                int i, w;
                int outOffset = 0;
                final int mask = 1023;
                for (i = 0, w = 1; i < 4; ++i, w += 10) {
                        int curInputValue0 = in[w];
                        int curInputValue1 = in[w + 1];
                        int curInputValue2 = in[w + 2];
                        int curInputValue3 = in[w + 3];
                        int curInputValue4 = in[w + 4];
                        int curInputValue5 = in[w + 5];
                        int curInputValue6 = in[w + 6];
                        int curInputValue7 = in[w + 7];
                        int curInputValue8 = in[w + 8];
                        int curInputValue9 = in[w + 9];
                        out[0 + outOffset] = curInputValue0 & mask;
                        out[1 + outOffset] = (curInputValue0 >>> 10) & mask;
                        out[2 + outOffset] = (curInputValue0 >>> 20) & mask;
                        out[3 + outOffset] = ((curInputValue0 >>> 30) | (curInputValue1 << 2))
                                & mask;
                        out[4 + outOffset] = (curInputValue1 >>> 8) & mask;
                        out[5 + outOffset] = (curInputValue1 >>> 18) & mask;
                        out[6 + outOffset] = ((curInputValue1 >>> 28) | (curInputValue2 << 4))
                                & mask;
                        out[7 + outOffset] = (curInputValue2 >>> 6) & mask;
                        out[8 + outOffset] = (curInputValue2 >>> 16) & mask;
                        out[9 + outOffset] = ((curInputValue2 >>> 26) | (curInputValue3 << 6))
                                & mask;
                        out[10 + outOffset] = (curInputValue3 >>> 4) & mask;
                        out[11 + outOffset] = (curInputValue3 >>> 14) & mask;
                        out[12 + outOffset] = ((curInputValue3 >>> 24) | (curInputValue4 << 8))
                                & mask;
                        out[13 + outOffset] = (curInputValue4 >>> 2) & mask;
                        out[14 + outOffset] = (curInputValue4 >>> 12) & mask;
                        out[15 + outOffset] = curInputValue4 >>> 22;
                        out[16 + outOffset] = curInputValue5 & mask;
                        out[17 + outOffset] = (curInputValue5 >>> 10) & mask;
                        out[18 + outOffset] = (curInputValue5 >>> 20) & mask;
                        out[19 + outOffset] = ((curInputValue5 >>> 30) | (curInputValue6 << 2))
                                & mask;
                        out[20 + outOffset] = (curInputValue6 >>> 8) & mask;
                        out[21 + outOffset] = (curInputValue6 >>> 18) & mask;
                        out[22 + outOffset] = ((curInputValue6 >>> 28) | (curInputValue7 << 4))
                                & mask;
                        out[23 + outOffset] = (curInputValue7 >>> 6) & mask;
                        out[24 + outOffset] = (curInputValue7 >>> 16) & mask;
                        out[25 + outOffset] = ((curInputValue7 >>> 26) | (curInputValue8 << 6))
                                & mask;
                        out[26 + outOffset] = (curInputValue8 >>> 4) & mask;
                        out[27 + outOffset] = (curInputValue8 >>> 14) & mask;
                        out[28 + outOffset] = ((curInputValue8 >>> 24) | (curInputValue9 << 8))
                                & mask;
                        out[29 + outOffset] = (curInputValue9 >>> 2) & mask;
                        out[30 + outOffset] = (curInputValue9 >>> 12) & mask;
                        out[31 + outOffset] = curInputValue9 >>> 22;
                        outOffset += 32;
                }
        }

        static private void unpack11(int[] out, int[] in) {
                int i, w;
                int outOffset = 0;
                final int mask = 2047;
                for (i = 0, w = 1; i < 4; ++i, w += 11) {
                        int curInputValue0 = in[w];
                        int curInputValue1 = in[w + 1];
                        int curInputValue2 = in[w + 2];
                        int curInputValue3 = in[w + 3];
                        int curInputValue4 = in[w + 4];
                        int curInputValue5 = in[w + 5];
                        int curInputValue6 = in[w + 6];
                        int curInputValue7 = in[w + 7];
                        int curInputValue8 = in[w + 8];
                        int curInputValue9 = in[w + 9];
                        int curInputValue10 = in[w + 10];
                        out[0 + outOffset] = curInputValue0 & mask;
                        out[1 + outOffset] = (curInputValue0 >>> 11) & mask;
                        out[2 + outOffset] = ((curInputValue0 >>> 22) | (curInputValue1 << 10))
                                & mask;
                        out[3 + outOffset] = (curInputValue1 >>> 1) & mask;
                        out[4 + outOffset] = (curInputValue1 >>> 12) & mask;
                        out[5 + outOffset] = ((curInputValue1 >>> 23) | (curInputValue2 << 9))
                                & mask;
                        out[6 + outOffset] = (curInputValue2 >>> 2) & mask;
                        out[7 + outOffset] = (curInputValue2 >>> 13) & mask;
                        out[8 + outOffset] = ((curInputValue2 >>> 24) | (curInputValue3 << 8))
                                & mask;
                        out[9 + outOffset] = (curInputValue3 >>> 3) & mask;
                        out[10 + outOffset] = (curInputValue3 >>> 14) & mask;
                        out[11 + outOffset] = ((curInputValue3 >>> 25) | (curInputValue4 << 7))
                                & mask;
                        out[12 + outOffset] = (curInputValue4 >>> 4) & mask;
                        out[13 + outOffset] = (curInputValue4 >>> 15) & mask;
                        out[14 + outOffset] = ((curInputValue4 >>> 26) | (curInputValue5 << 6))
                                & mask;
                        out[15 + outOffset] = (curInputValue5 >>> 5) & mask;
                        out[16 + outOffset] = (curInputValue5 >>> 16) & mask;
                        out[17 + outOffset] = ((curInputValue5 >>> 27) | (curInputValue6 << 5))
                                & mask;
                        out[18 + outOffset] = (curInputValue6 >>> 6) & mask;
                        out[19 + outOffset] = (curInputValue6 >>> 17) & mask;
                        out[20 + outOffset] = ((curInputValue6 >>> 28) | (curInputValue7 << 4))
                                & mask;
                        out[21 + outOffset] = (curInputValue7 >>> 7) & mask;
                        out[22 + outOffset] = (curInputValue7 >>> 18) & mask;
                        out[23 + outOffset] = ((curInputValue7 >>> 29) | (curInputValue8 << 3))
                                & mask;
                        out[24 + outOffset] = (curInputValue8 >>> 8) & mask;
                        out[25 + outOffset] = (curInputValue8 >>> 19) & mask;
                        out[26 + outOffset] = ((curInputValue8 >>> 30) | (curInputValue9 << 2))
                                & mask;
                        out[27 + outOffset] = (curInputValue9 >>> 9) & mask;
                        out[28 + outOffset] = (curInputValue9 >>> 20) & mask;
                        out[29 + outOffset] = ((curInputValue9 >>> 31) | (curInputValue10 << 1))
                                & mask;
                        out[30 + outOffset] = (curInputValue10 >>> 10) & mask;
                        out[31 + outOffset] = curInputValue10 >>> 21;
                        outOffset += 32;
                }
        }

        static private void unpack12(int[] out, int[] in) {
                int i, w;
                int outOffset = 0;
                final int mask = 4095;
                for (i = 0, w = 1; i < 4; ++i, w += 12) {
                        int curInputValue0 = in[w];
                        int curInputValue1 = in[w + 1];
                        int curInputValue2 = in[w + 2];
                        int curInputValue3 = in[w + 3];
                        int curInputValue4 = in[w + 4];
                        int curInputValue5 = in[w + 5];
                        int curInputValue6 = in[w + 6];
                        int curInputValue7 = in[w + 7];
                        int curInputValue8 = in[w + 8];
                        int curInputValue9 = in[w + 9];
                        int curInputValue10 = in[w + 10];
                        int curInputValue11 = in[w + 11];
                        out[0 + outOffset] = curInputValue0 & mask;
                        out[1 + outOffset] = (curInputValue0 >>> 12) & mask;
                        out[2 + outOffset] = ((curInputValue0 >>> 24) | (curInputValue1 << 8))
                                & mask;
                        out[3 + outOffset] = (curInputValue1 >>> 4) & mask;
                        out[4 + outOffset] = (curInputValue1 >>> 16) & mask;
                        out[5 + outOffset] = ((curInputValue1 >>> 28) | (curInputValue2 << 4))
                                & mask;
                        out[6 + outOffset] = (curInputValue2 >>> 8) & mask;
                        out[7 + outOffset] = curInputValue2 >>> 20;
                        out[8 + outOffset] = curInputValue3 & mask;
                        out[9 + outOffset] = (curInputValue3 >>> 12) & mask;
                        out[10 + outOffset] = ((curInputValue3 >>> 24) | (curInputValue4 << 8))
                                & mask;
                        out[11 + outOffset] = (curInputValue4 >>> 4) & mask;
                        out[12 + outOffset] = (curInputValue4 >>> 16) & mask;
                        out[13 + outOffset] = ((curInputValue4 >>> 28) | (curInputValue5 << 4))
                                & mask;
                        out[14 + outOffset] = (curInputValue5 >>> 8) & mask;
                        out[15 + outOffset] = curInputValue5 >>> 20;
                        out[16 + outOffset] = curInputValue6 & mask;
                        out[17 + outOffset] = (curInputValue6 >>> 12) & mask;
                        out[18 + outOffset] = ((curInputValue6 >>> 24) | (curInputValue7 << 8))
                                & mask;
                        out[19 + outOffset] = (curInputValue7 >>> 4) & mask;
                        out[20 + outOffset] = (curInputValue7 >>> 16) & mask;
                        out[21 + outOffset] = ((curInputValue7 >>> 28) | (curInputValue8 << 4))
                                & mask;
                        out[22 + outOffset] = (curInputValue8 >>> 8) & mask;
                        out[23 + outOffset] = curInputValue8 >>> 20;
                        out[24 + outOffset] = curInputValue9 & mask;
                        out[25 + outOffset] = (curInputValue9 >>> 12) & mask;
                        out[26 + outOffset] = ((curInputValue9 >>> 24) | (curInputValue10 << 8))
                                & mask;
                        out[27 + outOffset] = (curInputValue10 >>> 4) & mask;
                        out[28 + outOffset] = (curInputValue10 >>> 16) & mask;
                        out[29 + outOffset] = ((curInputValue10 >>> 28) | (curInputValue11 << 4))
                                & mask;
                        out[30 + outOffset] = (curInputValue11 >>> 8) & mask;
                        out[31 + outOffset] = curInputValue11 >>> 20;
                        outOffset += 32;
                }
        }

        static private void unpack13(int[] out, int[] in) {
                int i, w;
                int outOffset = 0;
                final int mask = 8191;
                for (i = 0, w = 1; i < 4; ++i, w += 13) {
                        int curInputValue0 = in[w];
                        int curInputValue1 = in[w + 1];
                        int curInputValue2 = in[w + 2];
                        int curInputValue3 = in[w + 3];
                        int curInputValue4 = in[w + 4];
                        int curInputValue5 = in[w + 5];
                        int curInputValue6 = in[w + 6];
                        int curInputValue7 = in[w + 7];
                        int curInputValue8 = in[w + 8];
                        int curInputValue9 = in[w + 9];
                        int curInputValue10 = in[w + 10];
                        int curInputValue11 = in[w + 11];
                        int curInputValue12 = in[w + 12];
                        out[0 + outOffset] = curInputValue0 & mask;
                        out[1 + outOffset] = (curInputValue0 >>> 13) & mask;
                        out[2 + outOffset] = ((curInputValue0 >>> 26) | (curInputValue1 << 6))
                                & mask;
                        out[3 + outOffset] = (curInputValue1 >>> 7) & mask;
                        out[4 + outOffset] = ((curInputValue1 >>> 20) | (curInputValue2 << 12))
                                & mask;
                        out[5 + outOffset] = (curInputValue2 >>> 1) & mask;
                        out[6 + outOffset] = (curInputValue2 >>> 14) & mask;
                        out[7 + outOffset] = ((curInputValue2 >>> 27) | (curInputValue3 << 5))
                                & mask;
                        out[8 + outOffset] = (curInputValue3 >>> 8) & mask;
                        out[9 + outOffset] = ((curInputValue3 >>> 21) | (curInputValue4 << 11))
                                & mask;
                        out[10 + outOffset] = (curInputValue4 >>> 2) & mask;
                        out[11 + outOffset] = (curInputValue4 >>> 15) & mask;
                        out[12 + outOffset] = ((curInputValue4 >>> 28) | (curInputValue5 << 4))
                                & mask;
                        out[13 + outOffset] = (curInputValue5 >>> 9) & mask;
                        out[14 + outOffset] = ((curInputValue5 >>> 22) | (curInputValue6 << 10))
                                & mask;
                        out[15 + outOffset] = (curInputValue6 >>> 3) & mask;
                        out[16 + outOffset] = (curInputValue6 >>> 16) & mask;
                        out[17 + outOffset] = ((curInputValue6 >>> 29) | (curInputValue7 << 3))
                                & mask;
                        out[18 + outOffset] = (curInputValue7 >>> 10) & mask;
                        out[19 + outOffset] = ((curInputValue7 >>> 23) | (curInputValue8 << 9))
                                & mask;
                        out[20 + outOffset] = (curInputValue8 >>> 4) & mask;
                        out[21 + outOffset] = (curInputValue8 >>> 17) & mask;
                        out[22 + outOffset] = ((curInputValue8 >>> 30) | (curInputValue9 << 2))
                                & mask;
                        out[23 + outOffset] = (curInputValue9 >>> 11) & mask;
                        out[24 + outOffset] = ((curInputValue9 >>> 24) | (curInputValue10 << 8))
                                & mask;
                        out[25 + outOffset] = (curInputValue10 >>> 5) & mask;
                        out[26 + outOffset] = (curInputValue10 >>> 18) & mask;
                        out[27 + outOffset] = ((curInputValue10 >>> 31) | (curInputValue11 << 1))
                                & mask;
                        out[28 + outOffset] = (curInputValue11 >>> 12) & mask;
                        out[29 + outOffset] = ((curInputValue11 >>> 25) | (curInputValue12 << 7))
                                & mask;
                        out[30 + outOffset] = (curInputValue12 >>> 6) & mask;
                        out[31 + outOffset] = curInputValue12 >>> 19;
                        outOffset += 32;
                }
        }

        static private void unpack16(int[] out, int[] in) {
                int i, w;
                int outOffset = 0;
                final int mask = 65535;
                for (i = 0, w = 1; i < 4; ++i, w += 16) {
                        int curInputValue0 = in[w];
                        int curInputValue1 = in[w + 1];
                        int curInputValue2 = in[w + 2];
                        int curInputValue3 = in[w + 3];
                        int curInputValue4 = in[w + 4];
                        int curInputValue5 = in[w + 5];
                        int curInputValue6 = in[w + 6];
                        int curInputValue7 = in[w + 7];
                        int curInputValue8 = in[w + 8];
                        int curInputValue9 = in[w + 9];
                        int curInputValue10 = in[w + 10];
                        int curInputValue11 = in[w + 11];
                        int curInputValue12 = in[w + 12];
                        int curInputValue13 = in[w + 13];
                        int curInputValue14 = in[w + 14];
                        int curInputValue15 = in[w + 15];
                        out[0 + outOffset] = curInputValue0 & mask;
                        out[1 + outOffset] = curInputValue0 >>> 16;
                        out[2 + outOffset] = curInputValue1 & mask;
                        out[3 + outOffset] = curInputValue1 >>> 16;
                        out[4 + outOffset] = curInputValue2 & mask;
                        out[5 + outOffset] = curInputValue2 >>> 16;
                        out[6 + outOffset] = curInputValue3 & mask;
                        out[7 + outOffset] = curInputValue3 >>> 16;
                        out[8 + outOffset] = curInputValue4 & mask;
                        out[9 + outOffset] = curInputValue4 >>> 16;
                        out[10 + outOffset] = curInputValue5 & mask;
                        out[11 + outOffset] = curInputValue5 >>> 16;
                        out[12 + outOffset] = curInputValue6 & mask;
                        out[13 + outOffset] = curInputValue6 >>> 16;
                        out[14 + outOffset] = curInputValue7 & mask;
                        out[15 + outOffset] = curInputValue7 >>> 16;
                        out[16 + outOffset] = curInputValue8 & mask;
                        out[17 + outOffset] = curInputValue8 >>> 16;
                        out[18 + outOffset] = curInputValue9 & mask;
                        out[19 + outOffset] = curInputValue9 >>> 16;
                        out[20 + outOffset] = curInputValue10 & mask;
                        out[21 + outOffset] = curInputValue10 >>> 16;
                        out[22 + outOffset] = curInputValue11 & mask;
                        out[23 + outOffset] = curInputValue11 >>> 16;
                        out[24 + outOffset] = curInputValue12 & mask;
                        out[25 + outOffset] = curInputValue12 >>> 16;
                        out[26 + outOffset] = curInputValue13 & mask;
                        out[27 + outOffset] = curInputValue13 >>> 16;
                        out[28 + outOffset] = curInputValue14 & mask;
                        out[29 + outOffset] = curInputValue14 >>> 16;
                        out[30 + outOffset] = curInputValue15 & mask;
                        out[31 + outOffset] = curInputValue15 >>> 16;
                        outOffset += 32;
                }
        }

        static private void unpack20(int[] out, int[] in) {
                int i, w;
                int outOffset = 0;
                final int mask = 1048575;
                for (i = 0, w = 1; i < 4; ++i, w += 20) {
                        int curInputValue0 = in[w];
                        int curInputValue1 = in[w + 1];
                        int curInputValue2 = in[w + 2];
                        int curInputValue3 = in[w + 3];
                        int curInputValue4 = in[w + 4];
                        int curInputValue5 = in[w + 5];
                        int curInputValue6 = in[w + 6];
                        int curInputValue7 = in[w + 7];
                        int curInputValue8 = in[w + 8];
                        int curInputValue9 = in[w + 9];
                        int curInputValue10 = in[w + 10];
                        int curInputValue11 = in[w + 11];
                        int curInputValue12 = in[w + 12];
                        int curInputValue13 = in[w + 13];
                        int curInputValue14 = in[w + 14];
                        int curInputValue15 = in[w + 15];
                        int curInputValue16 = in[w + 16];
                        int curInputValue17 = in[w + 17];
                        int curInputValue18 = in[w + 18];
                        int curInputValue19 = in[w + 19];
                        out[0 + outOffset] = curInputValue0 & mask;
                        out[1 + outOffset] = ((curInputValue0 >>> 20) | (curInputValue1 << 12))
                                & mask;
                        out[2 + outOffset] = (curInputValue1 >>> 8) & mask;
                        out[3 + outOffset] = ((curInputValue1 >>> 28) | (curInputValue2 << 4))
                                & mask;
                        out[4 + outOffset] = ((curInputValue2 >>> 16) | (curInputValue3 << 16))
                                & mask;
                        out[5 + outOffset] = (curInputValue3 >>> 4) & mask;
                        out[6 + outOffset] = ((curInputValue3 >>> 24) | (curInputValue4 << 8))
                                & mask;
                        out[7 + outOffset] = curInputValue4 >>> 12;
                        out[8 + outOffset] = curInputValue5 & mask;
                        out[9 + outOffset] = ((curInputValue5 >>> 20) | (curInputValue6 << 12))
                                & mask;
                        out[10 + outOffset] = (curInputValue6 >>> 8) & mask;
                        out[11 + outOffset] = ((curInputValue6 >>> 28) | (curInputValue7 << 4))
                                & mask;
                        out[12 + outOffset] = ((curInputValue7 >>> 16) | (curInputValue8 << 16))
                                & mask;
                        out[13 + outOffset] = (curInputValue8 >>> 4) & mask;
                        out[14 + outOffset] = ((curInputValue8 >>> 24) | (curInputValue9 << 8))
                                & mask;
                        out[15 + outOffset] = curInputValue9 >>> 12;
                        out[16 + outOffset] = curInputValue10 & mask;
                        out[17 + outOffset] = ((curInputValue10 >>> 20) | (curInputValue11 << 12))
                                & mask;
                        out[18 + outOffset] = (curInputValue11 >>> 8) & mask;
                        out[19 + outOffset] = ((curInputValue11 >>> 28) | (curInputValue12 << 4))
                                & mask;
                        out[20 + outOffset] = ((curInputValue12 >>> 16) | (curInputValue13 << 16))
                                & mask;
                        out[21 + outOffset] = (curInputValue13 >>> 4) & mask;
                        out[22 + outOffset] = ((curInputValue13 >>> 24) | (curInputValue14 << 8))
                                & mask;
                        out[23 + outOffset] = curInputValue14 >>> 12;
                        out[24 + outOffset] = curInputValue15 & mask;
                        out[25 + outOffset] = ((curInputValue15 >>> 20) | (curInputValue16 << 12))
                                & mask;
                        out[26 + outOffset] = (curInputValue16 >>> 8) & mask;
                        out[27 + outOffset] = ((curInputValue16 >>> 28) | (curInputValue17 << 4))
                                & mask;
                        out[28 + outOffset] = ((curInputValue17 >>> 16) | (curInputValue18 << 16))
                                & mask;
                        out[29 + outOffset] = (curInputValue18 >>> 4) & mask;
                        out[30 + outOffset] = ((curInputValue18 >>> 24) | (curInputValue19 << 8))
                                & mask;
                        out[31 + outOffset] = curInputValue19 >>> 12;
                        outOffset += 32;
                }
        }

        static private void unpack28(int[] out, int[] in) {
                int i, w;
                int outOffset = 0;
                final int mask = 268435455;
                for (i = 0, w = 1; i < 4; ++i, w += 28) {
                        int curInputValue0 = in[w];
                        int curInputValue1 = in[w + 1];
                        int curInputValue2 = in[w + 2];
                        int curInputValue3 = in[w + 3];
                        int curInputValue4 = in[w + 4];
                        int curInputValue5 = in[w + 5];
                        int curInputValue6 = in[w + 6];
                        int curInputValue7 = in[w + 7];
                        int curInputValue8 = in[w + 8];
                        int curInputValue9 = in[w + 9];
                        int curInputValue10 = in[w + 10];
                        int curInputValue11 = in[w + 11];
                        int curInputValue12 = in[w + 12];
                        int curInputValue13 = in[w + 13];
                        int curInputValue14 = in[w + 14];
                        int curInputValue15 = in[w + 15];
                        int curInputValue16 = in[w + 16];
                        int curInputValue17 = in[w + 17];
                        int curInputValue18 = in[w + 18];
                        int curInputValue19 = in[w + 19];
                        int curInputValue20 = in[w + 20];
                        int curInputValue21 = in[w + 21];
                        int curInputValue22 = in[w + 22];
                        int curInputValue23 = in[w + 23];
                        int curInputValue24 = in[w + 24];
                        int curInputValue25 = in[w + 25];
                        int curInputValue26 = in[w + 26];
                        int curInputValue27 = in[w + 27];
                        out[0 + outOffset] = curInputValue0 & mask;
                        out[1 + outOffset] = ((curInputValue0 >>> 28) | (curInputValue1 << 4))
                                & mask;
                        out[2 + outOffset] = ((curInputValue1 >>> 24) | (curInputValue2 << 8))
                                & mask;
                        out[3 + outOffset] = ((curInputValue2 >>> 20) | (curInputValue3 << 12))
                                & mask;
                        out[4 + outOffset] = ((curInputValue3 >>> 16) | (curInputValue4 << 16))
                                & mask;
                        out[5 + outOffset] = ((curInputValue4 >>> 12) | (curInputValue5 << 20))
                                & mask;
                        out[6 + outOffset] = ((curInputValue5 >>> 8) | (curInputValue6 << 24))
                                & mask;
                        out[7 + outOffset] = curInputValue6 >>> 4;
                        out[8 + outOffset] = curInputValue7 & mask;
                        out[9 + outOffset] = ((curInputValue7 >>> 28) | (curInputValue8 << 4))
                                & mask;
                        out[10 + outOffset] = ((curInputValue8 >>> 24) | (curInputValue9 << 8))
                                & mask;
                        out[11 + outOffset] = ((curInputValue9 >>> 20) | (curInputValue10 << 12))
                                & mask;
                        out[12 + outOffset] = ((curInputValue10 >>> 16) | (curInputValue11 << 16))
                                & mask;
                        out[13 + outOffset] = ((curInputValue11 >>> 12) | (curInputValue12 << 20))
                                & mask;
                        out[14 + outOffset] = ((curInputValue12 >>> 8) | (curInputValue13 << 24))
                                & mask;
                        out[15 + outOffset] = curInputValue13 >>> 4;
                        out[16 + outOffset] = curInputValue14 & mask;
                        out[17 + outOffset] = ((curInputValue14 >>> 28) | (curInputValue15 << 4))
                                & mask;
                        out[18 + outOffset] = ((curInputValue15 >>> 24) | (curInputValue16 << 8))
                                & mask;
                        out[19 + outOffset] = ((curInputValue16 >>> 20) | (curInputValue17 << 12))
                                & mask;
                        out[20 + outOffset] = ((curInputValue17 >>> 16) | (curInputValue18 << 16))
                                & mask;
                        out[21 + outOffset] = ((curInputValue18 >>> 12) | (curInputValue19 << 20))
                                & mask;
                        out[22 + outOffset] = ((curInputValue19 >>> 8) | (curInputValue20 << 24))
                                & mask;
                        out[23 + outOffset] = curInputValue20 >>> 4;
                        out[24 + outOffset] = curInputValue21 & mask;
                        out[25 + outOffset] = ((curInputValue21 >>> 28) | (curInputValue22 << 4))
                                & mask;
                        out[26 + outOffset] = ((curInputValue22 >>> 24) | (curInputValue23 << 8))
                                & mask;
                        out[27 + outOffset] = ((curInputValue23 >>> 20) | (curInputValue24 << 12))
                                & mask;
                        out[28 + outOffset] = ((curInputValue24 >>> 16) | (curInputValue25 << 16))
                                & mask;
                        out[29 + outOffset] = ((curInputValue25 >>> 12) | (curInputValue26 << 20))
                                & mask;
                        out[30 + outOffset] = ((curInputValue26 >>> 8) | (curInputValue27 << 24))
                                & mask;
                        out[31 + outOffset] = curInputValue27 >>> 4;
                        outOffset += 32;
                }
        }
}
