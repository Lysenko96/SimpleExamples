package org.web.ecom.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.web.ecom.model.Address;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {
}
