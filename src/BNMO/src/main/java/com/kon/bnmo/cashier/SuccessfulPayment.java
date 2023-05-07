package com.kon.bnmo.cashier;

import com.kon.bnmo.BillExporter;
import com.kon.bnmo.items.FixedBill;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.time.LocalTime;
import java.util.Locale;

public class SuccessfulPayment extends Stage {
    private Button printBill;
    private BillExporter billExporter;

    public SuccessfulPayment(FixedBill fixedBill) {
        LocalTime localTime = LocalTime.now();
        this.billExporter = new BillExporter(fixedBill, localTime.toString());
        this.printBill = new Button("Print bill");

        VBox statementContainer = new VBox();
        statementContainer.setSpacing(10);
        statementContainer.setAlignment(Pos.CENTER);
        Label congratulations = new Label("Congratulations, your payment is successful");
        statementContainer.getChildren().add(congratulations);

        HBox buttonContainer = new HBox();
        buttonContainer.setAlignment(Pos.CENTER_RIGHT);
        Region spacer = new Region();
        HBox.setHgrow(spacer, Priority.ALWAYS);
        buttonContainer.getChildren().addAll(spacer, printBill);

        statementContainer.getChildren().add(buttonContainer);
        VBox.setMargin(buttonContainer, new Insets(10, 10, 10, 10));

        this.printBill.setOnAction(this::startPrinting);

        this.setTitle("Payment successful");
        this.setScene(new Scene(statementContainer, 300, 300));
    }

    private void startPrinting(ActionEvent actionEvent) {
        this.billExporter.start();
        this.close();
    }

    public Button getPrintBill() {
        return printBill;
    }

    public void setPrintBill(Button printBill) {
        this.printBill = printBill;
    }

    public BillExporter getBillExporter() {
        return billExporter;
    }

    public void setBillExporter(BillExporter billExporter) {
        this.billExporter = billExporter;
    }
}
