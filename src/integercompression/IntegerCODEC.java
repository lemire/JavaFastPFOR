/**
 * This is code is released under the
 * Apache License Version 2.0 http://www.apache.org/licenses/.
 *
 * (c) Daniel Lemire, http://lemire.me/en/
 */

package integercompression;

import java.util.concurrent.atomic.AtomicInteger;

public interface IntegerCODEC {
  /**
  * Both inpos and outpos are modified to represent how much
  * data was read and written to
  * if 12 ints (inlength = 12) are compressed to 3 ints, then
  * inpos will be incremented by 12 while outpos will be
  * incremented by 3
  * we use AtomicInteger to pass the values by reference.
  */
  public void compress(int[] in, AtomicInteger inpos, int inlength, int[] out, AtomicInteger outpos);

  // returns how many integers we decompressed
  public void uncompress(int[] in, AtomicInteger inpos, int inlength, int[] out, AtomicInteger outpos);

  
}
