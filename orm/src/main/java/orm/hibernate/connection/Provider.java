package orm.hibernate.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:config.properties")
public class Provider {

	@Value("${db.url}")
	private String url;
	@Value("${db.user}")
	private String user;
	@Value("${db.passwd}")
	private String passwd;
	@Value("${db.driver}")
	private String driver;

	@Bean
	public Connection connection() throws SQLException, ClassNotFoundException {
		Class.forName(driver);
		return DriverManager.getConnection(url, user, passwd);
	}
}
