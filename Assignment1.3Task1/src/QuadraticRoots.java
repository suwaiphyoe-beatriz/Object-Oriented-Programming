import java.util.Scanner;

public class QuadraticRoots {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter coefficient a: ");
        double a = Double.parseDouble(scanner.nextLine());

        System.out.print("Enter coefficient b: ");
        double b = Double.parseDouble(scanner.nextLine());

        System.out.print("Enter coefficient c: ");
        double c = Double.parseDouble(scanner.nextLine());


        double discriminant = (b * b)- (4 * a * c) ; // b^2 -4ac

        if (discriminant > 0) {
            // Two real roots
            double root1 = (-b + Math.sqrt(discriminant)) / (2 * a);
            double root2 = (-b - Math.sqrt(discriminant)) / (2 * a);
            System.out.printf("Roots are: %.2f and %.2f%n", root1, root2);
        }
        else if (discriminant == 0) {

            double root = -b / (2 * a);
            System.out.printf("Root is: %.2f%n", root);
        }
        else {

            System.out.println("No real roots");
        }
    }
}
