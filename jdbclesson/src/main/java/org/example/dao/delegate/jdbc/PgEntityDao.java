package org.example.dao.delegate.jdbc;

import org.example.dao.EntityDao;
import org.example.dao.PgDaoFactory;
import org.example.entity.Entity;

import javax.sql.rowset.serial.SerialBlob;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.*;
import java.util.List;

import static org.example.Start.PATH_FILE;

public class PgEntityDao implements EntityDao {

    private static final String ADD_ENTITY = "INSERT INTO entity (name, phones, file, blob) values (?,?,?,?)";

    private PgDaoFactory pgDaoFactory;

    public PgEntityDao(PgDaoFactory pgDaoFactory) {
        this.pgDaoFactory = pgDaoFactory;
    }

    @Override
    public Long add(Entity entity) {
        try {
            Connection conn = pgDaoFactory.getConnection();
            System.out.println(conn);
            InputStream file = Files.newInputStream(Paths.get(PATH_FILE).toAbsolutePath());
            Blob blob = new SerialBlob(Files.readAllBytes(Paths.get(PATH_FILE).toAbsolutePath()));
            PreparedStatement ps = conn.prepareStatement(ADD_ENTITY, Statement.RETURN_GENERATED_KEYS);
            String[] phonesStr = entity.getPhones().toArray(new String[0]);
            Array phones = conn.createArrayOf("TEXT", phonesStr);
            ps.setString(1, entity.getName());
            ps.setArray(2, phones);
            ps.setBinaryStream(3, file);
            //ps.setBytes(3, Files.readAllBytes(Paths.get(PATH_FILE).toAbsolutePath()));
            ps.setBlob(4, blob);
            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                long id = rs.getLong("id");
                entity.setId(id);
            }
        } catch (SQLException | IOException e) {
            e.printStackTrace();
        }
        return entity.getId();
    }

    @Override
    public List<Entity> getAll() {

        return null;
    }

    @Override
    public Entity getById(Long id) {
        return null;
    }

    @Override
    public Long update(Entity entity) {
        return null;
    }

    @Override
    public void deleteById(Long id) {

    }
}
