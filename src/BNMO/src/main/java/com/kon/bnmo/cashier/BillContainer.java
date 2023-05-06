package com.kon.bnmo.cashier;

import com.kon.bnmo.items.Bill;
import com.kon.bnmo.items.Item;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.VBox;

public class BillContainer extends ScrollPane {
    private Bill billHolder;
    private final VBox vBox;
    private CashierSidePanel sidePanel;

    public BillContainer(CashierSidePanel sidePanel) {
        this.billHolder = new Bill();
        this.sidePanel = sidePanel;
        this.vBox = new VBox();
        this.setContent(this.vBox);
    }

    public void addItem(ItemContainer item) {
        this.billHolder.add(item);
        this.vBox.getChildren().add(new ItemContainer(item.getContainedItem(), this));
        this.setContent(this.vBox);
    }

    public void removeItem(String name, double price, String category, String imgName, Integer stock,
                           Integer amount, Double sellingPrice) {
        this.billHolder.remove(new ItemContainer(name, price, category, imgName, stock, this, amount, sellingPrice));
        this.vBox.getChildren().remove(new ItemContainer(name, price, category, imgName, stock, this, amount,
                sellingPrice));
        this.setContent(this.vBox);
    }

    public void updateAmount(ItemContainer itemContainer, Integer amount) {
        int index = this.billHolder.getItemList().indexOf(itemContainer);
        this.billHolder.getItemList().get(index).setAmount(amount);
    }

    public CashierSidePanel getSidePanel() {
        return sidePanel;
    }

    public VBox getvBox() {
        return this.vBox;
    }
    public void setSidePanel(CashierSidePanel sidePanel) {
        this.sidePanel = sidePanel;
    }

    public Bill getBillHolder() {
        return billHolder;
    }

    public void setBillHolder(Bill billHolder) {
        this.billHolder = billHolder;
    }
}
