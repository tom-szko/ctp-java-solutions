package pl.coderstrust.hoare;

import java.util.Arrays;

public class HoarePartition {
    public int[] partition(int[] array, int pivotIndex) {
        if (array == null || array.length < 1) {
            throw new IllegalArgumentException("Array cannot be null or has length of 0.");
        }
        if (pivotIndex >= array.length || pivotIndex < 0) {
            throw new IllegalArgumentException("Pivot index cannot be >= array.length and < 0");
        }
        int[] partitioned = Arrays.copyOf(array, array.length);
        int pivot = partitioned[pivotIndex];
        int loIndex = 0;
        int hiIndex = partitioned.length;
        swap(partitioned, pivotIndex, 0);
        while (true) {
            do {
                if (loIndex == partitioned.length - 1) {
                    break;
                }
                loIndex++;
            } while (partitioned[loIndex] <= pivot);
            do {
                if (hiIndex == 0) {
                    break;
                }
                hiIndex--;
            } while (partitioned[hiIndex] > pivot);
            if (loIndex < hiIndex) {
                swap(partitioned, loIndex, hiIndex);
            } else {
                swap(partitioned, hiIndex, 0);
                return partitioned;
            }
        }
    }

    private void swap(int[] array, int index1, int index2) {
        int temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }
}
