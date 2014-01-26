/**
 * This code is released under the
 * Apache License Version 2.0 http://www.apache.org/licenses/.
 */
package me.lemire.integercompression.benchmarktools;

/**
 * PerformanceLogger for IntegerCODEC.
 * 
 * @author MURAOKA Taro http://github.com/koron
 */
public final class PerformanceLogger {
        static class Timer {
                private long startNano;
                private long duration = 0;

                public Timer() {
                }

                public void start() {
                        this.startNano = System.nanoTime();
                }

                public long end() {
                        return this.duration += System.nanoTime()
                                - this.startNano;
                }

                public long getDuration() {
                        return this.duration;
                }
        }

        final Timer compressionTimer = new Timer();

        final Timer decompressionTimer = new Timer();

        private long originalSize = 0;

        private long compressedSize = 0;

        long addOriginalSize(long value) {
                return this.originalSize += value;
        }

        long addCompressedSize(long value) {
                return this.compressedSize += value;
        }

        long getOriginalSize() {
                return this.originalSize;
        }

        long getCompressedSize() {
                return this.compressedSize;
        }

        double getBitPerInt() {
                return this.compressedSize * 32.0 / this.originalSize;
        }

        private static double getMiS(long size, long nanoTime) {
                return (size * 1e-6) / (nanoTime * 1.0e-9);
        }

        double getCompressSpeed() {
                return getMiS(this.originalSize,
                        this.compressionTimer.getDuration());
        }

        double getDecompressSpeed() {
                return getMiS(this.originalSize,
                        this.decompressionTimer.getDuration());
        }
}
