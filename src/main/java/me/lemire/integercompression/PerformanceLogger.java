/**
 * This code is released under the
 * Apache License Version 2.0 http://www.apache.org/licenses/.
 */
package me.lemire.integercompression;

public final class PerformanceLogger
{
    public static class Timer {
        private long startNano;
        private long duration = 0;

        public Timer() {}

        public void start() {
            this.startNano = System.nanoTime();
        }

        public long end() {
            return this.duration += System.nanoTime() - this.startNano;
        }

        public long getDuration() {
            return this.duration;
        }
    }

    public final Timer compressionTimer = new Timer();

    public final Timer decompressionTimer = new Timer();

    private long originalSize = 0;

    private long compressedSize = 0;

    public long addOriginalSize(long value) {
        return this.originalSize += value;
    }

    public long addCompressedSize(long value) {
        return this.compressedSize += value;
    }

    public long getOriginalSize() {
        return this.originalSize;
    }

    public long getCompressedSize() {
        return this.compressedSize;
    }

    public double getBitPerInt() {
        return this.compressedSize * 32.0 / this.originalSize;
    }

    private static double getMiS(long size, long nanoTime) {
        return (size * 1e-6) / (nanoTime * 1.0e-9);
    }

    public double getCompressSpeed() {
        return getMiS(this.originalSize, this.compressionTimer.getDuration());
    }

    public double getDecompressSpeed() {
        return getMiS(this.originalSize, this.decompressionTimer.getDuration());
    }
}
