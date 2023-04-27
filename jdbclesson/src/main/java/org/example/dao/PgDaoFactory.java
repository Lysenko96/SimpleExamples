package org.example.dao;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.example.dao.delegate.jdbc.PgEntityDao;
import org.example.provider.Provider;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Objects;

public class PgDaoFactory extends DaoFactory {

    public static final String JDBC_URL = "jdbc:postgresql://127.0.0.1:5432/postgres";
    public static final String JDBC_USER = "postgres";
    public static final String JDBC_PASSWORD = "postgresTE!";

    private Connection connection;
    private HikariDataSource dataSource;
    private static volatile boolean inTransaction = false;

    public PgDaoFactory() {
        getConnectionFromPool();
        //setDriverManagerConnection();
    }

    public void startTransaction() throws Exception {
        if (inTransaction) {
            throw new Exception("Cannot start transaction - already in transaction");
        }

        inTransaction = true;
    }

    public void commitTransaction() throws Exception {
        if (!inTransaction) {
            throw new Exception("Cannot commit transaction - not in transaction");
        }

        try {
            if (connection != null) {
                connection.commit();
            }

            inTransaction = false;
        } catch (SQLException e) {
            throw new Exception("Cannot commit transaction. " + e.getMessage());
        }
    }

    public void rollbackTransaction() throws Exception {
        if (!inTransaction) {
            throw new Exception("Cannot rollback transaction - not in transaction");
        }

        try {
            if (connection != null) {
                connection.rollback();
            }

            inTransaction = false;
        } catch (SQLException e) {
            throw new Exception("Cannot rollback transaction. " + e.getMessage());
        }
    }

    public void releaseConnections() throws Exception {
        if (this.connection != null) {
            try {
                this.connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
                throw new Exception(e.getMessage());
            }
        }
    }

    private void getConnectionFromPool() {
        try {
            setHikariPoolConnection();
            Connection conn = getConnection();
            //System.out.println(conn);
            conn.setAutoCommit(false);
            setConnection(conn);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

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

    @Override
    public EntityDao getEntityDao() {
        return new PgEntityDao(this);
    }

    public Connection getConnection() {
        return connection;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }

    public HikariDataSource getDataSource() {
        return dataSource;
    }

    public void setDataSource(HikariDataSource dataSource) {
        this.dataSource = dataSource;
    }
}
