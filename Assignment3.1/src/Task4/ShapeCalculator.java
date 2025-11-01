package Task4;

public class ShapeCalculator {
    public static void main(String[] args) {
        System.out.println("Shape Calculator with colors \n");

        Shape[] shapes = {
                new Circle("Red", 5.0),
                new Rectangle("Blue", 4.0, 6.0),
                new Triangle("Green", 3.0, 8.0)
        };

        for (Shape shape : shapes) {
            System.out.println("Area of " + shape + ": " + shape.calculateArea());
        }
    }
}
