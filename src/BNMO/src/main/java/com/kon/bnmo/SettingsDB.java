package com.kon.bnmo;

import com.kon.bnmo.datastore.*;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Tab;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.DirectoryChooser;

import java.io.File;
import java.io.IOException;

import javafx.scene.control.ComboBox;
import javafx.stage.Stage;


public class SettingsDB extends Tab {
    private String directory;

    private DataStore dataStore;

    private  String extension;
//    private String extension;
    private Label exception;

    public SettingsDB(DataStore other, MainApplication mainApplication){
        this.dataStore = other;
        setText("Setting Database");
        exception = new Label(" ");

        // Membuat VBox sebagai kontainer untuk semua elemen UI
        VBox root = new VBox();

        // Membuat Label untuk judul direktori penyimpanan
        Label directoryLabel = new Label("Directory Penyimpanan");

        // Membuat Button untuk mengganti direktori penyimpanan
        Button directoryButton = new Button("Pilih Direktori");

        directoryButton.setOnAction(event -> {
            File initialDirectory = new File("DataStore");
            DirectoryChooser directoryChooser = new DirectoryChooser();
            directoryChooser.setInitialDirectory(initialDirectory);
            File selectedDirectory = directoryChooser.showDialog(null);
            if (selectedDirectory != null) {
                directoryChooser.setInitialDirectory(selectedDirectory);
                System.out.println(selectedDirectory.toString());
                directory = selectedDirectory.toString();
                System.out.println(directory);
                // Mengupdate direktori penyimpanan
//                if(selectedExtension)
            }
        });

        // Menambahkan Label dan Button ke dalam VBox
        root.getChildren().addAll(directoryLabel, directoryButton);

        // Membuat dropdown untuk memilih ekstensi file
        ComboBox<String> extensionDropdown = new ComboBox<>();
        extensionDropdown.getItems().addAll(".xml", ".json", ".obj");
        extensionDropdown.setOnAction(event -> {
            extension = extensionDropdown.getValue();

            // melakukan aksi ketika ekstensi dipilih
        });
        GridPane extensionGrid = new GridPane();
        extensionGrid.setVgap(10);
        extensionGrid.setHgap(10);
        extensionGrid.setAlignment(Pos.CENTER_LEFT);
        extensionGrid.add(new Label("File extension:"), 0, 0);
        extensionGrid.add(extensionDropdown, 1, 0);

        // Menambahkan GridPane ke dalam VBox
        root.getChildren().addAll(extensionGrid);

        // Menambahkan VBox ke dalam Tab
        setContent(root);

        Label imporlabel = new Label("import data");

// Membuat Button untuk mengimpor plugin
        Button Impor = new Button("Impor data");
        Impor.setOnAction(event -> {
                dataStore.setDataAdapter(createAdapter(extension));
                try{
                    dataStore.read(directory);
                }catch (IOException e) {
                    Stage ex = new Stage();
                    ex.setWidth(300);
                    ex.setHeight(200);
                    Label label = new Label("Folder dan ekstensi yang dipilih ga sesuai!");
                    Scene scene = new Scene(label);
                    ex.setScene(scene);
                    ex.show();
                    throw new RuntimeException(e);
                }

            dataStore.printCustomerHolder();
            dataStore.printItemHolder();
            dataStore.printTransactionHolder();
            mainApplication.updateUI();
        });
//        exception.setText("konto");

// Menambahkan Label dan Button ke dalam VBox
        root.getChildren().addAll(imporlabel, Impor);
    }

    public DataStore getDataStore() {
        return dataStore;
    }
    public String getDirectory(){
        return this.directory;
    }
    public DataAdapter createAdapter(String extension){
        if(extension == ".obj"){
            return new OBJDataAdapter();
        }
        else if(extension == ".json"){
            return new JSONDataAdapter();
        }
        else if(extension == ".obj"){
            return  new OBJDataAdapter();
        }
        return null;
    }
}
