package pl.coderstrust.fibonaccichecker;

import java.util.HashSet;
import java.util.Set;

public class FibonacciChecker {
    private static Set<Long> cacheFibonacci = new HashSet<>();
    private static Set<Long> cacheNonFibonacci = new HashSet<>();

    public boolean isFibonacciNumber(long number) {
        if (number <= 0) {
            return false;
        }
        if (cacheFibonacci.contains(number)) {
            return true;
        }
        if (cacheNonFibonacci.contains(number)) {
            return false;
        }
        if ((((Math.sqrt((5 * number * number) + 4)) % 1) == 0) || (((Math.sqrt((5 * number * number) - 4)) % 1) == 0)) {
            cacheFibonacci.add(number);
            return true;
        }
        cacheNonFibonacci.add(number);
        return false;
    }
}
