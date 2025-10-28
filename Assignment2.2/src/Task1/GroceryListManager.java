package Task1;

import java.util.ArrayList;

public class GroceryListManager {
    private ArrayList<String> groceryList = new ArrayList<>();

    //Adding an item
    public void addItem(String item) {
        if (groceryList.contains(item)) {
            System.out.println("️The item \"" + item + "\" is already in the list!");
        } else {
            groceryList.add(item);
            System.out.println("Added \"" + item + "\" to the grocery list.");
        }
    }

    // removing an item
    public void removeItem(String item) {
        if (groceryList.contains(item)) {
            groceryList.remove(item);
            System.out.println("Removed \"" + item + "\" from the grocery list.");
        } else {
            System.out.println("The item \"" + item + "\" is not in the list!");
        }
    }

    // displaying all items
    public void displayList() {
        System.out.println("\nGrocery List:");
        if (groceryList.isEmpty()) {
            System.out.println("(Your grocery list is empty.)");
        } else {
            for (int i = 0; i < groceryList.size(); i++) {
                System.out.println((i + 1) + ". " + groceryList.get(i));
            }
        }
    }

    //checking if an item exists
    public boolean checkItem(String item) {
        return groceryList.contains(item);
    }

    public static void main(String[] args) {
        GroceryListManager manager = new GroceryListManager();

        // Adding items
        manager.addItem("Apples");
        manager.addItem("Milk");
        manager.addItem("Bread");
        manager.addItem("Milk"); // checking duplicates

        manager.displayList();

        // Check for an item
        String itemToCheck = "Milk";
        System.out.println("\nIs \"" + itemToCheck + "\" in the grocery list? " + manager.checkItem(itemToCheck));

        // Remove an item
        System.out.println("\nRemoving \"" + itemToCheck + "\" from the list...");
        manager.removeItem(itemToCheck);
        manager.removeItem(itemToCheck);

        // updated list
        manager.displayList();
    }
}
