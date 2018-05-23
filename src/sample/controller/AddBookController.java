package sample.controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import sample.database.MySQL;
import sample.database.model.Book;
import sample.database.model.BookDAO;

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
        String Cate = cbCategory.getSelectionModel().getSelectedItem().toString();
        Book book=new Book(txtName.getText(),txtAutor.getText(),txaReview.getText(),txtLink.getText(),Cate,Float.parseFloat(txtScore.getText()),txtCover.getText());
        BookDAO bookDao=new BookDAO(MySQL.getConnection());
        bookDao.addBook(book);



    }
}
