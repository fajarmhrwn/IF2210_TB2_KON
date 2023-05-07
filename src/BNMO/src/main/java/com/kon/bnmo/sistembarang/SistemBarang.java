package com.kon.bnmo.sistembarang;

import com.kon.bnmo.items.Item;
import com.kon.bnmo.items.ItemHolder;
import javafx.scene.control.*;
import javafx.scene.layout.*;


public class SistemBarang extends Tab {

    private int jumlahBarang;
    private ScrollPane scrollPane;

    private ItemHolder itemHolder;

    public void setItemHolder(ItemHolder itemHolder) {
        this.itemHolder = itemHolder;
        this.jumlahBarang = itemHolder.getList().size();
    }

    public ItemHolder getItemHolder() {
        return itemHolder;
    }

    private VBox layout;

    private Label jumlahBarangLabel;

    public void removeItem(Item item){
        itemHolder.remove(item);
        jumlahBarang--;
        jumlahBarangLabel.setText("Jumlah Barang : " + jumlahBarang);
        layout.getChildren().clear();
        this.itemHolder.getList().forEach(Item -> {
            Barang barang = new Barang(Item, this);
            layout.getChildren().add(barang);
        });

    }

    public SistemBarang(ItemHolder itemHolder) {
        super("Sistem Barang");
        this.itemHolder = new ItemHolder(itemHolder);
        this.jumlahBarang = itemHolder.getList().size();
        this.jumlahBarangLabel = new Label("Jumlah Barang : " + jumlahBarang);
        this.layout = new VBox();

        layout.setAlignment(javafx.geometry.Pos.CENTER); // set alignment to center

        for (Item item : itemHolder.getList()){
            Barang barang = new Barang(item, this);
            layout.getChildren().add(barang);
        }

        // create a ScrollPane layout and add the VBox to it
        this.scrollPane = new ScrollPane();
        this.scrollPane.setContent(layout);
        this.scrollPane.setFitToWidth(true);

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

    public void updateUI() {
        this.layout = new VBox();

        layout.setAlignment(javafx.geometry.Pos.CENTER); // set alignment to center

        for (Item item : itemHolder.getList()){
            Barang barang = new Barang(item, this);
            layout.getChildren().add(barang);
        }
        this.scrollPane.setContent(this.layout);
    }

}