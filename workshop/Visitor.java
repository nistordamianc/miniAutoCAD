package workshop;

public interface Visitor {

    void visit(Circle circle);
    void visit(Rectangle rectangle);
    void visit(Square square);
    void visit(Line line);
    void visit(Diamond diamond);
    void visit(Polygon polygon);
    void visit(Triangle triangle);
    void visit(Canvas canvas);

}
