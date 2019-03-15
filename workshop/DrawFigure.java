package workshop;

public final class DrawFigure implements Visitor {

    public static final int DOI_FOUR_ZECI = 42;
    public static final int THREE = 3;
    public static final int FOUR = 4;
    public static final int SIX = 6;
    public static final int TEN = 10;
    private static DrawFigure drawer = new DrawFigure();

    private DrawFigure() {

    }

    public static DrawFigure getDrawer() {
        return drawer;
    }

    public void visit(final Circle circle) {
        int centerX = circle.getCenterX();
        int centerY = circle.getCenterY();
        int radius = circle.getRadius();
        int aux = 0;
        int decision = THREE - (2 * radius);

        while (radius >= aux) {

            if (centerX + radius >= 0 && centerY + aux >= 0
            && centerX + radius < circle.getHeightMatrix()
            && centerY + aux < circle.getWidthMatrix()) {
                circle.setMatrixElement(centerX + radius, centerY + aux, DOI_FOUR_ZECI);
            }
            if (centerX + aux >= 0 && centerY + radius >= 0
            && centerX + aux < circle.getHeightMatrix()
            && centerY + radius < circle.getWidthMatrix()) {
                circle.setMatrixElement(centerX + aux, centerY + radius, DOI_FOUR_ZECI);
            }
            if (centerX - aux >= 0 && centerY + radius >= 0
            && centerX - aux < circle.getHeightMatrix()
            && centerY + radius < circle.getWidthMatrix()) {
                circle.setMatrixElement(centerX - aux, centerY + radius, DOI_FOUR_ZECI);
            }
            if (centerX - radius >= 0 && centerY + aux >= 0
            && centerX - radius < circle.getHeightMatrix()
            && centerY + aux < circle.getWidthMatrix()) {
                circle.setMatrixElement(centerX - radius, centerY + aux, DOI_FOUR_ZECI);
            }
            if (centerX - radius >= 0 && centerY - aux >= 0
            && centerX - radius < circle.getHeightMatrix()
            && centerY - aux < circle.getWidthMatrix()) {
                circle.setMatrixElement(centerX - radius, centerY - aux, DOI_FOUR_ZECI);
            }
            if (centerX - aux >= 0 && centerY - radius >= 0
            && centerX - aux < circle.getHeightMatrix()
            && centerY - radius < circle.getWidthMatrix()) {
                circle.setMatrixElement(centerX - aux, centerY - radius, DOI_FOUR_ZECI);
            }
            if (centerX + aux >= 0 && centerY - radius >= 0
            && centerX + aux < circle.getHeightMatrix()
            && centerY - radius < circle.getWidthMatrix()) {
                circle.setMatrixElement(centerX + aux, centerY - radius, DOI_FOUR_ZECI);
            }
            if (centerX + radius >= 0 && centerY - aux >= 0
            && centerX + radius < circle.getHeightMatrix()
            && centerY - aux < circle.getWidthMatrix()) {
                circle.setMatrixElement(centerX + radius, centerY - aux, DOI_FOUR_ZECI);
            }
            aux++;
            if (decision <= 0) {
                decision += FOUR * aux + SIX;
            } else {
                radius--;
                decision += FOUR * (aux - radius) + TEN;
            }
        }
    }

    public void visit(final Rectangle rectangle) {
        Line firstLine = new Line(rectangle.getLeftUpperX(), rectangle.getLeftUpperY(),
        rectangle.getLeftUpperX() + rectangle.getHeightDimension() - 1,
        rectangle.getLeftUpperY());
        Line secondLine = new Line(rectangle.getLeftUpperX(), rectangle.getLeftUpperY(),
        rectangle.getLeftUpperX(), rectangle.getLeftUpperY()
        + rectangle.getWidthDimension() - 1);
        Line thirdLine = new Line(rectangle.getLeftUpperX() + rectangle.getHeightDimension() - 1,
        rectangle.getLeftUpperY(), rectangle.getLeftUpperX()
        + rectangle.getHeightDimension() - 1, rectangle.getLeftUpperY()
        + rectangle.getWidthDimension() - 1);
        Line fourthLine = new Line(rectangle.getLeftUpperX(), rectangle.getWidthDimension() - 1
        + rectangle.getLeftUpperY(), rectangle.getLeftUpperX()
        + rectangle.getHeightDimension() - 1, rectangle.getLeftUpperY()
        + rectangle.getWidthDimension() - 1);
        drawer.visit(firstLine);
        drawer.visit(secondLine);
        drawer.visit(thirdLine);
        drawer.visit(fourthLine);
    }

    public void visit(final Square square) {
        Line firstLine = new Line(square.getLeftUpperX(), square.getLeftUpperY(),
        square.getLeftUpperX(), square.getLeftUpperY() + square.getLineDimension()
        - 1);
        Line secondLine = new Line(square.getLeftUpperX(), square.getLeftUpperY(),
        square.getLeftUpperX() + square.getLineDimension() - 1,
        square.getLeftUpperY());
        Line thirdLine = new Line(square.getLeftUpperX() + square.getLineDimension() - 1,
        square.getLeftUpperY(), square.getLeftUpperX() + square.getLineDimension()
        - 1, square.getLeftUpperY() + square.getLineDimension() - 1);
        Line fourthLine = new Line(square.getLeftUpperX() + square.getLineDimension() - 1,
        square.getLeftUpperY() + square.getLineDimension() - 1,
        square.getLeftUpperX(), square.getLeftUpperY()
        + square.getLineDimension() - 1);
        drawer.visit(firstLine);
        drawer.visit(secondLine);
        drawer.visit(thirdLine);
        drawer.visit(fourthLine);
    }

    public void visit(final Line line) {
        int x = line.getStartingX();
        int y = line.getStartingY();
        int deltaX = Math.abs(line.getEndingX() - line.getStartingX());
        int deltaY = Math.abs(line.getEndingY() - line.getStartingY());
        int signX = (int) Math.signum(line.getEndingX() - line.getStartingX());
        int signY = (int) Math.signum(line.getEndingY() - line.getStartingY());
        boolean interchange;

        if (deltaY > deltaX) {
            interchange = true;
            int deltaAuxiliar = deltaY;
            deltaY = deltaX;
            deltaX = deltaAuxiliar;
        } else {
            interchange = false;
        }

        int error = 2 * deltaY - deltaX;
        for (int i = 0; i <= deltaX; i++) {
            if (x >= 0 && y >= 0 && x < line.getHeightMatrix()
            && y < line.getWidthMatrix()) {
                line.setMatrixElement(x, y, DOI_FOUR_ZECI);
            }
            while (error > 0) {
                if (interchange) {
                    x += signX;
                } else {
                    y += signY;
                }
                error -= 2 * deltaX;
            }
            if (interchange) {
                y += signY;
            } else {
                x += signX;
            }
            error += 2 * deltaY;
        }
    }

    public void visit(final Diamond diamond) {

        Line firstLine = new Line(diamond.getCenterX() + diamond.getVerticalDiag() / 2,
        diamond.getCenterY(), diamond.getCenterX(), diamond.getHorizontalDiag() / 2
        + diamond.getCenterY());
        Line secondLine = new Line(diamond.getCenterX(), diamond.getCenterY()
        + diamond.getHorizontalDiag() / 2, diamond.getCenterX()
        - diamond.getVerticalDiag() / 2, diamond.getCenterY());
        Line thirdLine = new Line(diamond.getCenterX() - diamond.getVerticalDiag() / 2,
        diamond.getCenterY(), diamond.getCenterX(), diamond.getCenterY()
        - diamond.getHorizontalDiag() / 2);
        Line fourthLine = new Line(diamond.getCenterX(), diamond.getCenterY()
        - diamond.getHorizontalDiag() / 2, diamond.getCenterX()
        + diamond.getVerticalDiag() / 2, diamond.getCenterY());
        drawer.visit(firstLine);
        drawer.visit(secondLine);
        drawer.visit(thirdLine);
        drawer.visit(fourthLine);
    }

    public void visit(final Polygon polygon) {
        for (int i = 0; i < polygon.getNumberOfPoints() - 1; i++) {
            Line auxiliarLine = new Line(polygon.getCoordonatesX(i),
            polygon.getCoordonatesY(i), polygon.getCoordonatesX(i + 1),
            polygon.getCoordonatesY(i + 1));
            drawer.visit(auxiliarLine);
        }

        Line finalLine = new Line(polygon.getCoordonatesX(polygon.getNumberOfPoints() - 1),
        polygon.getCoordonatesY(polygon.getNumberOfPoints() - 1),
        polygon.getCoordonatesX(0), polygon.getCoordonatesY(0));
        drawer.visit(finalLine);
    }

    public void visit(final Triangle triangle) {

        Line firstLine = new Line(triangle.getFirstX(), triangle.getFirstY(),
        triangle.getSecondX(), triangle.getSecondY());
        Line secondLine = new Line(triangle.getSecondX(), triangle.getSecondY(),
        triangle.getThirdX(), triangle.getThirdY());
        Line thirdLine = new Line(triangle.getThirdX(), triangle.getThirdY(),
        triangle.getFirstX(), triangle.getFirstY());
        drawer.visit(firstLine);
        drawer.visit(secondLine);
        drawer.visit(thirdLine);

    }

    public void visit(final Canvas canvas) {

    }

}
