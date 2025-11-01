package Task2;

public class BusTester {
    public static void main(String[] args) {
        Bus cityBus = new Bus("Volvo 9700", 50);

        cityBus.fillTank();
        // pass enter
        cityBus.passengerEnter();
        cityBus.passengerEnter();
        cityBus.passengerEnter();

        //accelerate
        cityBus.accelerate();
        cityBus.accelerate();

        System.out.println("\nCurrent bus status:");
        System.out.println(cityBus);

        //pass exit
        cityBus.passengerExit();
        cityBus.passengerExit();

        //decelerate
        cityBus.decelerate(10);
        System.out.println("\nFinal bus status:");
        System.out.println(cityBus);
    }
}

