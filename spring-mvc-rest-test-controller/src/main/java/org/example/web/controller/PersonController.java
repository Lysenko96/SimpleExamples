package org.example.web.controller;

import lombok.RequiredArgsConstructor;
import org.example.web.service.PersonService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/person")
@RequiredArgsConstructor
public class PersonController {

    private final PersonService personService;

    @GetMapping("/salary")
    public ResponseEntity<?> getSalarySumByAllPersons() {
        return ResponseEntity.ok(personService.getSalarySumByAllPersons());
    }

//    @RequestMapping(value = "/", method = RequestMethod.GET)
//    public String home(){
//        return "/WEB-INF/index.jsp";
//    }

}