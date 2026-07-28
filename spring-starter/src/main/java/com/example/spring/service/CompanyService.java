package com.example.spring.service;

import com.example.spring.dto.CompanyDto;
import com.example.spring.listener.AccessType;
import com.example.spring.listener.EntityEvent;
import com.example.spring.model.Company;
import com.example.spring.repository.CompanyRepository;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CompanyService {

    private final CompanyRepository companyRepository;
    private final ApplicationEventPublisher applicationEventPublisher;

    public CompanyService(CompanyRepository companyRepository, ApplicationEventPublisher applicationEventPublisher) {
        this.companyRepository = companyRepository;
        this.applicationEventPublisher = applicationEventPublisher;
    }

    public Optional<CompanyDto> findById(Integer id) {
        Optional<CompanyDto> company = companyRepository.findById(id).map(model ->new CompanyDto(model.id()));
        applicationEventPublisher.publishEvent(new EntityEvent(company, AccessType.READ));
        return company;
    }
}
