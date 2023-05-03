package com.kon.bnmo;

import com.kon.bnmo.SistemBarang.SistemBarang;
import com.kon.bnmo.items.ItemHolder;
import com.kon.bnmo.items.StorageItem;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.*;
import javafx.scene.layout.*;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {

        MenuButton dropdownMenu = new MenuButton("Pilih Menu");
        
        MenuItem menuItem1 = new MenuItem("Menu 1");
        TabPane tabPane = new TabPane();

        menuItem1.setOnAction(event -> {
            Tab tab = new Tab("Tab 1");
            tab.setContent(new Label("Konten Tab 1"));
            tabPane.getTabs().add(tab);
        });

        MenuItem menuItem2 = new MenuItem("Menu 2");
        menuItem2.setOnAction(event -> {
            Tab tab = new Tab("Tab 2");
            tab.setContent(new Label("Konten Tab 2"));
            tabPane.getTabs().add(tab);
        });

        dropdownMenu.getItems().addAll(menuItem1, menuItem2);

        Tab tab1 = new Tab();
        CustomerPage customerPage = new CustomerPage("hakwe");
        tab1.setText("Home");
        tabPane.getTabs().add(tab1);
        tabPane.getTabs().add(customerPage);

        Settings settingsPage = new Settings();
        tabPane.getTabs().add(settingsPage);

        BorderPane borderPane = new BorderPane();
        borderPane.setCenter(tabPane);
        VBox root = new VBox(dropdownMenu, tabPane);

        ItemHolder<StorageItem> itemHolder = new ItemHolder<>();
        itemHolder.add(new StorageItem("Buku",10.000, 10));
        itemHolder.add(new StorageItem("Pensil", 5.000, 10));
        itemHolder.add(new StorageItem("Penghapus", 2.000, 10));
        itemHolder.add(new StorageItem("Penggaris", 3.000, 10));
        itemHolder.add(new StorageItem("Penggaris", 3.000, 10));
        itemHolder.add(new StorageItem("Penggaris", 3.000, 10));
        itemHolder.add(new StorageItem("Penggaris", 3.000, 10));
        itemHolder.add(new StorageItem("Penggaris", 3.000, 10));
        itemHolder.add(new StorageItem("Penggaris", 3.000, 10));
        itemHolder.add(new StorageItem("Penggaris", 3.000, 10));
        itemHolder.add(new StorageItem("Penggaris", 3.000, 10));


        Tab sistemBarang = new SistemBarang(itemHolder);
        tabPane.getTabs().add(sistemBarang);

        Scene scene = new Scene(root, 800, 600);
        primaryStage.setTitle("JavaFX Tab Example");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}