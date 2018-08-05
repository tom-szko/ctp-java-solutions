package pl.coderstrust.fibonacci;

public class FibonacciIterative {
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
        int previousFibonacciNumber = 1;
        int fibonacciNumber = 1;
        for (int i = 2; i < fibonacciNumberInOrder; i++) {
            int temp = fibonacciNumber;
            fibonacciNumber += previousFibonacciNumber;
            previousFibonacciNumber = temp;
        }
        return fibonacciNumber;
    }
}
