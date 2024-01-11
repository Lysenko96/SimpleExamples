package org.example.jdbcdemo;

import org.postgresql.ds.PGSimpleDataSource;

import java.lang.reflect.Proxy;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

public class CustomPoolDataSource extends PGSimpleDataSource {

    private static final int POOL_SIZE = 10;
    private Queue<Connection> connectionPool;

    public CustomPoolDataSource(String url, String username, String password) {
        super();
        setUrl(url);
        setUser(username);
        setPassword(password);

        connectionPool = new ConcurrentLinkedQueue<>();

        for (int i = 0; i < POOL_SIZE; i++) {
            try {
                Connection delegateConnection = super.getConnection();
                ConnectionProxy proxy = new ConnectionProxy(delegateConnection, connectionPool);
                connectionPool.add(proxy);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }

    @Override
    public Connection getConnection() throws SQLException {
        return connectionPool.poll();
    }
}
