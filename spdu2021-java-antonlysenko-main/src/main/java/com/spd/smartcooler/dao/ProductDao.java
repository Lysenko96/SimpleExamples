package com.spd.smartcooler.dao;

import java.util.List;

import com.spd.smartcooler.entity.Product;

public interface ProductDao {

	boolean add(Product product);

	Product getById(int id);

	List<Product> getAll();

	boolean update(Product product);

	boolean deleteById(int id);
}
