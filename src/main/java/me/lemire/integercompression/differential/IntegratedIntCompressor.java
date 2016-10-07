package me.lemire.integercompression.differential;

import java.util.Arrays;

import me.lemire.integercompression.IntWrapper;
import me.lemire.integercompression.UncompressibleInputException;

/**
 * This is a convenience class that wraps a codec to provide
 * a "friendly" API. It is useful to compress sorted integers.
 * If your integers are not sorted (not even nearly so), please
 * consider the IntCompressor class instead.
 *
 */
public class IntegratedIntCompressor {
    SkippableIntegratedIntegerCODEC codec;
    /**
     * Constructor wrapping a codec.
     * 
     * @param c the underlying codec
     */
    public IntegratedIntCompressor(SkippableIntegratedIntegerCODEC c) {
      codec = c;
    }
    
    /**
     * Constructor with default codec.
     */
    public IntegratedIntCompressor() {
        codec = new SkippableIntegratedComposition(new IntegratedBinaryPacking(),
                new IntegratedVariableByte());
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
        IntWrapper initvalue = new IntWrapper(0);
		try {
			codec.headlessCompress(input, new IntWrapper(0), input.length, compressed, outpos, initvalue);
		} catch (IndexOutOfBoundsException ioebe) {
			throw new UncompressibleInputException(
					"Your input is too poorly compressible with the current codec : " + codec);
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
                decompressed.length, new IntWrapper(0));
        return decompressed;
    }

}
