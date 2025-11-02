package Task4;

public class Motorcycle extends AbstractVehicle {
    public Motorcycle(String color, double fuelEfficiency) {
        super("Motorcycle", "Gasoline", color, fuelEfficiency);
    }

    @Override
    public String getInfo() {
        return super.getInfo() + "\nEngine Type: 2-cylinder";
    }
}