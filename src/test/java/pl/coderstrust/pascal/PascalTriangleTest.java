package pl.coderstrust.pascal;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;
import static pl.coderstrust.pascal.PascalTriangle.*;


@RunWith(JUnitParamsRunner.class)
public class PascalTriangleTest {

    @Rule
    public ExpectedException exception = ExpectedException.none();

    @Test
    @Parameters({"0|1", "1|1", "2|2", "3|6", "4|24", "5|120", "6|720", "7|5040"})
    public void testFactorial(int number, long expected) {
        assertThat(getFactorial(number), is(equalTo(expected)));
    }

    @Test
    public void testForFiveRows() {
        //given
        int triangleRows = 5;
        List<String> expected = Arrays.asList
                (
                        "           1",
                        "         1   1",
                        "       1   2   1",
                        "     1   3   3   1",
                        "   1   4   6   4   1"
                );

        //when
        List<String> actual = getPascalTriangle(triangleRows);

        //then
        assertThat(actual, is(equalTo(expected)));
    }

    @Test
    public void testForZeroRows() {
        //given
        int triangleRows = 0;
        List<String> expected = Arrays.asList();

        //when
        List<String> actual = getPascalTriangle(triangleRows);

        //then
        assertThat(actual, is(equalTo(expected)));
    }

    @Test
    public void testForNegativeNumbers() throws IllegalArgumentException {
        int triangleRows = -1;
        exception.expect(IllegalArgumentException.class);
        getPascalTriangle(triangleRows);
    }
}
