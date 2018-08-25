package pl.coderstrust.figures;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FigureTest {
    private static final double PRECISION = 0.1;

    @Test
    public void testCircleAsFigure() {
        //given
        double radius = 5;
        Figure figure = new Circle(radius);
        double expected = 78.5;

        //when
        double actual = figure.calculateArea();

        //then
        assertEquals(expected, actual, PRECISION);
    }

    @Test
    public void testSquareAsFigure() {
        //given
        double side = 5;
        Figure figure = new Square(side);
        double expected = 25;

        //when
        double actual = figure.calculateArea();

        //then
        assertEquals(expected, actual, PRECISION);
    }

    @Test
    public void testRectangleAsFigure() {
        //given
        double width = 5;
        double height = 6.5;
        Figure figure = new Rectangle(width, height);
        double expected = 32.5;

        //when
        double actual = figure.calculateArea();

        //then
        assertEquals(expected, actual, PRECISION);
    }

    @Test
    public void testTriangleAsFigure() {
        //given
        double base = 5;
        double height = 3;
        Figure figure = new Triangle(base, height);
        double expected = 7.5;

        //when
        double actual = figure.calculateArea();

        //then
        assertEquals(expected, actual, PRECISION);
    }

    @Test
    public void testTrapezoidAsFigure() {
        //given
        double baseOne = 5;
        double baseTwo = 7.3;
        double height = 4.5;
        Figure figure = new Trapezoid(baseOne, baseTwo, height);
        double expected = 27.7;

        //when
        double actual = figure.calculateArea();

        //then
        assertEquals(expected, actual, PRECISION);
    }
}
