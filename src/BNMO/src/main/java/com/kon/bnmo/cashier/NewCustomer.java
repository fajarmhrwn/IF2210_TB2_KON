package com.kon.bnmo.cashier;

import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;

import java.util.List;

public class NewCustomer extends Tab {
    private ChoiceBox<String> memberList;
    private TextField nonMember;
    private final Button enterButton;

    public NewCustomer(List<String> memberList) {

        super("Cashier: New Customer");

        // Add the members to the dropdown selection
        this.memberList = new ChoiceBox<>();
        for (String member : memberList) {
            this.memberList.getItems().add(member);
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
        Cashier cashierPage = new Cashier(value);
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
}
