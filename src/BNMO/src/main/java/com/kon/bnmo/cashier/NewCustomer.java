package com.kon.bnmo.cashier;

import com.kon.bnmo.customers.CustomerHolder;
import com.kon.bnmo.customers.MemberModel;
import com.kon.bnmo.customers.Person;
import com.kon.bnmo.customers.VIPModel;
import com.kon.bnmo.items.Item;
import com.kon.bnmo.items.ItemHolder;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;

import java.util.List;

public class NewCustomer extends Tab {
    private ChoiceBox<String> memberList;
    private TextField nonMember;
    private final Button enterButton;
    private CustomerHolder personList;
    private ItemHolder availableItems;

    public NewCustomer(CustomerHolder personList, ItemHolder availableItems) {

        super("Cashier: New Customer");
        this.personList = personList;
        this.availableItems = availableItems;

        // Add the members to the dropdown selection
        this.memberList = new ChoiceBox<>();
        for (Person p : this.personList.getList()) {
            if (p.getType().equals("member") || p.getType().equals("vip")) {
                if (p.getType().equals("member")) {
                    MemberModel memberPerson = (MemberModel) p;
                    this.memberList.getItems().add(memberPerson.getName());
                } else if (p.getType().equals("vip")) {
                    VIPModel vipPerson = (VIPModel) p;
                    this.memberList.getItems().add(vipPerson.getName());
                }
            }
        }
        this.memberList.getItems().add("Other");
        this.memberList.setValue("Choose Member");
        this.memberList.setOnAction(this::setActive);

        // Set text field to disabled
        this.nonMember = new TextField();
        this.nonMember.setDisable(true);

        enterButton = new Button("Enter");
        enterButton.setOnAction(this::createCashierPage);
        enterButton.setDisable(true);

        // Set the container as a vbox
        VBox container = new VBox(this.memberList, this.nonMember, enterButton);
        this.setContent(container);
    }

    private void createCashierPage(ActionEvent actionEvent) {
        String value;
        if (this.nonMember.isDisabled()) {
            value = this.memberList.getValue();
        } else {
            value = this.nonMember.getText();
        }
        Cashier cashierPage = new Cashier(value, this.availableItems, this.personList);
        this.getTabPane().getTabs().add(cashierPage);
        this.getTabPane().getSelectionModel().select(cashierPage);
        TabPane tabPane = getTabPane();
        if (tabPane != null) {
            tabPane.getTabs().remove(this);
        }
    }

    private void setActive(ActionEvent actionEvent) {
        this.nonMember.setDisable(!this.memberList.getValue().equals("Other"));
        this.enterButton.setDisable(this.memberList.getValue().equals("Choose Member"));
    }

    public ChoiceBox<String> getMemberList() {
        return memberList;
    }

    public void setMemberList(ChoiceBox<String> memberList) {
        this.memberList = memberList;
    }

    public TextField getNonMember() {
        return nonMember;
    }

    public void setNonMember(TextField nonMember) {
        this.nonMember = nonMember;
    }

    public CustomerHolder getPersonList() {
        return personList;
    }

    public void setPersonList(CustomerHolder personList) {
        this.personList = personList;
    }

    public ItemHolder getAvailableItems() {
        return availableItems;
    }

    public void setAvailableItems(ItemHolder availableItems) {
        this.availableItems = availableItems;
    }
}
