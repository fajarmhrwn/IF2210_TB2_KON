package com.kon.bnmo;

import com.kon.bnmo.cashier.NewCustomer;
import com.kon.bnmo.customers.*;
import com.kon.bnmo.datastore.DataStore;
import com.kon.bnmo.main.DigitalClock;
import com.kon.bnmo.plugin.loader;
import com.kon.bnmo.sistembarang.SistemBarang;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.*;
import javafx.scene.layout.*;

public class MainApplication extends Application {
    private TabPane tabPane;

    private Label time ;

    private DataStore dataStore;

    public void addTab(Tab tab){
        this.tabPane.getTabs().add(tab);
    }
    @Override
    public void start(Stage primaryStage) throws Exception {
        dataStore = new DataStore();

        time = new Label();
        DigitalClock digitalClock = new DigitalClock();
        digitalClock.bindLabel(time);
        digitalClock.start();

        MenuButton dropdownMenu = new MenuButton("Pilih Menu");

        MenuItem menuItem1 = new MenuItem("Menu Customer");
        Menu menuItem2 = new Menu("Menu Inventory");
        Menu menuItem3 = new Menu("Menu Settings");

        dropdownMenu.getItems().addAll(menuItem1, menuItem2, menuItem3);

        this.tabPane = new TabPane();
        this.tabPane.getSelectionModel().selectedItemProperty().addListener((observable, oldTab, newTab) -> {
            // menyembunyikan label waktu ketika suatu tab dipilih
            if (newTab != null) {
                time.setVisible(false);
            } else {
                time.setVisible(true);
            }
        });

        MenuItem submenuItem4 = new MenuItem("Menu Cashier");
        MenuItem submenuItem5 = new MenuItem("Menu Inventory");

        menuItem2.getItems().addAll(submenuItem4, submenuItem5);

        MenuItem submenuItem6 = new MenuItem("Menu Settings Database");
        MenuItem submenuItem7 = new MenuItem("Menu Settings Plugin");

        menuItem3.getItems().addAll(submenuItem6, submenuItem7);

        menuItem1.setOnAction(event -> {
            dataStore.printCustomerHolder();
            CustomerPage tab = new CustomerPage(dataStore, tabPane);
            tabPane.getTabs().add(tab);
            tabPane.getSelectionModel().select(tab);
        });
        MenuItem submenuItem9 = new MenuItem("Menu Fixed Bill");
        menuItem2.getItems().add(submenuItem9);
        submenuItem9.setOnAction(event -> {
            Tab tab = new Tab("Fixed Bill");
            loader a = new loader(tab, dataStore);
            tabPane.getTabs().add(tab);
        });
        submenuItem4.setOnAction(event -> {
            NewCustomer cashier = new NewCustomer(
                    this.dataStore.getCustomerHolder(),
                    this.getDataStore().getItemHolder(),
                    this);
            tabPane.getTabs().add(cashier);
            tabPane.getSelectionModel().select(cashier);
        });

        submenuItem5.setOnAction(event -> {
            SistemBarang tab = new SistemBarang(dataStore.getItemHolder());
            tabPane.getTabs().add(tab);
            tabPane.getSelectionModel().select(tab);
        });

        submenuItem6.setOnAction(event -> {
            SettingsDB tab = new SettingsDB(this.dataStore, this);
            tabPane.getTabs().add(tab);
            tabPane.getSelectionModel().select(tab);
        });

        submenuItem7.setOnAction(event -> {
            SettingsPlug tab = new SettingsPlug();
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

    public void updateUI(){
        this.tabPane.getTabs().forEach(tab -> {
            if(tab instanceof CustomerPage){
                ((CustomerPage) tab).updateUI(this.tabPane);
            }
        });
    }

    public DataStore getDataStore() {
        return dataStore;
    }

    public void setDataStore(DataStore dataStore) {
        this.dataStore = dataStore;
    }

    public static void main(String[] args) {
        Application.launch(MainApplication.class, args);
    }
}