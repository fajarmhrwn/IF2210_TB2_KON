package com.kon.bnmo.customers;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;

public class CustomerListItem extends HBox {
    public CustomerListItem(String label, String id){
        super();
        this.setAlignment(Pos.CENTER_LEFT);
        this.setSpacing(10);
        this.getChildren().add(new Label(label));
        Button editButton = new Button("Edit");
        Button deleteButton = new Button("Delete");
        this.getChildren().addAll(editButton, deleteButton);

        // menambahkan listener pada tombol edit dan delete
        editButton.setOnAction(event -> editCustomer());
        deleteButton.setOnAction(event -> deleteCustomer());
    }

    public void editCustomer(){

    }

    public void deleteCustomer(){

    }
}
