package com.example.integration.service;

import com.example.spring.config.DatabaseProps;
import com.example.spring.dto.CompanyDto;
import com.example.spring.service.CompanyService;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.TestConstructor;

@IT
@RequiredArgsConstructor
@TestConstructor(autowireMode = TestConstructor.AutowireMode.ALL)
public class CompanyServiceIT {

    private static final Integer COMPANY_ID = 1;

//    @Autowired
    private final CompanyService companyService;
//    @Autowired
    private final DatabaseProps databaseProps;

    @Test
    void findbyId() {
        var actual = companyService.findById(COMPANY_ID);

        Assertions.assertTrue(actual.isPresent());

        var expected = new CompanyDto(COMPANY_ID);

        actual.ifPresent(actualResult -> Assertions.assertEquals(expected, actualResult));
    }
}
