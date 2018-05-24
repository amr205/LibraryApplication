package sample.controller;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import sample.database.model.Book;

import java.net.URL;
import java.util.ResourceBundle;

public class BookElementController implements Initializable {

    @FXML
    ImageView imageView;

    @FXML
    VBox mainPane;

    @FXML
    Label titleLabel, authorLabel;

    @FXML
    ProgressIndicator progressIndicator;

    @FXML
    StackPane imageStackPane;

    private Book book;

    ShowBooks showBooksController;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        mainPane.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                imageView.setFitWidth(180);
                imageView.setFitHeight(250);
            }
        });

        mainPane.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                imageView.setFitWidth(160);
                imageView.setFitHeight(230);
            }
        });

        mainPane.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                showBooksController.showBookDetails(book);
            }
        });
    }

    public void setBook(Book book) {
        this.book = book;
        titleLabel.setText(book.getName());
        authorLabel.setText(book.getAutor());

        //set Image
        try {
            Image image = new Image(book.getCover(), true);
            image.progressProperty().addListener(new ChangeListener<Number>() {
                @Override
                public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                    if (newValue.floatValue() > .99) {
                        imageStackPane.getChildren().remove(progressIndicator);
                    }
                    if (image.isError()) {
                        book.setImage(new Image("/coverImage.jpg", true));
                        imageView.setImage(new Image("/coverImage.jpg", true));
                    }
                }
            });
            if (!image.isError()) {
                book.setImage(image);
                imageView.setImage(book.getImage());
            }
        }catch (Exception e){
            imageStackPane.getChildren().remove(progressIndicator);
            book.setImage(new Image("/coverImage.jpg", true));
            imageView.setImage(new Image("/coverImage.jpg", true));
        }



    }

    public void setShowBooksController(ShowBooks categoryBooksController) {
        this.showBooksController = categoryBooksController;
    }
}
