package me.lemire.integercompression.benchmarktools;

import me.lemire.integercompression.*;
import java.io.*;
import java.util.Arrays;

/**
 * This will run benchmarks using a set of posting lists stored as CSV files.
 * 
 * @author lemire
 * 
 */
public class BenchmarkCSV {
        static IntegratedIntegerCODEC codecs[] = {
                new IntegratedComposition(new IntegratedFastPFOR(),
                        new IntegratedVariableByte()),
                new IntegratedComposition(new IntegratedBinaryPacking(),
                        new IntegratedVariableByte()),
                new IntegratedVariableByte() };
        static IntegratedByteIntegerCODEC bcodecs[]= {
                new IntegratedVariableByte()
        };
        public static int[] loadIntegers(String filename) throws IOException {
                BufferedReader br = new BufferedReader(new FileReader(filename));
                String s = br.readLine();
                String[] numbers = s.split("[,;;]");
                int[] answer = new int[numbers.length];
                for (int k = 0; k < numbers.length; ++k) {
                        answer[k] = Integer.parseInt(numbers[k].trim());
                }
                return answer;
        }

        public static void main(String[] args) throws IOException {
                int[][] data = new int[args.length][];
                for (int k = 0; k < args.length; ++k)
                        data[k] = loadIntegers(args[k]);
                System.out.println("Loaded " + data.length + " arrays");
                bench(data, false);
                bench(data, false);
                bench(data, true);
                bytebench(data, false);
                bytebench(data, false);
                bytebench(data, true);
        }

        public static void bench(int[][] postings, boolean verbose) {
                int maxlength = 0;
                for (int[] x : postings)
                        if (maxlength < x.length)
                                maxlength = x.length;
                if (verbose) System.out.println("Max array length: " + maxlength);
                int[] compbuffer = new int[maxlength + 1024];
                int[] decompbuffer = new int[maxlength];
                if(verbose)
                        System.out.println("Scheme -- bits/int -- speed (mis)");
                for (IntegratedIntegerCODEC c : codecs) {
                        long bef = 0;
                        long aft = 0;
                        long decomptime = 0;
                        long volumein = 0;
                        long volumeout = 0;
                        int[][] compdata = new int[postings.length][];
                        for (int k = 0; k < postings.length; ++k) {
                                int[] in = postings[k];
                                IntWrapper inpos = new IntWrapper(0);
                                IntWrapper outpos = new IntWrapper(0);
                                c.compress(in, inpos, in.length, compbuffer,
                                        outpos);
                                int clength = outpos.get();
                                inpos = new IntWrapper(0);
                                outpos = new IntWrapper(0);
                                c.uncompress(compbuffer, inpos, clength,
                                        decompbuffer, outpos);
                                volumein += in.length;
                                volumeout += clength;

                                if (outpos.get() != in.length)
                                        throw new RuntimeException("bug");
                                for (int z = 0; z < in.length; ++z)
                                        if (in[z] != decompbuffer[z])
                                                throw new RuntimeException(
                                                        "bug");
                                compdata[k] = Arrays
                                        .copyOf(compbuffer, clength);
                        }
                        bef = System.nanoTime();
                        for (int[] cin : compdata) {
                                IntWrapper inpos = new IntWrapper(0);
                                IntWrapper outpos = new IntWrapper(0);
                                c.uncompress(cin, inpos, cin.length,
                                        decompbuffer, outpos);
                                if (inpos.get() != cin.length)
                                        throw new RuntimeException("bug");
                        }
                        aft = System.nanoTime();
                        decomptime += (aft - bef);
                        double bitsPerInt = volumeout * 32.0 / volumein;
                        double decompressSpeed = volumein * 1000.0
                                / (decomptime);
                        if (verbose)
                                System.out.println(c.toString()
                                        + "\t"
                                        + String.format("\t%1$.2f\t%2$.2f",
                                                bitsPerInt, decompressSpeed));

                }
        }

        public static void bytebench(int[][] postings, boolean verbose) {
                int maxlength = 0;
                for (int[] x : postings)
                        if (maxlength < x.length)
                                maxlength = x.length;
                if (verbose) System.out.println("Max array length: " + maxlength);
                byte[] compbuffer = new byte[4*(maxlength + 1024)];
                int[] decompbuffer = new int[maxlength];
                if(verbose)
                        System.out.println("Scheme -- bits/int -- speed (mis)");
                for (IntegratedByteIntegerCODEC c : bcodecs) {
                        long bef = 0;
                        long aft = 0;
                        long decomptime = 0;
                        long volumein = 0;
                        long volumeout = 0;
                        byte[][] compdata = new byte[postings.length][];
                        for (int k = 0; k < postings.length; ++k) {
                                int[] in = postings[k];
                                IntWrapper inpos = new IntWrapper(0);
                                IntWrapper outpos = new IntWrapper(0);
                                c.compress(in, inpos, in.length, compbuffer,
                                        outpos);
                                int clength = outpos.get();
                                inpos = new IntWrapper(0);
                                outpos = new IntWrapper(0);
                                c.uncompress(compbuffer, inpos, clength,
                                        decompbuffer, outpos);
                                volumein += in.length;
                                volumeout += clength;

                                if (outpos.get() != in.length)
                                        throw new RuntimeException("bug");
                                for (int z = 0; z < in.length; ++z)
                                        if (in[z] != decompbuffer[z])
                                                throw new RuntimeException(
                                                        "bug");
                                compdata[k] = Arrays
                                        .copyOf(compbuffer, clength);
                        }
                        bef = System.nanoTime();
                        for (byte[] cin : compdata) {
                                IntWrapper inpos = new IntWrapper(0);
                                IntWrapper outpos = new IntWrapper(0);
                                c.uncompress(cin, inpos, cin.length,
                                        decompbuffer, outpos);
                                if (inpos.get() != cin.length)
                                        throw new RuntimeException("bug");
                        }
                        aft = System.nanoTime();
                        decomptime += (aft - bef);
                        double bitsPerInt = volumeout * 32.0 / volumein;
                        double decompressSpeed = volumein * 1000.0
                                / (decomptime);
                        if (verbose)
                                System.out.println(c.toString()
                                        + "\t"
                                        + String.format("\t%1$.2f\t%2$.2f",
                                                bitsPerInt, decompressSpeed));

                }
        }

}
