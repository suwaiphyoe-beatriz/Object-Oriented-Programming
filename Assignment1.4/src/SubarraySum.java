import java.util.Scanner;

public class SubarraySum {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Asking the user size of the array
        System.out.print("Enter the size of the array: ");
        int n = input.nextInt();

        int[] arr = new int[n];

        // Ask q to enter the numbers
        System.out.println("Enter the integers into the array:");
        for (int i = 0; i < n; i++) {
            System.out.print("Enter integer " + (i + 1) + ": ");
            arr[i] = input.nextInt();
        }

        int maxSum = Integer.MIN_VALUE;
        int start = 0;
        int end = 0;

        // Check all possible subarrays
        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = i; j < n; j++) {
                sum += arr[j];
                if (sum > maxSum) {
                    maxSum = sum;
                    start = i;
                    end = j;
                }
            }
        }

        System.out.println();
        System.out.println("Maximum sum: " + maxSum);
        System.out.println("Integers: " + (start + 1) + "-" + (end + 1));
    }
}

