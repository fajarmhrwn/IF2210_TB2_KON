package com.kon.bnmo.cashier;

import com.kon.bnmo.items.ItemHolder;
import com.kon.bnmo.sistembarang.SistemBarang;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.Tab;
import javafx.scene.layout.VBox;

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
        this.sistemBarang = new SistemBarang(availableItems);
        this.restockButton.setOnAction(this::openSistemBarang);
        this.getChildren().addAll(this.catalogue, this.restockButton);
    }

    private void openSistemBarang(ActionEvent actionEvent) {
        Tab existingTab = null;

        for (Tab tab:
             this.parent.getTabPane().getTabs()) {
            if (tab.getText().equals(this.sistemBarang.getText())) {
                existingTab = tab;
                break;
            }
        }

        if (existingTab != null) {
            this.parent.getTabPane().getSelectionModel().select(existingTab);
        } else {
            this.parent.getTabPane().getTabs().add(this.sistemBarang);
            this.parent.getTabPane().getSelectionModel().select(this.sistemBarang);
        }

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

    public SistemBarang getSistemBarang() {
        return sistemBarang;
    }

    public void setSistemBarang(SistemBarang sistemBarang) {
        this.sistemBarang = sistemBarang;
    }
}
