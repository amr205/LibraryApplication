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
import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class CreateAutorController implements Initializable {

    @FXML
    TextField txtName;
    
    @FXML
    DatePicker birthDP;
    
    @FXML
    ComboBox<Country> countryBox;
    
    @FXML
    Button btnAccept;


    CountryDAO countryDAO;
    AutorDAO autorDAO;

    public void addAutor(MouseEvent mouseEvent) {

        LocalDate localDate = birthDP.getValue();
        Autor temp = new Autor(txtName.getText(),countryBox.getSelectionModel().getSelectedItem().getCveCountry(),Date.valueOf(localDate));
        autorDAO.addAutor(temp);

        Stage stage = (Stage)btnAccept.getScene().getWindow();
        stage.close();
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        countryDAO = new CountryDAO();
        autorDAO = new AutorDAO();

        countryBox.setItems(countryDAO.fetchAll());
        try{
            countryBox.getSelectionModel().selectFirst();
        }catch (Exception e){

        }

    }
}
