package pl.coderstrust.sieve;

import java.util.Arrays;

public class SieveOfEratosthenes {
    private static final int ZERO = 0;

    public static void main(String[] args) {
        System.out.println(Arrays.toString(sieve(123)));
    }

    private static int[] sieve(int maximumNumber) {
        int[] numbers = new int[maximumNumber - 1];
        fillArrayWithNumbers(numbers, 2);
        for (int j = 2; j <= (int) Math.sqrt(maximumNumber); j++) {
            for (int k = j; k < maximumNumber - 1; k++) {
                if (numbers[k] % j == ZERO) {
                    numbers[k] = ZERO;
                }
            }
        }
        int[] primes = new int[countNonZeroValues(numbers)];
        return fillArrayWithNonZeroValues(numbers, primes);
    }

    private static void fillArrayWithNumbers(int[] array, int number) {
        for (int i = 0; i < array.length; i++) {
            array[i] = number;
            number++;
        }
    }

    private static int countNonZeroValues(int[] array) {
        int numberOfPrimes = ZERO;
        for (int number : array) {
            if (number != ZERO) {
                numberOfPrimes++;
            }
        }
        return numberOfPrimes;
    }

    private static int[] fillArrayWithNonZeroValues(int[] arrayWithZeroes, int[] arrayWithoutZeroes) {
        int count = ZERO;
        for (int number : arrayWithZeroes) {
            if (number != ZERO) {
                arrayWithoutZeroes[count] = number;
                count++;
            }
        }
        return arrayWithoutZeroes;
    }
}
