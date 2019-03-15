package workshop;

public class Polygon extends ShapeClass implements Visitable {

    private int numberOfPoints;
    private int[] coordonatesX;
    private int[] coordonatesY;

    public Polygon() {

    }

    public Polygon(final int numberOfPoints, final int[] points) {
        this.numberOfPoints = numberOfPoints;
        coordonatesX = new int[numberOfPoints];
        coordonatesY = new int[numberOfPoints];
        int j = 0;
        for (int i = 0; i < numberOfPoints; i++) {
            coordonatesY[i] = points[j];
            j++;
            coordonatesX[i] = points[j];
            j++;
        }
    }

    public int getWeightPointX() {
        int sum = 0;
        for (int i = 0; i < this.numberOfPoints; i++) {
            sum += this.coordonatesX[i];
        }
        sum = sum / this.numberOfPoints;
        return sum;
    }

    public int getWeightPointY() {
        int sum = 0;
        for (int i = 0; i < this.numberOfPoints; i++) {
            sum += this.coordonatesY[i];
        }
        sum = sum / this.numberOfPoints;
        return sum;
    }

    public int getNumberOfPoints() {
        return numberOfPoints;
    }

    public int getCoordonatesX(final int index) {
        return coordonatesX[index];
    }

    public int getCoordonatesY(final int index) {
        return coordonatesY[index];
    }

    public void accept(final Visitor visitor) {
        visitor.visit(this);
    }

}
