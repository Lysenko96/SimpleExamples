package net.hairservice.dao;

import net.hairservice.entities.DaySchedule;

import java.util.List;

public interface DayScheduleDao {

    void add(DaySchedule schedule);

    List<DaySchedule> getAll();

    DaySchedule getById(long id);

    void update(DaySchedule schedule);

    void deleteById(long id);
}