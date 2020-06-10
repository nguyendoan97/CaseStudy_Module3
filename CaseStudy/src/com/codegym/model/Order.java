package com.codegym.model;

public class Order {
    int id;
    String name_customer,address,number_phone,name_product;
    int quantity,prince,amount;

    public Order() {
    }

    public Order(int id, String name_customer, String address, String number_phone, String name_product, int quantity, int prince, int amount) {
        this.id = id;
        this.name_customer = name_customer;
        this.address = address;
        this.number_phone = number_phone;
        this.name_product = name_product;
        this.quantity = quantity;
        this.prince = prince;
        this.amount = amount;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName_customer() {
        return name_customer;
    }

    public void setName_customer(String name_customer) {
        this.name_customer = name_customer;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getNumber_phone() {
        return number_phone;
    }

    public void setNumber_phone(String number_phone) {
        this.number_phone = number_phone;
    }

    public String getName_product() {
        return name_product;
    }

    public void setName_product(String name_product) {
        this.name_product = name_product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getPrince() {
        return prince;
    }

    public void setPrince(int prince) {
        this.prince = prince;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
