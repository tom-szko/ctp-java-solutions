package pl.coderstrust.multiplication;

public class MultiplicationTable {

    public static void main(String[] args) {
        MultiplicationTable table = new MultiplicationTable();

        table.printMultiplicationTable(3);
        System.out.println();

        table.printMultiplicationTable(5);
        System.out.println();

        table.printMultiplicationTable(12);
    }

    void printMultiplicationTable(int size) {
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

    String createTableCell(int size) {
        int longestNumber = String.valueOf(size * size).length();
        String whiteSpace = "";

        for (int i = 1; i <= longestNumber; i++) {
            whiteSpace += " ";
        }

        return whiteSpace + "%" + longestNumber + "s";
    }
}