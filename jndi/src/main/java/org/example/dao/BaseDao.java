package org.example.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class BaseDao {

    protected void finalize(ResultSet rs, Statement stmt) throws Exception {
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException ex) {
                throw new Exception(ex.getMessage());
            }
        }
        if (stmt != null) {
            try {
                stmt.close();
            } catch (SQLException e) {
                throw new Exception(e.getMessage());
            }
        }
    }
}
