package model;

public class Product {
    int id,price,quantity;
    String name,color,category;

    public Product() {
    }
    public Product( String name, int price, int quantity, String color,String category) {
        this.price = price;
        this.quantity = quantity;
        this.name = name;
        this.color = color;
        this.category = category;
    }
    public Product(int id, String name, int price, int quantity, String color,String category) {
        this.id = id;
        this.price = price;
        this.quantity = quantity;
        this.name = name;
        this.color = color;
        this.category = category;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
