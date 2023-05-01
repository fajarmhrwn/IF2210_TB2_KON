package com.kon.bnmo;

public class BillItem extends Item{
    private Integer amount;
    private String saleType;
    public BillItem(String name, Double price, Integer amount, String saleType) {
        super(name, price);
        this.amount = amount;
        this.saleType = saleType;
    }

    public BillItem(Item other, Integer amount, String saleType) {
        super(other);
        this.amount = amount;
        this.saleType = saleType;
        other.setAmount(other.getAmount() - amount);
    }

    public Integer getAmount() {
        return amount;
    }

    @Override
    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public String getSaleType() {
        return saleType;
    }

    public void setSaleType(String saleType) {
        this.saleType = saleType;
    }

    @Override
    public void addAmount(Integer amount) {
        this.amount += amount;
    }

    @Override
    public void decreaseAmount(Integer amount) {
        this.amount -= amount;
    }
}
