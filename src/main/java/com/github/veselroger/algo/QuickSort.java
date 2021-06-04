package com.github.veselroger.algo;

/**
 * Sorting algorithm that split element by pivot and sort elements according to
 * this pivot.
 */
public class QuickSort extends Sorting {

    @Override
    public void sort(int[] array) {
        quickSort(array, 0, array.length - 1);
    }

    public void quickSort(int[] array, int low, int high) {
        if (low >= high) {
            return;
        }
        int pivot = partition(array, low, high);
        quickSort(array, low, pivot - 1);
        quickSort(array, pivot + 1, high);
    }

    public int partition(int[] array, int low, int high) {
        int pivot = (low + high) / 2;
        // Swap pivot with the last element. High = pivot
        swap(array, pivot, high);
        int pivotIndexCounter = low;
        for (int i = low; i < high; i++) {
            // Move elements if they less than pivot
            if (array[i] <= array[high]) {
                swap(array, pivotIndexCounter, i);
                pivotIndexCounter++;
            }
        }
        swap(array, pivotIndexCounter, high);
        return pivotIndexCounter;
    }
}