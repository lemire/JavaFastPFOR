/*
 * This code is released under the
 * Apache License Version 2.0 http://www.apache.org/licenses/.
 */

package me.lemire.integercompression;

public final class DeltaZigzagBinaryPacking implements IntegerCODEC {

    public static final int BLOCK_LENGTH = 128;

    @Override
    public void compress(
            int[] inBuf, IntWrapper inPos, int inLen,
            int[] outBuf, IntWrapper outPos)
    {
        inLen = inLen - inLen % BLOCK_LENGTH;
        if (inLen == 0) {
            return;
        }

        outBuf[outPos.get()] = inLen;
        outPos.increment();

        DeltaZigzagEncoding.Encoder ctx = new DeltaZigzagEncoding.Encoder();
        int[] work = new int[BLOCK_LENGTH];

        int op = outPos.get();
        int ip = inPos.get();
        final int inPosLast = ip + inLen;
        for (; ip < inPosLast; ip += BLOCK_LENGTH) {
            ctx.encodeArray(inBuf, ip, BLOCK_LENGTH, work);
            final int bits1 = Util.maxbits32(work,  0);
            final int bits2 = Util.maxbits32(work, 32);
            final int bits3 = Util.maxbits32(work, 64);
            final int bits4 = Util.maxbits32(work, 96);
            outBuf[op++] = (bits1 << 24) | (bits2 << 16) |
                (bits3 << 8) | (bits4 << 0);
            op += pack(work,  0, outBuf, op, bits1);
            op += pack(work, 32, outBuf, op, bits2);
            op += pack(work, 64, outBuf, op, bits3);
            op += pack(work, 96, outBuf, op, bits4);
        }

        inPos.add(inLen);
        outPos.set(op);
    }

    @Override
    public void uncompress(
            int[] inBuf, IntWrapper inPos, int inLen,
            int[] outBuf, IntWrapper outPos)
    {
        if (inLen == 0) {
            return;
        }

        final int outLen = inBuf[inPos.get()];
        inPos.increment();

        DeltaZigzagEncoding.Decoder ctx = new DeltaZigzagEncoding.Decoder();
        int[] work = new int[BLOCK_LENGTH];

        int ip = inPos.get();
        int op = outPos.get();
        final int outPosLast = op + outLen;
        for (; op < outPosLast; op += BLOCK_LENGTH) {
            final int bits1 = (inBuf[ip] >>> 24);
            final int bits2 = (inBuf[ip] >>> 16) & 0xFF;
            final int bits3 = (inBuf[ip] >>>  8) & 0xFF;
            final int bits4 = (inBuf[ip] >>>  0) & 0xFF;
            ++ip;
            ip += unpack(inBuf, ip, work,  0, bits1);
            ip += unpack(inBuf, ip, work, 32, bits2);
            ip += unpack(inBuf, ip, work, 64, bits3);
            ip += unpack(inBuf, ip, work, 96, bits4);
            ctx.decodeArray(work, 0, BLOCK_LENGTH, outBuf, op);
        }

        outPos.add(outLen);
        inPos.set(ip);
    }

    private static int pack(int[] inBuf, int inOff,
            int[] outBuf, int outOff, int validBits)
    {
        BitPacking.fastpackwithoutmask(inBuf, inOff, outBuf, outOff,
                validBits);
        return validBits;
    }

    private static int unpack(int[] inBuf, int inOff,
            int[] outBuf, int outOff, int validBits)
    {
        BitPacking.fastunpack(inBuf, inOff, outBuf, outOff, validBits);
        return validBits;
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName();
    }
}
