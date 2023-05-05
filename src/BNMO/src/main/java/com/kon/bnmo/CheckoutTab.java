package  com.kon.bnmo;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.scene.control.TableView;
import javafx.scene.control.TableColumn;

public class CheckoutTab extends Stage {

    private TableView<Item> table;
    private Label totalLabel;

    public CheckoutTab() {
        setTitle("Checkout");

        // Create a table to display the items in the cart
        table = new TableView<>();
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
        totalLabel = new Label("Total: $0.00");
        totalLabel.setFont(new Font(20));

        // Create a button to remove the selected item from the cart
        Button removeButton = new Button("Remove");
        removeButton.setOnAction(event -> {
            Item selectedItem = table.getSelectionModel().getSelectedItem();
            if (selectedItem != null) {
                table.getItems().remove(selectedItem);
                updateTotal();
            }
        });

        // Create a button to clear the cart
        Button clearButton = new Button("Clear");
        clearButton.setOnAction(event -> {
            table.getItems().clear();
            updateTotal();
        });

        // Create a horizontal box to hold the buttons
        HBox buttonBox = new HBox(removeButton, clearButton);
        buttonBox.setSpacing(10);

        // Create a border pane to hold the table and the buttons
        BorderPane root = new BorderPane();
        root.setCenter(table);
        root.setBottom(new HBox(totalLabel, buttonBox));
        root.setPadding(new Insets(10));
        root.setPrefSize(500, 400);

        // Create a scene and set it on the stage
        setScene(new Scene(root));
    }
    private void updateTotal() {
    }
    public void addItem(Item item) {
    }
}