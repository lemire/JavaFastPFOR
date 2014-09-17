package me.lemire.integercompression;

import com.kamikaze.pfordelta.PForDelta;

/**
 * IntegerCODEC wrapper for Kamikaze's PForDelta.
 * 
 * Note: this class is only included for speed benchmarks.
 * It is not recommended. Use at your own risks.
 * 
 * @author Matteo Catena
 * 
 */
public class Kamikaze implements SkippableIntegerCODEC, IntegerCODEC {

    private int BLOCK_SIZE = 128;

    @Override
    public void headlessCompress(int[] in, IntWrapper inpos, int inlength, int[] out,
            IntWrapper outpos) {
        inlength = Util.greatestMultiple(inlength, BLOCK_SIZE);
        if (inlength > 0) {
            int[] out2 = PForDelta.compressOneBlockOpt(in, inlength);
            inpos.add(inlength);
            System.arraycopy(out2, 0, out, outpos.get(), out2.length);
            outpos.add(out2.length);
        }
    }

    @Override
    public void headlessUncompress(int[] in, IntWrapper inpos, int inlength, int[] out,
            IntWrapper outpos, int num) {
        num = Util.greatestMultiple(num, BLOCK_SIZE);
        if (num > 0) {
            int d = PForDelta.decompressOneBlock(out, in, num);
            inpos.add(d / 32);
            outpos.add(num);
        }
    }

    @Override
    public String toString() {
        return "Kamikaze's PForDelta";
    }

    @Override
    public void compress(int[] in, IntWrapper inpos, int inlength, int[] out,
            IntWrapper outpos) {
        inlength = Util.greatestMultiple(inlength, BLOCK_SIZE);
        if (inlength == 0)
                return;
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
}