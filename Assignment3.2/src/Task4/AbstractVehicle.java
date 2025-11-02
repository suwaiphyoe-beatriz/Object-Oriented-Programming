package Task4;

public abstract class AbstractVehicle implements Vehicle, ElectricVehicle {
    protected String type;
    protected String fuelType;
    protected String color;
    protected double fuelEfficiency;

    public AbstractVehicle(String type, String fuelType, String color, double fuelEfficiency) {
        this.type = type;
        this.fuelType = fuelType;
        this.color = color;
        this.fuelEfficiency = fuelEfficiency;
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
                "\nColor: " + color +
                "\nFuel Efficiency: " + fuelEfficiency + getEfficiencyUnit();
    }

    // Helper to show proper unit
    protected String getEfficiencyUnit() {
        if (fuelType.equalsIgnoreCase("Electricity")) {
            return " km/kWh";
        }
        return " km/l";
    }

    @Override
    public void charge() {
        System.out.println(type + ": Charging is not available for this vehicle type."+ "\n");
    }

    @Override
    public double calculateFuelEfficiency() {
        return fuelEfficiency;
    }
}
