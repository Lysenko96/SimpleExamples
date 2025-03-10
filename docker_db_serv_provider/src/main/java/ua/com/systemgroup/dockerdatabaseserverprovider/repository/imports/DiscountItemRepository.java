package ua.com.systemgroup.dockerdatabaseserverprovider.repository.imports;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.com.systemgroup.dockerdatabaseserverprovider.model.imports.DiscountItem;
import ua.com.systemgroup.dockerdatabaseserverprovider.model.imports.pkey.DiscountItemPk;

@Repository
public interface DiscountItemRepository extends JpaRepository<DiscountItem, DiscountItemPk> {
}
