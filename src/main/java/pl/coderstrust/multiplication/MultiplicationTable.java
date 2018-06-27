package pl.coderstrust.multiplication;

public class MultiplicationTable {

    public static void main(String[] args) {
        MultiplicationTable table = new MultiplicationTable();

        // Sample implementation (3x3)
        table.printMultiplicationTable(3);
        System.out.println();

        // Sample implementation (5x5)
        table.printMultiplicationTable(5);
        System.out.println();

        // Sample implementation (12x12)
        table.printMultiplicationTable(12);
        System.out.println();
    }

    void printMultiplicationTable(int size) {

        int longestNumber = String.valueOf(size*size).length();
        StringBuilder sb = new StringBuilder();

        // Creating white space template
        for (int i = 1; i<=longestNumber; i++) {
            sb.append(" ");
        }

        //Printing (first) empty cell
        System.out.print(sb.toString()+sb.toString());

        //Printing first row
        for (int i = 1; i <= size; i++) {
            System.out.printf("%" + longestNumber + "d" + sb.toString(), i);
        }
        System.out.println();

        //Printing other rows
        for (int i = 1; i <= size; i++) {
            System.out.printf("%" + longestNumber + "d" + sb.toString(), i);
            for (int k = 1; k <= size; k++) {
                int s = i*k;
                System.out.printf("%" + longestNumber + "d" + sb.toString(), s);
            }
            System.out.println();
        }
    }
}