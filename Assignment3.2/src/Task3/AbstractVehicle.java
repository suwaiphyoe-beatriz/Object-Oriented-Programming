package Task3;
// AbstractVehicle ka  Vehicle nk ElectricVehicle 2 khu lone gho implement dl
//Non-electric subclasses will override charge() to indicate it's not applicable.
public abstract class AbstractVehicle implements Vehicle, ElectricVehicle {
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

    @Override
    public void charge() {
        System.out.println(type + ": Charging is not available for this vehicle type");
    }
}
