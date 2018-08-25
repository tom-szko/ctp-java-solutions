package pl.coderstrust.figures;

public class Trapezoid implements Figure {
    private double baseOne, baseTwo, height;

    Trapezoid() {
        this.baseOne = 0;
        this.baseTwo = 0;
        this.height = 0;
    }

    Trapezoid(double baseOne, double baseTwo, double height) {
        validateBase(baseOne);
        validateBase(baseTwo);
        validateHeight(height);
        this.baseOne = baseOne;
        this.baseTwo = baseTwo;
        this.height = height;
    }

    @Override
    public double calculateArea() {
        return (baseOne + baseTwo) / 2 * height;
    }

    public double getBaseOne() {
        return baseOne;
    }

    public void setBaseOne(double baseOne) {
        validateBase(baseOne);
        this.baseOne = baseOne;
    }

    public double getBaseTwo() {
        return baseTwo;
    }

    public void setBaseTwo(double baseTwo) {
        validateBase(baseTwo);
        this.baseTwo = baseTwo;
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
