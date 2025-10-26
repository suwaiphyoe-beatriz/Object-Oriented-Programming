import java.util.Random;
import java.util.Scanner;

public class NameGenerator {
    public static void main(String[] args) {
        String[] firstNames = {"Alice", "Bob", "Charlie", "Diana", "Ethan", "Fiona"};
        String[] lastNames = {"Smith", "Johnson", "Brown", "Taylor", "Wilson", "Clark"};

        Scanner scanner = new Scanner(System.in);

        // question
        System.out.print("How many random names would you like to generate? ");
        int numofNames = scanner.nextInt();

        Random random = new Random();

        // Generate n print rd names
        System.out.println("\nGenerated names:");
        for (int i = 0; i < numofNames; i++) {
            int firstIndex = random.nextInt(firstNames.length);
            int lastIndex = random.nextInt(lastNames.length);
            String fullName = firstNames[firstIndex] + " " + lastNames[lastIndex];
            System.out.println((i + 1) + ". " + fullName);
        }
    }
}
