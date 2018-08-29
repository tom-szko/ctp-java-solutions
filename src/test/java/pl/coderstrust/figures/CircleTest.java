package pl.coderstrust.figures;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

@RunWith(JUnitParamsRunner.class)
public class CircleTest {
    private static final double PRECISION = 0.1;

    @Rule
    public ExpectedException exception = ExpectedException.none();

    @Test
    public void testCalculateCircleArea() {
        //given
        Circle circle = new Circle(5);
        double expectedArea = 78.5;

        //when
        double actualArea = circle.calculateArea();

        //then
        assertEquals(expectedArea, actualArea, PRECISION);
    }

    @Test
    public void testDefaultCircleConstructor() {
        //given
        double expectedRadius = 0;

        //when
        Circle circle = new Circle();

        //then
        assertThat(circle.getRadius(), is(expectedRadius));
    }

    @Test
    public void testCircleGetter() {
        //given
        Circle circle = new Circle(7);
        double expectedRadius = 7;

        //when
        double actualRadius = circle.getRadius();

        //then
        assertThat(expectedRadius, is(actualRadius));
    }

    @Test
    public void testCircleSetter() {
        //given
        Circle circle = new Circle();
        double expectedRadius = 7;

        //when
        circle.setRadius(7);

        //then
        assertThat(circle.getRadius(), is(expectedRadius));
    }

    @Test
    @Parameters(method = "illegalRadiusParameters")
    public void testIllegalCircleRadiusValue(double radius, String message) throws IllegalArgumentException {
        //given
        exception.expect(IllegalArgumentException.class);
        exception.expectMessage(message);

        //when
        new Circle(radius);
    }

    private Object[] illegalRadiusParameters() {
        return new Object[]{
                new Object[]{-1, "Radius cannot be equal to 0 or less than 0."},
                new Object[]{Double.MAX_VALUE + Math.ulp(Double.MAX_VALUE) / 2, "Radius cannot be greater than max double value (" + Double.MAX_VALUE + ")."},
        };
    }

    @Test
    @Parameters(method = "illegalRadiusSetterParameters")
    public void testCircleRadiusSetterValidation(double radius, String message) throws IllegalArgumentException {
        //given
        Circle circle = new Circle(5);
        exception.expect(IllegalArgumentException.class);
        exception.expectMessage(message);

        //when
        circle.setRadius(radius);
    }

    private Object[] illegalRadiusSetterParameters() {
        return new Object[]{
                new Object[]{-1, "Radius cannot be equal to 0 or less than 0."},
                new Object[]{Double.MAX_VALUE + Math.ulp(Double.MAX_VALUE) / 2, "Radius cannot be greater than max double value (" + Double.MAX_VALUE + ")."},
        };
    }
}
