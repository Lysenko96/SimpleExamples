package net.pack.jdbcstyle.dao.jdbc;

import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import net.pack.jdbcstyle.dao.PersonDao;
import net.pack.jdbcstyle.entity.Sex;
import net.pack.jdbcstyle.entity.Person;
import net.pack.jdbcstyle.provider.Provider;

public class JdbcPersonDao implements PersonDao {

    private Provider provider;
    private static final String ADD_PERSON = "insert into person (name,surname,sex,email,year,address,phone, \"postCode\") values (?,?,?,?,?,?,?,?)";
    private static final String ADD_PERSON_STATEMENT = "insert into person (name,surname,sex,email,year,address,phone, \"postCode\") values ('name1','surname1','MALE','email',2000,'address',324342, 'US')";
    private static final String ADD_PERSON_TEST_STATEMENT = "insert into person_test (name,surname,sex,email,year,address,phone, \"postCode\") values ('name2','surname2','FEMALE','email1',2004,'address2',32535, 'CA')";
    //	private static final String GET_PERSON_BY_ID = "";
    private static final String GET_ALL_PERSONS = "select * from person";
//	private static final String UPDATE_PERSON = "";
//	private static final String DELETE_PERSON_BY_ID = "";

    public JdbcPersonDao(Provider provider) {
        this.provider = provider;
    }

    @Override
    public void add(Person person) {
        try (Connection conn = provider.getConnection();
             PreparedStatement st = conn.prepareStatement(ADD_PERSON, Statement.RETURN_GENERATED_KEYS)) {
            System.out.println(conn.getTransactionIsolation());
            conn.setTransactionIsolation(Connection.TRANSACTION_READ_COMMITTED);
            DatabaseMetaData databaseMetaData = conn.getMetaData();
            System.out.println(conn.getTransactionIsolation());
            st.setString(1, person.getName());
            st.setString(2, person.getSurname());
            st.setString(3, person.getSex().name());
            st.setString(4, person.getEmail());
            st.setInt(5, person.getYear());
            st.setString(6, person.getAddress());
            st.setInt(7, person.getPhone());
            st.setString(8, person.getPostCode());
            st.execute();
            ResultSet rs = st.getGeneratedKeys();
            if (rs.next()) {
                long key = rs.getInt("id");
                person.setId(key);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void addBatch(List<Person> persons) {
        try (Connection conn = provider.getConnection();) {
            try (PreparedStatement st = conn.prepareStatement(ADD_PERSON, Statement.RETURN_GENERATED_KEYS)) {
                //try (Statement st = conn.createStatement()) {
                conn.setAutoCommit(false);
                for (Person person : persons) {
                    st.setString(1, person.getName());
                    st.setString(2, person.getSurname());
                    st.setString(3, person.getSex().name());
                    st.setString(4, person.getEmail());
                    st.setInt(5, person.getYear());
                    st.setString(6, person.getAddress());
                    st.setInt(7, person.getPhone());
                    st.setString(8, person.getPostCode());
//					st.addBatch(ADD_PERSON_STATEMENT);
//				    st.addBatch(ADD_PERSON_TEST_STATEMENT);
                    st.addBatch();
                    ResultSet rs = st.getGeneratedKeys();
                    if (rs.next()) {
                        long key = rs.getInt("id");
                        person.setId(key);
                    }
                }

                System.out.println(Arrays.toString(st.executeBatch()));
                conn.commit();
            } catch (SQLException e) {
                conn.rollback();
                e.printStackTrace();
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public Person getById(long id) {
        return null;
    }

    @Override
    public List<Person> getAll() {
        List<Person> persons = new ArrayList<>();
        try (Connection conn = provider.getConnection();
             Statement st = conn.createStatement()) {
            ResultSet rs = st.executeQuery(GET_ALL_PERSONS);
            while (rs.next()) {
                long id = rs.getInt("id");
                String name = rs.getString("name");
                String surname = rs.getString("surname");
                Sex sex = Sex.valueOf(rs.getString("sex"));
                String email = rs.getString("email");
                int year = rs.getInt("year");
                String address = rs.getString("address");
                int phone = rs.getInt("phone");
                String postCode = rs.getString("postcode");
                persons.add(new Person(id, name, surname, sex, email, year, address, phone, postCode));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return persons;
    }

    @Override
    public void insertWithResultSet() {
        try (Connection conn = provider.getConnection();
             Statement st = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE)) {
            ResultSet rs = st.executeQuery("SELECT * FROM person");
            rs.moveToInsertRow();
            rs.updateLong("id", 79L);
            rs.updateString("name", "John");
            rs.insertRow();
            rs.moveToCurrentRow();
            rs = st.executeQuery("SELECT * FROM person WHERE name = 'John'");
            while (rs.next()) {
                System.out.println(rs.getString("name"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteById(long id) {

    }
}