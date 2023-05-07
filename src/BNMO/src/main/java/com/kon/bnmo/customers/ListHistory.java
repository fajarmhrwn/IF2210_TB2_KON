package com.kon.bnmo.customers;

import com.kon.bnmo.transaction.Transaction;
import com.kon.bnmo.transaction.TransactionHolder;
import javafx.scene.control.ListView;
import javafx.scene.control.Tab;
import javafx.scene.layout.HBox;

import java.util.List;

public class ListHistory extends Tab {
    ListHistory(TransactionHolder transactionHolder, Person person){
        super();
        ListView list = new ListView();
        List<Transaction> listTransaction = transactionHolder.getList();
        for(int i=0;i<listTransaction.size();i++){
//            if(Integer.toString(listTransaction.get(i).getIdCustomer()) == idCustomer){
                HistoryListItem item = new HistoryListItem(listTransaction.get(i));
                list.getItems().add(item);
//            }
        }
        if(person.getType() == "customer"){
            this.setText("History " + person.getId());
        }else if(person.getType() == "member"){
            this.setText("History " + ((MemberModel)person).getName());
        }else{
            this.setText("History " + ((VIPModel)person).getName());
        }

        this.setContent(list);
    }
}
