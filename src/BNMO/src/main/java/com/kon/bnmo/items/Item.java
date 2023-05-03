package com.kon.bnmo.items;

public abstract class Item {
    private String name;
    private double price;
    private String category;
    private String imgName;

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

    public Item(String name, double price, String category, String imgName) {
        this.name = name;
        this.price = price;
        this.category = category;
        this.imgName = imgName;
    }

    public Item(Item other) {
        this.name = other.name;
        this.price = other.price;
        this.category = other.category;
        this.imgName = other.imgName;
    }

    public abstract void setAmount(Integer amount);

    public abstract Integer getAmount();

    public abstract void addAmount(Integer amount);

    public abstract void decreaseAmount(Integer amount);

    public static void main(String[] args) {
    }

}
