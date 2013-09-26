package me.lemire.integercompression;

public class BinaryPacking160 implements IntegerCODEC
{

    @Override
    public void compress(
            int[] in, IntWrapper inpos, int inlength,
            int[] out, IntWrapper outpos)
    {
        inlength = inlength - inlength % 160;
        if (inlength == 0) {
            return;
        }

        out[outpos.get()] = inlength;
        outpos.increment();
        int tmpoutpos = outpos.get();
        for (int s = inpos.get(); s < inpos.get() + inlength; s += 32 * 5) {
            final int mbits1 = Util.maxbits32(in, s +   0);
            final int mbits2 = Util.maxbits32(in, s +  32);
            final int mbits3 = Util.maxbits32(in, s +  64);
            final int mbits4 = Util.maxbits32(in, s +  96);
            final int mbits5 = Util.maxbits32(in, s + 128);

            out[tmpoutpos++] = (mbits1 << 24) | (mbits2 << 18) | (mbits3 << 12)
                | (mbits4 << 6) | (mbits5 << 0);

            BitPacking.fastpackwithoutmask(in, s +   0, out, tmpoutpos, mbits1);
            tmpoutpos += mbits1;
            BitPacking.fastpackwithoutmask(in, s +  32, out, tmpoutpos, mbits2);
            tmpoutpos += mbits2;
            BitPacking.fastpackwithoutmask(in, s +  64, out, tmpoutpos, mbits3);
            tmpoutpos += mbits3;
            BitPacking.fastpackwithoutmask(in, s +  96, out, tmpoutpos, mbits4);
            tmpoutpos += mbits4;
            BitPacking.fastpackwithoutmask(in, s + 128, out, tmpoutpos, mbits5);
            tmpoutpos += mbits5;
        }
        inpos.add(inlength);
        outpos.set(tmpoutpos);
    }


    @Override
    public void uncompress(
            int[] in, IntWrapper inpos, int inlength,
            int[] out, IntWrapper outpos)
    {
        if (inlength == 0) {
            return;
        }
        final int outlength = in[inpos.get()];
        inpos.increment();
        int tmpinpos = inpos.get();
        for (int s = outpos.get(); s < outpos.get() + outlength; s += 32 * 5) {
            int head = in[tmpinpos++];
            final int mbits1 = (head >>> 24) & 0x3F;
            final int mbits2 = (head >>> 18) & 0x3F;
            final int mbits3 = (head >>> 12) & 0x3F;
            final int mbits4 = (head >>>  6) & 0x3F;
            final int mbits5 = (head >>>  0) & 0x3F;
            BitPacking.fastunpack(in, tmpinpos, out, s +   0, mbits1);
            tmpinpos += mbits1;
            BitPacking.fastunpack(in, tmpinpos, out, s +  32, mbits2);
            tmpinpos += mbits2;
            BitPacking.fastunpack(in, tmpinpos, out, s +  64, mbits3);
            tmpinpos += mbits3;
            BitPacking.fastunpack(in, tmpinpos, out, s +  96, mbits4);
            tmpinpos += mbits4;
            BitPacking.fastunpack(in, tmpinpos, out, s + 128, mbits5);
            tmpinpos += mbits5;
        }
        outpos.add(outlength);
        inpos.set(tmpinpos);
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName();
    }
}
