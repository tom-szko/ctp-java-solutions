package pl.coderstrust.pascal;

public class PascalTriangle {
    public static void main(String[] args) {
        PascalTriangle pTriangle = new PascalTriangle();

        pTriangle.drawPascalTriangle(10);
        System.out.println();

        pTriangle.drawPascalTriangle(6);
        System.out.println();

        pTriangle.drawPascalTriangle(4);
    }

    void drawPascalTriangle(int triangleRows) {
        for (int row = 1; row <= triangleRows; row++) {
            for (int column = 0; column < (triangleRows - row); column++) {
                System.out.print("  ");
            }

            int column = 1;
            while (column <= row) {
                System.out.printf("%4d", calcTriangleNumber(row - 1, column - 1));
                column++;
            }
            System.out.println();
        }
    }

    long calcTriangleNumber(int row, int column) {
        return calcFactorial(row) / (calcFactorial(column) * (calcFactorial(row - column)));
    }

    long calcFactorial(int number) {
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