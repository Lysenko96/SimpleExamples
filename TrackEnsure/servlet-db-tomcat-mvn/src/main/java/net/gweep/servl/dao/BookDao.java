package net.gweep.servl.dao;

import java.util.List;

import net.gweep.servl.entity.Book;

public interface BookDao {

	void add(Book book);
	
	Book getById(int id);
	
	List<Book> getAll();
	
	void update(Book book);
	
	void deleteById(int id);
}
