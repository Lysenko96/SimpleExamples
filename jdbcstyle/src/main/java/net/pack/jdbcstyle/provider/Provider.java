package net.pack.jdbcstyle.provider;

import static net.pack.jdbcstyle.entity.Sex.FEMALE;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import net.pack.jdbcstyle.dao.jdbc.JdbcPersonDao;
import net.pack.jdbcstyle.entity.Person;

public class Provider {

	//fixed
	
	public Connection getConnection() {
		String hikaricpUrl = Provider.class.getClassLoader().getResource("hikaricp.properties").getFile();
		HikariConfig config = new HikariConfig(hikaricpUrl);
		Person person = new Person("name", "surname", FEMALE, "name@email.com", 18, "address", 9379992, "666");
		try (HikariDataSource ds = new HikariDataSource(config);
				Connection conn = ds.getConnection();
				PreparedStatement st = conn.prepareStatement(
						"insert into person (name,surname,sex,email,year,address,phone, \"postCode\") values (?,?,?,?,?,?,?,?)",
						Statement.RETURN_GENERATED_KEYS)) {
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
			return conn;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}
