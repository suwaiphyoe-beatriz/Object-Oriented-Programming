package Task1;
// vehicle interface gho implement lok pe represents petrol powered car
public class Car implements Vehicle {
    private String fuel = "Petrol";
    private String color = "Red";

    @Override
    public void start() {
        System.out.println("Car is starting...");
    }

    @Override
    public void stop() {
        System.out.println("Car is stopping...");
    }

    @Override
    public String getInfo() {
        return "Type: Car\nFuel: " + fuel + "\nColor: " + color;
    }
}
