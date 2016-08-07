/**
 * This code is released under the
 * Apache License Version 2.0 http://www.apache.org/licenses/.
 */
package me.lemire.integercompression.benchmarktools;

import java.io.File;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Random;

import me.lemire.integercompression.BinaryPacking;
import me.lemire.integercompression.DeltaZigzagBinaryPacking;
import me.lemire.integercompression.DeltaZigzagVariableByte;
import me.lemire.integercompression.FastPFOR;
import me.lemire.integercompression.FastPFOR128;
import me.lemire.integercompression.IntWrapper;
import me.lemire.integercompression.IntegerCODEC;
import me.lemire.integercompression.JustCopy;
import me.lemire.integercompression.differential.IntegratedBinaryPacking;
import me.lemire.integercompression.differential.XorBinaryPacking;

/**
 * Simple synthetic benchmark
 *
 */
public class BenchmarkOffsettedSeries {
        private static final int DEFAULT_MEAN = 1 << 20;
        private static final int DEFAULT_RANGE = 1 << 10;
        private static final int DEFAULT_REPEAT = 5;
        private static final int DEFAULT_WARMUP = 2;


        /**
         * Run benchmark.
         * 
         * @param csvWriter
         *                Write for results in CSV.
         * @param count
         *                Count of data chunks.
         * @param length
         *                Length of a data chunk.
         */
        public static void run(final PrintWriter csvWriter, final int count, final int length) {
                IntegerCODEC[] codecs = { new JustCopy(), new BinaryPacking(),
                        new DeltaZigzagBinaryPacking(),
                        new DeltaZigzagVariableByte(),
                        new IntegratedBinaryPacking(), new XorBinaryPacking(),
                        new FastPFOR128(), new FastPFOR()};

                csvWriter
                        .format("\"Dataset\",\"CODEC\",\"Bits per int\","
                                + "\"Compress speed (MiS)\",\"Decompress speed (MiS)\"\n");

                benchmark(csvWriter, codecs, count, length, DEFAULT_MEAN,
                        DEFAULT_RANGE);
                benchmark(csvWriter, codecs, count, length, DEFAULT_MEAN >> 5,
                        DEFAULT_RANGE);

                IntegerCODEC[] codecs2 = { new JustCopy(), new BinaryPacking(),
                        new DeltaZigzagBinaryPacking(),
                        new DeltaZigzagVariableByte(),
                        new IntegratedBinaryPacking(), new XorBinaryPacking(),
                        new FastPFOR128(),new FastPFOR(), };

                int freq = length / 4;
                benchmarkSine(csvWriter, codecs2, count, length,
                        DEFAULT_MEAN >> 0, DEFAULT_RANGE >> 0, freq);
                benchmarkSine(csvWriter, codecs2, count, length,
                        DEFAULT_MEAN >> 5, DEFAULT_RANGE >> 0, freq);
                benchmarkSine(csvWriter, codecs2, count, length,
                        DEFAULT_MEAN >> 10, DEFAULT_RANGE >> 0, freq);
                benchmarkSine(csvWriter, codecs2, count, length,
                        DEFAULT_MEAN >> 0, DEFAULT_RANGE >> 2, freq);
                benchmarkSine(csvWriter, codecs2, count, length,
                        DEFAULT_MEAN >> 5, DEFAULT_RANGE >> 2, freq);
                benchmarkSine(csvWriter, codecs2, count, length,
                        DEFAULT_MEAN >> 10, DEFAULT_RANGE >> 2, freq);
                benchmarkSine(csvWriter, codecs2, count, length,
                        DEFAULT_MEAN >> 0, DEFAULT_RANGE >> 4, freq);
                benchmarkSine(csvWriter, codecs2, count, length,
                        DEFAULT_MEAN >> 5, DEFAULT_RANGE >> 4, freq);
                benchmarkSine(csvWriter, codecs2, count, length,
                        DEFAULT_MEAN >> 10, DEFAULT_RANGE >> 4, freq);
        }

        private static void benchmarkSine(final PrintWriter csvWriter,
                final IntegerCODEC[] codecs, final int count, final int length, final int mean,
                final int range, final int freq) {
                String dataProp = String.format(
                        "(mean=%1$d range=%2$d freq=%3$d)", mean, range, freq);
                int[][] data = generateSineDataChunks(0, count, length, mean,
                        range, freq);
                benchmark(csvWriter, "Sine " + dataProp, codecs, data,
                        DEFAULT_REPEAT, DEFAULT_WARMUP);
                benchmark(csvWriter, "Sine+delta " + dataProp, codecs, data,
                        DEFAULT_REPEAT, DEFAULT_WARMUP);
        }

        private static void benchmark(final PrintWriter csvWriter, final IntegerCODEC[] codecs,
                final int count, final int length, final int mean, final int range) {
                String dataProp = String.format("(mean=%1$d range=%2$d)", mean,
                        range);

                int[][] randData = generateDataChunks(0, count, length, mean,
                        range);
                int[][] deltaData = deltaDataChunks(randData);
                int[][] sortedData = sortDataChunks(randData);
                int[][] sortedDeltaData = deltaDataChunks(sortedData);

                benchmark(csvWriter, "Random " + dataProp, codecs, randData,
                        DEFAULT_REPEAT, DEFAULT_WARMUP);
                benchmark(csvWriter, "Random+delta " + dataProp, codecs,
                        deltaData, DEFAULT_REPEAT, DEFAULT_WARMUP);
                benchmark(csvWriter, "Sorted " + dataProp, codecs, sortedData,
                        DEFAULT_REPEAT, DEFAULT_WARMUP);
                benchmark(csvWriter, "Sorted+delta " + dataProp, codecs,
                        sortedDeltaData, DEFAULT_REPEAT, DEFAULT_WARMUP);
        }

        private static void benchmark(final PrintWriter csvWriter, final String dataName,
                final IntegerCODEC[] codecs, final int[][] data, final int repeat, final int warmup) {
                System.out.println("Processing: " + dataName);
                for (IntegerCODEC codec : codecs) {
                        String codecName = codec.toString();
                        for (int i = 0; i < warmup; ++i) {
                                benchmark(null, null, null, codec, data, repeat);
                        }
                        benchmark(csvWriter, dataName, codecName, codec, data,
                                repeat);
                }
        }

        private static void benchmark(PrintWriter csvWriter, String dataName,
                String codecName, IntegerCODEC codec, int[][] data, int repeat) {
                PerformanceLogger logger = new PerformanceLogger();

                int maxLen = getMaxLen(data);
                int[] compressBuffer = new int[4 * maxLen + 1024];
                int[] decompressBuffer = new int[maxLen];

                for (int i = 0; i < repeat; ++i) {
                        for (int[] array : data) {
                                int compSize = compress(logger, codec, array,
                                        compressBuffer);
                                int decompSize = decompress(logger, codec,
                                        compressBuffer, compSize,
                                        decompressBuffer);
                                checkArray(array, decompressBuffer, decompSize,
                                        codec);
                        }
                }

                if (csvWriter != null) {
                        csvWriter.format(
                                "\"%1$s\",\"%2$s\",%3$.2f,%4$.0f,%5$.0f\n",
                                dataName, codecName, logger.getBitPerInt(),
                                logger.getCompressSpeed(),
                                logger.getDecompressSpeed());
                }
        }

        private static void checkArray(int[] expected, int[] actualArray,
                int actualLen, IntegerCODEC codec) {
                if (actualLen != expected.length) {
                        throw new RuntimeException("Length mismatch:"
                                + " expected=" + expected.length + " actual="
                                + actualLen + " codec=" + codec.toString());
                }
                for (int i = 0; i < expected.length; ++i) {
                        if (actualArray[i] != expected[i]) {
                                throw new RuntimeException("Value mismatch: "
                                        + " where=" + i + " expected="
                                        + expected[i] + " actual="
                                        + actualArray[i] + " codec="
                                        + codec.toString());
                        }
                }
        }

        private static int compress(PerformanceLogger logger, IntegerCODEC codec,
                int[] src, int[] dst) {
                IntWrapper inpos = new IntWrapper();
                IntWrapper outpos = new IntWrapper();
                logger.compressionTimer.start();
                codec.compress(src, inpos, src.length, dst, outpos);
                logger.compressionTimer.end();
                int outSize = outpos.get();
                logger.addOriginalSize(src.length);
                logger.addCompressedSize(outSize);
                return outSize;
        }

        private static int decompress(PerformanceLogger logger, IntegerCODEC codec,
                int[] src, int srcLen, int[] dst) {
                IntWrapper inpos = new IntWrapper();
                IntWrapper outpos = new IntWrapper();
                logger.decompressionTimer.start();
                codec.uncompress(src, inpos, srcLen, dst, outpos);
                logger.decompressionTimer.end();
                return outpos.get();
        }

        private static int getMaxLen(int[][] data) {
                int maxLen = 0;
                for (int[] array : data) {
                        if (array.length > maxLen) {
                                maxLen = array.length;
                        }
                }
                return maxLen;
        }

        private static int[][] generateSineDataChunks(long seed, int count,
                int length, int mean, int range, int freq) {
                int[][] chunks = new int[count][];
                Random r = new Random(seed);
                for (int i = 0; i < count; ++i) {
                        int[] chunk = chunks[i] = new int[length];
                        int phase = r.nextInt(2 * freq);
                        for (int j = 0; j < length; ++j) {
                                double angle = 2.0 * Math.PI * (j + phase)
                                        / freq;
                                chunk[j] = (int) (mean + Math.sin(angle)
                                        * range);
                        }
                }
                return chunks;
        }

        private static int[][] generateDataChunks(long seed, int count,
                int length, int mean, int range) {
                int offset = mean - range / 2;
                int[][] chunks = new int[count][];
                Random r = new Random(seed);
                for (int i = 0; i < count; ++i) {
                        int[] chunk = chunks[i] = new int[length];
                        for (int j = 0; j < length; ++j) {
                                chunk[j] = r.nextInt(range) + offset;
                        }
                }
                return chunks;
        }

        private static int[][] deltaDataChunks(int[][] src) {
                int[][] dst = new int[src.length][];
                for (int i = 0; i < src.length; ++i) {
                        int[] s = src[i];
                        int[] d = dst[i] = new int[s.length];
                        int prev = 0;
                        for (int j = 0; j < s.length; ++j) {
                                d[j] = s[j] - prev;
                                prev = s[j];
                        }
                }
                return dst;
        }

        private static int[][] sortDataChunks(int[][] src) {
                int[][] dst = new int[src.length][];
                for (int i = 0; i < src.length; ++i) {
                        dst[i] = Arrays.copyOf(src[i], src[i].length);
                        Arrays.sort(dst[i]);
                }
                return dst;
        }

        /**
         * @param args command-line arguments
         * @throws Exception when some problem occurs
         */
        public static void main(final String[] args) throws Exception {
                File csvFile = new File(
                        String.format(
                                "benchmark-offsetted-%1$tY%1$tm%1$tdT%1$tH%1$tM%1$tS.csv",
                                System.currentTimeMillis()));
                PrintWriter writer = null;
                try {
                        writer = new PrintWriter(csvFile);
                        System.out
                                .println("# Results will be written into a CSV file: "
                                        + csvFile.getName());
                        System.out.println();
                        BenchmarkOffsettedSeries.run(writer, 8 * 1024, 1280);
                        System.out.println();
                        System.out
                                .println("# Results were written into a CSV file: "
                                        + csvFile.getName());
                } finally {
                        if (writer != null) {
                                writer.close();
                        }
                }
        }
}
