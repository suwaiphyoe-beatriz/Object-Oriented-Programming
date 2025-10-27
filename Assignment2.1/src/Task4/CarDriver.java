package Task4;

public class CarDriver {
    public static void main(String[] args) {
        Car myCar = new Car("Toyota Corolla", 80, 0); // using constructor with fuel + speed
        myCar.fillTank();

        for (int i = 0; i < 6; i++) {
            myCar.accelerate();
            System.out.println(myCar.getTypeName() + ": speed is " + myCar.getSpeed() + " km/h");
        }

        //Cruise Control
        System.out.println("\nTesting cruise control...");

        myCar.setTargetSpeed(50);// set target speed
        boolean cruiseOn = myCar.turnOnCruiseControl();

        if (cruiseOn) {
            for (int i = 0; i < 5; i++) {
                myCar.updateCruiseControl();// car adjusts toward target
            }
        } else {
            System.out.println("Cruise control could not be turned ON.");
        }

        myCar.turnOffCruiseControl();


        while (myCar.getSpeed() > 0) {
            myCar.decelerate(15);
            System.out.println(myCar.getTypeName() + ": speed is " + myCar.getSpeed() + " km/h");
        }
    }
}
