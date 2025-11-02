package Task3;

public class Bus extends AbstractVehicle {
    private int capacity;

    public Bus(String color, int capacity) {
        super("Bus", "Diesel", color);
        this.capacity = capacity;
    }

    @Override
    public String getInfo() {
        return super.getInfo() + "\nCapacity: " + capacity + " passengers";
    }
}
