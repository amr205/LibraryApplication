package sample.database.model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import javax.swing.*;
import java.sql.*;
import java.time.LocalDate;
import java.util.List;

public class OwnerDAO {
    private Connection conn;
    public OwnerDAO(Connection conn)
    {
        this.conn = conn;
    }

    public void findAutorsByBook(Book book){

    }
    public ObservableList<Owner> findAutors(){
        return null;
    }

    public List<Owner> findROwnersByBook(Book book){
        ObservableList<Owner> owners = FXCollections.observableArrayList();
        try {
            String query = "SELECT * FROM ROwners where ROName = ?";
            PreparedStatement st =  conn.prepareStatement(query);
            st.setString(  1, book.getName());

            ResultSet rs = st.executeQuery();
            Owner p = null;
            while(rs.next()) {
                p = new Owner(rs.getString("ROName"),
                        rs.getString("ROAName"));
                owners.add(p);
            }
            rs.close();
            st.close();

        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null,"Error al recuperar información...");
        }
        return owners;
    }

    public boolean autorExist(Owner owner){
        try {
            String query = "SELECT * FROM Autor where AName = ? ";
            PreparedStatement st =  conn.prepareStatement(query);
            st.setString(  1, owner.getOAName());

            ResultSet rs = st.executeQuery();

            boolean value = rs.next();

            rs.close();
            st.close();

            return value;

        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null,"Error al recuperar información...");
            return false;
        }
    }

    public  boolean addRAutorToBook(Owner owner){
        try {
            String query = "insert into ROwners (ROName, ROAName) values (?,?)";
            PreparedStatement st =  conn.prepareStatement(query);
            st.setString(  1, owner.getOName());
            st.setString(  2, owner.getOAName());

            st.execute();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null,e.getMessage());
        }

        return false;
    }

    public  boolean removeRAutorFromBook(Book book){
        try {
            String query = "delete from ROwners where ROName = ? and ROLink = ? ";
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

    public boolean addAutorToBook(Owner owner){
        try {
            String query = "insert into Owners (OName, OAName) values (?,?)";
            PreparedStatement st =  conn.prepareStatement(query);
            st.setString(  1, owner.getOName());
            st.setString(  2, owner.getOAName());

            st.execute();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null,e.getMessage());
        }

        return false;
    }

}
