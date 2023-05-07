package com.kon.bnmo.cashier;

import com.kon.bnmo.datastore.DataStore;
import com.kon.bnmo.datastore.JSONDataAdapter;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.io.IOException;

public class SimplePane extends Application {

    private DataStore dataStore;

    @Override
    public void start(Stage primaryStage) {
        this.dataStore = new DataStore();
        dataStore.setDataAdapter(new JSONDataAdapter());
        try {
            dataStore.read("D:\\ITB\\Semester 4\\Object Oriented Programming\\Tubes2\\src\\BNMO\\DataStore\\JSON");
        } catch (IOException err) {
            System.out.println(err.getMessage());
        }
        // Create a new TabPane
        TabPane tabPane = new TabPane();

//         Create two tabs with their content
        NewCustomer tab1 = new NewCustomer(dataStore.getCustomerHolder(), dataStore.getItemHolder(), this);

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

    public DataStore getDataStore() {
        return dataStore;
    }

    public void setDataStore(DataStore dataStore) {
        this.dataStore = dataStore;
    }

    public static void main(String[] args) {
        launch(args);
    }
}
