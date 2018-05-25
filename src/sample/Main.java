package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import sample.controller.MainController;
import sample.database.MySQL;
import sample.database.model.User;
import sample.database.model.UserDAO;

import java.util.prefs.Preferences;

public class Main extends Application {

    public static User user;
    private Preferences appPrefs;

    @Override
    public void start(Stage primaryStage) throws Exception{
        //init database connection
        MySQL.Connect();

        //auto login
        appPrefs  = Preferences.userNodeForPackage(Main.class);
        logUser();

        //init aplication
        FXMLLoader loader= new FXMLLoader(Main.class.getResource("fxml/mainWindow.fxml"));
        Parent root = loader.load();
        MainController controller = loader.getController();
        controller.setStage(primaryStage);

        //primaryStage.initStyle(StageStyle.DECORATED);
        primaryStage.setTitle("Library app");
        Scene primaryScene = new Scene(root, 1400, 900);
        primaryScene.getStylesheets().add(Main.class.getResource("css/stylesheet.css").toString());
        primaryStage.setScene(primaryScene);
        primaryStage.setMaximized(true);
        primaryStage.show();


    }

    private void logUser() {
        UserDAO userDAO = new UserDAO(MySQL.getConnection());
        String username, password;
        username=appPrefs.get("username","none");
        password=appPrefs.get("password","none");

        user = userDAO.findUser(username,password);
        if(user!=null)
            System.out.println("init app with user :"+user.getUsername());
        else
            System.out.println("init app without user");
    }


    public static void main(String[] args) {
        launch(args);
    }
}
