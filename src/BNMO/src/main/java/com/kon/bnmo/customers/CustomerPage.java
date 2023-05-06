package com.kon.bnmo.customers;

import javafx.scene.control.*;
import javafx.scene.layout.VBox;

public class CustomerPage extends Tab {

    public CustomerPage(){
        super("erkjgf");
        VBox vLayout = new VBox();

        Label nameLabel = new Label("Customer");

        for(int i=0;i<10;i++){

        }

        vLayout.getChildren().add(nameLabel);

        this.setText("Customer");
        this.setContent(vLayout);
    }
}
