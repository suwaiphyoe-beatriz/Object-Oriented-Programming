package Task2;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ShoppingCart {

    private static class Item {
        String name;
        double price;

        Item(String name, double price) {
            this.name = name;
            this.price = price;
        }
    }

    private final List<Item> items = new ArrayList<>();

    public void addItem(String name, double price) {
        items.add(new Item(name, price));
    }

    public void removeItem(String name) {
        Iterator<Item> it = items.iterator();
        while (it.hasNext()) {
            if (it.next().name.equalsIgnoreCase(name)) {
                it.remove();
                return;
            }
        }
    }

    public int getItemCount() {
        return items.size();
    }

    public double calculateTotal() {
        double total = 0.0;
        for (Item item : items) {
            total += item.price;
        }
        return total;
    }
}

