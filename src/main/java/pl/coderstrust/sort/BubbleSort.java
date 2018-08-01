package pl.coderstrust.sort;

import java.util.Arrays;

public class BubbleSort {
    public static void main(String[] args) {
        int[] myArray = {Integer.MAX_VALUE, 123, 39, 0, -12, -123, 12390, 11, Integer.MIN_VALUE};
        System.out.println("myArray = " + Arrays.toString(myArray));
        System.out.println("myArray in ascending order = " + Arrays.toString(sort(myArray)));
    }

    private static int[] sort(int[] array) {
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

    private static void swapArrayElements(int[] array, int firstElementPosition, int secondElementPosition) {
        int temporaryValue = array[firstElementPosition];
        array[firstElementPosition] = array[secondElementPosition];
        array[secondElementPosition] = temporaryValue;
    }
}