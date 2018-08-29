package pl.coderstrust.sortcomparison;

import java.util.Arrays;

public class BubbleSort implements SortingMethod {
    @Override
    public int[] sort(int[] array) {
        if (array == null) {
            throw new NullPointerException("Array cannot be null.");
        }
        int[] sortedArray = Arrays.copyOf(array, array.length);
        boolean sorted = false;
        int subarrayToCheck = sortedArray.length;
        while (!sorted) {
            sorted = true;
            for (int i = 1; i < subarrayToCheck; i++) {
                if (sortedArray[i - 1] > sortedArray[i]) {
                    swapArrayElements(sortedArray, i - 1, i);
                    sorted = false;
                }
            }
            subarrayToCheck--;
        }
        return sortedArray;
    }

    private void swapArrayElements(int[] array, int firstElementPosition, int secondElementPosition) {
        int temporaryValue = array[firstElementPosition];
        array[firstElementPosition] = array[secondElementPosition];
        array[secondElementPosition] = temporaryValue;
    }
}
