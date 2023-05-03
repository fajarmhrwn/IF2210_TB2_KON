package com.kon.bnmo.SistemBarang;

import com.kon.bnmo.items.ItemHolder;
import com.kon.bnmo.items.StorageItem;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.stage.Popup;

public class Barang extends HBox {

    private StorageItem item;
    private Label nameLabel;
    private Label amountLabel;
    
    private ItemHolder<StorageItem> itemHolder; // tambahkan atribut untuk ItemHolder

    public Barang(StorageItem item, ItemHolder<StorageItem> itemHolder) { // tambahkan parameter untuk ItemHolder
        super();
        this.item = item;
        this.itemHolder = itemHolder; // simpan referensi ke ItemHolder
        this.amountLabel = new Label(item.getStock().toString());
        this.nameLabel = new Label(item.getName());

        this.setAlignment(Pos.CENTER);
        this.setSpacing(10);
        Region spacer = new Region();
        this.setHgrow(spacer, Priority.ALWAYS);
        this.getChildren().addAll(nameLabel, spacer, amountLabel);

        this.setOnMouseClicked(event -> {
            openPopUp();
        });
    }

    public void openPopUp() {
        System.out.println("Open Pop Up");

//        this.itemHolder.setItemAmount(item,this.item.getAmount()-1); // tambahkan item ke ItemHolder
//        amountLabel.setText(item.getStock().toString()); // mengubah tampilan label stock
//        System.out.println(item.getAmount()); // print jumlah item
    }


}

