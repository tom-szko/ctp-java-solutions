package pl.coderstrust.figures;

public class Square extends Rectangle {
    Square(){
        super();
    }

    Square(double side) {
        super(side, side);
    }

    @Override
    public void setWidth(double side) {
        validateSide(side);
        super.setHeight(side);
        super.setWidth(side);
    }

    @Override
    public void setHeight(double side) {
        throw new UnsupportedOperationException("This method is not supported. Use setWidth parameter to change rectangle size.");
    }

    private static void validateSide(double side) {
        if (side <= 0) {
            throw new IllegalArgumentException("Side cannot be equal to 0 or less than 0.");
        }
        if (side > Double.MAX_VALUE) {
            throw new IllegalArgumentException("Side cannot be greater than max double value (" + Double.MAX_VALUE + ").");
        }
    }
}
