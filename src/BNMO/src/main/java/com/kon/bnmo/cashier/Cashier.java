package com.kon.bnmo.cashier;

import com.kon.bnmo.items.Item;
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
    private CashierSidePanel sidePanel;
    private String customerName;

    public Cashier(String customerName) {
        super("Cashier: " + customerName);
        this.customerName = customerName;

        Label mainContent = new Label("Main content goes here");
        mainContent.setPrefWidth(800);
        mainContent.setMaxWidth(Double.MAX_VALUE);

        this.sidePanel = new CashierSidePanel(this);
        Item myBalls = new Item("Balls", 50000.0, "Makanan", "bakso.png", 3);
        Item mawutSosis = new Item("Boll", 50000.0, "Makanan", "bakso.png", 3);
        Item mawut = new Item("Nasi Goreng", 50000.0, "Makanan", "bakso.png", 3);
        Item serundeng = new Item("Ayam Serundeng", 50000.0, "Makanan", "bakso.png", 3);
        Item matah = new Item("Nasi Ayam Sambal Matah", 50000.0, "Makanan", "bakso.png", 3);
        ItemContainer containMyBalls = new ItemContainer(myBalls, sidePanel.getBc());
        ItemContainer containMawut = new ItemContainer(mawutSosis, sidePanel.getBc());
        ItemContainer containM = new ItemContainer(mawut, sidePanel.getBc());
        ItemContainer containSerundeng = new ItemContainer(serundeng, sidePanel.getBc());
        ItemContainer containMatah = new ItemContainer(matah, sidePanel.getBc());
        sidePanel.getBc().addItem(containMyBalls);
        sidePanel.getBc().addItem(containMawut);
        sidePanel.getBc().addItem(containM);
        sidePanel.getBc().addItem(containSerundeng);
        sidePanel.getBc().addItem(containMatah);
        sidePanel.setPrice();

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

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }
}


