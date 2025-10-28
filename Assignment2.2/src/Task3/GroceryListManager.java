package Task3;

import java.util.HashMap;
import java.util.Map;

public class GroceryListManager {
    static class Item {
        double cost;
        String category;

        Item(double cost, String category) {
            this.cost = cost;
            this.category = category;
        }
    }

    private HashMap<String, Item> groceryList = new HashMap<>();

    // adding an item with cost and category
    public void addItem(String item, double cost, String category) {
        if (groceryList.containsKey(item)) {
            System.out.println("The item \"" + item + "\" is already in the list!");
        } else {
            groceryList.put(item, new Item(cost, category));
            System.out.println("Added \"" + item + "\" (" + category + ") - $" + cost);
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

    // displaying all items with cost and category
    public void displayList() {
        System.out.println("\nGrocery List:");
        if (groceryList.isEmpty()) {
            System.out.println("(Your grocery list is empty.)");
        } else {
            int i = 1;
            for (Map.Entry<String, Item> entry : groceryList.entrySet()) {
                System.out.printf("%d. %s - $%.2f (%s)%n",
                        i++, entry.getKey(), entry.getValue().cost, entry.getValue().category);
            }
        }
    }

    // displaying items by category
    public void displayByCategory(String category) {
        System.out.println("\nItems in category: " + category);
        boolean found = false;
        int i = 1;
        for (Map.Entry<String, Item> entry : groceryList.entrySet()) {
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
            total += item.cost;
        }
        return total;
    }

    public static void main(String[] args) {
        GroceryListManager manager = new GroceryListManager();

        // adding categorized items
        manager.addItem("Apples", 2.50, "Fruits");
        manager.addItem("Milk", 1.75, "Dairy");
        manager.addItem("Bread", 2.00, "Bakery");
        manager.addItem("Cheese", 3.50, "Dairy");
        manager.addItem("Apples", 2.50, "Fruits"); // duplicate check

        manager.displayList();

        // displaying items in a specific category
        manager.displayByCategory("Dairy");

        // Calculate total cost
        System.out.printf("\nTotal cost of all items: $%.2f%n", manager.calculateTotalCost());

        // Remove an item and show update
        manager.removeItem("Milk");
        manager.displayList();
    }
}
