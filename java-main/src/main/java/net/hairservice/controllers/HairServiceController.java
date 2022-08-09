package net.hairservice.controllers;

import net.hairservice.dao.jdbc.JdbcHairServiceDao;
import net.hairservice.entities.HairService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/hairservice")
public class HairServiceController {

    private JdbcHairServiceDao jdbcHairServiceDao;

    public HairServiceController(JdbcHairServiceDao jdbcHairServiceDao) {
        this.jdbcHairServiceDao = jdbcHairServiceDao;
    }

    @GetMapping("/all")
    public List<HairService> list() {
        return jdbcHairServiceDao.getAll();
    }

    @GetMapping("/{id}")
    public HairService getById(@PathVariable int id) {
        return jdbcHairServiceDao.getById(id);
    }

    @PostMapping("/create")
    public void create(@RequestBody HairService hairService) {
        jdbcHairServiceDao.add(hairService);
    }

    @PutMapping("/{id}")
    public void updateById(@RequestBody HairService hairService) {
        jdbcHairServiceDao.update(hairService);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        jdbcHairServiceDao.deleteById(id);
    }
}