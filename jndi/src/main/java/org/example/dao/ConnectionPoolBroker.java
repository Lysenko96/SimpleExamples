package org.example.dao;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Objects;

public enum ConnectionPoolBroker {

    INSTANCE;

    private HikariDataSource dataSource;
    private Connection connection;


    public void initializeDataSource(int maxPoolSize) {
        String hikariCpUrl = Objects.requireNonNull(ConnectionPoolBroker.class.getClassLoader().getResource("hikaricp.properties")).getFile();
        HikariConfig config = new HikariConfig(hikariCpUrl);
        config.setMaximumPoolSize(maxPoolSize);
        try {
            HikariDataSource dataSource = new HikariDataSource(config);
            setDataSource(dataSource);
            Connection conn = dataSource.getConnection();
            conn.setAutoCommit(false);
            setConnection(conn);
            //System.out.println(config.getMaximumPoolSize());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Connection getConnection(int maxPoolSize){
        initializeDataSource(maxPoolSize);
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
