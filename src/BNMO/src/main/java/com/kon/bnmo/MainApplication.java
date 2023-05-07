package com.kon.bnmo;

import com.kon.bnmo.cashier.NewCustomer;
import com.kon.bnmo.customers.*;
import com.kon.bnmo.datastore.DataStore;
import com.kon.bnmo.main.DigitalClock;
import com.kon.bnmo.sistembarang.SistemBarang;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.stage.Popup;
import javafx.stage.Stage;
import javafx.scene.control.*;
import javafx.scene.layout.*;

import java.io.IOException;

public class MainApplication extends Application {
    private TabPane tabPane;

    private Label time ;

    private DataStore dataStore;

    private SettingsDB settingsDB;

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
        MenuItem menuItem4 = new Menu("Export Laporan");

        dropdownMenu.getItems().addAll(menuItem1, menuItem2, menuItem3, menuItem4);

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
            settingsDB = new SettingsDB(this.dataStore, this);
            tabPane.getTabs().add(settingsDB);
            tabPane.getSelectionModel().select(settingsDB);
//            PathDb = tab.getDirectory();
        });

        submenuItem7.setOnAction(event -> {
            SettingsPlug tab = new SettingsPlug();
            tabPane.getTabs().add(tab);
            tabPane.getSelectionModel().select(tab);
        });

        menuItem4.setOnAction(event-> {
            Stage stage = new Stage();
            VBox vlayout = new VBox();
            Scene scene = new Scene(vlayout);
            TextField tf = new TextField("");
            Button export = new Button("export");
            System.out.println(tf.getText());

            vlayout.getChildren().addAll(tf, export);
            stage.setScene(scene);
            export.setOnAction(event1->{
                LaporanExporter exporter = new LaporanExporter(dataStore.getTransactionHolder(),tf.getText());
                exporter.start();
//                while(!exporter.isCompleted()){
//                    try{
//                        Thread.sleep(10000);
//                    }catch (RuntimeException | InterruptedException e){
//                        e.printStackTrace();
//                    }
//                }
            });
            stage.showAndWait();
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
    @Override
    public void stop(){
        try {
            this.dataStore.write(settingsDB.getDirectory());
            super.stop();
        }catch (Exception e){
            System.out.println(e);
        }

    }

}