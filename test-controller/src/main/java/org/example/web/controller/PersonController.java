package org.example.web.controller;

import lombok.RequiredArgsConstructor;
import org.example.web.entity.Person;
import org.example.web.service.PersonService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/person")
@RequiredArgsConstructor
public class PersonController {

    private final PersonService personService;

    @GetMapping("/salary")
    public ResponseEntity<?> getSalarySumByAllPersons() {
        int sum = personService.getSalarySumByAllPersons();
        return new ResponseEntity<>(sum, HttpStatus.OK);
    }

    @PostMapping("/hire")
    public ResponseEntity<Void> hirePerson(@RequestBody Person person) {
        personService.hire(person);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Person> getPersonById(@PathVariable int id) {
        Person person = personService.findById(id);
        return new ResponseEntity<>(person, HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<Void> updatePerson(@RequestBody Person person) {
        personService.update(person);
        return new ResponseEntity<>(HttpStatus.OK);
    }

//    @RequestMapping(value = "/", method = RequestMethod.GET)
//    public String home(){
//        return "/WEB-INF/index.jsp";
//    }

}