package pl.coderstrust.search;

public class LinearSearch implements SearchMethod {
    public int search(int[] array, int number){
        if (array == null) {
            throw new NullPointerException("Array cannot be null.");
        }
        if (array.length == 0) {
            throw new IllegalArgumentException("Array cannot be empty.");
        }
        for (int i = 0; i < array.length; i++) {
            if (array[i] == number) {
                return i;
            }
        }
        return -1;
    }
}
