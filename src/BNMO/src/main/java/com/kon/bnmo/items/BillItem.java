package com.kon.bnmo.items;

import java.util.Objects;

public class BillItem extends Item{
    private Integer amount;
    private double discount;
    public BillItem(String name, Double price, String category, String imgName, Integer amount, double discount) {
        super(name, price, category, imgName);
        this.amount = amount;
        this.discount = discount;
    }

    public BillItem(Item other, Integer amount, double discount) {
        super(other);
        this.amount = amount;
        this.discount = discount;
        other.setAmount(other.getAmount() - amount);
    }

    public Integer getAmount() {
        return amount;
    }

    @Override
    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    @Override
    public void addAmount(Integer amount) {
        this.amount += amount;
    }

    @Override
    public void decreaseAmount(Integer amount) {
        this.amount -= amount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BillItem billItem = (BillItem) o;
        return Objects.equals(this.getName(), billItem.getName()) &&
                Objects.equals(this.getCategory(), billItem.getCategory()) &&
                Objects.equals(this.getImgName(), billItem.getImgName()) &&
                this.getPrice() == billItem.getPrice() &&
                Objects.equals(amount, billItem.amount) && Objects.equals(discount, billItem.discount);
    }

}
