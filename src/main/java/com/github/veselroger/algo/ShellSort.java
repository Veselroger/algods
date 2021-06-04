package com.github.veselroger.algo;

/**
 * Insertion sort alternation that uses a calculated gap
 */
public class ShellSort extends Sorting {

    @Override
    public void sort(int[] array) {
        for (int gap = array.length / 2; gap > 0; gap = gap / 2) {
            // Start from the gap, not from the n=1 as it was in the Insertion Sort
            for (int out = gap; out < array.length; out++) {
                int temp = array[out]; // cut element
                int in = out;
                // We compare in and in-gap that can be the zero index -> Use '>='
                while (in >= gap && array[in - gap] >= temp) {
                    array[in] = array[in - gap];
                    in = in - gap;
                }
                // Return the cutted element back
                array[in] = temp;
            }
        }
    }
}