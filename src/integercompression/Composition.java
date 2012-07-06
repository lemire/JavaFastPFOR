/**
 * This is code is released under the
 * Apache License Version 2.0 http://www.apache.org/licenses/.
 *
 * (c) Daniel Lemire, http://lemire.me/en/
 */
package integercompression;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Helper class to compose schemes.
 * 
 * @author Daniel Lemire
 */
public class Composition implements IntegerCODEC{
  IntegerCODEC F1, F2;
  public Composition(IntegerCODEC f1, IntegerCODEC f2) {F1 = f1; F2= f2;}

  public void compress(int[] in, AtomicInteger inpos, int inlength, int[] out,
    AtomicInteger outpos) {
    int init = inpos.get();
    F1.compress(in, inpos, inlength, out, outpos);
    inlength -=  inpos.get() - init;
    F2.compress(in, inpos, inlength, out, outpos);
  }

  public void uncompress(int[] in, AtomicInteger inpos, int inlength,
    int[] out, AtomicInteger outpos) {
    int init = inpos.get();
    F1.uncompress(in, inpos, inlength, out, outpos);
    inlength -=  inpos.get() - init;
    F2.uncompress(in, inpos, inlength, out, outpos);    
  }
  

  public String toString() {
    return F1.getClass().getName()+"+"+F2.getClass().getName();
  }

}
