/**
 * This code is released under the
 * Apache License Version 2.0 http://www.apache.org/licenses/.
 *
 */

package me.lemire.integercompression;

/**
 * @author dwu
 */
public final class IntWrapper extends Number {
    private static final long serialVersionUID = 1L;
    private int value;

    public IntWrapper() {
        this(0);
    }

    public IntWrapper(int v) {
        this.value = v;
    }

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

    public int get() {
        return this.value;
    }

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

    public void set(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return Integer.toString(this.value);
    }
}
