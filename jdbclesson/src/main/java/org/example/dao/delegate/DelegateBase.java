package org.example.dao.delegate;

import org.example.dao.DaoFactory;

public class DelegateBase {

    public void startTransaction() throws Exception {
        getDaoFactory().startTransaction();
    }

    public void commitTransaction() throws Exception {
        getDaoFactory().commitTransaction();
    }

    public void rollbackTransaction() throws Exception {
        getDaoFactory().rollbackTransaction();
    }

    public void releaseConnections() throws Exception {
        getDaoFactory().releaseConnections();
    }

    public void finalizeDaoFactory() throws Exception {
        releaseConnections();
    }

    public DaoFactory getDaoFactory(){
        return DaoFactory.getDaoFactory();
    }
}
