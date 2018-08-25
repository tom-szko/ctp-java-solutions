package pl.coderstrust.hoare;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertArrayEquals;

@RunWith(JUnitParamsRunner.class)
public class HoarePartitionTest {

    HoarePartition hoare;

    @Rule
    public ExpectedException exception = ExpectedException.none();

    @Before
    public void setUp() {
        hoare = new HoarePartition();
    }

    @Test
    public void testEmptyArray() {
        //given
        int pivotIndex = 0;
        int[] input = new int[0];
        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("Array cannot be empty.");

        //when
        hoare.partition(input, pivotIndex);
    }

    @Test
    public void testNullAsArray() {
        //given
        int pivotIndex = 0;
        int[] input = null;
        exception.expect(NullPointerException.class);
        exception.expectMessage("Array cannot be null.");

        //when
        hoare.partition(input, pivotIndex);
    }


    @Test
    @Parameters(method = "pivotValues")
    public void testPivotIndexes(int pivotIndex, int[] array, String message) {
        //given
        exception.expect(IllegalArgumentException.class);
        exception.expectMessage(message);

        //when
        hoare.partition(array, pivotIndex);
    }

    private Object[] pivotValues() {
        return new Object[]{
                new Object[]{-5, new int[]{1, 2, 3, 4}, "Pivot index cannot be less than zero."},
                new Object[]{17, new int[]{1, 2, 3, 4, 5, 6}, "Pivot index must be less than array size."},
                new Object[]{4, new int[]{1, 2, 3, 4}, "Pivot index must be less than array size."},
        };
    }

    @Test
    @Parameters(method = "sampleArrays")
    public void testSampleArrays(int pivotIndex, int[] input, int[] expected) {
        //when
        int[] actual = hoare.partition(input, pivotIndex);

        //then
        assertArrayEquals(expected, actual);
    }

    private Object[] sampleArrays() {
        return new Object[]{
                new Object[]{2, new int[]{3, 2, 1}, new int[]{1, 2, 3}},
                new Object[]{1, new int[]{1, 2, 3}, new int[]{1, 2, 3}},
                new Object[]{0, new int[]{4, 6, 6, 0, 0}, new int[]{0, 0, 4, 6, 6}},
                new Object[]{3, new int[]{4, 4, 4, 4, 4, 4}, new int[]{4, 4, 4, 4, 4, 4}},
                new Object[]{5, new int[]{3, 3, 3, 3, 1, 1, 1, 1}, new int[]{1, 1, 1, 1, 3, 3, 3, 3}},
                new Object[]{0, new int[]{3, 0, 0, 0, 0}, new int[]{0, 0, 0, 0, 3}},
                new Object[]{0, new int[]{3, 3, 3, 3, 0}, new int[]{0, 3, 3, 3, 3}},
        };
    }
}
