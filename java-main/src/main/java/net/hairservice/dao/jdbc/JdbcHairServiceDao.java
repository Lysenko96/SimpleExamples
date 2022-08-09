package net.hairservice.dao.jdbc;

import net.hairservice.dao.HairServiceDao;
import net.hairservice.entities.HairService;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;

import java.sql.PreparedStatement;
import java.util.List;

@Component
public class JdbcHairServiceDao implements HairServiceDao {

    private static final String ADD_HAIR_SERVICE = "INSERT INTO hair_service (client_id, master_id, schedule_id) VALUES (?,?,?)";
    private static final String GET_HAIR_SERVICES = "SELECT * FROM hair_service";
    private static final String GET_HAIR_SERVICE_BY_ID = "SELECT * FROM hair_service WHERE id=?";
    private static final String UPDATE_HAIR_SERVICE = "UPDATE hair_service SET client_id=?, master_id=?, schedule_id=? WHERE id=?";
    private static final String DELETE_HAIR_SERVICE = "DELETE FROM hair_service WHERE id=?";
    private final JdbcTemplate jdbcTemplate;
    private final BeanPropertyRowMapper<HairService> mapper = new BeanPropertyRowMapper<>(HairService.class);

    public JdbcHairServiceDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void add(HairService hairService) {
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(conn -> {
            PreparedStatement ps = conn.prepareStatement(ADD_HAIR_SERVICE, new String[]{"id"});
            ps.setLong(1, hairService.getClient().getId());
            ps.setLong(2, hairService.getMaster().getId());
            ps.setLong(3, hairService.getSchedule().getId());
            return ps;
        }, keyHolder);
        hairService.setId(keyHolder.getKey().longValue());
    }

    @Override
    public List<HairService> getAll() {
        return jdbcTemplate.query(GET_HAIR_SERVICES, mapper);
    }

    @Override
    public HairService getById(long id) {
        return jdbcTemplate.queryForObject(GET_HAIR_SERVICE_BY_ID, mapper, id);
    }

    @Override
    public void update(HairService hairService) {
        jdbcTemplate.update(UPDATE_HAIR_SERVICE, hairService.getClient().getId(), hairService.getMaster().getId(), hairService.getSchedule().getId(), hairService.getId());
    }

    @Override
    public void deleteById(long id) {
        jdbcTemplate.update(DELETE_HAIR_SERVICE, id);
    }
}