//package com.example.integration.repository;
//
//import com.example.integration.service.IT;
//import com.example.integration.service.TestAppRunner;
//import com.example.spring.SpringRunner;
//import com.example.spring.model.Company;
//import com.example.spring.repository.CompanyRepository;
//import jakarta.persistence.EntityManager;
//import lombok.RequiredArgsConstructor;
//import org.junit.jupiter.api.Assertions;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.boot.test.context.TestConfiguration;
//import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
//import org.springframework.test.annotation.Rollback;
//import org.springframework.test.context.ActiveProfiles;
//import org.springframework.test.context.ContextConfiguration;
//import org.springframework.test.context.TestConstructor;
//import org.springframework.transaction.annotation.Propagation;
//import org.springframework.transaction.annotation.Transactional;
//
//import java.util.Map;
//
////@IT
////@Transactional
////@Commit
////@Rollback
////@RequiredArgsConstructor
//@ActiveProfiles("test")
//@SpringBootTest
//@ContextConfiguration(classes = SpringRunner.class)
////@TestConstructor(autowireMode = TestConstructor.AutowireMode.ALL)
//public class CompanyRepositoryTest {
//
//
//    @Autowired
//    private EntityManager entityManager;
//    @Autowired
//    private CompanyRepository companyRepository;
//
//    @Test
//    void checkFindByQueries() {
//        var company = companyRepository.findByName("Google");
//        Assertions.assertNotNull(company);
////        var companies = companyRepository.findAllByNameContainingIgnoreCase("a");
////        org.assertj.core.api.Assertions.assertThat(companies).hasSize(1);
//    }
//
////    @Test
////    void findById() {
////        var company = entityManager.find(Company.class, 1);
////        Assertions.assertNotNull(company);
////        org.assertj.core.api.Assertions.assertThat(company.getLocales()).hasSize(2);
////    }
////
////    @Test
////    void save() {
////        var company = Company.builder()
////                .name("Apple")
////                .locales(Map.of(
////                        "ru", "Apple desc",
////                        "en", "Apple desc"
////                )).build();
////        entityManager.persist(company);
////        Assertions.assertNotNull(company);
////    }
////
////    @Test
////    @Transactional(propagation = Propagation.REQUIRES_NEW)
////    void delete() {
////        var mayBeCompany = companyRepository.findById(6);
////        Assertions.assertTrue(mayBeCompany.isPresent());
////        mayBeCompany.ifPresent(companyRepository::delete);
////        entityManager.flush();
////        Assertions.assertTrue(companyRepository.findById(6).isEmpty());
////    }
//}
