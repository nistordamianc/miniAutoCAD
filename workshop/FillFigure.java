package workshop;

public final class FillFigure implements Visitor {

    public static final int TREI_ZECE = 13;
    public static final int TREI = 3;
    private static FillFigure filler = new FillFigure();

    private FillFigure() {

    }

    public static FillFigure getFiller() {
        return filler;
    }

    public void visit(final Circle circle) {
        circle.fillAlgorithm(circle.getCenterX(), circle.getCenterY(), TREI_ZECE);
    }

    public void visit(final Rectangle rectangle) {
        rectangle.fillAlgorithm(rectangle.getLeftUpperX() + 2, rectangle.getLeftUpperY()
        + 2, TREI_ZECE);
    }

    public void visit(final Square square) {
        square.fillAlgorithm(square.getLeftUpperX() + 2,
        square.getLeftUpperY() + 2, TREI_ZECE);
    }

    public void visit(final Line line) {
        return;
    }

    public void visit(final Diamond diamond) {
        diamond.fillAlgorithm(diamond.getCenterX(), diamond.getCenterY(), TREI_ZECE);
    }

    public void visit(final Polygon polygon) {
        polygon.fillAlgorithm(polygon.getWeightPointX(), polygon.getWeightPointY(),
        TREI_ZECE);

    }

    public void visit(final Triangle triangle) {
        triangle.fillAlgorithm((triangle.getFirstX() + triangle.getSecondX()
        + triangle.getThirdX()) / TREI, (triangle.getFirstY() + triangle.getSecondY()
        + triangle.getThirdY()) / TREI, TREI_ZECE);
    }

    public void visit(final Canvas canvas) {
        return;
    }

}
