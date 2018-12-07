package sample.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import sample.database.MySQL;
import sample.database.model.User;
import sample.database.model.UserDAO;

import java.sql.Date;
import java.time.LocalDate;

public class CreateUserController {
    @FXML
    TextField usernameTextField, passwordTextField, emailTextField, fullNameTextField;

    private String type;

    @FXML
    DatePicker birthDP;

    public void createUser(MouseEvent mouseEvent) {
        LocalDate localDate = birthDP.getValue();
        User user = new User(usernameTextField.getText(),passwordTextField.getText(),1,type,fullNameTextField.getText(),emailTextField.getText(), Date.valueOf(localDate));
        UserDAO userDAO = new UserDAO();
        if(userDAO.isUsernameAvailable(user.getUsername())){
            userDAO.createUser(user);
            Stage stage = (Stage)usernameTextField.getScene().getWindow();
            stage.close();
        }
        else{
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText("Cannot create user");
            alert.setHeaderText("username is not available");
            alert.show();
        }
    }

    public void setType(String type) {
        this.type = type;
    }
}
