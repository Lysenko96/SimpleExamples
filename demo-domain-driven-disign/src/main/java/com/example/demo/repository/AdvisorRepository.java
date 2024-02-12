package com.example.demo.repository;

import com.example.demo.domain.Advisor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdvisorRepository extends JpaRepository<Advisor, Long> {

}
