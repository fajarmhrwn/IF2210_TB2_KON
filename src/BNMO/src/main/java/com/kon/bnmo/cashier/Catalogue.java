package com.kon.bnmo.cashier;

import com.kon.bnmo.items.Item;
import com.kon.bnmo.items.ItemHolder;
import com.kon.bnmo.items.Storage;
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
//        DataStore dataStore = new DataStore();
//        dataStore.setDataAdapter(new JSONDataAdapter());
//        try {
//            dataStore.readItem("items.json");
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//        ItemHolder itemHolder = dataStore.getItemHolder();
        this.availableItems = availableItems;
        for (Item item : availableItems.getItemList()) {
            this.addItem(new CatalogueContainer(item, this));
        }
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
