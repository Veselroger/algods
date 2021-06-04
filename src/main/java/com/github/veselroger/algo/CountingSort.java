package com.github.veselroger.algo;

import java.util.Arrays;

public class CountingSort extends Sorting {

    @Override
    public void sort(int[] array) {
        int min = Arrays.stream(array).min().orElse(0);
        int max = Arrays.stream(array).max().orElse(min);
        int aux[] = new int[max - min + 1];
        for (int value : array) {
            aux[value - min] = aux[value - min] + 1;
        }
        for (int i = 1; i < aux.length; i++) {
            aux[i] = aux[i] + aux[i - 1];
        }

        int[] output = new int[array.length];
        for (int i = array.length - 1; i >= 0; i--) {
            int pos = aux[array[i] - min] - 1;
            output[pos] = array[i];
            aux[array[i] - min]--;
        }
        System.arraycopy(output, 0, array, 0, array.length);
    }

}
