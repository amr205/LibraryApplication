package sample.controller;

import com.jfoenix.controls.JFXButton;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.stage.WindowEvent;
import sample.Main;
import sample.database.MySQL;
import sample.database.model.Category;
import sample.database.model.CategoryDAO;
import sample.database.model.UserDAO;

import java.net.URL;
import java.util.ResourceBundle;

public class MenuContentController implements Initializable {

    @FXML
    ImageView userImage;

    @FXML
    Button userButton;

    @FXML
    JFXButton comicCatButton;


    MainController mainController;


    @Override
    public void initialize(URL location, ResourceBundle resources) {


        userButton.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                userImage.setFitWidth(235);
                userImage.setFitHeight(145);
            }
        });

        userButton.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                userImage.setFitWidth(218);
                userImage.setFitHeight(131);
            }
        });

        userButton.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                if(Main.user!=null){
                    openProfileConfig();
                }
                else {
                    openLogInWindow();
                }
            }
        });
        updateImage();

        comicCatButton.setOnMouseClicked(handler);
    }

    EventHandler<MouseEvent> handler = new EventHandler<MouseEvent>() {
        @Override
        public void handle(MouseEvent event) {
            Category category = null;
            String cat="";
            CategoryDAO categoryDAO = new CategoryDAO(MySQL.getConnection());

            if(event.getSource()==comicCatButton)
                cat="comc";


            category = categoryDAO.findCategory(cat);

            mainController.showCategory(category);
        }
    };

    public void setMainController(MainController mainController) {
        this.mainController = mainController;
    }

    public void openHome(MouseEvent mouseEvent) {
        mainController.openHome();
    }

    public void openMyBooks(MouseEvent mouseEvent) {
        mainController.openMyBooks();
    }


    private void openLogInWindow() {
        try{
            Stage stage = new Stage();

            FXMLLoader loader= new FXMLLoader(Main.class.getResource("fxml/loginWindow.fxml"));
            Parent root = loader.load();
            LoginWindowController controller = loader.getController();

            stage.setTitle("Login");
            Scene primaryScene = new Scene(root, 525, 265);
            primaryScene.getStylesheets().add(Main.class.getResource("css/stylesheetLogin.css").toString());
            stage.setScene(primaryScene);
            stage.setResizable(false);
            stage.show();

            stage.addEventHandler(WindowEvent.WINDOW_HIDDEN, new EventHandler<WindowEvent>() {
                @Override
                public void handle(WindowEvent event) {
                    mainController.reloadUserData();
                    updateImage();
                }
            });
        }catch (Exception e){
            e.printStackTrace();
        }
    }


    private void openProfileConfig() {
        try{
            Stage stage = new Stage();

            FXMLLoader loader= new FXMLLoader(Main.class.getResource("fxml/configurationWindow.fxml"));
            Parent root = loader.load();
            ConfigurationWindowController controller = loader.getController();

            stage.setTitle("Profile Settings");
            Scene primaryScene = new Scene(root, 565, 720);
            primaryScene.getStylesheets().add(Main.class.getResource("css/stylesheet.css").toString());
            stage.setScene(primaryScene);
            stage.setResizable(false);
            stage.show();

            stage.addEventHandler(WindowEvent.WINDOW_HIDDEN, new EventHandler<WindowEvent>() {
                @Override
                public void handle(WindowEvent event) {
                    mainController.reloadUserData();
                    updateImage();
                }
            });

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    private void updateImage() {
        if(Main.user==null){
            userImage.setImage(new Image("/login.png"));
        }
        else{
            UserDAO userDAO = new UserDAO(MySQL.getConnection());
            userImage.setImage(new Image(userDAO.getImageLink(Main.user),true));
        }
    }

}
