package org.example.dao;

import org.example.dao.delegate.jdbc.PgEntityDao;
import org.example.provider.Provider;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class PgDaoFactory extends DaoFactory {

    private Connection connection;
    private volatile boolean inTransaction = false;

    public PgDaoFactory() {
        getConnectionFromPool();
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
        Connection con = null;
        try {
            Provider provider = new Provider();
            provider.setHikariPoolConnection();
            DataSource dataSource = provider.getSource();
            con = dataSource.getConnection();
            con.setAutoCommit(false);
            setConnection(con);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public EntityDao getEntityDao() {
        return new PgEntityDao();
    }

    public Connection getConnection() {
        return connection;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }
}
