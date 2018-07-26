package model.dao;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConectaBd {
    private static final String url = "jdbc:postgresql://localhost:5432/smarttraining";
    private static final String usuario = "postgres";
    private static final String senha = "123456";
    private static Connection conn;
    
    public static Connection conecta(){
        try {
            Class.forName("org.postgresql.Driver");
            try {
                conn = DriverManager.getConnection(url, usuario, senha);
            } catch (SQLException ex) {
                Logger.getLogger(ConectaBd.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ConectaBd.class.getName()).log(Level.SEVERE, null, ex);
        }
        return conn;
    }
}
