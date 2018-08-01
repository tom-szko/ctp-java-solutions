package pl.coderstrust.fibonacci;

public class FibonacciIterative {
    public static void main(String[] args) {
        int fibonacciNumberInOrder = 7;
        if (fibonacci(fibonacciNumberInOrder) < 0) {
            System.out.println("Invalid input");
        }  else {
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
        int a = 1;
        int b = 1;
        int temp;
        int count = 0;
        while (count < fibonacciNumberInOrder - 2) {
            temp = b;
            b = b + a;
            a = temp;
            count++;
        }
        return b;
    }
}