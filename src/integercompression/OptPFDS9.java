package integercompression;

/**
 * OptPFD implemented by Daniel Lemire
 * 
 * Follows:
 * 
 * H. Yan, S. Ding, T. Suel, Inverted index compression and query processing
 * with optimized document ordering, in: WWW 09, 2009, pp. 401--410.
 * 
 * using Simple9 as the secondary coder.
 * 
 * @author Daniel Lemire
 * 
 */
public final class OptPFDS9 implements IntegerCODEC {
	final int PageSize;
	final static int BlockSize = 128;
	int[] exceptbuffer = new int[2 * BlockSize];

	public OptPFDS9() {
		PageSize = 65536;
	}

	@Override
	public void compress(int[] in, IntWrapper inpos, int inlength, int[] out,
			IntWrapper outpos) {
		// Util.assertTrue(inpos.get()+inlength <= in.length);
		inlength = inlength / BlockSize * BlockSize;

		final int finalinpos = inpos.get() + inlength;
		out[outpos.get()] = inlength;
		outpos.increment();
		while (inpos.get() != finalinpos) {
			int thissize = finalinpos > PageSize + inpos.get() ? PageSize
					: (finalinpos - inpos.get());
			encodePage(in, inpos, thissize, out, outpos);
		}

	}

	public static final int[] bits = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11,
			12, 13, 16, 20, 32 };
	public static final int[] invbits = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11,
			12, 13, 14, 14, 14, 15, 15, 15, 15, 16, 16, 16, 16, 16, 16, 16, 16,
			16, 16, 16, 16 };

	void getBestBFromData(int[] in, int pos, IntWrapper bestb,
			IntWrapper bestexcept) {
		final int mb = Util.maxbits(in, pos, BlockSize);
		int mini = 0;
		if (mini + 28 < bits[invbits[mb]])
			mini = bits[invbits[mb]] - 28; // 28 is the max for exceptions
		int besti = bits.length - 1;
		int bestcost = bits[besti] * 4;
		int exceptcounter = 0;
		for (int i = mini; i < bits.length - 1; ++i) {
			int tmpcounter = 0;
			final int maxv = 1 << bits[i];
			for (int k = pos; k < BlockSize + pos; ++k)
				if (in[k] >= maxv) {
					++tmpcounter;
				}
			if (tmpcounter == BlockSize)
				continue; // no need
			for (int k = pos, c = 0; k < pos + BlockSize; ++k)
				if (in[k] >= maxv) {
					exceptbuffer[tmpcounter + c] = k - pos;
					exceptbuffer[c] = in[k] >>> bits[i];
					++c;
				}

			final int thiscost = bits[i] * 4
					+ S9.estimatecompress(exceptbuffer, 0, 2 * tmpcounter);
			if (thiscost <= bestcost) {
				bestcost = thiscost;
				besti = i;
				exceptcounter = tmpcounter;
			}
		}
		bestb.set(besti);
		bestexcept.set(exceptcounter);
	}

	private void encodePage(int[] in, IntWrapper inpos, int thissize,
			int[] out, IntWrapper outpos) {
		int tmpoutpos = outpos.get();
		int tmpinpos = inpos.get();
		IntWrapper bestb = new IntWrapper();
		IntWrapper bestexcept = new IntWrapper();
		for (final int finalinpos = tmpinpos + thissize; tmpinpos + BlockSize <= finalinpos; tmpinpos += BlockSize) {
			getBestBFromData(in, tmpinpos, bestb, bestexcept);
			int tmpbestb = bestb.get();
			int nbrexcept = bestexcept.get();
			int exceptsize = 0;
			int remember = tmpoutpos;
			tmpoutpos++;
			if (nbrexcept > 0) {
				final int maxv = 1 << bits[tmpbestb];
				int c = 0;
				for (int i = 0; i < BlockSize; ++i) {
					if (in[tmpinpos + i] >= maxv) {
						exceptbuffer[c + nbrexcept] = i;
						exceptbuffer[c] = in[tmpinpos + i] >>> bits[tmpbestb];
						++c;
					}
				}
				exceptsize = S9.compress(exceptbuffer, 0, 2 * nbrexcept, out,
						tmpoutpos);
				tmpoutpos += exceptsize;
			}
			out[remember] = tmpbestb | (nbrexcept << 8) | (exceptsize << 16);
			for (int k = 0; k < BlockSize; k += 32) {
				BitPacking.fastpack(in, tmpinpos + k, out, tmpoutpos,
						bits[tmpbestb]);
				tmpoutpos += bits[tmpbestb];
			}
		}
		inpos.set(tmpinpos);
		outpos.set(tmpoutpos);
	}

	@Override
	public void uncompress(int[] in, IntWrapper inpos, int inlength, int[] out,
			IntWrapper outpos) {
		// Util.assertTrue(inpos.get()+inlength <= in.length);
		int mynvalue = in[inpos.get()];
		inpos.increment();
		int finalout = outpos.get() + mynvalue;
		while (outpos.get() != finalout) {
			int thissize = finalout > PageSize + outpos.get() ? PageSize
					: (finalout - outpos.get());
			decodePage(in, inpos, out, outpos, thissize);
		}
	}

	private void decodePage(int[] in, IntWrapper inpos, int[] out,
			IntWrapper outpos, int thissize) {
		int tmpoutpos = outpos.get();
		int tmpinpos = inpos.get();

		for (int run = 0; run < thissize / BlockSize; ++run, tmpoutpos += BlockSize) {
			final int b = in[tmpinpos] & 0xFF;
			final int cexcept = (in[tmpinpos] >>> 8) & 0xFF;
			final int exceptsize = (in[tmpinpos] >>> 16);
			++tmpinpos;
			S9.uncompress(in, tmpinpos, exceptsize, exceptbuffer, 0,
					2 * cexcept);
			tmpinpos += exceptsize;
			for (int k = 0; k < BlockSize; k += 32) {
				BitPacking
						.fastunpack(in, tmpinpos, out, tmpoutpos + k, bits[b]);
				tmpinpos += bits[b];
			}
			for (int k = 0; k < cexcept; ++k) {
				out[tmpoutpos + exceptbuffer[k + cexcept]] |= (exceptbuffer[k] << bits[b]);
			}
		}
		outpos.set(tmpoutpos);
		inpos.set(tmpinpos);
	}

	@Override
	public String toString() {
		return this.getClass().getName();
	}

}