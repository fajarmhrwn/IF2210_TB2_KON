package com.kon.bnmo.items;

import com.kon.bnmo.cashier.CatalogueContainer;
import com.kon.bnmo.holder.holder;

public class Storage extends holder<CatalogueContainer> {
    public Storage() {
        super("Catalogue Container");
    }

    @Override
    public void add(CatalogueContainer item) {
        int index = this.list.indexOf(item);
        if (index == -1) {
            this.list.add(item);
        } else {
            this.list.get(index).getContainedItem().setStock(
                    this.list.get(index).getContainedItem().getStock() +
                            item.getContainedItem().getStock());
        }
    }
    @Override
    public void remove(CatalogueContainer item) {
        this.list.remove(item);
    }


}
