/**
 * This is code is released under the
 * Apache License Version 2.0 http://www.apache.org/licenses/.
 *
 * (c) Daniel Lemire, http://lemire.me/en/
 */
package integercompression;

/**
 * This is a version of Simple9 optimized for NewPFOR, OptPFOR
 * 
 * @author Daniel Lemire
 * 
 */

public final class s9 {
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
          if (max <= in[currentPos + i])
            continue mainloop;
        currentPos += compressedNum;
        ++tmpoutpos;
        continue outer;
      }
      final int selector = 8;
      Util.assertTrue(codeNum[selector] == 1);
      if (in[currentPos] >= 1 << bitLength[selector])
        throw new RuntimeException("Too big a number");
      tmpoutpos++;
      currentPos++;

    }
    return tmpoutpos;
  }

  public static int compress(int[] in, int currentPos, int inlength, int out[],
    int tmpoutpos) {
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
          if (max <= in[currentPos + i])
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
      Util.assertTrue(codeNum[selector] == 1);
      if (in[currentPos] >= 1 << bitLength[selector])
        throw new RuntimeException("Too big a number");
      out[tmpoutpos++] = in[currentPos++] | (selector << 28);
    }
    Util.assertTrue(currentPos == finalpos);
    return tmpoutpos - origtmpoutpos;
  }

  public static void uncompress(int[] in, int tmpinpos, int inlength,
    int[] out, int currentPos, int outlength) {
    int finallength = currentPos + outlength;
    int finalin = tmpinpos + inlength;

    while (currentPos < finallength) {
      int val = in[tmpinpos++];
      int header = val >>> 28;
      switch (header) {
      case 0: { // number : 28, bitwidth : 1
        final int howmany = finallength - currentPos < 28 ? finallength
          - currentPos : 28;
        for (int k = 0; k < howmany; ++k) {
          out[currentPos++] = (val << (k + 4)) >>> 31;
        }
        break;
      }
      case 1: { // number : 14, bitwidth : 2
        final int howmany = finallength - currentPos < 14 ? finallength
          - currentPos : 14;
        for (int k = 0; k < howmany; ++k) {
          out[currentPos++] = (val << (2 * k + 4)) >>> 30;
        }
        break;
      }
      case 2: { // number : 9, bitwidth : 3
        final int howmany = finallength - currentPos < 9 ? finallength
          - currentPos : 9;
        for (int k = 0; k < howmany; ++k) {
          out[currentPos++] = (val << (3 * k + 5)) >>> 29;
        }
        break;
      }
      case 3: { // number : 7, bitwidth : 4
        final int howmany = finallength - currentPos < 7 ? finallength
          - currentPos : 7;
        for (int k = 0; k < howmany; ++k) {
          out[currentPos++] = (val << (4 * k + 4)) >>> 28;
        }
        break;
      }
      case 4: { // number : 5, bitwidth : 5
        final int howmany = finallength - currentPos < 5 ? finallength
          - currentPos : 5;
        for (int k = 0; k < howmany; ++k) {
          out[currentPos++] = (val << (5 * k + 7)) >>> 27;
        }
        break;
      }
      case 5: { // number : 4, bitwidth : 7
        final int howmany = finallength - currentPos < 4 ? finallength
          - currentPos : 4;
        for (int k = 0; k < howmany; ++k) {
          out[currentPos++] = (val << (7 * k + 4)) >>> 25;
        }
        break;
      }
      case 6: { // number : 3, bitwidth : 9
        final int howmany = finallength - currentPos < 3 ? finallength
          - currentPos : 3;
        for (int k = 0; k < howmany; ++k) {
          out[currentPos++] = (val << (9 * k + 5)) >>> 23;
        }
        break;
      }
      case 7: { // number : 2, bitwidth : 14
        final int howmany = finallength - currentPos < 2 ? finallength
          - currentPos : 2;
        for (int k = 0; k < howmany; ++k) {
          out[currentPos++] = (val << (14 * k + 4)) >>> 18;
        }
        break;
      }
      case 8: { // number : 2, bitwidth : 14
        out[currentPos++] = (val << 4) >>> 4;
        break;
      }
      default: {
        throw new RuntimeException("shouldn't happen");
      }
      }
    }
    Util.assertTrue(currentPos == finallength);
    Util.assertTrue(tmpinpos <= finalin);

  }
  
  private final static int bitLength[] = { 1, 2, 3, 4, 5, 7, 9, 14, 28 };

  private final static int codeNum[] = { 28, 14, 9, 7, 5, 4, 3, 2, 1 };

 

}
