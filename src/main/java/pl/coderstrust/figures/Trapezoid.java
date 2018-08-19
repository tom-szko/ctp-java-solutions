package pl.coderstrust.figures;

public class Trapezoid implements Figure {
    private double baseOne, baseTwo, height;

    Trapezoid(double baseOne, double baseTwo, double height) {
        if (baseOne < 0) {
            throw new IllegalArgumentException("Base cannot take negative value.");
        }
        if (baseTwo < 0) {
            throw new IllegalArgumentException("Base cannot take negative value.");
        }
        if (height < 0) {
            throw new IllegalArgumentException("Height cannot take negative value.");
        }
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
        this.baseOne = baseOne;
    }

    public double getBaseTwo() {
        return baseTwo;
    }

    public void setBaseTwo(double baseTwo) {
        this.baseTwo = baseTwo;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }
}
