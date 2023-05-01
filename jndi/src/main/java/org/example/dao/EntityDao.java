package org.example.dao;

import org.example.entity.Entity;

import java.util.List;

public interface EntityDao {

    Long add(Entity entity) throws Exception;

    List<Entity> getAll() throws Exception;

    Entity getById(long id) throws Exception;

    void update(Entity entity) throws Exception;

    void deleteById(long id) throws Exception;

}
