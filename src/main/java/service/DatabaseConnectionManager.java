/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DatabaseConnectionManager {
    private final String url;

    public DatabaseConnectionManager() throws IOException {
        Properties props = new Properties();
        try (InputStream input = getClass().getClassLoader().getResourceAsStream("configdb.properties")) {
            if (input == null) {
                throw new IOException("Unable to find dbconfig.properties");
            }
            props.load(input);
        }

        String databaseName = props.getProperty("database.name");
        String username = props.getProperty("database.username");
        String password = props.getProperty("database.password");

        this.url = "jdbc:sqlserver://localhost:1433;database=" + databaseName
                + ";user=" + username
                + ";password=" + password
                + ";encrypt=true;trustServerCertificate=true;loginTimeout=30;";
    }

    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(this.url);
    }
}

