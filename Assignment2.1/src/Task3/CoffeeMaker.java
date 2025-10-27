package Task3;

public class CoffeeMaker {
    private boolean on;
    private String coffeeType; // normal or espresso
    private int coffeeAmount;  // 10–80 ml

    public CoffeeMaker() {
        on = false;
        coffeeType = "normal";
        coffeeAmount = 10;
    }

    public void switchOnOff() {
        on = !on;
        System.out.println("Coffee maker is " + (on ? "on" : "off"));
    }

    public void setCoffeeType(String type) {
        if (on && (type.equals("normal") || type.equals("espresso"))) {
            coffeeType = type;
        }
    }

    public void setCoffeeAmount(int amount) {
        if (on && amount >= 10 && amount <= 80) {
            coffeeAmount = amount;
        }
    }

    public String getCoffeeType() {
        return coffeeType;
    }

    public int getCoffeeAmount() {
        return coffeeAmount;
    }
}
