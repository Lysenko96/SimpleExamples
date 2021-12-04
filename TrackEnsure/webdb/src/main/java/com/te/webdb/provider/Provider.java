package com.te.webdb.provider;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class Provider {

	public Connection connect() {
		Connection connection = null;
		Properties properties = new Properties();
		// absolute path for config.properties
		try (FileReader reader = new FileReader("C:/Users/gweep/eclipse-workspace/webdb/src/main/resources/config.properties")) {
			properties.load(reader);
			String driver = properties.getProperty("db.driver");
			Class.forName(driver);
			String url = properties.getProperty("db.url");
			String user = properties.getProperty("db.user");
			String pass = properties.getProperty("db.password");
			connection = DriverManager.getConnection(url, user, pass);
		} catch (SQLException | ClassNotFoundException | IOException e) {
			e.printStackTrace();
		}
		return connection;
	}
}
