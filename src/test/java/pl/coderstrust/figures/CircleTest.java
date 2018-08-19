package pl.coderstrust.figures;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.*;

public class CircleTest {
    private static final double PRECISION = 0.1;

    @Rule
    public ExpectedException exception = ExpectedException.none();

    @Test
    public void testCalculateCircleArea() {
        //given
        double radius = 5;
        Circle circle = new Circle(radius);
        double expected = 78.5;

        //when
        double actual = circle.calculateArea();

        //then
        assertEquals(expected, actual, PRECISION);
    }

    @Test
    public void testIllegalRadiusValue() throws IllegalArgumentException {
        double radius = -3;
        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("Radius cannot have negative value.");
        new Circle(radius);
    }
}
