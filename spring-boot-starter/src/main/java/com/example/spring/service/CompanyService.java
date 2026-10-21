package com.example.spring.service;

import com.example.spring.dto.CompanyDto;
import com.example.spring.listener.AccessType;
import com.example.spring.listener.EntityEvent;
import com.example.spring.mapper.CompanyReadMapper;
import com.example.spring.repository.CompanyRepository;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class CompanyService {

    private final CompanyRepository companyRepository;
    private final ApplicationEventPublisher applicationEventPublisher;
    private final CompanyReadMapper companyReadMapper;

    public CompanyService(CompanyRepository companyRepository, ApplicationEventPublisher applicationEventPublisher, CompanyReadMapper companyReadMapper) {
        this.companyRepository = companyRepository;
        this.applicationEventPublisher = applicationEventPublisher;
        this.companyReadMapper = companyReadMapper;
    }

    public Optional<CompanyDto> findById(Integer id) {
        Optional<CompanyDto> company = companyRepository.findById(id).map(model -> new CompanyDto(model.getId(), model.getName()));
        applicationEventPublisher.publishEvent(new EntityEvent(company, AccessType.READ));
        return company;
    }

    public List<CompanyDto> findAll() {
        return companyRepository.findAll().stream()
                .map(companyReadMapper::map)
                .toList();
    }
}
