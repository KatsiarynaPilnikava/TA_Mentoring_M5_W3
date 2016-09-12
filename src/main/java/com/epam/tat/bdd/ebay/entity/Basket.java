package com.epam.tat.bdd.ebay.entity;

import java.util.ArrayList;
import java.util.List;

public class Basket {
    private List<Product> productList;
    private double totalPrice;

    public Basket() {
        productList = new ArrayList<Product>();
        totalPrice = 0;
    }

    public Basket (List<Product> productList) {
        this.productList = productList;
        totalPrice = 0;
        for (Product product:productList) {
            totalPrice += product.getPrice();
        }
    }

    public List<Product> getProductList() {
        return productList;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void addProduct(Product product) {
        productList.add(product);
        totalPrice+=product.getPrice();
    }
}
