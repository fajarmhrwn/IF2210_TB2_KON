package  com.kon.bnmo;
import com.kon.bnmo.cashier.CashierSidePanel;
import com.kon.bnmo.cashier.ItemContainer;
import javafx.beans.property.SimpleStringProperty;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.scene.control.TableView;
import javafx.scene.control.TableColumn;

public class Checkout extends Stage {

    private TableView<com.kon.bnmo.cashier.ItemContainer> table;
    private Label totalLabel;
    private CashierSidePanel sidePanel;

    public Checkout(CashierSidePanel sidePanel) {
        this.sidePanel = sidePanel;
        setTitle("Checkout");

        // Create a table to display the items in the cart
        table = new TableView<>();
        table.setEditable(true);
        table.setPrefWidth(400);

        // Define the columns of the table
        TableColumn<ItemContainer, String> nameCol = new TableColumn<>("Name");
        nameCol.setCellValueFactory(cellData -> {
            ItemContainer itemContainer = cellData.getValue();
            String category = itemContainer.getContainedItem().getName();
            return new SimpleStringProperty(category);
        });
        TableColumn<ItemContainer, Double> priceCol = new TableColumn<>("Price");
        priceCol.setCellValueFactory(new PropertyValueFactory<>("price"));
        TableColumn<ItemContainer, Integer> quantityCol = new TableColumn<>("Quantity");
        quantityCol.setCellValueFactory(new PropertyValueFactory<>("quantity"));
        TableColumn<ItemContainer, Double> subtotalCol = new TableColumn<>("Subtotal");
        subtotalCol.setCellValueFactory(new PropertyValueFactory<>("subtotal"));

        // Add the columns to the table
        table.getColumns().addAll(nameCol, priceCol, quantityCol, subtotalCol);

        // Create a label to display the total price of the items in the cart
        totalLabel = new Label();

        // Create a button to clear the cart
        Button clearButton = new Button("Clear");
        clearButton.setOnAction(event -> {
            table.getItems().clear();
            updateTotal();
        });

        // Create a horizontal box to hold the buttons
        HBox buttonBox = new HBox(clearButton);
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
    public void addItem(ItemContainer itemContainer) {
    }

    public TableView<ItemContainer> getTable() {
        return table;
    }

    public void updatePrice() {
        this.totalLabel.setText("Total: Rp." + this.sidePanel.getPriceTotal());
    }

    public void setTable(TableView<ItemContainer> table) {
        this.table = table;
    }

    public Label getTotalLabel() {
        return totalLabel;
    }

    public void setTotalLabel(Label totalLabel) {
        this.totalLabel = totalLabel;
    }

    public CashierSidePanel getSidePanel() {
        return sidePanel;
    }

    public void setSidePanel(CashierSidePanel sidePanel) {
        this.sidePanel = sidePanel;
    }
}