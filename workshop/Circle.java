package workshop;

public class Circle extends ShapeClass implements Visitable {

    private int centerX;
    private int centerY;
    private int radius;

    public Circle() {

    }

    public Circle(final int centerX, final int centerY, final int radius) {
        this.centerX = centerX;
        this.centerY = centerY;
        this.radius = radius;
    }

    public int getCenterX() {
        return centerX;
    }

    public int getCenterY() {
        return centerY;
    }

    public int getRadius() {
        return radius;
    }
 
    public void accept(final Visitor visitor) {
        visitor.visit(this);
    }

}
