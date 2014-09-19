/**
 * This code is released under the
 * Apache License Version 2.0 http://www.apache.org/licenses/.
 *
 * (c) Daniel Lemire, http://lemire.me/en/
 */
package me.lemire.integercompression.benchmarktools;

import me.lemire.integercompression.BinaryPacking;
import me.lemire.integercompression.FastPFOR;
import me.lemire.integercompression.FastPFOR128;
import me.lemire.integercompression.IntWrapper;
import me.lemire.integercompression.JustCopy;
import me.lemire.integercompression.NewPFD;
import me.lemire.integercompression.NewPFDS16;
import me.lemire.integercompression.NewPFDS9;
import me.lemire.integercompression.OptPFD;
import me.lemire.integercompression.OptPFDS16;
import me.lemire.integercompression.OptPFDS9;
import me.lemire.integercompression.Simple16;
import me.lemire.integercompression.Simple9;
import me.lemire.integercompression.SkippableComposition;
import me.lemire.integercompression.SkippableIntegerCODEC;
import me.lemire.integercompression.VariableByte;
import me.lemire.integercompression.differential.Delta;
import me.lemire.integercompression.differential.IntegratedBinaryPacking;
import me.lemire.integercompression.differential.IntegratedVariableByte;
import me.lemire.integercompression.differential.SkippableIntegratedComposition;
import me.lemire.integercompression.differential.SkippableIntegratedIntegerCODEC;
import me.lemire.integercompression.synth.ClusteredDataGenerator;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Arrays;

/**
 * 
 * Simple class meant to compare the speed of different schemes.
 * 
 * @author Daniel Lemire
 * 
 */
public class BenchmarkSkippable {

    private static int compressWithSkipTable(Object c, int[] data,
            int[] output, IntWrapper outpos, int[] metadata, int blocksize) {
        int metapos = 0;
        metadata[metapos++] = data.length;
        IntWrapper inpos = new IntWrapper();
        int initvalue = 0;
        IntWrapper ival = new IntWrapper(initvalue);
        while (inpos.get() < data.length) {
            metadata[metapos++] = outpos.get();
            metadata[metapos++] = initvalue;
            if (c instanceof SkippableIntegerCODEC) {
                int size = blocksize > data.length - inpos.get() ? data.length
                        - inpos.get() : blocksize;
                initvalue = Delta.delta(data, inpos.get(), size, initvalue);

                ((SkippableIntegerCODEC) c).headlessCompress(data, inpos,
                        blocksize, output, outpos);
            } else if (c instanceof SkippableIntegratedIntegerCODEC) {
                ival.set(initvalue);
                ((SkippableIntegratedIntegerCODEC) c).headlessCompress(data,
                        inpos, blocksize, output, outpos, ival);
                initvalue = ival.get();
            } else {
                throw new RuntimeException("Unrecognized codec " + c);
            }
        }
        return metapos;
    }

    private static int decompressFromSkipTable(Object c, int[] compressed,
            IntWrapper compressedpos, int[] metadata, int blocksize, int[] data) {
        int metapos = 0;
        int length = metadata[metapos++];
        IntWrapper uncomppos = new IntWrapper();
        IntWrapper ival = new IntWrapper();
        while (uncomppos.get() < length) {
            int num = blocksize;
            if (num > length - uncomppos.get())
                num = length - uncomppos.get();
            int location = metadata[metapos++];
            // System.out.println("location = "+location);
            int initvalue = metadata[metapos++];
            int outputlocation = uncomppos.get();
            if (location != compressedpos.get())
                throw new RuntimeException("Bug " + location + " "
                        + compressedpos.get() + " codec " + c);
            if (c instanceof SkippableIntegerCODEC) {
                ((SkippableIntegerCODEC) c).headlessUncompress(compressed,
                        compressedpos, compressed.length - uncomppos.get(),
                        data, uncomppos, num);
                initvalue = Delta.fastinverseDelta(data, outputlocation, num,
                        initvalue);
            } else if (c instanceof SkippableIntegratedIntegerCODEC) {
                ival.set(initvalue);
                ((SkippableIntegratedIntegerCODEC) c).headlessUncompress(
                        compressed, compressedpos, compressed.length
                                - uncomppos.get(), data, uncomppos, num, ival);
            } else {
                throw new RuntimeException("Unrecognized codec " + c);
            }
        }
        return length;
    }

    /**
     * Standard benchmark
     * 
     * @param csvLog
     *            Writer for CSV log.
     * @param c
     *            the codec
     * @param data
     *            arrays of input data
     * @param repeat
     *            How many times to repeat the test
     * @param verbose
     *            whether to output result on screen
     */
    private static void testCodec(PrintWriter csvLog, int sparsity, Object c,
            int[][] data, int repeat, boolean verbose) {
        if (verbose) {
            System.out.println("# " + c.toString());
            System.out
                    .println("# bits per int, compress speed (mis), decompression speed (mis) ");
        }

        int N = data.length;

        int totalSize = 0;
        int maxLength = 0;
        for (int k = 0; k < N; ++k) {
            totalSize += data[k].length;
            if (data[k].length > maxLength) {
                maxLength = data[k].length;
            }
        }

        // 4x + 1024 to account for the possibility of some negative
        // compression.
        int[] compressBuffer = new int[4 * maxLength + 1024];
        int[] decompressBuffer = new int[maxLength + 1024];
        int[] metadataBuffer = new int[maxLength];
        final int blocksize = 1024;

        // These variables hold time in microseconds (10^-6).
        double compressTime = 0;
        double decompressTime = 0;
        final int times = 5;

        int size = 0;

        for (int r = 0; r < repeat; ++r) {
            size = 0;
            for (int k = 0; k < N; ++k) {
                int[] backupdata = Arrays.copyOf(data[k], data[k].length);

                // compress data.
                long beforeCompress = System.nanoTime() / 1000;
                IntWrapper outpos = new IntWrapper();
                compressWithSkipTable(c, backupdata, compressBuffer, outpos,
                        metadataBuffer, blocksize);
                long afterCompress = System.nanoTime() / 1000;

                // measure time of compression.
                compressTime += afterCompress - beforeCompress;
                final int thiscompsize = outpos.get();
                size += thiscompsize;
                // dry run
                int volume = 0;
                {
                    IntWrapper compressedpos = new IntWrapper(0);
                    volume = decompressFromSkipTable(c, compressBuffer,
                            compressedpos, metadataBuffer, blocksize,
                            decompressBuffer);

                    // let us check the answer
                    if (volume != backupdata.length)
                        throw new RuntimeException(
                                "Bad output size with codec " + c);
                    for (int j = 0; j < volume; ++j) {
                        if (data[k][j] != decompressBuffer[j])
                            throw new RuntimeException("bug in codec " + c);
                    }
                }
                // extract (uncompress) data
                long beforeDecompress = System.nanoTime() / 1000;
                for (int t = 0; t < times; ++t) {
                    IntWrapper compressedpos = new IntWrapper(0);
                    volume = decompressFromSkipTable(c, compressBuffer,
                            compressedpos, metadataBuffer, blocksize,
                            decompressBuffer);
                }
                long afterDecompress = System.nanoTime() / 1000;

                // measure time of extraction (uncompression).
                decompressTime += (afterDecompress - beforeDecompress) / times;
                if (volume != data[k].length)
                    throw new RuntimeException("we have a bug (diff length) "
                            + c + " expected " + data[k].length + " got "
                            + volume);

                // verify: compare original array with
                // compressed and
                // uncompressed.
               for (int m = 0; m < outpos.get(); ++m) {
                    if (decompressBuffer[m] != data[k][m]) {
                        throw new RuntimeException(
                                "we have a bug (actual difference), expected "
                                        + data[k][m] + " found "
                                        + decompressBuffer[m] + " at " + m);
                    }
                }
            }
        }

        if (verbose) {
            double bitsPerInt = size * 32.0 / totalSize;
            long compressSpeed = Math
                    .round(totalSize * repeat / (compressTime));
            long decompressSpeed = Math.round(totalSize * repeat
                    / (decompressTime));
            System.out.println(String.format("\t%1$.2f\t%2$d\t%3$d",
                    bitsPerInt, compressSpeed, decompressSpeed));
            csvLog.format("\"%1$s\",%2$d,%3$.2f,%4$d,%5$d\n", c.toString(),
                    sparsity, bitsPerInt, compressSpeed, decompressSpeed);
            csvLog.flush();
        }
    }

    /**
     * Main method.
     * 
     * @param args
     *            command-line arguments
     * @throws FileNotFoundException
     *             when we fail to create a new file
     */
    public static void main(String args[]) throws FileNotFoundException {
        System.out.println("# benchmark based on the ClusterData model from:");
        System.out.println("# 	 Vo Ngoc Anh and Alistair Moffat. ");
        System.out.println("#	 Index compression using 64-bit words.");
        System.out
                .println("# 	 Softw. Pract. Exper.40, 2 (February 2010), 131-147. ");
        System.out.println();

        PrintWriter writer = null;
        try {
            File csvFile = new File(String.format(
                    "benchmark-%1$tY%1$tm%1$tdT%1$tH%1$tM%1$tS.csv",
                    System.currentTimeMillis()));
            writer = new PrintWriter(csvFile);
            System.out.println("# Results will be written into a CSV file: "
                    + csvFile.getName());
            System.out.println();
            test(writer, 20, 18, 10);
            System.out.println();
            System.out.println("Results were written into a CSV file: "
                    + csvFile.getName());
        } finally {
            if (writer != null) {
                writer.close();
            }
        }
    }

    /**
     * Generate test data.
     * 
     * @param N
     *            How many input arrays to generate
     * @param nbr
     *            How big (in log2) should the arrays be
     * @param sparsity
     *            How sparse test data generated
     */
    private static int[][] generateTestData(ClusteredDataGenerator dataGen,
            int N, int nbr, int sparsity) {
        final int[][] data = new int[N][];
        final int dataSize = (1 << (nbr + sparsity));
        for (int i = 0; i < N; ++i) {
            data[i] = dataGen.generateClustered((1 << nbr), dataSize);
        }
        return data;
    }

    static Object[] codecs = {
        
            new SkippableIntegratedComposition(new IntegratedBinaryPacking(),
                    new IntegratedVariableByte()), new JustCopy(), new VariableByte(),

            new SkippableComposition(new BinaryPacking(), new VariableByte()),
            new SkippableComposition(new NewPFD(), new VariableByte()),
            new SkippableComposition(new NewPFDS9(), new VariableByte()),
            new SkippableComposition(new NewPFDS16(), new VariableByte()),
            new SkippableComposition(new OptPFD(), new VariableByte()),
            new SkippableComposition(new OptPFDS9(), new VariableByte()),
            new SkippableComposition(new OptPFDS16(), new VariableByte()),
            new SkippableComposition(new FastPFOR(), new VariableByte()),
            new SkippableComposition(new FastPFOR128(), new VariableByte()),
            new Simple9(), new Simple16() };

    /**
     * Generates data and calls other tests.
     * 
     * @param csvLog
     *            Writer for CSV log.
     * @param N
     *            How many input arrays to generate
     * @param nbr
     *            how big (in log2) should the arrays be
     * @param repeat
     *            How many times should we repeat tests.
     */
    private static void test(PrintWriter csvLog, int N, int nbr, int repeat) {
        csvLog.format("\"Algorithm\",\"Sparsity\",\"Bits per int\",\"Compress speed (MiS)\",\"Decompress speed (MiS)\"\n");
        ClusteredDataGenerator cdg = new ClusteredDataGenerator();
        final int max_sparsity = 31 - nbr;

        for (int sparsity = 1; sparsity < max_sparsity; sparsity+=4) {
            System.out.println("# sparsity " + sparsity);
            System.out.println("# generating random data...");
            int[][] data = generateTestData(cdg, N, nbr, sparsity);
            System.out.println("# generating random data... ok.");
            for (Object c : codecs) {
                testCodec(csvLog, sparsity, c, data, repeat, false);
                testCodec(csvLog, sparsity, c, data, repeat, false);
                testCodec(csvLog, sparsity, c, data, repeat, true);
                testCodec(csvLog, sparsity, c, data, repeat, true);
                testCodec(csvLog, sparsity, c, data, repeat, true);

            }

        }
    }
}
