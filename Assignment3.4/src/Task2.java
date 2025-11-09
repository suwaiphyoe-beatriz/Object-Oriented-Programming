import java.io.*;

public class Task2 {

    public static void main(String[] args) {
        String filename = "fibonacci.csv";

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            writer.write("Index;Fibonacci\n");

            long a = 0, b = 1;

            for (int i = 0; i < 60; i++) {
                writer.write(i + ";" + a + "\n");
                long next = a + b;
                a = b;
                b = next;
            }

            System.out.println("Fibonacci CSV file created successfully!");

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
