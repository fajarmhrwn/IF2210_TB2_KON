package com.kon.bnmo.sistembarang;

import com.kon.bnmo.items.Item;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;

public class Barang extends HBox {

    private UpdateStoragePop updateStoragePop;
    private Item item;
    private Label nameLabel;
    private Label amountLabel;
    private SistemBarang sistemBarang;

    public void setItem(Item item) {
        this.item = item;
    }

    public void update(Item item){
        this.amountLabel.setText(this.item.getStock().toString());
    }
    public  void setAmountLabel(String str) {
        this.amountLabel.setText(str);
    }
    public void setNameLabel(String str) {
        this.nameLabel.setText(str);
    }

    public void delete(){
        this.sistemBarang.removeItem(this.item);
    }

    public Barang(Item item, SistemBarang sistemBarang) { // tambahkan parameter untuk ItemHolder
        super();

        this.sistemBarang = sistemBarang;
        this.item = item;
        this.amountLabel = new Label(item.getStock().toString());
        this.nameLabel = new Label(item.getName());
        this.updateStoragePop = new UpdateStoragePop(item,this);


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
        updateStoragePop.show();
//        this.item.decreaseAmount(1);
//        if(this.item.getStock() == 0){
//            sistemBarang.removeItem(this.item);
//        }
////        this.itemHolder.setItemAmount(item,this.item.getAmount()-1); // tambahkan item ke ItemHolder
//////        this.itemHolder.setItemAmount(item,this.item.getAmount()-1); // tambahkan item ke ItemHolder
//        amountLabel.setText(this.item.getStock().toString()); // mengubah tampilan label stock
////        System.out.println(item.getAmount()); // print jumlah item
    }


}

