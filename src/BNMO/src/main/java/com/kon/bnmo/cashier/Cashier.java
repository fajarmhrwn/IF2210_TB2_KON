package com.kon.bnmo.cashier;

import com.kon.bnmo.items.BillItem;
import javafx.geometry.Orientation;
import javafx.scene.control.Label;
import javafx.scene.control.SplitPane;
import javafx.scene.control.Tab;
import javafx.scene.layout.GridPane;

public class Cashier extends Tab {

    private GridPane itemPictureList;
    private CashierSidePanel sidePanel;

    Cashier(String customerName) {
        super("Cashier: " + customerName);

        Label mainContent = new Label("Main content goes here");
        mainContent.setPrefWidth(800);
        mainContent.setMaxWidth(Double.MAX_VALUE);

        this.sidePanel = new CashierSidePanel();
        BillItem myBalls = new BillItem("Balls", 50000.0, 3, "Dine in");
        BillItem mawutSosis = new BillItem("Nasi Goreng Mawut", 50000.0, 3, "Dine in");
        BillItem mawut = new BillItem("Nasi Goreng", 50000.0, 3, "Dine in");
        BillItem serundeng = new BillItem("Ayam Serundeng", 50000.0, 3, "Dine in");
        BillItem matah = new BillItem("Nasi Ayam Sambal Matah", 50000.0, 3, "Dine in");
        sidePanel.getBc().addItem(myBalls);
        sidePanel.getBc().addItem(mawutSosis);
        sidePanel.getBc().addItem(mawut);
        sidePanel.getBc().addItem(serundeng);
        sidePanel.getBc().addItem(matah);
//        bc.setMinWidth(350);
//        bc.setMaxWidth(350);

        SplitPane splitPane = new SplitPane();
        splitPane.setOrientation(Orientation.HORIZONTAL);
        splitPane.getItems().addAll(mainContent, sidePanel);
        splitPane.setDividerPositions(0.7, 0.3);

        this.setContent(splitPane);

    }
}


