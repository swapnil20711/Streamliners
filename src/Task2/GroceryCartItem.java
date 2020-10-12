package Task2;

public class GroceryCartItem extends GroceryItem {
    float quantity;
    float price;

    public GroceryCartItem(String name, float pricePerKg) {
        super(name, pricePerKg);
    }

    /******
     @Override public String toString() {
     return "GroceryCartItem{" +
     "name='" + name + '\'' +
     ", pricePerKg" + " * "
     + "quantity" + "=" + pricePerKg * quantity +
     '}';
     }
     ******/


    public static GroceryCartItem createNew(GroceryItem item, String quantityStr) {
        GroceryCartItem groceryCartItem = new GroceryCartItem(item.name, item.pricePerKg);
        groceryCartItem.quantity = extractQuantity(quantityStr);
        groceryCartItem.price = ((groceryCartItem.quantity) * (item.pricePerKg));
        return groceryCartItem;

    }

    public static Float extractQuantity(String quantityStr) {
        String[] splitted = quantityStr.split(" ", quantityStr.length());
        String str = "";
        String quantity = "";
        for (String s : splitted) {
            str += s;
        }
        str = str.replace("kg", " ").replace("g", "");
        String[] quans = str.split(" ", str.length());
        quantity += quans[0] + "." + quans[1];
        Float quantityFloat = Float.parseFloat(quantity);
        return quantityFloat;
    }
}
