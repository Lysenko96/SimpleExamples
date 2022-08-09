package com.spd.smartcooler.provider;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class Provider {

	public Connection connect(String pathConfig) {
		Connection connection = null;
		Properties properties = new Properties();
		try (FileReader reader = new FileReader(pathConfig)) {
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
