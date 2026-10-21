package com.example.integration.repository;

import com.example.spring.SpringRunner;
import com.example.spring.model.Company;
import com.example.spring.repository.CompanyRepository;
import jakarta.persistence.EntityManager;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;


//@Commit
//@Rollback
@SpringBootTest(classes = SpringRunner.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
@Transactional
@ActiveProfiles("test")
public class CompanyRepositoryTest {


    @Autowired
    private EntityManager entityManager;
    @Autowired
    private CompanyRepository companyRepository;

    @Test
    void checkFindByQueries() {
        var company = companyRepository.findByName("Google");
        Assertions.assertNotNull(company);
        var companies = companyRepository.findAllByNameContainingIgnoreCase("g");
        org.assertj.core.api.Assertions.assertThat(companies).hasSize(1);
    }

    @Test
    void findById() {
        var company = entityManager.find(Company.class, 1);
        Assertions.assertNotNull(company);
        org.assertj.core.api.Assertions.assertThat(company.getLocales()).hasSize(2);
    }

    @Test
    void save() {
        var company = Company.builder()
                .name("Apple")
                .locales(Map.of(
                        "ru", "Apple desc",
                        "en", "Apple desc"
                )).build();
        entityManager.persist(company);
        Assertions.assertNotNull(company);
    }

    @Test
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    void delete() {
        var mayBeCompany = companyRepository.findById(1);
        Assertions.assertTrue(mayBeCompany.isPresent());
        mayBeCompany.ifPresent(companyRepository::delete);
        entityManager.flush();
        Assertions.assertTrue(companyRepository.findById(1).isEmpty());
    }
}
