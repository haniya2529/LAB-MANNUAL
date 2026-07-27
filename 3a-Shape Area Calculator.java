class Circle {
    double radius;

    Circle(double radius) {
        this.radius = radius;
    }

    double area() {
        return Math.PI * radius * radius;
    }
}

class Rectangle {
    double length, width;

    Rectangle(double length, double width) {
        this.length = length;
        this.width = width;
    }

    double area() {
        return length * width;
    }
}

class Triangle {
    double base, height;

    Triangle(double base, double height) {
        this.base = base;
        this.height = height;
    }

    double area() {
        return 0.5 * base * height;
    }
}

public class ShapeAreaCalculator {
    public static void main(String[] args) {

        Circle circle = new Circle(5.0);
        Rectangle rectangle = new Rectangle(4.0, 6.0);
        Triangle triangle = new Triangle(3.0, 8.0);

        System.out.println("----- Shape Area Calculator -----");

        System.out.println("Circle:");
        System.out.println("Radius = " + circle.radius);
        System.out.println("Area of Circle = " + circle.area());

        System.out.println("\nRectangle:");
        System.out.println("Length = " + rectangle.length + ", Width = " + rectangle.width);
        System.out.println("Area of Rectangle = " + rectangle.area());

        System.out.println("\nTriangle:");
        System.out.println("Base = " + triangle.base + ", Height = " + triangle.height);
        System.out.println("Area of Triangle = " + triangle.area());
    }
}
