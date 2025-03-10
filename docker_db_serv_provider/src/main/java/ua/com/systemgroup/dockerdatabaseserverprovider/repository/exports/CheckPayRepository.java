package ua.com.systemgroup.dockerdatabaseserverprovider.repository.exports;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.com.systemgroup.dockerdatabaseserverprovider.model.exports.CheckPay;
import ua.com.systemgroup.dockerdatabaseserverprovider.model.exports.pkey.CheckPayPk;

@Repository
public interface CheckPayRepository extends JpaRepository<CheckPay, CheckPayPk> {
}
