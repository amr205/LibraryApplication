package sample.controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.DirectoryChooser;
import javafx.stage.Stage;
import sample.Main;
import sample.database.MySQL;
import sample.database.model.User;
import sample.database.model.UserDAO;

import java.io.File;
import java.net.URL;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ResourceBundle;
import java.util.prefs.Preferences;

public class ConfigurationWindowController implements Initializable {

    @FXML
    ToggleGroup userImg;

    @FXML
    ToggleButton userImage1, userImage2, userImage3, userImage4, userImage5, userImage6, userImage7, userImage8, userImage9, userImage10;

    @FXML
    ImageView image1, image2, image3, image4, image5, image6, image7, image8, image9, image10;

    @FXML
    TextField booksPathTextField;

    @FXML
    TextField emailTextField,fullNameTextField;

    @FXML
    DatePicker birthDP;

    private Preferences appPrefs;
    private DirectoryChooser directoryChooser;
    private UserDAO userDAO;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        userDAO  = new UserDAO(MySQL.getConnection());

        appPrefs = Preferences.userNodeForPackage(Main.class);

        directoryChooser = new DirectoryChooser();
        configuringDirectoryChooser(directoryChooser);


        booksPathTextField.setText(appPrefs.get("booksPath",System.getProperty("user.home")+"/Books"));


        emailTextField.setText(Main.user.getEmail());
        fullNameTextField.setText(Main.user.getFullName());

        birthDP.setValue(Main.user.getBirthDate().toLocalDate());

        setImages();

    }

    public void logoutUser(MouseEvent mouseEvent) {
        Main.user=null;
        appPrefs.put("username","none");
        appPrefs.put("password","none");

        System.out.println("log out user");

        Stage stage = (Stage)userImage1.getScene().getWindow();
        stage.close();
    }

    public void closeConfigWindow() {
        LocalDate localDate = birthDP.getValue();

        User newUser = new User(Main.user.getUsername(), Main.user.getPassword(),getImageID(),Main.user.getType(),fullNameTextField.getText(),emailTextField.getText(),Date.valueOf(localDate));

        userDAO.updateUser(newUser);

        Main.user = userDAO.findUser(Main.user.getUsername(), Main.user.getPassword());

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

    private void setImages(){
        userDAO = new UserDAO(MySQL.getConnection());
        image1.setImage(new Image(userDAO.getImageLinkByID(1),true));
        image2.setImage(new Image(userDAO.getImageLinkByID(2),true));
        image3.setImage(new Image(userDAO.getImageLinkByID(3),true));
        image4.setImage(new Image(userDAO.getImageLinkByID(4),true));
        image5.setImage(new Image(userDAO.getImageLinkByID(5),true));
        image6.setImage(new Image(userDAO.getImageLinkByID(6),true));
        image7.setImage(new Image(userDAO.getImageLinkByID(7),true));
        image8.setImage(new Image(userDAO.getImageLinkByID(8),true));
        image9.setImage(new Image(userDAO.getImageLinkByID(9),true));
        image10.setImage(new Image(userDAO.getImageLinkByID(10),true));

    }

    private int getImageID(){
        if(userImg.getSelectedToggle()==null){
            return Main.user.getImage();
        }
        else{
            if(userImg.getSelectedToggle()==userImage1)
                return 1;
            else if(userImg.getSelectedToggle()==userImage2)
                return 2;
            else if(userImg.getSelectedToggle()==userImage3)
                return 3;
            else if(userImg.getSelectedToggle()==userImage4)
                return 4;
            else if(userImg.getSelectedToggle()==userImage5)
                return 5;
            else if(userImg.getSelectedToggle()==userImage6)
                return 6;
            else if(userImg.getSelectedToggle()==userImage7)
                return 7;
            else if(userImg.getSelectedToggle()==userImage8)
                return 8;
            else if(userImg.getSelectedToggle()==userImage9)
                return 9;
            else if(userImg.getSelectedToggle()==userImage10)
                return 10;
            else return 1;
        }
    }
}
