package com.kon.bnmo.cashier;

import com.kon.bnmo.items.Item;
import com.kon.bnmo.items.ItemHolder;
import com.kon.bnmo.sistembarang.SistemBarang;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;

import java.util.List;

public class CashierMainPanel extends VBox {
    private Catalogue catalogue;
    private Button restockButton;
    private Cashier parent;
    private ItemHolder availableItems;
    private SistemBarang sistemBarang;

    public CashierMainPanel(Cashier parent, ItemHolder availableItems) {
        this.parent = parent;
        this.catalogue = new Catalogue(this, availableItems);
        this.catalogue.getvBox().prefWidthProperty().bind(this.widthProperty());
        this.availableItems = availableItems;
        this.restockButton = new Button("Restock");
//        this.sistemBarang = new SistemBarang()
        this.restockButton.setOnAction(this::openSistemBarang);
        this.getChildren().addAll(this.catalogue, this.restockButton);
    }

    private void openSistemBarang(ActionEvent actionEvent) {

    }

    public Catalogue getCatalogue() {
        return catalogue;
    }

    public void setCatalogue(Catalogue catalogue) {
        this.catalogue = catalogue;
    }

    public Button getRestockButton() {
        return restockButton;
    }

    public void setRestockButton(Button restockButton) {
        this.restockButton = restockButton;
    }

    public Cashier getCashier() {
        return parent;
    }

    public void setCashier(Cashier parent) {
        this.parent = parent;
    }

    public ItemHolder getAvailableItems() {
        return availableItems;
    }

    public void setAvailableItems(ItemHolder availableItems) {
        this.availableItems = availableItems;
    }
}
