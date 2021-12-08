package com.te.schedule.dao;

import java.util.List;

import com.te.schedule.entity.Company;

public interface CompanyDao {

	void add(Company company);

	Company getById(int id);

	List<Company> getAll();

	void update(Company company);

	void deleteById(int id);
}