package com.kon.bnmo.cashier;

import com.kon.bnmo.items.BillItem;
import javafx.event.ActionEvent;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;

import java.util.Arrays;
import java.util.List;

public class Cashier extends Tab {

    // new customer
    // main page
    // edit item
    // add item
    // checkout
    HBox mainContent;
    private GridPane itemPictureList;
    private CashierSidePanel sidePanel;

    Cashier(String customerName) {
        super("Cashier: " + customerName);

        Label mainContent = new Label("Main content goes here");
        mainContent.setPrefWidth(800);
        mainContent.setMaxWidth(Double.MAX_VALUE);

        this.sidePanel = new CashierSidePanel();
        BillItem myBalls = new BillItem("Balls", 50000.0, "Makanan", "bakso.png", 3, 0.1);
        BillItem mawutSosis = new BillItem("Boll", 50000.0, "Makanan", "bakso.png", 3, 0.1);
        BillItem mawut = new BillItem("Nasi Goreng", 50000.0, "Makanan", "bakso.png", 3, 0.1);
        BillItem serundeng = new BillItem("Ayam Serundeng", 50000.0, "Makanan", "bakso.png", 3, 0.1);
        BillItem matah = new BillItem("Nasi Ayam Sambal Matah", 50000.0, "Makanan", "bakso.png", 3, 0.1);
        sidePanel.getBc().addItem(myBalls);
        sidePanel.getBc().addItem(mawutSosis);
        sidePanel.getBc().addItem(mawut);
        sidePanel.getBc().addItem(serundeng);
        sidePanel.getBc().addItem(matah);

        this.getSidePanel().getAddCustomer().setOnAction(this::addNewCustomerTab);

        HBox container = new HBox();
        container.getChildren().addAll(mainContent, sidePanel);
        this.setContent(container);

    }

    private void addNewCustomerTab(ActionEvent actionEvent) {
        List<String> customerList = Arrays.asList("Nawwar", "Ulung", "Zaki");
        NewCustomer newPage = new NewCustomer(customerList);
        this.getTabPane().getTabs().add(newPage);
        this.getTabPane().getSelectionModel().select(newPage);
    }

    public CashierSidePanel getSidePanel() {
        return sidePanel;
    }

    public void setSidePanel(CashierSidePanel sidePanel) {
        this.sidePanel = sidePanel;
    }

}


