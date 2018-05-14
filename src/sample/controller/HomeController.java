package sample.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.layout.FlowPane;
import org.omg.CORBA.INITIALIZE;
import sample.Main;
import sample.database.MySQL;
import sample.database.model.Book;
import sample.database.model.BookDAO;
import sample.database.model.Category;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class HomeController extends ShowBooks implements Initializable {

    @FXML
    private FlowPane booksPane;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        initBooks();
    }

    private void initBooks(){
        BookDAO bookDAO = new BookDAO(MySQL.getConnection());
        List<Book> bookList = bookDAO.findByRating(50);

        try {
            for (int i = 0; i < bookList.size(); i++) {

                FXMLLoader loader = new FXMLLoader(Main.class.getResource("fxml/bookElement.fxml"));
                Parent root = loader.load();
                BookElementController controller = loader.getController();
                controller.setBook(bookList.get(i));
                controller.setShowBooksController(this);
                booksPane.getChildren().add(root);

            }
        }catch (Exception e){e.printStackTrace();}
    }
}
