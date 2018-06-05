package sample.database.model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import javax.swing.*;
import java.sql.*;

public class AutorDAO {

    private Connection conn;
    public AutorDAO(Connection conn)
    {
        this.conn = conn;
    }

    public ObservableList<Autor> fetchAllByBook(Book book) {
        ObservableList<Autor> autors = FXCollections.observableArrayList();
        try {
            String query = "SELECT * FROM Owners o inner join Autor a on o.OAName = a.AName where o.OName = ? and o.OLink = ? ";
            PreparedStatement st =  conn.prepareStatement(query);
            st.setString(  1, book.getName());
            st.setString(2, book.getLink());

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
            Statement st = conn.createStatement();
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
            PreparedStatement st =  conn.prepareStatement(query);
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
