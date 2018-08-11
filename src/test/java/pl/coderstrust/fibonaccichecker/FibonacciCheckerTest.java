package pl.coderstrust.fibonaccichecker;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

@RunWith(JUnitParamsRunner.class)
public class FibonacciCheckerTest {

    private FibonacciChecker fibonacciChecker;

    @Before
    public void initialize() {
        fibonacciChecker = new FibonacciChecker();
    }

    @Test
    @Parameters({"1, true", "2, true", "3, true", "5, true", "8, true", "13, true", "21, true", "34, true",
            "4, false", "6, false", "7, false", "9, false", "10, false", "11, false", "12, false", "14, false"})
    public void testForPositiveNumbers(long number, boolean isFibonacci) {
        assertThat(fibonacciChecker.isFibonacciNumber(number), is(isFibonacci));
    }

    @Test
    @Parameters({"-10, false", "-3, false", "-1, false"})
    public void testForNegativeNumbers(long number, boolean isFibonacci) {
        assertThat(fibonacciChecker.isFibonacciNumber(number), is(isFibonacci));
    }

    @Test
    @Parameters({"0, false"})
    public void testForZero(long number, boolean isFibonacci) {
        assertThat(fibonacciChecker.isFibonacciNumber(number), is(isFibonacci));
    }

    @Test
    @Parameters({"0, false"})
    public void testForDuplicates(long number, boolean isFibonacci) {
        assertThat(fibonacciChecker.isFibonacciNumber(number), is(isFibonacci));
    }
}
