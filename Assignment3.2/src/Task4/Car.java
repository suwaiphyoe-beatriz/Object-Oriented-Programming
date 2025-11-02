package Task4;

public class Car extends AbstractVehicle {
    public Car(String color, double fuelEfficiency) {
        super("Car", "Petrol", color, fuelEfficiency);
    }

    @Override
    public String getInfo() {
        return super.getInfo() + "\nDoors: 4";
    }
}

