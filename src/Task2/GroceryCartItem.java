package Task2;

import java.util.Objects;

public class GroceryCartItem extends GroceryItem {
    float quantity;
    float price;

    public GroceryCartItem(String name, float pricePerKg) {
        super(name, pricePerKg);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof GroceryCartItem)) return false;
        GroceryCartItem that = (GroceryCartItem) o;
        return name.equals(that);
    }

    @Override
    public int hashCode() {
        return Objects.hash(price);
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
//        String[] splitted = quantityStr.split(" ", quantityStr.length());
//        String str = "";
//        String quantity = "";
//        for (String s : splitted) {
//            str += s;
//        }
//        str = str.replace("kg", " ").replace("g", "");
//        String[] quans = str.split(" ", str.length());
//        quantity += quans[0] + "." + quans[1];
//        Float quantityFloat = Float.parseFloat(quantity);
        String s = quantityStr.replace("kg ", ".")
                .replace("kg", ".")
                .replace("g", "");
        int index = s.indexOf(".");
        if (index == -1 && s.length()<3) {
            s = ".0" + s;
//            System.out.println(s);
        }
//        System.out.println(Float.parseFloat(s));
        return Float.parseFloat(s);
    }
}
