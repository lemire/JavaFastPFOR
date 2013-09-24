/**
 * This code is released under the
 * Apache License Version 2.0 http://www.apache.org/licenses/.
 */
package me.lemire.integercompression;

public final class PerformanceLogger
{
    public static class Timer {
        private long startNano;
        private long duration;

        public Timer() {}

        public void start() {
            this.startNano = System.nanoTime();
        }

        public long end() {
            return this.duration = System.nanoTime() - this.startNano;
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

    public double getCompressSpeed() {
        return originalSize * 1.0e3 / this.compressionTimer.getDuration();
    }

    public double getDecompressSpeed() {
        return originalSize * 1.0e3 / this.decompressionTimer.getDuration();
    }
}
