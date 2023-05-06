package com.kon.bnmo.cashier;

import com.kon.bnmo.items.Item;
import com.kon.bnmo.items.Storage;
import javafx.scene.Node;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.VBox;

public class Catalogue extends ScrollPane {
    private Storage storage;
    private VBox vBox;
    private CashierMainPanel mainPanel;

    public Catalogue(CashierMainPanel mainPanel) {
        this.storage = new Storage();
        this.mainPanel = mainPanel;
        this.vBox = new VBox();
        this.setContent(this.vBox);

    }

    public void addItem(CatalogueContainer item) {
        this.storage.add(item);
        this.vBox.getChildren().add(new CatalogueContainer(item.getContainedItem(), this));
        this.setContent(this.vBox);
    }

    public void removeItem(String name, double price, String category, String imgName, Integer stock) {
        this.storage.remove(new CatalogueContainer(new Item(name, price, category, imgName, stock), this));
        this.vBox.getChildren().remove(new CatalogueContainer(new Item(name, price, category, imgName, stock), this));
        this.setContent(this.vBox);
    }

    public Catalogue(Storage storage, VBox vBox, CashierMainPanel mainPanel) {
        this.storage = storage;
        this.vBox = vBox;
        this.mainPanel = mainPanel;
    }

    public Catalogue(Node node, Storage storage, VBox vBox, CashierMainPanel mainPanel) {
        super(node);
        this.storage = storage;
        this.vBox = vBox;
        this.mainPanel = mainPanel;
    }

    public Storage getStorage() {
        return storage;
    }

    public void setStorage(Storage storage) {
        this.storage = storage;
    }

    public VBox getvBox() {
        return vBox;
    }

    public void setvBox(VBox vBox) {
        this.vBox = vBox;
    }

    public CashierMainPanel getMainPanel() {
        return mainPanel;
    }

    public void setMainPanel(CashierMainPanel mainPanel) {
        this.mainPanel = mainPanel;
    }
}
