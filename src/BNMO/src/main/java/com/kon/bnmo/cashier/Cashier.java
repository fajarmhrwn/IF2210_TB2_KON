package com.kon.bnmo.cashier;

import javafx.event.ActionEvent;
import javafx.scene.control.Tab;
import javafx.scene.layout.HBox;

import java.util.Arrays;
import java.util.List;

public class Cashier extends Tab {
    private CashierMainPanel mainPanel;
    private CashierSidePanel sidePanel;
    private String customerName;

    public Cashier(String customerName) {
        super("Cashier: " + customerName);
        this.customerName = customerName;

        this.mainPanel = new CashierMainPanel(this);
        this.mainPanel.setPrefWidth(850);

        this.sidePanel = new CashierSidePanel(this);

        this.getSidePanel().getAddCustomer().setOnAction(this::addNewCustomerTab);

        HBox container = new HBox();
        container.getChildren().addAll(this.mainPanel, sidePanel);
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

    public CashierMainPanel getMainPanel() {
        return mainPanel;
    }

    public void setMainPanel(CashierMainPanel mainPanel) {
        this.mainPanel = mainPanel;
    }
}


