package sample.controller;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import sample.Main;
import sample.database.MySQL;
import sample.database.model.UserDAO;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.prefs.Preferences;


public class LoginWindowController implements Initializable {
    @FXML
    TextField usernameTextField;
    @FXML
    PasswordField passwordField;

    private Preferences appPrefs;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        appPrefs = Preferences.userNodeForPackage(Main.class);
        passwordField.addEventFilter(KeyEvent.KEY_RELEASED,new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                if(event.getCode().equals(KeyCode.ENTER) )
                    loginUser();

               }
        });
    }

    public void loginUser(MouseEvent mouseEvent) {
        UserDAO userDAO = new UserDAO();
        String username, password;
        username = usernameTextField.getText();
        password = passwordField.getText();


        Main.user = userDAO.findUser(username,password);

        if(Main.user!=null){
            //System.out.println("login user: "+Main.user.getUsername());
            appPrefs.put("username",username);
            appPrefs.put("password",password);
            MySQL.Disconnect();
            MySQL.dbuser=Main.user.getUsername();
            MySQL.dbpass=Main.user.getPassword();
            MySQL.Connect();


            Stage stage = (Stage) usernameTextField.getScene().getWindow();
            stage.close();
        }
        else {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText("Cannot login");
            alert.setContentText("wrong username or password");
            alert.show();
        }
    }
    public void loginUser() {
        UserDAO userDAO = new UserDAO();
        String username, password;
        username = usernameTextField.getText();
        password = passwordField.getText();


        Main.user = userDAO.findUser(username,password);

        if(Main.user!=null){
            //System.out.println("login user: "+Main.user.getUsername());
            appPrefs.put("username",username);
            appPrefs.put("password",password);
            MySQL.Disconnect();
            MySQL.dbuser=Main.user.getUsername();
            MySQL.dbpass=Main.user.getPassword();
            MySQL.Connect();


            Stage stage = (Stage) usernameTextField.getScene().getWindow();
            stage.close();
        }
        else {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText("Cannot login");
            alert.setContentText("wrong username or password");
            alert.show();
        }
    }

    public void createUser(MouseEvent mouseEvent) {
        try {
            Stage stage = new Stage();
            FXMLLoader loader = new FXMLLoader(Main.class.getResource("fxml/createUser.fxml"));
            Parent root = loader.load();
            CreateUserController controller = loader.getController();
            controller.setType("U");
            stage.setTitle("Create user");
            Scene primaryScene = new Scene(root, 530, 345);
            primaryScene.getStylesheets().add(Main.class.getResource("css/stylesheet.css").toString());
            stage.setScene(primaryScene);
            stage.setResizable(true);
            stage.show();

        }catch (Exception e){e.printStackTrace();}
    }
}
