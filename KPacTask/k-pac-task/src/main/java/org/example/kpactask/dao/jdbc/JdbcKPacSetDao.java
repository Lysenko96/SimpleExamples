package org.example.kpactask.dao.jdbc;

import org.example.kpactask.dao.KPacSetDao;
import org.example.kpactask.entity.KPacSet;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import java.sql.PreparedStatement;
import java.util.List;

public class JdbcKPacSetDao implements KPacSetDao {

    private static final String ADD_K_PAC_SET = "INSERT INTO k_pac_set (title) VALUES (?)";
    private static final String GET_K_PAC_SET = "SELECT * FROM k_pac_set WHERE k_pac_set_id=?";
    private static final String GET_K_PACS_SET = "SELECT * FROM k_pac_set";
    private static final String UPDATE_K_PAC_SET = "UPDATE k_pac_set SET title=? WHERE k_pac_set_id=?";
    private static final String DELETE_K_PAC_SET = "DELETE FROM k_pac_set WHERE k_pac_set_id=?";

    private final JdbcTemplate jdbcTemplate;
    private final BeanPropertyRowMapper<KPacSet> rowMapper = new BeanPropertyRowMapper<>(KPacSet.class);

    public JdbcKPacSetDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void add(KPacSet kPacSet) {
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(connection -> {
            PreparedStatement statement = connection.prepareStatement(ADD_K_PAC_SET, new String[] { "id" });
            statement.setString(1, kPacSet.getTitle());
            return statement;
        }, keyHolder);
        kPacSet.setId(keyHolder.getKey() != null ? keyHolder.getKey().longValue() : null);
    }

    @Override
    public List<KPacSet> getAll() {
        return jdbcTemplate.query(GET_K_PACS_SET, rowMapper);
    }

    @Override
    public KPacSet getById(Long id) {
        return jdbcTemplate.queryForObject(GET_K_PAC_SET, rowMapper, id);
    }

    @Override
    public Long update(KPacSet kPacSet) {
        jdbcTemplate.update(UPDATE_K_PAC_SET, kPacSet.getTitle(), kPacSet.getId());
        return kPacSet.getId();
    }

    @Override
    public void deleteById(Long id) {
        jdbcTemplate.update(DELETE_K_PAC_SET, id);
    }

}
