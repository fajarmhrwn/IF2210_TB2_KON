package com.kon.bnmo.cashier;

import com.kon.bnmo.items.Item;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;

public class CatalogueContainer extends VBox {
    private Item containedItem;
    private Button addButton;
    private Catalogue catalogue;

    public CatalogueContainer(Item containedItem, Catalogue catalogue) {
        this.containedItem = containedItem;
        this.addButton = new Button("+");
        this.catalogue = catalogue;
    }

    public CatalogueContainer(double v, Item containedItem, Button addButton, Catalogue catalogue) {
        super(v);
        this.containedItem = containedItem;
        this.addButton = addButton;
        this.catalogue = catalogue;
    }

    public CatalogueContainer(Item containedItem, Button addButton, Catalogue catalogue, Node... nodes) {
        super(nodes);
        this.containedItem = containedItem;
        this.addButton = addButton;
        this.catalogue = catalogue;
    }

    public CatalogueContainer(double v, Item containedItem, Button addButton, Catalogue catalogue, Node... nodes) {
        super(v, nodes);
        this.containedItem = containedItem;
        this.addButton = addButton;
        this.catalogue = catalogue;
    }

    public Item getContainedItem() {
        return containedItem;
    }

    public void setContainedItem(Item containedItem) {
        this.containedItem = containedItem;
    }

    public Button getAddButton() {
        return addButton;
    }

    public void setAddButton(Button addButton) {
        this.addButton = addButton;
    }

    public Catalogue getCatalogue() {
        return catalogue;
    }

    public void setCatalogue(Catalogue catalogue) {
        this.catalogue = catalogue;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CatalogueContainer that = (CatalogueContainer) o;

        return (!containedItem.equals(that.containedItem));
    }

    @Override
    public int hashCode() {
        int result = containedItem.hashCode();
        result = 31 * result + addButton.hashCode();
        result = 31 * result + catalogue.hashCode();
        return result;
    }
}
