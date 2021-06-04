package com.github.veselroger.algo;

/**
 * Sorting algorithm that split elements, sort parts and then combine them in a
 * proper order.
 */
public class MergeSort extends Sorting {

    @Override
    public void sort(int[] array) {
        mergeSort(array, 0, array.length - 1);
    }

    protected void mergeSort(int[] array, int left, int right) {
        if (left >= right)
            return;
        int middle = left + (right - left) / 2;
        mergeSort(array, left, middle);
        mergeSort(array, middle + 1, right);
        merge(array, left, right, middle);
    }

    public static void merge(int[] array, int leftBound, int rightBound, int middle) {
        int left = leftBound;
        int right = middle + 1;
        // Auxiliary array to store the sorted elements
        int[] aux = new int[rightBound - leftBound + 1];
        // As we fill the aux array it make sense work only until we reach the aux end
        for (int i = 0; i < aux.length; i++) {
            // right > rightBound = no more elements from the right
            if (right > rightBound || (left <= middle && array[left] < array[right])) {
                aux[i] = array[left++];
            } else {
                aux[i] = array[right++];
            }
        }
        // Return elements back
        for (int i = 0; i < aux.length; i++) {
            array[leftBound + i] = aux[i];
        }
    }

}
