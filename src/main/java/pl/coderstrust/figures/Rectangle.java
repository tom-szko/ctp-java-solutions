package pl.coderstrust.figures;

public class Rectangle implements Figure {
    private double width, height;

    Rectangle() {
        this.width = 0;
        this.height = 0;
    }

    Rectangle(double width, double height) {
        validateWidth(width);
        validateHeight(height);
        this.width = width;
        this.height = height;
    }

    @Override
    public double calculateArea() {
        return width * height;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        validateWidth(width);
        this.width = width;
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

    private void validateWidth(double width) {
        if (width <= 0) {
            throw new IllegalArgumentException("Width cannot be equal to 0 or less than 0.");
        }
        if (width > Double.MAX_VALUE) {
            throw new IllegalArgumentException("Width cannot be greater than max double value (" + Double.MAX_VALUE + ").");
        }
    }
}
