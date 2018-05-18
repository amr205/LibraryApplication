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
                        rs.getString("UType"),
                        rs.getString("UNameCo"),
                        rs.getString("UEmail"),
                        rs.getDate("UDate"));
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

    public boolean createUser(User user){
        //TODO modify create user

        try {
            String query = "insert into UserB (UName, UPassword, UType , UPicture, UNameCo, UEmail, UDate) values (?,?,?,?,?,?,?)";
            PreparedStatement st =  conn.prepareStatement(query);
            st.setString(1, user.getUsername());
            st.setString(2, user.getPassword());
            st.setString(3, user.getType());
            st.setString(4, user.getImage());
            st.setString(5, user.getFullName());
            st.setString(6,user.getEmail());
            st.setDate(7,user.getBirthDate());
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
