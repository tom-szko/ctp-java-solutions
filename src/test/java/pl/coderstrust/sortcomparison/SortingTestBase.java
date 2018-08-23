package pl.coderstrust.sortcomparison;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.*;

public abstract class SortingTestBase {
    @Rule
    public ExpectedException exception = ExpectedException.none();

    public abstract SortingMethod getSortingMethod();

    @Test
    public void testSimpleArray() {
        // given
        int[] given = new int[]{20, 0, 20, 11, -9, 7, -3, 5, 2, 3, 1};
        int[] expected = new int[]{-9, -3, 0, 1, 2, 3, 5, 7, 11, 20, 20};

        // when
        long startTime = System.currentTimeMillis();
        int[] result = getSortingMethod().sort(given);
        long endTime = System.currentTimeMillis();

        System.out.println(endTime - startTime);

        // then
        assertArrayEquals(expected, result);
    }

    @Test
    public void testEmpty() {
        // given
        int[] given = new int[0];
        int[] expected = new int[0];

        // when
        int[] result = getSortingMethod().sort(given);

        // then
        assertArrayEquals(expected, result);
    }

    @Test
    public void testNull() throws NullPointerException {
        int[] given = null;
        exception.expect(NullPointerException.class);
        getSortingMethod().sort(given);
    }
}
