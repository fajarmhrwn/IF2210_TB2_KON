package com.kon.bnmo.SistemBarang;

import com.kon.bnmo.items.ItemHolder;
import com.kon.bnmo.items.StorageItem;
import javafx.scene.control.*;
import javafx.scene.layout.*;

import java.util.ArrayList;
import java.util.List;


public class SistemBarang extends  Tab {

    private int jumlahBarang ;

    private ItemHolder<StorageItem> itemHolder ;

    public void setItemHolder(ItemHolder<StorageItem> itemHolder) {
        this.itemHolder = itemHolder;
        this.jumlahBarang = itemHolder.getItemList().size();
    }

    public ItemHolder<StorageItem> getItemHolder() {
        return itemHolder;
    }

    private VBox layout;

    private Label jumlahBarangLabel;

    public void removeItem(StorageItem item){
        itemHolder.remove(item);
        jumlahBarang--;
        jumlahBarangLabel.setText("Jumlah Barang : " + jumlahBarang);
        layout.getChildren().clear();
        this.itemHolder.getItemList().forEach(storageItem -> {
            Barang barang = new Barang(storageItem, this);
            layout.getChildren().add(barang);
        });

    }

    public SistemBarang(ItemHolder<StorageItem> itemHolder) {
        super("Sistem Barang");
        this.itemHolder = new ItemHolder<StorageItem>(itemHolder);
        this.jumlahBarang = itemHolder.getItemList().size();
        this.jumlahBarangLabel = new Label("Jumlah Barang : " + jumlahBarang);
        this.layout = new VBox();

        layout.setAlignment(javafx.geometry.Pos.CENTER); // set alignment to center

        for (StorageItem item : itemHolder.getItemList()){
            Barang barang = new Barang(item, this);
            layout.getChildren().add(barang);
        }

        // create a ScrollPane layout and add the VBox to it
        ScrollPane scrollPane = new ScrollPane();
        scrollPane.setContent(layout);
        scrollPane.setFitToWidth(true);

        TextField textField = new TextField();
        textField.setPromptText("Nama Barang");

        Button button = new Button("Cari Barang");
        button.setOnAction(event -> {
            System.out.println("Cari Barang");
        });

        HBox hBox = new HBox();
        hBox.setSpacing(10);
        hBox.setAlignment(javafx.geometry.Pos.CENTER);
        hBox.getChildren().add(textField);
        hBox.getChildren().add(button);

        ;

        VBox keterangan = new VBox();
        keterangan.setSpacing(10);
        keterangan.setAlignment(javafx.geometry.Pos.CENTER);
        keterangan.getChildren().add(new Label("All Items"));
        keterangan.getChildren().add(jumlahBarangLabel);


        BorderPane borderPane = new BorderPane();
        borderPane.setCenter(scrollPane);
        borderPane.setTop(keterangan);

        this.setContent(borderPane);
    }
}