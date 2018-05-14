package sample.database.model;

public class Category {
    String cveCat, descCat;

    public Category(String cveCat, String descCat) {
        this.cveCat = cveCat;
        this.descCat = descCat;
    }

    public String getCveCat() {
        return cveCat;
    }

    public void setCveCat(String cveCat) {
        this.cveCat = cveCat;
    }

    public String getDescCat() {
        return descCat;
    }

    public void setDescCat(String descCat) {
        this.descCat = descCat;
    }
}
