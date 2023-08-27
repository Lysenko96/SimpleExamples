package info.gweep.fileworker.provider;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import static info.gweep.fileworker.DbFileWorkerServlet.PATH_FILE;

public class Provider {
    private String url;
    private String user;
    private String password;
    private String driver;

    public Provider() {
        Properties properties = read();
        if (properties != null) {
            this.url = properties.getProperty("url");
            this.user = properties.getProperty("user");
            this.password = properties.getProperty("password");
            this.driver = properties.getProperty("driver");
        }
    }

    public Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName(driver);
            connection = DriverManager.getConnection(url, user, password);
            connection.setAutoCommit(false);
        } catch (SQLException  e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return connection;
    }

    private Properties read() {
        Properties properties = null;
        Path path = Paths.get(PATH_FILE);
        System.out.println(path);
        try (BufferedReader reader = Files.newBufferedReader(path)) {
            properties = new Properties();
            properties.load(reader);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return properties;
    }

}
