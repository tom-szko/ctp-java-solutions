package pl.coderstrust.figures;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.*;

public class TrapezoidTest {
    private static final double PRECISION = 0.1;

    @Rule
    public ExpectedException exception = ExpectedException.none();

    @Test
    public void testCalculateTrapezoidArea() {
        //given
        double baseOne = 5;
        double baseTwo = 7.3;
        double height = 4.5;
        Trapezoid trapezoid = new Trapezoid(baseOne, baseTwo, height);
        double expected = 27.7;

        //when
        double actual = trapezoid.calculateArea();

        //then
        assertEquals(expected, actual, PRECISION);
    }

    @Test
    public void testIllegalHeightValue() throws IllegalArgumentException {
        double baseOne = 5;
        double baseTwo = 8;
        double height = -3;
        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("Height cannot take negative value.");
        new Trapezoid(baseOne, baseTwo, height);
    }

    @Test
    public void testIllegalBaseOneValue() throws IllegalArgumentException {
        double baseOne = -1;
        double baseTwo = 8;
        double height = 4;
        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("Base cannot take negative value.");
        new Trapezoid(baseOne, baseTwo, height);
    }

    @Test
    public void testIllegalBaseTwoValue() throws IllegalArgumentException {
        double baseOne = 3;
        double baseTwo = -2;
        double height = 4;
        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("Base cannot take negative value.");
        new Trapezoid(baseOne, baseTwo, height);
    }
}
