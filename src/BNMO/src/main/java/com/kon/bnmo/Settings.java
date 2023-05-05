package com.kon.bnmo;

import javafx.scene.control.Tab;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.DirectoryChooser;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.FileChooser;
import java.io.File;


public class Settings extends Tab {

    public Settings() {
        setText("Setting");

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
                // Mengupdate direktori penyimpanan
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
            fileChooser.getExtensionFilters().add(new ExtensionFilter("File Plugin", "*.jar"));
            File selectedFile = fileChooser.showOpenDialog(null);
            if (selectedFile != null) {
                // Mengimpor plugin
            }
        });

// Menambahkan Label dan Button ke dalam VBox
        root.getChildren().addAll(pluginLabel, pluginButton);
    }
}
