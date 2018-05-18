package sample.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXProgressBar;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import org.controlsfx.control.Rating;
import sample.Main;
import sample.database.MySQL;
import sample.database.model.Book;
import sample.database.model.BookDAO;
import sample.database.model.Category;
import sample.database.model.CategoryDAO;
import sample.utility.DownloadFileFromURL;

import java.io.File;
import java.io.FileOutputStream;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.text.DecimalFormat;
import java.util.Formatter;
import java.util.ResourceBundle;
import java.util.prefs.Preferences;

public class BookDetailsController implements Initializable {

    @FXML
    AnchorPane bookDetailPane;

    @FXML
    Label titleLabel, autorLabel, descriptionLabel, ratingLabel;

    @FXML
    Rating rating;

    @FXML
    Button favoritesButton;

    @FXML
    JFXButton visualizeButton;

    @FXML
    JFXProgressBar progressBar;

    @FXML
    FontAwesomeIconView fontAwesomeFavIcon;

    @FXML
    ProgressIndicator progressIndicator;

    @FXML
    StackPane imageStackPane;

    @FXML
    ImageView imageView;

    @FXML
    HBox progressBarHBox;

    private MainController mainController;

    private Book book;

    private boolean isDownloaded, isFavorite, isRated;
    private BookDAO bookDAO;
    private CategoryDAO categoryDAO;
    private Preferences appPrefs;
    private float calif;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        appPrefs = Preferences.userNodeForPackage(Main.class);
        progressBarHBox.getChildren().remove(progressBar);
        isDownloaded = false;

        bookDAO = new BookDAO(MySQL.getConnection());
        categoryDAO = new CategoryDAO(MySQL.getConnection());


    }

    public void setMainController(MainController mainController) {
        this.mainController = mainController;
    }

    public void setBook(Book _book) {

        this.book = _book;
        titleLabel.setText(book.getName());
        autorLabel.setText(book.getAutor());
        descriptionLabel.setText(book.getReview());


        //setImage
        book.getImage().progressProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                if(newValue.floatValue()>.99) {
                    imageStackPane.getChildren().remove(progressIndicator);
                }
            }
        });
        if(book.getImage().progressProperty().doubleValue()>.99)
            imageStackPane.getChildren().remove(progressIndicator);

        imageView.setImage(book.getImage());

        //check if book exists
        Category category = categoryDAO.findCategory(book.getCategory());
        File f = new File(appPrefs.get("booksPath",System.getProperty("user.home")+"/Books")+"/"+category.getDescCat()+"/"+book.getName()+".pdf");
        if(f.exists() && !f.isDirectory()) {
            isDownloaded = true;
            visualizeButton.setText("Visualize");
        }

        if(Main.user!=null) {
            //check if book is in favorite
            isFavorite = bookDAO.isFavorite(book, Main.user);
            if (isFavorite) {
                favoritesButton.setText("Remove from favorites");
                fontAwesomeFavIcon.setGlyphName("HEART");
            }
            //all about rating
            isRated = bookDAO.isRated(book, Main.user);
            if (isRated) {
                calif=bookDAO.getUserRate(book, Main.user);
            } else {
               calif=book.getCalif();
            }
            rating.setRating(calif);
            ratingLabel.setText(String.format("%.2f", calif));
            rating.ratingProperty().addListener(new ChangeListener<Number>() {
                @Override
                public void changed(ObservableValue<? extends Number> observable,
                                    Number oldValue, Number newValue) {
                    updateRating();
                }
            });
        }
        else{
            favoritesButton.setDisable(true);
            calif=book.getCalif();
            rating.setRating(calif);
            ratingLabel.setText(String.format("%.2f", calif));
            rating.setDisable(true);

            progressBarHBox.getChildren().add(new Label("To rate a book or add to favorites please login"));
        }
    }

    private void updateRating() {
        //update rating table with new rating
        if(!isRated)
            bookDAO.addUserRating(book,Main.user,(int)rating.getRating());
        else
            bookDAO.updateUserRating(book,Main.user,(int)rating.getRating());

        calif=(int)rating.getRating();
        ratingLabel.setText(String.format("%.2f", calif));
        isRated=true;
        //update rating in book with the average
        bookDAO.updateRating(book);
    }

    @FXML
    public void closeBook(){
        StackPane stackPane = mainController.getCenterPane();
        stackPane.getChildren().remove(1);
    }


    public void DownloadAndVisualize(MouseEvent mouseEvent) {
        Category category = categoryDAO.findCategory(book.getCategory());
        if (!isDownloaded) {
            progressBarHBox.getChildren().add(progressBar);



            DownloadFileFromURL downloadFileFromURL = new DownloadFileFromURL();
            downloadFileFromURL.setBookDetailsController(this);
            downloadFileFromURL.setData(appPrefs.get("booksPath", System.getProperty("user.home") + "/Books")+ "/" +category.getDescCat(),book.getName()+".pdf",book.getLink());
            downloadFileFromURL.download();

        }
        else {
            mainController.openBook(appPrefs.get("booksPath", System.getProperty("user.home") + "/Books") + "/" +category.getDescCat()+"/"+ book.getName() + ".pdf");
        }

    }

    public void onFinishDownload() {
        progressBarHBox.getChildren().remove(progressBar);
        isDownloaded = true;
        visualizeButton.setText("Visualize");

        //TODO update consulted table
        if(Main.user!=null){

        }
    }

    public void AddToFavorites(MouseEvent mouseEvent) {
        if(!isFavorite){
            //add to favs
            isFavorite=bookDAO.addBookToFavorite(book,Main.user);
            favoritesButton.setText("Remove from favorites");
            fontAwesomeFavIcon.setGlyphName("HEART");

        }else{
            //remove from favs
            isFavorite=!bookDAO.deleteFromFavorite(book, Main.user);
            favoritesButton.setText("Add to favorites");
            fontAwesomeFavIcon.setGlyphName("HEART_ALT");
        }
    }
}


