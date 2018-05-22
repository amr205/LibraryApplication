package sample.controller;

import com.jfoenix.controls.JFXHamburger;
import com.jfoenix.controls.JFXTextField;
import com.jfoenix.transitions.hamburger.HamburgerSlideCloseTransition;
import control.OpenPdfViewer;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.util.Duration;
import sample.Main;
import sample.database.model.Book;
import sample.database.model.Category;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.prefs.Preferences;


public class MainController implements Initializable{
    @FXML
    JFXHamburger hamburger;

    @FXML
    BorderPane mainPane;

    @FXML
    StackPane centerPane;

    @FXML
    HBox topLHbox, topRHbox;

    @FXML
    JFXTextField searchTextField;

    private StackPane menuContent;
    private boolean isContentShow;
    private Stage stage;

    private int sideMenuWidth = 190;

    Preferences appPrefs;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
         appPrefs = Preferences.userNodeForPackage(Main.class);

        initializeMenuDrawer();
        //openBook("/home/alejandro/Documentos/usb/Ecuaciones diferenciales con aplicaciones de modelado - Zill 9ed.pdf");

        //initializeWindowMovement();

        openHome();

    }

    private void initializeMenuDrawer(){
        try {
            FXMLLoader loader= new FXMLLoader(Main.class.getResource("fxml/menuContent.fxml"));
            menuContent = loader.load();
            MenuContentController menuContentController = loader.getController();
            menuContentController.setMainController(this);

            HamburgerSlideCloseTransition transition = new HamburgerSlideCloseTransition(hamburger);
            transition.setRate(-1);

            mainPane.setLeft(menuContent);
            menuContent.minWidth(0);
            menuContent.maxWidth(0);
            menuContent.prefWidth(0);
            isContentShow=false;

            hamburger.addEventHandler(MouseEvent.MOUSE_CLICKED, mouseEvent -> {

                if(isContentShow){
                    final Timeline timeline = new Timeline();
                    final KeyValue kv = new KeyValue(menuContent.minWidthProperty(), 0);
                    final KeyValue kv2 = new KeyValue(menuContent.maxWidthProperty(), 0);
                    final KeyFrame kf = new KeyFrame(Duration.millis(350), kv,kv2);
                    timeline.getKeyFrames().add(kf);
                    timeline.play();
                    isContentShow=false;
                }
                else{
                    final Timeline timeline = new Timeline();
                    final KeyValue kv = new KeyValue(menuContent.minWidthProperty(), sideMenuWidth);
                    final KeyValue kv2 = new KeyValue(menuContent.maxWidthProperty(), sideMenuWidth);
                    final KeyFrame kf = new KeyFrame(Duration.millis(350), kv,kv2);
                    timeline.getKeyFrames().add(kf);
                    timeline.play();
                    isContentShow=true;
                }

                transition.setRate(-1 * transition.getRate());
                transition.play();
            });



        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void openHome(){
        try {


            centerPane.getChildren().clear();

            FXMLLoader loader= new FXMLLoader(Main.class.getResource("fxml/homePage.fxml"));
            Parent categoryBooks = loader.load();
            HomeController controller = loader.getController();

            controller.setMainController(this);

            centerPane.getChildren().add(categoryBooks);



        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void openMyBooks(){
        try {

            if(Main.user!=null) {
                centerPane.getChildren().clear();

                FXMLLoader loader = new FXMLLoader(Main.class.getResource("fxml/myBooks.fxml"));
                Parent myBooks = loader.load();
                MyBooksController controller = loader.getController();

                controller.setMainController(this);

                centerPane.getChildren().add(myBooks);
            }
            else{
                centerPane.getChildren().clear();

                FXMLLoader loader = new FXMLLoader(Main.class.getResource("fxml/notLogin.fxml"));
                Parent notLogin = loader.load();

                centerPane.getChildren().add(notLogin);
            }



        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void openBook(String path){
        try {
            centerPane.getChildren().clear();

            AnchorPane anchorPane = new AnchorPane();

            OpenPdfViewer openPdfViewer = new OpenPdfViewer();
            AnchorPane.setBottomAnchor(openPdfViewer,0.0);
            AnchorPane.setLeftAnchor(openPdfViewer,0.0);
            AnchorPane.setRightAnchor(openPdfViewer,0.0);
            AnchorPane.setTopAnchor(openPdfViewer,0.0);

            openPdfViewer.setZoomOptions(true);
            openPdfViewer.setLoadOptions(false);
            openPdfViewer.setDeltaForResize(25);
            openPdfViewer.loadPdf(path);
            openPdfViewer.setZoomType(OpenPdfViewer.ZoomType.HEIGHT);

            anchorPane.getChildren().add(openPdfViewer);
            centerPane.getChildren().add(anchorPane);

            //"/home/alejandro/Documentos/usb/Ecuaciones diferenciales con aplicaciones de modelado - Zill 9ed.pdf"

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void showCategory(Category category){
        try {
            centerPane.getChildren().clear();

            FXMLLoader loader= new FXMLLoader(Main.class.getResource("fxml/categoryBooks.fxml"));
            Parent categoryBooks = loader.load();
            CategoryBooksController controller = loader.getController();

            controller.setMainController(this);
            controller.initBooks(category);

            centerPane.getChildren().add(categoryBooks);



        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void showBookDetails(Book book){
        try {
            FXMLLoader loader= new FXMLLoader(Main.class.getResource("fxml/bookDetails.fxml"));
            Parent bookDetails = loader.load();
            BookDetailsController controller = loader.getController();

            controller.setMainController(this);
            controller.setBook(book);

            centerPane.getChildren().add(bookDetails);



        }catch (Exception e){
            e.printStackTrace();
        }
    }

    private void initializeWindowMovement(){
        final Delta dragDelta = new Delta();
        topLHbox.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override public void handle(MouseEvent mouseEvent) {
                // record a delta distance for the drag and drop operation.
                try {
                    dragDelta.x = stage.getX() - mouseEvent.getScreenX();
                    dragDelta.y = stage.getY() - mouseEvent.getScreenY();
                }catch (Exception e) {

                }
            }
        });
        topLHbox.setOnMouseDragged(new EventHandler<MouseEvent>() {
            @Override public void handle(MouseEvent mouseEvent) {
                try {
                    stage.setX(mouseEvent.getScreenX() + dragDelta.x);
                    stage.setY(mouseEvent.getScreenY() + dragDelta.y);

                }catch (Exception e){

                }
            }
        });

        topRHbox.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override public void handle(MouseEvent mouseEvent) {
                // record a delta distance for the drag and drop operation.
                try {
                    dragDelta.x = stage.getX() - mouseEvent.getScreenX();
                    dragDelta.y = stage.getY() - mouseEvent.getScreenY();
                }catch (Exception e) {

                }
            }
        });
        topRHbox.setOnMouseDragged(new EventHandler<MouseEvent>() {
            @Override public void handle(MouseEvent mouseEvent) {
                try {
                    stage.setX(mouseEvent.getScreenX() + dragDelta.x);
                    stage.setY(mouseEvent.getScreenY() + dragDelta.y);

                }catch (Exception e){

                }
            }
        });


        topLHbox.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                if(mouseEvent.getButton().equals(MouseButton.PRIMARY)){
                    if(mouseEvent.getClickCount() == 2){
                        stage.setMaximized(!stage.isMaximized());
                    }
                }
            }
        });


    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    public void Exit(MouseEvent mouseEvent) {
        System.exit(0);
    }

    public StackPane getCenterPane() {
        return centerPane;
    }

    public void reloadUserData() {
        openHome();
    }

    public void searchBook(ActionEvent actionEvent) {
        try {
            centerPane.getChildren().clear();

            FXMLLoader loader= new FXMLLoader(Main.class.getResource("fxml/searchBook.fxml"));
            Parent searchResults = loader.load();
            SearchBooksController controller = loader.getController();

            controller.setMainController(this);
            controller.initBooks(searchTextField.getText());

            centerPane.getChildren().add(searchResults);



        }catch (Exception e){
            e.printStackTrace();
        }
    }
}

// records relative x and y co-ordinates.
class Delta { double x, y; }