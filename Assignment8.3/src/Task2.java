import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Task2 {
    public static void main(String[] args) {
        // Create a list of integers
        List<Integer> numbers = new ArrayList<>(Arrays.asList(10, 5, 8, 20, 15, 3, 12));

        // Filter out even numbers
        numbers.removeIf(n -> n % 2 == 0);

        System.out.println("Odd numbers:");
        numbers.forEach(System.out::println);

        // Double the odd numbers
        numbers.replaceAll(n -> n * 2);

        System.out.println("\nDoubled odd numbers:");
        numbers.forEach(System.out::println);

        // Calculate the sum of numbers
        int sum = 0;
        for (int n : numbers) {
            sum += n;
        }

        System.out.println("\nSum of numbers: " + sum);
    }
}
