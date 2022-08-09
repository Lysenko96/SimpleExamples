package net.hairservice.controllers;

import net.hairservice.dao.jdbc.JdbcScheduleDao;
import net.hairservice.entities.DaySchedule;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/hairservice")
public class ScheduleController {

    private JdbcScheduleDao jdbcScheduleDao;

    public ScheduleController(JdbcScheduleDao jdbcScheduleDao) {
        this.jdbcScheduleDao = jdbcScheduleDao;
    }

    @GetMapping("/schedules")
    public List<DaySchedule> list() {
        return jdbcScheduleDao.getAll();
    }

    @GetMapping("/schedules/{id}")
    public DaySchedule getById(@PathVariable int id) {
        return jdbcScheduleDao.getById(id);
    }

    @PostMapping("/schedules")
    public void create(@RequestBody DaySchedule schedule) {
        jdbcScheduleDao.add(schedule);
    }

    @PutMapping("/schedules/{id}")
    public void updateById(@RequestBody DaySchedule schedule) {
        jdbcScheduleDao.update(schedule);
    }

    @DeleteMapping("/schedules/{id}")
    public void delete(@PathVariable int id) {
        jdbcScheduleDao.deleteById(id);
    }
}