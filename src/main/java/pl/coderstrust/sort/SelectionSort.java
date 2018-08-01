package pl.coderstrust.sort;

import java.util.Arrays;

public class SelectionSort {
    public static void main(String[] args) {
        int[] myArray = {Integer.MAX_VALUE, 39, 0, -12, 890, 12390, 111, Integer.MIN_VALUE};
        System.out.println("myArray = " + Arrays.toString(myArray));
        System.out.println("myArray in ascending order = " + Arrays.toString(sort(myArray)));
    }

    private static int[] sort(int[] array) {
        int[] sortedArray = Arrays.copyOf(array, array.length);
        for (int k = 0; k < sortedArray.length; k++) {
            int temporaryValue = sortedArray[k];
            int currentMinPosition = k;
            for (int i = k + 1; i < sortedArray.length; i++) {
                if (temporaryValue > sortedArray[i]) {
                    temporaryValue = sortedArray[i];
                    currentMinPosition = i;
                }
            }
            swapArrayElements(sortedArray, currentMinPosition, k);
        }
        return sortedArray;
    }

    private static void swapArrayElements(int[] array, int firstElementPosition, int secondElementPosition) {
        int temporaryValue = array[firstElementPosition];
        array[firstElementPosition] = array[secondElementPosition];
        array[secondElementPosition] = temporaryValue;
    }
}