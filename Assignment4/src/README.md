## Calculator Project

This project implements a simple Calculator class in Java. The calculator sums positive integers, can reset to zero, and throws an exception for negative values. GitHub Copilot was used to assist in writing some method implementations and explanations.

### Calculator.java
```java
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
```
#### How the class works
- The `Calculator` class has a private integer field `total` that keeps track of the sum.
- The constructor initializes `total` to zero.
- The `reset` method sets `total` back to zero.
- The `add` method takes an integer value and adds it to `total`.
- The `getTotal` method returns the current value of `total`.
### Usage
To use the `Calculator` class, create an instance of it, call the `add` method with positive integers, and retrieve the sum using `getTotal`. You can reset the total to zero using the `reset` method.
### Note
This implementation does not handle negative values. If you want to extend the functionality to throw an exception for negative inputs, you can modify the `add` method accordingly.
```java
public void add(int value) {
    if (value < 0) {
        throw new IllegalArgumentException("Negative values are not allowed");
    }
    this.total += value;
}
```                     
