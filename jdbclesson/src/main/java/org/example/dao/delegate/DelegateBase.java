package org.example.dao.delegate;

import org.example.dao.DaoFactory;

public class DelegateBase {

    public void startTransaction(DaoFactory daoFactory) throws Exception {
        daoFactory.startTransaction();
    }

    public void commitTransaction(DaoFactory daoFactory) throws Exception {
        daoFactory.commitTransaction();
    }

    public void rollbackTransaction(DaoFactory daoFactory) throws Exception {
        daoFactory.rollbackTransaction();
    }

    public void releaseConnections(DaoFactory daoFactory) throws Exception {
        daoFactory.releaseConnections();
    }

    public void finalizeDaoFactory(DaoFactory daoFactory) throws Exception {
        releaseConnections(daoFactory);
    }

    public DaoFactory getDaoFactory(){
        return DaoFactory.getDaoFactory();
    }
}
