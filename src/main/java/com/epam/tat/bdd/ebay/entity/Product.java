package com.epam.tat.bdd.ebay.entity;

public class Product {
    private String name;
    private double price;
    private String id;

    public Product(String name, double price, String id) {
        this.name = name;
        this.price = price;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    public double getPrice() {
        return price;
    }
}
