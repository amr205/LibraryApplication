package sample.database.model;

public class Owner {
    String OName, OLink, OAName;

    public Owner(String OName, String OLink, String OAName) {
        this.OName = OName;
        this.OLink = OLink;
        this.OAName = OAName;
    }

    public String getOName() {
        return OName;
    }

    public void setOName(String OName) {
        this.OName = OName;
    }

    public String getOLink() {
        return OLink;
    }

    public void setOLink(String OLink) {
        this.OLink = OLink;
    }

    public String getOAName() {
        return OAName;
    }

    public void setOAName(String OAName) {
        this.OAName = OAName;
    }
}
