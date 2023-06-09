module com.kon.bnmo {
    requires javafx.controls;
    requires javafx.fxml;
    requires itextpdf;
        requires org.controlsfx.controls;
            requires com.dlsc.formsfx;
                    requires org.kordamp.bootstrapfx.core;
    requires com.fasterxml.jackson.databind;
    requires java.xml;

    opens com.kon.bnmo to javafx.fxml;
    exports com.kon.bnmo;
    exports com.kon.bnmo.items;
    opens com.kon.bnmo.items to javafx.fxml;
    exports com.kon.bnmo.cashier;
    opens com.kon.bnmo.cashier to javafx.fxml;
    exports com.kon.bnmo.customers;
    opens com.kon.bnmo.customers to javafx.fxml;
    exports com.kon.bnmo.transaction;
    opens com.kon.bnmo.transaction to javafx.fxml;
    exports com.kon.bnmo.datastore;
    exports com.kon.bnmo.holder;
    exports com.kon.bnmo.sistembarang;
    exports com.kon.bnmo.main;
    exports com.kon.bnmo.plugin;
}