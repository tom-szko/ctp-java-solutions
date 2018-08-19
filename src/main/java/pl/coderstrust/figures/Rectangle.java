package pl.coderstrust.figures;

public class Rectangle implements Figure {
    private double width, height;

    Rectangle(double width, double height) {
        if (width < 0) {
            throw new IllegalArgumentException("Width cannot take negative value.");
        }
        if (height < 0) {
            throw new IllegalArgumentException("Height cannot take negative value.");
        }
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
        this.width = width;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }
}
