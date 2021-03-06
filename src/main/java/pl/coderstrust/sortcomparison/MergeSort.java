package pl.coderstrust.sortcomparison;

public class MergeSort implements SortingMethod {
    @Override
    public int[] sort(int[] array) {
        if (array == null) {
            throw new NullPointerException("Array cannot be null.");
        }
        if (array.length < 2) {
            return array;
        }
        int[][] divided = divide(array);
        return merge(sort(divided[0]), sort(divided[1]));
    }

    private int[] merge(int[] array1, int[] array2) {
        int index1 = 0;
        int index2 = 0;
        int[] result = new int[array1.length + array2.length];
        int resultIndex = 0;
        while (index1 < array1.length && index2 < array2.length) {
            if (array1[index1] <= array2[index2]) {
                result[resultIndex] = array1[index1];
                index1++;
                resultIndex++;
            } else {
                result[resultIndex] = array2[index2];
                index2++;
                resultIndex++;
            }
        }
        while (index1 < array1.length) {
            result[resultIndex] = array1[index1];
            index1++;
            resultIndex++;
        }
        while (index2 < array2.length) {
            result[resultIndex] = array2[index2];
            index2++;
            resultIndex++;
        }
        return result;
    }

    private int[][] divide(int[] array) {
        int[][] result = new int[2][];
        int firstPartSize = array.length / 2;
        int secondPartSize = array.length - firstPartSize;
        result[0] = new int[firstPartSize];
        result[1] = new int[secondPartSize];
        for (int i = 0; i < firstPartSize; i++) {
            result[0][i] = array[i];
        }
        for (int i = firstPartSize; i < firstPartSize + secondPartSize; i++) {
            result[1][i - firstPartSize] = array[i];
        }
        return result;
    }
}
