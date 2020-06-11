package com.codegym.model;

public class CartItem {
    private Product product;
    private int quantity;
    private int amount;

    public CartItem() {
    }

    public CartItem(Product product, int quantity, int amount) {
        this.product = product;
        this.quantity = quantity;
        this.amount = amount;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
