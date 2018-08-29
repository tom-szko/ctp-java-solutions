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
public class RectangleTest {
    private static final double PRECISION = 0.1;

    @Rule
    public ExpectedException exception = ExpectedException.none();

    @Test
    public void testCalculateRectangleArea() {
        //given
        Rectangle rectangle = new Rectangle(5, 6.5);
        double expectedArea = 32.5;

        //when
        double actualArea = rectangle.calculateArea();

        //then
        assertEquals(expectedArea, actualArea, PRECISION);
    }

    @Test
    public void testDefaultRectangleConstructor() {
        //given
        double expectedWidth = 0;
        double expectedHeight = 0;

        //when
        Rectangle rectangle = new Rectangle();

        //then
        assertThat(rectangle.getWidth(), is(expectedWidth));
        assertThat(rectangle.getHeight(), is(expectedHeight));
    }

    @Test
    public void testRectangleGetters() {
        //given
        Rectangle rectangle = new Rectangle(7,4);
        double expectedWidth = 7;
        double expectedHeight = 4;

        //when
        double actualWidth = rectangle.getWidth();
        double actualHeight = rectangle.getHeight();

        //then
        assertThat(actualWidth, is(expectedWidth));
        assertThat(actualHeight, is(expectedHeight));
    }

    @Test
    public void testRectangleSetters() {
        //given
        Rectangle rectangle = new Rectangle();
        double expectedWidth = 7;
        double expectedHeight = 4;

        //when
        rectangle.setWidth(7);
        rectangle.setHeight(4);

        //then
        assertThat(rectangle.getWidth(), is(expectedWidth));
        assertThat(rectangle.getHeight(), is(expectedHeight));
    }

    @Test
    @Parameters(method = "illegalWidthParameters")
    public void testIllegalRectangleWidthValue(double width, double height, String message) throws IllegalArgumentException {
        //given
        exception.expect(IllegalArgumentException.class);
        exception.expectMessage(message);

        //when
        new Rectangle(width, height);
    }

    private Object[] illegalWidthParameters() {
        return new Object[]{
                new Object[]{-1, 8, "Width cannot be equal to 0 or less than 0."},
                new Object[]{Double.MAX_VALUE + Math.ulp(Double.MAX_VALUE) / 2, 4, "Width cannot be greater than max double value (" + Double.MAX_VALUE + ")."},
        };
    }

    @Test
    @Parameters(method = "illegalHeightParameters")
    public void testIllegalRectangleHeightValue(double width, double height, String message) throws IllegalArgumentException {
        //given
        exception.expect(IllegalArgumentException.class);
        exception.expectMessage(message);

        //when
        new Rectangle(width, height);
    }

    private Object[] illegalHeightParameters() {
        return new Object[]{
                new Object[]{5, -1, "Height cannot be equal to 0 or less than 0."},
                new Object[]{4, Double.MAX_VALUE + Math.ulp(Double.MAX_VALUE) / 2, "Height cannot be greater than max double value (" + Double.MAX_VALUE + ")."},
        };
    }

    @Test
    @Parameters(method = "illegalWidthSetterParameters")
    public void testRectangleWidthSetterValidation(double width, String message) throws IllegalArgumentException {
        //given
        Rectangle rectangle = new Rectangle(5, 4);
        exception.expect(IllegalArgumentException.class);
        exception.expectMessage(message);

        //when
        rectangle.setWidth(width);
    }

    private Object[] illegalWidthSetterParameters() {
        return new Object[]{
                new Object[]{-1, "Width cannot be equal to 0 or less than 0."},
                new Object[]{Double.MAX_VALUE + Math.ulp(Double.MAX_VALUE) / 2, "Width cannot be greater than max double value (" + Double.MAX_VALUE + ")."},
        };
    }

    @Test
    @Parameters(method = "illegalHeightSetterParameters")
    public void testRectangleHeightSetterValidation(double height, String message) throws IllegalArgumentException {
        //given
        Rectangle rectangle = new Rectangle(5, 4);
        exception.expect(IllegalArgumentException.class);
        exception.expectMessage(message);

        //when
        rectangle.setHeight(height);
    }

    private Object[] illegalHeightSetterParameters() {
        return new Object[]{
                new Object[]{-1, "Height cannot be equal to 0 or less than 0."},
                new Object[]{Double.MAX_VALUE + Math.ulp(Double.MAX_VALUE) / 2, "Height cannot be greater than max double value (" + Double.MAX_VALUE + ")."},
        };
    }
}
