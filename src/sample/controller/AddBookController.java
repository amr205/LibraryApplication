package sample.controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import sample.database.MySQL;
import sample.database.model.Book;
import sample.database.model.BookDAO;
import sample.database.model.Category;
import sample.database.model.CategoryDAO;

import java.net.URL;
import java.util.ResourceBundle;

public class AddBookController {

    @FXML
    TextField txtName,txtAutor,txtLink,txtScore,txtCover;
    @FXML
    TextArea txaReview;
    @FXML
    ComboBox<String> cbCategory;
    @FXML
    Button btnAccept;


    public void addBook(MouseEvent mouseEvent) {
        String DescCate = cbCategory.getSelectionModel().getSelectedItem().toString();
        CategoryDAO categoryDAO = new CategoryDAO(MySQL.getConnection());
        Category category = categoryDAO.findCategoryByDesc(DescCate);

        Book book=new Book(txtName.getText(),txtAutor.getText(),txaReview.getText(),txtLink.getText(),category.getCveCat(),Float.parseFloat(txtScore.getText()),txtCover.getText());
        BookDAO bookDao=new BookDAO(MySQL.getConnection());
        bookDao.addBook(book);

        Stage stage = (Stage)btnAccept.getScene().getWindow();
        stage.close();
    }
}