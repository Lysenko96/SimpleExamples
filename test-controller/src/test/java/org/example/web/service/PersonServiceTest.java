package org.example.web.service;

import org.example.web.entity.Person;
import org.example.web.exception.LowSalaryException;
import org.example.web.repository.PersonRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

@ExtendWith(MockitoExtension.class)
public class PersonServiceTest {

    @InjectMocks
    private PersonService personService;

    @Mock
    private PersonRepository personRepository;
    private Person person1;
    private Person person2;

    @BeforeEach
    public void setUp() {
        person1 = new Person("Jack", "Richard", 750);
        person2 = new Person("Tom", "Hawk", 1250);
    }

    @Test
    void getSalarySumByAllPersonsTest() {

        Mockito.when(personRepository.findAll()).thenReturn(List.of(person1, person2));

        int sum = personService.getSalarySumByAllPersons();
        Assertions.assertEquals(2000, sum);
    }

    @Test
    void hireTestThenThrowException() {
        Assertions.assertThrows(LowSalaryException.class, () -> personService.hire(person1));
    }

    @Test
    void hireTestThenSavePerson() {
        personService.hire(person2);
        Mockito.verify(personRepository, Mockito.times(1)).save(person2);
    }

}
