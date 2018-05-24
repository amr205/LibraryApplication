package sample.database.model;

public class RBook {
    String name, autor, review, link, category, RUname, RUpassword, cover;

    public RBook(String name, String autor, String review, String link, String category, String RUname, String RUpassword, String cover) {
        this.name = name;
        this.autor = autor;
        this.review = review;
        this.link = link;
        this.category = category;
        this.RUname = RUname;
        this.RUpassword = RUpassword;
        this.cover = cover;
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

    public String getRUname() {
        return RUname;
    }

    public void setRUname(String RUname) {
        this.RUname = RUname;
    }

    public String getRUpassword() {
        return RUpassword;
    }

    public void setRUpassword(String RUpassword) {
        this.RUpassword = RUpassword;
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }
}

