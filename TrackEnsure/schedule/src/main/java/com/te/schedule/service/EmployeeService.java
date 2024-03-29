package com.te.schedule.service;

import com.te.schedule.entity.Employee;
import com.te.schedule.entity.Type;

public class EmployeeService {

	private Employee employee;

	public EmployeeService(Employee employee) {
		this.employee = checkPreference(employee);

	}

	public Employee checkPreference(Employee employee) {
		int begin = employee.getBegin();
		Type type = employee.getType();
		boolean synch = employee.isSynch();
		double performance = 1.0;
		int hours = employee.getHours();
		double percent = employee.getPercent();
		int beginDiff = 9 - begin;
		employee.setEndWork(begin + 9);
		if (type.equals(Type.OFFICE)) {
			performance -= Math.abs(beginDiff) * 0.2;
		} else if (type.equals(Type.BEFORE)) {
			performance += beginDiff * 0.2;
		} else if (type.equals(Type.AFTER)) {
			performance += (-1) * beginDiff * 0.2;
		} else if (type.equals(Type.REMOTE) && synch == true) {
			performance -= Math.abs(beginDiff) * 0.2;
		}
		employee.setPerformance(validPerformance(performance));
		employee.setSalary((performance * hours) + (hours * percent));
		if (employee.getSalary() <= 0) {
			employee.setSalary(0.1);
		}
		return employee;
	}

	double validPerformance(double performance) {
		if (performance <= 0) {
			performance = 0.01;
		}
		return performance;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
}