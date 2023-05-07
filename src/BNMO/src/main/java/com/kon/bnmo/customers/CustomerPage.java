package com.kon.bnmo.customers;

import com.kon.bnmo.datastore.DataStore;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;

import java.util.List;

public class CustomerPage extends Tab {
    private DataStore dataStore;

    public CustomerPage(DataStore dataStore, TabPane tabPane){
        super();
        this.dataStore = dataStore;
        updateUI(tabPane);
    }

    public void updateUI(TabPane tabPane){
        VBox vLayout = new VBox();

        Label nameLabel = new Label("Customer");
        nameLabel.setStyle("-fx-font-size: 24px; -fx-font-weight: bold");
        Button addButton = new Button("Add");

        ListView list = new ListView();
        list.setStyle("-fx-background-color: #eeeeee");

        List<Person> listPerson = this.dataStore.getCustomerHolder().getList();
        for(int i=0;i<listPerson.size();i++){
            CustomerListItem item = new CustomerListItem(this.dataStore, listPerson.get(i), tabPane, this);
            list.getItems().add(item);
        }

        vLayout.getChildren().add(nameLabel);
        vLayout.getChildren().add(addButton);
        vLayout.getChildren().add(list);

        addButton.setOnAction(event -> {
            CustomerModel customerModel;
            if(listPerson.size() == 0)
                customerModel = new CustomerModel("1");
            else
                customerModel = new CustomerModel(Integer.toString(Integer.parseInt(listPerson.get(listPerson.size()-1).getId())+1));
            this.dataStore.getCustomerHolder().add(customerModel);
            updateUI(tabPane);
        });

        this.setText("Customer");

        vLayout.setAlignment(Pos.CENTER);
        vLayout.setSpacing(10);
        this.setContent(vLayout);
    }
}
