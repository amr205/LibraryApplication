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
                        rs.getInt("UPictureID"),
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

    public boolean updateUser(User user){
        try {
            String query = "update UserB set  UNameCo = ?, UEmail = ?, UDate = ?, UType = ?, UPictureID = ? where UName = ? and UPassword = ?";
            PreparedStatement st =  conn.prepareStatement(query);
            st.setString(1, user.getFullName());
            st.setString(2, user.getEmail());
            st.setDate(3, user.getBirthDate());
            st.setString(4, user.getType());
            st.setInt(5, user.getImage());
            st.setString(6,user.getUsername());
            st.setString(7,user.getPassword());
            st.execute();
            //data.add(transaction);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }

        return false;
    }

    public boolean createUser(User user){
        try {
            String query = "insert into UserB (UName, UPassword, UType , UPictureID, UNameCo, UEmail, UDate) values (?,?,?,?,?,?,?)";
            PreparedStatement st =  conn.prepareStatement(query);
            st.setString(1, user.getUsername());
            st.setString(2, user.getPassword());
            st.setString(3, user.getType());
            st.setInt(4, user.getImage());
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

    public String getImageLink(User user){
        try {
            String query = "select * from UserB u inner join UserImage i on u.UPictureID = i.ImageID where UName = ? and UPassword = ?";
            PreparedStatement st =  conn.prepareStatement(query);
            st.setString(1, user.getUsername());
            st.setString(2, user.getPassword());

            ResultSet rs = st.executeQuery();
            //data.add(transaction);
            if(rs.next())
                return rs.getString("ImageDesc");

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }

        return "https://i1.wp.com/www.winhelponline.com/blog/wp-content/uploads/2017/12/user.png?fit=256%2C256&quality=100";
    }

    public String getImageLinkByID(int id){
        try {
            String query = "select * from UserImage   where ImageID = ?";
            PreparedStatement st =  conn.prepareStatement(query);
            st.setInt(1, id);


            ResultSet rs = st.executeQuery();
            //data.add(transaction);
            if(rs.next())
                return rs.getString("ImageDesc");

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }

        return "https://i1.wp.com/www.winhelponline.com/blog/wp-content/uploads/2017/12/user.png?fit=256%2C256&quality=100";
    }
}
