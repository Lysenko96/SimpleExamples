package com.te.schedule;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.util.List;
import java.util.logging.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.te.schedule.dao.CompanyDao;
import com.te.schedule.dao.DepartmentDao;
import com.te.schedule.dao.EmployeeDao;
import com.te.schedule.dao.jdbc.JdbcCompanyDao;
import com.te.schedule.dao.jdbc.JdbcDepartmentDao;
import com.te.schedule.dao.jdbc.JdbcEmployeeDao;
import com.te.schedule.entity.Role;

// add tests for jdbc

@WebServlet(urlPatterns = { "/" })
public class StartServlet extends HttpServlet {

	private static final long serialVersionUID = 1180437010754947643L;
	private EmployeeDao employeeDao;
	private DepartmentDao departmentDao;
	private CompanyDao companyDao;
	private static final String BACK_TO_EMPLOYEES = "<a href=/schedule/listEmployees>Employees</a>";
	private static final String BACK_TO_DEPARTMENTS = "<a href=/schedule/listDepartments>Departments</a>";
	private static final String BACK_TO_COMPANIES = "<a href=/schedule/listCompanies>Companies</a>";
	private static final Logger log = Logger.getLogger(StartServlet.class.getSimpleName());

	public StartServlet() {
		employeeDao = new JdbcEmployeeDao();
		departmentDao = new JdbcDepartmentDao();
		companyDao = new JdbcCompanyDao();
	}

	public void init() {
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		process(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		process(request, response);
	}

	// split method process for several methods
	
	public void process(HttpServletRequest request, HttpServletResponse response) throws IOException {
		Connection connection = JdbcEmployeeDao.getProvider().getConnection();
		if (connection != null) {
			ServletEmployeeMapper employeeMapper = new ServletEmployeeMapper(request, response, employeeDao);
			ServletDepartmentMapper departmentMapper = new ServletDepartmentMapper(employeeMapper, departmentDao);
			ServletCompanyMapper companyMapper = new ServletCompanyMapper(departmentMapper, companyDao);
			String action = request.getServletPath();
			if (action.equalsIgnoreCase("/newEmployee")) {
				showNewForm(request, response, "employee-form.jsp");
			} else if (action.equalsIgnoreCase("/dispatcherEmployee")) {
				Role role = Role.valueOf(request.getParameter("role"));
				if (role.equals(Role.EMPLOYEE)) {
					showNewForm(request, response, "employee-form.jsp");
				} else if (role.equals(Role.EMPLOYEE_BY_HOURS)) {
					showNewForm(request, response, "employee-by-hours-form.jsp");
				} else if (role.equals(Role.EMPLOYEE_BY_PERCENT)) {
					showNewForm(request, response, "employee-by-percent-form.jsp");
				}
			} else if (action.equalsIgnoreCase("/addEmployee")) {
				employeeMapper.addEmployee();
			} else if (action.equalsIgnoreCase("/editEmployee")) {
				employeeMapper.showEditFormEmployee();
			} else if (action.equalsIgnoreCase("/updateEmployee")) {
				employeeMapper.updateEmployee();
			} else if (action.equalsIgnoreCase("/deleteEmployee")) {
				employeeMapper.deleteEmployee();
			} else if (action.equalsIgnoreCase("/listEmployees")) {
				employeeMapper.getEmployees();
			} else if (action.equalsIgnoreCase("/jsonListEmployees")) {
				response.setContentType("text/html");
				response.getWriter().append(BACK_TO_EMPLOYEES).append("<br>");
				showJsonObjects(employeeDao.getAll(), response);
			} else if (action.equalsIgnoreCase("/newDepartment")) {
				showNewForm(request, response, "department-form.jsp");
			} else if (action.equalsIgnoreCase("/addDepartment")) {
				response.setContentType("text/html");
				response.getWriter().append("Employee not exists").append("<br>");
				response.getWriter().append(BACK_TO_DEPARTMENTS).append("<br>");
				departmentMapper.addDepartment();
			} else if (action.equalsIgnoreCase("/editDepartment")) {
				departmentMapper.showEditFormDepartment();
			} else if (action.equalsIgnoreCase("/updateDepartment")) {
				departmentMapper.updateDepartment();
			} else if (action.equalsIgnoreCase("/deleteDepartment")) {
				departmentMapper.deleteDepartment();
			} else if (action.equalsIgnoreCase("/listDepartments")) {
				departmentMapper.getDepartments();
			} else if (action.equalsIgnoreCase("/jsonListDepartments")) {
				response.setContentType("text/html");
				response.getWriter().append(BACK_TO_DEPARTMENTS).append("<br>");
				showJsonObjects(departmentDao.getAll(), response);
			} else if (action.equalsIgnoreCase("/newCompany")) {
				showNewForm(request, response, "company-form.jsp");
			} else if (action.equalsIgnoreCase("/addCompany")) {
				response.setContentType("text/html");
				response.getWriter().append("Department not exists").append("<br>");
				response.getWriter().append(BACK_TO_COMPANIES).append("<br>");
				companyMapper.addCompany();
			} else if (action.equalsIgnoreCase("/editCompany")) {
				companyMapper.showEditFormCompany();
			} else if (action.equalsIgnoreCase("/updateCompany")) {
				companyMapper.updateCompany();
			} else if (action.equalsIgnoreCase("/deleteCompany")) {
				companyMapper.deleteCompany();
			} else if (action.equalsIgnoreCase("/listCompanies")) {
				companyMapper.getCompanies();
			} else if (action.equalsIgnoreCase("/jsonListCompanies")) {
				response.setContentType("text/html");
				response.getWriter().append(BACK_TO_COMPANIES).append("<br>");
				showJsonObjects(companyDao.getAll(), response);
			}
		} else {
			response.setContentType("text/html");
			response.getWriter().append("<h2>Database no connection</h2>");
		}
	}

	void showNewForm(HttpServletRequest request, HttpServletResponse response, String nameJspPage) {
		RequestDispatcher dispatcher = request.getRequestDispatcher(nameJspPage);
		try {
			dispatcher.forward(request, response);
		} catch (ServletException | IOException e) {
			e.printStackTrace();
		}
	}

	public void showJsonObjects(List objects, HttpServletResponse response) {
		try {
			if (objects == null) {
				log.info("list is null");
			} else if (!objects.isEmpty()) {
				PrintWriter writer = response.getWriter();
				ObjectMapper mapper = new ObjectMapper();
				mapper.writeValue(writer, objects);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void destroy() {
	}
}
