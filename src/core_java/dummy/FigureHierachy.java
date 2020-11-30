package core_java.dummy;

abstract class FigureHierachy {
    abstract double area();
}

class Rectangle extends FigureHierachy {
    double width;
    double length;

    Rectangle(double length, double width) {
        this.length = length;
        this.width = width;
    }

    @Override
    double area() {
        return width * length;
    }
}

class Circle extends FigureHierachy {
    double radius;

    Circle(double radius) {
        this.radius = radius;
    }

    @Override
    double area() {
        return Math.PI * Math.sqrt(radius);
    }
}

class Square extends Rectangle {
    Square(double side) {
        super(side, side);
    }
}
