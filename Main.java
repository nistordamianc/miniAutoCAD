import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Scanner;
import java.io.IOException;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;

import workshop.Canvas;
import workshop.Circle;
import workshop.Diamond;
import workshop.DrawFigure;
import workshop.FillFigure;
import workshop.Line;
import workshop.Polygon;
import workshop.Rectangle;
import workshop.Shape;
import workshop.ShapeFactory;
import workshop.Square;
import workshop.Triangle;

public final class Main {

    private Main() {

    }

    public static final int THREE = 3;
    public static final int FOUR = 4;
    public static final int FIVE = 5;
    public static final int SIX = 6;
    public static final int SEVEN = 7;
    public static final int EIGHT = 8;
    public static final int NINE = 9;
    public static final int TEN = 10;

    public static void main(final String[] args) throws IOException {

        ShapeFactory creator = ShapeFactory.getCreator();
        FillFigure filler = FillFigure.getFiller();
        DrawFigure drawer = DrawFigure.getDrawer();
        Canvas canvas = Canvas.getBackground();
        Scanner scanf = new Scanner(new BufferedReader(new FileReader(args[0])));
        File output = new File("drawing.png"); 

        int numberOfFigures = scanf.nextInt(); //number of figures
        scanf.nextLine();
        String auxiliar = new String();
        auxiliar = scanf.nextLine(); //scan canvas
        String[] parts = auxiliar.split(" ");
        canvas.initialize(Integer.parseInt(parts[1]), Integer.parseInt(parts[2]));
        int backgroundColor = creator.translateColor(parts[THREE], parts[FOUR]);

        BufferedImage image = new BufferedImage(canvas.getWidthMatrix(),
        canvas.getHeightMatrix(), BufferedImage.TYPE_INT_ARGB);
        for (int i = 0; i < canvas.getHeightMatrix(); i++) {
            for (int j = 0; j < canvas.getWidthMatrix(); j++) {
                image.setRGB(j, i, backgroundColor);
            }
        } //img background

        Shape[] shapes = new Shape[numberOfFigures - 1]; //rest of the forms
        int shapeColor; //outline color
        int shapeFillColor; //fill color

        for (int i = 0; i < numberOfFigures - 1; i++) { //parse the file

            auxiliar = scanf.nextLine();
            parts = auxiliar.split(" ");
            canvas.clearMatrix(); //initialize matrix with 0 again

            if (parts[0].equalsIgnoreCase("LINE")) {
                shapes[i] = creator.createShape("LINE"); //form type
                shapes[i] = new Line(Integer.parseInt(parts[2]),
                Integer.parseInt(parts[1]),
                Integer.parseInt(parts[FOUR]),
                Integer.parseInt(parts[THREE])); //constructor for parameters
                shapes[i].accept(drawer); //drawing of the scheme
                shapeColor = creator.translateColor(parts[FIVE], parts[SIX]); //color in argb
                canvas.draw(shapeColor, image); //countour draw
                continue;
            } else if (parts[0].equalsIgnoreCase("SQUARE")) {
                shapes[i] = creator.createShape("SQUARE");
                shapes[i] = new Square(Integer.parseInt(parts[2]),
                Integer.parseInt(parts[1]),
                Integer.parseInt(parts[THREE]));
                shapes[i].accept(drawer);
                shapeColor = creator.translateColor(parts[FOUR], parts[FIVE]);
                canvas.draw(shapeColor, image);

                shapes[i].accept(filler); //scheme for fill
                shapeFillColor = creator.translateColor(parts[SIX], parts[SEVEN]);
                canvas.fill(shapeFillColor, image); //effective fill
                continue;
            } else if (parts[0].equalsIgnoreCase("TRIANGLE")) {
                shapes[i] = creator.createShape("TRIANGLE");
                shapes[i] = new Triangle(Integer.parseInt(parts[2]),
                Integer.parseInt(parts[1]),
                Integer.parseInt(parts[FOUR]),
                Integer.parseInt(parts[THREE]),
                Integer.parseInt(parts[SIX]),
                Integer.parseInt(parts[FIVE]));
                shapes[i].accept(drawer);
                shapeColor = creator.translateColor(parts[SEVEN], parts[EIGHT]);
                canvas.draw(shapeColor, image);

                shapes[i].accept(filler);
                shapeFillColor = creator.translateColor(parts[NINE], parts[TEN]);
                canvas.fill(shapeFillColor, image);
                continue;
            } else if (parts[0].equalsIgnoreCase("RECTANGLE")) {
                shapes[i] = creator.createShape("RECTANGLE");
                shapes[i] = new Rectangle(Integer.parseInt(parts[2]),
                Integer.parseInt(parts[1]),
                Integer.parseInt(parts[THREE]),
                Integer.parseInt(parts[FOUR]));
                shapes[i].accept(drawer);
                shapeColor = creator.translateColor(parts[FIVE], parts[SIX]);
                canvas.draw(shapeColor, image);

                shapes[i].accept(filler);
                shapeFillColor = creator.translateColor(parts[SEVEN], parts[EIGHT]);
                canvas.fill(shapeFillColor, image);
                continue;
            } else if (parts[0].equalsIgnoreCase("DIAMOND")) {
                shapes[i] = creator.createShape("DIAMOND");
                shapes[i] = new Diamond(Integer.parseInt(parts[2]),
                Integer.parseInt(parts[1]),
                Integer.parseInt(parts[THREE]),
                Integer.parseInt(parts[FOUR]));
                shapes[i].accept(drawer);
                shapeColor = creator.translateColor(parts[FIVE], parts[SIX]);
                canvas.draw(shapeColor, image);

                shapes[i].accept(filler);
                shapeFillColor = creator.translateColor(parts[SEVEN], parts[EIGHT]);
                canvas.fill(shapeFillColor, image);
                continue;
            } else if (parts[0].equalsIgnoreCase("CIRCLE")) {
                shapes[i] = creator.createShape("CIRCLE");
                shapes[i] = new Circle(Integer.parseInt(parts[2]),
                Integer.parseInt(parts[1]),
                Integer.parseInt(parts[THREE]));
                shapes[i].accept(drawer);
                shapeColor = creator.translateColor(parts[FOUR], parts[FIVE]);
                canvas.draw(shapeColor, image);

                shapes[i].accept(filler);
                shapeFillColor = creator.translateColor(parts[SIX], parts[SEVEN]);
                canvas.fill(shapeFillColor, image);
                continue;
            } else if (parts[0].equalsIgnoreCase("POLYGON")) {
                shapes[i] = creator.createShape("POLYGON");

                int pointsNumber = Integer.parseInt(parts[1]);
                int[] points = new int[pointsNumber * 2];
                int q = 0;
                int w = 2;
                for (w = 2; w < parts.length - FOUR; w++) {
                    points[q] = Integer.parseInt(parts[w]);
                    q++;
                }
                shapes[i] = new Polygon(pointsNumber, points);
                shapes[i].accept(drawer);
                shapeColor = creator.translateColor(parts[w], parts[w + 1]);
                canvas.draw(shapeColor, image);

                shapes[i].accept(filler);
                shapeFillColor = creator.translateColor(parts[w + 2], parts[w + THREE]);
                canvas.fill(shapeFillColor, image);
                continue;
           }
       }
        ImageIO.write(image, "png", output); //file write
        scanf.close(); //scanner close
    }
}
