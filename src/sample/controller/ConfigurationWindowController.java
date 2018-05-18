package sample.controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.stage.DirectoryChooser;
import javafx.stage.Stage;
import sample.Main;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.prefs.Preferences;

public class ConfigurationWindowController implements Initializable {

    @FXML
    ToggleGroup userImg;

    @FXML
    ToggleButton userImage1, userImage2, userImage3, userImage4, userImage5, userImage6, userImage7, userImage8, userImage9, userImage10;

    @FXML
    TextField booksPathTextField;

    @FXML
    TextField usernameTextField,passwordTextField,emailTextField,fullNameTextField;

    @FXML
    DatePicker birthDP;

    private Preferences appPrefs;
    private DirectoryChooser directoryChooser;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        appPrefs = Preferences.userNodeForPackage(Main.class);

        directoryChooser = new DirectoryChooser();
        configuringDirectoryChooser(directoryChooser);


        booksPathTextField.setText(appPrefs.get("booksPath",System.getProperty("user.home")+"/Books"));

        usernameTextField.setText(Main.user.getUsername());
        passwordTextField.setText(Main.user.getPassword());
        emailTextField.setText(Main.user.getEmail());
        fullNameTextField.setText(Main.user.getFullName());

        birthDP.setValue(Main.user.getBirthDate().toLocalDate());




    }

    public void logoutUser(MouseEvent mouseEvent) {
        Main.user=null;
        appPrefs.put("username","none");
        appPrefs.put("password","none");

        System.out.println("log out user");

        closeConfigWindow();
    }

    public void closeConfigWindow() {
        Stage stage = (Stage)userImage1.getScene().getWindow();
        stage.close();
    }

    private void configuringDirectoryChooser(DirectoryChooser directoryChooser) {
        // Set title for DirectoryChooser
        directoryChooser.setTitle("Select book Directory");
        // Set Initial Directory
        directoryChooser.setInitialDirectory(new File(System.getProperty("user.home")));
    }

    public void chooseBooksPath(MouseEvent mouseEvent) {
        File dir = directoryChooser.showDialog((Stage)userImage1.getScene().getWindow());
        if (dir != null) {
            appPrefs.put("booksPath",dir.getAbsolutePath());
        } else {
            appPrefs.put("booksPath",System.getProperty("user.home")+"/Books");
        }

        booksPathTextField.setText(appPrefs.get("booksPath",System.getProperty("user.home")+"/Books"));
    }
}
