package org.gweep.springpet.dao;

import org.gweep.springpet.model.Task;

import java.util.List;

public interface TaskDao {

    void save(Task task);

    Task getById(long id);

    List<Task> getAll();

    void update(Task task);

    void deleteById(long id);
}
