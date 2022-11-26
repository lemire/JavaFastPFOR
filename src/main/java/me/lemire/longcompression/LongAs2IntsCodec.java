package me.lemire.longcompression;

import java.util.Arrays;

import me.lemire.integercompression.BinaryPacking;
import me.lemire.integercompression.Composition;
import me.lemire.integercompression.IntCompressor;
import me.lemire.integercompression.IntWrapper;
import me.lemire.integercompression.IntegerCODEC;
import me.lemire.integercompression.VariableByte;

/**
 * A {@link LongCODEC} which split each long in a highpart (32 first bits) and a low part (32 last bits).
 * 
 * @author Benoit Lacelle
 *
 */
public class LongAs2IntsCodec implements LongCODEC {
	final IntegerCODEC highPartsCodec;
	final IntegerCODEC lowPartsCodec;

	public LongAs2IntsCodec(IntegerCODEC highPartsCodec, IntegerCODEC lowPartsCodec) {
		this.highPartsCodec = highPartsCodec;
		this.lowPartsCodec = lowPartsCodec;
	}

	/**
	 * By default, we expect longs to be slightly above Integer.MAX_VALUE. Hence highParts to be small and positive
	 * integers. For lowParts, we rely on {@link IntCompressor} default IntegerCODEC
	 */
	public LongAs2IntsCodec() {
		this(new VariableByte(), new Composition(new BinaryPacking(), new VariableByte()));
	}

	@Override
	public void compress(long[] in, IntWrapper inpos, int inlength, long[] out, IntWrapper outpos) {
		if (inlength == 0) {
			return;
		}
		
		int[] highParts = new int[inlength];
		int[] lowParts = new int[inlength];

		for (int i = 0; i < inlength; i++) {
			int inPosition = inpos.get() + i;

			highParts[i] = RoaringIntPacking.high(in[inPosition]);
			lowParts[i] = RoaringIntPacking.low(in[inPosition]);
		}

		// TODO What would be a relevant buffer size?
		int[] buffer = new int[inlength * 16];

		int outPosition = outpos.get();

		boolean hasLeftover;
		{
			// The first integer is reserved to hold the number of compressed ints
			IntWrapper highPartsOutPosition = new IntWrapper(1);

			highPartsCodec.compress(highParts, new IntWrapper(), inlength, buffer, highPartsOutPosition);

			// Record the compressedHighparts length
			buffer[0] = highPartsOutPosition.get() - 1;

			for (int i = 0; i < highPartsOutPosition.get() / 2; i++) {
				long pack = RoaringIntPacking.pack(buffer[i * 2], buffer[i * 2 + 1]);
				out[outPosition++] = pack;
			}

			if (1 == highPartsOutPosition.get() % 2) {
				// Shift the trailing integer as first in the buffer
				hasLeftover = true;
				buffer[0] = buffer[highPartsOutPosition.get() - 1];
			} else {
				hasLeftover = false;
			}
		}

		{
			// The first integer is reserved to hold the number of compressed ints
			IntWrapper lowPartsOutPosition = new IntWrapper(1);
			if (hasLeftover) {
				// Keep the trailing int from highParts before the reserved int from lowParts compressed length
				lowPartsOutPosition.set(2);
			}

			lowPartsCodec.compress(lowParts, new IntWrapper(0), inlength, buffer, lowPartsOutPosition);

			// Record the compressedHighparts length
			buffer[hasLeftover ? 1 : 0] = lowPartsOutPosition.get() - (hasLeftover ? 2 : 1);

			for (int i = 0; i < lowPartsOutPosition.get() / 2; i++) {
				long pack = RoaringIntPacking.pack(buffer[i * 2], buffer[i * 2 + 1]);
				out[outPosition++] = pack;
			}

			if (1 == lowPartsOutPosition.get() % 2) {
				// The trailing integer is packed with a 0
				long pack = RoaringIntPacking.pack(buffer[lowPartsOutPosition.get() - 1], 0);
				out[outPosition++] = pack;
			}
		}

		inpos.add(inlength);
		outpos.set(outPosition);
	}

	/**
	 * inlength is ignored by this codec. We may rely on it instead of storing the compressedLowPart length
	 */
	@Override
	public void uncompress(long[] in, IntWrapper inpos, int inlength, long[] out, IntWrapper outpos) {
		if (inlength == 0) {
			return;
		}

		int longIndex = inpos.get();

		int nbCompressedHighParts = RoaringIntPacking.high(in[longIndex]);
		int[] compressedHighParts = new int[nbCompressedHighParts];

		// !highPart as we just read the highPart for nbCompressedHighParts
		boolean highPart = false;
		for (int i = 0; i < nbCompressedHighParts; i++) {
			int nextInt;
			if (highPart) {
				nextInt = RoaringIntPacking.high(in[longIndex + (i + 1) / 2]);
			} else {
				nextInt = RoaringIntPacking.low(in[longIndex + (i + 1) / 2]);
			}
			compressedHighParts[i] = nextInt;

			highPart = !highPart;
		}

		// TODO What would be a relevant buffer size?
		int[] buffer = new int[inlength * 16];

		IntWrapper highPartsOutPosition = new IntWrapper();
		highPartsCodec.uncompress(compressedHighParts,
				new IntWrapper(),
				compressedHighParts.length,
				buffer,
				highPartsOutPosition);
		int[] highParts = Arrays.copyOf(buffer, highPartsOutPosition.get());

		// +1 as we initially read nbCompressedHighParts
		int intIndexNbCompressedLowParts = longIndex * 2 + 1 + nbCompressedHighParts;
		int nbCompressedLowParts;
		if (highPart) {
			nbCompressedLowParts = RoaringIntPacking.high(in[intIndexNbCompressedLowParts / 2]);
		} else {
			nbCompressedLowParts = RoaringIntPacking.low(in[intIndexNbCompressedLowParts / 2]);
		}
		highPart = !highPart;

		int[] compressedLowParts = new int[nbCompressedLowParts];
		for (int i = 0; i < nbCompressedLowParts; i++) {
			int nextInt;
			if (highPart) {
				nextInt = RoaringIntPacking.high(in[(intIndexNbCompressedLowParts + 1 + i) / 2]);
			} else {
				nextInt = RoaringIntPacking.low(in[(intIndexNbCompressedLowParts + 1 + i) / 2]);
			}
			compressedLowParts[i] = nextInt;

			highPart = !highPart;
		}

		IntWrapper lowPartsOutPosition = new IntWrapper();
		lowPartsCodec.uncompress(compressedLowParts,
				new IntWrapper(),
				compressedLowParts.length,
				buffer,
				lowPartsOutPosition);
		int[] lowParts = Arrays.copyOf(buffer, lowPartsOutPosition.get());
		assert highParts.length == lowParts.length;

		int outposition = outpos.get();
		for (int i = 0; i < highParts.length; i++) {
			out[outposition++] = RoaringIntPacking.pack(highParts[i], lowParts[i]);
		}

		inpos.add(inlength);
		outpos.set(outposition);
	}

}
