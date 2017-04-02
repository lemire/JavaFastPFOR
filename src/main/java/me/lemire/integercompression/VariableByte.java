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
public class VariableByte implements IntegerCODEC, ByteIntegerCODEC, SkippableIntegerCODEC {

    private static byte extract7bits(int i, long val) {
        return (byte) ((val >> (7 * i)) & ((1 << 7) - 1));
    }

    private static byte extract7bitsmaskless(int i, long val) {
        return (byte) ((val >> (7 * i)));
    }
    @Override
    public void compress(int[] in, IntWrapper inpos, int inlength, int[] out,
            IntWrapper outpos) {
        headlessCompress(in, inpos, inlength, out, outpos);
    }

    @Override
    public void headlessCompress(int[] in, IntWrapper inpos, int inlength, int[] out,
            IntWrapper outpos) {
        if (inlength == 0)
            return;
        ByteBuffer buf = makeBuffer(inlength * 8);
        buf.order(ByteOrder.LITTLE_ENDIAN);
        for (int k = inpos.get(); k < inpos.get() + inlength; ++k) {
            final long val = in[k] & 0xFFFFFFFFL; // To be consistent with
                                                  // unsigned integers in C/C++
            if (val < (1 << 7)) {
                buf.put((byte) (val | (1 << 7)));
            } else if (val < (1 << 14)) {
                buf.put((byte) extract7bits(0, val));
                buf.put((byte) (extract7bitsmaskless(1, (val)) | (1 << 7)));
            } else if (val < (1 << 21)) {
                buf.put((byte) extract7bits(0, val));
                buf.put((byte) extract7bits(1, val));
                buf.put((byte) (extract7bitsmaskless(2, (val)) | (1 << 7)));
            } else if (val < (1 << 28)) {
                buf.put((byte) extract7bits(0, val));
                buf.put((byte) extract7bits(1, val));
                buf.put((byte) extract7bits(2, val));
                buf.put((byte) (extract7bitsmaskless(3, (val)) | (1 << 7)));
            } else {
                buf.put((byte) extract7bits(0, val));
                buf.put((byte) extract7bits(1, val));
                buf.put((byte) extract7bits(2, val));
                buf.put((byte) extract7bits(3, val));
                buf.put((byte) (extract7bitsmaskless(4, (val)) | (1 << 7)));
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
    public void compress(int[] in, IntWrapper inpos, int inlength, byte[] out,
            IntWrapper outpos) {
        if (inlength == 0)
            return;
        int outpostmp = outpos.get();
        for (int k = inpos.get(); k < inpos.get() + inlength; ++k) {
            final long val = in[k] & 0xFFFFFFFFL; // To be consistent with
                                                  // unsigned integers in C/C++
            if (val < (1 << 7)) {
                out[outpostmp++] = (byte) (val | (1 << 7));
            } else if (val < (1 << 14)) {
                out[outpostmp++] = (byte) extract7bits(0, val);
                out[outpostmp++] = (byte) (extract7bitsmaskless(1, (val)) | (1 << 7));
            } else if (val < (1 << 21)) {
                out[outpostmp++] = (byte) extract7bits(0, val);
                out[outpostmp++] = (byte) extract7bits(1, val);
                out[outpostmp++] = (byte) (extract7bitsmaskless(2, (val)) | (1 << 7));
            } else if (val < (1 << 28)) {
                out[outpostmp++] = (byte) extract7bits(0, val);
                out[outpostmp++] = (byte) extract7bits(1, val);
                out[outpostmp++] = (byte) extract7bits(2, val);
                out[outpostmp++] = (byte) (extract7bitsmaskless(3, (val)) | (1 << 7));
            } else {
                out[outpostmp++] = (byte) extract7bits(0, val);
                out[outpostmp++] = (byte) extract7bits(1, val);
                out[outpostmp++] = (byte) extract7bits(2, val);
                out[outpostmp++] = (byte) extract7bits(3, val);
                out[outpostmp++] = (byte) (extract7bitsmaskless(4, (val)) | (1 << 7));
            }
        }
        outpos.set(outpostmp);
        inpos.add(inlength);
    }

    @Override
    public void uncompress(int[] in, IntWrapper inpos, int inlength, int[] out,
            IntWrapper outpos) {
        int s = 0;
        int val = 0;
        int p = inpos.get();
        int finalp = inpos.get() + inlength;
        int tmpoutpos = outpos.get();
        for (int v = 0, shift = 0; p < finalp;) {
            val = in[p];
            int c = (byte) (val >>> s);
            s += 8;
            p += s>>5;
            s = s & 31;
            v += ((c & 127) << shift);
            if ((c & 128) == 128) {
                out[tmpoutpos++] = v;
                v = 0;
                shift = 0;
            } else
                shift += 7;
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
        for (int v = 0; p < finalp; out[tmpoutpos++] = v) {
            v = in[p] & 0x7F;
            if (in[p] < 0) {
                p += 1;
                continue;
            }
            v = ((in[p + 1] & 0x7F) << 7) | v;
            if (in[p + 1] < 0) {
                p += 2;
                continue;
            }
            v = ((in[p + 2] & 0x7F) << 14) | v;
            if (in[p + 2] < 0 ) {
                p += 3;
                continue;
            }
            v = ((in[p + 3] & 0x7F) << 21) | v;
            if (in[p + 3] < 0) {
                p += 4;
                continue;
            }
            v = ((in[p + 4] & 0x7F) << 28) | v;
            p += 5;
        }
        outpos.set(tmpoutpos);
        inpos.add(p);
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName();
    }

    @Override
    public void headlessUncompress(int[] in, IntWrapper inpos, int inlength, int[] out,
            IntWrapper outpos, int num) {
        int s = 0;
        int val = 0;
        int p = inpos.get();
        int tmpoutpos = outpos.get();
        int finaloutpos = num + tmpoutpos;
        for (int v = 0, shift = 0; tmpoutpos < finaloutpos;) {
            val = in[p];
            int c = val >>> s;
            s += 8;
            p += s>>5;
            s = s & 31;
            v += ((c & 127) << shift);
            if ((c & 128) == 128) {
                out[tmpoutpos++] = v;
                v = 0;
                shift = 0;
            } else
                shift += 7;
        }
        outpos.set(tmpoutpos);
        inpos.set(p + (s!=0 ? 1 : 0));
    }

    /**
     * Creates a new buffer of the requested size.
     *
     * In case you need a different way to allocate buffers, you can override this method
     * with a custom behavior. The default implementation allocates a new Java direct
     * {@link ByteBuffer} on each invocation.
     */
    protected ByteBuffer makeBuffer(int sizeInBytes) {
        return ByteBuffer.allocateDirect(sizeInBytes);
    }
}
