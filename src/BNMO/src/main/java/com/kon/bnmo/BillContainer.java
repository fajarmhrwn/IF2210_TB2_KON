package com.kon.bnmo;

import javafx.scene.control.ScrollPane;
import javafx.scene.layout.VBox;

import java.util.List;

public class BillContainer extends ScrollPane {
    ItemHolder<BillItem> billItemItemHolder;
    List<ItemContainer> itemContainerList;

    public BillContainer(ItemHolder<BillItem> itemList) {
        this.billItemItemHolder = new ItemHolder<>(itemList);

        VBox content = new VBox();

        this.setContent(content);
    }

    public void addItem(StorageItem item, Integer amount, String saleType) {
        BillItem tempBill = new BillItem(item, amount, saleType);
        this.billItemItemHolder.add(tempBill);

        this.getChildren().add(new ItemContainer(item, amount, saleType));
    }

    public void removeItem(BillItem item) {
        this.billItemItemHolder.remove(item);
    }

}
