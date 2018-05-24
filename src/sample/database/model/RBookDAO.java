package sample.database.model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
                        rs.getString("RAutor"),
                        rs.getString("RReview"),
                        rs.getString("RLink"),
                        rs.getString("RCat"),
                        rs.getString("RUname"),
                        rs.getString("RUpassword"),
                        rs.getString("RCover"));
                rbooks.add(p);
            }
            rs.close();
            st.close();

        } catch (SQLException ex) {
            ex.printStackTrace();
            System.out.println("Error al recuperar información...");
        }
        return rbooks;
    }

}
