package com.kon.bnmo.sistembarang;

import com.kon.bnmo.MainApplication;
import com.kon.bnmo.cashier.Cashier;
import com.kon.bnmo.items.Item;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;

public class UpdateStoragePop extends Stage {
    private Item item;
    private Barang barang;
    private Scene scene;
    private VBox layout;

    public UpdateStoragePop(Item item, Barang barang) {
        this.item = item;
        this.scene = new Scene(new Label("Update Storage"));
        this.barang = barang;
        this.layout = new VBox();
        this.setTitle("Update Storage");
        this.setScene(scene);

        Label namaBarang = new Label(item.getName());
        Label labelQuantity = new Label("Update Quantity");
        TextField textFieldQuantity = new TextField();
        textFieldQuantity.setText(String.valueOf(item.getStock()));
        Label labelCategory = new Label("Change Category");
        TextField textFieldCategory = new TextField();
        textFieldCategory.setText(item.getCategory());
        Button buttonUpdate = new Button("Update");
        Button buttonDelete = new Button("Delete");

        buttonUpdate.setOnAction(event -> {
            try {

                int quantity = Integer.parseInt(textFieldQuantity.getText());
                if (quantity < 0) {
                    throw new NumberFormatException();
                }

                // Update item holder in SistemBarang
                this.barang.getSistemBarang().getItemHolder().getList().get(
                        this.barang.getSistemBarang().getItemHolder().getList().indexOf(item)
                ).setStock(quantity);

                // Update item holder pada catalogue serta pada cashier
                for (Tab tab:
                     this.barang.getSistemBarang().getTabPane().getTabs()) {
                    if (tab.getText().contains("Cashier:")) {
                        Cashier cashier = (Cashier) tab;
                        cashier.getMainPanel().getCatalogue().getAvailableItems().setItemStock(this.item, quantity);
                        cashier.getAvailableItems().setItemStock(this.item, quantity);
                        MainApplication mainApplication = (MainApplication) cashier.getMainClass();
                        mainApplication.getDataStore().getItemHolder().setItemStock(this.item, quantity);
                        cashier.getMainPanel().getCatalogue().updateCatalogue();
                        cashier.getSidePanel().getBc().updateBillContainer(this.item, quantity);
                    }
                }

                item.setStock(quantity);
                item.setCategory(textFieldCategory.getText());
                barang.update(item);
                this.close();
            } catch (NumberFormatException e) {
                // Jika input yang dimasukkan tidak valid (tidak angka atau angka kurang dari 0)
                // Maka lakukan penanganan kesalahan disini
                System.out.println("Input quantity harus berupa angka lebih dari sama dengan 0");
            }
        });
        buttonDelete.setOnAction(event -> {
            barang.delete();
            this.close();
        });

        layout.getChildren().addAll(namaBarang,labelQuantity,textFieldQuantity,labelCategory,textFieldCategory,buttonUpdate,buttonDelete);
        this.setScene(new Scene(layout, 300, 300));

    }
    @Override
    public void close(){
        super.close();
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public Barang getBarang() {
        return barang;
    }

    public void setBarang(Barang barang) {
        this.barang = barang;
    }
}
