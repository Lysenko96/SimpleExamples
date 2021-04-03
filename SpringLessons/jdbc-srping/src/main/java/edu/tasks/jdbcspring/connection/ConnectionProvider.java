//package edu.tasks.jdbcspring.connection;
//
//import static edu.tasks.jdbcsrping.scriptrunner.ScriptRunner.getPath;
//
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.nio.charset.StandardCharsets;
//import java.nio.file.Files;
//import java.nio.file.Path;
//import java.nio.file.Paths;
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.SQLException;
//import java.util.Properties;
//
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.stereotype.Component;
//@Component
//public class ConnectionProvider {
//
//	//private static final String URL = "db.url";
//	//private static final String USER = "db.user";
//	//private static final String PASSWD = "db.passwd";
//
//	@Value("${connectionProvider.url}")
//	private String url;
//	@Value("${connectionProvider.user}")
//	private String user;
//	@Value("${connectionProvider.passwd}")
//	private String passwd;
//
//	
////	public ConnectionProvider(String fileName) {
////		Properties properties = readProperties(fileName);
////		this.url = properties.getProperty(URL);
////		this.user = properties.getProperty(USER);
////		this.passwd = properties.getProperty(PASSWD);
////	}
////
////	private Properties readProperties(String fileName) {
////		Properties properties = new Properties();
////		Path config = Paths.get(getPath(fileName));
////		try (BufferedReader reader = Files.newBufferedReader(config, StandardCharsets.UTF_8);) {
////			properties.load(reader);
////			return properties;
////		} catch (IOException e) {
////			e.printStackTrace();
////		}
////		return null;
////	}
//	public Connection getConnection() throws SQLException {
//		return DriverManager.getConnection(url, user, passwd);
//	}
//}
