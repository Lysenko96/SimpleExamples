package com.te.webdb.entity;

import java.util.Objects;

public class Employee {

	private int employeeId;
	private String lastName;
	private String firstName;
	private String title;
	private Object info;
	
	
	public Employee() {
		
	}

	public Employee(int employeeId, String lastName, String firstName, String title, Object info) {
		this.employeeId = employeeId;
		this.lastName = lastName;
		this.firstName = firstName;
		this.title = title;
		this.info = info;
	}



	public Employee(String lastName, String firstName, String title) {
		this.lastName = lastName;
		this.firstName = firstName;
		this.title = title;
	}



	public Employee(int employeeId, String lastName, String firstName, String title) {
		this.employeeId = employeeId;
		this.lastName = lastName;
		this.firstName = firstName;
		this.title = title;
	}

	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Object getInfo() {
		return info;
	}

	public void setInfo(Object info) {
		this.info = info;
	}

	@Override
	public int hashCode() {
		return Objects.hash(employeeId, firstName, info, lastName, title);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		return employeeId == other.employeeId && Objects.equals(firstName, other.firstName)
				&& Objects.equals(info, other.info) && Objects.equals(lastName, other.lastName)
				&& Objects.equals(title, other.title);
	}

	@Override
	public String toString() {
		return "Employee [employeeId=" + employeeId + ", lastName=" + lastName + ", firstName=" + firstName + ", title="
				+ title + ", info=" + info + "]";
	}
	
	
	
	
}