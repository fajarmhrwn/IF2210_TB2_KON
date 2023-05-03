package com.kon.bnmo.items;

import java.util.ArrayList;
import java.util.List;

public class ItemHolder<T extends Item> {
    private List<T> itemList;

    public ItemHolder() {
        this.itemList = new ArrayList<T>();
    }

    public ItemHolder(ItemHolder<T> other) {
        this.itemList = new ArrayList<T>();
        this.itemList.addAll(other.getItemList());
    }

    public void add(T item) {
        int index = this.itemList.indexOf(item);
        if (index == -1) {
            this.itemList.add(item);
        } else {
            this.itemList.get(index).setAmount(this.itemList.get(index).getAmount() + item.getAmount());
        }
    }

    public void remove(T item) {
        this.itemList.remove(item);
    }

    public void setItemAmount(T item, Integer amount) {
        int index = this.itemList.indexOf(item);
        this.itemList.get(index).setAmount(amount);
    }

    public List<T> getItemList() {
        return itemList;
    }


    public void setItemList(List<T> itemList) {
        this.itemList = itemList;
    }

    public static void main(String[] args) {
        ItemHolder<BillItem> bill = new ItemHolder<BillItem>();
        BillItem padangA = new BillItem("Nasi padang", 18000.0, 2, "Dine in");
        BillItem padangB = new BillItem("Nasi padang", 18000.0, 2, "Dine in");
        bill.add(padangA);
        bill.remove(padangB);
    }
}
