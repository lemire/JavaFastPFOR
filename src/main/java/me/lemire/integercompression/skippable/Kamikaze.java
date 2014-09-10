package me.lemire.integercompression.skippable;

import me.lemire.integercompression.IntWrapper;
import com.kamikaze.pfordelta.PForDelta;

/**
 * IntegerCODEC wrapper for Kamikaze's PForDelta.
 * 
 * 
 * @author Matteo Catena
 * 
 */
public class Kamikaze implements SkippableIntegerCODEC {

    private int BLOCK_SIZE = 128;

    @Override
    public void compress(int[] in, IntWrapper inpos, int inlength, int[] out,
            IntWrapper outpos) {

        inlength = inlength / BLOCK_SIZE * BLOCK_SIZE;
        if (inlength > 0) {
            int[] out2 = PForDelta.compressOneBlockOpt(in, inlength);
            inpos.add(inlength);
            System.arraycopy(out2, 0, out, outpos.get(), out2.length);
            outpos.add(out2.length);
        }
    }

    @Override
    public void uncompress(int[] in, IntWrapper inpos, int inlength, int[] out,
            IntWrapper outpos, int num) {

        num = num / BLOCK_SIZE * BLOCK_SIZE;
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
}