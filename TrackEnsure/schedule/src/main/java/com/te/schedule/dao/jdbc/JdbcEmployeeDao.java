package com.te.schedule.dao.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.te.schedule.dao.EmployeeDao;
import com.te.schedule.entity.Employee;
import com.te.schedule.entity.Role;
import com.te.schedule.entity.Type;
import com.te.schedule.provider.SingleProvider;

public class JdbcEmployeeDao implements EmployeeDao {

	private static SingleProvider provider;
	private static final String ADD_EMPLOYEE = "insert into employee (name, surname, hours, begin, endWork, role, type, synch, performance, percent, salary) values (?,?,?,?,?,?,?,?,?,?,?)";
	private static final String GET_EMPLOYEE = "select * from employee where id=?";
	private static final String GET_ALL_EMPLOYEE = "select * from employee";
	private static final String UPDATE_EMPLOYEE = "update employee set name=?, surname=?, hours=?, begin=?, endWork=?, role=?, type=?, synch=?, performance=?, percent=?, salary=? where id=?";
	private static final String DELETE_EMPLOYEE = "delete from employee where id=?";

	public JdbcEmployeeDao() {
		provider = SingleProvider.getInstance();
	}

	@Override
	public void add(Employee employee) {
		try {
			Connection connection = provider.getConnection();
			PreparedStatement st = connection.prepareStatement(ADD_EMPLOYEE);
			st.setString(1, employee.getName());
			st.setString(2, employee.getSurname());
			st.setInt(3, employee.getHours());
			st.setInt(4, employee.getBegin());
			st.setInt(5, employee.getEndWork());
			st.setString(6, employee.getRole().name());
			st.setString(7, employee.getType().name());
			st.setBoolean(8, employee.isSynch());
			st.setDouble(9, employee.getPerformance());
			st.setDouble(10, employee.getPercent());
			st.setDouble(11, employee.getSalary());
			st.executeUpdate();
			ResultSet rs = st.getGeneratedKeys();
			if (rs.next()) {
				int key = rs.getInt(1);
				employee.setId(key);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public Employee getById(int id) {
		Employee employee = null;
		try {
			Connection connection = provider.getConnection();
			PreparedStatement st = connection.prepareStatement(GET_EMPLOYEE);
			st.setInt(1, id);
			ResultSet rs = st.executeQuery();
			if (rs.next()) {
				String name = rs.getString("name");
				String surname = rs.getString("surname");
				int hours = rs.getInt("hours");
				int begin = rs.getInt("begin");
				int endWork = rs.getInt("endWork");
				Role role = Role.valueOf(rs.getString("role"));
				Type type = Type.valueOf(rs.getString("type"));
				boolean synch = rs.getBoolean("synch");
				double performance = rs.getDouble("performance");
				double percent = rs.getDouble("percent");
				double salary = rs.getDouble("salary");
				employee = new Employee(id, name, surname, hours, begin, endWork, role, type, synch, performance,
						percent, salary);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return employee;
	}

	@Override
	public List<Employee> getAll() {
		List<Employee> employees = new ArrayList<>();
		try {
			Connection connection = provider.getConnection();
			PreparedStatement st = connection.prepareStatement(GET_ALL_EMPLOYEE);
			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				String surname = rs.getString("surname");
				int hours = rs.getInt("hours");
				int begin = rs.getInt("begin");
				int endWork = rs.getInt("endWork");
				Role role = Role.valueOf(rs.getString("role"));
				Type type = Type.valueOf(rs.getString("type"));
				boolean synch = rs.getBoolean("synch");
				double performance = rs.getDouble("performance");
				double percent = rs.getDouble("percent");
				double salary = rs.getDouble("salary");
				employees.add(new Employee(id, name, surname, hours, begin, endWork, role, type, synch, performance,
						percent, salary));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return employees;
	}

	@Override
	public void update(Employee employee) {
		try {
			Connection connection = provider.getConnection();
			PreparedStatement st = connection.prepareStatement(UPDATE_EMPLOYEE);
			st.setString(1, employee.getName());
			st.setString(2, employee.getSurname());
			st.setInt(3, employee.getHours());
			st.setInt(4, employee.getBegin());
			st.setInt(5, employee.getEndWork());
			st.setString(6, employee.getRole().name());
			st.setString(7, employee.getType().name());
			st.setBoolean(8, employee.isSynch());
			st.setDouble(9, employee.getPerformance());
			st.setDouble(10, employee.getPercent());
			st.setDouble(11, employee.getSalary());
			st.setInt(12, employee.getId());
			st.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void deleteById(int id) {
		try {
			Connection connection = provider.getConnection();
			PreparedStatement st = connection.prepareStatement(DELETE_EMPLOYEE);
			st.setInt(1, id);
			st.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static SingleProvider getProvider() {
		return provider;
	}

	public static void setProvider(SingleProvider provider) {
		JdbcEmployeeDao.provider = provider;
	}
}