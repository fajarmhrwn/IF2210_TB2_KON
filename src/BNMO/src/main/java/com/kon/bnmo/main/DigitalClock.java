package com.kon.bnmo.main;

import java.text.SimpleDateFormat;
import java.util.Date;

import javafx.application.Platform;
import javafx.scene.control.Label;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class DigitalClock extends Thread {
    private Label label;
    private SimpleDateFormat dateFormat;

    public DigitalClock() {
        this.dateFormat = new SimpleDateFormat("EEE, d MMMM yyyy\nHH:mm:ss");
    }

    public void bindLabel(Label label) {
        this.label = label;
        label.setFont(Font.font("Arial", FontWeight.EXTRA_BOLD, 32));
    }
    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(1000); // wait for 1 second
                Platform.runLater(() -> label.setText(dateFormat.format(new Date()))); // update UI in JavaFX thread
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
