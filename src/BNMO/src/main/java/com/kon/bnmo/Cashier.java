package com.kon.bnmo;

import javafx.beans.binding.Bindings;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.SplitPane;
import javafx.scene.control.Tab;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

public class Cashier extends Tab {
    Cashier() {
        super("Cashier");
    }
    Cashier(String customerName) {
        super("Cashier: " + customerName);

        Label mainContent = new Label("Main content goes here");
        mainContent.setPrefWidth(800);
        mainContent.setMaxWidth(Double.MAX_VALUE);

        VBox sidePanel = new VBox();
        StorageItem meatballs = new StorageItem("Bakso", 2500.0, 5);
        ItemContainer item1 = new ItemContainer(meatballs, 3, "");
        StorageItem mawut = new StorageItem("Nasi Goreng Mawut Ayam", 2500.0, 5);
        ItemContainer item2 = new ItemContainer(mawut, 3, "");
        sidePanel.getChildren().addAll(item1, item2);
        sidePanel.setMinWidth(200);

        SplitPane splitPane = new SplitPane();
        splitPane.setOrientation(Orientation.HORIZONTAL);
        splitPane.getItems().addAll(mainContent, sidePanel);
        splitPane.setDividerPositions(0.78, 0.22);

        this.setContent(splitPane);

    }
}


