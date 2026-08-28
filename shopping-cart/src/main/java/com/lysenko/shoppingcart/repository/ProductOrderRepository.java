package com.lysenko.shoppingcart.repository;

import com.lysenko.shoppingcart.model.ProductOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductOrderRepository extends JpaRepository<ProductOrder, Integer> {
}
