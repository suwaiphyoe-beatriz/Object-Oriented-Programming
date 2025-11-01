package Task3;

public class ShapeCalculator {

    public static void main(String[] args) {
        System.out.println("Shape Calculator\n");

        // Array of different Shape types
        Shape[] shapes = {
                new Circle(5.0),
                new Rectangle(4.0, 6.0),
                new Triangle(3.0, 8.0)
        };

        //  same method name, different behavior
        for (Shape shape : shapes) {
            System.out.println("Area of " + shape + ": " + shape.calculateArea());
        }
    }
}
