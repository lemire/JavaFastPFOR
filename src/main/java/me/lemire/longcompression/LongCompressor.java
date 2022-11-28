package me.lemire.longcompression;

import java.util.Arrays;

import me.lemire.integercompression.IntWrapper;
import me.lemire.integercompression.UncompressibleInputException;

/**
 * This is a convenience class that wraps a codec to provide
 * a "friendly" API.
 *
 * @author Benoit Lacelle
 */
public class LongCompressor {


    SkippableLongCODEC codec;
    /**
     * Constructor wrapping a codec.
     * 
     * @param c the underlying codec
     */
    public LongCompressor(SkippableLongCODEC c) {
      codec = c;
    }
    
    /**
     * Constructor with default codec.
     */
    public LongCompressor() {
        codec = new SkippableLongComposition(new LongBinaryPacking(),
                new LongVariableByte());
    }

    /**
     * Compress an array and returns the compressed result as a new array.
     * 
     * @param input array to be compressed
     * @return compressed array
     * @throws UncompressibleInputException if the data is too poorly compressible
     */
    public  long[] compress(long[] input) {
    	long[] compressed = new long[input.length + input.length / 100 + 1024];
        // Store at index=0 the length of the input, hence enabling .headlessCompress
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
    public long[] uncompress(long[] compressed) {
        // Read at index=0 the length of the input, hence enabling .headlessUncompress
    	long[] decompressed = new long[(int) compressed[0]];
        IntWrapper inpos = new IntWrapper(1);
        codec.headlessUncompress(compressed, inpos, 
                compressed.length - inpos.intValue(), 
                decompressed, new IntWrapper(0), 
                decompressed.length);
        return decompressed;
    }

}
