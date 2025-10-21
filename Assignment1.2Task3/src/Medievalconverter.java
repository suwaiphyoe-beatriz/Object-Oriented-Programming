import java.util.Scanner;

public class Medievalconverter {
    public static void main(String[] args) {
        final double luotiInGrams = 13.28;
        final int naulaInLuoti = 32;
        final int leiviskaInNaula = 20;

        Scanner input = new Scanner(System.in);
        System.out.print("Weight (g): ");
        double grams = input.nextDouble();

        // Convert grams to luoti
        double totalLuoti = grams / luotiInGrams;

        //  leiviskä, naula, and luoti
        int leiviska = (int)(totalLuoti / (naulaInLuoti * leiviskaInNaula));
        double remainderAfterLeiviska = totalLuoti % (naulaInLuoti * leiviskaInNaula);

        int naula = (int)(remainderAfterLeiviska / naulaInLuoti);
        double luoti = remainderAfterLeiviska % naulaInLuoti;

        System.out.printf("%.0f grams is %d leiviskä, %d naula, and %.2f luoti.%n", grams, leiviska, naula, luoti);
    }
}
