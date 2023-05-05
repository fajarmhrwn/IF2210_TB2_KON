package com.kon.bnmo.items;

import com.kon.bnmo.holder.holder;


public class ItemHolder extends holder<Item> {
    public ItemHolder() {
        super("Item");
    }

    public ItemHolder(ItemHolder other) {
        super("Item", other.getItemList());
    }
    @Override
    public void add(Item item) {
        int index = this.itemList.indexOf(item);
        if (index == -1) {
            this.itemList.add(item);
        } else {
            this.itemList.get(index).setStock(this.itemList.get(index).getStock() + item.getStock());
        }
    }
    @Override
    public void remove(Item item) {
        this.itemList.remove(item);
    }

//    public static void main(String[] args) {
//        ItemHolder<BillItem> bill = new ItemHolder<BillItem>();
////        BillItem padangA = new BillItem("Nasi padang", 18000.0, 2, "Dine in");
////        BillItem padangB = new BillItem("Nasi padang", 18000.0, 2, "Dine in");
////        bill.add(padangA);
////        bill.remove(padangB);
//    }
}
