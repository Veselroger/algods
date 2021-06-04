package com.github.veselroger.algo;

/**
 * The sorting algorithm.
 */
public abstract class Sorting {

    /**
     * Sort defined array
     */
    public abstract void sort(int[] array);

    /**
     * Swap two elements inside the array.
     */
    protected void swap(int[] array, int first, int second) {
        int temp = array[first];
        array[first] = array[second];
        array[second] = temp;
    }
}
