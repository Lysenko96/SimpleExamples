package org.example.provider;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Objects;
import java.util.Properties;

public class Provider {

    public static final String JDBC_URL = "jdbc:postgresql://127.0.0.1:5432/postgres";
    public static final String JDBC_USER = "postgres";
    public static final String JDBC_PASSWORD = "postgresTE!";
    public static final String PATH_PROPS = "src/main/resources/configuration.properties";
    private HikariDataSource dataSource;
    private Connection connection;

    public void setHikariPoolConnection() {
        String hikariCpUrl = Objects.requireNonNull(Provider.class.getClassLoader().getResource("hikaricp.properties")).getFile();
        HikariConfig config = new HikariConfig(hikariCpUrl);
        try {
            HikariDataSource dataSource = new HikariDataSource(config);
            setDataSource(dataSource);
            Connection conn = dataSource.getConnection();
            setConnection(conn);
            //System.out.println(conn);
            //getSource().close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void setDriverManagerFromPropsConnection() {
        Properties props = new Properties();
        try {
            props.load(Files.newInputStream(Paths.get(PATH_PROPS).toAbsolutePath()));
            Connection conn = DriverManager.getConnection(props.getProperty("jdbc.url"), props.getProperty("jdbc.user"), props.getProperty("jdbc.password"));
            System.out.println(conn);
            conn.close();
        } catch (SQLException | IOException e) {
            e.printStackTrace();
        }

    }

    public void setDriverManagerConnection() {
        try {
            Connection conn = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
            System.out.println(conn);
            conn.setAutoCommit(false);
            setConnection(conn);
            //conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public HikariDataSource getDataSource() {
        return dataSource;
    }

    public void setDataSource(HikariDataSource dataSource) {
        this.dataSource = dataSource;
    }

    public Connection getConnection() {
        return connection;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }
}