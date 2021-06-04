package com.github.veselroger.algo;

import java.util.Arrays;

/**
 * The sorting algorithms that is based on the heap - a complete binary tree
 */
public class HeapSort extends Sorting {

    @Override
    public void sort(int[] array) {
        // Build Max-Heap
        for (int i = array.length / 2; i >= 0; i--) {
            heapify(array, i, array.length);
        }
        // Sort
        for (int i = array.length - 1; i >= 0; i--) {
            swap(array, 0, i);    // swap root with last            
            heapify(array, 0, i); // Heapify root element
        }
    }

    public void heapify(int[] array, int index, int len) {
        while (index < len) {
            int left = 2 * index + 1;
            int right = 2 * index + 2;
            int largest = index;
            if (left < len && array[left] > array[largest]) {
                largest = left;
            }
            if (right < len && array[right] > array[largest]) {
                largest = right;
            }
            if (largest != index) {
                swap(array, index, largest);
                index = largest;
            } else {
                break;
            }
        }
    }
}
