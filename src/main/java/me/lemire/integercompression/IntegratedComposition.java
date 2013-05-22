/**
 * This code is released under the
 * Apache License Version 2.0 http://www.apache.org/licenses/.
 *
 * (c) Daniel Lemire, http://lemire.me/en/
 */
package me.lemire.integercompression;

/**
 * Helper class to compose schemes.
 *
 * @author Daniel Lemire
 */
public class IntegratedComposition implements IntegratedIntegerCODEC {
    IntegratedIntegerCODEC F1, F2;

    public IntegratedComposition(IntegratedIntegerCODEC f1, IntegratedIntegerCODEC f2) {
        F1 = f1;
        F2 = f2;
    }

    @Override
    public void compress(int[] in, IntWrapper inpos, int inlength, int[] out,
                         IntWrapper outpos) {
        int init = inpos.get();
        F1.compress(in, inpos, inlength, out, outpos);
        inlength -= inpos.get() - init;
        F2.compress(in, inpos, inlength, out, outpos);
    }

    @Override
    public void uncompress(int[] in, IntWrapper inpos, int inlength, int[] out,
                           IntWrapper outpos) {
        int init = inpos.get();
        F1.uncompress(in, inpos, inlength, out, outpos);
        inlength -= inpos.get() - init;
        F2.uncompress(in, inpos, inlength, out, outpos);
    }

    @Override
    public String toString() {
        return F1.getClass().getName() + "+" + F2.getClass().getName();
    }

}
