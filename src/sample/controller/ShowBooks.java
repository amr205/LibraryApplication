package sample.controller;

import sample.database.model.Book;

public class ShowBooks {
    MainController mainController;

    public void setMainController(MainController mainController) {
        this.mainController = mainController;
    }

    public void showBookDetails(Book book){
        mainController.showBookDetails(book);
    }
}
