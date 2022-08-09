package net.hairservice.controllers;

import net.hairservice.dao.jdbc.JdbcDurationDao;
import net.hairservice.entities.Duration;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/hairservice")
public class DurationController {

    private JdbcDurationDao jdbcDurationDao;

    public DurationController(JdbcDurationDao jdbcDurationDao) {
        this.jdbcDurationDao = jdbcDurationDao;
    }

    @GetMapping("/durations")
    public List<Duration> list() {
        return jdbcDurationDao.getAll();
    }

    @GetMapping("/durations/{id}")
    public Duration getById(@PathVariable int id) {
        return jdbcDurationDao.getById(id);
    }

    @PostMapping("/durations")
    public void create(@RequestBody Duration duration) {
        jdbcDurationDao.add(duration);
    }

    @PutMapping("/durations/{id}")
    public void updateById(@RequestBody Duration duration) {
        jdbcDurationDao.update(duration);
    }

    @DeleteMapping("/durations/{id}")
    public void delete(@PathVariable int id) {
        jdbcDurationDao.deleteById(id);
    }
}