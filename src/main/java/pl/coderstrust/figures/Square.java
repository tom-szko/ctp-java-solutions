package pl.coderstrust.figures;

public class Square extends Rectangle {
    Square(double side) {
        super(side, side);
    }

    @Override
    public void setHeight(double side) {
        super.setHeight(side);
        super.setWidth(side);
    }

    @Override
    public void setWidth(double side) {
        setHeight(side);
    }
}
