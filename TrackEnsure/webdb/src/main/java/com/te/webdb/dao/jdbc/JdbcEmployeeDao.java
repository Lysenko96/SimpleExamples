package com.te.webdb.dao.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.te.webdb.dao.EmployeeDao;
import com.te.webdb.entity.Employee;
import com.te.webdb.provider.SingleConnection;

public class JdbcEmployeeDao implements EmployeeDao {

	private static final String ADD_EMPLOYEE = "insert into \"Employee\" (\"EmployeeId\", \"LastName\" ,\"FirstName\" , \"Title\") values (?,?,?,?)";
	// private static final String ADD_EMPLOYEE = "insert into \"Employee\" (
	// \"LastName\" ,\"FirstName\" , \"Title\") values (?,?,?)";
	private static final String GET_EMPLOYEE = "select * from \"Employee\" where \"EmployeeId\"=? ";
	private static final String GET_ALL = "select * from \"Employee\"";
	private static final String UPDATE_EMPLOYEE = "update \"Employee\" set \"LastName\"=?, \"FirstName\"=?, \"Title\"=? where \"EmployeeId\"=?";
	private static final String DELETE_EMPLOYEE = "delete from \"Employee\" where \"EmployeeId\"=?";
	private static final String FIND_EMPLOYEE_MAX_BY_YEAR = "select \"Employee\".*, sum(\"Invoice\".\"Total\") "
			+ "from \"Invoice\" " + "left join \"Customer\" "
			+ "on \"Invoice\".\"CustomerId\"=\"Customer\".\"CustomerId\" " + "left join \"Employee\"  "
			+ "on \"Customer\".\"SupportRepId\"=\"Employee\".\"EmployeeId\" "
			+ " where extract(year from \"InvoiceDate\") in(?)  "
			+ "group by \"Employee\".\"EmployeeId\", \"Invoice\".\"Total\" " + "order by \"Total\" desc " + "limit 1";

	@Override
	public void add(Employee employee) {
		try (Connection connection = SingleConnection.getInstance().getConnection();
				PreparedStatement statement = connection.prepareStatement(ADD_EMPLOYEE)) {
			statement.setInt(1, employee.getEmployeeId());
			statement.setString(2, employee.getLastName());
			statement.setString(3, employee.getFirstName());
			statement.setString(4, employee.getTitle());
			statement.executeUpdate();
			ResultSet resultSet = statement.getGeneratedKeys();
			if (resultSet.next()) {
				int key = resultSet.getInt(1);
				employee.setEmployeeId(key);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public Employee getById(int id) {
		Employee employee = null;
		try (Connection connection = SingleConnection.getInstance().getConnection();
				PreparedStatement statement = connection.prepareStatement(GET_EMPLOYEE)) {
			statement.setInt(1, id);
			ResultSet resultSet = statement.executeQuery();
			if (resultSet.next()) {
				String lastName = resultSet.getString("LastName");
				String firstName = resultSet.getString("FirstName");
				String title = resultSet.getString("Title");
				employee = new Employee(id, lastName, firstName, title, 0.0d);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return employee;
	}

	@Override
	public List<Employee> getAll() {
		List<Employee> employees = new ArrayList<>();
		try (Connection connection = SingleConnection.getInstance().getConnection();
				PreparedStatement statement = connection.prepareStatement(GET_ALL)) {
			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()) {
				int id = resultSet.getInt("EmployeeId");
				String lastName = resultSet.getString("LastName");
				String firstName = resultSet.getString("FirstName");
				String title = resultSet.getString("Title");
				employees.add(new Employee(id, lastName, firstName, title, 0.0d));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return employees;
	}

	@Override
	public void update(Employee employee) {
		try (Connection connection = SingleConnection.getInstance().getConnection();
				PreparedStatement statement = connection.prepareStatement(UPDATE_EMPLOYEE)) {
			statement.setString(1, employee.getLastName());
			statement.setString(2, employee.getFirstName());
			statement.setString(3, employee.getTitle());
			statement.setInt(4, employee.getEmployeeId());
			statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void deleteById(int id) {
		try (Connection connection = SingleConnection.getInstance().getConnection();
				PreparedStatement statement = connection.prepareStatement(DELETE_EMPLOYEE)) {
			statement.setInt(1, id);
			statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public Employee findEmployeeMaxByYear(int year) {
		Employee employee = null;
		try (Connection connection = SingleConnection.getInstance().getConnection();
				PreparedStatement statement = connection.prepareStatement(FIND_EMPLOYEE_MAX_BY_YEAR)) {
			statement.setInt(1, year);
			ResultSet resultSet = statement.executeQuery();
			if (resultSet.next()) {
				int employeeId = resultSet.getInt(1);
				String lastName = resultSet.getString(2);
				String firstName = resultSet.getString(3);
				String title = resultSet.getString(4);
				Double sum = resultSet.getDouble(5);
				employee = new Employee(employeeId, lastName, firstName, title);
				employee.setInfo(sum);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return employee;
	}

}