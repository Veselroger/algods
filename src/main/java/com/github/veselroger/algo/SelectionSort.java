package com.github.veselroger.algo;

/**
 * Bubble Sort improvement to reduce swap operations.
 */
public class SelectionSort extends Sorting {

    @Override
    public void sort(int[] array) {
        // Out iterator as a cursor for the current handled element
        // Out iteration n-1 because we compare out and out+1
        for (int out = 0; out < array.length - 1; out++) {
            int minInd = out;
            for (int in = out + 1; in < array.length; in++) {
                if (array[in] < array[minInd]) {
                    minInd = in;
                }
            }
            swap(array, out, minInd);
        }
    }
}
