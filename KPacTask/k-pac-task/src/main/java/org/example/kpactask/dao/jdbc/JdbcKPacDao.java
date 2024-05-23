package org.example.kpactask.dao.jdbc;

import org.example.kpactask.dao.KPacDao;
import org.example.kpactask.entity.KPac;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;

import java.sql.PreparedStatement;
import java.util.List;

@Component
public class JdbcKPacDao implements KPacDao {

    private static final String ADD_K_PAC = "INSERT INTO k_pac (title, description, createdAt) VALUES (?,?,?)";
    private static final String GET_K_PAC = "SELECT * FROM k_pac WHERE k_pac_id=?";
    private static final String GET_K_PACS = "SELECT * FROM k_pac";
    private static final String UPDATE_K_PAC = "UPDATE k_pac SET title=?, description=?, createdAt=? WHERE k_pac_id=?";
    private static final String DELETE_K_PAC = "DELETE FROM k_pac WHERE k_pac_id=?";

    private final JdbcTemplate jdbcTemplate;
    private final BeanPropertyRowMapper<KPac> rowMapper = new BeanPropertyRowMapper<>(KPac.class);

    public JdbcKPacDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void add(KPac kPac) {
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(connection -> {
            PreparedStatement statement = connection.prepareStatement(ADD_K_PAC, new String[] { "id" });
            statement.setString(1, kPac.getTitle());
            statement.setString(2, kPac.getDescription());
            statement.setDate(3, kPac.getCreatedAt());
            return statement;
        }, keyHolder);
        kPac.setId(keyHolder.getKey() != null ? keyHolder.getKey().longValue() : null);
    }

    @Override
    public List<KPac> getAll() {
        return jdbcTemplate.query(GET_K_PACS, rowMapper);
    }

    @Override
    public KPac getById(Long id) {
        return jdbcTemplate.queryForObject(GET_K_PAC, rowMapper, id);
    }

    @Override
    public Long update(KPac kPac) {
        jdbcTemplate.update(UPDATE_K_PAC, kPac.getTitle(), kPac.getDescription(), kPac.getCreatedAt(), kPac.getId());
        return kPac.getId();
    }

    @Override
    public void deleteById(Long id) {
        jdbcTemplate.update(DELETE_K_PAC, id);
    }
}
