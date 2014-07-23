/**
 * This code is released under the
 * Apache License Version 2.0 http://www.apache.org/licenses/.
 *
 */

package me.lemire.integercompression;

/**
 * Essentially a mutable wrapper around an integer.
 * 
 * @author dwu
 */
public final class IntWrapper extends Number {
        private static final long serialVersionUID = 1L;
        private int value;

        /**
         * Constructor: value set to 0.
         */
        public IntWrapper() {
                this(0);
        }

        /**
         * Construction: value set to provided argument.
         * 
         * @param v
         *                value to wrap
         */
        public IntWrapper(final int v) {
                this.value = v;
        }

        /**
         * add the provided value to the integer
         * @param v value to add
         */
        public void add(int v) {
                this.value += v;
        }

        @Override
        public double doubleValue() {
                return this.value;
        }

        @Override
        public float floatValue() {
                return this.value;
        }

        /**
         * @return the integer value
         */
        public int get() {
                return this.value;
        }

        /**
         * add 1 to the integer value
         */
        public void increment() {
                this.value++;
        }

        @Override
        public int intValue() {
                return this.value;
        }

        @Override
        public long longValue() {
                return this.value;
        }

        /**
         * Set the value to that of the specified integer.
         * 
         * @param value
         *                specified integer value
         */
        public void set(final int value) {
                this.value = value;
        }

        @Override
        public String toString() {
                return Integer.toString(this.value);
        }
}
