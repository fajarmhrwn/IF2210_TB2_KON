package com.kon.bnmo.cashier;

import com.kon.bnmo.items.Item;
import javafx.event.ActionEvent;
import javafx.scene.control.Tab;
import javafx.scene.layout.HBox;

import javax.xml.catalog.Catalog;
import java.util.Arrays;
import java.util.List;

public class Cashier extends Tab {
    private CashierMainPanel mainPanel;
    private CashierSidePanel sidePanel;
    private String customerName;

    public Cashier(String customerName) {
        super("Cashier: " + customerName);
        this.customerName = customerName;

        this.mainPanel = new CashierMainPanel(this);
        this.mainPanel.setPrefWidth(850);

        Item myBalls = new Item("Balls", 50000.0, "Makanan", "", 3);
        Item mawutSosis = new Item("Boll", 50000.0, "Makanan", "", 3);
        Item mawut = new Item("Nasi Goreng", 50000.0, "Makanan", "", 3);
        Item serundeng = new Item("Ayam Serundeng", 50000.0, "Makanan", "", 3);
        Item matah = new Item("Nasi Ayam Sambal Matah", 50000.0, "Makanan", "", 3);

        CatalogueContainer myBallsCatalogue = new CatalogueContainer(myBalls, mainPanel.getCatalogue());
        CatalogueContainer mawutSosisCatalogue = new CatalogueContainer(mawutSosis, mainPanel.getCatalogue());
        CatalogueContainer mawutCatalogue = new CatalogueContainer(mawut, mainPanel.getCatalogue());
        CatalogueContainer serundengCatalogue = new CatalogueContainer(serundeng, mainPanel.getCatalogue());
        CatalogueContainer matahCatalogue = new CatalogueContainer(matah, mainPanel.getCatalogue());
        mainPanel.getCatalogue().addItem(myBallsCatalogue);
        mainPanel.getCatalogue().addItem(mawutSosisCatalogue);
        mainPanel.getCatalogue().addItem(mawutCatalogue);
        mainPanel.getCatalogue().addItem(serundengCatalogue);
        mainPanel.getCatalogue().addItem(matahCatalogue);

        this.sidePanel = new CashierSidePanel(this);
        ItemContainer containMyBalls = new ItemContainer(myBalls, sidePanel.getBc());
        ItemContainer containMawut = new ItemContainer(mawutSosis, sidePanel.getBc());
        ItemContainer containM = new ItemContainer(mawut, sidePanel.getBc());
        ItemContainer containSerundeng = new ItemContainer(serundeng, sidePanel.getBc());
        ItemContainer containMatah = new ItemContainer(matah, sidePanel.getBc());
        sidePanel.getBc().addItem(containMyBalls);
        sidePanel.getBc().addItem(containMawut);
        sidePanel.getBc().addItem(containM);
        sidePanel.getBc().addItem(containSerundeng);
        sidePanel.getBc().addItem(containMatah);
        sidePanel.setPrice();

        this.getSidePanel().getAddCustomer().setOnAction(this::addNewCustomerTab);

        HBox container = new HBox();
        container.getChildren().addAll(this.mainPanel, sidePanel);
        this.setContent(container);
    }

    private void addNewCustomerTab(ActionEvent actionEvent) {
        List<String> customerList = Arrays.asList("Nawwar", "Ulung", "Zaki");
        NewCustomer newPage = new NewCustomer(customerList);
        this.getTabPane().getTabs().add(newPage);
        this.getTabPane().getSelectionModel().select(newPage);
    }

    public CashierSidePanel getSidePanel() {
        return sidePanel;
    }

    public void setSidePanel(CashierSidePanel sidePanel) {
        this.sidePanel = sidePanel;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public CashierMainPanel getMainPanel() {
        return mainPanel;
    }

    public void setMainPanel(CashierMainPanel mainPanel) {
        this.mainPanel = mainPanel;
    }
}


