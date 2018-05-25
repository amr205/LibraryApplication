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
import javafx.scene.layout.VBox;
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
    JFXButton scieCatButton, physCatButton, busiCatButton, econCatButton, histCatButton, philCatButton, humoCatButton, noveCatButton, fictCatButton, adveCatButton, classCatButton, kidsCatButton;

    @FXML
    VBox optionsVBox, adminOptionsVBox, userOptionsVBox, drawer;

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

        updateUserInfo();

        scieCatButton.setOnMouseClicked(handler);
        physCatButton.setOnMouseClicked(handler);
        busiCatButton.setOnMouseClicked(handler);
        econCatButton.setOnMouseClicked(handler);
        histCatButton.setOnMouseClicked(handler);
        philCatButton.setOnMouseClicked(handler);
        humoCatButton.setOnMouseClicked(handler);
        noveCatButton.setOnMouseClicked(handler);
        fictCatButton.setOnMouseClicked(handler);
        adveCatButton.setOnMouseClicked(handler);
        classCatButton.setOnMouseClicked(handler);
        kidsCatButton.setOnMouseClicked(handler);

    }

    EventHandler<MouseEvent> handler = new EventHandler<MouseEvent>() {
        @Override
        public void handle(MouseEvent event) {
            Category category = null;
            String cat="";
            CategoryDAO categoryDAO = new CategoryDAO(MySQL.getConnection());

            if(event.getSource()==kidsCatButton)
                cat="kids";
            else if(event.getSource()==scieCatButton)
                cat="scie";
            else if(event.getSource()==physCatButton)
                cat="phys";
            else if(event.getSource()==busiCatButton)
                cat="busi";
            else if(event.getSource()==econCatButton)
                cat="econ";
            else if(event.getSource()==histCatButton)
                cat="hist";
            else if(event.getSource()==philCatButton)
                cat="phil";
            else if(event.getSource()==humoCatButton)
                cat="humo";
            else if(event.getSource()==noveCatButton)
                cat="nove";
            else if(event.getSource()==fictCatButton)
                cat="fict";
            else if(event.getSource()==adveCatButton)
                cat="adve";
            else if(event.getSource()==classCatButton)
                cat="clas";

            category = categoryDAO.findCategory(cat);

            mainController.showCategory(category);
        }
    };

    public void setMainController(MainController mainController) {
        this.mainController = mainController;
    }

    public void openHome() {
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
                    updateUserInfo();
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
                    updateUserInfo();
                }
            });

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void addRBook(MouseEvent mouseEvent) {
        try {
            Stage stage = new Stage();

            FXMLLoader loader = new FXMLLoader(Main.class.getResource("fxml/AddRBook.fxml"));
            Parent root = loader.load();
            AddRBookController controller = loader.getController();

            stage.setTitle("Add Requested Book");
            Scene primaryScene = new Scene(root, 450, 500);
            primaryScene.getStylesheets().add(Main.class.getResource("css/stylesheet.css").toString());
            stage.setScene(primaryScene);
            stage.setResizable(false);
            stage.show();


        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void updateUserInfo(){
        updateImage();



        if(Main.user==null){
            drawer.getChildren().remove(optionsVBox);
        }
        else {

            if(!drawer.getChildren().contains(optionsVBox))
                drawer.getChildren().add(optionsVBox);

            if (Main.user.getType().equals("A")) {

                if (!optionsVBox.getChildren().contains(adminOptionsVBox))
                    optionsVBox.getChildren().add(adminOptionsVBox);

                if(optionsVBox.getChildren().contains(userOptionsVBox))
                    optionsVBox.getChildren().remove(userOptionsVBox);

            } else {
                if (!optionsVBox.getChildren().contains(userOptionsVBox))
                    optionsVBox.getChildren().add(userOptionsVBox);

                if(optionsVBox.getChildren().contains(adminOptionsVBox))
                    optionsVBox.getChildren().remove(adminOptionsVBox);

            }
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

    public void acceptRequest(MouseEvent mouseEvent) {
        try {
            Stage stage = new Stage();
            FXMLLoader loader = new FXMLLoader(Main.class.getResource("fxml/addRequested.fxml"));
            Parent root = loader.load();
            addRequestedController controller = loader.getController();
            stage.setTitle("Accept Requested Books");
            Scene primaryScene = new Scene(root, 900, 400);
            primaryScene.getStylesheets().add(Main.class.getResource("css/stylesheet.css").toString());
            stage.setScene(primaryScene);
            stage.setResizable(true);
            stage.show();

            stage.addEventHandler(WindowEvent.WINDOW_HIDDEN, new EventHandler<WindowEvent>() {
                @Override
                public void handle(WindowEvent event) {
                    openHome();
                }
            });

        }catch (Exception e){e.printStackTrace();}
    }

    public void addAdmin(MouseEvent mouseEvent) {
        try {
            Stage stage = new Stage();
            FXMLLoader loader = new FXMLLoader(Main.class.getResource("fxml/createUser.fxml"));
            Parent root = loader.load();
            CreateUserController controller = loader.getController();
            controller.setType("A");
            stage.setTitle("Create admin");
            Scene primaryScene = new Scene(root, 530, 345);
            primaryScene.getStylesheets().add(Main.class.getResource("css/stylesheet.css").toString());
            stage.setScene(primaryScene);
            stage.setResizable(false);
            stage.show();

        }catch (Exception e){e.printStackTrace();}
    }

    public void modifyBooks(MouseEvent mouseEvent) {
        try {
            Stage stage = new Stage();
            FXMLLoader loader = new FXMLLoader(Main.class.getResource("fxml/modifyBook.fxml"));
            Parent root = loader.load();
            ModifyBookController controller = loader.getController();
            stage.setTitle("Book administration");
            Scene primaryScene = new Scene(root, 1200, 800);
            primaryScene.getStylesheets().add(Main.class.getResource("css/stylesheet.css").toString());
            stage.setScene(primaryScene);
            stage.setResizable(true);
            stage.show();

            stage.addEventHandler(WindowEvent.WINDOW_HIDDEN, new EventHandler<WindowEvent>() {
                @Override
                public void handle(WindowEvent event) {
                    openHome();
                }
            });

        }catch (Exception e){e.printStackTrace();}
    }
}
