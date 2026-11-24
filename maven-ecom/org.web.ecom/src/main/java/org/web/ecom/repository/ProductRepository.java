package org.web.ecom.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.web.ecom.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
}
