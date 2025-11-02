package Task3;

public class Motorcycle extends AbstractVehicle {
    public Motorcycle(String color) {
        super("Motorcycle", "Gasoline", color);
    }

    @Override
    public String getInfo() {
        return super.getInfo() + "\nEngine Type: 2-cylinder";
    }
}
