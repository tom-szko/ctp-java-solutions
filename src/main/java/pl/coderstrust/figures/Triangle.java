package pl.coderstrust.figures;

public class Triangle implements Figure {
    private double base, height;

    Triangle() {
        this.base = 0;
        this.height = 0;
    }

    Triangle(double base, double height) {
        validateBase(base);
        validateHeight(height);
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
        validateBase(base);
        this.base = base;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        validateHeight(height);
        this.height = height;
    }

    private void validateHeight(double height) {
        if (height <= 0) {
            throw new IllegalArgumentException("Height cannot be equal to 0 or less than 0.");
        }
        if (height > Double.MAX_VALUE) {
            throw new IllegalArgumentException("Height cannot be greater than max double value (" + Double.MAX_VALUE + ").");
        }
    }

    private void validateBase(double base) {
        if (base <= 0) {
            throw new IllegalArgumentException("Base cannot be equal to 0 or less than 0.");
        }
        if (base > Double.MAX_VALUE) {
            throw new IllegalArgumentException("Base cannot be greater than max double value (" + Double.MAX_VALUE + ").");
        }
    }
}
