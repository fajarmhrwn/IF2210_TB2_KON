package com.kon.bnmo.cashier;

import com.kon.bnmo.items.Item;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;

import java.io.InputStream;

public class CatalogueContainer extends HBox {
    private Item containedItem;
    private Button addButton;
    private Catalogue catalogue;

    public CatalogueContainer(Item containedItem, Catalogue catalogue) {
        this.containedItem = containedItem;
        InputStream stream = getClass().getResourceAsStream("/img/" + containedItem.getImgName());
        if (stream == null) {
            stream = getClass().getResourceAsStream("/img/image.png");
        }
        assert stream != null;
        ImageView imageView = new ImageView(new Image(stream));
        imageView.setFitHeight(50);
        imageView.setFitWidth(50);

        Label itemName = new Label(this.containedItem.getName());
        itemName.setWrapText(false);
        itemName.setMinWidth(700);
        this.addButton = new Button("+ Add Item");
        this.catalogue = catalogue;
        this.getChildren().addAll(imageView, itemName, this.addButton);
        this.setAlignment(Pos.CENTER_RIGHT);
        this.addButton.setOnAction(this::addToBill);
    }

    private void addToBill(ActionEvent actionEvent) {
        BillContainer billContainer = this.catalogue
        .getMainPanel().getCashier().getSidePanel()
                .getBc();
        if (!billContainer.getBillHolder().getList().contains(new com.kon.bnmo.cashier.ItemContainer(this.containedItem, billContainer))) {
           billContainer.addItem(new com.kon.bnmo.cashier.ItemContainer(this.containedItem, billContainer));
           billContainer.getSidePanel().setPrice();
        }
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

    public Catalogue getCatalogue() {
        return catalogue;
    }

    public void setCatalogue(Catalogue catalogue) {
        this.catalogue = catalogue;
    }

    public void enableAddButton() {
        this.addButton.setDisable(false);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CatalogueContainer that = (CatalogueContainer) o;

        return (containedItem.equals(that.containedItem));
    }

    @Override
    public int hashCode() {
        int result = containedItem.hashCode();
        result = 31 * result + addButton.hashCode();
        result = 31 * result + catalogue.hashCode();
        return result;
    }
}
