package sample.controller;

import javafx.fxml.FXML;
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

public class UpdateBookController {
    @FXML
    TextField txtName,txtLink,txtScore,txtCover;
    @FXML
    TextArea txaReview;
    @FXML
    ComboBox<String> cbCategory;
    @FXML
    Button btnAccept;

    Book book;


    public void setBook(Book book) {
        this.book = book;

        String cveCat = book.getCategory();
        CategoryDAO categoryDAO = new CategoryDAO(MySQL.getConnection());
        Category category = categoryDAO.findCategory(cveCat);

        txtName.setText(book.getName());
        txtLink.setText(book.getLink());
        txtScore.setText(book.getCalif()+"");
        txtCover.setText(book.getCover());
        txaReview.setText(book.getReview());
        cbCategory.getSelectionModel().select(category.getDescCat());

        txtName.setEditable(false);
        txtLink.setEditable(false);

    }

    public void update(MouseEvent mouseEvent) {
        String DescCate = cbCategory.getSelectionModel().getSelectedItem().toString();
        CategoryDAO categoryDAO = new CategoryDAO(MySQL.getConnection());
        Category category = categoryDAO.findCategoryByDesc(DescCate);
        Book book=new Book(txtName.getText(),txaReview.getText(),txtLink.getText(),category.getCveCat(),Float.parseFloat(txtScore.getText()),txtCover.getText());
        BookDAO bookDao=new BookDAO(MySQL.getConnection());
        bookDao.updateBook(book);

        Stage stage = (Stage)btnAccept.getScene().getWindow();
        stage.close();
    }
}
