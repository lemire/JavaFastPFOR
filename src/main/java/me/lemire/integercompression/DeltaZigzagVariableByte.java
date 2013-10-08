/*
 * This code is released under the
 * Apache License Version 2.0 http://www.apache.org/licenses/.
 */

package me.lemire.integercompression;

import java.nio.ByteBuffer;
import java.nio.IntBuffer;

public final class DeltaZigzagVariableByte implements IntegerCODEC {

    @Override
    public String toString() {
        return DeltaZigzagVariableByte.class.getSimpleName();
    }

    @Override
    public void compress(
            int[] inBuf, IntWrapper inPos, int inLen,
            int[] outBuf, IntWrapper outPos)
    {
        if (inLen == 0) {
            return;
        }

        ByteBuffer byteBuf = ByteBuffer.allocateDirect(inLen * 5);
        DeltaZigzagEncoding.Encoder ctx = new DeltaZigzagEncoding.Encoder();

        // Delta+Zigzag+VariableByte encoding.
        int ip = inPos.get();
        final int inPosLast = ip + inLen;
        for (; ip < inPosLast; ++ip) {
            // Filter with delta+zigzag encoding.
            int n = ctx.encodeInt(inBuf[ip]);
            // Variable byte encoding.
            switch (Integer.numberOfLeadingZeros(n)) {
                case 0: case 1: case 2: case 3:
                    byteBuf.put((byte)(((n >>> 28) & 0x7F) | 0x80));
                    // through.
                case 4: case 5: case 6: case 7: case 8: case 9: case 10:
                    byteBuf.put((byte)(((n >>> 21) & 0x7F) | 0x80));
                    // through.
                case 11: case 12: case 13: case 14: case 15: case 16: case 17:
                    byteBuf.put((byte)(((n >>> 14) & 0x7F) | 0x80));
                    // through.
                case 18: case 19: case 20: case 21: case 22: case 23: case 24:
                    byteBuf.put((byte)(((n >>>  7) & 0x7F) | 0x80));
                    // through.
                default:
                    byteBuf.put((byte)(n & 0x7F));
            }
        }

        // Padding buffer to considerable as IntBuffer.
        for (int i = (4 - (byteBuf.position() % 4)) % 4; i > 0; ++i) {
            byteBuf.put((byte)(0x80));
        }

        int outLen = byteBuf.position() / 4;
        byteBuf.flip();
        IntBuffer intBuf = byteBuf.asIntBuffer();
        intBuf.get(outBuf, outPos.get(), outLen);
        inPos.add(inLen);
        outPos.add(outLen);
    }

    @Override
    public void uncompress(
            int[] inBuf, IntWrapper inPos, int inLen,
            int[] outBuf, IntWrapper outPos)
    {
        /*
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
            int n = inBuf[ip++];
            ip += unpack(inBuf, ip, work,  0, (n >> 24) & 0x3F);
            ip += unpack(inBuf, ip, work, 32, (n >> 16) & 0x3F);
            ip += unpack(inBuf, ip, work, 64, (n >>  8) & 0x3F);
            ip += unpack(inBuf, ip, work, 96, (n >>  0) & 0x3F);
            ctx.decodeArray(work, 0, BLOCK_LENGTH, outBuf, op);
        }

        outPos.add(outLen);
        inPos.set(ip);
        */
    }
}
