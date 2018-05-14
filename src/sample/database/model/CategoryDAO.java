package sample.database.model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CategoryDAO {
    private Connection conn;
    public CategoryDAO(Connection conn)
    {
        this.conn = conn;
    }

    public Category findCategory(String cve) {
        Category category = null;
        try {
            String query = "SELECT * FROM Category where CveCat = '"+cve+"'";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(query);
            if(rs.next()){
                category=new Category(rs.getString("CveCat"),
                                    rs.getString("DescCat"));
            }
            rs.close();
            st.close();

        } catch (SQLException ex) {
            ex.printStackTrace();
            System.out.println("Error al recuperar información...");
        }
        return category;
    }
}
