package com.kon.bnmo.cashier;

import com.kon.bnmo.items.BillItem;
import com.kon.bnmo.items.StorageItem;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;

import java.util.Objects;

public class ItemContainer extends HBox {
    private BillItem containedItem;
    private Button editButton;

    public ItemContainer(StorageItem item, Integer itemAmount, String saleType) {
        this.containedItem = new BillItem(item, itemAmount, saleType);

        Label itemName = new Label(item.getName());
        itemName.setWrapText(false);
        this.editButton = new Button("Edit");
        this.getChildren().addAll(itemName, this.editButton);
        this.setAlignment(Pos.CENTER_RIGHT);
        HBox.setHgrow(itemName, Priority.ALWAYS);

        this.getStyleClass().add("item-container");
    }

    public ItemContainer(BillItem item) {
        this.containedItem = item;

        Label itemName = new Label(item.getName());
        itemName.setWrapText(false);
        itemName.setMinWidth(300);
        itemName.setMaxWidth(Double.MAX_VALUE);
        this.editButton = new Button("Edit");
        this.getChildren().addAll(itemName, this.editButton);
        this.setAlignment(Pos.CENTER_RIGHT);
        HBox.setHgrow(itemName, Priority.ALWAYS);

        this.getStyleClass().add("item-container");
    }

    public BillItem getContainedItem() {
        return containedItem;
    }

    public void setContainedItem(BillItem containedItem) {
        this.containedItem = containedItem;
    }

    public Button getEditButton() {
        return editButton;
    }

    public void setEditButton(Button editButton) {
        this.editButton = editButton;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ItemContainer that = (ItemContainer) o;

        return Objects.equals(containedItem, that.containedItem);
    }

    @Override
    public int hashCode() {
        return containedItem != null ? containedItem.hashCode() : 0;
    }
}
