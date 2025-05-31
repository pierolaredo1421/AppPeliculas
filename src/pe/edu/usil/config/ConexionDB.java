package pe.edu.usil.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.io.InputStream;

public class ConexionDB {
    private static String url;
    private static String user;
    private static String password;

    static {
        try (InputStream input = ConexionDB.class.getClassLoader().getResourceAsStream("db.properties")) {
            Properties prop = new Properties();
            prop.load(input);
            url = prop.getProperty("db.url");
            user = prop.getProperty("db.user");
            password = prop.getProperty("db.password");
            Class.forName(prop.getProperty("db.driver"));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static Connection getConexion() throws SQLException {
        return DriverManager.getConnection(url, user, password);
    }
}