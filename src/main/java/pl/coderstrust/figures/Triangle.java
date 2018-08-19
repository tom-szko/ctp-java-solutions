package pl.coderstrust.figures;

public class Triangle implements Figure {
    private double base, height;

    public Triangle(double base, double height) {
        if (height < 0) {
            throw new IllegalArgumentException("Height cannot take negative value.");
        }
        if (base < 0) {
            throw new IllegalArgumentException("Base cannot take negative value.");
        }
        this.base = base;
        this.height = height;
    }

    @Override
    public double calculateArea() {
        return base * height / 2;
    }

    public double getBase() {
        return base;
    }

    public void setBase(double base) {
        this.base = base;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }
}
