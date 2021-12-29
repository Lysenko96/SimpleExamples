package net.pack.jdbcstyle.dao;

import java.util.List;

import net.pack.jdbcstyle.entity.Person;

public interface PersonDao {

	void add(Person person);

	Person getById(long id);

	List<Person> getAll();

	void update(Person person);

	void deleteById(long id);
}