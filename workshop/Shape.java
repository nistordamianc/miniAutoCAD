package workshop;

import java.awt.image.BufferedImage;

public interface Shape extends Visitable {
    void initialize(int height, int width);
    void setMatrixElement(int x, int y, int value);
    int getHeightMatrix();
    int getWidthMatrix();
    void setMatrix(int height, int width);
    int[][] getMatrix();
    void fillAlgorithm(int centerX, int centerY, int newColor);
    void clearMatrix();
    int getMatrixElement(int x, int y);
    void draw(int color, BufferedImage image);
    void fill(int color, BufferedImage image);
}
