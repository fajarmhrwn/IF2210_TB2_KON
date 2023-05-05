package com.kon.bnmo.cashier;

import com.kon.bnmo.cashier.Cashier;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.util.Arrays;
import java.util.List;

public class SimplePane extends Application {

    @Override
    public void start(Stage primaryStage) {
        // Create a new TabPane
        TabPane tabPane = new TabPane();

//         Create two tabs with their content
        Cashier tab1 = new Cashier("Nawwar");
//        tab1.getSidePanel().getAddCustomer().setOnAction(this::onCustomerButtonClick);
//        List<String> customerList = Arrays.asList("Nawwar", "Ulung", "Zaki");
//        NewCustomer tab1 = new NewCustomer(customerList);

        Tab tab2 = new Tab("Tab 2");
        StackPane tab2Content = new StackPane();
        tab2.setContent(tab2Content);

        // Add the tabs to the TabPane
        tabPane.getTabs().addAll(tab1, tab2);

        // Create a new Scene with the TabPane as its root
        Scene scene = new Scene(tabPane, 1200, 675);

        // Set the Scene to the primary Stage and show it
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
