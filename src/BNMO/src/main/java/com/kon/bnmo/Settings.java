package com.kon.bnmo;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import javafx.scene.control.Alert;

public class Settings extends Tab {

    private TextField directoryField;
    private TextField formatField;

    public Settings() {
        this.setText("Settings");

        // create UI elements
        Label directoryLabel = new Label("File Directory:");
        directoryField = new TextField();
        directoryField.setPromptText("Enter directory path");

        Label formatLabel = new Label("File Format:");
        formatField = new TextField();
        formatField.setPromptText("Enter file format");

        Button saveButton = new Button("Save");

        // create layout
        GridPane gridPane = new GridPane();
        gridPane.setHgap(10);
        gridPane.setVgap(10);
        gridPane.setPadding(new Insets(10, 10, 10, 10));
        gridPane.setAlignment(Pos.CENTER);

        gridPane.add(directoryLabel, 0, 0);
        gridPane.add(directoryField, 1, 0);
        gridPane.add(formatLabel, 0, 1);
        gridPane.add(formatField, 1, 1);

        HBox buttonBox = new HBox();
        buttonBox.setAlignment(Pos.CENTER_RIGHT);
        buttonBox.getChildren().add(saveButton);
        gridPane.add(buttonBox, 1, 2);

        VBox vbox = new VBox();
        vbox.getChildren().addAll(gridPane);
        this.setContent(vbox);

        File storageLocation = new File("C:\\Data");
        // set save button action
        saveButton.setOnAction(event -> {
            String directory = directoryField.getText();
            String format = formatField.getText();

            // save directory and format to settings file or database
            File settingsFile = new File("settings.txt");
            try (PrintWriter writer = new PrintWriter(settingsFile)) {
                writer.println("Directory:" + storageLocation.getAbsolutePath());
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }



            // show confirmation message
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Settings Saved");
            alert.setHeaderText(null);
            alert.setContentText("Your settings have been saved successfully.");
            alert.showAndWait();
        });
    }

}


