package org.example.single;

import java.util.ArrayList;
import java.util.List;

public class SaveEntity { // save plain old java object

    private Entity entity;
    private List<Entity> entities;

    public SaveEntity() {
    }

    public SaveEntity(Entity entity, List<Entity> entities) {
        this.entity = entity;
        this.entities = entities;
    }

    public Entity getEntity() {
        return entity;
    }

    public void setEntity(Entity entity) {
        this.entity = entity;
    }

    public List<Entity> getEntities() {
        return entities;
    }

    public void setEntities(List<Entity> entities) {
        this.entities = entities;
    }

    void addEntity(){
        entities.add(entity);
    }

    void addEntity(Entity entity){
        entities.add(entity);
    }
}
