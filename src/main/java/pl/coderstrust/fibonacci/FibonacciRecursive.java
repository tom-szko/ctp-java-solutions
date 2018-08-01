package pl.coderstrust.fibonacci;

public class FibonacciRecursive {
    public static void main(String[] args) {
        int fibonacciNumberInOrder = 10;
        if (fibonacci(fibonacciNumberInOrder) < 0) {
            System.out.println("Invalid input");
        } else {
            System.out.println(fibonacci(fibonacciNumberInOrder));
        }
    }

    private static long fibonacci(int fibonacciNumberInOrder) {
        if (fibonacciNumberInOrder <= 0) {
            return -1;
        }
        if (fibonacciNumberInOrder == 1 || fibonacciNumberInOrder == 2) {
            return 1;
        }
        return fibonacci(fibonacciNumberInOrder - 1)
                + fibonacci(fibonacciNumberInOrder - 2);
    }
}