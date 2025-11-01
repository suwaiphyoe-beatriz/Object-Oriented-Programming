package Task2;

public class Bus extends Car {
    private int passengers;
    private int capacity;

    public Bus(String typeName, int capacity) {
        super(typeName);
        this.capacity = capacity;
        this.passengers = 0;
    }

    public void passengerEnter() {
        if (passengers < capacity) {
            passengers++;
            System.out.println("One passenger entered the bus.");
        } else {
            System.out.println("Bus is full!");
        }
    }

    public void passengerExit() {
        if (passengers > 0) {
            passengers--;
            System.out.println("One passenger exited the bus.");
        } else {
            System.out.println("No passengers to exit!");
        }
    }
    //return current number of pass
    public int getPassengers() {
        return passengers;
    }
    // Returns the maximum capacity of the bus.
    public int getCapacity() {
        return capacity;
    }

    @Override
    public String toString() {
        return "Bus " + typeName + " speed: " + speed + " km/h, fuel: " + gasolineLevel +
                "%, passengers: " + passengers + "/" + capacity;
    }
}
