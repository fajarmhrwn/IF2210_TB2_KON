package com.kon.bnmo.customers;

import javafx.scene.control.*;
import javafx.scene.layout.VBox;

public class CustomerPage extends Tab {
    CustomerPage(){
        super("erkjgf");
    }

    public CustomerPage(String name){
        VBox vLayout = new VBox();

        Label nameLabel = new Label(name);

        vLayout.getChildren().add(nameLabel);
        this.setText(name);
        this.setContent(vLayout);
    }
}
