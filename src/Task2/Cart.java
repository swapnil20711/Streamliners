package Task2;

import java.util.ArrayList;

public class Cart {
    ArrayList<GroceryCartItem> cartItems = new ArrayList<>();
    float totalAmount = 0;
    StringBuilder builder = new StringBuilder();

    public Cart(ArrayList<GroceryCartItem> cartItems, float totalAmount) {
        this.cartItems = cartItems;
        this.totalAmount = totalAmount;
    }

    public Cart add(GroceryCartItem item) {
        builder.append("\n" + "\t" + item.name + " (" + "₹" + item.pricePerKg + " × " + item.quantity + "kg" + ") =" + " ₹" + item.price + "," + " \n");
        cartItems.add(item);
        totalAmount += item.quantity * item.pricePerKg;
        return this;
    }

    @Override
    public String toString() {
        return "Cart{" + "\n" +
                "groceryCartItems= [" + builder.toString() + " ]" +
                ",\n" + "totalAmount=" + totalAmount + "\n" +
                '}';
    }
}
