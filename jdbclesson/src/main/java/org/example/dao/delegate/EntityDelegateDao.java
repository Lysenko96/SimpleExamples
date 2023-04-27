package org.example.dao.delegate;

import org.example.dao.DaoFactory;
import org.example.dao.EntityDao;
import org.example.entity.Entity;

public class EntityDelegateDao extends DelegateBase {

    public Long addEntity(Entity entity) throws Exception {
        DaoFactory daoFactory = getDaoFactory();
        try {
            super.startTransaction(daoFactory);
            EntityDao dao = daoFactory.getEntityDao();
            Long id = dao.add(entity);
            super.commitTransaction(daoFactory);
            return id;
        } catch (Exception e){
            e.printStackTrace();
            super.rollbackTransaction(daoFactory);
            throw new Exception(); // if comment need return
        } finally {
            super.finalizeDaoFactory(daoFactory);
        }
    }
}
