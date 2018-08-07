package pl.coderstrust.sieve;

import java.util.Arrays;

public class SieveOfEratosthenes {
    private static final int MARKER_VALUE = 0;

    public static void main(String[] args) {
        System.out.println(Arrays.toString(sieve(127)));
    }

    private static int[] sieve(int maximumNumber) {
        int[] numbers = initArray(maximumNumber);
        for (int j = 2; j <= (int) Math.sqrt(maximumNumber); j++) {
            markMultiples(numbers, j);
        }
        return filterPrimes(numbers);
    }

    private static void markMultiples(int[] array, int multiple) {
        for (int nextMultiple = 2 * multiple; nextMultiple < array.length + 2; nextMultiple += multiple) {
            array[nextMultiple - 2] = MARKER_VALUE;
        }
    }

    private static int[] initArray(int max) {
        int[] result = new int[max - 1];
        for (int i = 0; i < result.length; i++) {
            result[i] = i + 2;
        }
        return result;
    }

    private static int countPrimes(int[] array) {
        int numberOfPrimes = 0;
        for (int number : array) {
            if (number != MARKER_VALUE) {
                numberOfPrimes++;
            }
        }
        return numberOfPrimes;
    }

    private static int[] filterPrimes(int[] array) {
        int count = 0;
        int[] primes = new int[countPrimes(array)];
        for (int number : array) {
            if (number != MARKER_VALUE) {
                primes[count] = number;
                count++;
            }
        }
        return primes;
    }
}
