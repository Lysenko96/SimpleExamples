package org.example.dao;

import org.example.entity.Entity;

import java.util.List;

public interface EntityDao {

    Long add(Entity entity);

    List<Entity> getAll();

    Entity getById(Long id);

    Long update(Entity entity);

    void deleteById(Long id);

}
