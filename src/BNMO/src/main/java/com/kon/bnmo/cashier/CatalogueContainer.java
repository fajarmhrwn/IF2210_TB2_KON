package com.kon.bnmo.cashier;

import com.kon.bnmo.items.Item;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;

import java.io.InputStream;
import java.util.Objects;

public class CatalogueContainer extends HBox {
    private Item containedItem;
    private Button addButton;
    private Catalogue catalogue;

    public CatalogueContainer(Item containedItem, Catalogue catalogue) {
        this.containedItem = containedItem;
        ImageView image = new ImageView(new Image("D:\\ITB\\Semester 4\\Object Oriented Programming\\Tubes2\\src\\BNMO\\src\\main\\java\\com\\kon\\bnmo\\cashier\\image.png"));
        image.setFitHeight(50);
        image.setFitWidth(50);

        Label itemName = new Label(this.containedItem.getName());
        itemName.setWrapText(false);
        itemName.setMinWidth(700);
        this.addButton = new Button("+ Add Item");
        this.catalogue = catalogue;
        this.getChildren().addAll(image, itemName, this.addButton);
        this.setAlignment(Pos.CENTER_RIGHT);
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
