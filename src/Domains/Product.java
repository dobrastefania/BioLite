package Domains;

public class Product {
    private int id;
    private String name;
    private float price;
    private ProductType type;
    private int stoc;

    public Product(int id, String name, float price, ProductType type) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public ProductType getType() {
        return type;
    }

    public void setType(ProductType type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return id + '\t' + name + '\t' + price + '\t' + type + '\t' + stoc;
    }
}
