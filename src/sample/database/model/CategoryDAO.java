package sample.database.model;

import javax.swing.*;
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
            JOptionPane.showMessageDialog(null,"Error al recuperar información...");
        }
        return category;
    }

    public Category findCategoryByDesc(String desc) {
        Category category = null;
        try {

            String query = "SELECT * FROM Category where DescCat = '"+desc+"'";
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
            JOptionPane.showMessageDialog(null,"Error al recuperar información...");
        }
        return category;
    }
}
