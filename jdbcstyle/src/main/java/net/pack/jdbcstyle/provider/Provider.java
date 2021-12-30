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

	private HikariDataSource ds;

	public Connection getConnection() {
		String hikaricpUrl = Provider.class.getClassLoader().getResource("hikaricp.properties").getFile();
		HikariConfig config = new HikariConfig(hikaricpUrl);
		try {
			HikariDataSource ds = new HikariDataSource(config);
			this.ds = ds;
			Connection conn = ds.getConnection();
			return conn;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public HikariDataSource getDs() {
		return ds;
	}

	public void setDs(HikariDataSource ds) {
		this.ds = ds;
	}
}
