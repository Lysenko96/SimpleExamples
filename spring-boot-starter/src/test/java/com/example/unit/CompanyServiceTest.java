package com.example.unit;

import com.example.spring.dto.CompanyDto;
import com.example.spring.listener.EntityEvent;
import com.example.spring.model.Company;
import com.example.spring.repository.CompanyRepository;
import com.example.spring.service.CompanyService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.context.ApplicationEventPublisher;

import java.util.Optional;


@ExtendWith(MockitoExtension.class)
public class CompanyServiceTest {

    private static final Integer COMPANY_ID = 1;

    @Mock
    private CompanyRepository companyRepository;
    @Mock
    private ApplicationEventPublisher eventPublisher;
    @InjectMocks
    private CompanyService companyService;

    @Test
    void findById() {
        Mockito.doReturn(Optional.of(new Company(COMPANY_ID)))
                .when(companyRepository).findById(COMPANY_ID);

        var actual = companyService.findById(COMPANY_ID);

        Assertions.assertTrue(actual.isPresent());

        var expected = new CompanyDto(COMPANY_ID);

        actual.ifPresent(actualResult -> Assertions.assertEquals(expected, actualResult));

        Mockito.verify(eventPublisher).publishEvent(Mockito.any(EntityEvent.class));

    }
}
