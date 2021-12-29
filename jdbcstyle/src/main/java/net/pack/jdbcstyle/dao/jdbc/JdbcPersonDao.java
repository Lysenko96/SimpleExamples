package net.pack.jdbcstyle.dao.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import net.pack.jdbcstyle.dao.PersonDao;
import net.pack.jdbcstyle.entity.Sex;
import net.pack.jdbcstyle.entity.Person;
import net.pack.jdbcstyle.provider.Provider;

public class JdbcPersonDao implements PersonDao {

	private Provider provider;
	private static final String ADD_PERSON = "insert into person (name,surname,sex,email,age,address,phone, \"postCode\" values (?,?,?,?,?,?,?,?)";
//	private static final String GET_PERSON_BY_ID = "";
	private static final String GET_ALL_PERSONS = "select * from persondb";
//	private static final String UPDATE_PERSON = "";
//	private static final String DELETE_PERSON_BY_ID = "";

	public JdbcPersonDao(Provider provider) {
		this.provider = provider;
	}

	@Override
	public void add(Person person) {
		try (Connection conn = provider.getConnection();
				PreparedStatement st = conn.prepareStatement(ADD_PERSON, Statement.RETURN_GENERATED_KEYS)) {
			st.setString(1, person.getName());
			st.setString(2, person.getSurname());
			st.setString(3, person.getSex().name());
			st.setString(4, person.getEmail());
			st.setInt(5, person.getYear());
			st.setString(6, person.getAddress());
			st.setInt(7, person.getPhone());
			st.setString(8, person.getPostCode());
			st.executeUpdate();
			ResultSet rs = st.getGeneratedKeys();
			if (rs.next()) {
				long key = rs.getInt("id");
				person.setId(key);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public Person getById(long id) {
		return null;
	}

	@Override
	public List<Person> getAll() {
		List<Person> persons = new ArrayList<>();
		try (Connection conn = provider.getConnection();
				PreparedStatement st = conn.prepareStatement(GET_ALL_PERSONS)) {
			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				long id = rs.getInt("id");
				String name = rs.getString("name");
				String surname = rs.getString("surname");
				Sex sex = Sex.valueOf(rs.getString("sex"));
				String email = rs.getString("email");
				int year = rs.getInt("year");
				String address = rs.getString("address");
				int phone = rs.getInt("phone");
				String postCode = rs.getString("\"postCode\"");
				persons.add(new Person(id, name, surname, sex, email, year, address, phone, postCode));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return persons;
	}

	@Override
	public void update(Person person) {

	}

	@Override
	public void deleteById(long id) {

	}
}