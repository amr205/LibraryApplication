package sample.database.model;

import java.sql.Date;

public class Autor {
    String name, cveCountry;
    Date birthDate;

    public Autor(String name, String cveCountry, Date birthDate) {
        this.name = name;
        this.cveCountry = cveCountry;
        this.birthDate = birthDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCveCountry() {
        return cveCountry;
    }

    public void setCveCountry(String cveCountry) {
        this.cveCountry = cveCountry;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    @Override
    public String toString(){
        return name;
    }
}
