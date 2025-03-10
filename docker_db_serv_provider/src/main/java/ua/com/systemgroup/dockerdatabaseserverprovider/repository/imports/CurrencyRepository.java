package ua.com.systemgroup.dockerdatabaseserverprovider.repository.imports;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.com.systemgroup.dockerdatabaseserverprovider.model.imports.Currency;
import ua.com.systemgroup.dockerdatabaseserverprovider.model.imports.pkey.CurrencyPk;

@Repository

public interface CurrencyRepository extends JpaRepository<Currency, CurrencyPk> {
}
