package pl.coderstrust.sieve;

import java.util.Arrays;

public class SieveOfEratosthenes {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(sieve(123)));
    }

    private static int[] sieve(int maximumNumber) {
        int[] arrayOfNumbers = new int[maximumNumber - 1];
        fillArrayWithNumbers(arrayOfNumbers, 2);

        for (int j = 2; j <= (int) Math.sqrt(maximumNumber); j++) {
            for (int k = j; k < maximumNumber - 1; k++) {
                if (arrayOfNumbers[k] % j == 0) {
                    arrayOfNumbers[k] = 0;
                }
            }
        }
        int numberOfPrimes = 0;
        for (int item : arrayOfNumbers) {
            if (item != 0) {
                numberOfPrimes++;
            }
        }
        int[] arrayOfPrimes = new int[numberOfPrimes];
        int count = 0;
        for (int item : arrayOfNumbers) {
            if (item != 0) {
                arrayOfPrimes[count] = item;
                count++;
            }
        }
        return arrayOfPrimes;
    }

    private static void fillArrayWithNumbers(int[] array, int firstNumber) {
        for (int i = 0; i < array.length; i++) {
            array[i] = firstNumber;
            firstNumber++;
        }
    }
}