import java.util.Arrays;
import java.util.Random;

public class Task2 {

    private static int[] numbers;

    private static volatile long totalSum = 0;

    private static final Object lock = new Object();

    private static class SumTask implements Runnable {
        private final int start; // Starting index (inclusive)
        private final int end;   // Ending index (exclusive)

        public SumTask(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public void run() {
            long partialSum = 0;
            //assigned portion atwk calculate sum dr
            for (int i = start; i < end; i++) {
                partialSum += numbers[i];
            }

            // Synchronize to shared totalSum
            synchronized (lock) {
                totalSum += partialSum;
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {

        final int ARRAY_SIZE = 100000;
       // Get no of available processor cores
        final int NUM_CORES = Runtime.getRuntime().availableProcessors();

        System.out.println("Starting Parallel Sum Calculation");
        System.out.println("Array Size: " + ARRAY_SIZE);
        System.out.println("Available Processor Cores: " + NUM_CORES);

        numbers = generateRandomArray(ARRAY_SIZE);

        // Prepare  Threads
        Thread[] threads = new Thread[NUM_CORES];
        int chunkSize = ARRAY_SIZE / NUM_CORES;
        int remainder = ARRAY_SIZE % NUM_CORES;
        int currentStart = 0;

        long startTime = System.nanoTime();

        // Create and start the threads
        for (int i = 0; i < NUM_CORES; i++) {
            int currentEnd = currentStart + chunkSize;

            if (i < remainder) {
                currentEnd++;
            }

            //new SumTask for the segment
            threads[i] = new Thread(new SumTask(currentStart, currentEnd));
            threads[i].start();

            //start index fornext thread
            currentStart = currentEnd;
        }

        for (Thread t : threads) {
            t.join();
        }

        long endTime = System.nanoTime(); // End timing

        // Verification (Single-threaded calculation)
        long sequentialSum = calculateSequentialSum(numbers);

        System.out.println("\n--- Results ---");
        System.out.println("Parallel Sum: " + totalSum);
        System.out.println("Sequential Sum (Verification): " + sequentialSum);

        if (totalSum == sequentialSum) {
            System.out.println("Verification successful: The sums match.");
        } else {
            System.out.println("Verification failed: The sums do not match.");
        }

        System.out.printf("Total Parallel Execution Time: %.3f ms\n", (endTime - startTime) / 1_000_000.0);
    }

    //hp method to generateRandomArray
    private static int[] generateRandomArray(int size) {
        int[] arr = new int[size];
        Random random = new Random();
        for (int i = 0; i < size; i++) {
            // Generate numbers between 1 and 100
            arr[i] = random.nextInt(100) + 1;
        }
        return arr;
    }

    private static long calculateSequentialSum(int[] arr) {
        long sum = 0;
        for (int num : arr) {
            sum += num;
        }
        return sum;
    }
}