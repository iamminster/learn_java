package core_java.dummy;

public class FigureTagged {
    enum Shape {RECTANGLE, CIRCLE};

    final Shape shape;

    // Are used if shape is rectangle
    double length;
    double width;

    // Is used if Shape is circle
    double radius;

    FigureTagged(double radius) {
        shape = Shape.CIRCLE;
        this.radius = radius;
    }

    FigureTagged(double length, double width) {
        shape = Shape.RECTANGLE;
        this.length = length;
        this.width = width;
    }

    double area() {
        switch (shape) {
            case CIRCLE:
                return 3.14 * radius * radius;
            case RECTANGLE:
                return width * length;
            default:
                throw new AssertionError(shape);
        }
    }
}
