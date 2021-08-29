package hibernate.script;

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

import org.springframework.stereotype.Component;

import hibernate.config.Provider;

@Component
public class ScriptRunner {
	private static final Logger log = Logger.getLogger(ScriptRunner.class.getName());

	Provider provider;

	public ScriptRunner(Provider provider) {
		this.provider = provider;
	}

	public void run(String fileName) throws ClassNotFoundException {

		try (Connection connection = provider.connection(); Statement statement = connection.createStatement();) {

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
