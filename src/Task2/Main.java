package Task2;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        GroceryItem sugar = new GroceryItem("Sugar", 35);
        GroceryItem jaggery = new GroceryItem("Jaggery", 40);
        GroceryItem Apple = new GroceryItem("Apple", 100);
        GroceryItem Mango = new GroceryItem("Mango", 60);
        Cart cart = new Cart();
        cart.add(GroceryCartItem.createNew(sugar, "3g"))
                .add(GroceryCartItem.createNew(jaggery, "5kg"))
                .add(GroceryCartItem.createNew(Apple, "1kg 500g"))
                .add(GroceryCartItem.createNew(Mango, "3kg 500g"));
        System.out.println(cart);
    }
}
