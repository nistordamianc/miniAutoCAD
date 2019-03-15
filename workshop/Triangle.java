package workshop;

public class Triangle extends ShapeClass implements Visitable {

    private int firstX;
    private int secondX;
    private int thirdX;
    private int firstY;
    private int secondY;
    private int thirdY;

    public Triangle() {

    }

    public Triangle(final int firstX, final int firstY, final int secondX, final int secondY,
    final int thirdX, final int thirdY) {

        this.firstX = firstX;
        this.firstY = firstY;
        this.secondX = secondX;
        this.secondY = secondY;
        this.thirdX = thirdX;
        this.thirdY = thirdY;

    }

    public int getFirstX() {
        return firstX;
    }

    public int getSecondX() {
        return secondX;
    }

    public int getThirdX() {
        return thirdX;
    }

    public int getFirstY() {
        return firstY;
    }

    public int getSecondY() {
        return secondY;
    }

    public int getThirdY() {
        return thirdY;
    }

    public void accept(final Visitor visitor) {
        visitor.visit(this);
    }

}
