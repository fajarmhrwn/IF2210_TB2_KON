package com.kon.bnmo.cashier;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class CashierSidePanel extends VBox {
    private Button addCustomer;
    private BillContainer bc;
    private HBox buttonContainer;
    private Label priceLabel;
    public CashierSidePanel() {
        this.addCustomer = new Button("+ Add Customer");

        this.bc = new BillContainer();

        this.buttonContainer = new HBox();
        Button checkout = new Button ("Checkout");
        Button addItem = new Button ("+ Add Item");
        this.buttonContainer.getChildren().addAll(addItem, checkout);

        this.priceLabel = new Label("Total: ");

        this.getChildren().addAll(this.addCustomer, this.bc, this.buttonContainer, this.priceLabel);
    }

    public Button getAddCustomer() {
        return addCustomer;
    }

    public void setAddCustomer(Button addCustomer) {
        this.addCustomer = addCustomer;
    }

    public BillContainer getBc() {
        return bc;
    }

    public void setBc(BillContainer bc) {
        this.bc = bc;
    }

    public HBox getButtonContainer() {
        return buttonContainer;
    }

    public void setButtonContainer(HBox buttonContainer) {
        this.buttonContainer = buttonContainer;
    }

    public Label getPriceLabel() {
        return priceLabel;
    }

    public void setPriceLabel(Label priceLabel) {
        this.priceLabel = priceLabel;
    }
}
