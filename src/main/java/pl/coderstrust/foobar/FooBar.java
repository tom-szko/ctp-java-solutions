package pl.coderstrust.foobar;

public class FooBar {
    public static void main(String[] args) {
        for (String line : makeFooBarTable(100)) {
            System.out.println(line);
        }
    }

    public static String[] makeFooBarTable(int number) {
        String[] fooBarTable = new String[number];
        for (int i = 0, j = 1; i < number; i++, j++) {
            String line = String.format(j + " ");
            if (j % 3 == 0) {
                line += "Foo";
            }
            if (j % 5 == 0) {
                line += "Bar";
            }
            fooBarTable[i] = line;
        }
        return fooBarTable;
    }
}
