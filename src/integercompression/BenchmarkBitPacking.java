/**
 * This is code is released under the
 * Apache License Version 2.0 http://www.apache.org/licenses/.
 *
 * (c) Daniel Lemire, http://lemire.me/en/
 */
package integercompression;

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Random;

public class BenchmarkBitPacking {
  public static void test(boolean verbose) {
    DecimalFormat dfspeed = new DecimalFormat("0");
    final int N = 32;
    final int times = 100000;
    Random r = new Random(0);
    int[] data = new int[N];
    int[] compressed = new int[N];
    int[] uncompressed = new int[N];
    for (int bit = 0; bit < 31; ++bit) {
      long comp = 0;
      long decomp = 0;
      for (int t = 0; t < times; ++t) {
        for (int k = 0; k < N; ++k) {
          data[k] = r.nextInt(1 << bit);
        }
        long time1 = System.nanoTime();
        BitPacking.fastpack(data, 0, compressed, 0, bit);
        long time2 = System.nanoTime();
        BitPacking.fastunpack(compressed, 0, uncompressed, 0, bit);
        long time3 = System.nanoTime();
        comp += time2 - time1;
        decomp += time3 - time2;
      }
      if (verbose)
        System.out.println("bit = " + bit + " comp. speed = "
          + dfspeed.format(N * times * 1000.0 / (comp)) + " decomp. speed = "
          + dfspeed.format(N * times * 1000.0 / (decomp)));
    }
  }

  public static void verify() {
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
  public static void verifyWithoutMask() {
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
  public static void verifyWithExceptions() {
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
        for(int k = 0; k < N; ++k) {
          if((data[k]& ((1<<bit)-1)) != uncompressed[k]) {
            for(int k2 = 0; k2 < N; ++k2) {
              System.out.println((data[k]& ((1<<bit)-1))+" "+uncompressed[k]);
            }
            System.out.println(compressed[0]);
            throw new RuntimeException("bug " + bit);
          }
        }
      }
    }
    System.out.println("Code with overflow appears to be correct.");
  }
  public static void main(String[] args) {
    verify();
    verifyWithExceptions();
    verifyWithoutMask();
    test(false);
    test(true);
  }

}
