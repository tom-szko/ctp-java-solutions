package pl.coderstrust.search;

public class BinarySearch implements Searchable {
    public int search(int[] array, int element) {
        if (array == null) {
            throw new NullPointerException("Array cannot be null.");
        }
        if (array.length == 0) {
            throw new IllegalArgumentException("Array cannot be empty.");
        }
        int loIndex = 0;
        int hiIndex = array.length - 1;
        while (loIndex <= hiIndex) {
            int centralElement = loIndex + (hiIndex - loIndex) / 2;
            if (element > array[centralElement]) {
                loIndex = centralElement + 1;
            } else if (element < array[centralElement]) {
                hiIndex = centralElement - 1;
            } else {
                return centralElement;
            }
        }
        return -1;
    }
}
