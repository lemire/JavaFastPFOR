package integercompression;

/**
 * @author dwu
 */
public final class IntWrapper {
    private int value;

    public IntWrapper() {
        this(0);
    }

    public IntWrapper(int value) {
        this.value = value;
    }

    public int get() {
        return this.value;
    }

    public void set(int value) {
        this.value = value;
    }

    public void add(int value) {
        this.value += value;
    }

    public void increment() {
        this.value++;
    }
}
