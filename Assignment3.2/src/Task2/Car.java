package Task2;
//Car extends AbstractVehicle with specific details.
public class Car extends AbstractVehicle {

    public Car(String color) {
        super("Car", "Petrol", color);
    }

    @Override
    public String getInfo() {
        return super.getInfo() + "\nDoors: 4";
    }
}
