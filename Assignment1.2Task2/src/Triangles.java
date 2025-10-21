import java.util.Scanner;
public class Triangles {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the length of your triangle: ");
        double length = Double.parseDouble(scanner.nextLine());

        System.out.print("Enter the height of your triangle: ");
        double height = Double.parseDouble(scanner.nextLine());

        double lengthsquared = Math.pow(length, 2);
        double heightsquared = Math.pow(height, 2);
        double sumOfSquares = lengthsquared + heightsquared ;

        double hypotenuse = Math.sqrt(sumOfSquares);

        System.out.printf("The length of the hypotenuse is: %.4f\n", hypotenuse);

    }
}
