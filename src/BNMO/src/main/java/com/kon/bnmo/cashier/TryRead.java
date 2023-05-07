package com.kon.bnmo.cashier;

import javafx.scene.image.Image;

import java.io.InputStream;

public class TryRead {

    private String imagePath;

    public TryRead(String imagePath) {
        this.imagePath = imagePath;
        try {
            InputStream inputStream = getClass().getResourceAsStream("/img/image.png");
            assert inputStream != null;
            Image image = new Image(inputStream);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public static void main(String[] args) {
        TryRead tryRead = new TryRead("/image.png");
    }
}
