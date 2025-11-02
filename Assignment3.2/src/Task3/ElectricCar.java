package Task3;
// Electric car subclass with real charging behavior.

public class ElectricCar extends AbstractVehicle {

    public ElectricCar(String color) {
        super("Electric Car", "Electricity", color);
    }

    @Override
    public void charge() {
        System.out.println(type + " is charging at the station");
    }

    @Override
    public String getInfo() {
        return super.getInfo() + "\nBattery Capacity: 75 kWh";
    }
}

