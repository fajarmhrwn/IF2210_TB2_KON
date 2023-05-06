package com.kon.bnmo.customers;

import javafx.scene.control.*;
import javafx.scene.layout.VBox;

public class CustomerPage extends Tab {

    public CustomerPage(){
        super();
        VBox vLayout = new VBox();

        Label nameLabel = new Label("Customer");
        Button addButton = new Button("Add");

        ListView list = new ListView();

        for(int i=0;i<10;i++){
            list.getItems().add(new CustomerListItem("Kimochi", "2"));
        }

        vLayout.getChildren().add(nameLabel);
        vLayout.getChildren().add(list);

        this.setText("Customer");
        this.setContent(vLayout);
    }
}
