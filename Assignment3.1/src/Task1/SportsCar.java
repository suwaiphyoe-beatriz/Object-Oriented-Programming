package Task1;

public class SportsCar extends Car {

    public SportsCar(String typeName) {
        super(typeName);
    }

    @Override
    public void accelerate() {
        if (gasolineLevel > 0) {
            speed += 20;          // faster
            gasolineLevel -= 2;   // uses more fuel
        } else {
            speed = 0;
        }
    }

    @Override
    public void decelerate(int amount) {
        super.decelerate(amount * 2); // stronger brakes
    }

    @Override
    public String toString() {
        return "SportsCar " + super.toString();
    }
}
