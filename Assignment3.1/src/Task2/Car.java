package Task2;

public class Car {
    protected double speed;          // made protected so subclasses can access
    protected double gasolineLevel;
    protected String typeName;

    public Car(String typeName) {
        this.typeName = typeName;
        this.speed = 0;
        this.gasolineLevel = 0;
    }

    public void accelerate() {
        if (gasolineLevel > 0) {
            speed += 10;
            gasolineLevel -= 1;
        } else {
            speed = 0;
        }
    }

    public void decelerate(int amount) {
        if (gasolineLevel > 0 && amount > 0) {
            speed = Math.max(0, speed - amount);
        } else {
            speed = 0;
        }
    }

    public void fillTank() {
        gasolineLevel = 100;
    }

    public double getSpeed() {
        return speed;
    }

    public double getGasolineLevel() {
        return gasolineLevel;
    }

    public String getTypeName() {
        return typeName;
    }

    @Override
    public String toString() {
        return typeName + " speed: " + speed + " km/h, fuel: " + gasolineLevel + "%";
    }
}
