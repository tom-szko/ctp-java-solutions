package pl.coderstrust.figures;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.*;

public class SquareTest {
    private static final double PRECISION = 0.1;

    @Rule
    public ExpectedException exception = ExpectedException.none();

    @Test
    public void testCalculateSquareArea() {
        //given
        double side = 5;
        Square square = new Square(side);
        double expected = 25;

        //when
        double actual = square.calculateArea();

        //then
        assertEquals(expected, actual, PRECISION);
    }

    @Test
    public void testIllegalSideValue() throws IllegalArgumentException {
        double side = -3;
        exception.expect(IllegalArgumentException.class);
        new Square(side);
    }
}
