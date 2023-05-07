package com.kon.bnmo.customers;

import com.kon.bnmo.transaction.Transaction;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;

public class HistoryListItem extends HBox {
    public HistoryListItem(Transaction transaction){
        super();
        Label label = new Label(transaction.getListBillItem().get(0).getName());
        this.setAlignment(Pos.CENTER);
        this.getChildren().add(label);
    }
}
