package pl.coderstrust.pascal;

import java.util.ArrayList;
import java.util.List;

public class PascalTriangle {
    public static void main(String[] args) {
        List<String> triangle = getPascalTriangle(2);
        for (String row : triangle) {
            System.out.println(row);
        }
    }

    public static List<String> getPascalTriangle(int triangleRows) {
        if (triangleRows < 0) {
            throw new IllegalArgumentException("Number of rows must be positive");
        }
        List<String> result = new ArrayList<>();
        StringBuilder stringBuilder = new StringBuilder();
        for (int row = 1; row <= triangleRows; row++) {
            stringBuilder.delete(0, stringBuilder.length());
            for (int column = 0; column < (triangleRows - row); column++) {
                stringBuilder.append("  ");
            }
            for (int column = 1; column <= row; column++) {
                stringBuilder.append(String.format("%4d", getPascalNumber(row - 1, column - 1)));
            }
            result.add(stringBuilder.toString());
        }
        return result;
    }

    private static long getPascalNumber(int row, int column) {
        return getFactorial(row) / (getFactorial(column) * (getFactorial(row - column)));
    }

    public static long getFactorial(int number) {
        if (number == 0) {
            return 1;
        } else {
            long factorial = 1;
            for (int i = 1; i <= number; i++) {
                factorial *= i;
            }
            return factorial;
        }
    }
}
