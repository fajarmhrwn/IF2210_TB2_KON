package com.kon.bnmo.cashier;

import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;

import java.util.Objects;

public class ImageContainer extends VBox {

    private ImageView image;
    private Label imageCaption;

    public ImageContainer() {
        this.image = new ImageView(new Image(Objects.requireNonNull(
                ImageContainer.class.getResourceAsStream("/img/placeholder.png")
        )));
        this.imageCaption = new Label("");
    }

    public ImageContainer(String imageCaption) {
        this.image = new ImageView(new Image(Objects.requireNonNull(
                ImageContainer.class.getResourceAsStream("/img/placeholder.png")
        )));
        this.imageCaption = new Label(imageCaption);
    }

    public ImageContainer(String imagePath, String imageCaption) {
        this.image = new ImageView(new Image(Objects.requireNonNull(
                ImageContainer.class.getResourceAsStream("/img/" + imagePath)
        )));
        this.imageCaption = new Label(imageCaption);
    }

    public ImageView getImage() {
        return image;
    }

    public void setImage(ImageView image) {
        this.image = image;
    }

    public Label getImageCaption() {
        return imageCaption;
    }

    public void setImageCaption(Label imageCaption) {
        this.imageCaption = imageCaption;
    }
}
