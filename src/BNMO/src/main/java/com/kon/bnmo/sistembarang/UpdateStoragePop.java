package com.kon.bnmo.sistembarang;

import com.kon.bnmo.items.StorageItem;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class UpdateStoragePop extends Stage {
    StorageItem item;
    Barang barang;
    Scene scene;
    VBox layout;
    public UpdateStoragePop(StorageItem item, Barang barang) {
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

}
