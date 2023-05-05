package com.kon.bnmo.cashier;

import com.kon.bnmo.items.Item;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class CashierSidePanel extends VBox {
    private Button addCustomer;
    private BillContainer bc;
    private HBox buttonContainer;
    private HBox priceContainer;
    private Label totalPrice;
    private Cashier parent;
    public CashierSidePanel(Cashier parent) {
        this.parent = parent;
        this.addCustomer = new Button("+ Add Customer");

        this.bc = new BillContainer(this);

        this.buttonContainer = new HBox();
        Button checkout = new Button ("Checkout");
        Button addItem = new Button ("+ Add Item");
        addItem.setOnAction(event -> {

        });
        this.buttonContainer.getChildren().addAll(addItem, checkout);

        this.priceContainer = new HBox();
        Label priceLabel = new Label("Total: ");
        this.totalPrice = new Label("0");
        this.priceContainer.getChildren().addAll(
                priceLabel,
                this.totalPrice
        );

        this.getChildren().addAll(this.addCustomer, this.bc, this.buttonContainer, this.priceContainer);
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
        return this.totalPrice;
    }

    public HBox getPriceContainer() {
        return priceContainer;
    }

    public Cashier getThisParent() {
        return parent;
    }

    public void setParent(Cashier parent) {
        this.parent = parent;
    }

    public void setPriceContainer(HBox priceContainer) {
        this.priceContainer = priceContainer;
    }

    public Label getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Double newPrice) {
        this.priceContainer.getChildren().remove(this.totalPrice);
        this.totalPrice.setText("Rp." + String.format("%.2f", newPrice));
        this.priceContainer.getChildren().add(totalPrice);
    }

    public void setPrice() {
        double tempTotal = 0.0;
        for (Node bi: this.bc.getvBox().getChildren()) {
            if (bi instanceof ItemContainer) {
                // If else to know whether the use points checkbox is checked
                tempTotal += ((ItemContainer) bi).getBuyingPrice();
            }
        }
        this.setTotalPrice(tempTotal);
    }

    public void setPriceLabel(Label priceLabel) {
        this.totalPrice = priceLabel;
    }
}
