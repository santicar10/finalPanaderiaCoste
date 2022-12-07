package com.example.finalpanaderiacoste.model;

public class Product {

    private String name;
    private int amount;
    private double price;
    private String urlImage;
    private String id;

    public Product(String name, int amount, double price, String id,String urlImage) {
        this.name = name;
        this.amount = amount;
        this.price = price;
        this.id = id;
        this.urlImage = urlImage;
    }

    public Product() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUrlImage() {
        return urlImage;
    }

    public void setUrlImage(String urlImage) {
        this.urlImage = urlImage;
    }
}
