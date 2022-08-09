package net.hairservice.controllers;

import net.hairservice.dao.jdbc.JdbcClientDao;
import net.hairservice.entities.Client;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/hairservice")
public class ClientController {

    private JdbcClientDao jdbcClientDao;

    public ClientController(JdbcClientDao jdbcClientDao) {
        this.jdbcClientDao = jdbcClientDao;
    }

    @GetMapping("/clients")
    public List<Client> list() {
        return jdbcClientDao.getAll();
    }

    @GetMapping("/clients/{id}")
    public Client getById(@PathVariable int id) {
        return jdbcClientDao.getById(id);
    }

    @PostMapping("/clients")
    public void create(@RequestBody Client client) {
        jdbcClientDao.add(client);
    }

    @PutMapping("clients/{id}")
    public void updateById(@RequestBody Client client) {
        jdbcClientDao.update(client);
    }

    @DeleteMapping("/clients/{id}")
    public void delete(@PathVariable int id) {
        jdbcClientDao.deleteById(id);
    }
}