import java.util.Arrays;

public class Task1 {
    public static void main(String[] args) {
        int[] numbers = {10, 20, 30, 40, 50};

        double mean = Arrays.stream(numbers)
                .average()
                .orElse(0); // Default to 0 if array is empty

        System.out.println("Mean: " + mean);
    }
}
