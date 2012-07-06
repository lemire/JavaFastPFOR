/**
 * This is code is released under the
 * Apache License Version 2.0 http://www.apache.org/licenses/.
 *
 * (c) Daniel Lemire, http://lemire.me/en/
 */
package integercompression;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Scheme designed by D. Lemire
 * @author Daniel Lemire
 *
 */
public final class BinaryPacking implements IntegerCODEC {

  public void compress(int[] in, AtomicInteger inpos, int inlength, int[] out, AtomicInteger outpos) {

    inlength = inlength / 128 * 128;

    out[outpos.intValue()] = inlength;
    outpos.incrementAndGet();
    int tmpoutpos = outpos.intValue();
    for (int s = inpos.intValue(); s < inpos.intValue() + inlength; s += 32 * 4) {
      final int mbits1 = Util.maxbits(in, s, 32);
      final int mbits2 = Util.maxbits(in, s + 32, 32);
      final int mbits3 = Util.maxbits(in, s + 2 * 32, 32);
      final int mbits4 = Util.maxbits(in, s + 3 * 32, 32);
      out[tmpoutpos++] = (mbits1 << 24) | (mbits2 << 16) | (mbits3 << 8)
        | (mbits4);
      BitPacking.fastpackwithoutmask(in, s, out, tmpoutpos, mbits1);
      tmpoutpos += mbits1;
      BitPacking.fastpackwithoutmask(in, s + 32, out, tmpoutpos, mbits2);
      tmpoutpos += mbits2;
      BitPacking.fastpackwithoutmask(in, s + 2 * 32, out, tmpoutpos, mbits3);
      tmpoutpos += mbits3;
      BitPacking.fastpackwithoutmask(in, s + 3 * 32, out, tmpoutpos, mbits4);
      tmpoutpos += mbits4;
    }
    inpos.addAndGet(inlength);
    outpos.set(tmpoutpos);
  }

  public void uncompress(int[] in, AtomicInteger inpos, int inlength, int[] out, AtomicInteger outpos) {
    final int outlength = in[inpos.intValue()];
    inpos.incrementAndGet();
    int tmpinpos = inpos.intValue();
    for (int s = outpos.intValue(); s < outpos.intValue() + outlength; s += 32 * 4) {
      final int mbits1 = (in[tmpinpos] >>> 24);
      final int mbits2 = (in[tmpinpos] >>> 16) & 0xFF;
      final int mbits3 = (in[tmpinpos] >>> 8) & 0xFF;
      final int mbits4 = (in[tmpinpos]) & 0xFF;
      ++tmpinpos;
      BitPacking.fastunpack(in, tmpinpos, out, s, mbits1);
      tmpinpos += mbits1;
      BitPacking.fastunpack(in, tmpinpos, out, s + 32, mbits2);
      tmpinpos += mbits2;
      BitPacking.fastunpack(in, tmpinpos, out, s + 2 * 32, mbits3);
      tmpinpos += mbits3;
      BitPacking.fastunpack(in, tmpinpos, out, s + 3 * 32, mbits4);
      tmpinpos += mbits4;
    }
    outpos.addAndGet(outlength);
    inpos.set(tmpinpos);
  }

}
