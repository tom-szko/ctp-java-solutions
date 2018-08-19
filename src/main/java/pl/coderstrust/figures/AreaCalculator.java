package pl.coderstrust.figures;

public class AreaCalculator {
    public static void main(String[] args) {
        Square square = new Square(6);
        square.setHeight(10);
        double squareArea = square.calculateArea();
        System.out.println("Square side: " + square.getHeight() + ". Square area: " + squareArea);
        Rectangle rectangle = new Rectangle(6, 10);
        double rectangleArea = rectangle.calculateArea();
        System.out.println("Rectangle width: " + rectangle.getWidth()+ ", height: "+ rectangle.getHeight() + ". Rectangle area: " + rectangleArea);
        Triangle triangle = new Triangle(10, 5);
        double triangleArea = triangle.calculateArea();
        System.out.println("Triangle base: " + triangle.getBase()+ ", height: "+ triangle.getHeight() + ". Triangle area: " + triangleArea);
        Circle circle = new Circle(5);
        double circleArea = circle.calculateArea();
        System.out.println("Circle radius: " + circle.getRadius() + ". Circle area: " + circleArea);
        Trapezoid trapezoid = new Trapezoid(5, 7.3, 4.5);
        double trapezoidArea = trapezoid.calculateArea();
        System.out.println("Trapezoid baseOne: " + trapezoid.getBaseOne() + ", baseTwo: " + trapezoid.getBaseTwo() + ", height: " + trapezoid.getHeight() + ". Trapezoid area: " + trapezoidArea);
    }
}
