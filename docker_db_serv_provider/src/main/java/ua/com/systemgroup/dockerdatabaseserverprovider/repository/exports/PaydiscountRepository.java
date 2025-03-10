package ua.com.systemgroup.dockerdatabaseserverprovider.repository.exports;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.com.systemgroup.dockerdatabaseserverprovider.model.exports.Paydiscount;
import ua.com.systemgroup.dockerdatabaseserverprovider.model.exports.pkey.PaydiscountPk;

@Repository
public interface PaydiscountRepository extends JpaRepository<Paydiscount, PaydiscountPk> {
}
