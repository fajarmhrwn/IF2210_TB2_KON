module com.kon.bnmo {
    requires javafx.controls;
    requires javafx.fxml;
    requires itextpdf;
        requires org.controlsfx.controls;
            requires com.dlsc.formsfx;
                    requires org.kordamp.bootstrapfx.core;
    requires com.fasterxml.jackson.databind;

    opens com.kon.bnmo to javafx.fxml;
    exports com.kon.bnmo;
    exports com.kon.bnmo.items;
    opens com.kon.bnmo.items to javafx.fxml;
    exports com.kon.bnmo.cashier;
    opens com.kon.bnmo.cashier to javafx.fxml;
    opens com.kon.bnmo.datastore to com.fasterxml.jackson.databind;
}