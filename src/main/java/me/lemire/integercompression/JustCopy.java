/**
 * This code is released under the
 * Apache License Version 2.0 http://www.apache.org/licenses/.
 *
 * (c) Daniel Lemire, http://lemire.me/en/
 */

package me.lemire.integercompression;


/**
 * @author Daniel Lemire
 * 
 */
public final class JustCopy implements IntegerCODEC, SkippableIntegerCODEC {

        @Override
        public void headlessCompress(int[] in, IntWrapper inpos, int inlength,
                int[] out, IntWrapper outpos) {
                System.arraycopy(in, inpos.get(), out, outpos.get(), inlength);
                inpos.add(inlength);
                outpos.add(inlength);
        }

        @Override
        public void uncompress(int[] in, IntWrapper inpos, int inlength,
                int[] out, IntWrapper outpos) {
            headlessUncompress(in,inpos,inlength,out,outpos,inlength);
        }

        @Override
        public String toString() {
                return this.getClass().getSimpleName();
        }

        @Override
        public void headlessUncompress(int[] in, IntWrapper inpos, int inlength,
                int[] out, IntWrapper outpos, int num) {
            System.arraycopy(in, inpos.get(), out, outpos.get(), num);
            inpos.add(num);
            outpos.add(num);
            
        }

        @Override
        public void compress(int[] in, IntWrapper inpos, int inlength,
                int[] out, IntWrapper outpos) {
            headlessCompress(in,inpos,inlength,out,outpos);
        }

}
