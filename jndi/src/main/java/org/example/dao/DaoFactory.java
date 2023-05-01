package org.example.dao;

public abstract class DaoFactory {

    public abstract void startTransaction() throws Exception;

    public abstract void commitTransaction() throws Exception;

    public abstract void rollbackTransaction() throws Exception;

    public abstract void releaseConnections() throws Exception;

    public abstract EntityDao getEntityDao();

    public static DaoFactory getDaoFactory(){
        return new PgDaoFactory();
    }
}
