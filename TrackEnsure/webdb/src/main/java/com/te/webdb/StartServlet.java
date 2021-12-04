package com.te.webdb;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.te.webdb.dao.jdbc.JdbcEmployeeDao;
import com.te.webdb.entity.Employee;

@WebServlet(urlPatterns = { "/start", "/result", "/json" })
public class StartServlet extends HttpServlet {

	// private Provider provider;
	// private DataSource source;
	// private static Connection connection;

	private static final long serialVersionUID = -4616851664568431876L;

	public void init() {
		// provider = new Provider();
//		try {
//			InitialContext context = new InitialContext();
//			source = (DataSource) context.lookup("java:/comp/env/jdbc/chinook");
//			
//		} catch (NamingException e) {
//			e.printStackTrace();
//		}
		// connection = SingleConnection.getInstance().getConnection();

	}

	public void show(List<Employee> employees, HttpServletResponse response) {
		try {
			PrintWriter writer = response.getWriter();
			ObjectMapper mapper = new ObjectMapper();
			mapper.writeValue(writer, employees);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		if (request.getServletPath().equals("/json")) {

			List<Employee> employees = new JdbcEmployeeDao().getAll();
			show(employees, response);

		} else {

			// if (connection != null) {
			response.getWriter().append("Served at: ").append(request.getContextPath());
			// new JdbcEmployeeDao().add(new Employee("lastName", "firstName",
			// "UkrainianAgent"));
			// System.out.println(new JdbcEmployeeDao().getById(111));
			// System.out.println(new JdbcEmployeeDao().getAll());
			// Employee employee = new Employee(111, "surname", "name", "RussianAgent");
			// new JdbcEmployeeDao().update(employee);
			// new JdbcEmployeeDao().deleteById(111);
			// System.out.println(new JdbcEmployeeDao().getAll());
			// } else {
//			PrintWriter writer = response.getWriter();
//			writer.write("Not connected");
			// }
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int year = Integer.parseInt(request.getParameter("year"));
		Employee e = new JdbcEmployeeDao().findEmployeeMaxByYear(year);

		System.out.println(e.toString());

	}

	public void destroy() {
	}

}
