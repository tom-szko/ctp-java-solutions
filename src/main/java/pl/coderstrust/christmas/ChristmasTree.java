package pl.coderstrust.christmas;

import java.util.ArrayList;
import java.util.List;

public class ChristmasTree {
    public static void main(String[] args) {
        List<String> tree = getChristmasTree(6);
        for (String line : tree) {
            System.out.println(line);
        }
    }

    public static List<String> getChristmasTree(int size) {
        List<String> result = new ArrayList<String>();
        StringBuilder stringBuilder = new StringBuilder();

        for (int row = 1; row <= size; row++) {
            stringBuilder.delete(0, stringBuilder.length());
                for (int i = 0; i < size - row; i++) {
                    stringBuilder.append(" ");
                }
                for (int s = 1; s <= row * 2 - 1; s++) {
                    stringBuilder.append("*");
                }
                result.add(stringBuilder.toString());
        }
        if (size > 0) {
            result.add(makeTreeTrunk(size));
        }
        return result;
    }

    private static String makeTreeTrunk(int size) {
        StringBuilder trunkBuilder = new StringBuilder();
        for (int i = 0; i < size - 2; i++) {
            trunkBuilder.append(" ");
        }
        return trunkBuilder.append("**").toString();
    }
}
