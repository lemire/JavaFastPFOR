// Copyright (C) 2022 Intel Corporation

// SPDX-License-Identifier: Apache-2.0

import java.util.Arrays;
import me.lemire.integercompression.FastPFOR;
import me.lemire.integercompression.IntWrapper;
import me.lemire.integercompression.Composition;
import me.lemire.integercompression.IntegerCODEC;
import me.lemire.integercompression.VariableByte;
import me.lemire.integercompression.vector.VectorFastPFOR;

public class Example {
  public static void main(String[] args) {
    if (args.length == 0)
      throw new IllegalArgumentException();

    // pass 0 for Vector compressor , non-zero for default compressor
    int compressorToUse = Integer.parseInt(args[0]);

    final int N = 1310720;
    int[] data = new int[N];

    // 2-bit data
    for (int k = 0; k < N; k += 1)
      data[k] = 3;

    // a few large values
    for (int k = 0; k < N; k += 5)
      data[k] = 100;
    for (int k = 0; k < N; k += 533)
      data[k] = 10000;

    int[] compressed = new int[N + 1024];

    IntegerCODEC codec = new Composition(
        compressorToUse == 0 ? new VectorFastPFOR() : new FastPFOR(),
        new VariableByte());

    IntWrapper inputoffset = new IntWrapper(0);
    IntWrapper outputoffset = new IntWrapper(0);

    codec.compress(data, inputoffset, data.length, compressed, outputoffset);

    System.out.println("compressed unsorted integers from " +
                       data.length * 4 / 1024 + "KB to " +
                       outputoffset.intValue() * 4 / 1024 + "KB");

    compressed = Arrays.copyOf(compressed, outputoffset.intValue());

    int[] recovered = new int[N];
    IntWrapper recoffset = new IntWrapper(0);

    codec.uncompress(compressed, new IntWrapper(0), compressed.length,
                     recovered, recoffset);

    System.out.println("compressed length = " + compressed.length +
                       ", uncompressed length = " + recoffset.intValue());

    if (Arrays.equals(data, recovered))
      System.out.println("data is recovered without loss");
    else
      throw new RuntimeException("bug"); // could use assert

    System.out.println();
  }
}
