package pl.coderstrust.figures;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

@RunWith(JUnitParamsRunner.class)
public class TriangleTest {
    private static final double PRECISION = 0.1;

    @Rule
    public ExpectedException exception = ExpectedException.none();

    @Test
    public void testCalculateTriangleArea() {
        //given
        Triangle triangle = new Triangle(5, 3);
        double expectedArea = 7.5;

        //when
        double actualArea = triangle.calculateArea();

        //then
        assertEquals(expectedArea, actualArea, PRECISION);
    }

    @Test
    public void testDefaultTriangleConstructor() {
        //given
        double expectedBase = 0;
        double expectedHeight = 0;

        //when
        Triangle triangle = new Triangle();

        //then
        assertThat(triangle.getBase(), is(expectedBase));
        assertThat(triangle.getHeight(), is(expectedHeight));
    }

    @Test
    public void testTriangleGetters() {
        //given
        Triangle triangle = new Triangle(7, 4);
        double expectedBase = 7;
        double expectedHeight = 4;

        //when
        double actualBase = triangle.getBase();
        double actualHeight = triangle.getHeight();

        //then
        assertThat(actualBase, is(expectedBase));
        assertThat(actualHeight, is(expectedHeight));
    }

    @Test
    public void testTriangleSetters() {
        //given
        Triangle triangle = new Triangle();
        double expectedBase = 7;
        double expectedHeight = 4;

        //when
        triangle.setBase(7);
        triangle.setHeight(4);

        //then
        assertThat(triangle.getBase(), is(expectedBase));
        assertThat(triangle.getHeight(), is(expectedHeight));
    }

    @Test
    @Parameters(method = "illegalHeightParameters")
    public void testIllegalTriangleHeightValue(double height, double base, String message) throws IllegalArgumentException {
        //given
        exception.expect(IllegalArgumentException.class);
        exception.expectMessage(message);

        //when
        new Triangle(base, height);
    }

    private Object[] illegalHeightParameters() {
        return new Object[]{
                new Object[]{-1, 8, "Height cannot be equal to 0 or less than 0."},
                new Object[]{Double.MAX_VALUE + Math.ulp(Double.MAX_VALUE) / 2, 4, "Height cannot be greater than max double value (" + Double.MAX_VALUE + ")."},
        };
    }

    @Test
    @Parameters(method = "illegalBaseParameters")
    public void testIllegalTriangleBaseValue(double height, double base, String message) throws IllegalArgumentException {
        //given
        exception.expect(IllegalArgumentException.class);
        exception.expectMessage(message);

        //when
        new Triangle(base, height);
    }

    private Object[] illegalBaseParameters() {
        return new Object[]{
                new Object[]{5, -1, "Base cannot be equal to 0 or less than 0."},
                new Object[]{4, Double.MAX_VALUE + Math.ulp(Double.MAX_VALUE) / 2, "Base cannot be greater than max double value (" + Double.MAX_VALUE + ")."},
        };
    }

    @Test
    @Parameters(method = "illegalBaseSetterParameters")
    public void testTriangleBaseSetterValidation(double base, String message) throws IllegalArgumentException {
        //given
        Triangle triangle = new Triangle(5, 4);
        exception.expect(IllegalArgumentException.class);
        exception.expectMessage(message);

        //when
        triangle.setBase(base);
    }

    private Object[] illegalBaseSetterParameters() {
        return new Object[]{
                new Object[]{-1, "Base cannot be equal to 0 or less than 0."},
                new Object[]{Double.MAX_VALUE + Math.ulp(Double.MAX_VALUE) / 2, "Base cannot be greater than max double value (" + Double.MAX_VALUE + ")."},
        };
    }

    @Test
    @Parameters(method = "illegalHeightSetterParameters")
    public void testTriangleHeightSetterValidation(double height, String message) throws IllegalArgumentException {
        //given
        Triangle triangle = new Triangle(5, 4);
        exception.expect(IllegalArgumentException.class);
        exception.expectMessage(message);

        //when
        triangle.setHeight(height);
    }

    private Object[] illegalHeightSetterParameters() {
        return new Object[]{
                new Object[]{-1, "Height cannot be equal to 0 or less than 0."},
                new Object[]{Double.MAX_VALUE + Math.ulp(Double.MAX_VALUE) / 2, "Height cannot be greater than max double value (" + Double.MAX_VALUE + ")."},
        };
    }
}
