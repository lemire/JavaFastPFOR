/**
 * This code is released under the
 * Apache License Version 2.0 http://www.apache.org/licenses/.
 */
package me.lemire.integercompression;

import java.util.Random;

public class BenchmarkOffsettedSeries
{
    public static final int DEFAULT_MEAN = 1 << 20;
    public static final int DEFAULT_RANGE = 1 << 10;

    public BenchmarkOffsettedSeries() {
    }

    /**
     * Run benchmark.
     *
     * @param count Count of data chunks.
     * @param length Length of a data chunk.
     */
    public void run(int count, int length) {
        int[][] data = generateDataChunks(0, count, length,
                DEFAULT_MEAN, DEFAULT_RANGE);
        // TODO:
    }

    public static int[][] generateDataChunks(
            long seed,
            int count,
            int length,
            int mean,
            int range)
    {
        int offset = mean - range / 2;
        int[][] chunks = new int[count][];
        Random r = new Random(seed);
        for (int i = 0; i < count; ++i) {
            int[] chunk = chunks[i] = new int[length];
            for (int j = 0; j < length; ++j) {
                chunk[j] = (r.nextInt() % range) + offset;
            }
        }
        return chunks;
    }

    public static void main(String[] args) {
        BenchmarkOffsettedSeries b = new BenchmarkOffsettedSeries();
        b.run(1024, 1024);
        System.out.println("Hello BenchmarkOffsettedSeries");
    }
}
