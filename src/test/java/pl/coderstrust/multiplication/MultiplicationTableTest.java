package pl.coderstrust.multiplication;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class MultiplicationTableTest {

    @Rule
    public ExpectedException exception = ExpectedException.none();

    @Test
    public void testForSizeOfSix() {
        //given
        int size = 6;
        List<String> expected = Arrays.asList
                (
                        "       1   2   3   4   5   6",
                        "   1   1   2   3   4   5   6",
                        "   2   2   4   6   8  10  12",
                        "   3   3   6   9  12  15  18",
                        "   4   4   8  12  16  20  24",
                        "   5   5  10  15  20  25  30",
                        "   6   6  12  18  24  30  36"
                );

        //when
        List<String> actual = MultiplicationTable.generateMultiplicationTable(size);

        //then
        assertEquals(actual, expected);
    }

    @Test
    public void testForSizeOfOne() {
        //given
        int size = 1;
        List<String> expected = Arrays.asList
                (
                        "   1",
                        " 1 1"
                );

        //when
        List<String> actual = MultiplicationTable.generateMultiplicationTable(size);

        //then
        assertEquals(actual, expected);
    }

    @Test
    public void testForSizeOfLessThanOne() throws IllegalArgumentException {
        int size = -1;
        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("Table size argument cannot be less than 0.");
        MultiplicationTable.generateMultiplicationTable(size);
    }
}
