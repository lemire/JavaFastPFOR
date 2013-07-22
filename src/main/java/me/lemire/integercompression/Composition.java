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
public class Composition implements IntegerCODEC {
    IntegerCODEC F1, F2;

    /**
     * Compose a scheme from a first one (f1) and a second one (f2).
     * The first one is called first and then the second one tries to
     * compress whatever remains from the first run.
     * 
     * @param f1 first codec
     * @param f2 second codec
     */
    public Composition(IntegerCODEC f1, IntegerCODEC f2) {
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
    public void uncompress(int[] in, IntWrapper inpos, int inlength,
                           int[] out, IntWrapper outpos) {
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
