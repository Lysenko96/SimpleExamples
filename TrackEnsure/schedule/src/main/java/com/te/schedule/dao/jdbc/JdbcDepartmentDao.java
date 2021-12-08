package com.te.schedule.dao.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.te.schedule.dao.DepartmentDao;
import com.te.schedule.dao.EmployeeDao;
import com.te.schedule.entity.Department;
import com.te.schedule.entity.Employee;
import com.te.schedule.provider.SingleProvider;

public class JdbcDepartmentDao implements DepartmentDao {

	private static SingleProvider provider;
	private EmployeeDao employeeDao;
	private static final String ADD_DEPARTMENT = "insert into department (name, change, synch, idEmployee, performance) values (?,?,?,?,?)";
	private static final String GET_DEPARTMENT = "select * from department where id=?";
	private static final String GET_ALL_DEPARTMENTS = "select * from department";
	private static final String UPDATE_DEPARTMENT = "update department set name=?, change=?, synch=?, idEmployee=?, performance=? where id=?";
	private static final String DELETE_DEPARTMENT = "delete from department where id=?";

	public JdbcDepartmentDao() {
		provider = SingleProvider.getInstance();
		employeeDao = new JdbcEmployeeDao();
	}

	@Override
	public void add(Department department) {
		try {
			Connection connection = provider.getConnection();
			PreparedStatement st = connection.prepareStatement(ADD_DEPARTMENT);
			st.setString(1, department.getName());
			st.setBoolean(2, department.isChange());
			st.setBoolean(3, department.isSynch());
			st.setInt(4, department.getEmployee().getId());
			st.setDouble(5, department.getPerformance());
			st.executeUpdate();
			ResultSet rs = st.getGeneratedKeys();
			if (rs.next()) {
				int key = rs.getInt(1);
				department.setId(key);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public Department getById(int id) {
		Department department = null;
		try {
			Connection connection = provider.getConnection();
			PreparedStatement st = connection.prepareStatement(GET_DEPARTMENT);
			st.setInt(1, id);
			ResultSet rs = st.executeQuery();
			if (rs.next()) {
				String name = rs.getString("name");
				boolean change = rs.getBoolean("change");
				boolean synch = rs.getBoolean("synch");
				int idEmployee = rs.getInt("idEmployee");
				double performance = rs.getDouble("performance");
				Employee employee = employeeDao.getById(idEmployee);
				department = new Department(id, name, employee, change, synch, performance);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return department;
	}

	@Override
	public List<Department> getAll() {
		List<Department> departments = new ArrayList<>();
		try {
			Connection connection = provider.getConnection();
			PreparedStatement st = connection.prepareStatement(GET_ALL_DEPARTMENTS);
			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				boolean change = rs.getBoolean("change");
				boolean synch = rs.getBoolean("synch");
				int idEmployee = rs.getInt("idEmployee");
				double performance = rs.getDouble("performance");
				Employee employee = employeeDao.getById(idEmployee);
				departments.add(new Department(id, name, employee, change, synch, performance));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return departments;
	}

	@Override
	public void update(Department department) {
		Department departmentDb = getById(department.getId());
		if (departmentDb != null && departmentDb.isChange() == true) {
			try {
				Connection connection = provider.getConnection();
				PreparedStatement st = connection.prepareStatement(UPDATE_DEPARTMENT);
				st.setString(1, department.getName());
				st.setBoolean(2, department.isChange());
				st.setBoolean(3, department.isSynch());
				st.setInt(4, department.getEmployee().getId());
				st.setDouble(5, department.getPerformance());
				st.setInt(6, department.getId());
				st.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public void deleteById(int id) {
		try {
			Connection connection = provider.getConnection();
			PreparedStatement st = connection.prepareStatement(DELETE_DEPARTMENT);
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
		JdbcDepartmentDao.provider = provider;
	}
}