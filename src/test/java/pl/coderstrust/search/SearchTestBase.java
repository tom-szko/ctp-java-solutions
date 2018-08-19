package pl.coderstrust.search;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.assertEquals;

public abstract class SearchTestBase {
    @Rule
    public ExpectedException exception = ExpectedException.none();

    public abstract Searchable getSearchMethod();

    @Test
    public void testHugeArray() {
        //given
        int[] hugeArray = new int[100_000_000];
        for (int i = 0; i < hugeArray.length; i++) {
            hugeArray[i] = -50_000_000 + i;
        }
        int element = 1;
        int expected = 50_000_001;

        //when
        long startTime = System.currentTimeMillis();
        int actual = getSearchMethod().search(hugeArray, element);
        long finishTime = System.currentTimeMillis();
        System.out.println(getSearchMethod().getClass() + ": " + (finishTime - startTime) + "ms.");

        //then
        assertEquals(expected, actual);
    }

    @Test
    public void testSampleArray(){
        //given
        int[] testArray = {-6, -4, -1, 0, 3, 7, 16, 21, 24, 28, 45, 67};
        int element = 21;
        int expected = 7;

        //when
        int actual = getSearchMethod().search(testArray, element);

        //then
        assertEquals(expected, actual);
    }

    @Test
    public void testMissingElement(){
        //given
        int[] testArray = {-6, -4, -1, 0, 3, 7, 16, 21, 24, 28, 45, 67};
        int element = 9;
        int expected = -1;

        //when
        int actual = getSearchMethod().search(testArray, element);

        //then
        assertEquals(expected, actual);
    }

    @Test
    public void testEmptyArray() throws IllegalArgumentException {
        int element = 1;
        int[] testArray = new int[0];
        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("Array cannot be empty.");
        getSearchMethod().search(testArray, element);
    }

    @Test
    public void testNull() throws NullPointerException {
        int element = 0;
        int[] testArray = null;
        exception.expect(NullPointerException.class);
        exception.expectMessage("Array cannot be null.");
        getSearchMethod().search(testArray, element);
    }
}
