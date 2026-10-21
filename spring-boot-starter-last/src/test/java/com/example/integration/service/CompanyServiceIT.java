package com.example.integration.service;

import com.example.spring.SpringRunner;
import com.example.spring.config.DatabaseProps;
import com.example.spring.dto.CompanyDto;
import com.example.spring.service.CompanyService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.transaction.annotation.Transactional;


@SpringBootTest(classes = SpringRunner.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
@Transactional
public class CompanyServiceIT {

    private static final Integer COMPANY_ID = 1;

    @Autowired
    private CompanyService companyService;
    @Autowired
    private DatabaseProps databaseProps;

    @Test
    void findbyId() {
        var actual = companyService.findById(COMPANY_ID);

        Assertions.assertTrue(actual.isPresent());

        var expected = new CompanyDto(COMPANY_ID, "Google");

        actual.ifPresent(actualResult -> Assertions.assertEquals(expected, actualResult));
    }
}
