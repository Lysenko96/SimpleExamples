package org.example.jparelations.repository;

import org.example.jparelations.entity.Wife;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WifeRepository extends JpaRepository<Wife, Long> {
}
