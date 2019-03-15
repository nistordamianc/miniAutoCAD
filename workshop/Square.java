package workshop;

public class Square extends ShapeClass implements Visitable {

    private int leftUpperX;
    private int leftUpperY;
    private int lineDimension;

    public Square() {

    }

    public Square(final int leftUpperX, final int leftUpperY, final int lineDimension) {
        this.leftUpperX = leftUpperX;
        this.leftUpperY = leftUpperY;
        this.lineDimension = lineDimension;
    }

    public int getLeftUpperX() {
        return leftUpperX;
   }

    public int getLeftUpperY() {
        return leftUpperY;
    }

    public int getLineDimension() {
        return lineDimension;
    }

    public void accept(final Visitor visitor) {
        visitor.visit(this);
    }
}
