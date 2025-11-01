package Task1;

public class SportsCarTester {
    public static void main(String[] args) {
        SportsCar ferrari = new SportsCar("Ferrari F8");
        ferrari.fillTank();
        ferrari.accelerate();
        ferrari.accelerate();
        ferrari.decelerate(5);

        System.out.println(ferrari);
    }
}

