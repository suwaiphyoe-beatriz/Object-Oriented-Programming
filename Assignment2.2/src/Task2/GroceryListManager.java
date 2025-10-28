package Task2;

import java.util.HashMap;
import java.util.Map;

public class GroceryListManager {
    private HashMap<String, Double> groceryList = new HashMap<>();

    // Adding an item with its cost
    public void addItem(String item, double cost) {
        if (groceryList.containsKey(item)) {
            System.out.println("The item \"" + item + "\" is already in the list!");
        } else {
            groceryList.put(item, cost);
            System.out.println("Added \"" + item + "\" with cost $" + cost + " to the grocery list.");
        }
    }

    // removing an item
    public void removeItem(String item) {
        if (groceryList.containsKey(item)) {
            groceryList.remove(item);
            System.out.println("Removed \"" + item + "\" from the grocery list.");
        } else {
            System.out.println("The item \"" + item + "\" is not in the list!");
        }
    }

    // displaying all items with their costs
    public void displayList() {
        System.out.println("\nGrocery List:");
        if (groceryList.isEmpty()) {
            System.out.println("(Your grocery list is empty.)");
        } else {
            int i = 1;
            for (Map.Entry<String, Double> entry : groceryList.entrySet()) {
                System.out.printf("%d. %s - $%.2f%n", i++, entry.getKey(), entry.getValue());
            }
        }
    }

    // checking if an item exists
    public boolean checkItem(String item) {
        return groceryList.containsKey(item);
    }

    // calculating total cost
    public double calculateTotalCost() {
        double total = 0.0;
        for (double cost : groceryList.values()) {
            total += cost;
        }
        return total;
    }

    public static void main(String[] args) {
        GroceryListManager manager = new GroceryListManager();

        // Adding items with costs
        manager.addItem("Apples", 2.50);
        manager.addItem("Milk", 1.75);
        manager.addItem("Bread", 2.00);
        manager.addItem("Milk", 1.75); // duplicate check

        manager.displayList();

        // Check for an item
        String itemToCheck = "Milk";
        System.out.println("\nIs \"" + itemToCheck + "\" in the grocery list? " + manager.checkItem(itemToCheck));

        // Calculate total cost
        System.out.printf("\nTotal cost of all items: $%.2f%n", manager.calculateTotalCost());

        // Remove an item
        System.out.println("\nRemoving \"" + itemToCheck + "\" from the list...");
        manager.removeItem(itemToCheck);

        //updated list
        manager.displayList();
        System.out.printf("\nUpdated total cost: $%.2f%n", manager.calculateTotalCost());
    }
}

