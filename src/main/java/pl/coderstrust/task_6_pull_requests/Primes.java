package pl.coderstrust.task_6_pull_requests;

public class Primes {
    private static int cell = 0;

    public static void main(String[] args) {
        printPrimes(1000);
    }

    private static void printPrimes(int range) {
        int k = 1;
        int n = 1;
        while (k <= range) {
            if (checkIfPrime(n)) {
                printNumber(n);
                k++;
            }
            n++;
        }
    }

    private static void printNumber(int n) {
        if (cell < 9) {
            System.out.printf("    %5d", n);
            cell++;
        } else {
            System.out.printf("    %5d\n", n);
            cell = 0;
        }
    }

    private static boolean checkIfPrime(int number) {
        boolean isPrime = true;
        if (number <= 1) {
            isPrime = false;
        } else {
            for (int i = 2; i <= (long) Math.sqrt(number); i++) {
                if (number % i == 0) {
                    isPrime = false;
                }
            }
        }
        return isPrime;
    }
}