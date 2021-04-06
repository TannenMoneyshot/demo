package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(HelloController.class)
public class HelloControllerTests {
    @Autowired
    MockMvc mockMvc;

    @Test
    void sayHello_noParam_rtnHelloWorld() throws Exception {
// /hello string "Hello World"
        mockMvc.perform(get("/hello"))
                .andExpect(status().isOk())
                .andExpect(content().string("Hello World"));
    }

    @Test
    void sayHello_myName_rtnHelloMyName() throws Exception {
        mockMvc.perform(get("/hello?name=Christian"))
                .andExpect(status().isOk())
                .andExpect(content().string("Hello Christian"));
    }
}
