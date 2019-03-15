package workshop;

public final class Canvas extends ShapeClass {

    private static Canvas background = new Canvas();

    private Canvas() {

    }

    public static Canvas getBackground() {
        return background;
    }

}
