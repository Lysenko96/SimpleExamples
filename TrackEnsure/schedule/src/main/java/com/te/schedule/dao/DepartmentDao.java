package com.te.schedule.dao;

import java.util.List;

import com.te.schedule.entity.Department;

public interface DepartmentDao {

	void add(Department department);

	Department getById(int id);

	List<Department> getAll();

	void update(Department department);

	void deleteById(int id);
}