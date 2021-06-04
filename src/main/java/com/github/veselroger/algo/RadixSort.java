package com.github.veselroger.algo;

import java.util.Arrays;

/**
 * The sorting algorithm that sort elements according to their values radix.
 */
public class RadixSort extends Sorting {

    @Override
    public void sort(int[] array) {
        int max = Arrays.stream(array).max().orElse(Integer.MAX_VALUE);
        for (int exp = 1; max / exp > 0; exp = exp * 10) {
            sort(array, exp);
        }
    }

    public static void sort(int[] array, int exp) {
        int aux[] = new int[10];
        for (int value : array) {
            aux[(value / exp) % 10] = aux[(value / exp) % 10] + 1;
        }
        for (int i = 1; i < aux.length; i++) {
            aux[i] = aux[i] + aux[i - 1];
        }

        int[] output = new int[array.length];
        for (int i = array.length - 1; i >= 0; i--) {
            int pos = aux[(array[i] / exp) % 10] - 1;
            output[pos] = array[i];
            aux[(array[i] / exp) % 10]--;
        }
        System.arraycopy(output, 0, array, 0, array.length);
    }

}
