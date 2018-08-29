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
    public void testDefaultTrapezoidConstructor() {
        //given
        double expectedBaseOne = 0;
        double expectedBaseTwo = 0;
        double expectedHeight = 0;

        //when
        Trapezoid trapezoid = new Trapezoid();

        //then
        assertThat(trapezoid.getBaseOne(), is(expectedBaseOne));
        assertThat(trapezoid.getBaseTwo(), is(expectedBaseTwo));
        assertThat(trapezoid.getHeight(), is(expectedHeight));
    }

    @Test
    public void testTrapezoidGetters() {
        //given
        Trapezoid trapezoid = new Trapezoid(7, 5, 4);
        double expectedBaseOne = 7;
        double expectedBaseTwo = 5;
        double expectedHeight = 4;

        //when
        double actualBaseOne = trapezoid.getBaseOne();
        double actualBaseTwo = trapezoid.getBaseTwo();
        double actualHeight = trapezoid.getHeight();

        //then
        assertThat(actualBaseOne, is(expectedBaseOne));
        assertThat(actualBaseTwo, is(expectedBaseTwo));
        assertThat(actualHeight, is(expectedHeight));
    }

    @Test
    public void testTrapezoidSetters() {
        //given
        Trapezoid trapezoid = new Trapezoid();
        double expectedBaseOne = 7;
        double expectedBaseTwo = 5;
        double expectedHeight = 4;

        //when
        trapezoid.setBaseOne(7);
        trapezoid.setBaseTwo(5);
        trapezoid.setHeight(4);

        //then
        assertThat(trapezoid.getBaseOne(), is(expectedBaseOne));
        assertThat(trapezoid.getBaseTwo(), is(expectedBaseTwo));
        assertThat(trapezoid.getHeight(), is(expectedHeight));
    }

    @Test
    @Parameters(method = "illegalHeightParameters")
    public void testIllegalTrapezoidHeightValue(double height, String message) throws IllegalArgumentException {
        //given
        exception.expect(IllegalArgumentException.class);
        exception.expectMessage(message);

        //when
        new Trapezoid(7, 4, height);
    }

    private Object[] illegalHeightParameters() {
        return new Object[]{
                new Object[]{-1, "Height cannot be equal to 0 or less than 0."},
                new Object[]{Double.MAX_VALUE + Math.ulp(Double.MAX_VALUE) / 2, "Height cannot be greater than max double value (" + Double.MAX_VALUE + ")."},
        };
    }

    @Test
    @Parameters(method = "illegalBaseParameters")
    public void testIllegalTrapezoidBaseValue(double baseOne, double baseTwo, String message) throws IllegalArgumentException {
        //given
        exception.expect(IllegalArgumentException.class);
        exception.expectMessage(message);

        //when
        new Trapezoid(baseOne, baseTwo, 4);
    }

    private Object[] illegalBaseParameters() {
        return new Object[]{
                new Object[]{-2, 5, "Base cannot be equal to 0 or less than 0."},
                new Object[]{Double.MAX_VALUE + Math.ulp(Double.MAX_VALUE) / 2, 5, "Base cannot be greater than max double value (" + Double.MAX_VALUE + ")."},
                new Object[]{5, -2, "Base cannot be equal to 0 or less than 0."},
                new Object[]{5, Double.MAX_VALUE + Math.ulp(Double.MAX_VALUE) / 2, "Base cannot be greater than max double value (" + Double.MAX_VALUE + ")."},
        };
    }

    @Test
    @Parameters(method = "illegalBaseSetterParameters")
    public void testTrapezoidBaseSetterValidation(double baseOne, double baseTwo, String message) throws IllegalArgumentException {
        //given
        Trapezoid trapezoid = new Trapezoid();
        exception.expect(IllegalArgumentException.class);
        exception.expectMessage(message);

        //when
        trapezoid.setBaseOne(baseOne);
        trapezoid.setBaseTwo(baseTwo);
    }

    private Object[] illegalBaseSetterParameters() {
        return new Object[]{
                new Object[]{0, 3, "Base cannot be equal to 0 or less than 0."},
                new Object[]{Double.MAX_VALUE + Math.ulp(Double.MAX_VALUE) / 2, 3, "Base cannot be greater than max double value (" + Double.MAX_VALUE + ")."},
                new Object[]{3, 0, "Base cannot be equal to 0 or less than 0."},
                new Object[]{3, Double.MAX_VALUE + Math.ulp(Double.MAX_VALUE) / 2, "Base cannot be greater than max double value (" + Double.MAX_VALUE + ")."},
        };
    }

    @Test
    @Parameters(method = "illegalHeightSetterParameters")
    public void testTrapezoidHeightSetterValidation(double height, String message) throws IllegalArgumentException {
        //given
        Trapezoid trapezoid = new Trapezoid(4, 5, 1);
        exception.expect(IllegalArgumentException.class);
        exception.expectMessage(message);

        //when
        trapezoid.setHeight(height);
    }

    private Object[] illegalHeightSetterParameters() {
        return new Object[]{
                new Object[]{-1, "Height cannot be equal to 0 or less than 0."},
                new Object[]{Double.MAX_VALUE + Math.ulp(Double.MAX_VALUE) / 2, "Height cannot be greater than max double value (" + Double.MAX_VALUE + ")."},
        };
    }
}
