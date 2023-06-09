package com.kon.bnmo.customers;

import com.kon.bnmo.datastore.DataStore;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TabPane;
import javafx.scene.layout.HBox;

public class CustomerListItem extends HBox {
    public CustomerListItem(DataStore data, Person person, TabPane tabPane, CustomerPage customerPage){
        super();
        this.setAlignment(Pos.CENTER_LEFT);
        this.setSpacing(10);
        Label nameLabel = new Label();
        if(person.getType() =="customer") {
            CustomerModel customer = (CustomerModel) person;
            nameLabel.setText(customer.getId().toString());
        }else if(person.getType() =="member") {
            MemberModel member = (MemberModel) person;
            nameLabel.setText(member.getName());
        }else {
            VIPModel vip = (VIPModel) person;
            nameLabel.setText(vip.getName());
        }
        Button detailButton = new Button("Detail");
        Button editButton = new Button("Edit");
        Button deleteButton = new Button("Delete");
        this.getChildren().addAll(nameLabel, detailButton, editButton, deleteButton);

        detailButton.setOnAction(event -> {
            ListHistory listHistory = new ListHistory(data.getTransactionHolder(), person);
            tabPane.getTabs().add(listHistory);
        });

        // menambahkan listener pada tombol edit dan delete
        editButton.setOnAction(event -> editCustomer(tabPane, customerPage, data, person));
        deleteButton.setOnAction(event -> deleteCustomer(tabPane, customerPage, data, person));
        this.setAlignment(Pos.CENTER);
    }

    private void deleteCustomer(TabPane tabPane, CustomerPage customerPage, DataStore data, Person person) {
        data.getCustomerHolder().remove(person);
        customerPage.updateUI(tabPane);
    }

    public void editCustomer(TabPane tabPane, CustomerPage customerPage, DataStore data, Person person){
        UpdateCustomerPopUp popup = new UpdateCustomerPopUp(person, data, customerPage, tabPane);
        popup.showAndWait();
    }
}
