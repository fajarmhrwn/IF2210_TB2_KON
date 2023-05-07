package com.kon.bnmo.cashier;

import com.kon.bnmo.items.Item;
import com.kon.bnmo.items.ItemHolder;
import com.kon.bnmo.items.Storage;
import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.VBox;

public class Catalogue extends ScrollPane {
    private Storage storage;
    private VBox vBox;
    private CashierMainPanel mainPanel;
    private ItemHolder availableItems;

    public Catalogue(CashierMainPanel mainPanel, ItemHolder availableItems) {
        this.storage = new Storage();
        this.mainPanel = mainPanel;
        this.vBox = new VBox();

        this.availableItems = availableItems;
        for (Item item : availableItems.getList()) {
            this.addItem(new CatalogueContainer(item, this));
        }
        this.setContent(this.vBox);
    }

    public void addItem(CatalogueContainer item) {
        this.storage.add(item);
        this.vBox.getChildren().add(new CatalogueContainer(item.getContainedItem(), this));
        this.setContent(this.vBox);
    }

    public void updateCatalogue() {
        this.clearContent();
        VBox newVBox = new VBox();
        for (Item item : availableItems.getList()) {
            this.storage.add(new CatalogueContainer(item, this));
            newVBox.getChildren().add(new CatalogueContainer(item, this));
        }
        this.setContent(newVBox);
        this.vBox = newVBox;
    }

    public void clearContent() {
        this.storage.getList().clear();
    }

    public void removeItem(String name, double price, String category, String imgName, Integer stock) {
        this.storage.remove(new CatalogueContainer(new Item(name, price, category, imgName, stock), this));
        this.vBox.getChildren().remove(new CatalogueContainer(new Item(name, price, category, imgName, stock), this));
        this.setContent(this.vBox);
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

    public ItemHolder getAvailableItems() {
        return availableItems;
    }

    public void setAvailableItems(ItemHolder availableItems) {
        this.availableItems = availableItems;
    }
}
