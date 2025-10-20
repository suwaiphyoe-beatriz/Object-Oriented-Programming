import java.util.Scanner;

public class SumOfThreeNumbers {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Give the first number:");
        int first = Integer.parseInt(scanner.nextLine());

        System.out.println("Give the second number:");
        int second = Integer.parseInt(scanner.nextLine());

        System.out.println("Give the third number:");
        int third = Integer.parseInt(scanner.nextLine());

        // Calculate the Sum
        int sum = first + second + third;

        // Calculate the Product
        int product = first * second * third;

        // Calculate Average
        double average = (double) sum / 3;
        /*
        We need to use floating-point division to maintain average's decimal precision. If we divide two integers, Java drops the decimal part (e.g., 13 / 3 = 4).To avoid this, I convert the sum to a double before dividing.*/

        System.out.println("The sum of the numbers is " + sum);
        System.out.println("The product of the numbers is " + product);
        System.out.println("The average of the numbers is " + average);
    }
}