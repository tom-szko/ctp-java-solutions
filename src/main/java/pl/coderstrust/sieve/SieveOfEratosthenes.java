package pl.coderstrust.sieve;

import java.util.Arrays;

public class SieveOfEratosthenes {
    private static final int MARKER_VALUE = 0;

    public static void main(String[] args) {
        System.out.println(Arrays.toString(sieve(123)));
    }

    private static int[] sieve(int maximumNumber) {
        int[] numbers = new int[maximumNumber - 1];
        fillArrayWithValues(numbers, 2);
        for (int j = 2; j <= (int) Math.sqrt(maximumNumber); j++) {
            for (int k = j; k < maximumNumber - 1; k++) {
                if (numbers[k] % j == 0) {
                    numbers[k] = MARKER_VALUE;
                }
            }
        }
        int[] primes = new int[countNonMarkerValues(numbers)];
        return fillArrayWithNonMarkerValues(numbers, primes);
    }

    private static void fillArrayWithValues(int[] array, int value) {
        for (int i = 0; i < array.length; i++) {
            array[i] = value;
            value++;
        }
    }

    private static int countNonMarkerValues(int[] array) {
        int numberOfPrimes = 0;
        for (int number : array) {
            if (number != MARKER_VALUE) {
                numberOfPrimes++;
            }
        }
        return numberOfPrimes;
    }

    private static int[] fillArrayWithNonMarkerValues(int[] arrayWithZeroes, int[] arrayWithoutZeroes) {
        int count = 0;
        for (int number : arrayWithZeroes) {
            if (number != MARKER_VALUE) {
                arrayWithoutZeroes[count] = number;
                count++;
            }
        }
        return arrayWithoutZeroes;
    }
}
