package com.kon.bnmo.items;

import java.io.Serializable;

public class Item implements Serializable {
    protected static final long serialVersionUID = 1L;
    public boolean equalsOtherThanPrice(Item item) {
        if (!name.equals(item.name)) return false;
        if (!category.equals(item.category)) return false;
        if (!imgName.equals(item.imgName)) return false;
        return stock.equals(item.stock);
    }
    protected String name;
    protected double price;
    protected String category;
    protected String imgName;
    protected Integer stock;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Item item = (Item) o;

        if (Double.compare(item.price, price) != 0) return false;
        if (!name.equals(item.name)) return false;
        if (!category.equals(item.category)) return false;
        if (!imgName.equals(item.imgName)) return false;
        return stock.equals(item.stock);
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = name.hashCode();
        temp = Double.doubleToLongBits(price);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + category.hashCode();
        result = 31 * result + imgName.hashCode();
        result = 31 * result + stock.hashCode();
        return result;
    }
}
