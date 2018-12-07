package sample.database.model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import sample.database.MySQL;

import javax.swing.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class CountryDAO {


    
    public ObservableList<Country> fetchAll() {
        ObservableList<Country> list = FXCollections.observableArrayList();
        try {
            String query = "SELECT * FROM Country";
            Statement st = MySQL.getConnection().createStatement();
            ResultSet rs = st.executeQuery(query);

            Country p = null;
            while(rs.next()) {
                p = new Country(
                        rs.getString("CveCountry"),
                        rs.getString("DescCountry"));
                list.add(p);
            }
            rs.close();
            st.close();

        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null,"Error al recuperar información...");
        }
        return list;
    }

    public Country getCountryByCVE(String cve){
        Country p = null;

        try {
            String query = "SELECT * FROM Country where CveCountry = '"+cve+"' ";
            Statement st = MySQL.getConnection().createStatement();
            ResultSet rs = st.executeQuery(query);

            if(rs.next()) {
                p = new Country(
                        rs.getString("CveCountry"),
                        rs.getString("DescCountry"));

            }
            rs.close();
            st.close();
            return  p;

        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null,"Error al recuperar información...");
            return p;
        }
    }
}
