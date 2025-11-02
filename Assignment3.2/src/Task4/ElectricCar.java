package Task4;

public class ElectricCar extends AbstractVehicle {

    public ElectricCar(String color, double efficiency) {
        super("Electric Car", "Electricity", color, efficiency);
    }

    @Override
    public void charge() {
        System.out.println(type + " is charging at the station"+ "\n");
    }

    @Override
    public String getInfo() {
        return super.getInfo() + "\nBattery Capacity: 75 kWh";
    }
}

