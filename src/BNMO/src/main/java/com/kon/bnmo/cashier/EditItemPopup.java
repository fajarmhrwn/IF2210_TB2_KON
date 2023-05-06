package com.kon.bnmo.cashier;

import com.kon.bnmo.items.Item;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class EditItemPopup extends Stage {
    ItemContainer itemContainer;
    Scene scene;

    public EditItemPopup(Item item, ItemContainer itemContainer) {
        this.itemContainer = itemContainer;
        this.scene = new Scene(new Label("Edit Barang"));
        this.setTitle("Edit Barang");

        VBox layout = new VBox();

        Label itemName = new Label(item.getName());
        TextField itemAmount = new TextField();
        itemAmount.setText(String.valueOf(itemContainer.getAmount()));
        Label discountLabel = new Label("Discount Type");
        CheckBox memberDiscount = new CheckBox("Member discount");
        // If customer is member then enable
        memberDiscount.setOnAction(event -> {
            if (memberDiscount.isSelected()) {
                this.itemContainer.setUseMemberDiscount(true);
            }
        });

        // If customer is VIP then enable
        CheckBox usePoints = new CheckBox("Use VIP points");
        usePoints.setOnAction(event -> {
            if (usePoints.isSelected()) {
                this.itemContainer.setUseVIPPoints(true);
            }
        });

        Button updateButton = new Button("Update");
        updateButton.setOnAction(event -> {
            try {
                int quantity = Integer.parseInt(itemAmount.getText());
                if (quantity < 0) {
                    throw new NumberFormatException();
                }
                if (!memberDiscount.isDisabled()) {
                    if (memberDiscount.isSelected()) {
                        itemContainer.setBuyingPrice(itemContainer.getBuyingPrice() * 0.9);
                    }
                }
//                if (!usePoints.isDisabled()) {
//                    if (usePoints.isSelected()) {
//
//                    }
                this.close();
                this.itemContainer.getBillContainer().updateAmount(this.itemContainer, quantity);
                this.itemContainer.getBillContainer().getSidePanel().setPrice();
            } catch (NumberFormatException e) {
                // Jika input yang dimasukkan tidak valid (tidak angka atau angka kurang dari 0)
                // Maka lakukan penanganan kesalahan disini
                System.out.println("Input quantity harus berupa angka lebih dari sama dengan 0");
            }
        });
        Button deleteButton = new Button("Delete");
        deleteButton.setOnAction(event -> {
            itemContainer.delete();
            this.close();
            this.itemContainer.getBillContainer().getSidePanel().setPrice();
        });

        layout.getChildren().addAll(
                itemName,
                itemAmount,
                discountLabel,
                memberDiscount,
                usePoints,
                updateButton,
                deleteButton
        );

        this.setScene(new Scene(layout, 300, 300));

    }

    @Override
    public void close(){
        super.close();
    }

}
