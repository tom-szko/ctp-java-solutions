package pl.coderstrust.sortcomparison;

import java.util.Arrays;

public class BubbleSort implements SortingMethod {
    @Override
    public int[] sort(int[] array) {
        if (array == null) {
            throw new NullPointerException("Array cannot be null.");
        }
        int[] sortedArray = Arrays.copyOf(array, array.length);
        boolean sorted = true;
        while (sorted) {
            sorted = false;
            for (int i = 1; i < sortedArray.length; i++) {
                if (sortedArray[i - 1] > sortedArray[i]) {
                    swapArrayElements(sortedArray, i - 1, i);
                    sorted = true;
                }
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
