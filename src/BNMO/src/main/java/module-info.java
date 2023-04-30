module com.kon.bnmo {
    requires javafx.controls;
    requires javafx.fxml;
            
        requires org.controlsfx.controls;
            requires com.dlsc.formsfx;
                    requires org.kordamp.bootstrapfx.core;
            
    opens com.kon.bnmo to javafx.fxml;
    exports com.kon.bnmo;
}