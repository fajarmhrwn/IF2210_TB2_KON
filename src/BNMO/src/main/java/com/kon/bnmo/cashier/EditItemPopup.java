package com.kon.bnmo.cashier;

import com.kon.bnmo.customers.VIPModel;
import com.kon.bnmo.items.Item;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class EditItemPopup extends Stage {
    ItemContainer itemContainer;
    Scene scene;
    private Spinner<Integer> quantitySpinner;
    private VBox layout;

    public EditItemPopup(Item item, ItemContainer itemContainer, Integer initAmount) {
        this.itemContainer = itemContainer;
        this.scene = new Scene(new Label("Edit Barang"));
        this.setTitle("Edit Barang");

        this.layout = new VBox();

        Label itemName = new Label(item.getName());
        this.quantitySpinner = new Spinner<>(0, item.getStock(), initAmount);
        Label discountLabel = new Label("Discount Type");
//        CheckBox memberDiscount = new CheckBox("Member discount");
//        if (this.itemContainer
//                .getBillContainer()
//                .getSidePanel()
//                .getThisParent()
//                .getCustomerName()
//                .getType()
//                .equals("member")) {
//            memberDiscount.setDisable(false);
//        } else memberDiscount.setDisable(!this.itemContainer
//                .getBillContainer()
//                .getSidePanel()
//                .getThisParent()
//                .getCustomerName()
//                .getType()
//                .equals("vip"));
//
//        memberDiscount.setOnAction(event -> {
//            if (memberDiscount.isSelected()) {
//                this.itemContainer.setUseMemberDiscount(true);
//            }
//        });

        // If customer is VIP then enable
//        CheckBox usePoints = new CheckBox("Use VIP points");
//        usePoints.setOnAction(event -> {
//            if (usePoints.isSelected()) {
//                this.itemContainer.setUseVIPPoints(true);
//            }
//        });
//        if (this.itemContainer
//                .getBillContainer()
//                .getSidePanel()
//                .getThisParent()
//                .getCustomerName()
//                .getType()
//                .equals("member")) {
//            usePoints.setDisable(true);
//        } else usePoints.setDisable(!this.itemContainer
//                .getBillContainer()
//                .getSidePanel()
//                .getThisParent()
//                .getCustomerName()
//                .getType()
//                .equals("vip"));


        Button updateButton = new Button("Update");
        updateButton.setOnAction(event -> {
            try {
                int quantity = quantitySpinner.getValue();
                if (quantity < 0) {
                    throw new NumberFormatException();
                }
//                if (!memberDiscount.isDisabled()) {
//                    if (memberDiscount.isSelected()) {
//                        this.itemContainer.getBillContainer().getBillHolder().changeBuyingPrice(itemContainer, itemContainer.getBuyingPrice() * 0.9);
//                    }
//                }
//                if (!usePoints.isDisabled()) {
//                    if (usePoints.isSelected()) {
//                        VIPModel vip = (VIPModel) this.
//                                itemContainer
//                                        .getBillContainer()
//                                                .getSidePanel()
//                                                        .getThisParent()
//                                                                .getCustomerName();
//                        this.itemContainer.getBillContainer().getBillHolder().changeBuyingPrice(itemContainer,
//                                this.itemContainer.getBillContainer().getBillHolder().getBuyingPrice(itemContainer) - vip.getPoint());
//                    }
//                }
                this.close();
                this.itemContainer.getBillContainer().updateAmount(this.itemContainer, quantity);
                if (quantitySpinner.getValue() == 0) {
                    this.itemContainer.delete();
                }
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
                quantitySpinner,
                discountLabel,
//                memberDiscount,
//                usePoints,
                updateButton,
                deleteButton
        );

        this.setScene(new Scene(layout, 300, 300));

    }

    public void updateSpinner(Integer amount) {
        this.quantitySpinner = new Spinner<>(0, amount, this.quantitySpinner.getValue());
    }

    @Override
    public void close(){
        super.close();
    }

    public Spinner<Integer> getQuantitySpinner() {
        return quantitySpinner;
    }

    public void setQuantitySpinner(Spinner<Integer> quantitySpinner) {
        this.quantitySpinner = quantitySpinner;
    }

    public VBox getLayout() {
        return layout;
    }

    public void setLayout(VBox layout) {
        this.layout = layout;
    }
}
