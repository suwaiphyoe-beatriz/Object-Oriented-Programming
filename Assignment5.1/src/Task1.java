public class Task1 {

    private final int max;
    private int current = 1;
    private final Object lock = new Object();

    public Task1(int max) {
        this.max = max;
    }

    public void printOdd() {
        synchronized (lock) {
            while (current <= max) {
                if (current % 2 == 1) {
                    System.out.println("Odd Thread: " + current);
                    current++;
                    lock.notifyAll();
                } else {
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        return;
                    }
                }
            }
        }
    }

    public void printEven() {
        synchronized (lock) {
            while (current <= max) {
                if (current % 2 == 0) {
                    System.out.println("Even Thread: " + current);
                    current++;
                    lock.notifyAll();
                } else {
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        return;
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        Task1 printer = new Task1(20);

        Thread oddThread = new Thread(printer::printOdd);
        Thread evenThread = new Thread(printer::printEven);

        oddThread.start();
        evenThread.start();

        try {
            oddThread.join();
            evenThread.join();
        } catch (InterruptedException e) {}

        System.out.println("Printing complete.");
    }
}
