package pl.coderstrust.sortcomparison;

import java.util.Arrays;

public class SelectionSort implements SortingMethod {
    @Override
    public int[] sort(int[] array) {
        if (array == null) {
            throw new NullPointerException("Array cannot be null.");
        }
        int[] sortedArray = Arrays.copyOf(array, array.length);
        for (int k = 0; k < sortedArray.length; k++) {
            int currentMinPosition = k;
            for (int i = k + 1; i < sortedArray.length; i++) {
                if (sortedArray[currentMinPosition] > sortedArray[i]) {
                    currentMinPosition = i;
                }
            }
            if (currentMinPosition != k) {
                swapArrayElements(sortedArray, currentMinPosition, k);
            }
        }
        return sortedArray;
    }

    private void swapArrayElements(int[] array, int firstElementPosition, int secondElementPosition) {
        int temporaryValue = array[firstElementPosition];
        array[firstElementPosition] = array[secondElementPosition];
        array[secondElementPosition] = temporaryValue;
    }
}
