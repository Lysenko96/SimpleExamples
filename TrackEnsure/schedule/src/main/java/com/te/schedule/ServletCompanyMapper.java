package com.te.schedule;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.te.schedule.dao.CompanyDao;
import com.te.schedule.dao.DepartmentDao;
import com.te.schedule.dao.EmployeeDao;
import com.te.schedule.entity.Company;
import com.te.schedule.entity.Department;

public class ServletCompanyMapper {

	private HttpServletRequest request;
	private HttpServletResponse response;
	private DepartmentDao departmentDao;
	private EmployeeDao employeeDao;
	private CompanyDao companyDao;

	public ServletCompanyMapper(ServletDepartmentMapper departmentMapper, CompanyDao companyDao) {
		this.request = departmentMapper.getRequest();
		this.response = departmentMapper.getResponse();
		this.employeeDao = departmentMapper.getEmployeeDao();
		this.departmentDao = departmentMapper.getDepartmentDao();
		this.companyDao = companyDao;
	}

	void showEditFormCompany() {
		int id = Integer.parseInt(request.getParameter("id"));
		Company companyDb = companyDao.getById(id);
		RequestDispatcher dispatcher = request.getRequestDispatcher("company-form.jsp");
		request.setAttribute("company", companyDb);
		try {
			dispatcher.forward(request, response);
		} catch (ServletException | IOException e) {
			e.printStackTrace();
		}
	}

	void addCompany() {
		String name = request.getParameter("name");
		String street = request.getParameter("street");
		int number = Integer.parseInt(request.getParameter("number"));
		int countPerson = Integer.parseInt(request.getParameter("countperson"));
		int idDepartment = Integer.parseInt(request.getParameter("iddepartment"));
		Department department = departmentDao.getById(idDepartment);
		if (department != null) {
			Company company = new Company(name, street, number, countPerson, department);
			companyDao.add(company);
			try {
				response.sendRedirect("listCompanies");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	void updateCompany() {
		int id = Integer.parseInt(request.getParameter("id"));
		String name = request.getParameter("name");
		String street = request.getParameter("street");
		int number = Integer.parseInt(request.getParameter("number"));
		int countPerson = Integer.parseInt(request.getParameter("countperson"));
		int idDepartment = Integer.parseInt(request.getParameter("iddepartment"));
		Department department = departmentDao.getById(idDepartment);
		Company company = new Company(id, name, street, number, countPerson, department);
		companyDao.update(company);
		try {
			response.sendRedirect("listCompanies");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	void deleteCompany() {
		int id = Integer.parseInt(request.getParameter("id"));
		Company company = companyDao.getById(id);
		int idDepartment = company.getDepartment().getId();
		Department department = departmentDao.getById(idDepartment);
		int idEmployee = department.getEmployee().getId();
		companyDao.deleteById(id);
		departmentDao.deleteById(idDepartment);
		employeeDao.deleteById(idEmployee);
		try {
			response.sendRedirect("listCompanies");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	void getCompanies() {
		List<Company> companies = companyDao.getAll();
		request.setAttribute("companies", companies);
		RequestDispatcher dispatcher = request.getRequestDispatcher("companies-list.jsp");
		try {
			dispatcher.forward(request, response);
		} catch (ServletException | IOException e) {
			e.printStackTrace();
		}
	}
}
