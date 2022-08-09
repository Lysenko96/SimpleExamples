package com.spd.smartcooler.dao;

import java.util.List;

import com.spd.smartcooler.entity.Cooler;

public interface CoolerDao {

	boolean add(Cooler cooler);

	Cooler getById(int id);

	List<Cooler> getAll();

	boolean update(Cooler cooler);

	boolean deleteById(int id);
}