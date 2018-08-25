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
    public void testDefaultSquareConstructor() {
        //given
        double expectedWidth = 0;
        double expectedHeight = 0;

        //when
        Square square = new Square();

        //then
        assertThat(square.getWidth(), is(expectedWidth));
        assertThat(square.getHeight(), is(expectedHeight));
    }

    @Test
    public void testSquareWidthSetter() {
        //given
        Square square = new Square();
        double expectedWidth = 4;
        double expectedHeight = 4;

        //when
        square.setWidth(4);

        //then
        assertThat(square.getWidth(), is(expectedWidth));
        assertThat(square.getHeight(), is(expectedHeight));
    }

    @Test
    public void testSquareHeightSetter() throws UnsupportedOperationException {
        //given
        Square square = new Square();
        exception.expect(UnsupportedOperationException.class);
        exception.expectMessage("This method is not supported. Use setWidth parameter to change rectangle size.");

        //when
        square.setHeight(4);
    }

    @Test
    @Parameters(method = "illegalWidthParameters")
    public void testIllegalSquareWidthValue(double width, String message) throws IllegalArgumentException {
        //given
        exception.expect(IllegalArgumentException.class);
        exception.expectMessage(message);

        //when
        new Square(width);
    }

    private Object[] illegalWidthParameters() {
        return new Object[]{
                new Object[]{-1, "Width cannot be equal to 0 or less than 0."},
                new Object[]{Double.MAX_VALUE + Math.ulp(Double.MAX_VALUE) / 2, "Width cannot be greater than max double value (" + Double.MAX_VALUE + ")."},
        };
    }

    @Test
    @Parameters(method = "illegalWidthSetterParameters")
    public void testSquareWidthSetterValidation(double width, String message) throws IllegalArgumentException {
        //given
        Square square = new Square();
        exception.expect(IllegalArgumentException.class);
        exception.expectMessage(message);

        //when
        square.setWidth(width);
    }

    private Object[] illegalWidthSetterParameters() {
        return new Object[]{
                new Object[]{-1, "Side cannot be equal to 0 or less than 0."},
                new Object[]{Double.MAX_VALUE + Math.ulp(Double.MAX_VALUE) / 2, "Side cannot be greater than max double value (" + Double.MAX_VALUE + ")."},
        };
    }
}
