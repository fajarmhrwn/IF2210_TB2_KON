package com.kon.bnmo.main;

import com.kon.bnmo.main.DigitalClock;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.time.LocalTime;

public class LayarUtama extends Tab {

    private Label time ;
    private static final DigitalClock digitalClock = new DigitalClock();

    public LayarUtama() {
        BorderPane borderPane = new BorderPane();
        time = new Label();
        digitalClock.bindLabel(time);
        digitalClock.start();
        borderPane.setCenter(time);


        this.setContent(borderPane);
    }

}
