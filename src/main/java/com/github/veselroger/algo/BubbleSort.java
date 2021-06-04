package com.github.veselroger.algo;

/**
 * Simplest compare-and-swap algorithm.
 */
public class BubbleSort extends Sorting {
    @Override
    public void sort(int[] array) {
        // Perform n passes for n-1 elements while we should swap at least once per pass
        for (int pass = 0; pass < array.length; pass++) {
            boolean swapped = false;
            for (int i = 0; i < array.length - 1; i++) {
                if (array[i] > array[i + 1]) {
                    swap(array, i, i + 1);
                    swapped = true;
                }
            }
            if (!swapped)
                break;
        }
    }
}