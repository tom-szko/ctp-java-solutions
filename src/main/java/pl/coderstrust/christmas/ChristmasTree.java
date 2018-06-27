package pl.coderstrust.christmas;

public class ChristmasTree {

    public static void main(String[] args) {

        ChristmasTree tree = new ChristmasTree();
        tree.printChristmasTree(10);
    }

    void printChristmasTree(int size) {

        /*------ PRINTING TREETOP --------*/

        //Calculating maximum row length

        int rowLength = 1;
        for (int i = 1; i < size; i++) {
            rowLength += 2;
        }

        //Loop for printing rows

        int starsInRow = 1;
        int col = 0;

        for (int row_number = 1; row_number <= size; row_number++) {

            col = 1;
            while (col <= rowLength) {

                if ((col < (rowLength - ((rowLength - starsInRow) / 2) + 1)) && (col > ((rowLength - starsInRow) / 2))) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
                col++;
            }
            System.out.println("");
            starsInRow += 2;

        }

        /*------ PRINTING TREE TRUNK --------*/

        col = 1;
        starsInRow = 3;
        while (col <= rowLength) {

            if ((col < (rowLength - ((rowLength - starsInRow) / 2))) && (col > ((rowLength - starsInRow) / 2))) {
                System.out.print("*");
            } else {
                System.out.print(" ");
            }
            col++;
        }

    }
}