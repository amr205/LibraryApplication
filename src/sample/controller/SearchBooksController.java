package sample.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.layout.FlowPane;
import javafx.scene.text.Font;
import sample.Main;
import sample.database.MySQL;
import sample.database.model.Book;
import sample.database.model.BookDAO;
import sample.database.model.Category;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class SearchBooksController  extends ShowBooks implements Initializable {

    @FXML
    private Label titleLabel;

    @FXML
    FlowPane namePane, autorPane, reviewPane, categoryPane ;


    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }




    public void initBooks(String search){
        titleLabel.setText("Results of search: "+search);
        BookDAO bookDAO = new BookDAO();
        List<Book> bookList;

       bookList = bookDAO.findByCategoryDesc(search);

        try {
            if(!bookList.isEmpty())
                for (int i = 0; i < bookList.size(); i++) {

                    FXMLLoader loader = new FXMLLoader(Main.class.getResource("fxml/bookElement.fxml"));
                    Parent root = loader.load();
                    BookElementController controller = loader.getController();
                    controller.setBook(bookList.get(i));
                    controller.setShowBooksController(this);
                    categoryPane.getChildren().add(root);

                }
            else{
                Label label = new Label("No results found");
                label.setFont(new Font(14));
                label.setPadding(new Insets(10,10,10,30));
                categoryPane.getChildren().add(label);
            }

        }catch (Exception e){e.printStackTrace();}

        bookList = bookDAO.findByName(search);

        try {
            if(!bookList.isEmpty())
                for (int i = 0; i < bookList.size(); i++) {

                    FXMLLoader loader = new FXMLLoader(Main.class.getResource("fxml/bookElement.fxml"));
                    Parent root = loader.load();
                    BookElementController controller = loader.getController();
                    controller.setBook(bookList.get(i));
                    controller.setShowBooksController(this);
                    namePane.getChildren().add(root);

                }
            else{
                Label label = new Label("No results found");
                label.setFont(new Font(14));
                label.setPadding(new Insets(10,10,10,30));
                namePane.getChildren().add(label);
            }

        }catch (Exception e){e.printStackTrace();}

        bookList = bookDAO.findByAutor(search);

        try {
            if(!bookList.isEmpty())
                for (int i = 0; i < bookList.size(); i++) {

                    FXMLLoader loader = new FXMLLoader(Main.class.getResource("fxml/bookElement.fxml"));
                    Parent root = loader.load();
                    BookElementController controller = loader.getController();
                    controller.setBook(bookList.get(i));
                    controller.setShowBooksController(this);
                    autorPane.getChildren().add(root);

                }
            else{
                Label label = new Label("No results found");
                label.setFont(new Font(14));
                label.setPadding(new Insets(10,10,10,30));
                autorPane.getChildren().add(label);
            }

        }catch (Exception e){e.printStackTrace();}

        bookList = bookDAO.findByReview(search);

        try {
            if(!bookList.isEmpty())
                for (int i = 0; i < bookList.size(); i++) {

                    FXMLLoader loader = new FXMLLoader(Main.class.getResource("fxml/bookElement.fxml"));
                    Parent root = loader.load();
                    BookElementController controller = loader.getController();
                    controller.setBook(bookList.get(i));
                    controller.setShowBooksController(this);
                    reviewPane.getChildren().add(root);

                }
            else{
                Label label = new Label("No results found");
                label.setFont(new Font(14));
                label.setPadding(new Insets(10,10,10,30));
                reviewPane.getChildren().add(label);
            }


        }catch (Exception e){e.printStackTrace();}
    }
}

