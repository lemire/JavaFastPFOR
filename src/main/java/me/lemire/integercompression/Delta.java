/**
 * This code is released under the
 * Apache License Version 2.0 http://www.apache.org/licenses/.
 *
 * (c) Daniel Lemire, http://lemire.me/en/
 */

package me.lemire.integercompression;

public class Delta {

    public static void delta(int[] data) {
        for (int i = data.length - 1; i > 0; --i) {
            data[i] -= data[i - 1];
        }
    }

    public static void inverseDelta(int[] data) {
        for (int i = 1; i < data.length; ++i) {
            data[i] += data[i - 1];
        }
    }

    public static void fastinverseDelta(int[] data) {
        int sz0 = data.length / 4 * 4;
        int i = 1;
        if (sz0 >= 4) {
            int a = data[0];
            for (; i < sz0 - 4; i += 4) {
                a = data[i] += a;
                a = data[i + 1] += a;
                a = data[i + 2] += a;
                a = data[i + 3] += a;
            }
        }

        for (; i != data.length; ++i) {
            data[i] += data[i - 1];
        }
    }
}
