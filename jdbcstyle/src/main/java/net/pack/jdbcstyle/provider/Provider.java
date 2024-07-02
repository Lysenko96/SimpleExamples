package net.pack.jdbcstyle.provider;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import com.zaxxer.hikari.util.IsolationLevel;

public class Provider {

	private HikariDataSource source;

	public Connection getConnection() {
		String hikaricpUrl = Provider.class.getProtectionDomain().getClassLoader().getResource("hikaricp.properties").getPath();
		HikariConfig config = new HikariConfig(hikaricpUrl);
		config.setTransactionIsolation(IsolationLevel.TRANSACTION_READ_UNCOMMITTED.name());
		try {
			HikariDataSource localSrc = new HikariDataSource(config);
			this.source = localSrc;
			System.out.println(source.getTransactionIsolation());
//			return localSrc.getConnection();
			return DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", config.getDataSourceProperties().getProperty("user"), config.getDataSourceProperties().getProperty("password"));
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
