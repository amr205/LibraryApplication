package sample.database.model;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDAO {

    private Connection conn;
    public UserDAO(Connection conn)
    {
        this.conn = conn;
    }

    public User findUser(String username, String passwor) {
        User user = null;
        try {
            String query = "SELECT * FROM UserB WHERE UName = '"+username+"'  AND UPassword = '"+passwor+"'";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(query);

            if(rs.next()){
                user= new User(rs.getString("UName"),
                        rs.getString("UPassword"),
                        rs.getString("UPicture"),
                        rs.getString("UType"));
            }
            rs.close();
            st.close();

        } catch (SQLException ex) {
            ex.printStackTrace();
            user = null;
            System.out.println("Error al recuperar información...");
        }
        return user;
    }

    public boolean isUsernameAvailable(String username){
        boolean available = true;
        try {
            String query = "SELECT UName FROM UserB WHERE UName = '"+username+"'";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(query);

            if(rs.next())
                available=false;

            rs.close();
            st.close();

        } catch (SQLException ex) {
            ex.printStackTrace();
            System.out.println("Error al recuperar información...");
        }
        return available;
    }

    public boolean createUser(String username, String password){
        //TODO modify create user
        try {
            String query = "insert into UserB values (?,?,'U','default')";
            PreparedStatement st =  conn.prepareStatement(query);
            st.setString(1, username);
            st.setString(2, password);

            st.execute();
            //data.add(transaction);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }

        return false;
    }
}
