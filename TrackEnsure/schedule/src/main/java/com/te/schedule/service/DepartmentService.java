package com.te.schedule.service;

import java.util.ArrayList;
import java.util.List;

import com.te.schedule.dao.DepartmentDao;
import com.te.schedule.dao.jdbc.JdbcDepartmentDao;
import com.te.schedule.entity.Department;

public class DepartmentService {

	private Department department;

	public DepartmentService(Department department) {
		this.department = checkPerformance(department);
	}

	Department checkPerformance(Department department) {
		String name = department.getName();
		boolean change = department.isChange();
		boolean synch = department.isSynch();
		DepartmentDao departmentDao = new JdbcDepartmentDao();
		List<Department> departments = new ArrayList<>();
		for (Department departmentDb : departmentDao.getAll()) {
			String nameDb = departmentDb.getName();
			boolean changeDb = departmentDb.isChange();
			boolean synchDb = departmentDb.isSynch();
			if (nameDb.equals(name) && changeDb == change && synchDb == synch) {
				departments.add(departmentDb);
			}
		}
		departments.add(department);
		double avgPerformance = 0;
		for (Department obj : departments) {
			avgPerformance += obj.getEmployee().getPerformance();
		}
		avgPerformance /= departments.size();
		for (Department obj : departments) {
			obj.setPerformance(avgPerformance);
			departmentDao.update(obj);
		}
		return department;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}
}