package com.kon.bnmo.customers;

import com.kon.bnmo.transaction.Transaction;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;

public class HistoryListItem extends HBox {
    public HistoryListItem(Transaction transaction){
        super();
        Label label = new Label(transaction.getListBillItem().get(0).getName());
        this.getChildren().add(label);
    }
}
