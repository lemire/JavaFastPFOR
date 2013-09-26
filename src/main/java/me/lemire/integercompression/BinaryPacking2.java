/**
 * This code is released under the
 * Apache License Version 2.0 http://www.apache.org/licenses/.
 */
package me.lemire.integercompression;

public final class BinaryPacking2 extends BinaryPacking {

    @Override
    public void compress(
            int[] in, IntWrapper inpos, int inlength,
            int[] out, IntWrapper outpos)
    {
        inlength = inlength - inlength % 128;
        if (inlength == 0) {
            return;
        }

        out[outpos.get()] = inlength;
        outpos.increment();
        int tmpoutpos = outpos.get();
        for (int s = inpos.get(); s < inpos.get() + inlength; s += 32 * 4) {
            final int mbits1 = Util.maxbits32(in, s);
            final int mbits2 = Util.maxbits32(in, s + 32);
            final int mbits3 = Util.maxbits32(in, s + 2 * 32);
            final int mbits4 = Util.maxbits32(in, s + 3 * 32);
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
        inpos.add(inlength);
        outpos.set(tmpoutpos);
    }

}
