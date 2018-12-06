package sample.database.model;

public class Comment {
    String UName, UPassword, BName, BLink, opinion;

    public Comment(String UName, String BName,  String opinion) {
        this.UName = UName;
        this.BName = BName;
        this.opinion = opinion;
    }

    public String getUName() {
        return UName;
    }

    public void setUName(String UName) {
        this.UName = UName;
    }

    public String getBName() {
        return BName;
    }

    public void setBName(String BName) {
        this.BName = BName;
    }

    public String getOpinion() {
        return opinion;
    }

    public void setOpinion(String opinion) {
        this.opinion = opinion;
    }
}
