package org.example.dao.delegate;

import org.example.dao.DaoFactory;
import org.example.dao.EntityDao;
import org.example.entity.Entity;

import java.util.List;

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

    public List<Entity> getAllEntity() throws Exception {
        DaoFactory daoFactory = getDaoFactory();
        try {
            EntityDao dao = daoFactory.getEntityDao();
            return dao.getAll();
        } catch (Exception e){
            e.printStackTrace();
            throw new Exception();
        } finally {
            super.finalizeDaoFactory(daoFactory);
        }
    }

    public Entity getEntityById(long id) throws Exception {
        DaoFactory daoFactory = getDaoFactory();
        try {
            EntityDao dao = daoFactory.getEntityDao();
            return dao.getById(id);
        } catch (Exception e){
            e.printStackTrace();
            throw new Exception();
        } finally {
            super.finalizeDaoFactory(daoFactory);
        }
    }

    public void updateEntity(Entity entity) throws Exception {
        DaoFactory daoFactory = getDaoFactory();
        try {
            super.startTransaction(daoFactory);
            EntityDao dao = daoFactory.getEntityDao();
            dao.update(entity);
            super.commitTransaction(daoFactory);
        } catch (Exception e){
            e.printStackTrace();
            super.rollbackTransaction(daoFactory);
            throw new Exception();
        } finally {
            super.finalizeDaoFactory(daoFactory);
        }
    }

    public void deleteEntityById(long id) throws Exception {
        DaoFactory daoFactory = getDaoFactory();
        try {
            super.startTransaction(daoFactory);
            EntityDao dao = daoFactory.getEntityDao();
            dao.deleteById(id);
            super.commitTransaction(daoFactory);
        } catch (Exception e){
            e.printStackTrace();
            super.rollbackTransaction(daoFactory);
            throw new Exception();
        } finally {
            super.finalizeDaoFactory(daoFactory);
        }
    }
}
