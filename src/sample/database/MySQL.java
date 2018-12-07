package sample.database;/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author niluxer
 */
public class MySQL {
    private static Connection conn = null;
    private static String hostname   = "localhost";
    private static String dbname = "Bookstore";
    private static String dbuser = "root";
    private static String dbpass = "";
    

    public static void Connect() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
                conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Bookstore?useSSL=false&useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC","root","c7d7f11f9e");

                System.out.println("Se ha iniciado la conexión con el servidor de forma exitosa");
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(MySQL.class.getName()).log(Level.SEVERE, null, ex);
            } catch (Exception ex) {
                Logger.getLogger(MySQL.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
    
    public static Connection getConnection()
    {
        if(conn == null) Connect();
        return conn;
    }
    
    public static void Disconnect() {
        try {
            conn.close();
            System.out.println("Se ha finalizado la conexión con el servidor");
        } catch (SQLException ex) {
            Logger.getLogger(MySQL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    
}
