/**
 * This code is released under the
 * Apache License Version 2.0 http://www.apache.org/licenses/.
 *
 * (c) Daniel Lemire, http://lemire.me/en/
 */
package me.lemire.longcompression;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.LongBuffer;

import me.lemire.integercompression.IntWrapper;

/**
 * Implementation of variable-byte. For best performance, use it using the
 * ByteLongCODEC interface.
 * 
 * Note that this does not use differential coding: if you are working on sorted
 * lists, you must compute the deltas separately.
 * 
 * @author Benoit Lacelle
 */
public class LongVariableByte implements LongCODEC, ByteLongCODEC, SkippableLongCODEC {

    private static byte extract7bits(int i, long val) {
        return (byte) ((val >>> (7 * i)) & ((1 << 7) - 1));
    }

    private static byte extract7bitsmaskless(int i, long val) {
        return (byte) ((val >>> (7 * i)));
    }
    @Override
    public void compress(long[] in, IntWrapper inpos, int inlength, long[] out,
            IntWrapper outpos) {
        headlessCompress(in, inpos, inlength, out, outpos);
    }

    @Override
    public void headlessCompress(long[] in, IntWrapper inpos, int inlength, long[] out,
            IntWrapper outpos) {
        if (inlength == 0)
            return;
        // Worst case: we write 10 bytes per long, hence 2 longs for a long, hence 16 bytes per long
        ByteBuffer buf = makeBuffer(inlength * 16);
        buf.order(ByteOrder.LITTLE_ENDIAN);
        for (int k = inpos.get(); k < inpos.get() + inlength; ++k) {
            final long val = in[k];
            // System.out.println(LongUtil.longToBinaryWithLeading(val));
            if (val >= 0 && val < (1 << 7)) {
                buf.put((byte) (val | (1 << 7)));
            } else if (val >= 0 && val < (1 << 14)) {
                buf.put((byte) extract7bits(0, val));
                buf.put((byte) (extract7bitsmaskless(1, (val)) | (1 << 7)));
            } else if (val >= 0 && val < (1 << 21)) {
                buf.put((byte) extract7bits(0, val));
                buf.put((byte) extract7bits(1, val));
                buf.put((byte) (extract7bitsmaskless(2, (val)) | (1 << 7)));
            } else if (val >= 0 && val < (1 << 28)) {
                buf.put((byte) extract7bits(0, val));
                buf.put((byte) extract7bits(1, val));
                buf.put((byte) extract7bits(2, val));
                buf.put((byte) (extract7bitsmaskless(3, (val)) | (1 << 7)));
            } else if (val >= 0 && val < (1L << 35)) {
                buf.put((byte) extract7bits(0, val));
                buf.put((byte) extract7bits(1, val));
                buf.put((byte) extract7bits(2, val));
                buf.put((byte) extract7bits(3, val));
                buf.put((byte) (extract7bitsmaskless(4, (val)) | (1 << 7)));
            } else if (val >= 0 && val < (1L << 42)) {
                buf.put((byte) extract7bits(0, val));
                buf.put((byte) extract7bits(1, val));
                buf.put((byte) extract7bits(2, val));
                buf.put((byte) extract7bits(3, val));
                buf.put((byte) extract7bits(4, val));
                buf.put((byte) (extract7bitsmaskless(5, (val)) | (1 << 7)));
            } else if (val >= 0 && val < (1L << 49)) {
                buf.put((byte) extract7bits(0, val));
                buf.put((byte) extract7bits(1, val));
                buf.put((byte) extract7bits(2, val));
                buf.put((byte) extract7bits(3, val));
                buf.put((byte) extract7bits(4, val));
                buf.put((byte) extract7bits(5, val));
                buf.put((byte) (extract7bitsmaskless(6, (val)) | (1 << 7)));
            } else if (val >= 0 && val < (1L << 56)) {
                buf.put((byte) extract7bits(0, val));
                buf.put((byte) extract7bits(1, val));
                buf.put((byte) extract7bits(2, val));
                buf.put((byte) extract7bits(3, val));
                buf.put((byte) extract7bits(4, val));
                buf.put((byte) extract7bits(5, val));
                buf.put((byte) extract7bits(6, val));
                buf.put((byte) (extract7bitsmaskless(7, (val)) | (1 << 7)));
            } else if (val >= 0 && val < (1L << 63)) {
                buf.put((byte) extract7bits(0, val));
                buf.put((byte) extract7bits(1, val));
                buf.put((byte) extract7bits(2, val));
                buf.put((byte) extract7bits(3, val));
                buf.put((byte) extract7bits(4, val));
                buf.put((byte) extract7bits(5, val));
                buf.put((byte) extract7bits(6, val));
                buf.put((byte) extract7bits(7, val));
                buf.put((byte) (extract7bitsmaskless(8, (val)) | (1 << 7)));
            } else {
                buf.put((byte) extract7bits(0, val));
                buf.put((byte) extract7bits(1, val));
                buf.put((byte) extract7bits(2, val));
                buf.put((byte) extract7bits(3, val));
                buf.put((byte) extract7bits(4, val));
                buf.put((byte) extract7bits(5, val));
                buf.put((byte) extract7bits(6, val));
                buf.put((byte) extract7bits(7, val));
                buf.put((byte) extract7bits(8, val));
                buf.put((byte) (extract7bitsmaskless(9, (val)) | (1 << 7)));
            }
        }
        while (buf.position() % 8 != 0)
            buf.put((byte) 0);
        final int length = buf.position();
        buf.flip();
        LongBuffer ibuf = buf.asLongBuffer();
        ibuf.get(out, outpos.get(), length / 8);
        outpos.add(length / 8);
        inpos.add(inlength);
    }

    @Override
    public void compress(long[] in, IntWrapper inpos, int inlength, byte[] out,
            IntWrapper outpos) {
        if (inlength == 0)
            return;
        int outpostmp = outpos.get();
        for (int k = inpos.get(); k < inpos.get() + inlength; ++k) {
            final long val = in[k];
            if (val >= 0 && val < (1 << 7)) {
                out[outpostmp++] = (byte) (val | (1 << 7));
            } else if (val >= 0 && val < (1 << 14)) {
                out[outpostmp++] = (byte) extract7bits(0, val);
                out[outpostmp++] = (byte) (extract7bitsmaskless(1, (val)) | (1 << 7));
            } else if (val >= 0 && val < (1 << 21)) {
                out[outpostmp++] = (byte) extract7bits(0, val);
                out[outpostmp++] = (byte) extract7bits(1, val);
                out[outpostmp++] = (byte) (extract7bitsmaskless(2, (val)) | (1 << 7));
            } else if (val >= 0 && val < (1 << 28)) {
                out[outpostmp++] = (byte) extract7bits(0, val);
                out[outpostmp++] = (byte) extract7bits(1, val);
                out[outpostmp++] = (byte) extract7bits(2, val);
                out[outpostmp++] = (byte) (extract7bitsmaskless(3, (val)) | (1 << 7));
            } else if (val >= 0 && val < (1L << 35)) {
                out[outpostmp++] = (byte) extract7bits(0, val);
                out[outpostmp++] = (byte) extract7bits(1, val);
                out[outpostmp++] = (byte) extract7bits(2, val);
                out[outpostmp++] = (byte) extract7bits(3, val);
                out[outpostmp++] = (byte) (extract7bitsmaskless(4, (val)) | (1 << 7));
            } else if (val >= 0 && val < (1L << 42)) {
                out[outpostmp++] = (byte) extract7bits(0, val);
                out[outpostmp++] = (byte) extract7bits(1, val);
                out[outpostmp++] = (byte) extract7bits(2, val);
                out[outpostmp++] = (byte) extract7bits(3, val);
                out[outpostmp++] = (byte) extract7bits(4, val);
                out[outpostmp++] = (byte) (extract7bitsmaskless(5, (val)) | (1 << 7));
            } else if (val >= 0 && val < (1L << 49)) {
                out[outpostmp++] = (byte) extract7bits(0, val);
                out[outpostmp++] = (byte) extract7bits(1, val);
                out[outpostmp++] = (byte) extract7bits(2, val);
                out[outpostmp++] = (byte) extract7bits(3, val);
                out[outpostmp++] = (byte) extract7bits(4, val);
                out[outpostmp++] = (byte) extract7bits(5, val);
                out[outpostmp++] = (byte) (extract7bitsmaskless(6, (val)) | (1 << 7));
            } else if (val >= 0 && val < (1L << 56)) {
                out[outpostmp++] = (byte) extract7bits(0, val);
                out[outpostmp++] = (byte) extract7bits(1, val);
                out[outpostmp++] = (byte) extract7bits(2, val);
                out[outpostmp++] = (byte) extract7bits(3, val);
                out[outpostmp++] = (byte) extract7bits(4, val);
                out[outpostmp++] = (byte) extract7bits(5, val);
                out[outpostmp++] = (byte) extract7bits(6, val);
                out[outpostmp++] = (byte) (extract7bitsmaskless(7, (val)) | (1 << 7));
            } else if (val >= 0 && val < (1L << 63)) {
                out[outpostmp++] = (byte) extract7bits(0, val);
                out[outpostmp++] = (byte) extract7bits(1, val);
                out[outpostmp++] = (byte) extract7bits(2, val);
                out[outpostmp++] = (byte) extract7bits(3, val);
                out[outpostmp++] = (byte) extract7bits(4, val);
                out[outpostmp++] = (byte) extract7bits(5, val);
                out[outpostmp++] = (byte) extract7bits(6, val);
                out[outpostmp++] = (byte) extract7bits(7, val);
                out[outpostmp++] = (byte) (extract7bitsmaskless(8, (val)) | (1 << 7));
            } else {
                // System.out.println(LongUtil.longToBinaryWithLeading(val));
                out[outpostmp++] = (byte) extract7bits(0, val);
                out[outpostmp++] = (byte) extract7bits(1, val);
                out[outpostmp++] = (byte) extract7bits(2, val);
                out[outpostmp++] = (byte) extract7bits(3, val);
                out[outpostmp++] = (byte) extract7bits(4, val);
                out[outpostmp++] = (byte) extract7bits(5, val);
                out[outpostmp++] = (byte) extract7bits(6, val);
                out[outpostmp++] = (byte) extract7bits(7, val);
                out[outpostmp++] = (byte) extract7bits(8, val);
                out[outpostmp++] = (byte) (extract7bitsmaskless(9, (val)) | (1 << 7));
            }
        }
        outpos.set(outpostmp);
        inpos.add(inlength);
    }

    @Override
    public void uncompress(long[] in, IntWrapper inpos, int inlength, long[] out,
            IntWrapper outpos) {
        int s = 0;
        long val = 0;
        int p = inpos.get();
        int finalp = inpos.get() + inlength;
        int tmpoutpos = outpos.get();
        for (long v = 0, shift = 0; p < finalp;) {
            val = in[p];
            // System.out.println(LongUtil.longToBinaryWithLeading(val));
            long c = (byte) (val >>> s);
            // Shift to next byte
            s += 8;
            // Shift to next long if s==64
            p += s>>6;
            // Cycle from 64 to 0
            s = s & 63;
            v += ((c & 127) << shift);
            if ((c & 128) == 128) {
                out[tmpoutpos++] = v;
                v = 0;
                shift = 0;
            } else
                shift += 7;
            assert shift < 64;
        }
        outpos.set(tmpoutpos);
        inpos.add(inlength);
    }

    @Override
    public void uncompress(byte[] in, IntWrapper inpos, int inlength,
            long[] out, IntWrapper outpos) {
        int p = inpos.get();
        int finalp = inpos.get() + inlength;
        int tmpoutpos = outpos.get();
        for (long v = 0; p < finalp; out[tmpoutpos++] = v) {
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
            v = (((long) in[p + 4] & 0x7F) << 28) | v;
            if (in[p + 4] < 0) {
                p += 5;
                continue;
            }
            v = (((long) in[p + 5] & 0x7F) << 35) | v;
            if (in[p + 5] < 0) {
                p += 6;
                continue;
            }
            v = (((long) in[p + 6] & 0x7F) << 42) | v;
            if (in[p + 6] < 0) {
                p += 7;
                continue;
            }
            v = (((long) in[p + 7] & 0x7F) << 49) | v;
            if (in[p + 7] < 0) {
                p += 8;
                continue;
            }
            v = (((long) in[p + 8] & 0x7F) << 56) | v;
            if (in[p + 8] < 0) {
                p += 9;
                continue;
            }
            v = (((long) in[p + 9] & 0x7F) << 63) | v;
            p += 10;
        }
        outpos.set(tmpoutpos);
        inpos.add(p);
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName();
    }

    @Override
    public void headlessUncompress(long[] in, IntWrapper inpos, int inlength, long[] out,
            IntWrapper outpos, int num) {
        int s = 0;
        long val = 0;
        int p = inpos.get();
        int tmpoutpos = outpos.get();
        int finaloutpos = num + tmpoutpos;
        for (long v = 0, shift = 0; tmpoutpos < finaloutpos;) {
            val = in[p];
            // System.out.println(longToBinaryWithLeading(val));
            long c = val >>> s;
            // Shift to next byte
            s += 8;
            // Shift to next long if s == 64
            p += s>>6;
            // Cycle from 64 to 0
            s = s & 63;
            v += ((c & 127) << shift);
            if ((c & 128) == 128) {
                out[tmpoutpos++] = v;
                v = 0;
                shift = 0;
            } else
                shift += 7;
            assert shift < 64;
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
