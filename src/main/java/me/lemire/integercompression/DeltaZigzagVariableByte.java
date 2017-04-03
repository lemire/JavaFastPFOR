/*
 * This code is released under the
 * Apache License Version 2.0 http://www.apache.org/licenses/.
 */

package me.lemire.integercompression;

import java.nio.ByteBuffer;
import java.nio.IntBuffer;

/**
 * VariableByte with Delta+Zigzag Encoding.
 * 
 * @author MURAOKA Taro http://github.com/koron
 */
public class DeltaZigzagVariableByte implements IntegerCODEC {

        @Override
        public String toString() {
                return DeltaZigzagVariableByte.class.getSimpleName();
        }

        @Override
        public void compress(int[] inBuf, IntWrapper inPos, int inLen,
                int[] outBuf, IntWrapper outPos) {
                if (inLen == 0) {
                        return;
                }

                ByteBuffer byteBuf = makeBuffer(inLen * 5 + 3);
                DeltaZigzagEncoding.Encoder ctx = new DeltaZigzagEncoding.Encoder(0);

                // Delta+Zigzag+VariableByte encoding.
                int ip = inPos.get();
                final int inPosLast = ip + inLen;
                for (; ip < inPosLast; ++ip) {
                        // Filter with delta+zigzag encoding.
                        int n = ctx.encodeInt(inBuf[ip]);
                        // Variable byte encoding.
                        switch (Integer.numberOfLeadingZeros(n)) {
                        case 0:
                        case 1:
                        case 2:
                        case 3:
                                byteBuf.put((byte) (((n >>> 28) & 0x7F) | 0x80));
                                // through.
                                //$FALL-THROUGH$
                        case 4:
                        case 5:
                        case 6:
                        case 7:
                        case 8:
                        case 9:
                        case 10:
                                byteBuf.put((byte) (((n >>> 21) & 0x7F) | 0x80));
                                // through.
                                //$FALL-THROUGH$
                        case 11:
                        case 12:
                        case 13:
                        case 14:
                        case 15:
                        case 16:
                        case 17:
                                byteBuf.put((byte) (((n >>> 14) & 0x7F) | 0x80));
                                // through.
                                //$FALL-THROUGH$
                        case 18:
                        case 19:
                        case 20:
                        case 21:
                        case 22:
                        case 23:
                        case 24:
                                byteBuf.put((byte) (((n >>> 7) & 0x7F) | 0x80));
                                // through.
                                //$FALL-THROUGH$
                        default:
                                byteBuf.put((byte) (n & 0x7F));
                        }
                }

                // Padding buffer to considerable as IntBuffer.
                for (int i = (4 - (byteBuf.position() % 4)) % 4; i > 0; --i) {
                        byteBuf.put((byte) (0x80));
                }

                int outLen = byteBuf.position() / 4;
                byteBuf.flip();
                IntBuffer intBuf = byteBuf.asIntBuffer();
                /*
                 * System.out.println(String.format(
                 * "inLen=%d pos=%d limit=%d outLen=%d outBuf.len=%d", inLen,
                 * intBuf.position(), intBuf.limit(), outLen, outBuf.length));
                 */
                intBuf.get(outBuf, outPos.get(), outLen);
                inPos.add(inLen);
                outPos.add(outLen);
        }

        @Override
        public void uncompress(int[] inBuf, IntWrapper inPos, int inLen,
                int[] outBuf, IntWrapper outPos) {
                DeltaZigzagEncoding.Decoder ctx = new DeltaZigzagEncoding.Decoder(0);

                int ip = inPos.get();
                int op = outPos.get();
                int vbcNum = 0, vbcShift = 24; // Varialbe Byte Context.
                final int inPosLast = ip + inLen;
                while (ip < inPosLast) {
                        // Fetch a byte value.
                        int n = (inBuf[ip] >>> vbcShift) & 0xFF;
                        if (vbcShift > 0) {
                                vbcShift -= 8;
                        } else {
                                vbcShift = 24;
                                ip++;
                        }
                        // Decode variable byte and delta+zigzag.
                        vbcNum = (vbcNum << 7) + (n & 0x7F);
                        if ((n & 0x80) == 0) {
                                outBuf[op++] = ctx.decodeInt(vbcNum);
                                vbcNum = 0;
                        }
                }

                outPos.set(op);
                inPos.set(inPosLast);
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
