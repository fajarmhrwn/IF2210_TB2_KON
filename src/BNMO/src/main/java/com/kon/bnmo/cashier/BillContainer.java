package com.kon.bnmo.cashier;

import com.kon.bnmo.items.BillItem;
import com.kon.bnmo.items.ItemHolder;
import com.kon.bnmo.items.StorageItem;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.VBox;

public class BillContainer extends ScrollPane {
    private ItemHolder<BillItem> billItemItemHolder;
    private final VBox content;

    public BillContainer() {
        this.billItemItemHolder = new ItemHolder<>();
        this.content = new VBox();
        this.setContent(this.content);
    }

    public void addItem(BillItem item) {
        this.billItemItemHolder.add(item);
        this.content.getChildren().add(new ItemContainer(item));
        this.setContent(this.content);
    }

    public void removeItem(StorageItem item, Integer amount, String saleType) {
        this.billItemItemHolder.remove(new BillItem(item, amount, saleType));
        this.content.getChildren().remove(new ItemContainer(item, amount, saleType));
        this.setContent(this.content);
    }

    public ItemHolder<BillItem> getBillItemItemHolder() {
        return billItemItemHolder;
    }

    public void setBillItemItemHolder(ItemHolder<BillItem> billItemItemHolder) {
        this.billItemItemHolder = billItemItemHolder;
    }
}
