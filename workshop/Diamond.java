package workshop;

public class Diamond extends ShapeClass implements Visitable {

    private int centerX;
    private int centerY;
    private int horizontalDiag;
    private int verticalDiag;

    public Diamond() {

    }

    public Diamond(final int centerX, final int centerY, final int horizontalDiag,
    final int verticalDiag) {

        this.centerX = centerX;
        this.centerY = centerY;
        this.horizontalDiag = horizontalDiag;
        this.verticalDiag = verticalDiag;

    }

    public int getCenterX() {
        return centerX;
    }

    public int getCenterY() {
        return centerY;
    }

    public int getHorizontalDiag() {
        return horizontalDiag;
    }

    public int getVerticalDiag() {
        return verticalDiag;
    }

    public void accept(final Visitor visitor) {
        visitor.visit(this);
    }

}
