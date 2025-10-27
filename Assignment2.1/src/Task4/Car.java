package Task4;

public class Car {
    private double speed;
    private double gasolineLevel;
    private double tankCapacity;
    private String typeName;

    // Cruise Control
    private boolean cruiseControlOn;
    private double targetSpeed;
    private static final double MIN_CRUISE_SPEED = 30;
    private static final double MAX_CRUISE_SPEED = 180;

    public Car(String typeName) {
        this.typeName = typeName;
        speed = 0;
        gasolineLevel = 0;
        tankCapacity = 100; // default
        cruiseControlOn = false; // added initialization
    }

    public Car(String typeName, double gasolineLevel, double speed) {
        this.typeName = typeName;
        this.gasolineLevel = gasolineLevel;
        this.tankCapacity = tankCapacity;
        this.speed = speed;
        this.cruiseControlOn = false;
    }

    public void accelerate() {
        if (gasolineLevel > 0)
            speed += 10;
        else
            speed = 0;
    }

    void decelerate(int amount) {
        if (gasolineLevel > 0) {
            if (amount > 0)
                speed = Math.max(0, speed - amount);
        } else
            speed = 0;
    }

    double getSpeed() {
        return speed;
    }

    String getTypeName() {
        return typeName;
    }

    void fillTank() {
        gasolineLevel = 100;
    }

    double getGasolineLevel() {
        return gasolineLevel;
    }

    //Cruise Control Methods
    public void setTargetSpeed(double target) {
        this.targetSpeed = target;
    }

    public double getTargetSpeed() {
        return targetSpeed;
    }

    public boolean turnOnCruiseControl() {
        if (gasolineLevel <= 0) {
            System.out.println("Cannot turn on cruise control — out of fuel.");
            cruiseControlOn = false;
            return false;
        }
        if (targetSpeed < MIN_CRUISE_SPEED || targetSpeed > MAX_CRUISE_SPEED) {
            System.out.println("Target speed out of range (" + MIN_CRUISE_SPEED + "–" + MAX_CRUISE_SPEED + ").");
            cruiseControlOn = false;
            return false;
        }
        cruiseControlOn = true;
        System.out.println("Cruise control activated at target speed: " + targetSpeed + " km/h");
        return true;
    }

    public void turnOffCruiseControl() {
        cruiseControlOn = false;
        System.out.println("Cruise control turned off.");
    }

    // adjusting speed ctrl
    public void updateCruiseControl() {
        if (!cruiseControlOn) return;

        if (gasolineLevel <= 0) {
            cruiseControlOn = false;
            System.out.println("Cruise control OFF (out of fuel).");
            return;
        }

        if (Math.abs(speed - targetSpeed) < 1) {
            speed = targetSpeed;  // close
            System.out.println("Cruise control maintaining speed at " + speed + " km/h");
        } else if (speed < targetSpeed) {
            accelerate();
            System.out.println("Accelerating toward cruise speed: " + speed + " km/h");
        } else {
            decelerate(5);
            System.out.println("Decelerating toward cruise speed: " + speed + " km/h");
        }

        if (targetSpeed > MAX_CRUISE_SPEED || targetSpeed < MIN_CRUISE_SPEED) {
            cruiseControlOn = false;
            System.out.println("Cruise control OFF (invalid target speed).");
        }
    }
}
