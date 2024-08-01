package net.pack.jdbcstyle.dao;

import java.util.List;

import net.pack.jdbcstyle.entity.Person;

public interface PersonDao {

	void add(Person person);
	
	void addBatch(List<Person> persons);

	Person getById(long id);

	List<Person> getAll();

	void insertWithResultSet();

	void deleteById(long id);
}