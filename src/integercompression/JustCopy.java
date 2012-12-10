/**
 * This is code is released under the
 * Apache License Version 2.0 http://www.apache.org/licenses/.
 *
 * (c) Daniel Lemire, http://lemire.me/en/
 */

package integercompression;


public final class JustCopy implements IntegerCODEC {

  public void compress(int[] in, IntWrapper inpos, int inlength, int[] out, IntWrapper outpos) {
    // Util.assertTrue(inpos.get()+inlength <= in.length);
    System.arraycopy(in, inpos.get(), out, outpos.get(), inlength);
    inpos.add(inlength);
    outpos.add(inlength);
  }

  public void uncompress(int[] in, IntWrapper inpos, int inlength, int[] out, IntWrapper outpos) {
    // Util.assertTrue(inpos.get()+inlength <= in.length);
    System.arraycopy(in, inpos.get(), out, outpos.get(), inlength);
    inpos.add(inlength);
    outpos.add(inlength);
  }
  
  
  
  public String toString() {
    return this.getClass().getName();
  }


}
