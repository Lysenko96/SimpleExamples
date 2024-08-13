package org.example.unitsimple.service;

import jakarta.annotation.PostConstruct;
import jakarta.persistence.EntityManagerFactory;
import lombok.RequiredArgsConstructor;
import org.example.unitsimple.WebConfig;
import org.example.unitsimple.dto.CompanyDto;
import org.example.unitsimple.repository.CompanyRepository;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CompanyService {

    private final CompanyRepository companyRepository;

    @PostConstruct
    public void init() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(WebConfig.class);
        context.getBean(EntityManagerFactory.class);
        context.close();
    }

    public List<CompanyDto> findAll() {
        return companyRepository.findAll().stream()
                .map(c -> new CompanyDto(c.getId(), c.getName()))
                .collect(Collectors.toList());
    }
}

