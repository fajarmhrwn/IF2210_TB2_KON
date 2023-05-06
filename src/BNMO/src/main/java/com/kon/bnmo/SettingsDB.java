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
import java.io.IOException;

import javafx.scene.control.ComboBox;


public class SettingsDB extends Tab {
    private String directory;

    private DataStore dataStore;
//    private String extension;

    public SettingsDB() {
        setText("Setting Database");

        // Membuat VBox sebagai kontainer untuk semua elemen UI
        VBox root = new VBox();

        // Membuat Label untuk judul direktori penyimpanan
        Label directoryLabel = new Label("Directory Penyimpanan");

        // Membuat Button untuk mengganti direktori penyimpanan
        Button directoryButton = new Button("Pilih Direktori");


        // Membuat dropdown untuk memilih ekstensi file
        ComboBox<String> extensionDropdown = new ComboBox<>();
        extensionDropdown.getItems().addAll(".xml", ".json", ".obj");
        extensionDropdown.setOnAction(event -> {
            String selectedExtension = extensionDropdown.getValue();
            dataStore = new DataStore();
//            if(selectedExtension == ".xml"){
//                System.out.println("masuk");
//
//                dataStore.setDataAdapter(new XMLDataAdapter());
//                try{
//                    dataStore.readItem(directory);
//                } catch (IOException e) {
//                    throw new RuntimeException(e);
//                }
//            }else if(selectedExtension == ".json"){
//                dataStore.setDataAdapter(new JSONDataAdapter());
//                try{
////                    dataStore.readItem(directory);
//                } catch (IOException e) {
//                    throw new RuntimeException(e);
//                }
//            }else if(selectedExtension == ".obj"){
//                dataStore.setDataAdapter(new OBJDataAdapter());
//                try{
//                    dataStore.readItem(directory);
//                } catch (IOException e) {
//                    throw new RuntimeException(e);
//                }
//            }
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

        directoryButton.setOnAction(event -> {
            DirectoryChooser directoryChooser = new DirectoryChooser();
            File selectedDirectory = directoryChooser.showDialog(null);
            if (selectedDirectory != null) {
                directoryChooser.setInitialDirectory(selectedDirectory);
                System.out.println(selectedDirectory.toString());
                directory = selectedDirectory.toString();
                // Mengupdate direktori penyimpanan
//                if(selectedExtension)
            }
        });

        // Menambahkan Label dan Button ke dalam VBox
        root.getChildren().addAll(directoryLabel, directoryButton);

        // Menambahkan VBox ke dalam Tab
        setContent(root);

        Label pluginLabel = new Label("Plugin");

// Membuat Button untuk mengimpor plugin
        Button pluginButton = new Button("Impor Plugin");
        pluginButton.setOnAction(event -> {
            FileChooser fileChooser = new FileChooser();
            fileChooser.setTitle("Pilih File Plugin");
            fileChooser.getExtensionFilters().add(new ExtensionFilter(".jar", "*.jar"));
            File selectedFile = fileChooser.showOpenDialog(null);
            if (selectedFile != null) {
                // Mengimpor plugin
            }
        });

// Menambahkan Label dan Button ke dalam VBox
        root.getChildren().addAll(pluginLabel, pluginButton);
    }

    public DataStore getDataStore() {
        return dataStore;
    }
}
