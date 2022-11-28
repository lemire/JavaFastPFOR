/**
 * This code is released under the
 * Apache License Version 2.0 http://www.apache.org/licenses/.
 *
 * (c) Daniel Lemire, http://lemire.me/en/
 */
package me.lemire.longcompression.synth;

import me.lemire.integercompression.synth.ClusteredDataGenerator;

/**
 * This class will generate lists of random longs based on the clustered
 * model:
 * 
 * Reference: Vo Ngoc Anh and Alistair Moffat. 2010. Index compression using
 * 64-bit words. Softw. Pract. Exper.40, 2 (February 2010), 131-147.
 * 
 * @author Benoit Lacelle
 * @see ClusteredDataGenerator
 */
public class LongClusteredDataGenerator {

        final LongUniformDataGenerator unidg = new LongUniformDataGenerator();

        /**
         * Creating random array generator.
         */
        public LongClusteredDataGenerator() {
        }

        void fillUniform(long[] array, int offset, int length, long Min, long Max) {
        	    long[] v = this.unidg.generateUniform(length, Max - Min);
                for (int k = 0; k < v.length; ++k)
                        array[k + offset] = Min + v[k];
        }

        void fillClustered(long[] array, int offset, int length, long Min, long Max) {
                final long range = Max - Min;
                if ((range == length) || (length <= 10)) {
                        fillUniform(array, offset, length, Min, Max);
                        return;
                }
                final long cut = length
                        / 2
                        + ((range - length - 1 > 0) ? (long)this.unidg.rand
                                .nextDouble() * (range - length - 1) : 0);
                final double p = this.unidg.rand.nextDouble();
                if (p < 0.25) {
                        fillUniform(array, offset, length / 2, Min, Min + cut);
                        fillClustered(array, offset + length / 2, length
                                - length / 2, Min + cut, Max);
                } else if (p < 0.5) {
                        fillClustered(array, offset, length / 2, Min, Min + cut);
                        fillUniform(array, offset + length / 2, length - length
                                / 2, Min + cut, Max);
                } else {
                        fillClustered(array, offset, length / 2, Min, Min + cut);
                        fillClustered(array, offset + length / 2, length
                                - length / 2, Min + cut, Max);
                }
        }

        /**
         * generates randomly N distinct integers from 0 to Max.
         * 
         * @param N
         *                number of integers to generate
         * @param Max
         *                maximal value of the integers
         * @return array containing the integers
         */
        public long[] generateClustered(int N, long Max) {
        	    long[] array = new long[N];
                fillClustered(array, 0, N, 0, Max);
                return array;
        }

        /**
         * Little test program.
         * 
         * @param args
         *                arguments are ignored
         */
        public static void main(final String[] args) {
        	    long[] example = (new LongClusteredDataGenerator())
                        .generateClustered(20, 1000);
                for (int k = 0; k < example.length; ++k)
                        System.out.println(example[k]);
        }

}
