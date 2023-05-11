package org.example.dao;

import com.zaxxer.hikari.HikariDataSource;
import org.example.dao.delegate.jdbc.PgEntityDao;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class PgDaoFactory extends DaoFactory {

    private String DATASOURCE_JNDI_NAME = "java:/comp/env/jdbc/postgres";
    private Connection connection;
    private HikariDataSource dataSource;
    private static volatile boolean inTransaction = false;



    public PgDaoFactory() {
        //setupConnections();
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

    public void setupConnections() {
        Context context = null;
        try {
            context = new InitialContext();
            DataSource source = (DataSource) context.lookup(DATASOURCE_JNDI_NAME);
            Connection conn = source.getConnection();
            conn.setAutoCommit(false);
            setConnection(conn);
        } catch (NamingException | SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void getConnectionFromPool(){
        setConnection(ConnectionPoolBroker.INSTANCE.getConnection());
        setDataSource(ConnectionPoolBroker.INSTANCE.getDataSource());
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
