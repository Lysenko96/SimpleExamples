package com.example.demo.util;

import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.*;
import java.util.Properties;


@Component
public class Provider {

    public void getFromDatabaseJdbc() {
        Provider provider = new Provider();
        try(Connection conn = provider.getConnection();
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM person JOIN note ON person.id = note.person_id")) {
            try(ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    System.out.println(rs.getObject("id", Long.class));
                    System.out.println(rs.getString("first_name"));
                    System.out.println(rs.getString("last_name"));
                    System.out.println(rs.getString("email"));
                    System.out.println(rs.getString("body"));
                }
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
    }


    private String url;
    private String user;
    private String password;

    public Provider() {
        Properties properties = read();
        if (properties != null) {
            this.url = properties.getProperty("url");
            this.user = properties.getProperty("user");
            this.password = properties.getProperty("password");
        }
    }

    public Connection getConnection() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    private Properties read() {
        Properties properties = null;
        Path path = Paths
                .get(new File(Provider.class.getClassLoader().getResource("config.properties").getFile()).getPath());
        try (BufferedReader reader = Files.newBufferedReader(path)) {
            properties = new Properties();
            properties.load(reader);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return properties;
    }
}
