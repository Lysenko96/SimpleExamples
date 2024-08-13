package org.example.unitsimple.controller;

import lombok.RequiredArgsConstructor;
import org.example.unitsimple.dto.CompanyDto;
import org.example.unitsimple.service.CompanyService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/company")
public class CompanyController {

    private final CompanyService companyService;

    @GetMapping(value = "/findAll", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<CompanyDto> findAll() {
        return companyService.findAll();
    }
}
