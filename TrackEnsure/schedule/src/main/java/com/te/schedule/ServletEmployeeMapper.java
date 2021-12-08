package com.te.schedule;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.te.schedule.dao.EmployeeDao;
import com.te.schedule.entity.Employee;
import com.te.schedule.entity.Role;
import com.te.schedule.entity.Type;
import com.te.schedule.service.EmployeeService;

public class ServletEmployeeMapper {

	private HttpServletRequest request;
	private HttpServletResponse response;
	private EmployeeDao employeeDao;

	public ServletEmployeeMapper(HttpServletRequest request, HttpServletResponse response, EmployeeDao employeeDao) {
		this.request = request;
		this.response = response;
		this.employeeDao = employeeDao;
	}

	void showEditFormEmployee() {
		int id = Integer.parseInt(request.getParameter("id"));
		Employee employeeDb = employeeDao.getById(id);
		RequestDispatcher dispatcher = request.getRequestDispatcher("employee-form.jsp");
		request.setAttribute("employee", employeeDb);
		try {
			dispatcher.forward(request, response);
		} catch (ServletException | IOException e) {
			e.printStackTrace();
		}
	}

	void addEmployee() {
		String name = request.getParameter("name");
		String surname = request.getParameter("surname");
		int hours = Integer.parseInt(request.getParameter("hours"));
		int begin = Integer.parseInt(request.getParameter("begin"));
		boolean synch = Boolean.valueOf(request.getParameter("synch"));
		Role role = Role.valueOf(request.getParameter("role"));
		Type type = Type.valueOf(request.getParameter("type"));
		double percent = Double.valueOf(request.getParameter("percent"));
		Employee employee = new Employee(name, surname, hours, begin, role, type, synch, percent);
		employeeDao.add(new EmployeeService(employee).getEmployee());
		try {
			response.sendRedirect("listEmployees");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	void updateEmployee() {
		int id = Integer.parseInt(request.getParameter("id"));
		String name = request.getParameter("name");
		String surname = request.getParameter("surname");
		int hours = Integer.parseInt(request.getParameter("hours"));
		int begin = Integer.parseInt(request.getParameter("begin"));
		boolean synch = Boolean.valueOf(request.getParameter("synch"));
		Role role = Role.valueOf(request.getParameter("role"));
		Type type = Type.valueOf(request.getParameter("type"));
		double percent = Double.valueOf(request.getParameter("percent"));
		Employee employee = new Employee(id, name, surname, hours, begin, role, type, synch, percent);
		employeeDao.update(new EmployeeService(employee).getEmployee());
		try {
			response.sendRedirect("listEmployees");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	void deleteEmployee() {
		int id = Integer.parseInt(request.getParameter("id"));
		employeeDao.deleteById(id);
		try {
			response.sendRedirect("listEmployees");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	void getEmployees() {
		List<Employee> employees = employeeDao.getAll();
		request.setAttribute("employees", employees);
		RequestDispatcher dispatcher = request.getRequestDispatcher("employees-list.jsp");
		try {
			dispatcher.forward(request, response);
		} catch (ServletException | IOException e) {
			e.printStackTrace();
		}
	}

	public HttpServletRequest getRequest() {
		return request;
	}

	public void setRequest(HttpServletRequest request) {
		this.request = request;
	}

	public HttpServletResponse getResponse() {
		return response;
	}

	public void setResponse(HttpServletResponse response) {
		this.response = response;
	}

	public EmployeeDao getEmployeeDao() {
		return employeeDao;
	}

	public void setEmployeeDao(EmployeeDao employeeDao) {
		this.employeeDao = employeeDao;
	}
}