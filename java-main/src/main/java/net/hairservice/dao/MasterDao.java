package net.hairservice.dao;

import net.hairservice.entities.Master;

import java.util.List;

public interface MasterDao {

    void add(Master master);

    List<Master> getAll();

    Master getById(long id);

    void update(Master master);

    void deleteById(long id);
}