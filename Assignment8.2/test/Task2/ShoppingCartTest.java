package Task2;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ShoppingCartTest {

    @Test
    void testAddItem() {
        ShoppingCart cart = new ShoppingCart();
        cart.addItem("Apple", 1.0);
        cart.addItem("Banana", 0.5);
        assertEquals(2, cart.getItemCount());
    }

    @Test
    void testRemoveItem() {
        ShoppingCart cart = new ShoppingCart();
        cart.addItem("Apple", 1.0);
        cart.addItem("Banana", 0.5);
        cart.removeItem("Apple");
        assertEquals(1, cart.getItemCount());
    }

    @Test
    void testCalculateTotal() {
        ShoppingCart cart = new ShoppingCart();
        cart.addItem("Apple", 1.0);
        cart.addItem("Banana", 0.5);
        cart.addItem("Orange", 0.75);
        assertEquals(2.25, cart.calculateTotal(), 0.01);
    }

    @Test
    void testEmptyCart() {
        ShoppingCart cart = new ShoppingCart();
        assertEquals(0, cart.getItemCount());
        assertEquals(0.0, cart.calculateTotal(), 0.01);
    }
}
