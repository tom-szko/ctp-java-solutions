package pl.coderstrust.pascal;

public class PascalTriangle {
    public static void main(String[] args) {
        drawPascalTriangle(10);
        System.out.println();

        drawPascalTriangle(6);
        System.out.println();

        drawPascalTriangle(4);
    }

    static void drawPascalTriangle(int triangleRows) {
        for (int row = 1; row <= triangleRows; row++) {
            for (int column = 0; column < (triangleRows - row); column++) {
                System.out.print("  ");
            }
            int column = 1;
            while (column <= row) {
                System.out.printf("%4d", calculateTriangleNumber(row - 1, column - 1));
                column++;
            }
            System.out.println();
        }
    }

    static long calculateTriangleNumber(int row, int column) {
        return calculateFactorial(row) / (calculateFactorial(column) * (calculateFactorial(row - column)));
    }

    static long calculateFactorial(int number) {
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