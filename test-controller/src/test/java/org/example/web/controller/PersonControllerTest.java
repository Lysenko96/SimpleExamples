package org.example.web.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.web.entity.Person;
import org.example.web.service.PersonService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@ExtendWith(MockitoExtension.class)
public class PersonControllerTest {

    @Mock
    private PersonService personService;

    @InjectMocks
    private PersonController personController;

    private MockMvc mockMvc;
    private ObjectMapper objectMapper;

    @BeforeEach
    void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(personController).build();
        objectMapper = new ObjectMapper();
    }

    @Test
    void getSalarySumByAllPersonsTest() throws Exception {
        when(personService.getSalarySumByAllPersons()).thenReturn(3100);
        mockMvc.perform(get("/api/person/salary"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").value(3100));
        verify(personService, times(1)).getSalarySumByAllPersons();
    }

    @Test
    void hireTest() throws Exception {
        Person person = new Person("Jacob", "Green", 1200);
        String personJson = objectMapper.writeValueAsString(person);
        mockMvc.perform(post("/api/person/hire")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(personJson))
                .andExpect(status().isCreated());
        verify(personService, times(1)).hire(person);
    }

    @Test
    void getPersonByIdTest() throws Exception {
        Person person = new Person(1, "Jacob", "Green", 1200);
        when(personService.findById(1)).thenReturn(person);
        mockMvc.perform(get("/api/person/{id}", 1))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1))
                .andExpect(jsonPath("$.firstName").value("Jacob"))
                .andExpect(jsonPath("$.lastName").value("Green"))
                .andExpect(jsonPath("$.salary").value(1200));
        verify(personService, times(1)).findById(1);

    }

    @Test
    void updatePersonTest() throws Exception {
        Person person = new Person(1, "Jacob", "Green", 1200);
        String personJson = objectMapper.writeValueAsString(person);
        mockMvc.perform(put("/api/person/update")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(personJson))
                .andExpect(status().isOk());
        verify(personService, times(1)).update(person);
    }
}
