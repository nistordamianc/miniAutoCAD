package workshop;

public class Line extends ShapeClass implements Visitable {

    private int startingX;
    private int startingY;
    private int endingX;
    private int endingY;


    public Line() {

    }

    public Line(final int startingX, final int startingY,
    final int endingX, final int endingY) {
        this.startingX = startingX;
        this.startingY = startingY;
        this.endingX = endingX;
        this.endingY = endingY;
    }

    public int getStartingX() {
        return startingX;
    }

    public int getStartingY() {
        return startingY;
    }

    public int getEndingX() {
        return endingX;
    }

    public int getEndingY() {
        return endingY;
    }

    public void accept(final Visitor visitor) {
        visitor.visit(this);
    }

}
