/**
 * This code is released under the
 * Apache License Version 2.0 http://www.apache.org/licenses/.
 *
 * (c) Daniel Lemire, http://lemire.me/en/
 */
package me.lemire.integercompression;

import java.nio.ByteBuffer;
import java.util.Arrays;

/**
 * This is a patching scheme designed for speed. It encodes integers in blocks
 * integers.  For arrays containing a number of
 * integers that is not divisible by BLOCK_SIZE, you should use it in conjunction with
 * another CODEC:
 * 
 * IntegerCODEC ic = new Composition(new SkippableFastPFOR(), new
 * VariableByte()).
 * <p>
 * For details, please see
 * </p>
 * <p>
 * Daniel Lemire and Leonid Boytsov, Decoding billions of integers per second
 * through vectorization Software: Practice &amp; Experience <a
 * href="http://onlinelibrary.wiley.com/doi/10.1002/spe.2203/abstract"
 * >http://onlinelibrary.wiley.com/doi/10.1002/spe.2203/abstract</a> <a
 * href="http://arxiv.org/abs/1209.2137">http://arxiv.org/abs/1209.2137</a>
 * </p>
 * <p>
 * For sufficiently compressible and long arrays, it is faster and better than
 * other PFOR schemes.
 * </p>
 * 
 * Note that this does not use differential coding: if you are working on sorted
 * lists, use IntegratedFastPFOR instead.
 * 
 * For multi-threaded applications, each thread should use its own FastPFOR
 * object.
 * 
 * @author Daniel Lemire
 */
public final class SkippableFastPFOR implements IntegerCODEC,
        SkippableIntegerCODEC {
    /**
     * 
     */
    final public static int BLOCK_SIZE = 256;
    final static int OVERHEAD_OF_EACH_EXCEPT = 8;

    ByteBuffer byteContainer = null;

    // Working area for compress and uncompress.
    int[] freqs = new int[33];
    int[] bestbbestcexceptmaxb = new int[3];
    int[] exceptionbuffer = new int[BLOCK_SIZE];

    /**
     * Construct the fastPFOR CODEC with default parameters.
     */
    public SkippableFastPFOR() {
    }

    /**
     * Compress data in blocks of integers (if fewer than BLOCK_SIZE integers are
     * provided, nothing is done).
     * 
     * @see IntegerCODEC#compress(int[], IntWrapper, int, int[], IntWrapper)
     */
    @Override
    public void headlessCompress(int[] in, IntWrapper inpos, int inlength,
            int[] out, IntWrapper outpos) {
        inlength = Util.greatestMultiple(inlength, BLOCK_SIZE);
        if (inlength == 0)
            return;
        encodePage(in, inpos, inlength, out, outpos);
    }

    private void getBestBFromData(int[] in, int pos) {
        Arrays.fill(freqs, 0);
        for (int k = pos, k_end = pos + BLOCK_SIZE; k < k_end; ++k) {
            freqs[Util.bits(in[k])]++;
        }
        bestbbestcexceptmaxb[0] = 32;
        while (freqs[bestbbestcexceptmaxb[0]] == 0)
            bestbbestcexceptmaxb[0]--;
        bestbbestcexceptmaxb[2] = bestbbestcexceptmaxb[0];
        int bestcost = bestbbestcexceptmaxb[0] * BLOCK_SIZE;
        int cexcept = 0;
        bestbbestcexceptmaxb[1] = cexcept;
        for (int b = bestbbestcexceptmaxb[0] - 1; b >= 0; --b) {
            cexcept += freqs[b + 1];
            if (cexcept == BLOCK_SIZE)
                break;
            // the extra 8 is the cost of storing maxbits
            int thiscost = cexcept
                    * OVERHEAD_OF_EACH_EXCEPT
                    + Util.packsizew((int) cexcept, bestbbestcexceptmaxb[2] - b)
                    + b * BLOCK_SIZE + 8;
            if (thiscost < bestcost) {
                bestcost = thiscost;
                bestbbestcexceptmaxb[0] =  b;
                bestbbestcexceptmaxb[1] = cexcept;
            }
        }
    }

    private void encodePage(int[] in, IntWrapper inpos, int thissize,
            int[] out, IntWrapper outpos) {

        final int headerpos = outpos.get();
        outpos.increment();
        int tmpoutpos = outpos.get();
        final int bytesrequired = 3 * thissize / BLOCK_SIZE + thissize;
        if ((byteContainer == null)
                || (byteContainer.capacity() < bytesrequired))
            byteContainer = ByteBuffer.allocateDirect(bytesrequired);
        else
            byteContainer.clear();

        int tmpinpos = inpos.get();

        for (final int finalinpos = tmpinpos + thissize - BLOCK_SIZE; tmpinpos <= finalinpos; tmpinpos += BLOCK_SIZE) {
            getBestBFromData(in, tmpinpos);
            final int tmpbestb = bestbbestcexceptmaxb[0];
            byteContainer.put((byte)bestbbestcexceptmaxb[0]);
            byteContainer.put((byte)bestbbestcexceptmaxb[1]);
            if (bestbbestcexceptmaxb[1] > 0) {
                byteContainer.put((byte)bestbbestcexceptmaxb[2]);
                for (int k = 0, ek = 0; k < BLOCK_SIZE; ++k) {
                    if ((in[k + tmpinpos] >>> bestbbestcexceptmaxb[0]) != 0) {
                        // we have an exception
                        byteContainer.put((byte) k);
                        exceptionbuffer[ek++] = in[k + tmpinpos] >>> tmpbestb;
                    }
                }

            }
            for (int k = 0; k < BLOCK_SIZE; k += 32) {
                BitPacking.fastpack(in, tmpinpos + k, out, tmpoutpos, tmpbestb);
                tmpoutpos += tmpbestb;
            }
            final int index = bestbbestcexceptmaxb[2] - bestbbestcexceptmaxb[0];
            if (bestbbestcexceptmaxb[1] > 0)
                tmpoutpos = Util.packw(out, tmpoutpos, exceptionbuffer,
                        bestbbestcexceptmaxb[1], index);

        }
        inpos.set(tmpinpos);
        out[headerpos] = tmpoutpos - headerpos;
        final int bytesize = byteContainer.position();
        while ((byteContainer.position() & 3) != 0)
            byteContainer.put((byte) 0);
        out[tmpoutpos++] = bytesize;
        final int howmanyints = byteContainer.position() / 4;
        byteContainer.flip();
        byteContainer.asIntBuffer().get(out, tmpoutpos, howmanyints);
        tmpoutpos += howmanyints;
        outpos.set(tmpoutpos);

    }

    /**
     * Uncompress data in blocks  integers. In this particular case, the
     * inlength parameter is ignored: it is deduced from the compressed data.
     * 
     * @see IntegerCODEC#compress(int[], IntWrapper, int, int[], IntWrapper)
     */
    @Override
    public void headlessUncompress(int[] in, IntWrapper inpos, int inlength,
            int[] out, IntWrapper outpos, int mynvalue) {
        if (inlength == 0)
            return;
        mynvalue = Util.greatestMultiple(mynvalue, BLOCK_SIZE);
        if (mynvalue == 0)
            return;
        decodePage(in, inpos, out, outpos, mynvalue);
    }

    private void decodePage(int[] in, IntWrapper inpos, int[] out,
            IntWrapper outpos, int thissize) {

        final int initpos = inpos.get();
        final int wheremeta = in[inpos.get()];
        inpos.increment();
        int inexcept = initpos + wheremeta;
        final int bytesize = in[inexcept++];
        if ((byteContainer == null) || (byteContainer.capacity() < bytesize))
            byteContainer = ByteBuffer.allocateDirect(bytesize);
        else
            byteContainer.clear();
        byteContainer.asIntBuffer().put(in, inexcept, (bytesize + 3) / 4);
        inexcept += (bytesize + 3) / 4;

        int tmpoutpos = outpos.get();
        int tmpinpos = inpos.get();

        for (int run = 0, run_end = thissize / BLOCK_SIZE; run < run_end; ++run, tmpoutpos += BLOCK_SIZE) {
            final int b = byteContainer.get();
            final int cexcept = byteContainer.get() & 0xFF;
            int nexttmpinpos = tmpinpos + b * BLOCK_SIZE / 32;
            if (cexcept > 0) {
                final int maxbits = byteContainer.get();
                final int index = maxbits - b;
                nexttmpinpos = Util.unpackw(in, nexttmpinpos, exceptionbuffer,
                        cexcept, index);

            }

            for (int k = 0; k < BLOCK_SIZE; k += 32) {
                BitPacking.fastunpack(in, tmpinpos + b * (k / 32), out,
                        tmpoutpos + k, b);

            }
            tmpinpos = nexttmpinpos;
            for (int k = 0; k < cexcept; ++k) {
                final int pos = byteContainer.get() & 0xFF;
                out[pos + tmpoutpos] |= exceptionbuffer[k] << b;
            }

        }
        outpos.set(tmpoutpos);
        inpos.set(inexcept);
    }

    @Override
    public void compress(int[] in, IntWrapper inpos, int inlength, int[] out,
            IntWrapper outpos) {

        inlength = Util.greatestMultiple(inlength, BLOCK_SIZE);

        if (inlength == 0) {
            return;
        }

        out[outpos.get()] = inlength;
        outpos.increment();
        headlessCompress(in, inpos, inlength, out, outpos);
    }

    @Override
    public void uncompress(int[] in, IntWrapper inpos, int inlength, int[] out,
            IntWrapper outpos) {
        if (inlength == 0)
            return;
        final int outlength = in[inpos.get()];
        inpos.increment();
        headlessUncompress(in, inpos, inlength, out, outpos, outlength);
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName();
    }
}
