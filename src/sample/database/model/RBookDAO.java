package sample.database.model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import javax.swing.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RBookDAO {
    private Connection conn;
    public RBookDAO(Connection conn)
    {
        this.conn = conn;
    }

    public ObservableList<RBook> findAll() {
        ObservableList<RBook> rbooks = FXCollections.observableArrayList();
        try {
            String query = "SELECT * FROM RBook";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(query);
            RBook p = null;
            while(rs.next()) {
                p = new RBook(
                        rs.getString("RName"),
                        rs.getString("RReview"),
                        rs.getString("RLink"),
                        rs.getString("RCat"),
                        rs.getString("RUname"),
                        rs.getString("RUpassword"),
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
                    + "where RName = ? and RLink = ? ";
            PreparedStatement st =  conn.prepareStatement(query);
            st.setString(  1, book.getName());
            st.setString(2, book.getLink());

            st.execute();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null,e.getMessage());
        }

        return false;
    }

}
