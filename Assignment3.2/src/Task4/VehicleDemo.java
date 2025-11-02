package Task4;

public class VehicleDemo {
    public static void main(String[] args) {
        System.out.println("Vehicle Demo with Fuel Efficiency Calculation\n");

        Vehicle[] vehicles = {
                new Car("Red", 15.0),
                new Motorcycle("Black", 30.0),
                new Bus("Yellow", 40, 5.0),
                new ElectricCar("Blue", 6.0),   // 6 km/kWh
                new ElectricMotorcycle("White", 9.5) // 9.5 km/kWh
        };

        for (Vehicle v : vehicles) {
            v.start();
            v.stop();
            System.out.println(v.getInfo());
            System.out.println("Calculated Efficiency: " + v.calculateFuelEfficiency());

            // Check for electric interface
            if (v instanceof ElectricVehicle ev) {
                ev.charge();
            }

        }
    }
}