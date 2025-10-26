import java.util.Scanner;

public class RemovingDuplicates {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter the size of the array: ");
        int n = input.nextInt();

        int[] numbers = new int[n];

        System.out.println("Enter the integers into the array:");
        for (int i = 0; i < n; i++) {
            System.out.print("Enter integer " + (i + 1) + ": ");
            numbers[i] = input.nextInt();
        }

        // create new array
        int[] newarray = new int[n];
        int newCount = 0;

        // Go through the original array n keep only the first occurrence
        for (int i = 0; i < n; i++) {
            boolean alreadyExists = false;
            for (int j = 0; j < newCount; j++) {
                if (numbers[i] == newarray[j]) {
                    alreadyExists = true;
                    break;
                }
            }

            if (!alreadyExists) {
                newarray[newCount] = numbers[i];
                newCount++;
            }
        }

        System.out.println("\nThe array without duplicates:");
        for (int i = 0; i < newCount; i++) {
            System.out.print(newarray[i] + " ");
        }
    }
}
