package com.kon.bnmo;

public abstract class Item {
    private String name;
    private double price;

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


    public Item(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public Item(Item other) {
        this.name = other.name;
        this.price = other.price;
    }

    public abstract void setAmount(Integer amount);

    public abstract Integer getAmount();

    public abstract void addAmount(Integer amount);

    public abstract void decreaseAmount(Integer amount);


}
