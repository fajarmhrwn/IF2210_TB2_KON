package com.kon.bnmo.cashier;

import com.kon.bnmo.items.Item;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;

import java.util.Objects;

public class ItemContainer extends HBox {
    private Item containedItem;
    private Button editButton;
    private BillContainer billContainer;
    private Integer amount;
    private Double buyingPrice;

    private EditItemPopup editItem;

    public ItemContainer(String name, double price, String category, String imgName, Integer stock,
                         BillContainer billContainer, Integer amount, Double buyingPrice) {
        this.containedItem = new Item(name, price, category, imgName, stock);
        this.billContainer = billContainer;
        this.amount = amount;
        this.buyingPrice = buyingPrice;

        Label itemName = new Label(name);
        itemName.setWrapText(false);
        this.editButton = new Button("Edit");
        this.getChildren().addAll(itemName, this.editButton);
        this.editButton.setOnAction(this::showEditPopup);
        this.editItem = new EditItemPopup(this.containedItem, this, 1);
        this.setAlignment(Pos.CENTER_RIGHT);
        HBox.setHgrow(itemName, Priority.ALWAYS);

        this.getStyleClass().add("item-container");
    }

    public ItemContainer(String name, double price, String category, String imgName, Integer stock,
                         Integer amount, Double buyingPrice) {
        this.containedItem = new Item(name, price, category, imgName, stock);
        this.billContainer = null;
        this.amount = amount;
        this.buyingPrice = buyingPrice;

        Label itemName = new Label(name);
        itemName.setWrapText(false);
        this.editButton = new Button("Edit");
        this.getChildren().addAll(itemName, this.editButton);
        this.editButton.setOnAction(this::showEditPopup);
        this.editItem = new EditItemPopup(this.containedItem, this, 1);
        this.setAlignment(Pos.CENTER_RIGHT);
        HBox.setHgrow(itemName, Priority.ALWAYS);

        this.getStyleClass().add("item-container");
    }

    private void showEditPopup(ActionEvent actionEvent) {
        this.editItem.show();
    }


    public ItemContainer(Item itemContainer, BillContainer billContainer) {
        this.containedItem = itemContainer;
        this.billContainer = billContainer;
        this.amount = 1;
        this.buyingPrice = itemContainer.getPrice();

        // Set the background color and border
//        this.setStyle("-fx-background-color: #ffffff; -fx-border-color: #cccccc; -fx-border-width: 1px;");
//
//        // Set padding and spacing
//        this.setPadding(new Insets(10));
//        this.setSpacing(10);

        Label itemName = new Label(itemContainer.getName());
//        itemName.setStyle("-fx-font-size: 16px; -fx-text-fill: #333333;");
        itemName.setWrapText(false);
        itemName.setMinWidth(300);
        itemName.setMaxWidth(Double.MAX_VALUE);
        this.editButton = new Button("Edit");
        this.editButton.setOnAction(this::showEditPopup);
        // Set the font and text color of the Edit Button
//        this.editButton.setStyle("-fx-font-size: 12px; -fx-text-fill: #ffffff; -fx-background-color: #0077cc;");
        this.editItem = new EditItemPopup(this.containedItem, this, 1);
        this.getChildren().addAll(itemName, this.editButton);
        this.setAlignment(Pos.CENTER_RIGHT);
        HBox.setHgrow(itemName, Priority.ALWAYS);

        this.getStyleClass().add("item-container");
    }

    public BillContainer getBillContainer() {
        return billContainer;
    }

    public void setBillContainer(BillContainer billContainer) {
        this.billContainer = billContainer;
    }

    public EditItemPopup getEditItem() {
        return editItem;
    }

    public void setEditItem(EditItemPopup editItem) {
        this.editItem = editItem;
    }

    public Item getContainedItem() {
        return containedItem;
    }

    public void setContainedItem(Item containedItem) {
        this.containedItem = containedItem;
    }

    public Button getEditButton() {
        return editButton;
    }

    public void setEditButton(Button editButton) {
        this.editButton = editButton;
    }

    public void delete() {
        this.billContainer.removeItem(
                containedItem.getName(),
                containedItem.getPrice(),
                containedItem.getCategory(),
                containedItem.getImgName(),
                containedItem.getStock(),
                this.getAmount(),
                this.getBuyingPrice()
        );
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Double getBuyingPrice() {
        return buyingPrice;
    }

    public void setBuyingPrice(Double buyingPrice) {
        this.buyingPrice = buyingPrice;
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
