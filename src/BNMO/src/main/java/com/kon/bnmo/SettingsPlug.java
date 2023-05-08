package com.kon.bnmo;

import com.kon.bnmo.datastore.DataStore;
import com.kon.bnmo.datastore.JSONDataAdapter;
import com.kon.bnmo.datastore.OBJDataAdapter;
import com.kon.bnmo.datastore.XMLDataAdapter;
import com.kon.bnmo.plugin.loader;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.DirectoryChooser;
import javafx.stage.FileChooser;

import java.io.File;
import java.io.IOException;
import java.nio.file.*;

public class SettingsPlug extends Tab {
    private String FilePath;
    public SettingsPlug(TabPane tabPane, DataStore dataStore){
        setText("Setting Plugin");

        // Membuat VBox sebagai kontainer untuk semua elemen UI
        VBox root = new VBox();

        // Menambahkan VBox ke dalam Tab
        setContent(root);

        Label pluginLabel = new Label();

        // Membuat Button untuk mengimpor plugin
        Button pluginButton = new Button("Impor Plugin");
        pluginButton.setOnAction(event -> {
            FileChooser fileChooser = new FileChooser();
            fileChooser.setTitle("Pilih File Plugin");
            fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter(".jar", "*.jar"));
            File selectedFile = fileChooser.showOpenDialog(null);
            if (selectedFile != null) {
                String fileSource = selectedFile.getAbsolutePath();
                String target = System.getProperty("user.dir") + "\\src\\BNMO\\src\\main\\java\\com\\kon\\bnmo\\plugin";
                System.out.println(target);
//                try {
//                    Path filePath = Paths.get(fileSource);
//                    Path destinationPath = Paths.get(target);
//                    if (Files.exists(filePath)){
//                        System.out.println("File exists");
//                        Files.copy(filePath, destinationPath.resolve(filePath.getFileName().toString()), StandardCopyOption.REPLACE_EXISTING);
//                    }else{
//                        System.out.println("File doesn't exist");
//                    }
//                }catch (IOException e) {
//                    e.printStackTrace();
//                }
                FilePath = selectedFile.toString();
                pluginLabel.setText(selectedFile.toString());
            }
        });
        Button pluginButton2 = new Button("Gas");

        pluginButton2.setOnAction(event -> {
            Tab tab = new Tab("Plugin");
            loader loader = new loader(tab, dataStore,FilePath);
            tabPane.getTabs().add(tab);
            System.out.println("Plugin Loaded");
        });
// Menambahkan Label dan Button ke dalam VBox
        root.getChildren().addAll(pluginLabel, pluginButton,pluginButton2);
    }

    public String getFilePath() {
        return FilePath;
    }
}
