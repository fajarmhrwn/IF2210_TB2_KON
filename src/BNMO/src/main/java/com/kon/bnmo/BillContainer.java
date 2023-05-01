package com.kon.bnmo;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

public class BillContainer extends GridPane {
    ItemHolder<BillItem> billItemItemHolder;

    public BillContainer(ItemHolder<BillItem> itemList) {
        this.billItemItemHolder = new ItemHolder<>(itemList);
        Button editButton = new Button("Edit");
        for (int i = 0; i < this.billItemItemHolder.getItemList().size(); i++) {
            Label label = new Label(this.billItemItemHolder.getItemList().get(i).getName());
            this.add(label, 0, i);
            this.add(editButton, 1, i);
        }

    }

}
