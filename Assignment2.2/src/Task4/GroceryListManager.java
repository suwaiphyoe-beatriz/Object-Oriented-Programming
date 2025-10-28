package Task4;

import java.util.HashMap;
import java.util.Map;

public class GroceryListManager {
    static class Item {
        double cost;
        String category;
        int quantity;

        Item(double cost, String category, int quantity) {
            this.cost = cost;
            this.category = category;
            this.quantity = quantity;
        }
    }

    private HashMap<String, Task4.GroceryListManager.Item> groceryList = new HashMap<>();

    // adding an item with cost and category
    public void addItem(String item, double cost, String category, int quantity) {
        if (groceryList.containsKey(item)) {
            System.out.println("The item \"" + item + "\" is already in the list!Update quantity instead.");
            Item existing = groceryList.get(item);
            existing.quantity += quantity;
        }
        else {
            groceryList.put(item, new Task4.GroceryListManager.Item(cost, category, quantity));
            System.out.println("Added \"" + item + "\" (" + category + ") - $" + cost + quantity);
        }
    }

    // Update the quantity of a specific item
    public void updateQuantity(String item, int newQuantity) {
        if (groceryList.containsKey(item)) {
            groceryList.get(item).quantity = newQuantity;
            System.out.println("Updated quantity of \"" + item + "\" to " + newQuantity + ".");
        } else {
            System.out.println("The item \"" + item + "\" is not in the grocery list!");
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

    public void displayAvailableItems() {
        System.out.println("\nAvailable Items:");
        boolean found = false;
        int i = 1;
        for (Map.Entry<String, Item> entry : groceryList.entrySet()) {
            Item item = entry.getValue();
            if (item.quantity > 0) {
                System.out.printf("%d. %s - $%.2f (%s) x%d%n",
                        i++, entry.getKey(), item.cost, item.category, item.quantity);
                found = true;
            }
        }
        if (!found) {
            System.out.println("(No available items — all quantities are zero.)");
        }
    }

    // displaying all items with cost , category n quantity
    public void displayList() {
        System.out.println("\nGrocery List:");
        if (groceryList.isEmpty()) {
            System.out.println("(Your grocery list is empty.)");
        } else {
            int i = 1;
            for (Map.Entry<String, Item> entry : groceryList.entrySet()) {
                Item item = entry.getValue();
                System.out.printf("%d. %s - $%.2f (%s) x%d%n",
                        i++, entry.getKey(), item.cost, item.category, item.quantity);
            }
        }
    }

    // displaying items by category
    public void displayByCategory(String category) {
        System.out.println("\nItems in category: " + category);
        boolean found = false;
        int i = 1;
        for (Map.Entry<String, Task4.GroceryListManager.Item> entry : groceryList.entrySet()) {
            if (entry.getValue().category.equalsIgnoreCase(category)) {
                System.out.printf("%d. %s - $%.2f%n", i++, entry.getKey(), entry.getValue().cost);
                found = true;
            }
        }
        if (!found) {
            System.out.println("No items found in this category.");
        }
    }

    // checking if an item exists
    public boolean checkItem(String item) {
        return groceryList.containsKey(item);
    }

    // calculating total cost
    public double calculateTotalCost() {
        double total = 0.0;
        for (Item item : groceryList.values()) {
            total += item.cost * item.quantity;
        }
        return total;
    }

    public static void main(String[] args) {
        Task4.GroceryListManager manager = new Task4.GroceryListManager();

        // adding items with cost, category, and quantity
        manager.addItem("Apples", 2.50, "Fruits", 5);
        manager.addItem("Milk", 1.75, "Dairy", 2);
        manager.addItem("Bread", 2.00, "Bakery", 1);
        manager.addItem("Cheese", 3.50, "Dairy", 0); // zero quantity test
        manager.addItem("Apples", 2.50, "Fruits", 3); // duplicate item test (adds more quantity)

        manager.displayList();

        // Display available items
        manager.displayAvailableItems();

        // Updating quantity of an item
        manager.updateQuantity("Milk", 0);

        // updated availability
        manager.displayAvailableItems();

        // calculating total cost with quantities
        System.out.printf("\nTotal cost of all items: $%.2f%n", manager.calculateTotalCost());
    }
}