package com.kon.bnmo.cashier;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.StackPane;
import javafx.stage.Popup;
import javafx.stage.Stage;

public class PopupInTabExample extends Application {

    @Override
    public void start(Stage primaryStage) {
        // Create a TabPane
        TabPane tabPane = new TabPane();

        // Create a Tab with a Label as its content
        Tab tab1 = new Tab("Tab 1", new Label("This is the content of Tab 1"));

        // Create a Tab with a Popup as its content
        Tab tab = new Tab("My Tab");

        StackPane content = new StackPane();
        tab.setContent(content);

        Button button = new Button("Show Popup");
        button.setOnAction(e -> {
            Popup popup = new Popup();
            popup.setAutoHide(true);
            popup.getContent().add(new Label("This is a popup"));
            popup.show(tab.getTabPane().getScene().getWindow());
        });

        content.getChildren().add(button);

        // Add the Tabs to the TabPane
        tabPane.getTabs().addAll(tab1, tab);

        // Create a Scene with the TabPane as its root node
        Scene scene = new Scene(tabPane, 400, 400);

        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
