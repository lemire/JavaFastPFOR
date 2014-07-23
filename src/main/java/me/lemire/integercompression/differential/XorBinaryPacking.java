/**
 * This code is released under the
 * Apache License Version 2.0 http://www.apache.org/licenses/.
 */
package me.lemire.integercompression.differential;

import me.lemire.integercompression.BitPacking;
import me.lemire.integercompression.IntWrapper;

/**
 * BinaryPacking over XOR differential.
 * 
 * <pre>IntegratedIntegerCODEC is = 
 * new Composition(new XorBinaryPacking(), new VariableByte())</pre>
 * 
 * @author MURAOKA Taro http://github.com/koron
 */
public final class XorBinaryPacking implements IntegratedIntegerCODEC {

        private static final int BLOCK_LENGTH = 128;

        @Override
        public void compress(final int[] inBuf, final IntWrapper inPos,
                int inLen, final int[] outBuf, final IntWrapper outPos) {
                inLen = inLen - inLen % BLOCK_LENGTH;
                if (inLen == 0)
                        return;

                outBuf[outPos.get()] = inLen;
                outPos.increment();

                int context = 0;
                final int[] work = new int[32];

                int op = outPos.get();
                int ip = inPos.get();
                final int inPosLast = ip + inLen;
                for (; ip < inPosLast; ip += BLOCK_LENGTH) {
                        final int bits1 = xorMaxBits(inBuf, ip + 0, 32, context);
                        final int bits2 = xorMaxBits(inBuf, ip + 32, 32,
                                inBuf[ip + 31]);
                        final int bits3 = xorMaxBits(inBuf, ip + 64, 32,
                                inBuf[ip + 63]);
                        final int bits4 = xorMaxBits(inBuf, ip + 96, 32,
                                inBuf[ip + 95]);
                        outBuf[op++] = (bits1 << 24) | (bits2 << 16)
                                | (bits3 << 8) | (bits4 << 0);
                        op += xorPack(inBuf, ip + 0, outBuf, op, bits1,
                                context, work);
                        op += xorPack(inBuf, ip + 32, outBuf, op, bits2,
                                inBuf[ip + 31], work);
                        op += xorPack(inBuf, ip + 64, outBuf, op, bits3,
                                inBuf[ip + 63], work);
                        op += xorPack(inBuf, ip + 96, outBuf, op, bits4,
                                inBuf[ip + 95], work);
                        context = inBuf[ip + 127];
                }

                inPos.add(inLen);
                outPos.set(op);
        }

        @Override
        public void uncompress(int[] inBuf, IntWrapper inPos, int inLen,
                int[] outBuf, IntWrapper outPos) {
                if (inLen == 0)
                        return;

                final int outLen = inBuf[inPos.get()];
                inPos.increment();

                int context = 0;
                final int[] work = new int[32];

                int ip = inPos.get();
                int op = outPos.get();
                final int outPosLast = op + outLen;
                for (; op < outPosLast; op += BLOCK_LENGTH) {
                        final int bits1 = (inBuf[ip] >>> 24);
                        final int bits2 = (inBuf[ip] >>> 16) & 0xFF;
                        final int bits3 = (inBuf[ip] >>> 8) & 0xFF;
                        final int bits4 = (inBuf[ip] >>> 0) & 0xFF;
                        ++ip;
                        ip += xorUnpack(inBuf, ip, outBuf, op + 0, bits1,
                                context, work);
                        ip += xorUnpack(inBuf, ip, outBuf, op + 32, bits2,
                                outBuf[op + 31], work);
                        ip += xorUnpack(inBuf, ip, outBuf, op + 64, bits3,
                                outBuf[op + 63], work);
                        ip += xorUnpack(inBuf, ip, outBuf, op + 96, bits4,
                                outBuf[op + 95], work);
                        context = outBuf[op + 127];
                }

                outPos.add(outLen);
                inPos.set(ip);
        }

        @Override
        public String toString() {
                return this.getClass().getSimpleName();
        }

        private static int xorMaxBits(final int[] buf, final int offset,
                final int length, final int context) {
                int mask = buf[offset] ^ context;
                final int M = offset + length;
                for (int i = offset + 1, prev = offset; i < M; ++i, ++prev) {
                        mask |= buf[i] ^ buf[prev];
                }

                return 32 - Integer.numberOfLeadingZeros(mask);
        }

        private static int xorPack(final int[] inBuf, final int inOff,
                final int[] outBuf, final int outOff, final int validBits,
                final int context, final int[] work) {
                work[0] = inBuf[inOff] ^ context;
                for (int i = 1, p = inOff + 1; i < 32; ++i, ++p) {
                        work[i] = inBuf[p] ^ inBuf[p - 1];
                }
                BitPacking.fastpackwithoutmask(work, 0, outBuf, outOff,
                        validBits);

                return validBits;
        }

        private static int xorUnpack(final int[] inBuf, final int inOff,
                final int[] outBuf, final int outOff, final int validBits,
                int context, final int[] work) {

                BitPacking.fastunpack(inBuf, inOff, work, 0, validBits);
                outBuf[outOff] = context = work[0] ^ context;
                for (int i = 1, p = outOff + 1; i < 32; ++i, ++p) {
                        outBuf[p] = context = work[i] ^ context;
                }
                return validBits;
        }
}
