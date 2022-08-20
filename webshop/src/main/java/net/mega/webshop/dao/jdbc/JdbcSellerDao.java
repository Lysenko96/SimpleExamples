package net.mega.webshop.dao.jdbc;

import net.mega.webshop.connection.Provider;
import net.mega.webshop.dao.SellerDao;
import net.mega.webshop.model.Seller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class JdbcSellerDao implements SellerDao {

    private Provider provider;
    private static final String ADD_SELLER = "insert into seller (first_name, last_name, username, password, address, phone, email) values (?,?,?,?,?,?,?)";

    public JdbcSellerDao(Provider provider) {
        this.provider = provider;
    }

    @Override
    public void add(Seller seller) {
        try(Connection conn = provider.getConnection();
            PreparedStatement ps = conn.prepareStatement(ADD_SELLER)) {
            ps.setString(1, seller.getFirstName());
            ps.setString(2, seller.getLastName());
            ps.setString(3, seller.getUsername());
            ps.setString(4, seller.getPassword());
            ps.setString(5, seller.getAddress());
            ps.setInt(6, seller.getPhone());
            ps.setString(7, seller.getEmail());
            ps.executeUpdate();
        } catch (SQLException e) {
           e.printStackTrace();
        }
    }

    @Override
    public Seller getById(int id) {
        return null;
    }

    @Override
    public List<Seller> getAll() {
        return null;
    }

    @Override
    public void update(Seller seller) {

    }

    @Override
    public void deleteById(int id) {

    }
}
