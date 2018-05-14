package sample.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Orientation;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.layout.FlowPane;
import sample.Main;
import sample.database.MySQL;
import sample.database.model.Book;
import sample.database.model.BookDAO;
import sample.database.model.Category;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class CategoryBooksController  extends ShowBooks implements Initializable{

    @FXML
    private Label categoryNameLabel;

    @FXML
    private FlowPane booksPane;


    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    public void fillBooksPaneDebug() {
        try {
            for (int i = 0; i < 30; i++) {
                FXMLLoader loader = new FXMLLoader(Main.class.getResource("fxml/bookElement.fxml"));
                Parent root = loader.load();
                BookElementController controller = loader.getController();
                controller.setShowBooksController(this);
                booksPane.getChildren().add(root);
            }
        }catch (Exception e){e.printStackTrace();}
    }



    public void initBooks(Category category){
        categoryNameLabel.setText(category.getDescCat());
        BookDAO bookDAO = new BookDAO(MySQL.getConnection());
        List<Book> bookList = bookDAO.findByCategory(category.getCveCat());

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
