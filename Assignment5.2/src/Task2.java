import java.util.ArrayList;

class ThreadSafeList<T> {
    private final ArrayList<T> list = new ArrayList<>();

    public synchronized void add(T element) {
        list.add(element);
    }

    public synchronized boolean remove(T element) {
        return list.remove(element);
    }

    public synchronized int size() {
        return list.size();
    }
}

public class Task2 {

    public static void main(String[] args) {
        ThreadSafeList<String> safeList = new ThreadSafeList<>();

        Runnable addTask = () -> {
            for (int i = 0; i < 1000; i++) {
                safeList.add(Thread.currentThread().getName() + "_item_" + i);
            }
        };

        Runnable removeTask = () -> {
            safeList.remove("does_not_exist");
        };

        Thread[] adders = new Thread[10];
        Thread[] removers = new Thread[5];

        for (int i = 0; i < adders.length; i++) {
            adders[i] = new Thread(addTask, "Adder-" + i);
        }

        for (int i = 0; i < removers.length; i++) {
            removers[i] = new Thread(removeTask, "Remover-" + i);
        }

        for (Thread t : adders) t.start();
        for (Thread t : removers) t.start();

        try {
            for (Thread t : adders) t.join();
            for (Thread t : removers) t.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Final list size: " + safeList.size());
    }
}
