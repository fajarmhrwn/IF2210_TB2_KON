package com.kon.bnmo;

import com.kon.bnmo.datastore.DataStore;
import com.kon.bnmo.datastore.JSONDataAdapter;
import com.kon.bnmo.datastore.OBJDataAdapter;
import com.kon.bnmo.datastore.XMLDataAdapter;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.DirectoryChooser;
import javafx.stage.FileChooser;

import java.io.File;
import java.io.IOException;

public class SettingsPlug extends Tab {
    private String FilePath;
    public SettingsPlug() {
        setText("Setting Plugin");

        // Membuat VBox sebagai kontainer untuk semua elemen UI
        VBox root = new VBox();

        // Menambahkan VBox ke dalam Tab
        setContent(root);

        Label pluginLabel = new Label("Plugin");

        // Membuat Button untuk mengimpor plugin
        Button pluginButton = new Button("Impor Plugin");
        pluginButton.setOnAction(event -> {
            FileChooser fileChooser = new FileChooser();
            fileChooser.setTitle("Pilih File Plugin");
            fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter(".jar", "*.class"));
            File selectedFile = fileChooser.showOpenDialog(null);
            if (selectedFile != null) {
                FilePath = selectedFile.toString();
                System.out.println(selectedFile.toString());
            }
        });

// Menambahkan Label dan Button ke dalam VBox
        root.getChildren().addAll(pluginLabel, pluginButton);
    }

    public String getFilePath() {
        return FilePath;
    }
}
