class TicketSystem {
    private int availableSeats;

    public TicketSystem(int seats) {
        this.availableSeats = seats;
    }

    public synchronized boolean reserve(String customerName, int seatsRequested) {
        if (seatsRequested <= availableSeats) {
            availableSeats -= seatsRequested;
            System.out.println(customerName + " reserved " + seatsRequested + " tickets.");
            return true;
        } else {
            System.out.println(customerName + " couldn't reserve " + seatsRequested + " tickets.");
            return false;
        }
    }
}

class Customer implements Runnable {
    private TicketSystem ticketSystem;
    private String name;
    private int seatsWanted;

    public Customer(TicketSystem system, String name, int seatsWanted) {
        this.ticketSystem = system;
        this.name = name;
        this.seatsWanted = seatsWanted;
    }

    @Override
    public void run() {
        ticketSystem.reserve(name, seatsWanted);
    }
}

public class Task1 {
    public static void main(String[] args) {
        TicketSystem system = new TicketSystem(10); // total seats

        Thread[] customers = new Thread[15];

        int[] requests = {1, 2, 2, 3, 1, 2, 1, 3, 1, 3, 2, 4, 1, 4, 3};

        for (int i = 0; i < customers.length; i++) {
            customers[i] = new Thread(new Customer(system,
                    "Customer " + (i + 1), requests[i]));
        }

        for (Thread t : customers) t.start();
        for (Thread t : customers) {
            try { t.join(); } catch (Exception ignored) {}
        }
    }
}
