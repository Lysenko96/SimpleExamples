package edu.tasks.lysenko.dao;

import java.util.List;

import edu.tasks.lysenko.entity.Key;

public interface KeyDao {

	void add(Key key);

	Key getById(int id);

	List<Key> getAll();

	void update(Key key);

	void remove(Key key);

}
