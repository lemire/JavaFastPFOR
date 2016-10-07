package me.lemire.integercompression;

import java.util.Arrays;

/**
 * This is a convenience class that wraps a codec to provide
 * a "friendly" API.
 *
 */
public class IntCompressor {


    SkippableIntegerCODEC codec;
    /**
     * Constructor wrapping a codec.
     * 
     * @param c the underlying codec
     */
    public IntCompressor(SkippableIntegerCODEC c) {
      codec = c;
    }
    
    /**
     * Constructor with default codec.
     */
    public IntCompressor() {
        codec = new SkippableComposition(new BinaryPacking(),
                new VariableByte());
    }

    /**
     * Compress an array and returns the compressed result as a new array.
     * 
     * @param input array to be compressed
     * @return compressed array
     * @throws UncompressibleInputException if the data is too poorly compressible
     */
    public  int[] compress(int[] input) {
        int [] compressed = new int[input.length + input.length / 100 + 1024];
        compressed[0] = input.length;
        IntWrapper outpos = new IntWrapper(1);
        try {
            codec.headlessCompress(input, new IntWrapper(0),
                    input.length, compressed, outpos);
        } catch (IndexOutOfBoundsException ioebe) {
            throw new
            UncompressibleInputException("Your input is too poorly compressible "
                    + "with the current codec : "+codec);
        }
        compressed = Arrays.copyOf(compressed,outpos.intValue());
        return compressed;
    }

    /**
     * Uncompress an array and returns the uncompressed result as a new array.
     * 
     * @param compressed compressed array
     * @return uncompressed array
     */
    public int[] uncompress(int[] compressed) {
        int[] decompressed = new int[compressed[0]];
        IntWrapper inpos = new IntWrapper(1);
        codec.headlessUncompress(compressed, inpos, 
                compressed.length - inpos.intValue(), 
                decompressed, new IntWrapper(0), 
                decompressed.length);
        return decompressed;
    }

}
