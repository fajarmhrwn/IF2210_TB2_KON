package com.kon.bnmo.customers;

import javafx.collections.FXCollections;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Dialog;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class UpdateCustomerPopUp extends Stage {
    UpdateCustomerPopUp(){
        VBox vLayout = new VBox();
        TextField nameField = new TextField();
        TextField phoneNumberField = new TextField();
        ComboBox<String> typeComboBox = new ComboBox<>(FXCollections.observableArrayList("Type 1", "Type 2", "Type 3"));
        Button submit = new Button("Submit");
        Button cancel = new Button("Cancel");
        cancel.setOnAction(event -> this.close());
        vLayout.getChildren().addAll(nameField, phoneNumberField, typeComboBox, submit, cancel);

        this.setScene(new Scene(vLayout, 300, 300));
    }
}
