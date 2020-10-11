package Task1;

public class SpecialProduct extends Product {

    int percentageOff, regularPrice;

    @Override
    public String toString() {
        return "SpecialProduct{" +
                "percentageOff=" + percentageOff +
                ", regularPrice=" + regularPrice +
                ", name='" + name + '\'' +
                ", DiscountedPrice=" + price +
                '}';
    }

    public SpecialProduct(String name, int price) {
        super(name, price);
    }

    public static SpecialProduct applyOffProduct(Product product, int percentageOff) {
        int discountedPrice;
        discountedPrice = (product.price - ((product.price * percentageOff) / 100));
        SpecialProduct specialProduct = new SpecialProduct(product.name, discountedPrice);
        specialProduct.regularPrice = product.price;
        specialProduct.percentageOff = percentageOff;
        return specialProduct;
    }
}
