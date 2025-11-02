package Task2;

public abstract class AbstractVehicle implements Vehicle {
    protected String type;
    protected String fuelType;
    protected String color;

    public AbstractVehicle(String type, String fuelType, String color) {
        this.type = type;
        this.fuelType = fuelType;
        this.color = color;
    }

    @Override
    public void start() {
        System.out.println(type + " is starting...");
    }

    @Override
    public void stop() {
        System.out.println(type + " is stopping...");
    }

    @Override
    public String getInfo() {
        return "Type: " + type +
                "\nFuel: " + fuelType +
                "\nColor: " + color;
    }
}
