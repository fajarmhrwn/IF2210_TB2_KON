package com.kon.bnmo;

import com.kon.bnmo.items.Item;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class CheckoutTab extends Application {

    @Override
    public void start(Stage stage) {

        // Create a table to display the items in the cart
        TableView<Item> table = new TableView<>();
        table.setEditable(true);
        table.setPrefWidth(400);

        // Define the columns of the table
        TableColumn<Item, String> nameCol = new TableColumn<>("Name");
        nameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        TableColumn<Item, Double> priceCol = new TableColumn<>("Price");
        priceCol.setCellValueFactory(new PropertyValueFactory<>("price"));
        TableColumn<Item, Integer> quantityCol = new TableColumn<>("Quantity");
        quantityCol.setCellValueFactory(new PropertyValueFactory<>("quantity"));
        TableColumn<Item, Double> subtotalCol = new TableColumn<>("Subtotal");
        subtotalCol.setCellValueFactory(new PropertyValueFactory<>("subtotal"));

        // Add the columns to the table
        table.getColumns().addAll(nameCol, priceCol, quantityCol, subtotalCol);

        // Create a label to display the total price of the items in the cart
        Label totalLabel = new Label("Total: $0.00");

        // Create a button to remove the selected item from the cart
        Button removeButton = new Button("Remove");
        removeButton.setOnAction(event -> {
            Item selectedItem = table.getSelectionModel().getSelectedItem();
            if (selectedItem != null) {
                table.getItems().remove(selectedItem);
            }
        });

        // Create a button to clear the cart
        Button clearButton = new Button("Clear");
        clearButton.setOnAction(event -> {
            table.getItems().clear();
            totalLabel.setText("Total: $0.00");
        });

        // Create a horizontal box to hold the buttons
        HBox buttonBox = new HBox(removeButton, clearButton);
        buttonBox.setSpacing(10);

        // Create a border pane to hold the table and the buttons
        BorderPane root = new BorderPane();
        root.setCenter(table);
        root.setBottom(new HBox(totalLabel, buttonBox));
        root.setPrefSize(500, 400);

        // Create a scene and add it to the stage
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Checkout");
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}