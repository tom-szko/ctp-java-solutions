package pl.coderstrust.figures;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.*;

public class RectangleTest {
    private static final double PRECISION = 0.1;

    @Rule
    public ExpectedException exception = ExpectedException.none();

    @Test
    public void testCalculateRectangleArea() {
        //given
        double width = 5;
        double height = 6.5;
        Rectangle rectangle = new Rectangle(width, height);
        double expected = 32.5;

        //when
        double actual = rectangle.calculateArea();

        //then
        assertEquals(expected, actual, PRECISION);
    }

    @Test
    public void testIllegalHeightValue() throws IllegalArgumentException {
        double height = -3;
        double width = 2;
        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("Height cannot take negative value.");
        new Rectangle(width, height);
    }

    @Test
    public void testIllegalWidthValue() throws IllegalArgumentException {
        double height = 2;
        double width = -3;
        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("Width cannot take negative value.");
        new Rectangle(width, height);
    }
}
