/**
 * This is code is released under the
 * Apache License Version 2.0 http://www.apache.org/licenses/.
 *
 * (c) Daniel Lemire, http://lemire.me/en/
 */
package integercompression;

import java.nio.ByteBuffer;
import java.nio.IntBuffer;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Implementation of variable-byte. Possibly inefficient.
 * 
 * @author Daniel Lemire
 * 
 */
public class VariableByte implements IntegerCODEC {
  public void compress(int[] in, AtomicInteger inpos, int inlength, int[] out,
    AtomicInteger outpos) {
    ByteBuffer buf = ByteBuffer.allocateDirect(inlength * 5);
    for (int k = inpos.get(); k < inpos.get() + inlength; ++k) {
      for (int val = in[k]; val != 0;) {
        int b = (val & 127);
        val >>>= 7;
        if (val != 0) {
          b |= 128;
        }
        buf.put((byte) b);
      }
    }
    while (buf.position() % 4 != 0)
      buf.put((byte) 128);
    final int length = buf.position();
    buf.flip();
    IntBuffer ibuf = buf.asIntBuffer();
    ibuf.get(out, outpos.get(), length / 4);
    outpos.addAndGet(length / 4);
    inpos.addAndGet(inlength);
  }

  public void uncompress(int[] in, AtomicInteger inpos, int inlength,
    int[] out, AtomicInteger outpos) {
    int s = 0;
    int p = inpos.get();
    int finalp = inpos.get() + inlength;
    int tmpoutpos = outpos.get();
    for (int v = 0, shift = 0; p<finalp;) {
      int c = (byte)(in[p] >>> (24-s));
      s+=8; if(s == 32) {s = 0; p++;}
      v += ((c & 127) << shift);
      if ((c & 128) == 0) {
        out[tmpoutpos++] = v;
        v = 0;
        shift = 0;
      } else
        shift += 7;
    }
    outpos.set(tmpoutpos);
    inpos.addAndGet(inlength);
  }

  public String toString() {
    return this.getClass().getName();
  }

}
