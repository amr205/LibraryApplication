package sample.database.model;

import sample.Main;

import javax.jws.soap.SOAPBinding;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BookDAO {
    private Connection conn;
    public BookDAO(Connection conn)
    {
        this.conn = conn;
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
                        rs.getString("Autor"),
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
            System.out.println("Error al recuperar información...");
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
                        rs.getString("Autor"),
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
            System.out.println("Error al recuperar información...");
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
                        rs.getString("Autor"),
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
            System.out.println("Error al recuperar información...");
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
                        rs.getString("Autor"),
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
            System.out.println("Error al recuperar información...");
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
                        rs.getString("Autor"),
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
            System.out.println("Error al recuperar información...");
        }
        return books;
    }

    public List<Book> findByAutor(String autor) {
        List<Book> books = new ArrayList<Book>();
        try {
            String query = "SELECT * FROM Book WHERE Autor like '%"+autor+"%' ";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(query);
            Book p = null;
            while(rs.next()) {
                p = new Book(
                        rs.getString("Name"),
                        rs.getString("Autor"),
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
            System.out.println("Error al recuperar información...");
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
                        rs.getString("Autor"),
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
            System.out.println("Error al recuperar información...");
        }
        return books;
    }

    public List<Book> findFavorites(User user) {
        List<Book> books = new ArrayList<Book>();
        try {
            String query = "select b.* from Favorites f" +
                    " inner join UserB u on f.FUName = u.UName and f.FUPassword = u.UPassword" +
                    " inner join Book b on b.Name = f.FName and b.Autor = f.FAutor" +
                    " where u.UName = '"+user.getUsername()+"' and u.UPassword = '"+user.getPassword()+"'";
            Statement st = conn.createStatement();

            ResultSet rs = st.executeQuery(query);
            Book p = null;
            while(rs.next()) {
                p = new Book(
                        rs.getString("Name"),
                        rs.getString("Autor"),
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
            System.out.println("Error al recuperar información...");
        }
        return books;
    }


    public List<Book> findDownloaded(User user) {
        List<Book> books = new ArrayList<Book>();
        try {
            String query = "select b.* from History c" +
                    " inner join UserB u on c.HUName = u.UName and c.HUPassword = u.UPassword" +
                    " inner join Book b on b.Name = c.HName and b.Autor = c.HAutor" +
                    " where u.UName = '"+user.getUsername()+"' and u.UPassword = '"+user.getPassword()+"'" +
                    " order by c.HDate limit 15";
            Statement st = conn.createStatement();

            ResultSet rs = st.executeQuery(query);
            Book p = null;
            while(rs.next()) {
                p = new Book(
                        rs.getString("Name"),
                        rs.getString("Autor"),
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
            System.out.println("Error al recuperar información...");
        }
        return books;
    }
    public boolean isBookDownloaded(User user, Book book){
        boolean downloaded = false;
        try {
            String query = "select b.* from History c" +
                    " inner join UserB u on c.HUName = u.UName and c.HUPassword = u.UPassword" +
                    " inner join Book b on b.Name = c.HName and b.Autor = c.HAutor" +
                    " where u.UName = ? and u.UPassword = ? and b.Name = ? and b.Autor = ?";
            PreparedStatement st = conn.prepareStatement(query);

            st.setString(1, user.getUsername());
            st.setString(2, user.getPassword());
            st.setString(  3, book.getName());
            st.setString(4, book.getAutor());

            ResultSet rs = st.executeQuery();


            if(rs.next())
                downloaded=  true;


            rs.close();
            st.close();

            return downloaded;

        } catch (SQLException ex) {
            ex.printStackTrace();
            System.out.println("Error al recuperar información...");
        }
        return downloaded;
    }


    public boolean addBookToDownloaded(User user, Book book){
        try {
            String query = "insert into History "
                    + " (HUName ,HUPassword ,HName ,HAutor, HDate)"
                    + "  values (?,?,?,?,NOW())";
            PreparedStatement st =  conn.prepareStatement(query);
            st.setString(1, user.getUsername());
            st.setString(2, user.getPassword());
            st.setString(  3, book.getName());
            st.setString(4, book.getAutor());

            st.execute();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }

        return false;
    }

    public boolean updateDownloaded(User user, Book book){
        try {
            String query = "update History "
                    + " set HDate = NOW() "
                    + "  where HUName = ? and HUPassword = ? and HName = ? and HAutor = ? ";
            PreparedStatement st =  conn.prepareStatement(query);
            st.setString(1, user.getUsername());
            st.setString(2, user.getPassword());
            st.setString(  3, book.getName());
            st.setString(4, book.getAutor());

            st.execute();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }

        return false;
    }

    public boolean addBookToFavorite(Book book, User user){
        try {
            String query = "insert into Favorites "
                    + " (FUName ,FUPassword ,FName ,FAutor)"
                    + "  values (?,?,?,?)";
            PreparedStatement st =  conn.prepareStatement(query);
            st.setString(1, user.getUsername());
            st.setString(2, user.getPassword());
            st.setString(  3, book.getName());
            st.setString(4, book.getAutor());

            st.execute();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }

        return false;
    }

    public boolean deleteFromFavorite(Book book, User user){
        try {
            String query = "delete from Favorites "
                    + "where FName = ? and FAutor = ? and FUName = ? and FUPassword = ?";
            PreparedStatement st =  conn.prepareStatement(query);
            st.setString(  1, book.getName());
            st.setString(2, book.getAutor());
            st.setString(  3, user.getUsername());
            st.setString(4, user.getPassword());

            st.execute();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }

        return false;
    }

    public boolean isFavorite(Book book, User user){
        boolean favorite = false;
        try {
            String query = "SELECT * FROM Favorites where  FName = ? and FAutor = ? and FUName = ? and FUPassword = ?";
            PreparedStatement st = conn.prepareStatement(query);
            st.setString(  1, book.getName());
            st.setString(2, book.getAutor());
            st.setString(  3, user.getUsername());
            st.setString(4, user.getPassword());
            ResultSet rs = st.executeQuery();
            if(rs.next()){
                favorite=true;
            }
            rs.close();
            st.close();

        } catch (SQLException ex) {
            ex.printStackTrace();
            System.out.println("Error al recuperar información...");
        }
        return favorite;
    }

    public boolean isRated(Book book, User user){
        boolean rated = false;
        try {
            String query = "SELECT * FROM Ranking where  GName = ? and GAutor = ? and GUName = ? and GUPassword = ?";
            PreparedStatement st = conn.prepareStatement(query);
            st.setString(  1, book.getName());
            st.setString(2, book.getAutor());
            st.setString(  3, user.getUsername());
            st.setString(4, user.getPassword());
            ResultSet rs = st.executeQuery();
            if(rs.next()){
                rated=true;
            }
            rs.close();
            st.close();

        } catch (SQLException ex) {
            ex.printStackTrace();
            System.out.println("Error al recuperar información...");
        }
        return rated;
    }

    public float getUserRate(Book book, User user){
        float rate = 0.0f;
        try {
            String query = "SELECT * FROM Ranking where  GName = ? and GAutor = ? and GUName = ? and GUPassword = ?";
            PreparedStatement st = conn.prepareStatement(query);
            st.setString(  1, book.getName());
            st.setString(2, book.getAutor());
            st.setString(  3, user.getUsername());
            st.setString(4, user.getPassword());
            ResultSet rs = st.executeQuery();
            if(rs.next()){
                rate=rs.getFloat("GCalif");
            }
            rs.close();
            st.close();

        } catch (SQLException ex) {
            ex.printStackTrace();
            System.out.println("Error al recuperar información...");
        }
        return rate;
    }

    public boolean addUserRating(Book book, User user, int calif) {
        try {
            String query = "insert into Ranking "
                    + " (GUName ,GUPassword ,GName ,GAutor, GCalif)"
                    + "  values (?,?,?,?,?)";
            PreparedStatement st =  conn.prepareStatement(query);
            st.setString(1, user.getUsername());
            st.setString(2, user.getPassword());
            st.setString(  3, book.getName());
            st.setString(4, book.getAutor());
            st.setInt(5, calif);

            st.execute();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }

        return false;
    }

    public boolean updateUserRating(Book book, User user, int calif) {
        try {
            String query = "update Ranking set GCalif = ? where GName = ? and GAutor = ? and GUName = ? and GUPassword = ? ";
            PreparedStatement st =  conn.prepareStatement(query);

            st.setInt(1, calif);
            st.setString(  2, book.getName());
            st.setString(3, book.getAutor());
            st.setString(4, user.getUsername());
            st.setString(5, user.getPassword());

            st.execute();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }

        return false;
    }

    public boolean updateRating(Book book){
        try {
            String query = "update Book set Calif = (select avg(GCalif) from Ranking where GName = ? and GAutor = ?) where Name = ? and Autor = ?";
            PreparedStatement st =  conn.prepareStatement(query);
            st.setString(  1, book.getName());
            st.setString(2, book.getAutor());
            st.setString(  3, book.getName());
            st.setString(4, book.getAutor());

            st.execute();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }

        return false;
    }
}
