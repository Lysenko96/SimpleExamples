package net.hairservice.dao;

import net.hairservice.entities.Duration;

import java.util.List;

public interface DurationDao {

    void add(Duration duration);

    List<Duration> getAll();

    Duration getById(long id);

    void update(Duration duration);

    void deleteById(long id);
}