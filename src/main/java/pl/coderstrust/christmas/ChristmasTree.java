package pl.coderstrust.christmas;

public class ChristmasTree {

    public static void main(String[] args) {
        ChristmasTree tree = new ChristmasTree();

        tree.printChristmasTree(5);
        System.out.println();

        tree.printChristmasTree(10);
        System.out.println();

        tree.printChristmasTree(16);
    }

    void printChristmasTree(int size) {
        int row = 1;

        while (row <= size) {

            for (int i = 0; i < size - row; i++) {
                System.out.print(" ");
            }

            for (int s = 1; s <= row * 2 - 1; s++) {
                System.out.print("*");
            }
            System.out.println();
            row++;
        }

        printTreeTrunk(size);
    }

    void printTreeTrunk(int size) {
        for (int i = 0; i < size - 2; i++) {
            System.out.print(" ");
        }

        System.out.print("**");
    }
}