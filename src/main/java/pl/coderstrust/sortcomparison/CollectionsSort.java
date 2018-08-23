package pl.coderstrust.sortcomparison;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class CollectionsSort implements SortingMethod {
    @Override
    public int[] sort(int[] array) {
        if (array == null) {
            throw new NullPointerException("Array cannot be null");
        }
        List<Integer> list = Arrays.asList(convertIntArrayToIntegerArray(array));
        Collections.sort(list);
        return convertListToIntArray(list);
    }

    private Integer[] convertIntArrayToIntegerArray(int[] array) {
        Integer[] integers = new Integer[array.length];
        for (int i = 0; i < integers.length; i++) {
            integers[i] = array[i];
        }
        return integers;
    }

    private int[] convertListToIntArray(List<Integer> list) {
        int[] ints = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            ints[i] = list.get(i);
        }
        return ints;
    }
}
