package com.kon.bnmo.items;

import com.kon.bnmo.holder.holder;

import java.util.ArrayList;
import java.util.List;

public class ItemHolder<T extends Item> extends holder<T> {
    public ItemHolder() {
        super("Item");
    }

    public ItemHolder(ItemHolder<T> other) {
        super("Item", other.getItemList());
    }
    @Override
    public void add(T item) {
        int index = this.itemList.indexOf(item);
        if (index == -1) {
            this.itemList.add(item);
        } else {
            this.itemList.get(index).setAmount(this.itemList.get(index).getAmount() + item.getAmount());
        }
    }
    @Override
    public void remove(T item) {
        this.itemList.remove(item);
    }

    public void setItemAmount(T item, Integer amount) {
        int index = this.itemList.indexOf(item);
        this.itemList.get(index).setAmount(amount);
    }

//    public static void main(String[] args) {
//        ItemHolder<BillItem> bill = new ItemHolder<BillItem>();
////        BillItem padangA = new BillItem("Nasi padang", 18000.0, 2, "Dine in");
////        BillItem padangB = new BillItem("Nasi padang", 18000.0, 2, "Dine in");
////        bill.add(padangA);
////        bill.remove(padangB);
//    }
}
