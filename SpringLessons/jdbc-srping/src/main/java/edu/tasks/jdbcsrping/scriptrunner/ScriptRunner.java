package edu.tasks.jdbcsrping.scriptrunner;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Logger;

import edu.tasks.jdbcspring.config.Config;
//import edu.tasks.jdbcspring.connection.ConnectionProvider;

public class ScriptRunner {

	private static final Logger log = Logger.getLogger(ScriptRunner.class.getName());

	// ConnectionProvider provider;

//	public ScriptRunner(ConnectionProvider provider) {
//		this.provider = provider;
//	}
	// private Connection provider;
	private Config config;

//	

//	public ScriptRunner(Connection provider) {
//		this.provider = provider;
//	}

	public ScriptRunner(Config config) {
		this.config = config;
	}

	public void runSQLQueries(String fileName) {
		// try (Connection connection = provider.getConnection(); Statement statement =
		// connection.createStatement();) {
		try (Connection connection = config.dataSource().getConnection();
				Statement statement = connection.createStatement();) {
			List<String> sqlQueries = getSQLQueries(fileName);

			for (String line : sqlQueries) {
				statement.execute(line);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static String getPath(String fileName) {
		try {
			File file = new File(ScriptRunner.class.getClassLoader().getResource(fileName).getFile());
			return file.toPath().toString();
		} catch (NullPointerException e) {
			log.info("file not exists");
			e.printStackTrace();
		}
		return "";
	}

	private List<String> getSQLQueries(String fileName) {
		String sqlText = "";
		List<String> sqlQueries = new ArrayList<>();
		try {
			if (!getPath(fileName).isEmpty()) {

				sqlText = readFile(getPath(fileName), Charset.defaultCharset());
			}
			List<String> sqlTestList = Arrays.asList(sqlText.split(";"));
			for (String query : sqlTestList) {
				sqlQueries.add(query);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return sqlQueries;
	}

	private String readFile(String path, Charset encoding) throws IOException {
		byte[] encoded = Files.readAllBytes(Paths.get(path));
		return new String(encoded, encoding);
	}

}
