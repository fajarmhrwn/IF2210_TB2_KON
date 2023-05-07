package com.kon.bnmo.items;

import com.kon.bnmo.cashier.ItemContainer;
import com.kon.bnmo.holder.holder;

public class Bill extends holder<ItemContainer> {
    public Bill() {
        super("Item Container");
    }
    @Override
    public void add(ItemContainer item) {
        int index = this.list.indexOf(item);
        if (index == -1) {
            this.list.add(item);
        } else {
            this.list.get(index).setAmount(this.list.get(index).getAmount() + item.getAmount());
        }
    }
    @Override
    public void remove(ItemContainer item) {
        this.list.remove(item);
    }

    public void changeBuyingPrice(ItemContainer item, Double buyingPrice) {
        int index = this.list.indexOf(item);
        this.list.get(index).setBuyingPrice(buyingPrice);
    }

    public Double getBuyingPrice(ItemContainer item) {
        int index = this.list.indexOf(item);
        return this.list.get(index).getBuyingPrice();
    }

}
