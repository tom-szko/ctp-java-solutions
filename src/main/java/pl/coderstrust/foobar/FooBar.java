package pl.coderstrust.foobar;

public class FooBar {
    public static void main(String[] args) {
        for (String line : makeFooBarTable(100)) {
            System.out.println(line);
        }
    }

    public static String[] makeFooBarTable(int number) {
        if (number < 0) {
            throw new IllegalArgumentException("Negative array size argument. Array cannot be created.");
        } else {
            StringBuilder line = new StringBuilder();
            String[] fooBarTable = new String[number];
            for (int i = 0, j = 1; i < number; i++, j++) {
                line.append(j).append(" ");
                if (j % 3 == 0) {
                    line.append("Foo");
                }
                if (j % 5 == 0) {
                    line.append("Bar");
                }
                fooBarTable[i] = line.toString();
                line.delete(0, line.length());
            }
            return fooBarTable;
        }
    }
}
