package Task4;

public class ElectricMotorcycle extends AbstractVehicle {

    public ElectricMotorcycle(String color, double efficiency) {
        super("Electric Motorcycle", "Electricity", color, efficiency);
    }

    @Override
    public void charge() {
        System.out.println(type + " is charging");
    }

    @Override
    public String getInfo() {
        return super.getInfo() + "\nBattery Capacity: 15 kWh";
    }
}
