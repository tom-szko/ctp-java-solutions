package pl.coderstrust.sortcomparison;

public class QuickSort implements SortingMethod {

    @Override
    public int[] sort(int[] array) {
        if (array == null) {
            throw new NullPointerException("Array cannot be null.");
        }
        if (array.length < 2) {
            return array;
        }
        int pivot = array[0];
        int[] less = new int[countLessOrEqual(array, pivot)];
        int[] greater = new int[countGreater(array, pivot)];
        int lessIndex = 0;
        int greaterIndex = 0;
        for (int i = 1; i < array.length; i++) {
            if (array[i] <= pivot) {
                less[lessIndex] = array[i];
                lessIndex++;
            }
            if (array[i] > pivot) {
                greater[greaterIndex] = array[i];
                greaterIndex++;
            }
        }
        return concatenateArrays(sort(less), new int[]{pivot}, sort(greater));
    }

    private int[] concatenateArrays(int[] array1, int[] array2, int[] array3) {
        int[] result = new int[array1.length + array2.length + array3.length];
        for (int i = 0; i < result.length; i++) {
            if (i < array1.length) {
                result[i] = array1[i];
            } else if (i < (array1.length + array2.length)) {
                result[i] = array2[i - array1.length];
            } else {
                result[i] = array3[i - array1.length - array2.length];
            }
        }
        return result;
    }

    private int countLessOrEqual(int[] array, int value) {
        int lessCount = 0;
        for (int i = 1; i < array.length; i++) {
            if (array[i] <= value) {
                lessCount++;
            }
        }
        return lessCount;
    }

    private int countGreater(int[] array, int value) {
        int greaterCount = 0;
        for (int i = 1; i < array.length; i++) {
            if (array[i] > value) {
                greaterCount++;
            }
        }
        return greaterCount;
    }
}
