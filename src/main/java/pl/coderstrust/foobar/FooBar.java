package pl.coderstrust.foobar;

public class FooBar {

    public static void main(String[] args) {

        for (int i = 1; i <= 100; i++) {

            System.out.printf("%3d ", i);

            // Reminder from division by 3 equals 0, Foo is printed.
            if (i % 3 == 0) {
                System.out.print("Foo");
            }
            // Reminder from division by 5 equals 0, Bar is printed.
            if (i % 5 == 0) {
                System.out.print("Bar");
            }
            // If both above conditions are true reminder from division by 15 equals 0 and FooBar phrase is printed.

            System.out.println();

        }

    }
}