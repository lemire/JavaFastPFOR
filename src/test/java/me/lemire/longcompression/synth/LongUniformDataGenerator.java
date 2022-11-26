/**
 * This code is released under the
 * Apache License Version 2.0 http://www.apache.org/licenses/.
 *
 * (c) Daniel Lemire, http://lemire.me/en/
 */
package me.lemire.longcompression.synth;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Random;
import java.util.Set;

import org.roaringbitmap.longlong.Roaring64Bitmap;

import me.lemire.integercompression.synth.UniformDataGenerator;

/**
 * This class will generate "uniform" lists of random longs.
 * 
 * @author Benoit Lacelle
 * @see UniformDataGenerator
 */
public class LongUniformDataGenerator {
        /**
         * construct generator of random arrays.
         */
        public LongUniformDataGenerator() {
                this.rand = new Random();
        }

        /**
         * @param seed
         *                random seed
         */
        public LongUniformDataGenerator(final int seed) {
                this.rand = new Random(seed);
        }

        /**
         * generates randomly N distinct longs from 0 to Max.
         */
        long[] generateUniformHash(int N, long Max) {
                if (N > Max)
                        throw new RuntimeException("not possible");
                long[] ans = new long[N];
                Set<Long> s = new HashSet<>();
                while (s.size() < N)
                        s.add((long) (this.rand.nextDouble() * Max));
                Iterator<Long> i = s.iterator();
                for (int k = 0; k < N; ++k)
                        ans[k] = i.next().longValue();
                Arrays.sort(ans);
                return ans;
        }

        /**
         * output all longs from the range [0,Max) that are not in the array
         */
        static long[] negate(long[] x, long Max) {
        	int newLength = saturatedCast(Max - x.length);
        	long[] ans = new long[newLength];
                int i = 0;
                int c = 0;
                for (int j = 0; j < x.length; ++j) {
                	long v = x[j];
                        for (; i < v; ++i)
                                ans[c++] = i;
                        ++i;
                }
                while (c < ans.length)
                        ans[c++] = i++;
                return ans;
        }

		private static int saturatedCast(long toInt) {
        	if (toInt > Integer.MAX_VALUE) {
        		return Integer.MAX_VALUE;
        	} else {
        		return (int) toInt;
        	}
		}

        /**
         * generates randomly N distinct longs from 0 to Max.
         * 
         * @param N
         *                number of longs to generate
         * @param Max
         *                bound on the value of longs
         * @return an array containing randomly selected longs
         */
        public long[] generateUniform(int N, long Max) {
        	    assert N >= 0;
                assert Max >= 0;
                if (N * 2 > Max) {
                        return negate(generateUniform(saturatedCast(Max - N), Max), Max);
                }
                if (2048 * N > Max)
                        return generateUniformBitmap(N, Max);
                return generateUniformHash(N, Max);
        }

        /**
         * generates randomly N distinct longs from 0 to Max.
         */
        long[] generateUniformBitmap(int N, long Max) {
                if (N > Max)
                        throw new RuntimeException("not possible");
                Roaring64Bitmap bs = new Roaring64Bitmap();
                int cardinality = 0;
                while (cardinality < N) {
                        long v = (long) (rand.nextDouble() * Max);
                        if (!bs.contains(v)) {
                                bs.add(v);
                                cardinality++;
                        }
                }
                return bs.toArray();
        }

        Random rand = new Random();

}