package Task1;

public class Product {
    String name;
    int price;

    //Parametrized constructor
    public Product(String name, int price) {
        this.name = name;
        this.price = price;
    }

    /*****
     TODO
     @Override public boolean equals(Product product){

     }
     ****/

    @Override
    public String toString() {
        return String.format("Product name is %s it's price is %d", name, price);
    }

    //Default constructor
    public Product() {

    }


}
