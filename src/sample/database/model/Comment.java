package sample.database.model;

public class Comment {
    String UName, UPassword, BName, BLink, opinion;

    public Comment(String UName, String UPassword, String BName, String BLink, String opinion) {
        this.UName = UName;
        this.UPassword = UPassword;
        this.BName = BName;
        this.BLink = BLink;
        this.opinion = opinion;
    }

    public String getUName() {
        return UName;
    }

    public void setUName(String UName) {
        this.UName = UName;
    }

    public String getUPassword() {
        return UPassword;
    }

    public void setUPassword(String UPassword) {
        this.UPassword = UPassword;
    }

    public String getBName() {
        return BName;
    }

    public void setBName(String BName) {
        this.BName = BName;
    }

    public String getBLink() {
        return BLink;
    }

    public void setBLink(String BLink) {
        this.BLink = BLink;
    }

    public String getOpinion() {
        return opinion;
    }

    public void setOpinion(String opinion) {
        this.opinion = opinion;
    }
}
