package org.example.dao.delegate.jdbc;

import org.example.dao.EntityDao;
import org.example.entity.Entity;

import java.util.List;

public class PgEntityDao implements EntityDao {

    @Override
    public Long add(Entity entity) {
        return null;
    }

    @Override
    public List<Entity> getAll() {
        return null;
    }

    @Override
    public Entity getById(Long id) {
        return null;
    }

    @Override
    public Long update(Entity entity) {
        return null;
    }

    @Override
    public void deleteById(Long id) {

    }
}
