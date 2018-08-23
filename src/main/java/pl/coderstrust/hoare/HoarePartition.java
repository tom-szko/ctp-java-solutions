package pl.coderstrust.hoare;

import java.util.Arrays;

public class HoarePartition {
    public int[] partition(int[] array, int pivotIndex) {
        if (array == null) {
            throw new NullPointerException("Array cannot be null.");
        }
        if (array.length < 1) {
            throw new IllegalArgumentException("Array cannot be empty.");
        }
        if (pivotIndex > array.length) {
            throw new IllegalArgumentException("Pivot index cannot be cannot be greater than max index of the array.");
        }
        if (pivotIndex == array.length) {
            throw new IllegalArgumentException("Pivot index cannot be equal to max index of the array.");
        }
        if (pivotIndex < 0) {
            throw new IllegalArgumentException("Pivot index cannot be less than zero.");
        }
        int[] partitioned = Arrays.copyOf(array, array.length);
        int pivot = partitioned[pivotIndex];
        int leftPointer = 0;
        int rightPointer = partitioned.length;
        swapArrayElements(partitioned, pivotIndex, 0);
        while (leftPointer < rightPointer) {
            do {
                leftPointer++;
            } while (partitioned[leftPointer] <= pivot && leftPointer != partitioned.length - 1);
            do {
                rightPointer--;
            } while (partitioned[rightPointer] > pivot && rightPointer != 0);
            if (leftPointer < rightPointer) {
                swapArrayElements(partitioned, leftPointer, rightPointer);
            }
        }
        swapArrayElements(partitioned, rightPointer, 0);
        return partitioned;
    }

    private void swapArrayElements(int[] array, int firstElementToSwap, int secondElementToSwap) {
        int temp = array[firstElementToSwap];
        array[firstElementToSwap] = array[secondElementToSwap];
        array[secondElementToSwap] = temp;
    }
}
