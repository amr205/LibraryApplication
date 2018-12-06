package sample.database.model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import sample.Main;

import javax.jws.soap.SOAPBinding;
import javax.swing.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BookDAO {
    private Connection conn;
    public BookDAO(Connection conn)
    {
        this.conn = conn;
    }

    public ObservableList<Book> fetchAll() {
        ObservableList<Book> books = FXCollections.observableArrayList();
        try {
            String query = "SELECT * FROM Book";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(query);
            Book p = null;
            while(rs.next()) {
                p = new Book(
                        rs.getString("Name"),
                        rs.getString("Review"),
                        rs.getString("Link"),
                        rs.getString("Cat"),
                        rs.getFloat("Calif"),
                        rs.getString("Cover"));
                books.add(p);
            }
            rs.close();
            st.close();

        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null,"Error al recuperar información...");
        }
        return books;
    }

    public List<Book> findAll() {
        List<Book> books = new ArrayList<Book>();
        try {
            String query = "SELECT * FROM Book";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(query);
            Book p = null;
            while(rs.next()) {
                p = new Book(
                        rs.getString("Name"),
                        rs.getString("Review"),
                        rs.getString("Link"),
                        rs.getString("Cat"),
                        rs.getFloat("Calif"),
                        rs.getString("Cover"));
                books.add(p);
            }
            rs.close();
            st.close();

        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null,"Error al recuperar información...");
        }
        return books;
    }

    public List<Book> findByRating(int limit) {
        List<Book> books = new ArrayList<Book>();
        try {
            String query = "SELECT * FROM Book order by Calif desc limit "+limit;
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(query);
            Book p = null;
            while(rs.next()) {
                p = new Book(
                        rs.getString("Name"),
                        rs.getString("Review"),
                        rs.getString("Link"),
                        rs.getString("Cat"),
                        rs.getFloat("Calif"),
                        rs.getString("Cover"));
                books.add(p);
            }
            rs.close();
            st.close();

        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null,"Error al recuperar información...");
        }
        return books;
    }

    public List<Book> findByCategory(String cat) {
        List<Book> books = new ArrayList<Book>();
        try {
            String query = "SELECT * FROM Book WHERE Cat = '"+cat+"' ";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(query);
            Book p = null;
            while(rs.next()) {
                p = new Book(
                        rs.getString("Name"),
                        rs.getString("Review"),
                        rs.getString("Link"),
                        rs.getString("Cat"),
                        rs.getFloat("Calif"),
                        rs.getString("Cover"));
                books.add(p);
            }
            rs.close();
            st.close();

        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null,"Error al recuperar información...");
        }
        return books;
    }

    public List<Book> findByCategoryDesc(String cat) {
        List<Book> books = new ArrayList<Book>();
        try {
            String query = "SELECT * FROM Book b inner join Category c on b.Cat = c.CveCat WHERE c.DescCat like '%"+cat+"%' ";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(query);
            Book p = null;
            while(rs.next()) {
                p = new Book(
                        rs.getString("Name"),
                        rs.getString("Review"),
                        rs.getString("Link"),
                        rs.getString("Cat"),
                        rs.getFloat("Calif"),
                        rs.getString("Cover"));
                books.add(p);
            }
            rs.close();
            st.close();

        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null,"Error al recuperar información...");
        }
        return books;
    }

    public List<Book> findByName(String name) {
        List<Book> books = new ArrayList<Book>();
        try {
            String query = "SELECT * FROM Book WHERE Name like '%"+name+"%' ";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(query);
            Book p = null;
            while(rs.next()) {
                p = new Book(
                        rs.getString("Name"),
                        rs.getString("Review"),
                        rs.getString("Link"),
                        rs.getString("Cat"),
                        rs.getFloat("Calif"),
                        rs.getString("Cover"));
                books.add(p);
            }
            rs.close();
            st.close();

        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null,"Error al recuperar información...");
        }
        return books;
    }

    public List<Book> findByAutor(String autor) {
        List<Book> books = new ArrayList<Book>();
        try {
            String query = "SELECT * FROM Book b inner join Owners o  on  b.Name = o.OName WHERE o.OAName like '%"+autor+"%' ";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(query);
            Book p = null;
            while(rs.next()) {
                p = new Book(
                        rs.getString("Name"),
                        rs.getString("Review"),
                        rs.getString("Link"),
                        rs.getString("Cat"),
                        rs.getFloat("Calif"),
                        rs.getString("Cover"));
                books.add(p);
            }
            rs.close();
            st.close();

        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null,"Error al recuperar información...");
        }
        return books;
    }

    public List<Book> findByReview(String review) {
        List<Book> books = new ArrayList<Book>();
        try {
            String query = "SELECT * FROM Book WHERE Review like '%"+review+"%' ";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(query);
            Book p = null;
            while(rs.next()) {
                p = new Book(
                        rs.getString("Name"),
                        rs.getString("Review"),
                        rs.getString("Link"),
                        rs.getString("Cat"),
                        rs.getFloat("Calif"),
                        rs.getString("Cover"));
                books.add(p);
            }
            rs.close();
            st.close();

        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null,"Error al recuperar información...");
        }
        return books;
    }

    public List<Book> findFavorites(User user) {
        List<Book> books = new ArrayList<Book>();
        try {
            String query = "select b.* from Favorites f" +
                    " inner join UserB u on f.FUName = u.UName"+
                    " inner join Book b on b.Name = f.FName" +
                    " where u.UName = '"+user.getUsername()+"'";
            Statement st = conn.createStatement();

            ResultSet rs = st.executeQuery(query);
            Book p = null;
            while(rs.next()) {
                p = new Book(
                        rs.getString("Name"),
                        
                        rs.getString("Review"),
                        rs.getString("Link"),
                        rs.getString("Cat"),
                        rs.getFloat("Calif"),
                        rs.getString("Cover"));
                books.add(p);
            }
            rs.close();
            st.close();

        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null,"Error al recuperar información...");
        }
        return books;
    }

    public boolean deleteBook(Book book){
        try {
            String query = "delete from Comments "
                    + "where CName = ?";
            PreparedStatement st =  conn.prepareStatement(query);
            st.setString(  1, book.getName());

            st.execute();
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null,e.getMessage());
        }
        try {
            String query = "delete from Owners "
                    + "where OName = ?";
            PreparedStatement st =  conn.prepareStatement(query);
            st.setString(  1, book.getName());

            st.execute();
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null,e.getMessage());
        }
        try {
            String query = "delete from Favorites "
                    + "where FName = ?";
            PreparedStatement st =  conn.prepareStatement(query);
            st.setString(  1, book.getName());

            st.execute();
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null,e.getMessage());
        }
        try {
            String query = "delete from History "
                    + "where HName = ?";
            PreparedStatement st =  conn.prepareStatement(query);
            st.setString(  1, book.getName());

            st.execute();
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null,e.getMessage());
        }

        try {
            String query = "delete from Ranking "
                    + "where GName = ?";
            PreparedStatement st =  conn.prepareStatement(query);
            st.setString(  1, book.getName());

            st.execute();
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null,e.getMessage());
        }


        try {
            String query = "delete from Book "
                    + "where Name = ?";
            PreparedStatement st =  conn.prepareStatement(query);
            st.setString(  1, book.getName());

            st.execute();
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null,e.getMessage());
        }

        return true;
    }

    public boolean updateBook(Book book){
        try {
            String query = "update Book set Review = ?,Cat = ?, Calif = ?,Cover = ?, Link = ?"
                    + "where Name = ?";

            PreparedStatement st =  conn.prepareStatement(query);
            st.setString(1,book.getReview());
            st.setString(2,book.getCategory());
            st.setFloat(3,book.getCalif());
            st.setString(4,book.getCover());
            st.setString(5, book.getLink());
            st.setString(  6, book.getName());

            st.execute();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null,e.getMessage());
        }

        return false;
    }


    public List<Book> findDownloaded(User user) {
        List<Book> books = new ArrayList<Book>();
        try {
            String query = "select b.* from History c" +
                    " inner join UserB u on c.HUName = u.UName" +
                    " inner join Book b on b.Name = c.HName" +
                    " where u.UName = '"+user.getUsername()+"'" +
                    " order by c.HDate limit 15";
            Statement st = conn.createStatement();

            ResultSet rs = st.executeQuery(query);
            Book p = null;
            while(rs.next()) {
                p = new Book(
                        rs.getString("Name"),
                        
                        rs.getString("Review"),
                        rs.getString("Link"),
                        rs.getString("Cat"),
                        rs.getFloat("Calif"),
                        rs.getString("Cover"));
                books.add(p);
            }
            rs.close();
            st.close();

        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null,"Error al recuperar información...");
        }
        return books;
    }
    public boolean isBookDownloaded(User user, Book book){
        boolean downloaded = false;
        try {
            String query = "select b.* from History c" +
                    " inner join UserB u on c.HUName = u.UName" +
                    " inner join Book b on b.Name = c.HName" +
                    " where u.UName = ?and b.Name = ?";
            PreparedStatement st = conn.prepareStatement(query);

            st.setString(1, user.getUsername());
            st.setString(  2, book.getName());

            ResultSet rs = st.executeQuery();


            if(rs.next())
                downloaded=  true;


            rs.close();
            st.close();

            return downloaded;

        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null,"Error al recuperar información...");
        }
        return downloaded;
    }


    public boolean addBookToDownloaded(User user, Book book){
        try {
            String query = "insert into History "
                    + " (HUName ,HName , HDate)"
                    + "  values (?,?,NOW())";
            PreparedStatement st =  conn.prepareStatement(query);
            st.setString(1, user.getUsername());
            st.setString(  2, book.getName());

            st.execute();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null,e.getMessage());
        }

        return false;
    }

    public boolean updateDownloaded(User user, Book book){
        try {
            String query = "update History "
                    + " set HDate = NOW() "
                    + "  where HUName = ? and HUPassword = ? and HName = ? and HLink = ? ";
            PreparedStatement st =  conn.prepareStatement(query);
            st.setString(1, user.getUsername());
            st.setString(2, user.getPassword());
            st.setString(  3, book.getName());
            st.setString(4, book.getLink());

            st.execute();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null,e.getMessage());
        }

        return false;
    }

    public boolean addBookToFavorite(Book book, User user){
        try {
            String query = "insert into Favorites "
                    + " (FUName  ,FName )"
                    + "  values (?,?)";
            PreparedStatement st =  conn.prepareStatement(query);
            st.setString(1, user.getUsername());
            st.setString(  2, book.getName());

            st.execute();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null,e.getMessage());
        }

        return false;
    }

    public boolean deleteFromFavorite(Book book, User user){
        try {
            String query = "delete from Favorites "
                    + "where FName = ? and FUName = ?";
            PreparedStatement st =  conn.prepareStatement(query);
            st.setString(  1, book.getName());
            st.setString(  2, user.getUsername());

            st.execute();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null,e.getMessage());
        }

        return false;
    }

    public boolean isFavorite(Book book, User user){
        boolean favorite = false;
        try {
            String query = "SELECT * FROM Favorites where  FName = ?  and FUName = ? ";
            PreparedStatement st = conn.prepareStatement(query);
            st.setString(  1, book.getName());
            st.setString(  2, user.getUsername());
            ResultSet rs = st.executeQuery();
            if(rs.next()){
                favorite=true;
            }
            rs.close();
            st.close();

        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null,"Error al recuperar información...");
        }
        return favorite;
    }

    public boolean isRated(Book book, User user){
        boolean rated = false;
        try {
            String query = "SELECT * FROM Ranking where  GName = ?  and GUName = ?";
            PreparedStatement st = conn.prepareStatement(query);
            st.setString(  1, book.getName());
            st.setString(  2, user.getUsername());
            ResultSet rs = st.executeQuery();
            if(rs.next()){
                rated=true;
            }
            rs.close();
            st.close();

        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null,"Error al recuperar información...");
        }
        return rated;
    }

    public float getUserRate(Book book, User user){
        float rate = 0.0f;
        try {
            String query = "SELECT * FROM Ranking where  GName = ? and GUName = ?";
            PreparedStatement st = conn.prepareStatement(query);
            st.setString(  1, book.getName());
            st.setString(  2, user.getUsername());
            ResultSet rs = st.executeQuery();
            if(rs.next()){
                rate=rs.getFloat("GCalif");
            }
            rs.close();
            st.close();

        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null,"Error al recuperar información...");
        }
        return rate;
    }

    public boolean addUserRating(Book book, User user, int calif) {
        try {
            String query = "insert into Ranking "
                    + " (GUName ,GName , GCalif)"
                    + "  values (?,?,?)";
            PreparedStatement st =  conn.prepareStatement(query);
            st.setString(1, user.getUsername());
            st.setString(  2, book.getName());
            st.setInt(3, calif);

            st.execute();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null,e.getMessage());
        }

        return false;
    }

    public boolean updateUserRating(Book book, User user, int calif) {
        try {
            String query = "update Ranking set GCalif = ? where GName = ? and GUName = ? ";
            PreparedStatement st =  conn.prepareStatement(query);

            st.setInt(1, calif);
            st.setString(  2, book.getName());
            st.setString(3, user.getUsername());

            st.execute();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null,e.getMessage());
        }

        return false;
    }

    public boolean updateRating(Book book){
        try {
            String query = "update Book set Calif = (select avg(GCalif) from Ranking where GName = ?) where Name = ? ";
            PreparedStatement st =  conn.prepareStatement(query);
            st.setString(  1, book.getName());
            st.setString(  2, book.getName());

            st.execute();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null,e.getMessage());
        }

        return false;
    }

    public boolean addBook(Book book){
        try {
            String query = "insert into Book (Name, Review, Link, Cat, Calif, Cover) values (?,?,?,?,?,?)";
            PreparedStatement st =  conn.prepareStatement(query);
            st.setString(  1, book.getName());
            st.setString(  2, book.getReview());
            st.setString(3, book.getLink());
            st.setString(4,book.getCategory());
            st.setFloat(5,book.getCalif());
            st.setString(6,book.getCover());

            st.execute();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null,e.getMessage());
        }

        return false;
    }

    public boolean addRBook(Book book,User user){
        try {
            String query = "insert into RBook (RName, RLink, RReview, RCat, RUname ,RCover, RCalif) values (?,?,?,?,?,?,?)";
            PreparedStatement st =  conn.prepareStatement(query);
            st.setString(  1, book.getName());
            st.setString(  3, book.getReview());
            st.setString(2, book.getLink());
            st.setString(4,book.getCategory());
            st.setString(5,user.getUsername());
            st.setString(6,book.getCover());
            st.setFloat(7,book.getCalif());


            st.execute();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null,e.getMessage());
        }

        return false;
    }

    public boolean addComment(User user, Book book, String opinion){
        try {
            String query = "insert into Comments (CUName, CName, COpinion) values (?,?,?)";
            PreparedStatement st =  conn.prepareStatement(query);
            st.setString(  1, user.getUsername());
            st.setString(2, book.getName());
            st.setString(3,opinion);



            st.execute();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null,e.getMessage());
        }

        return false;
    }

    public ArrayList<Comment> getComments(Book book) {
        ArrayList<Comment> comments = new ArrayList<>();
        try {
            String query = "SELECT * FROM Comments  where CName = ?";
            PreparedStatement st =  conn.prepareStatement(query);
            st.setString(  1, book.getName());

            ResultSet rs = st.executeQuery();
            Comment temp = null;
            while(rs.next()) {
                temp= new Comment(rs.getString("CUName"),
                        rs.getString("CName"),
                        rs.getString("COpinion"));
                comments.add(temp);
            }
            rs.close();
            st.close();

        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null,"Error al recuperar información...");
            return comments;
        }
        return comments;
    }
}
