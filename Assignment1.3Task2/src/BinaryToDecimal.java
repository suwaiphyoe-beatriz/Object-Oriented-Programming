import java.util.Scanner;

public class BinaryToDecimal {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a binary number: ");
        String binary = scanner.nextLine();

        int decimal = 0;

        for (int i = 0; i < binary.length(); i++) {
            char bit = binary.charAt(i);

            if (bit == '0' || bit == '1') {

                decimal = decimal * 2 + (bit - '0');
            } else {
                System.out.println("Invalid input! Only 0s and 1s allowed.");
                return;
            }
        }

        System.out.println("Decimal equivalent : " + decimal);
    }
}
