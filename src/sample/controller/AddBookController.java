package sample.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import sample.database.MySQL;
import sample.database.model.*;

import javax.swing.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class AddBookController implements Initializable{

    @FXML
    TextField txtName,txtLink,txtScore,txtCover;
    @FXML
    TextArea txaReview;
    @FXML
    ComboBox<String> cbCategory;
    @FXML
    Button btnAccept;

    @FXML
    VBox autorBox;


    ArrayList<ComboBox<Autor>> autorList = new ArrayList<>();
    OwnerDAO ownerDAO;
    AutorDAO autorDAO;

    public void addBook(MouseEvent mouseEvent) {
        if( cbCategory.getSelectionModel().getSelectedItem()==null){
            JOptionPane.showMessageDialog(null, "select a category");
            return;
        }
        String DescCate = cbCategory.getSelectionModel().getSelectedItem().toString();
        CategoryDAO categoryDAO = new CategoryDAO();
        Category category = categoryDAO.findCategoryByDesc(DescCate);

        Book book=new Book(txtName.getText(),txaReview.getText(),txtLink.getText(),category.getCveCat(),Float.parseFloat(txtScore.getText()),txtCover.getText());
        BookDAO bookDao=new BookDAO();
        bookDao.addBook(book);

        for (int i = 0; i < autorList.size(); i++) {
            Autor tempAutor = autorList.get(i).getSelectionModel().getSelectedItem();
            Owner temp = new Owner(book.getName(),tempAutor.getName());
            ownerDAO.addAutorToBook(temp);

        }

        Stage stage = (Stage)btnAccept.getScene().getWindow();
        stage.close();
    }


    public void addRow() {
        HBox box = new HBox(15);
        Label label = new Label("Name");
        ComboBox<Autor> autorComboBox = new ComboBox<>();
        autorComboBox.setItems(autorDAO.fetchAll());
        autorBox.getChildren().add(box);
        try{
            autorComboBox.getSelectionModel().selectFirst();
        }catch (Exception e){

        }

        box.getChildren().addAll(label,autorComboBox);
        box.prefWidth(250);

        autorList.add(autorComboBox);
    }

    public void removeRow(ActionEvent actionEvent) {
        if(autorList.size()>1){
            autorList.remove(autorList.size()-1);
            autorBox.getChildren().remove(autorBox.getChildren().size()-1);
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        ownerDAO = new OwnerDAO();
        autorDAO = new AutorDAO();

        addRow();
    }
}
