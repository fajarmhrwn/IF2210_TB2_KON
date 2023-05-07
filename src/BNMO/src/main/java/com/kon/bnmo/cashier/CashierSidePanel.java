package com.kon.bnmo.cashier;

import com.kon.bnmo.Checkout;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class CashierSidePanel extends VBox {
    private Button addCustomer;
    private BillContainer bc;
    private Button checkout;
    private HBox priceContainer;
    private Label totalPrice;
    private Cashier parent;
    private Double priceTotal;
    private Checkout checkoutPage;
    public CashierSidePanel(Cashier parent) {
        this.priceTotal = 0.0;
        this.parent = parent;
        this.addCustomer = new Button("+ Add Customer");

        this.bc = new BillContainer(this);

        this.checkout = new Button ("Checkout");

        this.priceContainer = new HBox();
        Label priceLabel = new Label("Total: ");
        this.totalPrice = new Label("0");
        this.priceContainer.getChildren().addAll(
                priceLabel,
                this.totalPrice
        );
        this.checkoutPage = new Checkout(this);
        this.checkout.setOnAction(this::openCheckout);

        this.getChildren().addAll(this.addCustomer, this.bc, this.checkout, this.priceContainer);

    }

    private void openCheckout(ActionEvent actionEvent) {
        this.checkoutPage.updatePrice();
        this.checkoutPage.updateTable();
        this.checkoutPage.show();
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

    public Button getCheckout() {
        return this.checkout;
    }

    public void setCheckout(Button checkout) {
        this.checkout = checkout;
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
        this.priceTotal = 0.0;
        for (ItemContainer bi: this.bc.getBillHolder().getList()) {
            // If else to know whether the use points checkbox is checked
            this.priceTotal += bi.getBuyingPrice() * bi.getAmount();
        }
        this.setTotalPrice(this.priceTotal);
    }

    public void setPriceLabel(Label priceLabel) {
        this.totalPrice = priceLabel;
    }

    public void setTotalPrice(Label totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Double getPriceTotal() {
        return priceTotal;
    }

    public void setPriceTotal(Double priceTotal) {
        this.priceTotal = priceTotal;
    }

    public Checkout getCheckoutPage() {
        return checkoutPage;
    }

    public void setCheckoutPage(Checkout checkoutPage) {
        this.checkoutPage = checkoutPage;
    }
}
