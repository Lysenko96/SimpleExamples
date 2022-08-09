package net.hairservice.dao;

import net.hairservice.entities.Client;

import java.util.List;

public interface ClientDao {

    void add(Client client);

    List<Client> getAll();

    Client getById(long id);

    void update(Client client);

    void deleteById(long id);
}