/**
 * This code is released under the
 * Apache License Version 2.0 http://www.apache.org/licenses/.
 *
 * (c) Daniel Lemire, http://lemire.me/en/
 */

package me.lemire.integercompression.differential;

import me.lemire.integercompression.BitPacking;
import me.lemire.integercompression.IntWrapper;
import me.lemire.integercompression.Util;

/**
 * Scheme based on a commonly used idea: can be extremely fast.
 * 
 * You should only use this scheme on sorted arrays. Use BinaryPacking if you
 * have unsorted arrays.
 * 
 * It encodes integers in blocks of 32 integers. For arrays containing an
 * arbitrary number of integers, you should use it in conjunction with another
 * CODEC:
 * 
 * <pre>
 * IntegratedIntegerCODEC is = 
 * new IntegratedComposition(new IntegratedBinaryPacking(), 
 * new IntegratedVariableByte())
 * </pre>
 * 
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
 * Daniel Lemire, Leonid Boytsov, Nathan Kurz, SIMD Compression and the
 * Intersection of Sorted Integers <a
 * href="http://arxiv.org/abs/1401.6399">http://arxiv.org/abs/1401.6399</a>
 * </p>
 * 
 * @author Daniel Lemire
 * 
 */
public class IntegratedBinaryPacking implements IntegratedIntegerCODEC,
        SkippableIntegratedIntegerCODEC {

    static final int BLOCK_SIZE = 32;

    @Override
    public void compress(int[] in, IntWrapper inpos, int inlength, int[] out,
            IntWrapper outpos) {
        inlength = Util.greatestMultiple(inlength, BLOCK_SIZE);
        if (inlength == 0)
            return;
        out[outpos.get()] = inlength;
        outpos.increment();
        headlessCompress(in, inpos, inlength, out, outpos, new IntWrapper(0));
    }

    @Override
    public void uncompress(int[] in, IntWrapper inpos, int inlength, int[] out,
            IntWrapper outpos) {
        if (inlength == 0)
            return;
        final int outlength = in[inpos.get()];
        inpos.increment();
        headlessUncompress(in,inpos,inlength,out,outpos,outlength, new IntWrapper(0));
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName();
    }

    @Override
    public void headlessCompress(int[] in, IntWrapper inpos, int inlength,
            int[] out, IntWrapper outpos, IntWrapper initvalue) {
        inlength = Util.greatestMultiple(inlength, BLOCK_SIZE);
        if (inlength == 0)
            return;
        int tmpoutpos = outpos.get();

        int initoffset = initvalue.get();
        initvalue.set(in[inpos.get()+inlength -1]);
        int s = inpos.get();
        for (; s + BLOCK_SIZE * 4 - 1 < inpos.get() + inlength; s += BLOCK_SIZE * 4) {
            final int mbits1 = Util.maxdiffbits(initoffset, in, s, BLOCK_SIZE);
            int initoffset2 = in[s + 31];
            final int mbits2 = Util.maxdiffbits(initoffset2, in, s + BLOCK_SIZE, BLOCK_SIZE);
            int initoffset3 = in[s + BLOCK_SIZE + 31];
            final int mbits3 = Util
                    .maxdiffbits(initoffset3, in, s + 2 * BLOCK_SIZE, BLOCK_SIZE);
            int initoffset4 = in[s + 2 * BLOCK_SIZE + 31];
            final int mbits4 = Util
                    .maxdiffbits(initoffset4, in, s + 3 * BLOCK_SIZE, BLOCK_SIZE);
            out[tmpoutpos++] = (mbits1 << 24) | (mbits2 << 16) | (mbits3 << 8)
                    | (mbits4);
            IntegratedBitPacking.integratedpack(initoffset, in, s, out,
                    tmpoutpos, mbits1);
            tmpoutpos += mbits1;
            IntegratedBitPacking.integratedpack(initoffset2, in, s + BLOCK_SIZE, out,
                    tmpoutpos, mbits2);
            tmpoutpos += mbits2;
            IntegratedBitPacking.integratedpack(initoffset3, in, s + 2 * BLOCK_SIZE,
                    out, tmpoutpos, mbits3);
            tmpoutpos += mbits3;
            IntegratedBitPacking.integratedpack(initoffset4, in, s + 3 * BLOCK_SIZE,
                    out, tmpoutpos, mbits4);
            tmpoutpos += mbits4;
            initoffset = in[s + 3 * BLOCK_SIZE + 31];
        }
        for (; s < inpos.get() + inlength; s += BLOCK_SIZE ) {
            final int mbits = Util.maxdiffbits(initoffset, in, s, BLOCK_SIZE);
            out[tmpoutpos++] = mbits;
            IntegratedBitPacking.integratedpack(initoffset, in, s, out,
                    tmpoutpos, mbits);
            tmpoutpos += mbits;
            initoffset = in[s + 31];
        }
        inpos.add(inlength);
        outpos.set(tmpoutpos);
    }

    @Override
    public void headlessUncompress(int[] in, IntWrapper inpos, int inlength,
            int[] out, IntWrapper outpos, int num, IntWrapper initvalue) {
        final int outlength = Util.greatestMultiple(num, BLOCK_SIZE);
        int tmpinpos = inpos.get();
        int initoffset = initvalue.get();
        int s = outpos.get();
        for (; s + BLOCK_SIZE * 4 - 1 < outpos.get() + outlength; s += BLOCK_SIZE * 4) {
            final int mbits1 = (in[tmpinpos] >>> 24);
            final int mbits2 = (in[tmpinpos] >>> 16) & 0xFF;
            final int mbits3 = (in[tmpinpos] >>> 8) & 0xFF;
            final int mbits4 = (in[tmpinpos]) & 0xFF;

            ++tmpinpos;
            IntegratedBitPacking.integratedunpack(initoffset, in, tmpinpos,
                    out, s, mbits1);
            tmpinpos += mbits1;
            initoffset = out[s + 31];
            IntegratedBitPacking.integratedunpack(initoffset, in, tmpinpos,
                    out, s + BLOCK_SIZE, mbits2);
            tmpinpos += mbits2;
            initoffset = out[s + BLOCK_SIZE + 31];
            IntegratedBitPacking.integratedunpack(initoffset, in, tmpinpos,
                    out, s + 2 * BLOCK_SIZE, mbits3);
            tmpinpos += mbits3;
            initoffset = out[s + 2 * BLOCK_SIZE + 31];
            IntegratedBitPacking.integratedunpack(initoffset, in, tmpinpos,
                    out, s + 3 * BLOCK_SIZE, mbits4);
            tmpinpos += mbits4;
            initoffset = out[s + 3 * BLOCK_SIZE + 31];
        }
        for (; s < outpos.get() + outlength; s += BLOCK_SIZE) {
            final int mbits = in[tmpinpos];
            ++tmpinpos;
            IntegratedBitPacking.integratedunpack(initoffset, in, tmpinpos,
                    out, s, mbits);
            initoffset = out[s + 31];

            tmpinpos += mbits;
        }
        outpos.add(outlength);
        initvalue.set(initoffset);
        inpos.set(tmpinpos);
    }
}
