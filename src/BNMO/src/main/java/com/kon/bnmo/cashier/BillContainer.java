package com.kon.bnmo.cashier;

import com.kon.bnmo.items.Item;
import com.kon.bnmo.items.ItemHolder;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.VBox;
import java.util.*;

public class BillContainer extends ScrollPane {
    private ItemHolder billItemItemHolder;
    private final VBox vBox;
    private CashierSidePanel sidePanel;

    public BillContainer(CashierSidePanel sidePanel) {
        this.billItemItemHolder = new ItemHolder();
        this.sidePanel = sidePanel;
        this.vBox = new VBox();
        this.setContent(this.vBox);
    }

    public void addItem(Item item) {
        this.billItemItemHolder.add(item);
        this.vBox.getChildren().add(new ItemContainer(item, this));
        this.setContent(this.vBox);
    }

    public void removeItem(String name, double price, String category, String imgName, Integer stock,
                           Integer amount, Double sellingPrice) {
        this.billItemItemHolder.remove(new Item(name, price, category, imgName, stock));
        this.vBox.getChildren().remove(new ItemContainer(name, price, category, imgName, stock, this, amount, sellingPrice));
        this.setContent(this.vBox);
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

    public ItemHolder getBillItemItemHolder() {
        return billItemItemHolder;
    }

    public void setBillItemItemHolder(ItemHolder billItemItemHolder) {
        this.billItemItemHolder = billItemItemHolder;
    }
}
