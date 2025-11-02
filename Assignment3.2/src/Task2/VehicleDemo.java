package Task2;

public class VehicleDemo {
    public static void main(String[] args) {
        System.out.println("Vehicle Demonstration\n");

        Vehicle[] vehicles = {
                new Car("Red"),
                new Motorcycle("Black"),
                new Bus("Yellow", 40)
        };

        for (Vehicle v : vehicles) {
            v.start();
            v.stop();
            System.out.println(v.getInfo());
            System.out.println();
        }
    }
}

