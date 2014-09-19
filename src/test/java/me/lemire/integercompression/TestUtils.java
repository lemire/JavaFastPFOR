package me.lemire.integercompression;

import java.util.Arrays;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Static utility methods for test.
 */
public class TestUtils {
    
    /**
     * 
     */
    @Test
    public void testPacking() {
        int[] outputarray = new int[32];
       for(int b = 1; b < 32; ++b) {
           int[] data = new int[32];
           int[] newdata = new int[32];
           int mask = (1<<b) -1;
           for(int j = 0; j < data.length; ++j) {
               data[j] = mask - (j % mask);
           }
           for(int n = 0; n <= 32; ++n) {
               Arrays.fill(outputarray, 0);
               int howmany = Util.pack(outputarray, 0, data,0, n, b);
               if(howmany != Util.packsize(n, b)) throw new RuntimeException("bug "+n+" "+b);
               Util.unpack(Arrays.copyOf(outputarray, howmany), 0, newdata,0, n, b);
               for(int i = 0; i < n; ++i)
                   if(newdata[i] != data[i]) {
                       System.out.println(Arrays.toString(Arrays.copyOf(data, n)));
                       System.out.println(Arrays.toString(Arrays.copyOf(newdata,n)));
                       throw new RuntimeException("bug "+b+" "+n);
                   }
           }
       }
    }
    /**
     * 
     */
    @Test
    public void testPackingw() {
        int[] outputarray = new int[32];
       for(int b = 1; b < 32; ++b) {
           int[] data = new int[32];
           int[] newdata = new int[32];
           int mask = (1<<b) -1;
           for(int j = 0; j < data.length; ++j) {
               data[j] = mask - (j % mask);
           }
           for(int n = 0; n <= 32; ++n) {
               Arrays.fill(outputarray, 0);
               int howmany = Util.packw(outputarray, 0, data, n, b);
               if(howmany != Util.packsizew(n, b)) throw new RuntimeException("bug "+n+" "+b);
               Util.unpackw(Arrays.copyOf(outputarray, howmany), 0, newdata, n, b);
               for(int i = 0; i < n; ++i)
                   if(newdata[i] != data[i]) {
                       System.out.println(Arrays.toString(Arrays.copyOf(data, n)));
                       System.out.println(Arrays.toString(Arrays.copyOf(newdata,n)));
                       throw new RuntimeException("bug "+b+" "+n);
                   }
           }
       }
    }

    protected static void dumpIntArray(int[] data, String label) {
        System.out.print(label);
        for (int i = 0; i < data.length; ++i) {
            if (i % 6 == 0) {
                System.out.println();
            }
            System.out.format(" %1$11d", data[i]);
        }
        System.out.println();
    }

    protected static void dumpIntArrayAsHex(int[] data, String label) {
        System.out.print(label);
        for (int i = 0; i < data.length; ++i) {
            if (i % 8 == 0) {
                System.out.println();
            }
            System.out.format(" %1$08X", data[i]);
        }
        System.out.println();
    }

    /**
     * Check that compress and uncompress keep original array.
     *
     * @param codec CODEC to test.
     * @param orig  original integers
     */
    public static void assertSymmetry(IntegerCODEC codec, int... orig) {
        // There are some cases that compressed array is bigger than original
        // array.  So output array for compress must be larger.
        //
        // Example:
        //  - VariableByte compresses an array like [ -1 ].
        //  - Composition compresses a short array.
        final int EXTEND = 1;

        int[] compressed = new int[orig.length + EXTEND];
        IntWrapper c_inpos = new IntWrapper(0);
        IntWrapper c_outpos = new IntWrapper(0);
        codec.compress(orig, c_inpos, orig.length, compressed,
                c_outpos);

        assertTrue(c_outpos.get() <= orig.length + EXTEND);

        // Uncompress an array.
        int[] uncompressed = new int[orig.length];
        IntWrapper u_inpos = new IntWrapper(0);
        IntWrapper u_outpos = new IntWrapper(0);
        codec.uncompress(compressed, u_inpos, c_outpos.get(),
                uncompressed, u_outpos);

        // Compare between uncompressed and orig arrays.
        int[] target = Arrays.copyOf(uncompressed, u_outpos.get());
        assertArrayEquals(orig, target);
    }

    protected static int[] compress(IntegerCODEC codec, int[] data) {
        int[] outBuf = new int[data.length * 4];
        IntWrapper inPos = new IntWrapper();
        IntWrapper outPos = new IntWrapper();
        codec.compress(data, inPos, data.length, outBuf, outPos);
        return Arrays.copyOf(outBuf, outPos.get());
    }

    protected static int[] uncompress(IntegerCODEC codec, int[] data, int len) {
        int[] outBuf = new int[len + 1024];
        IntWrapper inPos = new IntWrapper();
        IntWrapper outPos = new IntWrapper();
        codec.uncompress(data, inPos, data.length, outBuf, outPos);
        return Arrays.copyOf(outBuf, outPos.get());
    }



    protected static byte[] compress(ByteIntegerCODEC codec, int[] data) {
        byte[] outBuf = new byte[data.length * 4 * 4];
        IntWrapper inPos = new IntWrapper();
        IntWrapper outPos = new IntWrapper();
        codec.compress(data, inPos, data.length, outBuf, outPos);
        return Arrays.copyOf(outBuf, outPos.get());
    }

    protected static int[] uncompress(ByteIntegerCODEC codec, byte[] data, int len) {
        int[] outBuf = new int[len + 1024];
        IntWrapper inPos = new IntWrapper();
        IntWrapper outPos = new IntWrapper();
        codec.uncompress(data, inPos, data.length, outBuf, outPos);
        return Arrays.copyOf(outBuf, outPos.get());
    }

    protected static int[] compressHeadless(SkippableIntegerCODEC codec, int[] data) {
        int[] outBuf = new int[data.length * 4];
        IntWrapper inPos = new IntWrapper();
        IntWrapper outPos = new IntWrapper();
        codec.headlessCompress(data, inPos, data.length, outBuf, outPos);
        return Arrays.copyOf(outBuf, outPos.get());
    }

    protected static int[] uncompressHeadless(SkippableIntegerCODEC codec, int[] data, int len) {
        int[] outBuf = new int[len + 1024];
        IntWrapper inPos = new IntWrapper();
        IntWrapper outPos = new IntWrapper();
        codec.headlessUncompress(data, inPos, data.length, outBuf, outPos,len);
        if(outPos.get() < len) throw new RuntimeException("Insufficient output.");
        return Arrays.copyOf(outBuf, outPos.get());
    }

}
