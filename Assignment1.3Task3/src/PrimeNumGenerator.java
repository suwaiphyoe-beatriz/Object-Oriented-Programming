import java.util.Scanner;
public class PrimeNumGenerator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the start number: ");
        int start = Integer.parseInt(scanner.nextLine());

        System.out.print("Enter the end number: ");
        int end = Integer.parseInt(scanner.nextLine());

        if (start <= 0 || end <= 0 || start >=end ) {
            System.out.println("Invalid input");
            return;
        }
        System.out.println("Prime numbers between " + start + " and " + end + ":");

        for (int i = start; i <= end; i++) {
            if (isPrime(i)){
                System.out.print(i + " ");
            }
        }
    }
    public static boolean isPrime(int number) {
        if (number <= 1) return false;

        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }
}
