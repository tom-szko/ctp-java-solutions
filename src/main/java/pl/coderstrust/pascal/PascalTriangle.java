package pl.coderstrust.pascal;

public class PascalTriangle {
    public static void main(String[] args) {
        PascalTriangle pTriangle = new PascalTriangle();
        pTriangle.drawPascalTri(10);
        System.out.println();
        pTriangle.drawPascalTri(6);
        System.out.println();
        pTriangle.drawPascalTri(4);
    }

    void drawPascalTri(int triRows) {
        for (int row = 1; row <= triRows; row++) {
            for (int col = 0; col<(triRows-row); col++) {
                System.out.print("  ");
            }

            int col = 1;
            while (col <= row) {
                System.out.printf("%4d", calcTriNumber(row-1, col-1));
                col++;
            }
            System.out.println();
        }
    }

    long calcTriNumber(int row, int col) {

        return calcFactorial(row)/(calcFactorial(col)*(calcFactorial(row-col)));

    }

    long calcFactorial(int number) {

        if (number == 0) {
            return 1;
        }

        else {
            long factorial = 1;
            for (int i = 1; i <= number; i++) {
                factorial *= i;
            }

            return factorial;
        }
    }
}