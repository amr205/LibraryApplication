package sample.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ListView;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import sample.Main;
import sample.database.MySQL;
import sample.database.model.*;

import javax.swing.*;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class addRequestedController implements Initializable {

    RBookDAO rBookDAO=new RBookDAO(MySQL.getConnection());
    OwnerDAO ownerDAO = new OwnerDAO(MySQL.getConnection());


    @FXML
    TableView<RBook> tvwRBook;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        initTableR();

    }

    void initTableR(){
        tvwRBook.setItems(rBookDAO.findAll());

    }


    public void Aprove(MouseEvent mouseEvent) {
        if(tvwRBook.getSelectionModel().getSelectedItem()!=null) {
            RBook rbook = tvwRBook.getSelectionModel().getSelectedItem();
            Float score= 0f;

            Book book = new Book(rbook.getName(), rbook.getReview(), rbook.getLink(), rbook.getCategory(), score, rbook.getCover());

            List<Owner> possibles = ownerDAO.findROwnersByBook(book);

            for (int i = 0; i < possibles.size(); i++) {
                if(!ownerDAO.autorExist(possibles.get(i))){
                    JOptionPane.showMessageDialog(null,"Agrega primero al autor "+possibles.get(i).getOAName());
                    return;
                }
            }

            BookDAO bookDao = new BookDAO(MySQL.getConnection());
            bookDao.addBook(book);

            for (int i = 0; i < possibles.size(); i++) {
                ownerDAO.addAutorToBook(possibles.get(i));
            }
            ownerDAO.removeRAutorFromBook(book);


            RBookDAO rBookDAO = new RBookDAO(MySQL.getConnection());
            rBookDAO.delete(book);

            initTableR();
        }else{
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText("Cannot aprove book");
            alert.setContentText("Please select an item first");
            alert.show();
        }

    }

    public void addAutor(ActionEvent actionEvent) {
        try {
            Stage stage = new Stage();

            FXMLLoader loader = new FXMLLoader(Main.class.getResource("fxml/CreateAutor.fxml"));
            Parent root = loader.load();
            CreateAutorController controller = loader.getController();
            stage.setTitle("Create autor");
            Scene primaryScene = new Scene(root, 450, 280);
            primaryScene.getStylesheets().add(Main.class.getResource("css/stylesheet.css").toString());
            stage.setScene(primaryScene);
            stage.setResizable(false);
            stage.show();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void decline(MouseEvent mouseEvent) {
        if(tvwRBook.getSelectionModel().getSelectedItem()!=null) {
            RBook rbook = tvwRBook.getSelectionModel().getSelectedItem();
            Float score= 0f;

            Book book = new Book(rbook.getName(), rbook.getReview(), rbook.getLink(), rbook.getCategory(), score, rbook.getCover());

            ownerDAO.removeRAutorFromBook(book);

            RBookDAO rBookDAO = new RBookDAO(MySQL.getConnection());
            rBookDAO.delete(book);

            initTableR();
        }else{
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText("Cannot aprove book");
            alert.setContentText("Please select an item first");
            alert.show();
        }
    }
}
