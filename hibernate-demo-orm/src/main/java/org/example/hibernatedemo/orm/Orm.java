package org.example.hibernatedemo.orm;

import javax.sql.DataSource;

public class Orm {

    private DataSource dataSource;

    public Orm(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public <T> T find(Class<T> type, Long id) {

        return null;
    }
}
