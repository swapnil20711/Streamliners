package Task1;

public class Main {

    public static void main(String[] args) {
        Product orange = new Product("ORANGE", 100);
        Product orange1 = new Product("ORANGE", 100);
        Product apple = new Product("APPLE", 150);
        System.out.println(orange);
        System.out.println(orange1);
        System.out.println(orange.equals(orange1));
        SpecialProduct specialProduct = SpecialProduct.applyOffProduct(apple, 25);
        System.out.println(specialProduct);
    }

}
