package Task1;

public class SpecialProduct extends Product {
    static int regularPrice;
    static int discountedPrice;

    static String name;
    static int price;

    @Override
    public String toString() {
        return String.format("Product name is " + name + " Product after discount is " + discountedPrice);
    }

    public SpecialProduct(String name, int price) {
        super(name, price);
    }

    public static SpecialProduct applyOffProduct(Product product, int percentageOff) {
        discountedPrice = (product.price - ((product.price * percentageOff) / 100));
        regularPrice = product.price;
        name = product.name;
        price = product.price;
        return new SpecialProduct(name, discountedPrice);
    }
}
