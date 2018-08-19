package pl.coderstrust.figures;

public class Circle implements Figure {
    private double radius;

    Circle(double radius){
        if (radius < 0) {
            throw new IllegalArgumentException("Radius cannot have negative value.");
        }
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
        this.radius = radius;
    }
}
