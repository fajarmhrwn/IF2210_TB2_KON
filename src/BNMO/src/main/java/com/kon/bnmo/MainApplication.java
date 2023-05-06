package com.kon.bnmo;

import com.kon.bnmo.cashier.Cashier;
import com.kon.bnmo.cashier.SimplePane;
import com.kon.bnmo.customers.CustomerPage;
import com.kon.bnmo.items.Item;
import com.kon.bnmo.main.DigitalClock;
import com.kon.bnmo.main.LayarUtama;
import com.kon.bnmo.sistembarang.SistemBarang;
import com.kon.bnmo.items.ItemHolder;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.*;
import javafx.scene.layout.*;

public class MainApplication extends Application {
    private TabPane tabPane;

    private Label time ;

    public void addTab(Tab tab){
        this.tabPane.getTabs().add(tab);
    }
    @Override
    public void start(Stage primaryStage) throws Exception {

        time = new Label();
        DigitalClock digitalClock = new DigitalClock();
        digitalClock.bindLabel(time);
        digitalClock.start();

        MenuButton dropdownMenu = new MenuButton("Pilih Menu");

        Menu menuItem1 = new Menu("Menu Customer");
        Menu menuItem2 = new Menu("Menu Inventory");
        Menu menuItem3 = new Menu("Menu Settings");

        dropdownMenu.getItems().addAll(menuItem1, menuItem2, menuItem3);

        this.tabPane = new TabPane();

        MenuItem submenuItem1 = new MenuItem("Menu Register");
        MenuItem submenuItem2 = new MenuItem("Menu Update Member");
        MenuItem submenuItem3 = new MenuItem("Menu Transaction History");

        menuItem1.getItems().addAll(submenuItem1, submenuItem2, submenuItem3);

        MenuItem submenuItem4 = new MenuItem("Menu Inventory");
        MenuItem submenuItem5 = new MenuItem("Menu Cashier");

        menuItem2.getItems().addAll(submenuItem4, submenuItem5);

        MenuItem submenuItem6 = new MenuItem("Menu Settings Database");
        MenuItem submenuItem7 = new MenuItem("Menu Settings Plugin");

        menuItem3.getItems().addAll(submenuItem6, submenuItem7);

        submenuItem1.setOnAction(event -> {
            CustomerPage tab = new CustomerPage("Register");
            tabPane.getTabs().add(tab);
            tabPane.getSelectionModel().select(tab);
        });

        submenuItem2.setOnAction(event -> {
            CustomerPage tab = new CustomerPage("Update Member");
            tabPane.getTabs().add(tab);
            tabPane.getSelectionModel().select(tab);
        });

        submenuItem3.setOnAction(event -> {
            CustomerPage tab = new CustomerPage("Transaction History");
            tabPane.getTabs().add(tab);
            tabPane.getSelectionModel().select(tab);
        });

        submenuItem4.setOnAction(event -> {
            Cashier tab = new Cashier("Inventory");
            tabPane.getTabs().add(tab);
            tabPane.getSelectionModel().select(tab);
        });

        submenuItem5.setOnAction(event -> {
            ItemHolder itemHolder = new ItemHolder();
            itemHolder.add(new Item("Buku",10.000, "Alat tulis", "Buku Tulis", 10));
            itemHolder.add(new Item("Pensil", 5.000, "Alat tulis", "Pensil 2B", 10));
            itemHolder.add(new Item("Penghapus", 5.000, "Alat tulis", "Penghapus", 10));
            itemHolder.add(new Item("Penggaris", 5.000, "Alat tulis", "Penggaris", 10));
            itemHolder.add(new Item("Penggaris", 5.000, "Alat tulis", "Penggaris", 10));
            itemHolder.add(new Item("Penggaris", 5.000, "Alat tulis", "Penggaris", 10));
            SistemBarang tab = new SistemBarang(itemHolder);
            tabPane.getTabs().add(tab);
            tabPane.getSelectionModel().select(tab);
        });

        submenuItem6.setOnAction(event -> {
            Settings tab = new Settings();
            tabPane.getTabs().add(tab);
            tabPane.getSelectionModel().select(tab);
        });

        submenuItem7.setOnAction(event -> {
            Tab tab = new Tab("Settings Plugin");
            tabPane.getTabs().add(tab);
            tabPane.getSelectionModel().select(tab);
        });

        BorderPane borderPane = new BorderPane();
        borderPane.setCenter(this.tabPane);
        VBox root = new VBox(dropdownMenu, this.tabPane,time);
        root.setAlignment(Pos.TOP_CENTER);
        root.setSpacing(10);

        Scene scene = new Scene(root, 800, 600);
        primaryStage.setTitle("BNMO");
        primaryStage.setScene(scene);
        primaryStage.show();
    }


    public static void main(String[] args) {
        Application.launch(MainApplication.class, args);
    }
}