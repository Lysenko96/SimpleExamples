package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main {

    public static void main(String[] args) {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (Exception e){
            e.printStackTrace();
        }
        try(Connection conn = DriverManager.getConnection("jdbc:postgresql://127.0.0.1:5432/postgres", "postgres", "postgres")){
            System.out.println(conn);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
