package com.kon.bnmo.cashier;

import com.kon.bnmo.items.Bill;
import com.kon.bnmo.items.Item;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.VBox;

public class BillContainer extends ScrollPane {
    private Bill billHolder;
    private VBox vBox;
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

    public void updateBillContainer(Item itemToUpdate, Integer amount) {
        VBox newBox = new VBox();
        for (ItemContainer item: this.billHolder.getList()) {
            if (item.getContainedItem().equals(itemToUpdate)) {
                item.getContainedItem().setStock(amount);
                Integer changeAmount;
                if (item.getAmount() > amount) {
                    changeAmount = amount;
                } else {
                    changeAmount = item.getAmount();
                }
                item.setAmount(changeAmount);
                item.setEditItem(new EditItemPopup(item.getContainedItem(), item, changeAmount));
                newBox.getChildren().add(item);
            } else {
                newBox.getChildren().add(new ItemContainer(item.getContainedItem(), this));
            }
        }
        this.setContent(newBox);
        this.vBox = newBox;
        this.getSidePanel().setPrice();
    }

    public void updateAll() {
        VBox newBox = new VBox();
        for (ItemContainer item: this.billHolder.getList()) {
            for (Item i: this.sidePanel.getThisParent().getAvailableItems().getList()) {
                if (item.getContainedItem().equalsOtherThanPrice(i)) {
                    newBox.getChildren().add(new ItemContainer(item.getContainedItem(), this));
                }
            }
        }
        this.setContent(newBox);
        this.vBox = newBox;
        this.getSidePanel().setPrice();
    }

    public void removeItem(String name, double price, String category, String imgName, Integer stock,
                           Integer amount, Double sellingPrice) {
        this.billHolder.remove(new ItemContainer(name, price, category, imgName, stock, this, amount, sellingPrice));
        this.vBox.getChildren().remove(new ItemContainer(name, price, category, imgName, stock, this, amount,
                sellingPrice));
        this.setContent(this.vBox);
    }

    public void updateAmount(ItemContainer itemContainer, Integer amount) {
        int index = this.billHolder.getList().indexOf(itemContainer);
        this.billHolder.getList().get(index).setAmount(amount);
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
