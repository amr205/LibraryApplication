package sample.database.model;

public class Owner {
    String OName, OLink, OAName;

    public Owner(String OName, String OAName) {
        this.OName = OName;
        this.OAName = OAName;
    }

    public String getOName() {
        return OName;
    }

    public void setOName(String OName) {
        this.OName = OName;
    }

    public String getOAName() {
        return OAName;
    }

    public void setOAName(String OAName) {
        this.OAName = OAName;
    }
}
