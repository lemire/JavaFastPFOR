package me.lemire.longcompression;

import me.lemire.integercompression.BinaryPacking;
import me.lemire.integercompression.IntWrapper;
import me.lemire.integercompression.Util;

/**
 * Scheme  based on a commonly used idea: can be extremely fast.
 * It encodes integers in blocks of 64 longs. For arrays containing
 * an arbitrary number of longs, you should use it in conjunction
 * with another CODEC: 
 * 
 *  <pre>LongCODEC ic = 
 *  new Composition(new LongBinaryPacking(), new LongVariableByte()).</pre>
 * 
 * Note that this does not use differential coding: if you are working on sorted
 * lists, you must compute the deltas separately.
 *
 * <p>
 * For details, please see {@link BinaryPacking}
 * </p>
 * 
 * @author Benoit Lacelle
 */
public final class LongBinaryPacking implements LongCODEC, SkippableLongCODEC {
        final static int BLOCK_SIZE = 64;
    
        @Override
        public void compress(long[] in, IntWrapper inpos, int inlength,
                long[] out, IntWrapper outpos) {
            inlength = Util.greatestMultiple(inlength, BLOCK_SIZE);
            if (inlength == 0)
                    return;
            out[outpos.get()] = inlength;
            outpos.increment();
            headlessCompress(in, inpos, inlength, out, outpos);
        }

        @Override
        public void headlessCompress(long[] in, IntWrapper inpos, int inlength,
                long[] out, IntWrapper outpos) {
            inlength = Util.greatestMultiple(inlength, BLOCK_SIZE);
            int tmpoutpos = outpos.get();
            int s = inpos.get();
            // Compress by block of 8 * 64 longs as much as possible
            for (; s + BLOCK_SIZE * 8 - 1 < inpos.get() + inlength; s += BLOCK_SIZE * 8) {
                // maxbits can be anything between 0 and 64 included: expressed within a byte (1 << 6)
                final long mbits1 = LongUtil.maxbits(in, s + 0 * BLOCK_SIZE, BLOCK_SIZE);
                final long mbits2 = LongUtil.maxbits(in, s + 1 * BLOCK_SIZE, BLOCK_SIZE);
                final long mbits3 = LongUtil.maxbits(in, s + 2 * BLOCK_SIZE, BLOCK_SIZE);
                final long mbits4 = LongUtil.maxbits(in, s + 3 * BLOCK_SIZE, BLOCK_SIZE);
                final long mbits5 = LongUtil.maxbits(in, s + 4 * BLOCK_SIZE, BLOCK_SIZE);
                final long mbits6 = LongUtil.maxbits(in, s + 5 * BLOCK_SIZE, BLOCK_SIZE);
                final long mbits7 = LongUtil.maxbits(in, s + 6 * BLOCK_SIZE, BLOCK_SIZE);
                final long mbits8 = LongUtil.maxbits(in, s + 7 * BLOCK_SIZE, BLOCK_SIZE);
                // The first long expressed the maxbits for the 8 buckets
                out[tmpoutpos++] = (mbits1 << 56) | (mbits2 << 48) | (mbits3 << 40) | (mbits4 << 32) | (mbits5 << 24) | (mbits6 << 16) | (mbits7 << 8) | (mbits8);
                LongBitPacking.fastpackwithoutmask(in, s + 0 * BLOCK_SIZE, out, tmpoutpos, (int) mbits1);
                tmpoutpos += mbits1;
                LongBitPacking.fastpackwithoutmask(in, s + 1 * BLOCK_SIZE, out, tmpoutpos, (int) mbits2);
                tmpoutpos += mbits2;
                LongBitPacking.fastpackwithoutmask(in, s + 2 * BLOCK_SIZE, out, tmpoutpos, (int) mbits3);
                tmpoutpos += mbits3;
                LongBitPacking.fastpackwithoutmask(in, s + 3 * BLOCK_SIZE, out, tmpoutpos, (int) mbits4);
                tmpoutpos += mbits4;
                LongBitPacking.fastpackwithoutmask(in, s + 4 * BLOCK_SIZE, out, tmpoutpos, (int) mbits5);
                tmpoutpos += mbits5;
                LongBitPacking.fastpackwithoutmask(in, s + 5 * BLOCK_SIZE, out, tmpoutpos, (int) mbits6);
                tmpoutpos += mbits6;
                LongBitPacking.fastpackwithoutmask(in, s + 6 * BLOCK_SIZE, out, tmpoutpos, (int) mbits7);
                tmpoutpos += mbits7;
                LongBitPacking.fastpackwithoutmask(in, s + 7 * BLOCK_SIZE, out, tmpoutpos, (int) mbits8);
                tmpoutpos += mbits8;
            }
            // Then we compress up to 7 blocks of 64 longs
            for (; s < inpos.get() + inlength; s += BLOCK_SIZE ) {
                final int mbits = LongUtil.maxbits(in, s, BLOCK_SIZE);
                out[tmpoutpos++] = mbits;
                LongBitPacking.fastpackwithoutmask(in, s, out, tmpoutpos, mbits);
                tmpoutpos += mbits;
            }
            inpos.add(inlength);
            outpos.set(tmpoutpos);
        }

        @Override
        public void uncompress(long[] in, IntWrapper inpos, int inlength,
                long[] out, IntWrapper outpos) {
                if (inlength == 0)
                        return;
                final int outlength = (int) in[inpos.get()];
                inpos.increment();
                headlessUncompress(in,inpos, inlength,out,outpos,outlength);
        }

        @Override
        public void headlessUncompress(long[] in, IntWrapper inpos, int inlength,
                long[] out, IntWrapper outpos, int num) {
            final int outlength = Util.greatestMultiple(num, BLOCK_SIZE);
            int tmpinpos = inpos.get();
            int s = outpos.get();
            for (; s + BLOCK_SIZE * 8 - 1 < outpos.get() + outlength; s += BLOCK_SIZE * 8) {
                final long mbits1 = (in[tmpinpos] >>> 56);
                final long mbits2 = (in[tmpinpos] >>> 48) & 0xFF;
                final long mbits3 = (in[tmpinpos] >>> 40) & 0xFF;
                final long mbits4 = (in[tmpinpos] >>> 32) & 0xFF;
                final long mbits5 = (in[tmpinpos] >>> 24) & 0xFF;
                final long mbits6 = (in[tmpinpos] >>> 16) & 0xFF;
                final long mbits7 = (in[tmpinpos] >>> 8) & 0xFF;
                final long mbits8 = (in[tmpinpos]) & 0xFF;
                ++tmpinpos;
                LongBitPacking.fastunpack(in, tmpinpos, out, s + 0 * BLOCK_SIZE, (int) mbits1);
                tmpinpos += mbits1;
                LongBitPacking.fastunpack(in, tmpinpos, out, s + 1 * BLOCK_SIZE, (int) mbits2);
                tmpinpos += mbits2;
                LongBitPacking.fastunpack(in, tmpinpos, out, s + 2 * BLOCK_SIZE, (int) mbits3);
                tmpinpos += mbits3;
                LongBitPacking.fastunpack(in, tmpinpos, out, s + 3 * BLOCK_SIZE, (int) mbits4);
                tmpinpos += mbits4;
                LongBitPacking.fastunpack(in, tmpinpos, out, s + 4 * BLOCK_SIZE, (int) mbits5);
                tmpinpos += mbits5;
                LongBitPacking.fastunpack(in, tmpinpos, out, s + 5 * BLOCK_SIZE, (int) mbits6);
                tmpinpos += mbits6;
                LongBitPacking.fastunpack(in, tmpinpos, out, s + 6 * BLOCK_SIZE, (int) mbits7);
                tmpinpos += mbits7;
                LongBitPacking.fastunpack(in, tmpinpos, out, s + 7 * BLOCK_SIZE, (int) mbits8);
                tmpinpos += mbits8;
            }
            for (; s < outpos.get() + outlength; s += BLOCK_SIZE ) {
                final int mbits = (int) in[tmpinpos];
                ++tmpinpos;
                LongBitPacking.fastunpack(in, tmpinpos, out, s, mbits);
                tmpinpos += mbits;
            }
            outpos.add(outlength);
            inpos.set(tmpinpos);
        }
        
        @Override
        public String toString() {
                return this.getClass().getSimpleName();
        }
}
