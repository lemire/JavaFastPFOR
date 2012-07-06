/**
 * This is code is released under the
 * Apache License Version 2.0 http://www.apache.org/licenses/.
 *
 * (c) Daniel Lemire, http://lemire.me/en/
 */

package integercompression;

import java.util.concurrent.atomic.AtomicInteger;

public final class JustCopy implements IntegerCODEC {

  public void compress(int[] in, AtomicInteger inpos, int inlength, int[] out, AtomicInteger outpos) {
    System.arraycopy(in, inpos.intValue(), out, outpos.intValue(), inlength);
    inpos.addAndGet(inlength);
    outpos.addAndGet(inlength);
  }

  public void uncompress(int[] in, AtomicInteger inpos, int inlength, int[] out, AtomicInteger outpos) {
    System.arraycopy(in, inpos.intValue(), out, outpos.intValue(), inlength);
    inpos.addAndGet(inlength);
    outpos.addAndGet(inlength);
  }
  
  
  
  public String toString() {
    return this.getClass().getName();
  }


}
