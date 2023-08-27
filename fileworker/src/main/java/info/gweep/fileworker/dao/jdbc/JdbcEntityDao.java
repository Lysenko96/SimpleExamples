package info.gweep.fileworker.dao.jdbc;

import info.gweep.fileworker.dao.EntityDao;
import info.gweep.fileworker.entity.Entity;
import info.gweep.fileworker.provider.Provider;

import javax.sql.rowset.serial.SerialBlob;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.*;
import java.util.Arrays;
import java.util.HashSet;

public class JdbcEntityDao implements EntityDao {

    private Provider provider;
    private static final String ADD_ENTITY = "INSERT INTO entity (name, phones, file, blob) values (?,?,?,?)";
    private static final String GET_ENTITY_BY_ID = "SELECT * FROM entity WHERE id = ?";
    public static final int BUFFER_SIZE = 4096;
    private static long index = 0;

    public static final String PATH_FILE_FROM_DB = "/home/user/Documents/Spd/fileworker/src/main/resources/file_from_db_";

    public JdbcEntityDao(Provider provider) {
        this.provider = provider;
    }

    @Override
    public void add(Entity entity) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection conn = provider.getConnection();
        try {
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
            conn.commit();
        } catch (SQLException | IOException e) {
            try {
                conn.rollback();
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
            e.printStackTrace();
        } finally {
            try {
                conn.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }

    @Override
    public Entity getById(Long id) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        Entity entity = new Entity();
        Connection conn = provider.getConnection();
        try {
            ps = conn.prepareStatement(GET_ENTITY_BY_ID);
            ps.setLong(1, id);
            rs = ps.executeQuery();
            if (rs.next()) {
                entity.setId(rs.getLong("id"));
                entity.setName(rs.getString("name"));
                Array phones = rs.getArray("phones");
                entity.setPhones(new HashSet<>(Arrays.asList((String[]) phones.getArray())));
                InputStream is = rs.getBinaryStream("file");
                OutputStream os = Files.newOutputStream(Paths.get(PATH_FILE_FROM_DB + index + ".txt"));
                int bytesRead = -1;
                byte[] buffer = new byte[BUFFER_SIZE];
                while ((bytesRead = is.read(buffer)) != -1) {
                    os.write(buffer, 0, bytesRead);
                }
                is.close();
                os.close();
                File file = new File(PATH_FILE_FROM_DB + index + ".txt");
                if (file.exists())
                    entity.setFile(file);
                else
                    entity.setFile(null);

                Blob blob = rs.getBlob("blob");
                entity.setBlob(blob.getBytes(1, (int) blob.length()));
                index++;
            }
            conn.commit();
            return entity;
        } catch (SQLException | IOException e) {
            try {
                conn.rollback();
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
            e.printStackTrace();
        } finally {
            try {
                conn.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        return entity;
    }
}
