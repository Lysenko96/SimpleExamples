package com.te.webdb.dao;

import java.util.List;

import com.te.webdb.entity.Employee;

public interface EmployeeDao {

	void add(Employee employee);

	Employee getById(int id);

	List<Employee> getAll();

	void update(Employee employee);

	void deleteById(int id);
}