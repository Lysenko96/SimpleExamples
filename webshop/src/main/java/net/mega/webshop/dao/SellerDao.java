package net.mega.webshop.dao;

import net.mega.webshop.model.Seller;

import java.util.List;

public interface SellerDao {

    void add(Seller seller);

    Seller getById(int id);

    List<Seller> getAll();

    void update(Seller seller);

    void deleteById(int id);
}
