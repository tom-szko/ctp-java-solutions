package pl.coderstrust.sortcomparison;

import java.util.Arrays;

public class QuickSort implements SortingMethod {

    @Override
    public int[] sort(int[] array) {
        if (array == null) {
            throw new NullPointerException("Array cannot be null.");
        }
        int[] sorted = Arrays.copyOf(array, array.length);
        quicksort(sorted, 0, sorted.length - 1);
        return sorted;
    }

    private void quicksort(int[] array, int loIndex, int hiIndex) {
        if (loIndex < hiIndex) {
            int pivotIndex = partition(array, loIndex, hiIndex);
            quicksort(array, loIndex, pivotIndex - 1);
            quicksort(array, pivotIndex + 1, hiIndex);
        }
    }

    private int partition(int[] array, int loIndex, int hiIndex) {
        int pointer = loIndex;
        int pivot = array[hiIndex];
        for (int i = loIndex; i < hiIndex; i++) {
            if (array[i] < pivot) {
                swapArrayElements(array, pointer, i);
                pointer++;
            }
        }
        swapArrayElements(array, pointer, hiIndex);
        return pointer;
    }

    private void swapArrayElements(int[] array, int index1, int index2) {
        int temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }
}
