package sample.database.model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import sample.database.MySQL;

import javax.swing.*;
import java.sql.*;

public class AutorDAO {



    public ObservableList<Autor> fetchAllByBook(Book book) {
        ObservableList<Autor> autors = FXCollections.observableArrayList();
        try {
            String query = "SELECT * FROM Owners o inner join Autor a on o.OAName = a.AName where o.OName = ?";
            PreparedStatement st =  MySQL.getConnection().prepareStatement(query);
            st.setString(  1, book.getName());

            ResultSet rs = st.executeQuery();
            Autor p = null;
            while(rs.next()) {
                p = new Autor(
                        rs.getString("AName"),
                        rs.getString("ACveCountry"),
                        rs.getDate("ABirthDate"));
                autors.add(p);
            }
            rs.close();
            st.close();

        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null,"Error al recuperar información...");
        }
        return autors;
    }

    public ObservableList<Autor> fetchAll() {
        ObservableList<Autor> autors = FXCollections.observableArrayList();
        try {
            String query = "SELECT * FROM Autor";
            Statement st = MySQL.getConnection().createStatement();
            ResultSet rs = st.executeQuery(query);

            Autor p = null;
            while(rs.next()) {
                p = new Autor(
                        rs.getString("AName"),
                        rs.getString("ACveCountry"),
                        rs.getDate("ABirthDate"));
                autors.add(p);
            }
            rs.close();
            st.close();

        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null,"Error al recuperar información...");
        }
        return autors;
    }

    public boolean addAutor(Autor autor){
        try {
            String query = "insert into Autor (AName, ABirthDate, ACveCountry) values (?,?,?)";
            PreparedStatement st =  MySQL.getConnection().prepareStatement(query);
            st.setString(  1, autor.getName());
            st.setDate(  2, autor.getBirthDate());
            st.setString(3, autor.getCveCountry());


            st.execute();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null,e.getMessage());
        }

        return false;
    }


}
