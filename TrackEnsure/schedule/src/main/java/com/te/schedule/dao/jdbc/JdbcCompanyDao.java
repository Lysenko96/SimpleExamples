package com.te.schedule.dao.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.te.schedule.dao.CompanyDao;
import com.te.schedule.dao.DepartmentDao;
import com.te.schedule.entity.Company;
import com.te.schedule.entity.Department;
import com.te.schedule.provider.SingleProvider;

public class JdbcCompanyDao implements CompanyDao {

	private static SingleProvider provider;
	private DepartmentDao departmentDao;
	private static final String ADD_COMPANY = "insert into company (name, street, number, countPerson, idDepartment) values (?,?,?,?,?)";
	private static final String GET_COMPANY = "select * from company where id=?";
	private static final String GET_ALL_COMPANIES = "select * from company";
	private static final String UPDATE_COMPANY = "update company set name=?, street=?, number=?, countPerson=?, idDepartment=? where id=?";
	private static final String DELETE_COMPANY = "delete from company where id=?";

	public JdbcCompanyDao() {
		provider = SingleProvider.getInstance();
		departmentDao = new JdbcDepartmentDao();
	}

	@Override
	public void add(Company company) {
		try {
			Connection connection = provider.getConnection();
			PreparedStatement st = connection.prepareStatement(ADD_COMPANY);
			st.setString(1, company.getName());
			st.setString(2, company.getStreet());
			st.setInt(3, company.getNumber());
			st.setInt(4, company.getCountPerson());
			st.setInt(5, company.getDepartment().getId());
			st.executeUpdate();
			ResultSet rs = st.getGeneratedKeys();
			if (rs.next()) {
				int key = rs.getInt(1);
				company.setId(key);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public Company getById(int id) {
		Company company = null;
		try {
			Connection connection = provider.getConnection();
			PreparedStatement st = connection.prepareStatement(GET_COMPANY);
			st.setInt(1, id);
			ResultSet rs = st.executeQuery();
			if (rs.next()) {
				String name = rs.getString("name");
				String street = rs.getString("street");
				int number = rs.getInt("number");
				int countPerson = rs.getInt("countPerson");
				int idDepartment = rs.getInt("idDepartment");
				Department department = departmentDao.getById(idDepartment);
				company = new Company(id, name, street, number, countPerson, department);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return company;
	}

	@Override
	public List<Company> getAll() {
		List<Company> companies = new ArrayList<>();
		try {
			Connection connection = provider.getConnection();
			PreparedStatement st = connection.prepareStatement(GET_ALL_COMPANIES);
			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				String street = rs.getString("street");
				int number = rs.getInt("number");
				int countPerson = rs.getInt("countPerson");
				int idDepartment = rs.getInt("idDepartment");
				Department department = departmentDao.getById(idDepartment);
				companies.add(new Company(id, name, street, number, countPerson, department));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return companies;
	}

	@Override
	public void update(Company company) {
		try {
			Connection connection = provider.getConnection();
			PreparedStatement st = connection.prepareStatement(UPDATE_COMPANY);
			st.setString(1, company.getName());
			st.setString(2, company.getStreet());
			st.setInt(3, company.getNumber());
			st.setInt(4, company.getCountPerson());
			st.setInt(5, company.getDepartment().getId());
			st.setInt(6, company.getId());
			st.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void deleteById(int id) {
		try {
			Connection connection = provider.getConnection();
			PreparedStatement st = connection.prepareStatement(DELETE_COMPANY);
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
		JdbcCompanyDao.provider = provider;
	}
}
