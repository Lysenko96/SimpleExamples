package net.hairservice.dao;

import net.hairservice.entities.HairService;

import java.util.List;

public interface HairServiceDao {

    void add(HairService hairService);

    List<HairService> getAll();

    HairService getById(long id);

    void update(HairService hairService);

    void deleteById(long id);
}