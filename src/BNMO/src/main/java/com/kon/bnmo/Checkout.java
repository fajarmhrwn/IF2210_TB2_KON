package  com.kon.bnmo;
import com.kon.bnmo.cashier.Cashier;
import com.kon.bnmo.cashier.CashierSidePanel;
import com.kon.bnmo.cashier.ItemContainer;
import com.kon.bnmo.cashier.SuccessfulPayment;
import com.kon.bnmo.items.Billitem;
import com.kon.bnmo.sistembarang.SistemBarang;
import com.kon.bnmo.transaction.Transaction;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.scene.control.TableView;
import javafx.scene.control.TableColumn;

import java.time.LocalDate;

public class Checkout extends Stage {

    private TableView<ItemContainer> table;
    private Label totalLabel;
    private CashierSidePanel sidePanel;
    private SuccessfulPayment successfulPayment;

    public Checkout(CashierSidePanel sidePanel) {
        this.sidePanel = sidePanel;
        this.successfulPayment = null;
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
        priceCol.setCellValueFactory(new PropertyValueFactory<>("buyingPrice"));
        TableColumn<ItemContainer, Integer> quantityCol = new TableColumn<>("Quantity");
        quantityCol.setCellValueFactory(new PropertyValueFactory<>("amount"));
        TableColumn<ItemContainer, Double> subtotalCol = new TableColumn<>("Subtotal");
        subtotalCol.setCellValueFactory(cellData -> {
            ItemContainer item = cellData.getValue();
            Double price = item.getBuyingPrice();
            int amount = item.getAmount();
            return new SimpleDoubleProperty(price * amount).asObject();
        });

        // Add the columns to the table
        table.getColumns().addAll(nameCol, priceCol, quantityCol, subtotalCol);

        // Create a label to display the total price of the items in the cart
        totalLabel = new Label();

        // Create a button to clear the cart
        Button buyButton = new Button("Buy");
        buyButton.setOnAction(this::buyProduct);

        // Create a horizontal box to hold the buttons
        HBox buttonBox = new HBox(buyButton);
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

    private void buyProduct(ActionEvent actionEvent) {
        // Update item holder pada catalogue serta pada cashier
        Transaction fixedBill = new Transaction();
        for (ItemContainer ic: this.getSidePanel().getBc().getBillHolder().getList()) {
            for (Tab tab:
                    this.getSidePanel().getThisParent().getTabPane().getTabs()) {
                if (tab.getText().contains("Cashier:")) {
                    Cashier cashier = (Cashier) tab;
                    cashier.getSidePanel().getBc().updateBillContainer(ic.getContainedItem(), ic.getContainedItem().getStock() - ic.getAmount());
                    cashier.getMainPanel().getCatalogue().updateCatalogue();
                    cashier.getMainPanel().getSistemBarang().updateUI();
                }
            }
            fixedBill.getListBillItem().add(new Billitem(ic));
        }
        this.successfulPayment = new SuccessfulPayment(fixedBill);
        fixedBill.setIdCustomer(Integer.parseInt(this.sidePanel.getThisParent().getCustomerName().getId()));
        MainApplication mainApplication = (MainApplication) this.sidePanel.getThisParent().getMainClass();
        mainApplication.getDataStore().getTransactionHolder().getList().add(fixedBill);
        this.close();
        this.successfulPayment.show();
    }

    private void updateTotal() {
    }
    public void addItem(ItemContainer itemContainer) {
    }

    public TableView<ItemContainer> getTable() {
        return table;
    }

    public void updateTable() {
        this.table.getItems().clear();
        ObservableList<ItemContainer> items = FXCollections.observableArrayList();
        items.addAll(this.sidePanel.getBc().getBillHolder().getList());
        this.table.setItems(items);
    }

    public void updatePrice() {
        MainApplication mainApplication = (MainApplication) this.sidePanel.getThisParent().getMainClass();
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

    public SuccessfulPayment getSuccessfulPayment() {
        return successfulPayment;
    }

    public void setSuccessfulPayment(SuccessfulPayment successfulPayment) {
        this.successfulPayment = successfulPayment;
    }
}