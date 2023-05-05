package com.kon.bnmo.items;

import java.io.Serializable;

public class Item implements Serializable {
    private static final long serialVersionUID = 1L;
    private String name;
    private double price;
    private String category;
    private String imgName;
    private Integer stock;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getImgName() {
        return imgName;
    }

    public void setImgName(String imgName) {
        this.imgName = imgName;
    }

    public Item(String name, double price, String category, String imgName, Integer stock) {
        this.name = name;
        this.price = price;
        this.category = category;
        this.imgName = imgName;
        this.stock = stock;
    }

    public Item(Item other) {
        this.name = other.name;
        this.price = other.price;
        this.category = other.category;
        this.imgName = other.imgName;
        this.stock = other.stock;
    }

    public  Item(){
        this.name = "";
        this.price = 0;
        this.category = "";
        this.imgName = "";
        this.stock = 0;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public static void main(String[] args) {
    }

}
