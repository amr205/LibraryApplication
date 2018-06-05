package sample.database.model;

public class Country {
    String cveCountry, descCountry;

    public Country(String cveCountry, String descCountry) {
        this.cveCountry = cveCountry;
        this.descCountry = descCountry;
    }

    public String getCveCountry() {
        return cveCountry;
    }

    public void setCveCountry(String cveCountry) {
        this.cveCountry = cveCountry;
    }

    public String getDescCountry() {
        return descCountry;
    }

    public void setDescCountry(String descCountry) {
        this.descCountry = descCountry;
    }

    @Override
    public String toString(){
        return descCountry;
    }
}
