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
         * Compose a scheme from a first one (f1) and a second one (f2). The
         * first one is called first and then the second one tries to compress
         * whatever remains from the first run.
         * 
         * By convention, the first scheme should be such that if, during
         * decoding, a 32-bit zero is first encountered, then there is no
         * output.
         * 
         * @param f1
         *                first codec
         * @param f2
         *                second codec
         */
        public Composition(IntegerCODEC f1, IntegerCODEC f2) {
                F1 = f1;
                F2 = f2;
        }

        @Override
        public void compress(int[] in, IntWrapper inpos, int inlength,
                int[] out, IntWrapper outpos) {
            if (inlength == 0) {
                return;
            }
            int inposInit = inpos.get();
            int outposInit = outpos.get();
            F1.compress(in, inpos, inlength, out, outpos);
            if (outpos.get() == outposInit) {
                out[outposInit] = 0;
                outpos.increment();
            }
            inlength -= inpos.get() - inposInit;
            F2.compress(in, inpos, inlength, out, outpos);
        }

        @Override
        public void uncompress(int[] in, IntWrapper inpos, int inlength,
                int[] out, IntWrapper outpos) {
                if (inlength == 0)
                        return;
                final int init = inpos.get();
                F1.uncompress(in, inpos, inlength, out, outpos);
                inlength -= inpos.get() - init;
                F2.uncompress(in, inpos, inlength, out, outpos);
        }

        @Override
        public String toString() {
                return F1.toString() + " + " + F2.toString();
        }

}
