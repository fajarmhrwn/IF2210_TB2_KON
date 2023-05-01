package com.kon.bnmo;

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
        this.itemList.add(item);
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
}
