package pl.coderstrust.foobar;

public class FooBar {

    public static void main(String[] args) {
        for (int i = 1; i <= 100; i++) {
            System.out.printf("%3d ", i);

            if (i % 3 == 0) {
                System.out.print("Foo");
            }

            if (i % 5 == 0) {
                System.out.print("Bar");
            }

            System.out.println();
        }
    }
}