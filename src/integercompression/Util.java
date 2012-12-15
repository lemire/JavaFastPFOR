/**
 * This is code is released under the
 * Apache License Version 2.0 http://www.apache.org/licenses/.
 *
 * (c) Daniel Lemire, http://lemire.me/en/
 */
package integercompression;

public class Util {
  public static int maxbits(int[] i, int pos, int length) {
    int mask = 0;
    for (int k = pos; k < pos + length; ++k)
      mask |= i[k];
    return bits(mask);
  }
  public static int maxdiffbits(int initoffset, int[] i, int pos, int length) {
	    int mask = 0;
	    mask |= (i[pos] - initoffset);
	    for (int k = pos+1; k < pos + length; ++k) {
	      mask |= i[k] - i[k-1];
	    }
	    return bits(mask);
  }

  public static int bits(int i) {
    return 32 - Integer.numberOfLeadingZeros(i);
  }
  
  public static void assertTrue(boolean b) {
    if(!b) throw new RuntimeException("bug!");
  }

  public static void assertTrue(boolean b, String message) {
    if(!b) throw new RuntimeException(message);
  }

}
