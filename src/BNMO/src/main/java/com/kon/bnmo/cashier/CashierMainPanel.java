package com.kon.bnmo.cashier;

import javafx.scene.control.Button;
import javafx.scene.layout.VBox;

public class CashierMainPanel extends VBox {
    private Catalogue catalogue;
    private Button restockButton;

    public CashierMainPanel() {
        this.catalogue = new Catalogue(this);
        this.restockButton = new Button("Restock");
        this.getChildren().addAll(this.catalogue, this.restockButton);
    }

    public Catalogue getCatalogue() {
        return catalogue;
    }

    public void setCatalogue(Catalogue catalogue) {
        this.catalogue = catalogue;
    }

    public Button getRestockButton() {
        return restockButton;
    }

    public void setRestockButton(Button restockButton) {
        this.restockButton = restockButton;
    }
}
