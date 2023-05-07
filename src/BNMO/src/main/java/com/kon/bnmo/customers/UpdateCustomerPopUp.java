package com.kon.bnmo.customers;

import com.kon.bnmo.datastore.DataStore;
import javafx.collections.FXCollections;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class UpdateCustomerPopUp extends Stage {
    UpdateCustomerPopUp(Person person, DataStore dataStore, CustomerPage customerPage, TabPane tabPane){
        VBox vLayout = new VBox();
        TextField nameField = new TextField();
        TextField phoneNumberField = new TextField();
        ComboBox<String> typeComboBox = new ComboBox<>(FXCollections.observableArrayList("customer", "member", "vip"));
        if(person.getType() == "customer"){
            nameField.setText(((CustomerModel)person).getId());
            typeComboBox.setValue("customer");
        }else if(person.getType() == "member"){
            nameField.setText(((MemberModel)person).getName());
            phoneNumberField.setText(((MemberModel)person).getPhoneNumber());
            typeComboBox.setValue("member");
        }else{
            nameField.setText(((VIPModel)person).getName());
            phoneNumberField.setText(((VIPModel)person).getPhoneNumber());
            typeComboBox.setValue("vip");
        }
        Button submit = new Button("Submit");

        submit.setOnAction(event -> {
            int index = dataStore.getCustomerHolder().getList().indexOf(person);
            if(typeComboBox.getValue() == "customer"){
                CustomerModel customerModel = new CustomerModel(person.getId());
                dataStore.getCustomerHolder().getList().set(index, customerModel);
            }else if(typeComboBox.getValue() == "member"){
                MemberModel memberModel = new MemberModel(person.getId(), nameField.getText(), phoneNumberField.getText());
                dataStore.getCustomerHolder().getList().set(index, memberModel);
            }else{
                VIPModel vipModel = new VIPModel(person.getId(), nameField.getText(), phoneNumberField.getText(), 0);
                dataStore.getCustomerHolder().getList().set(index, vipModel);
            }
            customerPage.updateUI(tabPane);
            this.close();
        });

        Button cancel = new Button("Cancel");
        cancel.setOnAction(event -> this.close());
        vLayout.getChildren().addAll(nameField, phoneNumberField, typeComboBox, submit, cancel);

        this.setScene(new Scene(vLayout, 300, 300));
    }
}
