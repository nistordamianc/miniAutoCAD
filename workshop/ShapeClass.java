package workshop;
import java.awt.image.BufferedImage;
import java.util.LinkedList;
import java.util.Queue;


public class ShapeClass implements Shape {

    public static final int FORTY_TWO = 42;
    public static final int THIRTEEN = 13;
    private static int[][] matrix;
    private static int heightMatrix;
    private static int widthMatrix;

    public int[][] getMatrix() {
        return matrix;
    }

    public void setMatrix(final int height, final int width) {
        matrix = new int[height][width];
        heightMatrix = height;
        widthMatrix = width;
    }

    public void setMatrixElement(final int x, final int y, final int value) {
        matrix[x][y] = value;
    }

    public int getMatrixElement(final int x, final int y) {
        return matrix[x][y];
    }

    public int getHeightMatrix() {
        return heightMatrix;
    }

    public int getWidthMatrix() {
        return widthMatrix;
    }

    public void fillAlgorithm(final int centerX, final int centerY, final int newColor) {
        int x = centerX;
        int y = centerY;
        if (x != 0) {
            x--;
        }
        if (y != 0) {
            y--;
        }
        Queue<Point> queue = new LinkedList<Point>();
        if (x > 0 && y > 0 && y < widthMatrix && x < heightMatrix) {
            if (matrix[x][y] != 0) {
                return;
            }
        }
        queue.add(new Point(x, y));
        while (!queue.isEmpty()) {
            Point p = queue.remove();
            if (p.getX() < heightMatrix && p.getY() < widthMatrix
            && p.getX() >= 0 && p.getY() >= 0) {
                if (matrix[p.getX()][p.getY()] == 0) {
                    matrix[p.getX()][p.getY()] = newColor;
                    if (p.getX() + 1 < heightMatrix && p.getY() < widthMatrix
                            && p.getX() + 1 >= 0 && p.getY() >= 0
                            && matrix[p.getX() + 1][p.getY()] != FORTY_TWO) {
                        queue.add(new Point(p.getX() + 1, p.getY()));
                    }
                    if (p.getX() - 1 < heightMatrix && p.getY() < widthMatrix
                            && p.getX() - 1 >= 0 && p.getY() >= 0
                            && matrix[p.getX() - 1][p.getY()] != FORTY_TWO) {
                        queue.add(new Point(p.getX() - 1, p.getY()));
                    }
                    if (p.getX() < heightMatrix && p.getY() + 1 < widthMatrix
                            && p.getX() >= 0 && p.getY() + 1 >= 0
                            && matrix[p.getX()][p.getY() + 1] != FORTY_TWO) {
                        queue.add(new Point(p.getX(), p.getY() + 1));
                    }
                    if (p.getX() < heightMatrix && p.getY() - 1 < widthMatrix
                            && p.getX() >= 0 && p.getY() - 1 >= 0
                            && matrix[p.getX()][p.getY() - 1] != FORTY_TWO) {
                        queue.add(new Point(p.getX(), p.getY() - 1));
                    }
                }
            }
        }
    }

    public void clearMatrix() {
        for (int i = 0; i < heightMatrix; i++) {
            for (int j = 0; j < widthMatrix; j++) {
                matrix[i][j] = 0;
            }
        }
    }

    public void initialize(final int height, final int width) {
        setMatrix(height, width);
        clearMatrix();
    }

    public void accept(final Visitor visitor) {

    }

    public void draw(final int color, final BufferedImage image) {
        for (int i = 0; i < getHeightMatrix(); i++) {
            for (int j = 0; j < getWidthMatrix(); j++) {
                if (getMatrixElement(i, j) == FORTY_TWO) {
                    image.setRGB(j, i, color);
                }
            }
        }
    }

    public void fill(final int color, final BufferedImage image) {
        for (int i = 0; i < getHeightMatrix(); i++) {
            for (int j = 0; j < getWidthMatrix(); j++) {
                if (getMatrixElement(i, j) == THIRTEEN) {
                    image.setRGB(j, i, color);
                }
            }
        }
    }

}
