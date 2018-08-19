package pl.coderstrust.figures;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.*;

public class TriangleTest {
    private static final double PRECISION = 0.1;

    @Rule
    public ExpectedException exception = ExpectedException.none();

    @Test
    public void testCalculateTriangleArea() {
        //given
        double base = 5;
        double height = 3;
        Triangle triangle = new Triangle(base, height);
        double expected = 7.5;

        //when
        double actual = triangle.calculateArea();

        //then
        assertEquals(expected, actual, PRECISION);
    }

    @Test
    public void testIllegalHeightValue() throws IllegalArgumentException {
        double height = -1;
        double base = 8;
        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("Height cannot take negative value.");
        new Triangle(base, height);
    }

    @Test
    public void testIllegalBaseValue() throws IllegalArgumentException {
        double height = 5;
        double base = -1;
        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("Base cannot take negative value.");
        new Triangle(base, height);
    }
}
