/**
 * This code is released under the
 * Apache License Version 2.0 http://www.apache.org/licenses/.
 */
package me.lemire.integercompression;

public class BinaryPacking160 implements IntegerCODEC
{
    public final static int CHUNK_SIZE = 160;

    @Override
    public void compress(
            int[] in, IntWrapper inpos, int inlength,
            int[] out, IntWrapper outpos)
    {
        inlength = inlength - inlength % CHUNK_SIZE;
        if (inlength == 0) {
            return;
        }

        int op = outpos.get();
        out[op++] = inlength;
        for (int ip = inpos.get(); ip < inpos.get() + inlength;
                ip += CHUNK_SIZE)
        {
            final int mbits1 = Util.maxbits32(in, ip +   0);
            final int mbits2 = Util.maxbits32(in, ip +  32);
            final int mbits3 = Util.maxbits32(in, ip +  64);
            final int mbits4 = Util.maxbits32(in, ip +  96);
            final int mbits5 = Util.maxbits32(in, ip + 128);

            out[op++] = (mbits1 << 24) | (mbits2 << 18) | (mbits3 << 12)
                | (mbits4 << 6) | (mbits5 << 0);

            BitPacking.fastpackwithoutmask(in, ip +   0, out, op, mbits1);
            op += mbits1;
            BitPacking.fastpackwithoutmask(in, ip +  32, out, op, mbits2);
            op += mbits2;
            BitPacking.fastpackwithoutmask(in, ip +  64, out, op, mbits3);
            op += mbits3;
            BitPacking.fastpackwithoutmask(in, ip +  96, out, op, mbits4);
            op += mbits4;
            BitPacking.fastpackwithoutmask(in, ip + 128, out, op, mbits5);
            op += mbits5;
        }
        inpos.add(inlength);
        outpos.set(op);
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
        for (int s = outpos.get(), e = s + outlength; s < e; s += CHUNK_SIZE)
        {
            int head = in[tmpinpos++];
            final int mbits1 = (head >> 24) & 0x3F;
            final int mbits2 = (head >> 18) & 0x3F;
            final int mbits3 = (head >> 12) & 0x3F;
            final int mbits4 = (head >>  6) & 0x3F;
            final int mbits5 = (head >>  0) & 0x3F;
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
