/**
 * This is code is released under the
 * Apache License Version 2.0 http://www.apache.org/licenses/.
 *
 * (c) Daniel Lemire, http://lemire.me/en/
 */
package integercompression;

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;

import integercompression.synth.*;

public class benchmark {

  public static void main(String args[]) {
    test(20, 18, 10);
  }

  public static void testCodec(IntegerCODEC c, int[][] data, int Max, int repeat, boolean verbose) {
    DecimalFormat df = new DecimalFormat("0.00");
    DecimalFormat dfspeed = new DecimalFormat("0");
    if(verbose) System.out.println("# " + c.toString());
    if(verbose) System.out
      .println("# bits per int, compress speed (mis), decompression speed (mis) ");
    long bef, aft;
    String line = "";
    int N = data.length;
    int totalsize = 0;
    int maxlength = 0;
    int[] complength = new int[N];
    int[][] dataout = new int[N][];
    for (int k = 0; k < N; ++k) {
      dataout[k] = new int[4 * data[k].length + 1024];
      /* 4x + 1024 to account for the possibility of some negative compression */
      totalsize += data[k].length;
      if (data[k].length > maxlength)
        maxlength = data[k].length;
    }
    bef = System.currentTimeMillis();
    int size = 0;
    for (int r = 0; r < repeat; ++r) {
      size = 0;
      for (int k = 0; k < N; ++k) {
        AtomicInteger howmanyread = new AtomicInteger(0);
        AtomicInteger howmanywritten = new AtomicInteger(0);
        c.compress(data[k], howmanyread, data[k].length, dataout[k], howmanywritten);
        size += howmanywritten.intValue();
        complength[k] = howmanywritten.intValue();
        //if (dataout[k].length != howmanywritten.intValue())
        //  dataout[k] = Arrays.copyOf(dataout[k], howmanywritten.intValue());
      }
    }
    aft = System.currentTimeMillis();
    line += "\t" + df.format(size * 32.0 / totalsize);
    line += "\t" + dfspeed.format(totalsize * repeat / (1000.0 * (aft - bef)));

    // uncompressing
    int[] buffer = new int[maxlength];
    for (int r = 0; r < repeat; ++r)
      for (int k = 0; k < N; ++k) {
        AtomicInteger howmanyread = new AtomicInteger(0);
        AtomicInteger howmanywritten = new AtomicInteger(0);
        c.uncompress(dataout[k], howmanyread, complength[k], buffer, howmanywritten);
        if (howmanywritten.intValue() != data[k].length)
          throw new RuntimeException("we have a bug (diff length)");
        for (int m = 0; m < howmanywritten.intValue(); ++m)
          if (buffer[m] != data[k][m]) {
            throw new RuntimeException("we have a bug (actual difference), expected "+data[k][m]+" found "+buffer[m]+" at "+m);
          }
      }
    bef = System.currentTimeMillis();
    for (int r = 0; r < repeat; ++r)
      for (int k = 0; k < N; ++k) {
        AtomicInteger howmanyread = new AtomicInteger(0);
        AtomicInteger howmanywritten = new AtomicInteger(0);
        c.uncompress(dataout[k], howmanyread, complength[k], buffer, howmanywritten);
        if (howmanywritten.intValue() != data[k].length)
          throw new RuntimeException("we have a bug");
      }
    aft = System.currentTimeMillis();
    line += "\t" + dfspeed.format(totalsize * repeat / (1000.0 * (aft - bef)));
    if(verbose) System.out.println(line);
  }

  public static void test(int N, int nbr, int repeat) {
    ClusteredDataGenerator cdg = new ClusteredDataGenerator();
    for (int sparsity = 1; sparsity < 31 - nbr; sparsity += 1) {
      System.out.println("# sparsity " + sparsity);
      int[][] data = new int[N][];
      int Max = (1 << (nbr + sparsity));
      System.out.println("# generating random data...");
      for (int k = 0; k < N; ++k) {
        data[k] = cdg.generateClustered((1 << nbr) , Max);
        for (int m = data[k].length - 1; m > 0; --m) {
          data[k][m] = data[k][m] - data[k][m - 1];
        }
        data[k] = Arrays.copyOfRange(data[k], 1, data[k].length);
      }
      System.out.println("# generating random data... ok.");
      // building

      // building
      testCodec(new VariableByte(), data, Max, repeat, false);
      testCodec(new VariableByte(), data, Max, repeat, false);
      testCodec(new VariableByte(), data, Max, repeat, true);
      System.out.println();

      
      testCodec(new simple9(), data, Max, repeat, false);
      testCodec(new simple9(), data, Max, repeat, false);
      testCodec(new simple9(), data, Max, repeat, true);
      System.out.println();
      
      testCodec(new Composition(new NewPFD(),new VariableByte()), data, Max, repeat, false);
      testCodec(new Composition(new NewPFD(),new VariableByte()), data, Max, repeat, false);
      testCodec(new Composition(new NewPFD(),new VariableByte()), data, Max, repeat, true);
      System.out.println();

      testCodec(new Composition(new OptPFD(),new VariableByte()), data, Max, repeat, false);
      testCodec(new Composition(new OptPFD(),new VariableByte()), data, Max, repeat, false);
      testCodec(new Composition(new OptPFD(),new VariableByte()), data, Max, repeat, true);
      System.out.println();
      
      testCodec(new Composition(new FastPFOR(),new VariableByte()), data, Max, repeat, false);
      testCodec(new Composition(new FastPFOR(),new VariableByte()), data, Max, repeat, false);
      testCodec(new Composition(new FastPFOR(),new VariableByte()), data, Max, repeat, true);
      System.out.println();
     
      testCodec(new Composition(new BinaryPacking(),new VariableByte()), data, Max, repeat, false);
      testCodec(new Composition(new BinaryPacking(),new VariableByte()), data, Max, repeat, false);
      testCodec(new Composition(new BinaryPacking(),new VariableByte()), data, Max, repeat, true);
      System.out.println();

      testCodec(new JustCopy(), data, Max, repeat, false);
      testCodec(new JustCopy(), data, Max, repeat, false);
      testCodec(new JustCopy(), data, Max, repeat, true);
      System.out.println();

    }
  }
}
