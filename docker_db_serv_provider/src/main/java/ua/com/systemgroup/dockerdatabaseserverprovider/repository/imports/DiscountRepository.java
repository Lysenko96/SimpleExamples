package ua.com.systemgroup.dockerdatabaseserverprovider.repository.imports;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.com.systemgroup.dockerdatabaseserverprovider.model.imports.Discount;
import ua.com.systemgroup.dockerdatabaseserverprovider.model.imports.pkey.DiscountPk;

@Repository
public interface DiscountRepository extends JpaRepository<Discount, DiscountPk> {
}
