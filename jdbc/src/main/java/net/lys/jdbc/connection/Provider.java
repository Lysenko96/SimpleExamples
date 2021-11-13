package net.lys.jdbc.connection;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class Provider {

	private String url;
	private String user;
	private String password;

	public Provider() {
		Properties properties = read();
		if (properties != null) {
			this.url = properties.getProperty("url");
			this.user = properties.getProperty("user");
			this.password = properties.getProperty("password");
		}
	}

	public Connection getConnection() {
		Connection connection = null;
		try {
			connection = DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return connection;
	}

	private Properties read() {
		Properties properties = null;
		Path path = Paths
				.get(new File(Provider.class.getClassLoader().getResource("config.properties").getFile()).getPath());
		try (BufferedReader reader = Files.newBufferedReader(path)) {
			properties = new Properties();
			properties.load(reader);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return properties;
	}

}
