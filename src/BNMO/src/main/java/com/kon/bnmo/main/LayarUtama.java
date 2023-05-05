package com.kon.bnmo.main;

import com.kon.bnmo.main.DigitalClock;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class LayarUtama extends Tab {

    private Label time ;

    public LayarUtama() {
        GridPane gridPane = new GridPane();
        this.time = new Label();
        DigitalClock digitalClock = new DigitalClock(this.time);
        digitalClock.start();
        gridPane.add(this.time, 0, 0);
        gridPane.setAlignment(Pos.CENTER);
        this.setContent(gridPane);
        this.setText("Home");
    }
}
