package info.gweep.fileworker.dao;

import info.gweep.fileworker.entity.Entity;

public interface EntityDao {

    void add(Entity entity);

    Entity getById(Long id);
}
