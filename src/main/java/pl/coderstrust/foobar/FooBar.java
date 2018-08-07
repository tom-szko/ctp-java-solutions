package pl.coderstrust.foobar;

public class FooBar {
    public static void main(String[] args) {
        for (String line : makeFooBarTable(100)) {
            System.out.println(line);
        }
    }

    public static String[] makeFooBarTable(int size) {
        if (size < 0) {
            throw new IllegalArgumentException("Negative array size argument. Array cannot be created.");
        }
        StringBuilder stringBuilder = new StringBuilder();
        String[] fooBarTable = new String[size];
        for (int i = 0, j = 1; i < size; i++, j++) {
            stringBuilder.append(j).append(" ");
            if (j % 3 == 0) {
                stringBuilder.append("Foo");
            }
            if (j % 5 == 0) {
                stringBuilder.append("Bar");
            }
            fooBarTable[i] = stringBuilder.toString();
            stringBuilder.delete(0, stringBuilder.length());
        }
        return fooBarTable;
    }
}
