/*
 * This code is released under the
 * Apache License Version 2.0 http://www.apache.org/licenses/.
 */
package me.lemire.integercompression;

/**
 * Delta+Zigzag Encoding.
 * 
 * @author MURAOKA Taro http://github.com/koron
 */
public final class DeltaZigzagEncoding {

        static class Context {
                int contextValue;

                Context(int contextValue) {
                        this.contextValue = contextValue;
                }

                void setContextValue(int contextValue) {
                        this.contextValue = contextValue;
                }

                int getContextValue() {
                        return this.contextValue;
                }
        }

        static class Encoder extends Context {
                Encoder(int contextValue) {
                        super(contextValue);
                }

                int encodeInt(int value) {
                        int n = value - this.contextValue;
                        this.contextValue = value;
                        return (n << 1) ^ (n >> 31);
                }

                int[] encodeArray(int[] src, int srcoff, int length,
                        int[] dst, int dstoff) {
                        for (int i = 0; i < length; ++i) {
                                dst[dstoff + i] = encodeInt(src[srcoff + i]);
                        }
                        return dst;
                }

                int[] encodeArray(int[] src, int srcoff, int length,
                        int[] dst) {
                        return encodeArray(src, srcoff, length, dst, 0);
                }

                int[] encodeArray(int[] src, int offset, int length) {
                        return encodeArray(src, offset, length,
                                new int[length], 0);
                }

                int[] encodeArray(int[] src) {
                        return encodeArray(src, 0, src.length,
                                new int[src.length], 0);
                }
        }

        static class Decoder extends Context {
                Decoder(int contextValue) {
                        super(contextValue);
                }

                int decodeInt(int value) {
                        int n = (value >>> 1) ^ ((value << 31) >> 31);
                        n += this.contextValue;
                        this.contextValue = n;
                        return n;
                }

                int[] decodeArray(int[] src, int srcoff, int length,
                        int[] dst, int dstoff) {
                        for (int i = 0; i < length; ++i) {
                                dst[dstoff + i] = decodeInt(src[srcoff + i]);
                        }
                        return dst;
                }

                int[] decodeArray(int[] src, int offset, int length) {
                        return decodeArray(src, offset, length,
                                new int[length], 0);
                }

                int[] decodeArray(int[] src) {
                        return decodeArray(src, 0, src.length);
                }
        }
}
