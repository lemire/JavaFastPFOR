/**
 * This is code is released under the
 * Apache License Version 2.0 http://www.apache.org/licenses/.
 *
 * (c) Daniel Lemire, http://lemire.me/en/
 */
package integercompression;

import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * This is a new PFOR Scheme designed by D. Lemire called FastPFOR.
 * 
 * For sufficiently compressible arrays, it is faster and better than other PFOR
 * schemes.
 * 
 * @author Daniel Lemire
 */
public final class FastPFOR implements IntegerCODEC {
  int PageSize;
  final static int BlockSize = 128;
  final static int overheadofeachexcept = 8;

  int[][] datatobepacked = new int[32][];
  ByteBuffer bytecontainer;

  public FastPFOR(int pagesize) {
    PageSize = pagesize;
    initArrays();
  }

  public FastPFOR() {
    PageSize = 65536;
    initArrays();
  }

  public void initArrays() {
    bytecontainer = ByteBuffer.allocateDirect(3 * PageSize / BlockSize
      + PageSize);
    for (int k = 1; k < 32; ++k)
      datatobepacked[k] = new int[PageSize / 32 * 4];// heuristic
  }

  public void compress(int[] in, AtomicInteger inpos, int inlength, int[] out,
    AtomicInteger outpos) {
    Util.assertTrue(inpos.get()+inlength <= in.length);
    inlength = inlength / 128 * 128;

    final int finalinpos = inpos.get() + inlength;
    out[outpos.get()] = inlength;
    outpos.incrementAndGet();
    while (inpos.get() != finalinpos) {
      int thissize = finalinpos > PageSize + inpos.get() ? PageSize
        : (finalinpos - inpos.get());
      encodePage(in, inpos, thissize, out, outpos);
    }
  }

  public static void getBestBFromData(int[] in, int pos, byte[] bestbbestcexceptmaxb) {
    int freqs[] = new int[32];
    for (int k = pos; k < BlockSize + pos; ++k)
      freqs[Util.bits(in[k])]++;
    bestbbestcexceptmaxb[0] = 31;
    while (freqs[bestbbestcexceptmaxb[0]] == 0)
      bestbbestcexceptmaxb[0]--;
    bestbbestcexceptmaxb[2] = bestbbestcexceptmaxb[0];
    int bestcost = bestbbestcexceptmaxb[0] * BlockSize;
    byte cexcept = 0;
    bestbbestcexceptmaxb[1] = cexcept;
    for (int b = bestbbestcexceptmaxb[0] - 1; b >= 0; --b) {
      cexcept += freqs[b + 1];
      if (cexcept < 0)
        break;
      int thiscost = cexcept * overheadofeachexcept + cexcept
        * (bestbbestcexceptmaxb[2] - b) + b * BlockSize  + 8;// the  extra 8 is the cost of storing maxbits
      if (thiscost < bestcost) {
        bestcost = thiscost;
        bestbbestcexceptmaxb[0] = (byte) b;
        bestbbestcexceptmaxb[1] = cexcept;
      }
    }
  }

  private void encodePage(int[] in, AtomicInteger inpos, int thissize,
    int[] out, AtomicInteger outpos) {
    final int headerpos = outpos.getAndIncrement();
    int tmpoutpos = outpos.get();
    int[] datapointers = new int[32];
    bytecontainer.clear();
    final byte[] bestbbestcexceptmaxb = new byte[3];
    int tmpinpos = inpos.get();
    for (final int finalinpos = tmpinpos + thissize; tmpinpos
      + BlockSize <= finalinpos; tmpinpos+=BlockSize) {
      getBestBFromData(in, tmpinpos, bestbbestcexceptmaxb);
      final int tmpbestb = bestbbestcexceptmaxb[0];
      bytecontainer.put(bestbbestcexceptmaxb[0]);
      bytecontainer.put(bestbbestcexceptmaxb[1]);
      if (bestbbestcexceptmaxb[1] > 0) {
        bytecontainer.put(bestbbestcexceptmaxb[2]);
        final int index = bestbbestcexceptmaxb[2] - bestbbestcexceptmaxb[0];
        if (datapointers[index] + bestbbestcexceptmaxb[1] >= datatobepacked[index].length) {
          int newsize = 2 * (datapointers[index] + bestbbestcexceptmaxb[1]);
          newsize = (newsize + 31) / 32 * 32;// make sure it is a multiple of
                                             // 32
          datatobepacked[index] = Arrays.copyOf(datatobepacked[index], newsize);
        }
        final int maxval = 1 << bestbbestcexceptmaxb[0];
        for (int k = 0; k < BlockSize; ++k) {
          if (in[k + tmpinpos] >= maxval) {
            // we have an exception
            bytecontainer.put((byte) k);
            datatobepacked[index][datapointers[index]++] = in[k
              + tmpinpos] >>> tmpbestb;
          }
        }
      }
      for (int k = 0; k < 128; k += 32) {
        BitPacking.fastpack(in, tmpinpos + k, out,tmpoutpos, tmpbestb);
        tmpoutpos += tmpbestb;
      }
    }
    inpos.set(tmpinpos);
    out[headerpos] = tmpoutpos - headerpos;
    while ((bytecontainer.position() & 3) != 0)
      bytecontainer.put((byte) 0);
    final int bytesize = bytecontainer.position();
    out[tmpoutpos++] = bytesize;
    final int howmanyints = bytesize / 4;
    bytecontainer.flip();
    bytecontainer.asIntBuffer().get(out, tmpoutpos, howmanyints);
    tmpoutpos+=howmanyints;
    int bitmap = 0;
    for (int k = 1; k <= 31; ++k) {
      if (datapointers[k] != 0)
        bitmap |= (1 << (k - 1));
    }
    out[tmpoutpos++] = bitmap;
    for (int k = 1; k <= 31; ++k) {

      if (datapointers[k] != 0) {
        out[tmpoutpos++] = datapointers[k];// size
        for (int j = 0; j < datapointers[k]; j += 32) {
          BitPacking
            .fastpack(datatobepacked[k], j, out, tmpoutpos, k);
          tmpoutpos+=k;
        }
      }
    }
    outpos.set(tmpoutpos);
  }

  public void uncompress(int[] in, AtomicInteger inpos, int inlength,
    int[] out, AtomicInteger outpos) {
    Util.assertTrue(inpos.get()+inlength <= in.length);
    int mynvalue = in[inpos.get()];
    inpos.incrementAndGet();
    int finalout = outpos.get() + mynvalue;
    while (outpos.get() != finalout) {
      int thissize = finalout > PageSize + outpos.get() ? PageSize
        : (finalout - outpos.get());
      decodePage(in, inpos, out, outpos, thissize);
    }
  }

  private void decodePage(int[] in, AtomicInteger inpos, int[] out,
    AtomicInteger outpos, int thissize) {
    final int initpos = inpos.get();
    final int wheremeta = in[inpos.getAndIncrement()];
    int inexcept = initpos + wheremeta;
    final int bytesize = in[inexcept++];
    bytecontainer.clear();
    Util.assertTrue((bytesize & 3) == 0);
    bytecontainer.asIntBuffer().put(in, inexcept, bytesize / 4);
    inexcept += bytesize / 4;

    final int bitmap = in[inexcept++];
    for (int k = 1; k <= 31; ++k) {
      if ((bitmap & (1 << (k - 1))) != 0) {
        int size = in[inexcept++];
        if (datatobepacked[k].length < size)
          datatobepacked[k] = new int[(size + 31) / 32 * 32];
        for (int j = 0; j < size; j += 32) {
          BitPacking.fastunpack(in, inexcept, datatobepacked[k], j, k);
          inexcept += k;
        }
      }
    }
    int[] datapointers = new int[32];
    int tmpoutpos = outpos.get();
    int tmpinpos = inpos.get();

    for (int run = 0; run < thissize / BlockSize; ++run, tmpoutpos += BlockSize) {
      final byte b = bytecontainer.get();
      final byte cexcept = bytecontainer.get();
      for (int k = 0; k < 128; k += 32) {
        BitPacking.fastunpack(in, tmpinpos, out, tmpoutpos + k, b);
        tmpinpos += b;
      }
      if (cexcept > 0) {
        final byte maxbits = bytecontainer.get();
        final int index = maxbits - b;
        for (int k = 0; k < cexcept; ++k) {
          final byte pos = bytecontainer.get();
          final int exceptvalue = datatobepacked[index][datapointers[index]++];
          out[pos + tmpoutpos] |= exceptvalue << b;
        }

      }
    }
    outpos.set(tmpoutpos);
    inpos.set(inexcept);
  }

  public String toString() {
    return this.getClass().getName();
  }
}
