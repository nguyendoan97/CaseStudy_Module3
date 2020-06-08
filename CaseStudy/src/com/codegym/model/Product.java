package com.codegym.model;

public class Product {
    protected int id;
    protected String name;
    protected String image;
    protected int prince;
    protected String classify;

    public Product() {}

    public Product(String name, String image,int prince, String classify) {
        super();
        this.name = name;
        this.image = image;
        this.prince = prince;
        this.classify = classify;
    }

    public Product(int id,String name, String image,int prince, String classify) {
        this.id = id;
        this.name = name;
        this.image = image;
        this.prince = prince;
        this.classify = classify;
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
    public String getImage() {
        return image;
    }
    public void setImage(String image) {
        this.image = image;
    }

    public int getPrince() {
        return prince;
    }

    public void setPrince(int prince) {
        this.prince = prince;
    }

    public String getClassify() {
        return classify;
    }
    public void setClassify(String classify) {
        this.classify = classify;
    }
}
