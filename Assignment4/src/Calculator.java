public class Calculator {
    private int total;

    public Calculator (){
        this.total = 0; //copilot suggested this line
    }
    public void reset() {
        this.total = 0; // copilot
    }
    public void add(int value) { // copilot
        if (value < 0) {
            throw new IllegalArgumentException("Negative values are not allowed");
        }
        this.total += value;
    }
    public int getTotal() {
        return this.total; // copilot
    }

    //temporary method to demonstrate functionality
    public static void main(String[] args) {
        Calculator calc = new Calculator(); // copilot
        calc.add(5);
        calc.add(10);
        System.out.println("Total: " + calc.getTotal()); // Should print Total: 15
        calc.reset();
        System.out.println("Total after reset: " + calc.getTotal()); // Should print Total after reset: 0
    }

}