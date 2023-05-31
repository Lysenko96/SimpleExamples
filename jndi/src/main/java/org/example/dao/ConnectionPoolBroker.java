package org.example.dao;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Objects;

public enum ConnectionPoolBroker {

    INSTANCE;

    private static final int MAX_POOL_SIZE = 7;
    private HikariDataSource dataSource;
    private Connection connection;

    public void initializeDataSource() {
        String hikariCpUrl = Objects.requireNonNull(ConnectionPoolBroker.class.getClassLoader().getResource("hikaricp.properties")).getFile();
        HikariConfig config = new HikariConfig(hikariCpUrl);
        config.setMaximumPoolSize(MAX_POOL_SIZE);
        System.out.println(config.getMaximumPoolSize());
        try {
            HikariDataSource dataSource = new HikariDataSource(config);
           // System.out.println(dataSource.getMaximumPoolSize() + " setupHikari");
            setDataSource(dataSource);
            Connection conn = dataSource.getConnection();
            conn.setAutoCommit(false);
            setConnection(conn);
            //System.out.println(config.getMaximumPoolSize());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Connection getConnection(){
        initializeDataSource();
        return connection;
    }

    public HikariDataSource getDataSource() {
        return dataSource;
    }

    public void setDataSource(HikariDataSource dataSource) {
        this.dataSource = dataSource;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }
}
