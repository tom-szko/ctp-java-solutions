package pl.coderstrust.fibonacci;

public class FibonacciRecursive {
    public static void main(String[] args) {
        int fibonacciNumberInOrder = 7;
        try {
            System.out.println(fibonacci(fibonacciNumberInOrder));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    private static long fibonacci(int fibonacciNumberInOrder) {
        if (fibonacciNumberInOrder <= 0) {
            throw new IllegalArgumentException("Invalid input.");
        }
        if (fibonacciNumberInOrder <= 2) {
            return 1;
        }
        return fibonacci(fibonacciNumberInOrder - 1) + fibonacci(fibonacciNumberInOrder - 2);
    }
}
