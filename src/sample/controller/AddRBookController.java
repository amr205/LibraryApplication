package sample.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import sample.Main;
import sample.database.MySQL;
import sample.database.model.*;

import javax.swing.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class AddRBookController implements Initializable {
    @FXML
    TextField txtName,txtLink,txtCover;
    @FXML
    TextArea txaReview;
    @FXML
    ComboBox<String> cbCategory;
    @FXML
    Button btnAccept;

    @FXML
    VBox autorBox;


    ArrayList<TextField> autorList = new ArrayList<>();


    public void addBook(MouseEvent mouseEvent) {
        OwnerDAO ownerDAO = new OwnerDAO();



        String DescCate = cbCategory.getSelectionModel().getSelectedItem().toString();
        CategoryDAO categoryDAO = new CategoryDAO();
        Category category = categoryDAO.findCategoryByDesc(DescCate);

        Book book=new Book(txtName.getText(),txaReview.getText(),txtLink.getText(),category.getCveCat(),0,txtCover.getText());


        for (int i = 0; i < autorList.size(); i++) {
            if(autorList.get(i).getText().isEmpty()){
                JOptionPane.showMessageDialog(null,"Introduce el autor");
                return;
            }

        }

        BookDAO bookDao=new BookDAO();
        bookDao.addRBook(book, Main.user);


        for (int i = 0; i < autorList.size(); i++) {
            Owner temp = new Owner(book.getName(),autorList.get(i).getText());
            ownerDAO.addRAutorToBook(temp);

        }

        Stage stage = (Stage)btnAccept.getScene().getWindow();
        stage.close();

    }

    public void addRow( ) {
        HBox box = new HBox(15);
        Label label = new Label("Name");
        TextField textField = new TextField();

        box.getChildren().addAll(label,textField);
        autorBox.getChildren().add(box);
        autorList.add(textField);
    }

    public void removeRow(ActionEvent actionEvent) {
        if(autorList.size()>1){
            autorList.remove(autorList.size()-1);
            autorBox.getChildren().remove(autorBox.getChildren().size()-1);
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        addRow();
    }
}


