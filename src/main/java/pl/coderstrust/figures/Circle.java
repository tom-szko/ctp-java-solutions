package pl.coderstrust.figures;

public class Circle implements Figure {
    private double radius;

    Circle() {
        this.radius = 0;
    }

    Circle(double radius) {
        validateRadius(radius);
        this.radius = radius;
    }

    @Override
    public double calculateArea() {
        return Math.PI * Math.pow(radius, 2);
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        validateRadius(radius);
        this.radius = radius;
    }

    private void validateRadius(double radius) {
        if (radius <= 0) {
            throw new IllegalArgumentException("Radius cannot be equal to 0 or less than 0.");
        }
        if (radius > Double.MAX_VALUE) {
            throw new IllegalArgumentException("Radius cannot be greater than max double value (" + Double.MAX_VALUE + ").");
        }
    }
}
