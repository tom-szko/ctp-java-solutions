package pl.coderstrust.hoare;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.assertArrayEquals;

public class HoarePartitionTest {

    @Rule
    public ExpectedException exception = ExpectedException.none();

    @Test
    public void testEmptyArray() {
        HoarePartition hoare = new HoarePartition();
        int pivotIndex = 0;
        int[] input = new int[0];
        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("Array cannot be null or has length of 0.");
        hoare.partition(input, pivotIndex);
    }

    @Test
    public void testNull() {
        HoarePartition hoare = new HoarePartition();
        int pivotIndex = 0;
        int[] input = null;
        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("Array cannot be null or has length of 0.");
        hoare.partition(input, pivotIndex);
    }

    @Test
    public void testPivotIndexOutOfBounds() {
        HoarePartition hoare = new HoarePartition();
        int pivotIndex = 10;
        int[] input = {1, 2, 3, 4};
        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("Pivot index cannot be >= array.length and < 0");
        hoare.partition(input, pivotIndex);
    }

    @Test
    public void testDescendingOrder() {
        //given
        HoarePartition hoare = new HoarePartition();
        int pivotIndex = 2;
        int[] input = {3, 2, 1};
        int[] expected = {1, 2, 3};

        //when
        int[] actual = hoare.partition(input, pivotIndex);

        //then
        assertArrayEquals(expected, actual);
    }

    @Test
    public void testAscendingOrder() {
        //given
        HoarePartition hoare = new HoarePartition();
        int pivotIndex = 1;
        int[] input = {1, 2, 3};
        int[] expected = {1, 2, 3};

        //when
        int[] actual = hoare.partition(input, pivotIndex);

        //then
        assertArrayEquals(expected, actual);
    }

    @Test
    public void testDuplicatesOfDifferentValues() {
        //given
        HoarePartition hoare = new HoarePartition();
        int pivotIndex = 0;
        int[] input = {4, 6, 6, 0, 0};
        int[] expected = {0, 0, 4, 6, 6};

        //when
        int[] actual = hoare.partition(input, pivotIndex);

        //then
        assertArrayEquals(expected, actual);
    }

    @Test
    public void testDuplicatesOfSameValue() {
        //given
        HoarePartition hoare = new HoarePartition();
        int pivotIndex = 3;
        int[] input = {4, 4, 4, 4, 4, 4};
        int[] expected = {4, 4, 4, 4, 4, 4};

        //when
        int[] actual = hoare.partition(input, pivotIndex);

        //then
        assertArrayEquals(expected, actual);
    }

    @Test
    public void testTwoGroupsOfSameValues() {
        //given
        HoarePartition hoare = new HoarePartition();
        int pivotIndex = 5;
        int[] input = {3, 3, 3, 3, 1, 1, 1, 1};
        int[] expected = {1, 1, 1, 1, 3, 3, 3, 3};

        //when
        int[] actual = hoare.partition(input, pivotIndex);

        //then
        assertArrayEquals(expected, actual);
    }

    @Test
    public void testUniqueValueAtLowEnd() {
        //given
        HoarePartition hoare = new HoarePartition();
        int pivotIndex = 0;
        int[] input = {3, 0, 0, 0, 0};
        int[] expected = {0, 0, 0, 0, 3};

        //when
        int[] actual = hoare.partition(input, pivotIndex);

        //then
        assertArrayEquals(expected, actual);
    }

    @Test
    public void testUniqueValueAtHiEnd() {
        //given
        HoarePartition hoare = new HoarePartition();
        int pivotIndex = 0;
        int[] input = {3, 3, 3, 3, 0};
        int[] expected = {0, 3, 3, 3, 3};

        //when
        int[] actual = hoare.partition(input, pivotIndex);

        //then
        assertArrayEquals(expected, actual);
    }
}
