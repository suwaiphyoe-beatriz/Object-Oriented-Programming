import java.util.Scanner;
public class TempConverter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // constants for coverting formula
        final double TEMP_ADJUSTMENT = 32.0;
        final double TEMP_FACTOR = 5.0 / 9.0;

        System.out.print("Enter temperature in Fahrenheit: ");

        double fahrenheit = Double.parseDouble(scanner.nextLine());

        double celsius = (fahrenheit - TEMP_ADJUSTMENT) * TEMP_FACTOR;

        // Display the converted temperature, formatted to one decimal place,
        System.out.printf("The temperature in Celsius is: %.1f\n", celsius);

    }
}