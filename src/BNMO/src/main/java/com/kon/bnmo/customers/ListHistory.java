package com.kon.bnmo.customers;

import com.kon.bnmo.transaction.Transaction;
import com.kon.bnmo.transaction.TransactionHolder;
import javafx.scene.control.ListView;
import javafx.scene.control.Tab;
import javafx.scene.layout.HBox;

import java.util.List;

public class ListHistory extends Tab {
    ListHistory(TransactionHolder transactionHolder, String idCustomer){
        super();
        ListView list = new ListView();
        List<Transaction> listTransaction = transactionHolder.getList();
        for(int i=0;i<listTransaction.size();i++){
//            if(Integer.toString(listTransaction.get(i).getIdCustomer()) == idCustomer){
                HistoryListItem item = new HistoryListItem(listTransaction.get(i));
                list.getItems().add(item);
//            }
        }
        this.setContent(list);
    }
}
