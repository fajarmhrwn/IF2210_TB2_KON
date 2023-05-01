package com.kon.bnmo;

import com.kon.bnmo.cashier.ItemContainer;
import com.kon.bnmo.items.StorageItem;
import javafx.application.Application;
import javafx.geometry.Orientation;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.SplitPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class SidePanelExample extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        Label mainContent = new Label("Main content goes here");
        mainContent.setPrefWidth(300);
        mainContent.setMaxWidth(Double.MAX_VALUE);

        VBox sidePanel = new VBox();
        StorageItem meatballs = new StorageItem("Bakso", 2500.0, 5);
        ItemContainer item1 = new ItemContainer(meatballs, 3, "");
        item1.setMaxWidth(Double.MAX_VALUE);
        item1.setPrefWidth(100);
        HBox.setHgrow(item1, Priority.ALWAYS);
        sidePanel.getChildren().add(item1);
        sidePanel.setPrefWidth(150);
        sidePanel.setMinWidth(150);

        SplitPane splitPane = new SplitPane();
        splitPane.setOrientation(Orientation.HORIZONTAL);
        splitPane.getItems().addAll(mainContent, sidePanel);

//        AnchorPane root = new AnchorPane();
//        AnchorPane.setLeftAnchor(splitPane, 0.0);
//        AnchorPane.setTopAnchor(splitPane, 0.0);
//        AnchorPane.setRightAnchor(splitPane, 0.0);
//        AnchorPane.setBottomAnchor(splitPane, 0.0);
//        root.getChildren().add(splitPane);

        Scene scene = new Scene(splitPane, 600, 400);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
