package org.example.jdbcdemo;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.postgresql.ds.PGSimpleDataSource;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

public class Start {

    private static DataSource dataSource;
    private static int BATCH_SIZE = 50;
    private static int COUNTER = 500;

    public static void main(String[] args) {
        Start start = new Start();
        //start.initializeDataSource();

        // start.initializeCustomPoolDataSource();

        start.initializeHikariCPDataSource();

//        try(Scanner in = new Scanner(System.in)) {
//            System.out.print("Enter email: ");
//            String email = in.nextLine();
//            System.out.print("Enter firstName: ");
//            String firstName = in.nextLine();
//            System.out.print("Enter lastName: ");
//            String lastName = in.nextLine();

        long begin = System.currentTimeMillis();

        for (int i = 0; i < COUNTER; i++) {
            try (Connection conn = dataSource.getConnection()) {
//            try (PreparedStatement ps = conn.prepareStatement("INSERT INTO person (email, first_name, last_name) VALUES (?, ?, ?)")) {
//                for (int i = 0; i < PERSON_COUNTER; i++) {
//                    ps.setString(1, "email" + i);
//                    ps.setString(2, "firstName" + i);
//                    ps.setString(3, "lastName" + i);
//                   // ps.executeUpdate();
//                    ps.addBatch();
//                    if (i % BATCH_SIZE == 0) ps.executeBatch();
//                    //System.out.println(PERSON_COUNTER % BATCH_SIZE != 0);
//                    if(PERSON_COUNTER % BATCH_SIZE != 0) ps.executeBatch();
//                }
//            }


//                try (PreparedStatement ps = conn.prepareStatement("SELECT * FROM person")) {
//                    ResultSet rs = ps.executeQuery();
//                    while (rs.next()) {
//                        System.out.println(rs.getLong("id"));
//                        System.out.println(rs.getString("first_name"));
//                        System.out.println(rs.getString("last_name"));
//                        System.out.println(rs.getString("email"));
//                        System.out.println(rs.getTimestamp("created_at"));
//                    }
//                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println("Total time: " + (System.currentTimeMillis() - begin) + "ms");

        // }
    }

    private void initializeDataSource() {
        PGSimpleDataSource dataSource = new PGSimpleDataSource();
        dataSource.setUrl("jdbc:postgresql://localhost:5432/demo");
        dataSource.setUser("postgres");
        dataSource.setPassword("postgres");
        Start.dataSource = dataSource;
    }

    private void initializeCustomPoolDataSource() {
        dataSource = new CustomPoolDataSource(
                "jdbc:postgresql://localhost:5432/demo",
                "postgres", "postgres");
    }

    private void initializeHikariCPDataSource() {
        Properties properties = new Properties();
        InputStream input = Start.class.
                getClassLoader()
                .getResourceAsStream("application.properties");
        try {
            properties.load(input);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        HikariConfig config = new HikariConfig(properties);
        dataSource = new HikariDataSource(config);
    }
}
