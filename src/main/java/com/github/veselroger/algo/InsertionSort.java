package com.github.veselroger.algo;

/**
 * Alternative for Selection Sort
 */
public class InsertionSort extends Sorting {

    @Override
    public void sort(int[] array) {
        for (int out = 1; out < array.length; out++) {
            int temp = array[out]; // cut element
            int in = out; // start from 'out'
            // Move elements while they less than cutted element
            while (in > 0 && array[in - 1] >= temp) {
                array[in] = array[in - 1];
                --in;
            }
            // Return the cutted element back
            array[in] = temp;
        }
    }

    public void sortShort(int[] array) {
        for (int out = 1; out < array.length; out++) {
            // While in has one space before && in should be swapped
            for (int in = out; in > 0 && array[in] < array[in - 1]; in--) {
                swap(array, in, in - 1);
            }
        }
    }

}