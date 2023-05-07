package com.kon.bnmo.items;

import com.kon.bnmo.holder.holder;

public class ItemHolder extends holder<Item> {
    public ItemHolder() {
        super("Item");
    }

    public ItemHolder(ItemHolder other) {
        super("Item", other.getList());
    }
    @Override
    public void add(Item item) {
        int index = this.list.indexOf(item);
        if (index == -1) {
            this.list.add(item);
        } else {
            this.list.get(index).setStock(this.list.get(index).getStock() + item.getStock());
        }
    }
    @Override
    public void remove(Item item) {
        this.list.remove(item);
    }

    public void setItemStock(Item item, Integer stock) {
        this.list.get(this.list.indexOf(item)).setStock(stock);
    }

}
