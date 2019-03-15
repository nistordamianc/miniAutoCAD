package workshop;

public class Rectangle extends ShapeClass implements Visitable {

    private int leftUpperX;
    private int leftUpperY;
    private int heightDimension;
    private int widthDimension;

    public Rectangle() {

    }

    public Rectangle(final int leftUpperX, final int leftUpperY, final int heightDimension,
    final int widthDimension) {
        this.leftUpperX = leftUpperX;
        this.leftUpperY = leftUpperY;
        this.heightDimension = heightDimension;
        this.widthDimension = widthDimension;
    }

    public int getLeftUpperX() {
        return leftUpperX;
    }

    public int getLeftUpperY() {
        return leftUpperY;
    }

    public int getHeightDimension() {
        return heightDimension;
    }

    public int getWidthDimension() {
        return widthDimension;
    }

    public void accept(final Visitor visitor) {
        visitor.visit(this);
    }

}
