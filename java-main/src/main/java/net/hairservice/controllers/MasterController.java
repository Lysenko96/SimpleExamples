package net.hairservice.controllers;

import net.hairservice.dao.jdbc.JdbcMasterDao;
import net.hairservice.entities.Master;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/hairservice")
public class MasterController {

    private JdbcMasterDao jdbcMasterDao;

    public MasterController(JdbcMasterDao jdbcMasterDao) {
        this.jdbcMasterDao = jdbcMasterDao;
    }

    @GetMapping("/masters")
    public List<Master> list() {
        return jdbcMasterDao.getAll();
    }

    @GetMapping("/masters/{id}")
    public Master getById(@PathVariable int id) {
        return jdbcMasterDao.getById(id);
    }

    @PostMapping("/masters")
    public void create(@RequestBody Master master) {
        jdbcMasterDao.add(master);
    }

    @PutMapping("/masters/{id}")
    public void updateById(@RequestBody Master master) {
        jdbcMasterDao.update(master);
    }

    @DeleteMapping("/masters/{id}")
    public void delete(@PathVariable int id) {
        jdbcMasterDao.deleteById(id);
    }
}