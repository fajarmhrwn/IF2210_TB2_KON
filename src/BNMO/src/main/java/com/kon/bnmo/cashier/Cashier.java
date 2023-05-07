package com.kon.bnmo.cashier;

import com.kon.bnmo.customers.*;
import com.kon.bnmo.items.ItemHolder;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.scene.control.Tab;
import javafx.scene.layout.HBox;

public class Cashier extends Tab {
    private CashierMainPanel mainPanel;
    private CashierSidePanel sidePanel;
    private Person customer;
    private ItemHolder availableItems;
    private CustomerHolder memberList;
    private Application mainClass;

    public Cashier(Person customer, ItemHolder availableItems, CustomerHolder memberList, Application mainClass) {
        super();
        String name;
        if (customer.getType().equals("customer")) {
            name = customer.getId();
        } else if (customer.getType().equals("member")) {
            name = ((MemberModel) customer).getName();
        } else {
            name = ((VIPModel) customer).getName();
        }
        this.setText("Cashier: " + name);

        this.customer = customer;
        this.availableItems = availableItems;
        this.memberList = memberList;
        this.mainClass = mainClass;

        this.mainPanel = new CashierMainPanel(this, this.availableItems);
        this.mainPanel.setPrefWidth(850);

        this.sidePanel = new CashierSidePanel(this);

        this.getSidePanel().getAddCustomer().setOnAction(this::addNewCustomerTab);

        HBox container = new HBox();
        container.getChildren().addAll(this.mainPanel, sidePanel);
        this.setContent(container);
    }

    private void addNewCustomerTab(ActionEvent actionEvent) {
        NewCustomer newPage = new NewCustomer(memberList, availableItems, this.mainClass);
        this.getTabPane().getTabs().add(newPage);
        this.getTabPane().getSelectionModel().select(newPage);
    }

    public CashierSidePanel getSidePanel() {
        return sidePanel;
    }

    public void setSidePanel(CashierSidePanel sidePanel) {
        this.sidePanel = sidePanel;
    }

    public Person getCustomerName() {
        return customer;
    }

    public void setCustomerName(Person customerName) {
        this.customer = customerName;
    }

    public CashierMainPanel getMainPanel() {
        return mainPanel;
    }

    public void setMainPanel(CashierMainPanel mainPanel) {
        this.mainPanel = mainPanel;
    }

    public ItemHolder getAvailableItems() {
        return availableItems;
    }

    public void setAvailableItems(ItemHolder availableItems) {
        this.availableItems = availableItems;
    }

    public CustomerHolder getMemberList() {
        return memberList;
    }

    public void setMemberList(CustomerHolder memberList) {
        this.memberList = memberList;
    }

    public void updateUI() {

    }

    public Application getMainClass() {
        return mainClass;
    }

    public void setMainClass(Application mainClass) {
        this.mainClass = mainClass;
    }
}


