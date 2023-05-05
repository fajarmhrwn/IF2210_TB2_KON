package com.kon.bnmo.items;

import com.kon.bnmo.cashier.ItemContainer;
import com.kon.bnmo.holder.holder;

public class Bill extends holder<ItemContainer> {
    public Bill() {
        super("Item Container");
    }
    @Override
    public void add(ItemContainer item) {
        int index = this.itemList.indexOf(item);
        if (index == -1) {
            this.itemList.add(item);
        } else {
            this.itemList.get(index).setAmount(this.itemList.get(index).getAmount() + item.getAmount());
        }
    }
    @Override
    public void remove(ItemContainer item) {
        this.itemList.remove(item);
    }

}
