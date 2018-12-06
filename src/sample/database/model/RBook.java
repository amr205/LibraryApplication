package sample.database.model;

public class RBook {
    String name, review, link, category, RUname, RUpassword, cover;
    float calif;

    public RBook(String name, String review, String link, String category, String RUname, String cover, float calif) {
        this.name = name;
        this.review = review;
        this.link = link;
        this.category = category;
        this.RUname = RUname;
        this.cover = cover;
        this.calif = calif;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    public float getCalif() {
        return calif;
    }

    public void setCalif(float calif) {
        this.calif = calif;
    }
}