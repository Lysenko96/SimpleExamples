package com.example.spring.repository;

import com.example.spring.model.Company;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class CompanyRepository {

    public Optional<Company> findById(Integer id) {
        System.out.println("CompanyRepository findById: " + id);
        return Optional.of(new Company(id));
    }
}
