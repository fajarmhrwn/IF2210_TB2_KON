package com.kon.bnmo;

import javafx.geometry.Orientation;
import javafx.scene.control.Label;
import javafx.scene.control.SplitPane;
import javafx.scene.control.Tab;

public class Cashier extends Tab {
    Cashier() {
        super("Cashier");
    }
    Cashier(String customerName) {
        super("Cashier: " + customerName);

        Label mainContent = new Label("Main content goes here");
        mainContent.setPrefWidth(800);
        mainContent.setMaxWidth(Double.MAX_VALUE);

        BillContainer bc = new BillContainer();
        BillItem myBalls = new BillItem("Balls", 50000.0, 3, "Dine in");
        BillItem mawutSosis = new BillItem("Nasi Goreng Mawut", 50000.0, 3, "Dine in");
        BillItem mawut = new BillItem("Nasi Goreng", 50000.0, 3, "Dine in");
        BillItem serundeng = new BillItem("Ayam Serundeng", 50000.0, 3, "Dine in");
        BillItem matah = new BillItem("Nasi Ayam Sambal Matah", 50000.0, 3, "Dine in");
        bc.addItem(myBalls);
        bc.addItem(myBalls);
        bc.addItem(myBalls);
        bc.addItem(myBalls);
        bc.addItem(myBalls);
        bc.addItem(myBalls);
        bc.addItem(myBalls);
        bc.addItem(myBalls);
        bc.addItem(myBalls);
        bc.addItem(myBalls);
        bc.addItem(myBalls);
        bc.addItem(myBalls);
        bc.addItem(myBalls);
        bc.addItem(myBalls);
        bc.addItem(myBalls);
        bc.addItem(myBalls);
        bc.addItem(myBalls);
        bc.addItem(myBalls);
        bc.addItem(myBalls);
        bc.addItem(myBalls);
        bc.addItem(myBalls);
        bc.addItem(myBalls);
        bc.addItem(myBalls);
        bc.addItem(myBalls);
        bc.addItem(myBalls);
        bc.addItem(myBalls);
        bc.addItem(myBalls);
        bc.addItem(myBalls);
        bc.addItem(mawutSosis);
        bc.addItem(mawut);
        bc.addItem(serundeng);
        bc.addItem(matah);

//        VBox sidePanel = new VBox();
//        StorageItem meatballs = new StorageItem("Bakso", 2500.0, 5);
//        ItemContainer item1 = new ItemContainer(meatballs, 3, "");
//        StorageItem mawut = new StorageItem("Nasi Goreng Mawut Ayam", 2500.0, 5);
//        ItemContainer item2 = new ItemContainer(mawut, 3, "");
//        sidePanel.getChildren().addAll(item1, item2);
//        sidePanel.setMinWidth(200);

        SplitPane splitPane = new SplitPane();
        splitPane.setOrientation(Orientation.HORIZONTAL);
        splitPane.getItems().addAll(mainContent, bc);
        splitPane.setDividerPositions(0.7, 0.3);

        this.setContent(splitPane);

    }
}


