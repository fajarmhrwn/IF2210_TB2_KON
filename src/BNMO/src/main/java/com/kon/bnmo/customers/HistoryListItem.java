package com.kon.bnmo.customers;

import com.kon.bnmo.transaction.Transaction;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;

public class HistoryListItem extends HBox {
    public HistoryListItem(Transaction transaction){
        super();
        StringBuilder listName = new StringBuilder();
        for(int i=0;i<transaction.getListBillItem().size();i++){
            listName.append(transaction.getListBillItem().get(0).getName());
            if(i!=transaction.getListBillItem().size()-1){
                listName.append(", ");
            }
        }
        Label label = new Label(listName.toString());
        Label date = new Label(transaction.getCheckoutDate());
        this.setAlignment(Pos.CENTER);
        this.setSpacing(10);
        this.getChildren().addAll(label, date);
    }
}
