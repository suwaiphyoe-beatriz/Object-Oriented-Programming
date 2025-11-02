package Task1;

public class VehicleDemo {
    public static void main(String[] args) {
        System.out.println("Vehicle Demonstration\n");

        Vehicle[] vehicles = {
                new Car(),
                new Motorcycle(),
                new Bus()
        };

        for (Vehicle v : vehicles) {
            v.start();
            v.stop();
            System.out.println(v.getInfo());
            System.out.println();
        }
    }
}