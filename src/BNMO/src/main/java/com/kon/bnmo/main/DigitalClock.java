package com.kon.bnmo.main;

import java.text.SimpleDateFormat;
import java.util.Date;

import javafx.application.Platform;
import javafx.scene.control.Label;

public class DigitalClock extends Thread {
    private Label label;
    private SimpleDateFormat dateFormat;

    public DigitalClock() {
        this.dateFormat = new SimpleDateFormat("EEE, d MMMM yyyy\nHH:mm:ss");
    }

    public void bindLabel(Label label) {
        this.label = label;
    }
    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(1000); // wait for 1 second
                Platform.runLater(() -> label.setText(dateFormat.format(new Date()))); // update UI in JavaFX thread
                System.out.println("Clock updated");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
