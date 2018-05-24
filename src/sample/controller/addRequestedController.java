package sample.controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import sample.database.MySQL;
import sample.database.model.Book;
import sample.database.model.BookDAO;
import sample.database.model.RBook;
import sample.database.model.RBookDAO;

import java.net.URL;
import java.util.ResourceBundle;

public class addRequestedController implements Initializable {

    RBookDAO rBookDAO=new RBookDAO(MySQL.getConnection());
    @FXML
    TableView<RBook> tvwRBook;
    @FXML
    TextField calif;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        initTableR();

    }

    void initTableR(){
        tvwRBook.setItems(rBookDAO.findAll());

    }


    public void Aprove(MouseEvent mouseEvent) {
        RBook rbook=tvwRBook.getSelectionModel().getSelectedItem();
        Float score;
        if(calif.getText()=="")
            score=(float)0;
        else
            score=Float.parseFloat(calif.getText());

        Book book =new Book (rbook.getName(),rbook.getAutor(),rbook.getReview(),rbook.getLink(),rbook.getCategory(),score,rbook.getCover());
        BookDAO bookDao=new BookDAO(MySQL.getConnection());
        bookDao.addBook(book);


    }
}
