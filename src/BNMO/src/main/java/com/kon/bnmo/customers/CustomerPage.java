package com.kon.bnmo.customers;

import com.kon.bnmo.datastore.DataStore;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;

import java.util.List;

public class CustomerPage extends Tab {

    public CustomerPage(DataStore dataStore, TabPane tabPane){
        super();
        VBox vLayout = new VBox();

        Label nameLabel = new Label("Customer");
        Button addButton = new Button("Add");

        ListView list = new ListView();

        List<Person> listPerson = dataStore.getCustomerHolder().getList();
        for(int i=0;i<listPerson.size();i++){
            CustomerListItem item = new CustomerListItem(dataStore, listPerson.get(i), tabPane);
            list.getItems().add(item);
        }

        vLayout.getChildren().add(nameLabel);
        vLayout.getChildren().add(list);

        this.setText("Customer");
        this.setContent(vLayout);
    }
}
