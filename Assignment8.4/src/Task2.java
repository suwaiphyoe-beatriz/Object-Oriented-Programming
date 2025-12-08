import java.util.Arrays;
import java.util.List;

public class Task2 {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(10, 5, 8, 20, 15, 3, 12);

        // Filter odd numbers, double them, then sum
        int sum = numbers.stream()
                .filter(n -> n % 2 != 0)  // Keep only odd numbers
                .map(n -> n * 2)          // Double each number
                .reduce(0, Integer::sum); // Sum the results

        System.out.println("Sum of doubled odd numbers: " + sum);
    }
}
