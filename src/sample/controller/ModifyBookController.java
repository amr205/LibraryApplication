package sample.controller;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TableView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import sample.Main;
import sample.database.MySQL;
import sample.database.model.Book;
import sample.database.model.BookDAO;

import java.net.URL;
import java.util.ResourceBundle;

public class ModifyBookController implements Initializable {
    @FXML
    TableView<Book> tableView;

    BookDAO bookDAO;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        bookDAO = new BookDAO(MySQL.getConnection());
        reloadData();
    }

    private void reloadData(){
        tableView.setItems(bookDAO.fetchAll());
    }

    public void addBook(MouseEvent mouseEvent) {
        try{
            Stage stage = new Stage();

            FXMLLoader loader= new FXMLLoader(Main.class.getResource("fxml/AddBook.fxml"));
            Parent root = loader.load();
            AddBookController controller = loader.getController();

            stage.setTitle("Add Book");
            Scene primaryScene = new Scene(root, 450, 500);
            primaryScene.getStylesheets().add(Main.class.getResource("css/stylesheet.css").toString());
            stage.setScene(primaryScene);
            stage.setResizable(false);
            stage.show();

            stage.addEventHandler(WindowEvent.WINDOW_HIDDEN, new EventHandler<WindowEvent>() {
                @Override
                public void handle(WindowEvent event) {
                    reloadData();
                }
            });



        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void deleteBook(MouseEvent mouseEvent) {
        if(tableView.getSelectionModel().getSelectedItem()!=null){
            bookDAO.deleteBook(tableView.getSelectionModel().getSelectedItem());
            reloadData();
        }
        else{
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText("Cannot delete book");
            alert.setContentText("Please select an item first");
            alert.show();
        }
    }

    public void updateBook(MouseEvent mouseEvent) {
        if(tableView.getSelectionModel().getSelectedItem()!=null) {
            try {
                Stage stage = new Stage();

                FXMLLoader loader = new FXMLLoader(Main.class.getResource("fxml/updateBook.fxml"));
                Parent root = loader.load();
                UpdateBookController controller = loader.getController();
                controller.setBook(tableView.getSelectionModel().getSelectedItem());
                stage.setTitle("Update Book");
                Scene primaryScene = new Scene(root, 450, 500);
                primaryScene.getStylesheets().add(Main.class.getResource("css/stylesheet.css").toString());
                stage.setScene(primaryScene);
                stage.setResizable(false);
                stage.show();

                stage.addEventHandler(WindowEvent.WINDOW_HIDDEN, new EventHandler<WindowEvent>() {
                    @Override
                    public void handle(WindowEvent event) {
                        reloadData();
                    }
                });


            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        else{
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText("Cannot update book");
            alert.setContentText("Please select an item first");
            alert.show();
        }
    }
}
