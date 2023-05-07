package com.kon.bnmo;

import com.kon.bnmo.datastore.DataStore;
import com.kon.bnmo.datastore.JSONDataAdapter;
import com.kon.bnmo.datastore.OBJDataAdapter;
import com.kon.bnmo.datastore.XMLDataAdapter;
import javafx.geometry.Pos;
import javafx.scene.control.Tab;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.DirectoryChooser;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import javafx.scene.control.ComboBox;


public class SettingsDB extends Tab {
    private String directory;

    private DataStore dataStore;

    private  String extension;
//    private String extension;
    private Label exception;

    public SettingsDB() {
        setText("Setting Database");
        exception = new Label(" ");

        // Membuat VBox sebagai kontainer untuk semua elemen UI
        VBox root = new VBox();

        // Membuat Label untuk judul direktori penyimpanan
        Label directoryLabel = new Label("Directory Penyimpanan");

        // Membuat Button untuk mengganti direktori penyimpanan
        Button directoryButton = new Button("Pilih Direktori");

        directoryButton.setOnAction(event -> {
            DirectoryChooser directoryChooser = new DirectoryChooser();
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
            dataStore = new DataStore();
            if(extension == ".xml"){
                System.out.println("masuk");

                dataStore.setDataAdapter(new XMLDataAdapter());
                try{
                    dataStore.read(directory);
                }  catch(FileNotFoundException e){
                    exception.setText(e.getMessage());
                }catch (IOException e) {
                    exception.setText(e.getMessage());
                    throw new RuntimeException(e);
                }
            }else if(extension == ".json"){
                dataStore.setDataAdapter(new JSONDataAdapter());
                try{
                    dataStore.read(directory);
                }  catch(FileNotFoundException e){
                    exception.setText(e.getMessage());
                }catch (IOException e) {
                    exception.setText(e.getMessage());
                    throw new RuntimeException(e);
                }


            }else if(extension == ".obj"){
                dataStore.setDataAdapter(new OBJDataAdapter());
                try{
                    dataStore.read(directory);
                } catch(FileNotFoundException e){
                    exception.setText(e.getMessage());
                } catch (IOException e) {
                    exception.setText(e.getMessage());
                    throw new RuntimeException(e);
                }
            }
            dataStore.printCustomerHolder();
            dataStore.printItemHolder();
            dataStore.printTransactionHolder();
        });

// Menambahkan Label dan Button ke dalam VBox
        root.getChildren().addAll(imporlabel, Impor, exception);

    }

    public DataStore getDataStore() {
        return dataStore;
    }
}
