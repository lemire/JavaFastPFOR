/**
 * This code is released under the
 * Apache License Version 2.0 http://www.apache.org/licenses/.
 *
 * (c) Daniel Lemire, http://lemire.me/en/
 */

package me.lemire.longcompression;

import me.lemire.integercompression.IntWrapper;

/**
 * @author Benoit lacelle
 * 
 */
public final class LongJustCopy implements LongCODEC, SkippableLongCODEC {

        @Override
        public void headlessCompress(long[] in, IntWrapper inpos, int inlength,
        		long[] out, IntWrapper outpos) {
                System.arraycopy(in, inpos.get(), out, outpos.get(), inlength);
                inpos.add(inlength);
                outpos.add(inlength);
        }

        @Override
        public void uncompress(long[] in, IntWrapper inpos, int inlength,
        		long[] out, IntWrapper outpos) {
            headlessUncompress(in,inpos,inlength,out,outpos,inlength);
        }

        @Override
        public String toString() {
                return this.getClass().getSimpleName();
        }

        @Override
        public void headlessUncompress(long[] in, IntWrapper inpos, int inlength,
        		long[] out, IntWrapper outpos, int num) {
            System.arraycopy(in, inpos.get(), out, outpos.get(), num);
            inpos.add(num);
            outpos.add(num);
            
        }

        @Override
        public void compress(long[] in, IntWrapper inpos, int inlength,
        		long[] out, IntWrapper outpos) {
            headlessCompress(in,inpos,inlength,out,outpos);
        }

}
