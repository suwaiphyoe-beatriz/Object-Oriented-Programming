package Task3;

//Demon Vehicle inheritance with ElectricVehicle extension

public class VehicleDemo {
    public static void main(String[] args) {
        System.out.println("Electric Vehicles \n");

        Vehicle[] vehicles = {
                new Car("Red"),
                new Motorcycle("Black"),
                new Bus("Yellow", 40),
                new ElectricCar("Blue"),
                new ElectricMotorcycle("White")
        };

        for (Vehicle v : vehicles) {
            v.start();
            v.stop();
            System.out.println(v.getInfo());

            // Check if it supports charging
            // vehicle v ka e vehicle so yin charge() method gho call dr
            if (v instanceof ElectricVehicle ev) {
                ev.charge();
            }

            System.out.println();
        }
    }
}
