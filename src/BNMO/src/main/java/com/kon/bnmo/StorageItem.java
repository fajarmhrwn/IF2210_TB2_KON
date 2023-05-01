package com.kon.bnmo;

import java.util.Objects;

public class StorageItem extends Item {
    private Integer stock;

    public StorageItem(String name, Double price, Integer stock) {
        super(name, price);
        this.stock = stock;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    @Override
    public void setAmount(Integer amount) {
        this.stock = amount;
    }

    @Override
    public Integer getAmount() {
        return stock;
    }

    @Override
    public void addAmount(Integer amount) {
        this.stock += amount;
    }

    @Override
    public void decreaseAmount(Integer amount) {
        this.stock -= amount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        StorageItem that = (StorageItem) o;

        return Objects.equals(this.getName(), that.getName()) && Objects.equals(this.getPrice(), that.getPrice()) &&
                stock.equals(that.stock);
    }

    @Override
    public int hashCode() {
        return stock.hashCode();
    }
}
