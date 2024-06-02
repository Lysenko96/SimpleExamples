package org.example.junitmockitoproject.controller;

import lombok.RequiredArgsConstructor;
import org.example.junitmockitoproject.service.PersonService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/person")
@RequiredArgsConstructor
public class PersonController {

    private final PersonService personService;

    @GetMapping("/salary-sum")
    public int getSalarySumByAllPersons() {
        return personService.getSalarySumByAllPersons();
    }

}
