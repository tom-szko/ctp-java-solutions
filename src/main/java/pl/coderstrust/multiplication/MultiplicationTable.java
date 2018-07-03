package pl.coderstrust.multiplication;

public class MultiplicationTable {

    public static void main(String[] args) {
        printMultiplicationTable(3);
        System.out.println();

        printMultiplicationTable(5);
        System.out.println();

        printMultiplicationTable(12);
    }

    static void printMultiplicationTable(int size) {
        System.out.printf(createTableCell(size), " ");

        for (int i = 1; i <= size; i++) {
            System.out.printf(createTableCell(size), i);
        }
        System.out.println();

        for (int i = 1; i <= size; i++) {
            System.out.printf(createTableCell(size), i);
            for (int k = 1; k <= size; k++) {
                int s = i * k;
                System.out.printf(createTableCell(size), s);
            }
            System.out.println();
        }
    }

    static String createTableCell(int size) {
        int longestNumber = String.valueOf(size * size).length();
        String whiteSpace = "";
        for (int i = 1; i <= longestNumber; i++) {
            whiteSpace += " ";
        }
        return whiteSpace + "%" + longestNumber + "s";
    }
}