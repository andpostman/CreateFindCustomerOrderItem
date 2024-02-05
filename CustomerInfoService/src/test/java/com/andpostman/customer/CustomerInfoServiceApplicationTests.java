package com.andpostman.customer;

import com.andpostman.customer.repositories.CustomerRepository;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;


import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.http.MediaType;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;


import java.util.Optional;

import static org.assertj.core.internal.bytebuddy.matcher.ElementMatchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * Class Template3ApplicationTests contains a set of tests
 */
@RunWith(SpringRunner.class)
@SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
@SpringBootTest(
        classes = CustomerInfoServiceApplicationTests.class)
@AutoConfigureMockMvc
@TestPropertySource(
        locations = "classpath:application.properties"
)
class CustomerInfoServiceApplicationTests {

    @Autowired
    CustomerRepository repository;

    @Autowired
    private MockMvc mockMvc;

    /**
     * In this test, the basic functionality of the application is checked
     */
    @Test
    void test() {
        Assertions.assertEquals(Optional.empty(), repository.findShortInfoByEmail("s"));
        Assertions.assertTrue(repository.findShortInfoByEmail("andrew@mail.ru").isPresent());
    }

    /**
     * This test checks the HTTP request GET for order
     * @throws Exception occurs when the test fails
     */
    @Test
    void firstControllerRequest() throws Exception{
        mockMvc.perform(get("/customer/andrew@mail.ru")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("firstName").value("Andrew"))
                .andExpect(jsonPath("lastName").value("Ivanenko"));
    }
}
