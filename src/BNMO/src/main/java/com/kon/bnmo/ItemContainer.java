package com.kon.bnmo;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class ItemContainer extends HBox {
    private BillItem containedItem;

    public ItemContainer(StorageItem item, Integer itemAmount, String saleType) {
        this.containedItem = new BillItem(item, itemAmount, saleType);

        Label itemName = new Label(item.getName());
        itemName.setWrapText(false);
        itemName.setMinWidth(250);
        Button editButton = new Button("Edit");
        this.getChildren().addAll(itemName, editButton);
        this.setAlignment(Pos.CENTER_LEFT);
        HBox.setHgrow(itemName, Priority.ALWAYS);
        HBox.setMargin(editButton, new Insets(0, 0, 0, 10));
    }

    public BillItem getContainedItem() {
        return containedItem;
    }

    public void setContainedItem(BillItem containedItem) {
        this.containedItem = containedItem;
    }
}
