package com.example.integration.http;

import com.example.spring.SpringRunner;
import com.example.spring.dto.UserCreateEditDto;
import org.hamcrest.collection.IsCollectionWithSize;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.webmvc.test.autoconfigure.AutoConfigureMockMvc;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest(classes = SpringRunner.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
@AutoConfigureMockMvc
@Transactional
public class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void getUsers() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/users"))
                .andExpect(MockMvcResultMatchers.status().is2xxSuccessful())
                .andExpect(MockMvcResultMatchers.view().name("/user/users"))
                .andExpect(MockMvcResultMatchers.model().attributeExists("users"))
                .andExpect(MockMvcResultMatchers.model().attribute("users", IsCollectionWithSize.hasSize(2)));
    }

    @Test
    void createUser() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/users")
                        .contentType(MediaType.APPLICATION_PROBLEM_JSON_VALUE)
                        .content("""
                                {
                                "username": "username125",
                                "firstname": "name123",
                                "lastname": "lastname123",
                                "role": "ADMIN",
                                "birthDate": "2000-01-01T00:00:00"
                                }
                                """)
                )
                .andExpectAll(MockMvcResultMatchers.status().is3xxRedirection(),
                        MockMvcResultMatchers.redirectedUrlPattern("/users/{\\d+}"));
    }

    @Test
    void update() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/users/1/update")
                .param(UserCreateEditDto.Fields.username, "username123")
//                .param("username", "username123")
        ).andExpectAll(MockMvcResultMatchers.status().is3xxRedirection(),
                MockMvcResultMatchers.redirectedUrlPattern("/users/{\\d+}"));
    }

    @Test
    void delete() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/users/1/delete"))
                .andExpectAll(MockMvcResultMatchers.status().is3xxRedirection(),
                        MockMvcResultMatchers.redirectedUrl("/users"));
    }
}
