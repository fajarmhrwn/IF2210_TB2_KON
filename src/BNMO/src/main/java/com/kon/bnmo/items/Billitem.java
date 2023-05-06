package com.kon.bnmo.items;

public class Billitem extends Item{
    private int amount;
    public Billitem(String name, double price, String category, String imgName, Integer stock, Integer amount) {
        super(name, price, category, imgName, stock);
        this.amount = amount;
    }

    public Billitem(Billitem other) {
        this.name = other.name;
        this.price = other.price;
        this.category = other.category;
        this.imgName = other.imgName;
        this.stock = other.stock;
        this.amount = other.amount;
    }

    public  Billitem(){
        this.name = "";
        this.price = 0;
        this.category = "";
        this.imgName = "";
        this.stock = 0;
    }

    public Billitem(String name, double price, int quantity) {
        this.name = name;
        this.price = price;
        this.amount = quantity;
    }

    public int getAmount() {
        return amount;
    }

    public  void setAmount(int amount){
        this.amount = amount;
    }
}
