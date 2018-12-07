package sample.database.model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import sample.database.MySQL;

import javax.swing.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RBookDAO {


    public ObservableList<RBook> findAll() {
        ObservableList<RBook> rbooks = FXCollections.observableArrayList();
        try {
            String query = "SELECT * FROM RBook";
            Statement st = MySQL.getConnection().createStatement();
            ResultSet rs = st.executeQuery(query);
            RBook p = null;
            while(rs.next()) {
                p = new RBook(
                        rs.getString("RName"),
                        rs.getString("RReview"),
                        rs.getString("RLink"),
                        rs.getString("RCat"),
                        rs.getString("RUname"),
                        rs.getString("RCover"),
                        rs.getFloat("RCalif"));
                rbooks.add(p);
            }
            rs.close();
            st.close();

        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null,"Error al recuperar información...");
        }
        return rbooks;
    }

    public boolean delete(Book book){
        try {
            String query = "delete from RBook "
                    + "where RName = ?";
            PreparedStatement st =  MySQL.getConnection().prepareStatement(query);
            st.setString(  1, book.getName());

            st.execute();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null,e.getMessage());
        }

        return false;
    }

}
