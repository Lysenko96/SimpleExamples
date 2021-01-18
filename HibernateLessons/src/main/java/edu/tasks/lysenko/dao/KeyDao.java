package edu.tasks.lysenko.dao;

import java.util.List;

import edu.tasks.lysenko.entity.Key;

public interface KeyDao {

	void add(Key driver);

	Key getById(int id);

	List<Key> getAll();

	void update(Key driver);

	void removeById(int id);

}
