package org.example.dao.delegate.jdbc;

import org.example.dao.BaseDao;
import org.example.dao.PgDaoFactory;
import org.example.entity.Entity;
import org.example.dao.EntityDao;

import javax.sql.rowset.serial.SerialBlob;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;


public class PgEntityDao extends BaseDao implements EntityDao {

    public static final String PATH_FILE = "/home/user/IdeaProjects/jndi/src/main/resources/file.txt";
    public static final String PATH_FILE_NEXT = "/home/user/IdeaProjects/jndi/src/main/resources/file_next.txt";
    public static final String PATH_FILE_UPDATE = "/home/user/IdeaProjects/jndi/src/main/resources/file_update.txt";
    public static final String PATH_FILE_FROM_DB = "/home/user/IdeaProjects/jndi/src/main/resources/file_from_db_";
    public static final String TXT = ".txt";
    private static final String ADD_ENTITY = "INSERT INTO entity (name, phones, file, blob) values (?,?,?,?)";
    private static final String GET_ALL_ENTITIES = "SELECT * FROM entity";
    private static final String GET_ENTITY_BY_ID = "SELECT * FROM entity WHERE id = ?";
    private static final String UPDATE_ENTITY = "UPDATE entity SET name=?, phones=?, file=?, blob=? WHERE id=?";
    private static final String DELETE_ENTITY_BY_ID = "DELETE FROM entity WHERE id = ?";

    private static final int BUFFER_SIZE = 4096;

    private PgDaoFactory pgDaoFactory;

    private static long index = 0;

    public PgEntityDao(PgDaoFactory pgDaoFactory) {
        this.pgDaoFactory = pgDaoFactory;
    }

    @Override
    public Long add(Entity entity) throws Exception {
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            Connection conn = pgDaoFactory.getConnection();
            InputStream file = Files.newInputStream(Paths.get(entity.getFile().getAbsolutePath()));
            Blob blob = new SerialBlob(Files.readAllBytes(Paths.get(entity.getFile().getAbsolutePath())));
            ps = conn.prepareStatement(ADD_ENTITY, Statement.RETURN_GENERATED_KEYS);
            String[] phonesStr = entity.getPhones().toArray(new String[0]);
            Array phones = conn.createArrayOf("TEXT", phonesStr);
            ps.setString(1, entity.getName());
            ps.setArray(2, phones);
            ps.setBinaryStream(3, file);
            //ps.setBytes(3, Files.readAllBytes(Paths.get(PATH_FILE).toAbsolutePath()));
            ps.setBlob(4, blob);
            ps.executeUpdate();
            rs = ps.getGeneratedKeys();
            if (rs.next()) {
                long id = rs.getLong("id");
                entity.setId(id);
            }
            return entity.getId();
        } catch (SQLException | IOException e) {
            e.printStackTrace();
            throw new Exception();
        } finally {
            finalize(rs, ps);
        }
    }

    @Override
    public List<Entity> getAll() throws Exception {
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Entity> entities = new ArrayList<>();
        try {
            Connection conn = pgDaoFactory.getConnection();
            ps = conn.prepareStatement(GET_ALL_ENTITIES);
            rs = ps.executeQuery();
            while (rs.next()) {
                Entity entity = new Entity();
                entity.setId(rs.getLong("id"));
                entity.setName(rs.getString("name"));
                Array phones = rs.getArray("phones");
                entity.setPhones(new HashSet<>(Arrays.asList((String[]) phones.getArray())));
                InputStream is = rs.getBinaryStream("file");
                OutputStream os = Files.newOutputStream(Paths.get(PATH_FILE_FROM_DB + index + TXT));
                int bytesRead = -1;
                byte[] buffer = new byte[BUFFER_SIZE];
                while ((bytesRead = is.read(buffer)) != -1) {
                    os.write(buffer, 0, bytesRead);
                }
                is.close();
                os.close();
                entity.setFile(new File(PATH_FILE_FROM_DB + index + TXT));
                Blob blob = rs.getBlob("blob");
                entity.setBlob(blob.getBytes(1, (int) blob.length()));
                index++;
                entities.add(entity);
            }
            return entities;
        } catch (SQLException e) {
            e.printStackTrace();
            throw new Exception();
        } finally {
            finalize(rs, ps);
        }
    }

    @Override
    public Entity getById(long id) throws Exception {
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            Connection conn = pgDaoFactory.getConnection();
            ps = conn.prepareStatement(GET_ENTITY_BY_ID);
            ps.setLong(1, id);
            rs = ps.executeQuery();
            Entity entity = new Entity();
            if (rs.next()) {
                entity.setId(rs.getLong("id"));
                entity.setName(rs.getString("name"));
                Array phones = rs.getArray("phones");
                entity.setPhones(new HashSet<>(Arrays.asList((String[]) phones.getArray())));
                InputStream is = rs.getBinaryStream("file");
                OutputStream os = Files.newOutputStream(Paths.get(PATH_FILE_FROM_DB + index + TXT));
                int bytesRead = -1;
                byte[] buffer = new byte[BUFFER_SIZE];
                while ((bytesRead = is.read(buffer)) != -1) {
                    os.write(buffer, 0, bytesRead);
                }
                is.close();
                os.close();
                entity.setFile(new File(PATH_FILE_FROM_DB + index + TXT));
                Blob blob = rs.getBlob("blob");
                entity.setBlob(blob.getBytes(1, (int) blob.length()));
                index++;
            }
            return entity;
        } catch (SQLException e) {
            e.printStackTrace();
            throw new Exception();
        } finally {
            finalize(rs, ps);
        }
    }

    @Override
    public void update(Entity entity) throws Exception {
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            Connection conn = pgDaoFactory.getConnection();
            InputStream file = Files.newInputStream(Paths.get(entity.getFile().getAbsolutePath()));
            Blob blob = new SerialBlob(Files.readAllBytes(Paths.get(entity.getFile().getAbsolutePath())));
            ps = conn.prepareStatement(UPDATE_ENTITY);
            String[] phonesStr = entity.getPhones().toArray(new String[0]);
            Array phones = conn.createArrayOf("TEXT", phonesStr);
            ps.setString(1, entity.getName());
            ps.setArray(2, phones);
            ps.setBinaryStream(3, file);
            //ps.setBytes(3, Files.readAllBytes(Paths.get(PATH_FILE).toAbsolutePath()));
            ps.setBlob(4, blob);
            ps.setLong(5, entity.getId());
            ps.executeUpdate();
        } catch (SQLException | IOException e) {
            e.printStackTrace();
            throw new Exception();
        } finally {
            finalize(rs, ps);
        }
    }

    @Override
    public void deleteById(long id) throws Exception {
        PreparedStatement ps = null;
        try {
            Connection conn = pgDaoFactory.getConnection();
            ps = conn.prepareStatement(DELETE_ENTITY_BY_ID);
            ps.setLong(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new Exception();
        } finally {
            finalize(null, ps);
        }
    }
}
