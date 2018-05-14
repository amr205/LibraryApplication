package sample.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.layout.FlowPane;
import sample.Main;
import sample.database.MySQL;
import sample.database.model.Book;
import sample.database.model.BookDAO;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class MyBooksController extends ShowBooks implements Initializable {

    @FXML
    FlowPane downloadedPane, favoritePane;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        initFavoriteBooks();
        initDownloadedBooks();
    }

    private void initDownloadedBooks() {
        BookDAO bookDAO = new BookDAO(MySQL.getConnection());
        List<Book> bookList = bookDAO.findDownloaded(Main.user);

        try {
            for (int i = 0; i < bookList.size(); i++) {

                FXMLLoader loader = new FXMLLoader(Main.class.getResource("fxml/bookElement.fxml"));
                Parent root = loader.load();
                BookElementController controller = loader.getController();
                controller.setBook(bookList.get(i));
                controller.setShowBooksController(this);
                downloadedPane.getChildren().add(root);

            }
        }catch (Exception e){e.printStackTrace();}
    }

    private void initFavoriteBooks() {
        BookDAO bookDAO = new BookDAO(MySQL.getConnection());
        List<Book> bookList = bookDAO.findFavorites(Main.user);

        try {
            for (int i = 0; i < bookList.size(); i++) {

                FXMLLoader loader = new FXMLLoader(Main.class.getResource("fxml/bookElement.fxml"));
                Parent root = loader.load();
                BookElementController controller = loader.getController();
                controller.setBook(bookList.get(i));
                controller.setShowBooksController(this);
                favoritePane.getChildren().add(root);

            }
        }catch (Exception e){e.printStackTrace();}
    }
}
