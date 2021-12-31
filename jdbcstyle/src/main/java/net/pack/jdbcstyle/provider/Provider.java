package net.pack.jdbcstyle.provider;

import java.sql.Connection;
import java.sql.SQLException;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

public class Provider {

	private HikariDataSource source;

	public Connection getConnection() {
		String hikaricpUrl = Provider.class.getClassLoader().getResource("hikaricp.properties").getFile();
		HikariConfig config = new HikariConfig(hikaricpUrl);
		try {
			HikariDataSource localSrc = new HikariDataSource(config);
			this.source = localSrc;
			return localSrc.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public HikariDataSource getDs() {
		return source;
	}

	public void setDs(HikariDataSource source) {
		this.source = source;
	}
}
