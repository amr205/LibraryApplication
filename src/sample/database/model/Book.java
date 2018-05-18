package sample.database.model;

import javafx.scene.image.Image;

public class Book {
    String name, autor, review, link, category,cover;
    float calif;

    Image image;

    public Book(String name, String autor, String review, String link, String category, float calif, String cover) {
        this.name = name;
        this.autor = autor;
        this.review = review;
        this.link = link;
        this.category = category;
        this.calif = calif;
        this.cover = cover;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public Image getImage() {
        return image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public float getCalif() {
        return calif;
    }

    public void setCalif(float calif) {
        this.calif = calif;
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }
}
