package com.example.javabasic.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class JdbcUtil {

    private static String url = "jdbc:postgresql://localhost:5432/postgres";
    private static String user = "postgres";
    private static String password = "postgres";

    Connection getConnection(String url, String user, String password){
        try {
            return DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        JdbcUtil jdbcUtil = new JdbcUtil();
        test(jdbcUtil);
    }

    private static void test(JdbcUtil jdbcUtil){
        try(Connection conn = jdbcUtil.getConnection(url, user, password)){
            conn.setAutoCommit(false);
            //conn.setReadOnly(true); error insert if read only
            conn.setReadOnly(false);
            PreparedStatement ps = conn.prepareStatement("INSERT INTO users(name) VALUES (?)");
            ps.setString(1, "Spike");
            ps.executeUpdate();
            conn.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
