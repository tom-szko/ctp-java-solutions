package pl.coderstrust.multiplication;

import java.util.ArrayList;
import java.util.List;

public class MultiplicationTable {
    public static void main(String[] args) {
        List<String> table = getMultiplicationTable(6);
        for (String line : table) {
            System.out.println(line);
        }
    }

    public static List<String> getMultiplicationTable(int size) {
        List<String> result = new ArrayList<>();
        if (size <= 0) {
            throw new IllegalArgumentException("Table size argument cannot be less than 0.");
        }
        StringBuilder stringBuilder = new StringBuilder(String.format(createTableCell(size), " "));
        for (int i = 1; i <= size; i++) {
            stringBuilder.append(String.format(createTableCell(size), i));
        }
        result.add(stringBuilder.toString());
        for (int i = 1; i <= size; i++) {
            stringBuilder.delete(0, stringBuilder.length()).append(String.format(createTableCell(size), i));
            for (int k = 1; k <= size; k++) {
                stringBuilder.append(String.format(createTableCell(size), i * k));
            }
            result.add(stringBuilder.toString());
        }
        return result;
    }

    private static String createTableCell(int size) {
        StringBuilder whiteSpaceBuilder = new StringBuilder();
        int longestNumber = String.valueOf(size * size).length();
        for (int i = 1; i <= longestNumber; i++) {
            whiteSpaceBuilder.append(" ");
        }
        return whiteSpaceBuilder.append("%").append(longestNumber).append("s").toString();
    }
}
