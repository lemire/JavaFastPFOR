/**
 * This code is released under the
 * Apache License Version 2.0 http://www.apache.org/licenses/.
 *
 * (c) Daniel Lemire, http://lemire.me/en/
 */
package me.lemire.integercompression;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.IntBuffer;

/**
 * Implementation of variable-byte. For best performance, use it using the
 * ByteIntegerCODEC interface.
 * 
 * Note that this does not use differential coding: if you are working on sorted
 * lists, you must compute the deltas separately.
 * 
 * @author Daniel Lemire
 */
public class VariableByte implements IntegerCODEC, ByteIntegerCODEC {

	private byte extract7bits(int i, long val) {
		return (byte)((val >> (7 * i)) & ((1 << 7) - 1));
	}

	private byte extract7bitsmaskless(int i, long val) {
		return (byte)((val >> (7 * i)));
	}

	@Override
	public void compress(int[] in, IntWrapper inpos, int inlength,
			int[] out, IntWrapper outpos) {
		if (inlength == 0)
			return;
		ByteBuffer buf = ByteBuffer.allocateDirect(inlength * 8);
		for (int k = inpos.get(); k < inpos.get() + inlength; ++k) {
			long val = in[k] & 0xFFFFFFFFL;
			if (val < (1 << 7)) {
				buf.put((byte)(val | (1 << 7)));
			} else if (val < (1 << 14)) {
				buf.put((byte)extract7bits(0, val));
				buf.put((byte)(extract7bitsmaskless(1, (val)) | (1 << 7)));
			} else if (val < (1 << 21)) {
				buf.put((byte)extract7bits(0, val));
				buf.put((byte)extract7bits(1, val));
				buf.put((byte)(extract7bitsmaskless(2, (val)) | (1 << 7)));
			} else if (val < (1 << 28)) {
				buf.put((byte)extract7bits(0, val));
				buf.put((byte)extract7bits(1, val));
				buf.put((byte)extract7bits(2, val));
				buf.put((byte)(extract7bitsmaskless(3, (val)) | (1 << 7)));
			} else {
				buf.put((byte)extract7bits(0, val));
				buf.put((byte)extract7bits(1, val));
				buf.put((byte)extract7bits(2, val));
				buf.put((byte)extract7bits(3, val));
				buf.put((byte)(extract7bitsmaskless(4, (val)) | (1 << 7)));
			}
		}
		while (buf.position() % 4 != 0)
			buf.put((byte) 0);
		final int length = buf.position();
		buf.flip();
		IntBuffer ibuf = buf.asIntBuffer();
		ibuf.get(out, outpos.get(), length / 4);
		outpos.add(length / 4);
		inpos.add(inlength);
	}

	@Override
	public void compress(int[] in, IntWrapper inpos, int inlength,
			byte[] out, IntWrapper outpos) {
		if (inlength == 0)
			return;
		ByteBuffer buf = ByteBuffer.allocateDirect(inlength * 8);
		for (int k = inpos.get(); k < inpos.get() + inlength; ++k) {
			long val = in[k] & 0xFFFFFFFFL;
			if (val < (1 << 7)) {
				buf.put((byte)(val | (1 << 7)));
			} else if (val < (1 << 14)) {
				buf.put((byte)extract7bits(0, val));
				buf.put((byte)(extract7bitsmaskless(1, (val)) | (1 << 7)));
			} else if (val < (1 << 21)) {
				buf.put((byte)extract7bits(0, val));
				buf.put((byte)extract7bits(1, val));
				buf.put((byte)(extract7bitsmaskless(2, (val)) | (1 << 7)));
			} else if (val < (1 << 28)) {
				buf.put((byte)extract7bits(0, val));
				buf.put((byte)extract7bits(1, val));
				buf.put((byte)extract7bits(2, val));
				buf.put((byte)(extract7bitsmaskless(3, (val)) | (1 << 7)));
			} else {
				buf.put((byte)extract7bits(0, val));
				buf.put((byte)extract7bits(1, val));
				buf.put((byte)extract7bits(2, val));
				buf.put((byte)extract7bits(3, val));
				buf.put((byte)(extract7bitsmaskless(4, (val)) | (1 << 7)));
			}
		}
		while (buf.position() % 4 != 0)
			buf.put((byte) 0);
		final int length = buf.position();
		buf.flip();
		buf.get(out,0,length);
		outpos.set(length);
		inpos.add(inlength);
	}

	@Override
	public void uncompress(int[] in, IntWrapper inpos, int inlength,
			int[] out, IntWrapper outpos) {
		int s = 0;
		int val = 0;
		int p = inpos.get();
		int finalp = inpos.get() + inlength;
		int tmpoutpos = outpos.get();
		for (int v = 0, shift =0; p < finalp;) {
			val = in[p];
			int c = (byte) (val >>> (24 - s));
			s += 8;
			if (s == 32) {
				s = 0;
				p++;
			}
			v += ((c & 127) << shift);
			if ((c & 128) == 128) {
				out[tmpoutpos++] = v;
				v = 0;
				shift = 0;
			} else 
				shift +=7;
		}
		outpos.set(tmpoutpos);
		inpos.add(inlength);
	}

	@Override
	public void uncompress(byte[] in, IntWrapper inpos, int inlength,
			int[] out, IntWrapper outpos) {
		int p = inpos.get();
        int finalp = inpos.get() + inlength;
        int tmpoutpos = outpos.get();
        int v = 0;
        int shift = 0;
        for (; p < finalp; ++p) {
                int c = in[p];
                v += ((c & 127) << shift);
                if ((c & 128) == 128) {
                        out[tmpoutpos++] = v;
                        v = 0;
                        shift = 0;
                } else
                        shift += 7;
        }
        outpos.set(tmpoutpos);
        inpos.add(p);
	}
	
	@Override
	public String toString() {
		return this.getClass().getSimpleName();
	}

}
