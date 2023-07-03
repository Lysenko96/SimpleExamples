package org.example.jparelations.repository;

import org.example.jparelations.entity.Husband;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HusbandRepository extends JpaRepository<Husband, Long> {
}
