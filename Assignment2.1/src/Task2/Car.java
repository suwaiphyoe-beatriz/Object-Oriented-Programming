
package Task2;

public class Car {
    private double speed;
    private double gasolineLevel;
    private double tankCapacity;
    private String typeName;

    public Car(String typeName) {
        this.typeName = typeName;
        speed = 0;
        gasolineLevel = 0;
        tankCapacity = 100; // default
    }

    public Car(String typeName, double tankCapacity, double speed) {
        this.typeName = typeName;
        this.tankCapacity = tankCapacity;
        this.speed = speed;
        gasolineLevel = 0;
    }

    public void accelerate() {
        if (gasolineLevel > 0)
            speed += 10;
        else
            speed = 0;
    }

    public void decelerate(int amount) {
        if (gasolineLevel > 0)
            speed = Math.max(0, speed - amount);
        else
            speed = 0;
    }

    public double getSpeed() {
        return speed;
    }

    public String getTypeName() {
        return typeName;
    }

    public void fillTank() {
        gasolineLevel = tankCapacity;
    }

    public double getGasolineLevel() {
        return gasolineLevel;
    }
}
