package Task1;

public class Product {
    String name;
    int price;

    //Parametrized constructor
    public Product(String name, int price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return price == product.price &&
                name.equals(product.name);
    }

    @Override
    public String toString() {
        return String.format("Product name is %s it's price is %d", name, price);
    }

    //Default constructor
    public Product() {

    }


}
